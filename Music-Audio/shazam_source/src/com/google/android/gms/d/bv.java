// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            br

public interface bv
    extends IInterface
{
    public static abstract class a extends Binder
        implements bv
    {

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                a(br.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static final class a.a
        implements bv
    {

        private IBinder a;

        public final void a(br br1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            if (br1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            br1 = br1.asBinder();
_L1:
            parcel.writeStrongBinder(br1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            br1 = null;
              goto _L1
            br1;
            parcel1.recycle();
            parcel.recycle();
            throw br1;
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


    public abstract void a(br br);
}
