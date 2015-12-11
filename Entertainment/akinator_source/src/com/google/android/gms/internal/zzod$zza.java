// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzod

public static abstract class zza.zznJ extends Binder
    implements zzod
{
    private static class zza
        implements zzod
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(SessionInsertRequest sessioninsertrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessioninsertrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sessioninsertrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessioninsertrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessioninsertrequest;
        }

        public void zza(SessionReadRequest sessionreadrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionreadrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sessionreadrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionreadrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessionreadrequest;
        }

        public void zza(SessionRegistrationRequest sessionregistrationrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionregistrationrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sessionregistrationrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionregistrationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessionregistrationrequest;
        }

        public void zza(SessionStartRequest sessionstartrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionstartrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sessionstartrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionstartrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessionstartrequest;
        }

        public void zza(SessionStopRequest sessionstoprequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionstoprequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sessionstoprequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionstoprequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessionstoprequest;
        }

        public void zza(SessionUnregistrationRequest sessionunregistrationrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (sessionunregistrationrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            sessionunregistrationrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sessionunregistrationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sessionunregistrationrequest;
        }

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zzod zzbD(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
        if (iinterface != null && (iinterface instanceof zzod))
        {
            return (zzod)iinterface;
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
        Object obj5 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            if (parcel.readInt() != 0)
            {
                obj = (SessionStartRequest)SessionStartRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SessionStartRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = (SessionStopRequest)SessionStopRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SessionStopRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = (SessionInsertRequest)SessionInsertRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SessionInsertRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = (SessionReadRequest)SessionReadRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SessionReadRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            obj = obj4;
            if (parcel.readInt() != 0)
            {
                obj = (SessionRegistrationRequest)SessionRegistrationRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SessionRegistrationRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            obj = obj5;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (SessionUnregistrationRequest)SessionUnregistrationRequest.CREATOR.createFromParcel(parcel);
        }
        zza(((SessionUnregistrationRequest) (obj)));
        parcel1.writeNoException();
        return true;
    }
}
