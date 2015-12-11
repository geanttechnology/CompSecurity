// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

public interface zzob
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzob
    {

        public static zzob zzbB(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            if (iinterface != null && (iinterface instanceof zzob))
            {
                return (zzob)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                if (parcel.readInt() != 0)
                {
                    obj = (SubscribeRequest)SubscribeRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((SubscribeRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (UnsubscribeRequest)UnsubscribeRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((UnsubscribeRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
                obj = obj2;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (ListSubscriptionsRequest)ListSubscriptionsRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((ListSubscriptionsRequest) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzob
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(ListSubscriptionsRequest listsubscriptionsrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            if (listsubscriptionsrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            listsubscriptionsrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            listsubscriptionsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw listsubscriptionsrequest;
        }

        public void zza(SubscribeRequest subscriberequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            if (subscriberequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            subscriberequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            subscriberequest;
            parcel1.recycle();
            parcel.recycle();
            throw subscriberequest;
        }

        public void zza(UnsubscribeRequest unsubscriberequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
            if (unsubscriberequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            unsubscriberequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            unsubscriberequest;
            parcel1.recycle();
            parcel.recycle();
            throw unsubscriberequest;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(ListSubscriptionsRequest listsubscriptionsrequest)
        throws RemoteException;

    public abstract void zza(SubscribeRequest subscriberequest)
        throws RemoteException;

    public abstract void zza(UnsubscribeRequest unsubscriberequest)
        throws RemoteException;
}
