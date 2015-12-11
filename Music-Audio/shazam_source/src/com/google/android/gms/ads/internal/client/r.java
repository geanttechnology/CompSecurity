// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.h;
import com.google.android.gms.d.bs;
import com.google.android.gms.d.bt;
import com.google.android.gms.d.bu;
import com.google.android.gms.d.bv;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            q, p

public interface r
    extends IInterface
{
    public static abstract class a extends Binder
        implements r
    {

        public static r a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (iinterface != null && (iinterface instanceof r))
            {
                return (r)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        {
            Object obj2 = null;
            Object obj1 = null;
            IInterface iinterface1 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                parcel = a();
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel = parcel.asBinder();
                } else
                {
                    parcel = null;
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                a(p.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = ((Parcel) (obj));
                } else
                {
                    obj = parcel.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                    if (obj != null && (obj instanceof bs))
                    {
                        parcel = (bs)obj;
                    } else
                    {
                        parcel = new com.google.android.gms.d.bs.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj2;
                } else
                {
                    obj = parcel.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    if (obj != null && (obj instanceof bt))
                    {
                        parcel = (bt)obj;
                    } else
                    {
                        parcel = new com.google.android.gms.d.bt.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                String s = parcel.readString();
                obj = parcel.readStrongBinder();
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    iinterface1 = ((IBinder) (obj)).queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    if (iinterface1 != null && (iinterface1 instanceof bv))
                    {
                        obj = (bv)iinterface1;
                    } else
                    {
                        obj = new com.google.android.gms.d.bv.a.a(((IBinder) (obj)));
                    }
                }
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj1;
                } else
                {
                    IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    if (iinterface != null && (iinterface instanceof bu))
                    {
                        parcel = (bu)iinterface;
                    } else
                    {
                        parcel = new com.google.android.gms.d.bu.a.a(parcel);
                    }
                }
                a(s, ((bv) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                obj = iinterface1;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = NativeAdOptionsParcel.CREATOR;
                obj = h.a(parcel);
            }
            a(((NativeAdOptionsParcel) (obj)));
            parcel1.writeNoException();
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }
    }

    private static final class a.a
        implements r
    {

        private IBinder a;

        public final q a()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            q q;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            q = com.google.android.gms.ads.internal.client.q.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return q;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final void a(p p1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (p1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            p1 = p1.asBinder();
_L1:
            parcel.writeStrongBinder(p1);
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            p1 = null;
              goto _L1
            p1;
            parcel1.recycle();
            parcel.recycle();
            throw p1;
        }

        public final void a(NativeAdOptionsParcel nativeadoptionsparcel)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (nativeadoptionsparcel == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            nativeadoptionsparcel.writeToParcel(parcel, 0);
_L1:
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            nativeadoptionsparcel;
            parcel1.recycle();
            parcel.recycle();
            throw nativeadoptionsparcel;
        }

        public final void a(bs bs1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (bs1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            bs1 = bs1.asBinder();
_L1:
            parcel.writeStrongBinder(bs1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bs1 = null;
              goto _L1
            bs1;
            parcel1.recycle();
            parcel.recycle();
            throw bs1;
        }

        public final void a(bt bt1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (bt1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            bt1 = bt1.asBinder();
_L1:
            parcel.writeStrongBinder(bt1);
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bt1 = null;
              goto _L1
            bt1;
            parcel1.recycle();
            parcel.recycle();
            throw bt1;
        }

        public final void a(String s, bv bv1, bu bu1)
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            parcel.writeString(s);
            if (bv1 == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            s = bv1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            s = obj;
            if (bu1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            s = bu1.asBinder();
            parcel.writeStrongBinder(s);
            a.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s = null;
              goto _L1
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


    public abstract q a();

    public abstract void a(p p);

    public abstract void a(NativeAdOptionsParcel nativeadoptionsparcel);

    public abstract void a(bs bs);

    public abstract void a(bt bt);

    public abstract void a(String s, bv bv, bu bu);
}
