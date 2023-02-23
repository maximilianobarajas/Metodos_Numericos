import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sympy import *
from sympy import sin, cos, symbols, lambdify, exp
class metodos_numericos:
  def __init__(self,fun,funsymb) -> None:
      a = symbols('a')
      self.fun=fun
      self.funsymb=funsymb
      self.deriv_symb=funsymb.diff(a)
  def __init__(self,fun) -> None:
      self.fun=fun
  def graficar(self,a: np.float64,b: np.float64,N: int):
    x=np.linspace(a,b,N)
    y=self.fun(x)
    plt.grid()
    plt.plot(x,y)
  def biseccion(self,a: np.float64,b:np.float64,tol:np.float64)->pd.DataFrame:
    A: list=[];B: list=[];C: list=[];fC:list=[];bk_ax:list=[];
    while(b-a>=tol):
      A.append(a);B.append(b)
      c=np.float64((b+a)/2.0)
      C.append(c)
      fC.append(self.fun(c))
      bk_ax.append(abs(b-a))
      if(self.fun(c)==0.0):
        break
      if(self.fun(c)*self.fun(a)<np.float64(0.0)):
        b=c
      else:
        a=c
    return pd.DataFrame(dict(ak = A, bk = B, ck= C, fCk=fC,Bk_Ak=bk_ax))
  def secante(self,x0:np.float64,x1:np.float64,tol:np.float64)->pd.DataFrame:
     X0: list=[];X1: list=[];X2: list=[];X1_X0: list=[];
     while(abs(x0-x1)>=tol):
       X1.append(x1);X0.append(x0);X1_X0.append(abs(x0-x1))
       x2 = x1 - self.fun(x1) * (x1 - x0) / float(self.fun(x1) - self.fun(x0))
       x0, x1 = x1, x2
       X2.append(x2)
     return pd.DataFrame(dict(Xn_1=X0, Xn=X1, Xnplus1=X2, Xn_Xn_1=X1_X0))
  def regula_falsi(self,a: np.float64, b: np.float64 , tol: np.float64):
    A: list=[];B: list=[];C: list=[];fC:list=[];bk_ax:list=[];
    tramo=abs(b-a)
    fa=self.fun(a)
    fb=self.fun(b)
    while not(tramo<=tol):
      A.append(a);B.append(b)
      c=b-fb*(a-b)/(fa-fb)
      fc=self.fun(c)
      C.append(c)
      fC.append(fc)
      bk_ax.append(tramo)
      cambi=np.sign(fa)*np.sign(fc)
      if(cambi>0):
        tramo=abs(c-a)
        a=c
        fa=fc
      else:
        tramo=abs(b-c)
        b=c
        fb=fc
    return pd.DataFrame(dict(ak = A, bk = B, ck= C, fCk=fC,Bk_Ak=bk_ax))
  def newton_rhapson(self,x0: np.float64,tol: np.float64):
    a = symbols('a')
    deriv=lambdify(a,self.funsymb.diff(a),'numpy')
    X1: list=[]; X0: list=[]; X0_X1: list=[]; fx0: list=[]
    while(True):
      if(abs(deriv(x0))<=tol):
        break
      x1=x0 - self.fun(x0)/deriv(x0)
      X0.append(x0);X1.append(x1);X0_X1.append(abs(x0-x1));fx0.append(self.fun(x0))
      if(abs(x0-x1)<=tol):
        break
      x0 = x1 
    return pd.DataFrame(dict(X_0=X0,X_1=X1,X0__X1=X0_X1, FX0=fx0))
