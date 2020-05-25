package com.river.oaidlite.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/****************************
 * on 2020/2/17
 ****************************
 */
public interface OnePlusIDInterface extends IInterface{

  public static abstract class up extends Binder implements OppoIDInterface {

    public static class down implements OppoIDInterface {
      public IBinder iBinder;

      public down(IBinder ib) {
        iBinder = ib;
      }

      public String getSerID(String str1, String str2, String str3) {
        String res = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
          obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
          obtain.writeString(str1);
          obtain.writeString(str2);
          obtain.writeString(str3);
          iBinder.transact(1, obtain, obtain2, 0);
          obtain2.readException();
          res = obtain2.readString();
        }
        catch (Exception e) {
          e.printStackTrace();
        }
        finally {
          obtain.recycle();
          obtain2.recycle();
        }
        return res;
      }

      @Override
      public IBinder asBinder() {
        return iBinder;
      }
    }

    public static OnePlusIDInterface genInterface(IBinder iBinder) {
      if (iBinder == null) {
        return null;
      }
      IInterface iInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
      if (iInterface == null || !(iInterface instanceof OnePlusIDInterface)) {
        return (OnePlusIDInterface) new down(iBinder);
      } else {
        return (OnePlusIDInterface) iInterface;
      }
    }
  }
}
