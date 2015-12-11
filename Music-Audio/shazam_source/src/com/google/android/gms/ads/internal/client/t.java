// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.b.c;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.em;
import com.google.android.gms.d.eq;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdSizeParcel, o, p, v, 
//            w, AdRequestParcel, i, k

public interface t
    extends IInterface
{
    public static abstract class a extends Binder
        implements t
    {

        public static t a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (iinterface != null && (iinterface instanceof t))
            {
                return (t)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int l, Parcel parcel, Parcel parcel1, int i1)
        {
            boolean flag2 = false;
            boolean flag1 = false;
            boolean flag = false;
            Object obj9 = null;
            c c1 = null;
            Object obj10 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj = null;
            switch (l)
            {
            default:
                return super.onTransact(l, parcel, parcel1, i1);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                c1 = a();
                parcel1.writeNoException();
                parcel = obj;
                if (c1 != null)
                {
                    parcel = c1.asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                b();
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                flag2 = c();
                parcel1.writeNoException();
                if (flag2)
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                parcel1.writeInt(l);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                Object obj1 = obj9;
                if (parcel.readInt() != 0)
                {
                    obj1 = AdRequestParcel.CREATOR;
                    obj1 = com.google.android.gms.ads.internal.client.i.a(parcel);
                }
                flag2 = a(((AdRequestParcel) (obj1)));
                parcel1.writeNoException();
                l = ((flag) ? 1 : 0);
                if (flag2)
                {
                    l = 1;
                }
                parcel1.writeInt(l);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                d();
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                e();
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                a(p.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = c1;
                } else
                {
                    IInterface iinterface = parcel.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (iinterface != null && (iinterface instanceof v))
                    {
                        parcel = (v)iinterface;
                    } else
                    {
                        parcel = new v.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                f();
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                g();
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                h();
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = i();
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                Object obj2 = obj10;
                if (parcel.readInt() != 0)
                {
                    obj2 = AdSizeParcel.CREATOR;
                    obj2 = com.google.android.gms.ads.internal.client.k.a(parcel);
                }
                a(((AdSizeParcel) (obj2)));
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj4;
                } else
                {
                    IInterface iinterface1 = parcel.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    if (iinterface1 != null && (iinterface1 instanceof em))
                    {
                        parcel = (em)iinterface1;
                    } else
                    {
                        parcel = new com.google.android.gms.d.em.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                Object obj3 = parcel.readStrongBinder();
                if (obj3 == null)
                {
                    obj3 = obj5;
                } else
                {
                    IInterface iinterface5 = ((IBinder) (obj3)).queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    if (iinterface5 != null && (iinterface5 instanceof eq))
                    {
                        obj3 = (eq)iinterface5;
                    } else
                    {
                        obj3 = new com.google.android.gms.d.eq.a.a(((IBinder) (obj3)));
                    }
                }
                a(((eq) (obj3)), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = j();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj6;
                } else
                {
                    IInterface iinterface2 = parcel.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                    if (iinterface2 != null && (iinterface2 instanceof bi))
                    {
                        parcel = (bi)iinterface2;
                    } else
                    {
                        parcel = new com.google.android.gms.d.bi.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj7;
                } else
                {
                    IInterface iinterface3 = parcel.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (iinterface3 != null && (iinterface3 instanceof o))
                    {
                        parcel = (o)iinterface3;
                    } else
                    {
                        parcel = new o.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                parcel = parcel.readStrongBinder();
                if (parcel == null)
                {
                    parcel = obj8;
                } else
                {
                    IInterface iinterface4 = parcel.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (iinterface4 != null && (iinterface4 instanceof w))
                    {
                        parcel = (w)iinterface4;
                    } else
                    {
                        parcel = new w.a.a(parcel);
                    }
                }
                a(parcel);
                parcel1.writeNoException();
                return true;

            case 22: // '\026'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (parcel.readInt() != 0)
                {
                    flag2 = true;
                }
                a(flag2);
                parcel1.writeNoException();
                return true;

            case 23: // '\027'
                parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                flag2 = k();
                parcel1.writeNoException();
                l = ((flag1) ? 1 : 0);
                break;
            }
            if (flag2)
            {
                l = 1;
            }
            parcel1.writeInt(l);
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }
    }

    private static final class a.a
        implements t
    {

        private IBinder a;

        public final c a()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            c c1;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            c1 = com.google.android.gms.b.c.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return c1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final void a(AdSizeParcel adsizeparcel)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (adsizeparcel == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            adsizeparcel.writeToParcel(parcel, 0);
_L1:
            a.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            adsizeparcel;
            parcel1.recycle();
            parcel.recycle();
            throw adsizeparcel;
        }

        public final void a(o o1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (o1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            o1 = o1.asBinder();
_L1:
            parcel.writeStrongBinder(o1);
            a.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            o1 = null;
              goto _L1
            o1;
            parcel1.recycle();
            parcel.recycle();
            throw o1;
        }

        public final void a(p p1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (p1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            p1 = p1.asBinder();
_L1:
            parcel.writeStrongBinder(p1);
            a.transact(7, parcel, parcel1, 0);
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

        public final void a(v v1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (v1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            v1 = v1.asBinder();
_L1:
            parcel.writeStrongBinder(v1);
            a.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            v1 = null;
              goto _L1
            v1;
            parcel1.recycle();
            parcel.recycle();
            throw v1;
        }

        public final void a(w w1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (w1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            w1 = w1.asBinder();
_L1:
            parcel.writeStrongBinder(w1);
            a.transact(21, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            w1 = null;
              goto _L1
            w1;
            parcel1.recycle();
            parcel.recycle();
            throw w1;
        }

        public final void a(bi bi1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (bi1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            bi1 = bi1.asBinder();
_L1:
            parcel.writeStrongBinder(bi1);
            a.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            bi1 = null;
              goto _L1
            bi1;
            parcel1.recycle();
            parcel.recycle();
            throw bi1;
        }

        public final void a(em em1)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (em1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            em1 = em1.asBinder();
_L1:
            parcel.writeStrongBinder(em1);
            a.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            em1 = null;
              goto _L1
            em1;
            parcel1.recycle();
            parcel.recycle();
            throw em1;
        }

        public final void a(eq eq1, String s)
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (eq1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            eq1 = eq1.asBinder();
_L1:
            parcel.writeStrongBinder(eq1);
            parcel.writeString(s);
            a.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            eq1 = null;
              goto _L1
            eq1;
            parcel1.recycle();
            parcel.recycle();
            throw eq1;
        }

        public final void a(boolean flag)
        {
            Parcel parcel;
            Parcel parcel1;
            int l;
            l = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (flag)
            {
                l = 1;
            }
            parcel.writeInt(l);
            a.transact(22, parcel, parcel1, 0);
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

        public final boolean a(AdRequestParcel adrequestparcel)
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            if (adrequestparcel == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L1:
            int l;
            a.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readInt();
            if (l == 0)
            {
                flag = false;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            parcel.writeInt(0);
              goto _L1
            adrequestparcel;
            parcel1.recycle();
            parcel.recycle();
            throw adrequestparcel;
        }

        public final IBinder asBinder()
        {
            return a;
        }

        public final void b()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(2, parcel, parcel1, 0);
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

        public final boolean c()
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int l;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readInt();
            if (l != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final void d()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(5, parcel, parcel1, 0);
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

        public final void e()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(6, parcel, parcel1, 0);
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

        public final void f()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(9, parcel, parcel1, 0);
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

        public final void g()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(10, parcel, parcel1, 0);
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

        public final void h()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(11, parcel, parcel1, 0);
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

        public final AdSizeParcel i()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Object obj;
            obj = AdSizeParcel.CREATOR;
            obj = com.google.android.gms.ads.internal.client.k.a(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return ((AdSizeParcel) (obj));
_L2:
            obj = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final String j()
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public final boolean k()
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int l;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            a.transact(23, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readInt();
            if (l != 0)
            {
                flag = true;
            }
            parcel1.recycle();
            parcel.recycle();
            return flag;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        a.a(IBinder ibinder)
        {
            a = ibinder;
        }
    }


    public abstract c a();

    public abstract void a(AdSizeParcel adsizeparcel);

    public abstract void a(o o);

    public abstract void a(p p);

    public abstract void a(v v);

    public abstract void a(w w);

    public abstract void a(bi bi);

    public abstract void a(em em);

    public abstract void a(eq eq, String s);

    public abstract void a(boolean flag);

    public abstract boolean a(AdRequestParcel adrequestparcel);

    public abstract void b();

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract AdSizeParcel i();

    public abstract String j();

    public abstract boolean k();
}
