// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.youtube.player.internal:
//            l, k, j

public abstract class a extends Binder
    implements l
{

    public static l a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
        class a
            implements l
        {

            private IBinder a;

            public final IBinder a()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                a.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                ibinder1 = parcel1.readStrongBinder();
                parcel1.recycle();
                parcel.recycle();
                return ibinder1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final k a(j j1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                if (j1 == null)
                {
                    break MISSING_BLOCK_LABEL_66;
                }
                j1 = j1.asBinder();
_L1:
                parcel.writeStrongBinder(j1);
                a.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                j1 = k.a.a(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return j1;
                j1 = null;
                  goto _L1
                j1;
                parcel1.recycle();
                parcel.recycle();
                throw j1;
            }

            public final void a(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                if (flag)
                {
                    i = 1;
                }
                parcel.writeInt(i);
                a.transact(3, parcel, parcel1, 0);
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

            public final IBinder asBinder()
            {
                return a;
            }

            a(IBinder ibinder)
            {
                a = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof l))
        {
            return (l)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int i1)
    {
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, i1);

        case 1598968902: 
            parcel1.writeString("com.google.android.youtube.player.internal.IYouTubeService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
            parcel = a();
            parcel1.writeNoException();
            parcel1.writeStrongBinder(parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
            parcel = parcel.readStrongBinder();
            k k1;
            if (parcel == null)
            {
                parcel = null;
            } else
            {
                android.os.IInterface iinterface = parcel.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                if (iinterface != null && (iinterface instanceof j))
                {
                    parcel = (j)iinterface;
                } else
                {
                    parcel = new a(parcel);
                }
            }
            k1 = a(parcel);
            parcel1.writeNoException();
            parcel = obj;
            if (k1 != null)
            {
                parcel = k1.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
            break;
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        parcel1.writeNoException();
        return true;
    }
}
