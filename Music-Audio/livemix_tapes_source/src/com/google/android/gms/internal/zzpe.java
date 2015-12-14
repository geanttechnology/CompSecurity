// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.connection.AppMetadata;

public interface zzpe
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzpe
    {

        public static zzpe zzdf(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            if (iinterface != null && (iinterface instanceof zzpe))
            {
                return (zzpe)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                return true;

            case 1001: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                onConnectionRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel1.writeNoException();
                return true;

            case 1002: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                onEndpointFound(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 1003: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                onEndpointLost(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 1004: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                String s = parcel.readString();
                String s2 = parcel.readString();
                String s3 = parcel.readString();
                String s4 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    parcel = (AppMetadata)AppMetadata.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(s, s2, s3, s4, parcel);
                parcel1.writeNoException();
                return true;

            case 1005: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzeb(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 1006: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zza(parcel.readString(), parcel.readInt(), parcel.createByteArray());
                parcel1.writeNoException();
                return true;

            case 1007: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                String s1 = parcel.readString();
                byte abyte0[] = parcel.createByteArray();
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                onMessageReceived(s1, abyte0, flag);
                parcel1.writeNoException();
                return true;

            case 1008: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                onDisconnected(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 1009: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzk(parcel.readInt(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 1010: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzif(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 1011: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzig(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 1012: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzih(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 1013: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzii(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 1014: 
                parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
                zzij(parcel.readInt());
                parcel1.writeNoException();
                return true;
            }
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
        }
    }

    private static class zza.zza
        implements zzpe
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void onConnectionRequest(String s, String s1, String s2, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeByteArray(abyte0);
            zznI.transact(1001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void onDisconnected(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            zznI.transact(1008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void onEndpointFound(String s, String s1, String s2, String s3)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            zznI.transact(1002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void onEndpointLost(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            zznI.transact(1003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void onMessageReceived(String s, byte abyte0[], boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(1007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zza(String s, int i, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeByteArray(abyte0);
            zznI.transact(1006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zza(String s, String s1, String s2, String s3, AppMetadata appmetadata)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeString(s3);
            if (appmetadata == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            parcel.writeInt(1);
            appmetadata.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzeb(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeString(s);
            zznI.transact(1005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzif(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            zznI.transact(1010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzig(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            zznI.transact(1011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzih(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            zznI.transact(1012, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzii(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            zznI.transact(1013, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzij(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            zznI.transact(1014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzk(int i, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionCallbacks");
            parcel.writeInt(i);
            parcel.writeString(s);
            zznI.transact(1009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void onConnectionRequest(String s, String s1, String s2, byte abyte0[])
        throws RemoteException;

    public abstract void onDisconnected(String s)
        throws RemoteException;

    public abstract void onEndpointFound(String s, String s1, String s2, String s3)
        throws RemoteException;

    public abstract void onEndpointLost(String s)
        throws RemoteException;

    public abstract void onMessageReceived(String s, byte abyte0[], boolean flag)
        throws RemoteException;

    public abstract void zza(String s, int i, byte abyte0[])
        throws RemoteException;

    public abstract void zza(String s, String s1, String s2, String s3, AppMetadata appmetadata)
        throws RemoteException;

    public abstract void zzeb(String s)
        throws RemoteException;

    public abstract void zzif(int i)
        throws RemoteException;

    public abstract void zzig(int i)
        throws RemoteException;

    public abstract void zzih(int i)
        throws RemoteException;

    public abstract void zzii(int i)
        throws RemoteException;

    public abstract void zzij(int i)
        throws RemoteException;

    public abstract void zzk(int i, String s)
        throws RemoteException;
}
