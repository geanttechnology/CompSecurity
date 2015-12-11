// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            bp

public interface bt
    extends IInterface
{
    public static abstract class a extends Binder
        implements bt
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
                parcel1.writeString("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                parcel = parcel.readStrongBinder();
                break;
            }
            if (parcel == null)
            {
                parcel = null;
            } else
            {
                IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                if (iinterface != null && (iinterface instanceof bp))
                {
                    parcel = (bp)iinterface;
                } else
                {
                    parcel = new bp.a.a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        }
    }

    private static final class a.a
        implements bt
    {

        private IBinder a;

        public final void a(bp bp1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            if (bp1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            bp1 = bp1.asBinder();
_L1:
            parcel.writeStrongBinder(bp1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bp1 = null;
              goto _L1
            bp1;
            parcel1.recycle();
            parcel.recycle();
            throw bp1;
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


    public abstract void a(bp bp);
}
