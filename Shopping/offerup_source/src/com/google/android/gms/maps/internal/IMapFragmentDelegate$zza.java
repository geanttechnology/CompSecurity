// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.zza;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IMapFragmentDelegate, IGoogleMapDelegate

public abstract class zza extends Binder
    implements IMapFragmentDelegate
{

    public static IMapFragmentDelegate zzcp(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
        class zza
            implements IMapFragmentDelegate
        {

            private IBinder zznJ;

            public IBinder asBinder()
            {
                return zznJ;
            }

            public IGoogleMapDelegate getMap()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IGoogleMapDelegate igooglemapdelegate;
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                igooglemapdelegate = IGoogleMapDelegate.zza.zzcm(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return igooglemapdelegate;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getMapAsync(zzl zzl1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (zzl1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                zzl1 = zzl1.asBinder();
_L1:
                parcel.writeStrongBinder(zzl1);
                zznJ.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                zzl1 = null;
                  goto _L1
                zzl1;
                parcel1.recycle();
                parcel.recycle();
                throw zzl1;
            }

            public boolean isReady()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if (i != 0)
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

            public void onCreate(Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                bundle;
                parcel1.recycle();
                parcel.recycle();
                throw bundle;
            }

            public zzd onCreateView(zzd zzd1, zzd zzd2, Bundle bundle)
            {
                Object obj;
                Parcel parcel;
                Parcel parcel1;
                obj = null;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                zzd1 = obj;
                if (zzd2 == null)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                zzd1 = zzd2.asBinder();
                parcel.writeStrongBinder(zzd1);
                if (bundle == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L6:
                zznJ.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                zzd1 = com.google.android.gms.dynamic.zzd.zza.zzbk(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return zzd1;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                  goto _L5
            }

            public void onDestroy()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(8, parcel, parcel1, 0);
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

            public void onDestroyView()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(7, parcel, parcel1, 0);
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

            public void onEnterAmbient(Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                bundle;
                parcel1.recycle();
                parcel.recycle();
                throw bundle;
            }

            public void onExitAmbient()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(14, parcel, parcel1, 0);
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

            public void onInflate(zzd zzd1, GoogleMapOptions googlemapoptions, Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (zzd1 == null) goto _L2; else goto _L1
_L1:
                zzd1 = zzd1.asBinder();
_L5:
                parcel.writeStrongBinder(zzd1);
                if (googlemapoptions == null) goto _L4; else goto _L3
_L3:
                parcel.writeInt(1);
                googlemapoptions.writeToParcel(parcel, 0);
_L6:
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_127;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L7:
                zznJ.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                zzd1 = null;
                  goto _L5
_L4:
                parcel.writeInt(0);
                  goto _L6
                zzd1;
                parcel1.recycle();
                parcel.recycle();
                throw zzd1;
                parcel.writeInt(0);
                  goto _L7
            }

            public void onLowMemory()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(9, parcel, parcel1, 0);
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

            public void onPause()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(6, parcel, parcel1, 0);
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

            public void onResume()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                zznJ.transact(5, parcel, parcel1, 0);
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

            public void onSaveInstanceState(Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_69;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                zznJ.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() != 0)
                {
                    bundle.readFromParcel(parcel1);
                }
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                bundle;
                parcel1.recycle();
                parcel.recycle();
                throw bundle;
            }

            zza(IBinder ibinder)
            {
                zznJ = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof IMapFragmentDelegate))
        {
            return (IMapFragmentDelegate)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        GoogleMapOptions googlemapoptions = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            parcel = getMap();
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
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            zzd zzd1 = com.google.android.gms.dynamic.asBinder(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                googlemapoptions = GoogleMapOptions.CREATOR.zzff(parcel);
            } else
            {
                googlemapoptions = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.FromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onInflate(zzd1, googlemapoptions, parcel);
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.FromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onCreate(parcel);
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            zzd zzd2 = com.google.android.gms.dynamic.e.zza.onCreate(parcel.readStrongBinder());
            zzd zzd3 = com.google.android.gms.dynamic.e.zza.onCreate(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.FromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zzd2 = onCreateView(zzd2, zzd3, parcel);
            parcel1.writeNoException();
            parcel = googlemapoptions;
            if (zzd2 != null)
            {
                parcel = zzd2.asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onResume();
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onPause();
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onDestroyView();
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onDestroy();
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onLowMemory();
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.FromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onSaveInstanceState(parcel);
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

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            boolean flag = isReady();
            parcel1.writeNoException();
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            getMapAsync(getMapAsync(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.FromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onEnterAmbient(parcel);
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            onExitAmbient();
            parcel1.writeNoException();
            return true;
        }
    }
}
