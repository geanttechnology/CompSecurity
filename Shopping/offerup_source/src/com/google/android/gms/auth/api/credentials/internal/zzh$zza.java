// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

// Referenced classes of package com.google.android.gms.auth.api.credentials.internal:
//            zzh, SaveRequest, DeleteRequest

public abstract class quest extends Binder
    implements zzh
{

    public static zzh zzat(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        class zza
            implements zzh
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(zzg zzg1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                if (zzg1 == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                zzg1 = zzg1.asBinder();
_L1:
                parcel.writeStrongBinder(zzg1);
                zznJ.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzg1 = null;
                  goto _L1
                zzg1;
                parcel1.recycle();
                parcel.recycle();
                throw zzg1;
            }

            public void zza(zzg zzg1, CredentialRequest credentialrequest)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                if (zzg1 == null) goto _L2; else goto _L1
_L1:
                zzg1 = zzg1.asBinder();
_L5:
                parcel.writeStrongBinder(zzg1);
                if (credentialrequest == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                credentialrequest.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzg1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzg1;
                parcel1.recycle();
                parcel.recycle();
                throw zzg1;
                  goto _L5
            }

            public void zza(zzg zzg1, DeleteRequest deleterequest)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                if (zzg1 == null) goto _L2; else goto _L1
_L1:
                zzg1 = zzg1.asBinder();
_L5:
                parcel.writeStrongBinder(zzg1);
                if (deleterequest == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                deleterequest.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzg1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzg1;
                parcel1.recycle();
                parcel.recycle();
                throw zzg1;
                  goto _L5
            }

            public void zza(zzg zzg1, SaveRequest saverequest)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                if (zzg1 == null) goto _L2; else goto _L1
_L1:
                zzg1 = zzg1.asBinder();
_L5:
                parcel.writeStrongBinder(zzg1);
                if (saverequest == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                saverequest.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzg1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzg1;
                parcel1.recycle();
                parcel.recycle();
                throw zzg1;
                  goto _L5
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zzh))
        {
            return (zzh)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        zzg zzg = null;
        zzg zzg2 = null;
        CredentialRequest credentialrequest = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzg = zzas(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                credentialrequest = (CredentialRequest)CredentialRequest.CREATOR.createFromParcel(parcel);
            }
            zza(zzg, credentialrequest);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzg2 = zzas(parcel.readStrongBinder());
            Object obj = zzg;
            if (parcel.readInt() != 0)
            {
                obj = (SaveRequest)SaveRequest.CREATOR.createFromParcel(parcel);
            }
            zza(zzg2, ((SaveRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zzg zzg1 = zzas(parcel.readStrongBinder());
            Object obj1 = zzg2;
            if (parcel.readInt() != 0)
            {
                obj1 = (DeleteRequest)DeleteRequest.CREATOR.createFromParcel(parcel);
            }
            zza(zzg1, ((DeleteRequest) (obj1)));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            zza(zzas(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
