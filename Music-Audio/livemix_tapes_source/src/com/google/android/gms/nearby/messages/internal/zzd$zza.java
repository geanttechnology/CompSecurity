// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzd, PublishRequest, UnpublishRequest, SubscribeRequest, 
//            UnsubscribeRequest, GetPermissionStatusRequest

public static abstract class zza.zznI extends Binder
    implements zzd
{
    private static class zza
        implements zzd
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(GetPermissionStatusRequest getpermissionstatusrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (getpermissionstatusrequest == null)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            parcel.writeInt(1);
            getpermissionstatusrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(7, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            getpermissionstatusrequest;
            parcel.recycle();
            throw getpermissionstatusrequest;
        }

        public void zza(PublishRequest publishrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (publishrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            publishrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            publishrequest;
            parcel.recycle();
            throw publishrequest;
        }

        public void zza(SubscribeRequest subscriberequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (subscriberequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            subscriberequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            subscriberequest;
            parcel.recycle();
            throw subscriberequest;
        }

        public void zza(UnpublishRequest unpublishrequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (unpublishrequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            unpublishrequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(2, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            unpublishrequest;
            parcel.recycle();
            throw unpublishrequest;
        }

        public void zza(UnsubscribeRequest unsubscriberequest)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            if (unsubscriberequest == null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            parcel.writeInt(1);
            unsubscriberequest.writeToParcel(parcel, 0);
_L1:
            zznI.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            unsubscriberequest;
            parcel.recycle();
            throw unsubscriberequest;
        }

        public void zzee(String s)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel.writeString(s);
            zznI.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            s;
            parcel.recycle();
            throw s;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzd zzdj(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        if (iinterface != null && (iinterface instanceof zzd))
        {
            return (zzd)iinterface;
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
        Object obj3 = null;
        Object obj4 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj;
            if (parcel.readInt() != 0)
            {
                parcel1 = (PublishRequest)PublishRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj1;
            if (parcel.readInt() != 0)
            {
                parcel1 = (UnpublishRequest)UnpublishRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj2;
            if (parcel.readInt() != 0)
            {
                parcel1 = (SubscribeRequest)SubscribeRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj3;
            if (parcel.readInt() != 0)
            {
                parcel1 = (UnsubscribeRequest)UnsubscribeRequest.CREATOR.createFromParcel(parcel);
            }
            zza(parcel1);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            zzee(parcel.readString());
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            parcel1 = obj4;
            break;
        }
        if (parcel.readInt() != 0)
        {
            parcel1 = (GetPermissionStatusRequest)GetPermissionStatusRequest.CREATOR.createFromParcel(parcel);
        }
        zza(parcel1);
        return true;
    }
}
