// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.f;

// Referenced classes of package com.google.android.gms.d:
//            ht

public interface hs
    extends IInterface
{
    public static abstract class a extends Binder
        implements hs
    {

        public static hs a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (iinterface != null && (iinterface instanceof hs))
            {
                return (hs)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                a(com.google.android.gms.d.ht.a.a(parcel.readStrongBinder()), parcel.readString(), (UsageInfo[])parcel.createTypedArray(UsageInfo.CREATOR));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                a(com.google.android.gms.d.ht.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                b(com.google.android.gms.d.ht.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                ht ht = com.google.android.gms.d.ht.a.a(parcel.readStrongBinder());
                boolean flag;
                if (parcel.readInt() != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a(ht, flag);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                Object obj;
                if (parcel.readInt() != 0)
                {
                    obj = com.google.android.gms.appdatasearch.GetRecentContextCall.Request.CREATOR;
                    obj = f.a(parcel);
                } else
                {
                    obj = null;
                }
                a(((com.google.android.gms.appdatasearch.GetRecentContextCall.Request) (obj)), com.google.android.gms.d.ht.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                a(com.google.android.gms.d.ht.a.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;
            }
        }
    }

    private static final class a.a
        implements hs
    {

        private IBinder a;

        public final void a(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, ht ht1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (request == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            request.writeToParcel(parcel, 0);
_L3:
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            request = ht1.asBinder();
_L4:
            parcel.writeStrongBinder(request);
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            request;
            parcel1.recycle();
            parcel.recycle();
            throw request;
            request = null;
              goto _L4
        }

        public final void a(ht ht1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            ht1 = ht1.asBinder();
_L1:
            parcel.writeStrongBinder(ht1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ht1 = null;
              goto _L1
            ht1;
            parcel1.recycle();
            parcel.recycle();
            throw ht1;
        }

        public final void a(ht ht1, String s, String s1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ht1 = ht1.asBinder();
_L1:
            parcel.writeStrongBinder(ht1);
            parcel.writeString(s);
            parcel.writeString(s1);
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ht1 = null;
              goto _L1
            ht1;
            parcel1.recycle();
            parcel.recycle();
            throw ht1;
        }

        public final void a(ht ht1, String s, UsageInfo ausageinfo[])
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ht1 = ht1.asBinder();
_L1:
            parcel.writeStrongBinder(ht1);
            parcel.writeString(s);
            parcel.writeTypedArray(ausageinfo, 0);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ht1 = null;
              goto _L1
            ht1;
            parcel1.recycle();
            parcel.recycle();
            throw ht1;
        }

        public final void a(ht ht1, boolean flag)
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_77;
            }
            ht1 = ht1.asBinder();
_L1:
            parcel.writeStrongBinder(ht1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ht1 = null;
              goto _L1
            ht1;
            parcel1.recycle();
            parcel.recycle();
            throw ht1;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        public final void b(ht ht1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            if (ht1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            ht1 = ht1.asBinder();
_L1:
            parcel.writeStrongBinder(ht1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ht1 = null;
              goto _L1
            ht1;
            parcel1.recycle();
            parcel.recycle();
            throw ht1;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract void a(com.google.android.gms.appdatasearch.GetRecentContextCall.Request request, ht ht);

    public abstract void a(ht ht);

    public abstract void a(ht ht, String s, String s1);

    public abstract void a(ht ht, String s, UsageInfo ausageinfo[]);

    public abstract void a(ht ht, boolean flag);

    public abstract void b(ht ht);
}
