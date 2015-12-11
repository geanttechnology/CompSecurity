// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface l
    extends IInterface
{
    public static abstract class a extends Binder
        implements l
    {

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            boolean flag3 = false;
            boolean flag2 = false;
            String s;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                Bitmap bitmap;
                String s1;
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
                } else
                {
                    bitmap = null;
                }
                s1 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag2 = true;
                }
                a(bitmap, s1, flag, flag2);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                s = parcel.readString();
                break;
            }
            boolean flag1;
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag3;
            if (parcel.readInt() != 0)
            {
                flag2 = true;
            }
            a(s, flag1, flag2);
            parcel1.writeNoException();
            return true;
        }
    }

    private static final class a.a
        implements l
    {

        private IBinder a;

        public final void a(Bitmap bitmap, String s, boolean flag, boolean flag1)
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
            if (bitmap == null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
_L1:
            parcel.writeString(s);
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (flag1)
            {
                i = ((flag2) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            bitmap;
            parcel1.recycle();
            parcel.recycle();
            throw bitmap;
        }

        public final void a(String s, boolean flag, boolean flag1)
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
            parcel.writeString(s);
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (flag1)
            {
                i = ((flag2) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
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


    public abstract void a(Bitmap bitmap, String s, boolean flag, boolean flag1);

    public abstract void a(String s, boolean flag, boolean flag1);
}
