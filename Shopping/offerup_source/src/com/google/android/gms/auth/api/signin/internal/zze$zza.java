// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;

// Referenced classes of package com.google.android.gms.auth.api.signin.internal:
//            zze, SignInConfiguration

public abstract class g extends Binder
    implements zze
{

    public static zze zzaz(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        class zza
            implements zze
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public void zza(zzd zzd1, GoogleSignInConfig googlesigninconfig)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (googlesigninconfig == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                googlesigninconfig.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(101, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            public void zza(zzd zzd1, SignInConfiguration signinconfiguration)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (signinconfiguration == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                signinconfiguration.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            public void zzb(zzd zzd1, GoogleSignInConfig googlesigninconfig)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (googlesigninconfig == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                googlesigninconfig.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(102, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            public void zzb(zzd zzd1, SignInConfiguration signinconfiguration)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (signinconfiguration == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                signinconfiguration.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            public void zzc(zzd zzd1, GoogleSignInConfig googlesigninconfig)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (googlesigninconfig == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                googlesigninconfig.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(103, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof zze))
        {
            return (zze)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        zzd zzd = null;
        zzd zzd1 = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzd = zzay(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(parcel);
            }
            zza(zzd, ((SignInConfiguration) (obj)));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzd1 = zzay(parcel.readStrongBinder());
            obj = zzd;
            if (parcel.readInt() != 0)
            {
                obj = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(parcel);
            }
            zzb(zzd1, ((SignInConfiguration) (obj)));
            parcel1.writeNoException();
            return true;

        case 101: // 'e'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzd = zzay(parcel.readStrongBinder());
            obj = zzd1;
            if (parcel.readInt() != 0)
            {
                obj = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(parcel);
            }
            zza(zzd, ((GoogleSignInConfig) (obj)));
            parcel1.writeNoException();
            return true;

        case 102: // 'f'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzd = zzay(parcel.readStrongBinder());
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(parcel);
            }
            zzb(zzd, ((GoogleSignInConfig) (obj)));
            parcel1.writeNoException();
            return true;

        case 103: // 'g'
            parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            zzd = zzay(parcel.readStrongBinder());
            obj = obj2;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(parcel);
        }
        zzc(zzd, ((GoogleSignInConfig) (obj)));
        parcel1.writeNoException();
        return true;
    }
}
