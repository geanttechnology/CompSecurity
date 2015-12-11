// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface e
    extends IInterface
{
    public static abstract class a extends Binder
        implements e
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
                parcel1.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                a(parcel.readString(), parcel.readStrongBinder());
                parcel1.writeNoException();
                return true;
            }
        }

        public a()
        {
            attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }
    }

    private static final class a.a
        implements e
    {

        private IBinder a;

        public final void a(String s, IBinder ibinder)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            a.transact(1, parcel, parcel1, 0);
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


    public abstract void a(String s, IBinder ibinder);
}
