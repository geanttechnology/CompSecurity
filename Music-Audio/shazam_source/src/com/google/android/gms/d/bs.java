// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            bn

public interface bs
    extends IInterface
{
    public static abstract class a extends Binder
        implements bs
    {

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                parcel = parcel.readStrongBinder();
                break;
            }
            if (parcel == null)
            {
                parcel = null;
            } else
            {
                IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                if (iinterface != null && (iinterface instanceof bn))
                {
                    parcel = (bn)iinterface;
                } else
                {
                    parcel = new bn.a.a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        }
    }

    private static final class a.a
        implements bs
    {

        private IBinder a;

        public final void a(bn bn1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
            if (bn1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            bn1 = bn1.asBinder();
_L1:
            parcel.writeStrongBinder(bn1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bn1 = null;
              goto _L1
            bn1;
            parcel1.recycle();
            parcel.recycle();
            throw bn1;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        public a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract void a(bn bn);
}
