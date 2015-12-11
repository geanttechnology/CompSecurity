// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.ActivityRecognitionResultCreator;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationAvailabilityCreator;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzb;
import com.google.android.gms.location.zzd;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzh, zzj, LocationRequestInternal, LocationRequestUpdateData, 
//            ParcelableGeofence, zzm, zzn

public interface zzi
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzi
    {

        public static zzi zzcb(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (iinterface != null && (iinterface instanceof zzi))
            {
                return (zzi)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag2 = false;
            boolean flag = false;
            Object obj1 = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj1 = parcel.createTypedArrayList(ParcelableGeofence.CREATOR);
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zza(((List) (obj1)), ((PendingIntent) (obj)), zzh.zza.zzca(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 57: // '9'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj1 = null;
                }
                zza(((GeofencingRequest) (obj)), ((PendingIntent) (obj1)), zzh.zza.zzca(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zza(((PendingIntent) (obj)), zzh.zza.zzca(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zza(parcel.createStringArray(), zzh.zza.zzca(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zza(zzh.zza.zzca(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                long l = parcel.readLong();
                if (parcel.readInt() != 0)
                {
                    flag = true;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(l, flag, parcel);
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel);
                parcel1.writeNoException();
                return true;

            case 64: // '@'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = zzdu(parcel.readString());
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

            case 65: // 'A'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zzb(parcel);
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

            case 66: // 'B'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zzc(parcel);
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

            case 60: // '<'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = GestureRequest.CREATOR.zzeA(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zza(((GestureRequest) (obj)), parcel);
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

            case 61: // '='
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zzd(parcel);
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

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = zzwC();
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

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((LocationRequest) (obj)), com.google.android.gms.location.zzd.zza.zzbX(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((LocationRequest) (obj)), com.google.android.gms.location.zzd.zza.zzbX(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((LocationRequest) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 52: // '4'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj2;
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequestInternal.CREATOR.zzeH(parcel);
                }
                zza(((LocationRequestInternal) (obj)), com.google.android.gms.location.zzd.zza.zzbX(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 53: // '5'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequestInternal.CREATOR.zzeH(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((LocationRequestInternal) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                zza(com.google.android.gms.location.zzd.zza.zzbX(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zze(parcel);
                parcel1.writeNoException();
                return true;

            case 59: // ';'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                obj = obj3;
                if (parcel.readInt() != 0)
                {
                    obj = LocationRequestUpdateData.CREATOR.zzeI(parcel);
                }
                zza(((LocationRequestUpdateData) (obj)));
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                boolean flag1 = flag2;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzah(flag1);
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    parcel = (Location)Location.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zzc(parcel);
                parcel1.writeNoException();
                return true;

            case 21: // '\025'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = zzdv(parcel.readString());
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

            case 26: // '\032'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                if (parcel.readInt() != 0)
                {
                    obj = (Location)Location.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zza(((Location) (obj)), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 34: // '"'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                parcel = zzdw(parcel.readString());
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

            case 63: // '?'
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (LocationSettingsRequest)LocationSettingsRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                obj = null;
            }
            zza(((LocationSettingsRequest) (obj)), zzj.zza.zzcc(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzi
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public Status zza(GestureRequest gesturerequest, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (gesturerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            gesturerequest.writeToParcel(parcel, 0);
_L5:
            if (pendingintent == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L6:
            zznJ.transact(60, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_127;
            }
            gesturerequest = (Status)Status.CREATOR.createFromParcel(parcel1);
_L7:
            parcel1.recycle();
            parcel.recycle();
            return gesturerequest;
_L2:
            parcel.writeInt(0);
              goto _L5
            gesturerequest;
            parcel1.recycle();
            parcel.recycle();
            throw gesturerequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            gesturerequest = null;
              goto _L7
        }

        public void zza(long l, boolean flag, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeLong(l);
            if (!flag)
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void zza(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public void zza(PendingIntent pendingintent, zzh zzh1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            pendingintent = zzh1.asBinder();
_L4:
            parcel.writeStrongBinder(pendingintent);
            parcel.writeString(s);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
            pendingintent = null;
              goto _L4
        }

        public void zza(Location location, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
_L1:
            parcel.writeInt(i);
            zznJ.transact(26, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, zzh zzh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (geofencingrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            geofencingrequest.writeToParcel(parcel, 0);
_L5:
            if (pendingintent == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L6:
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            geofencingrequest = zzh1.asBinder();
_L7:
            parcel.writeStrongBinder(geofencingrequest);
            zznJ.transact(57, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            geofencingrequest;
            parcel1.recycle();
            parcel.recycle();
            throw geofencingrequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            geofencingrequest = null;
              goto _L7
        }

        public void zza(LocationRequest locationrequest, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(LocationRequest locationrequest, zzd zzd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            locationrequest = zzd1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            locationrequest = null;
              goto _L4
        }

        public void zza(LocationRequest locationrequest, zzd zzd1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequest.writeToParcel(parcel, 0);
_L3:
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            locationrequest = zzd1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequest);
            parcel.writeString(s);
            zznJ.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequest;
            locationrequest = null;
              goto _L4
        }

        public void zza(LocationSettingsRequest locationsettingsrequest, zzj zzj1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationsettingsrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationsettingsrequest.writeToParcel(parcel, 0);
_L3:
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            locationsettingsrequest = zzj1.asBinder();
_L4:
            parcel.writeStrongBinder(locationsettingsrequest);
            parcel.writeString(s);
            zznJ.transact(63, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationsettingsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw locationsettingsrequest;
            locationsettingsrequest = null;
              goto _L4
        }

        public void zza(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestinternal == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequestinternal.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(53, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequestinternal;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestinternal;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(LocationRequestInternal locationrequestinternal, zzd zzd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestinternal == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            locationrequestinternal.writeToParcel(parcel, 0);
_L3:
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            locationrequestinternal = zzd1.asBinder();
_L4:
            parcel.writeStrongBinder(locationrequestinternal);
            zznJ.transact(52, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            locationrequestinternal;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestinternal;
            locationrequestinternal = null;
              goto _L4
        }

        public void zza(LocationRequestUpdateData locationrequestupdatedata)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationrequestupdatedata == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            locationrequestupdatedata.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(59, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            locationrequestupdatedata;
            parcel1.recycle();
            parcel.recycle();
            throw locationrequestupdatedata;
        }

        public void zza(zzh zzh1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            zzh1 = zzh1.asBinder();
_L1:
            parcel.writeStrongBinder(zzh1);
            parcel.writeString(s);
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzh1 = null;
              goto _L1
            zzh1;
            parcel1.recycle();
            parcel.recycle();
            throw zzh1;
        }

        public void zza(zzd zzd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzd1 = zzd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzd1);
            zznJ.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzd1 = null;
              goto _L1
            zzd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzd1;
        }

        public void zza(List list, PendingIntent pendingintent, zzh zzh1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeTypedList(list);
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_118;
            }
            list = zzh1.asBinder();
_L4:
            parcel.writeStrongBinder(list);
            parcel.writeString(s);
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            list;
            parcel1.recycle();
            parcel.recycle();
            throw list;
            list = null;
              goto _L4
        }

        public void zza(String as[], zzh zzh1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeStringArray(as);
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            as = zzh1.asBinder();
_L1:
            parcel.writeStrongBinder(as);
            parcel.writeString(s);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as = null;
              goto _L1
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public void zzah(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznJ.transact(12, parcel, parcel1, 0);
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

        public Status zzb(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            zznJ.transact(65, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
_L2:
            parcel.writeInt(0);
              goto _L3
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
            pendingintent = null;
              goto _L4
        }

        public Status zzc(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            zznJ.transact(66, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
_L2:
            parcel.writeInt(0);
              goto _L3
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
            pendingintent = null;
              goto _L4
        }

        public void zzc(Location location)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            location;
            parcel1.recycle();
            parcel.recycle();
            throw location;
        }

        public Status zzd(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L3:
            zznJ.transact(61, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            pendingintent = (Status)Status.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return pendingintent;
_L2:
            parcel.writeInt(0);
              goto _L3
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
            pendingintent = null;
              goto _L4
        }

        public ActivityRecognitionResult zzdu(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            zznJ.transact(64, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = ActivityRecognitionResult.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Location zzdv(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            zznJ.transact(21, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Location)Location.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public LocationAvailability zzdw(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(s);
            zznJ.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = LocationAvailability.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s;
_L2:
            s = null;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zze(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            pendingintent;
            parcel1.recycle();
            parcel.recycle();
            throw pendingintent;
        }

        public Location zzwC()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Location location = (Location)Location.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return location;
_L2:
            location = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract Status zza(GestureRequest gesturerequest, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(long l, boolean flag, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(PendingIntent pendingintent, zzh zzh, String s)
        throws RemoteException;

    public abstract void zza(Location location, int i)
        throws RemoteException;

    public abstract void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, zzh zzh)
        throws RemoteException;

    public abstract void zza(LocationRequest locationrequest, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(LocationRequest locationrequest, zzd zzd1)
        throws RemoteException;

    public abstract void zza(LocationRequest locationrequest, zzd zzd1, String s)
        throws RemoteException;

    public abstract void zza(LocationSettingsRequest locationsettingsrequest, zzj zzj, String s)
        throws RemoteException;

    public abstract void zza(LocationRequestInternal locationrequestinternal, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(LocationRequestInternal locationrequestinternal, zzd zzd1)
        throws RemoteException;

    public abstract void zza(LocationRequestUpdateData locationrequestupdatedata)
        throws RemoteException;

    public abstract void zza(zzh zzh, String s)
        throws RemoteException;

    public abstract void zza(zzd zzd1)
        throws RemoteException;

    public abstract void zza(List list, PendingIntent pendingintent, zzh zzh, String s)
        throws RemoteException;

    public abstract void zza(String as[], zzh zzh, String s)
        throws RemoteException;

    public abstract void zzah(boolean flag)
        throws RemoteException;

    public abstract Status zzb(PendingIntent pendingintent)
        throws RemoteException;

    public abstract Status zzc(PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zzc(Location location)
        throws RemoteException;

    public abstract Status zzd(PendingIntent pendingintent)
        throws RemoteException;

    public abstract ActivityRecognitionResult zzdu(String s)
        throws RemoteException;

    public abstract Location zzdv(String s)
        throws RemoteException;

    public abstract LocationAvailability zzdw(String s)
        throws RemoteException;

    public abstract void zze(PendingIntent pendingintent)
        throws RemoteException;

    public abstract Location zzwC()
        throws RemoteException;
}
