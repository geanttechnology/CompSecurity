// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

// Referenced classes of package com.google.android.a.a.a:
//            e

public interface k
    extends IInterface
{
    public static abstract class a extends Binder
        implements k
    {

        public static k a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
            if (iinterface != null && (iinterface instanceof k))
            {
                return (k)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            Bundle bundle = null;
            Object obj;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.youtube.player.internal.IServiceBroker");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
                obj = parcel.readStrongBinder();
                break;
            }
            String s;
            String s1;
            String s2;
            if (obj == null)
            {
                obj = null;
            } else
            {
                IInterface iinterface = ((IBinder) (obj)).queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                if (iinterface != null && (iinterface instanceof e))
                {
                    obj = (e)iinterface;
                } else
                {
                    obj = new e.a.a(((IBinder) (obj)));
                }
            }
            i = parcel.readInt();
            s = parcel.readString();
            s1 = parcel.readString();
            s2 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(((e) (obj)), i, s, s1, s2, bundle);
            parcel1.writeNoException();
            return true;
        }
    }

    private static final class a.a
        implements k
    {

        private IBinder a;

        public final void a(e e1, int i, String s, String s1, String s2, Bundle bundle)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
            if (e1 == null) goto _L2; else goto _L1
_L1:
            e1 = e1.asBinder();
_L5:
            parcel.writeStrongBinder(e1);
            parcel.writeInt(i);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            e1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            e1;
            parcel1.recycle();
            parcel.recycle();
            throw e1;
              goto _L5
        }

        public final IBinder asBinder()
        {
            return a;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract void a(e e, int i, String s, String s1, String s2, Bundle bundle);
}
