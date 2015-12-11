// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import java.util.List;

// Referenced classes of package android.support.v7:
//            lk, qb, qc, qd

public interface qa
    extends IInterface
{
    public static abstract class a extends Binder
        implements qa
    {

        public static qa a(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (iinterface != null && (iinterface instanceof qa))
            {
                return (qa)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int j, Parcel parcel, Parcel parcel1, int k)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            lk lk3 = null;
            String s = null;
            Object obj = null;
            switch (j)
            {
            default:
                return super.onTransact(j, parcel, parcel1, k);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk3 = lk.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    obj = AdSizeParcel.CREATOR.zzc(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = AdRequestParcel.CREATOR.zzb(parcel);
                } else
                {
                    obj1 = null;
                }
                a(lk3, ((AdSizeParcel) (obj)), ((AdRequestParcel) (obj1)), parcel.readString(), android.support.v7.qb.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                obj1 = a();
                parcel1.writeNoException();
                parcel = ((Parcel) (obj));
                if (obj1 != null)
                {
                    parcel = ((lk) (obj1)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk3 = lk.a.a(parcel.readStrongBinder());
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = AdRequestParcel.CREATOR.zzb(parcel);
                }
                a(lk3, ((AdRequestParcel) (obj)), parcel.readString(), android.support.v7.qb.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                b();
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                c();
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk3 = lk.a.a(parcel.readStrongBinder());
                AdRequestParcel adrequestparcel;
                if (parcel.readInt() != 0)
                {
                    obj = AdSizeParcel.CREATOR.zzc(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    adrequestparcel = AdRequestParcel.CREATOR.zzb(parcel);
                } else
                {
                    adrequestparcel = null;
                }
                a(lk3, ((AdSizeParcel) (obj)), adrequestparcel, parcel.readString(), parcel.readString(), android.support.v7.qb.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk lk1 = lk.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    obj = AdRequestParcel.CREATOR.zzb(parcel);
                } else
                {
                    obj = null;
                }
                a(lk1, ((AdRequestParcel) (obj)), parcel.readString(), parcel.readString(), android.support.v7.qb.a.a(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                d();
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                e();
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk lk2 = lk.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    obj = AdRequestParcel.CREATOR.zzb(parcel);
                } else
                {
                    obj = null;
                }
                a(lk2, ((AdRequestParcel) (obj)), parcel.readString(), com.google.android.gms.ads.internal.reward.mediation.client.zza.zza.zzad(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                obj = obj2;
                if (parcel.readInt() != 0)
                {
                    obj = AdRequestParcel.CREATOR.zzb(parcel);
                }
                a(((AdRequestParcel) (obj)), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                f();
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                boolean flag = g();
                parcel1.writeNoException();
                if (flag)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                parcel1.writeInt(j);
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                lk3 = lk.a.a(parcel.readStrongBinder());
                NativeAdOptionsParcel nativeadoptionsparcel;
                String s1;
                qb qb;
                if (parcel.readInt() != 0)
                {
                    obj = AdRequestParcel.CREATOR.zzb(parcel);
                } else
                {
                    obj = null;
                }
                s = parcel.readString();
                s1 = parcel.readString();
                qb = android.support.v7.qb.a.a(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    nativeadoptionsparcel = NativeAdOptionsParcel.CREATOR.zzf(parcel);
                } else
                {
                    nativeadoptionsparcel = null;
                }
                a(lk3, ((AdRequestParcel) (obj)), s, s1, qb, nativeadoptionsparcel, parcel.createStringArrayList());
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                obj = h();
                parcel1.writeNoException();
                parcel = lk3;
                if (obj != null)
                {
                    parcel = ((qc) (obj)).asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                obj = i();
                parcel1.writeNoException();
                parcel = s;
                break;
            }
            if (obj != null)
            {
                parcel = ((qd) (obj)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }

        public a()
        {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }
    }

    private static class a.a
        implements qa
    {

        private IBinder a;

        public lk a()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            lk lk1;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            lk1 = lk.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return lk1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void a(lk lk1, AdRequestParcel adrequestparcel, String s, qb qb1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adrequestparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s);
            lk1 = obj;
            if (qb1 == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            lk1 = qb1.asBinder();
            parcel.writeStrongBinder(lk1);
            a.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
        }

        public void a(lk lk1, AdRequestParcel adrequestparcel, String s, zza zza1, String s1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adrequestparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s);
            lk1 = obj;
            if (zza1 == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            lk1 = zza1.asBinder();
            parcel.writeStrongBinder(lk1);
            parcel.writeString(s1);
            a.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
        }

        public void a(lk lk1, AdRequestParcel adrequestparcel, String s, String s1, qb qb1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adrequestparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s);
            parcel.writeString(s1);
            lk1 = obj;
            if (qb1 == null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            lk1 = qb1.asBinder();
            parcel.writeStrongBinder(lk1);
            a.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
              goto _L5
        }

        public void a(lk lk1, AdRequestParcel adrequestparcel, String s, String s1, qb qb1, NativeAdOptionsParcel nativeadoptionsparcel, List list)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adrequestparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s);
            parcel.writeString(s1);
            lk1 = obj;
            if (qb1 == null)
            {
                break MISSING_BLOCK_LABEL_83;
            }
            lk1 = qb1.asBinder();
            parcel.writeStrongBinder(lk1);
            if (nativeadoptionsparcel == null)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            parcel.writeInt(1);
            nativeadoptionsparcel.writeToParcel(parcel, 0);
_L7:
            parcel.writeStringList(list);
            a.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
            parcel.writeInt(0);
              goto _L7
        }

        public void a(lk lk1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, qb qb1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adsizeparcel.writeToParcel(parcel, 0);
_L6:
            if (adrequestparcel == null)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L7:
            parcel.writeString(s);
            lk1 = obj;
            if (qb1 == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            lk1 = qb1.asBinder();
            parcel.writeStrongBinder(lk1);
            a.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
            parcel.writeInt(0);
              goto _L7
        }

        public void a(lk lk1, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, qb qb1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (lk1 == null) goto _L2; else goto _L1
_L1:
            lk1 = lk1.asBinder();
_L5:
            parcel.writeStrongBinder(lk1);
            if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            adsizeparcel.writeToParcel(parcel, 0);
_L6:
            if (adrequestparcel == null)
            {
                break MISSING_BLOCK_LABEL_167;
            }
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L7:
            parcel.writeString(s);
            parcel.writeString(s1);
            lk1 = obj;
            if (qb1 == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            lk1 = qb1.asBinder();
            parcel.writeStrongBinder(lk1);
            a.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            lk1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            lk1;
            parcel1.recycle();
            parcel.recycle();
            throw lk1;
            parcel.writeInt(0);
              goto _L7
        }

        public void a(AdRequestParcel adrequestparcel, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (adrequestparcel == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            parcel.writeInt(1);
            adrequestparcel.writeToParcel(parcel, 0);
_L1:
            parcel.writeString(s);
            a.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            adrequestparcel;
            parcel1.recycle();
            parcel.recycle();
            throw adrequestparcel;
        }

        public IBinder asBinder()
        {
            return a;
        }

        public void b()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(4, parcel, parcel1, 0);
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

        public void c()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

        public void d()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(8, parcel, parcel1, 0);
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

        public void e()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

        public void f()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(12, parcel, parcel1, 0);
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

        public boolean g()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int j;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            j = parcel1.readInt();
            if (j != 0)
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

        public qc h()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            qc qc;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            qc = android.support.v7.qc.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return qc;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public qd i()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            qd qd;
            parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            a.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            qd = android.support.v7.qd.a.a(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return qd;
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


    public abstract lk a()
        throws RemoteException;

    public abstract void a(lk lk, AdRequestParcel adrequestparcel, String s, qb qb)
        throws RemoteException;

    public abstract void a(lk lk, AdRequestParcel adrequestparcel, String s, zza zza, String s1)
        throws RemoteException;

    public abstract void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException;

    public abstract void a(lk lk, AdRequestParcel adrequestparcel, String s, String s1, qb qb, NativeAdOptionsParcel nativeadoptionsparcel, List list)
        throws RemoteException;

    public abstract void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, qb qb)
        throws RemoteException;

    public abstract void a(lk lk, AdSizeParcel adsizeparcel, AdRequestParcel adrequestparcel, String s, String s1, qb qb)
        throws RemoteException;

    public abstract void a(AdRequestParcel adrequestparcel, String s)
        throws RemoteException;

    public abstract void b()
        throws RemoteException;

    public abstract void c()
        throws RemoteException;

    public abstract void d()
        throws RemoteException;

    public abstract void e()
        throws RemoteException;

    public abstract void f()
        throws RemoteException;

    public abstract boolean g()
        throws RemoteException;

    public abstract qc h()
        throws RemoteException;

    public abstract qd i()
        throws RemoteException;
}
