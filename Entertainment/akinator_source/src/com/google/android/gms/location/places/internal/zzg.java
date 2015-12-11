// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.zzc;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.zzd;
import com.google.android.gms.maps.model.zze;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, zzi, zzh, zzt

public interface zzg
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzg
    {

        public static zzg zzcf(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (iinterface != null && (iinterface instanceof zzg))
            {
                return (zzg)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj = null;
            String s1 = null;
            Object obj1 = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            PlacesParams placesparams = null;
            int k;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = LatLngBounds.CREATOR.zzfk(parcel);
                } else
                {
                    obj = null;
                }
                i = parcel.readInt();
                s1 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj1 = PlaceFilter.CREATOR.zzeO(parcel);
                } else
                {
                    obj1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    placesparams = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((LatLngBounds) (obj)), i, s1, ((PlaceFilter) (obj1)), placesparams, zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((String) (obj1)), ((PlacesParams) (obj)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                Object obj2;
                if (parcel.readInt() != 0)
                {
                    obj = LatLng.CREATOR.zzfl(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = PlaceFilter.CREATOR.zzeO(parcel);
                } else
                {
                    obj1 = null;
                }
                obj2 = s1;
                if (parcel.readInt() != 0)
                {
                    obj2 = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((LatLng) (obj)), ((PlaceFilter) (obj1)), ((PlacesParams) (obj2)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = PlaceFilter.CREATOR.zzeO(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                }
                zzb(((PlaceFilter) (obj)), ((PlacesParams) (obj1)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.readString();
                obj = obj5;
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zzb(((String) (obj1)), ((PlacesParams) (obj)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.createStringArrayList();
                obj = obj6;
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((List) (obj1)), ((PlacesParams) (obj)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 17: // '\021'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.createStringArrayList();
                obj = obj7;
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zzb(((List) (obj1)), ((PlacesParams) (obj)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                PlacesParams placesparams1;
                java.util.ArrayList arraylist;
                if (parcel.readInt() != 0)
                {
                    obj = UserDataType.CREATOR.zzeT(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = LatLngBounds.CREATOR.zzfk(parcel);
                } else
                {
                    obj1 = null;
                }
                arraylist = parcel.createStringArrayList();
                if (parcel.readInt() != 0)
                {
                    placesparams1 = PlacesParams.CREATOR.zzeY(parcel);
                } else
                {
                    placesparams1 = null;
                }
                zza(((UserDataType) (obj)), ((LatLngBounds) (obj1)), arraylist, placesparams1, zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = (PlaceRequest)PlaceRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                } else
                {
                    obj1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((PlaceRequest) (obj)), ((PlacesParams) (obj1)), parcel);
                parcel1.writeNoException();
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
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
                zza(((PlacesParams) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = NearbyAlertRequest.CREATOR.zzeN(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                } else
                {
                    obj1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((NearbyAlertRequest) (obj)), ((PlacesParams) (obj1)), parcel);
                parcel1.writeNoException();
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
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
                zzb(((PlacesParams) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 13: // '\r'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                String s2 = parcel.readString();
                PlacesParams placesparams2;
                if (parcel.readInt() != 0)
                {
                    obj = LatLngBounds.CREATOR.zzfk(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = AutocompleteFilter.CREATOR.zzeL(parcel);
                } else
                {
                    obj1 = null;
                }
                if (parcel.readInt() != 0)
                {
                    placesparams2 = PlacesParams.CREATOR.zzeY(parcel);
                } else
                {
                    placesparams2 = null;
                }
                zza(s2, ((LatLngBounds) (obj)), ((AutocompleteFilter) (obj1)), placesparams2, zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 14: // '\016'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = (AddPlaceRequest)AddPlaceRequest.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                obj1 = obj3;
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((AddPlaceRequest) (obj)), ((PlacesParams) (obj1)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 15: // '\017'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                if (parcel.readInt() != 0)
                {
                    obj = (PlaceReport)PlaceReport.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                obj1 = obj4;
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((PlaceReport) (obj)), ((PlacesParams) (obj1)));
                parcel1.writeNoException();
                return true;

            case 16: // '\020'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                String s;
                String s3;
                if (parcel.readInt() != 0)
                {
                    obj = PlaceAlias.CREATOR.zzfc(parcel);
                } else
                {
                    obj = null;
                }
                s = parcel.readString();
                s3 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj1 = PlacesParams.CREATOR.zzeY(parcel);
                } else
                {
                    obj1 = null;
                }
                zza(((PlaceAlias) (obj)), s, s3, ((PlacesParams) (obj1)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 18: // '\022'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.readString();
                i = parcel.readInt();
                obj = obj8;
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((String) (obj1)), i, ((PlacesParams) (obj)), zzi.zza.zzch(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 19: // '\023'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.readString();
                obj = obj9;
                if (parcel.readInt() != 0)
                {
                    obj = PlacesParams.CREATOR.zzeY(parcel);
                }
                zza(((String) (obj1)), ((PlacesParams) (obj)), zzh.zza.zzcg(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 20: // '\024'
                parcel.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                obj1 = parcel.readString();
                i = parcel.readInt();
                j = parcel.readInt();
                k = parcel.readInt();
                obj = obj10;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = PlacesParams.CREATOR.zzeY(parcel);
            }
            zza(((String) (obj1)), i, j, k, ((PlacesParams) (obj)), zzh.zza.zzcg(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzg
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(AddPlaceRequest addplacerequest, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (addplacerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            addplacerequest.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            addplacerequest = zzi1.asBinder();
_L7:
            parcel.writeStrongBinder(addplacerequest);
            zznJ.transact(14, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            addplacerequest;
            parcel1.recycle();
            parcel.recycle();
            throw addplacerequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            addplacerequest = null;
              goto _L7
        }

        public void zza(NearbyAlertRequest nearbyalertrequest, PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (nearbyalertrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            nearbyalertrequest.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L7:
            zznJ.transact(11, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            nearbyalertrequest;
            parcel1.recycle();
            parcel.recycle();
            throw nearbyalertrequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void zza(PlaceReport placereport, PlacesParams placesparams)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placereport == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placereport.writeToParcel(parcel, 0);
_L3:
            if (placesparams == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(15, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placereport;
            parcel1.recycle();
            parcel.recycle();
            throw placereport;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(PlaceRequest placerequest, PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placerequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placerequest.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L7:
            zznJ.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placerequest;
            parcel1.recycle();
            parcel.recycle();
            throw placerequest;
_L4:
            parcel.writeInt(0);
              goto _L6
            parcel.writeInt(0);
              goto _L7
        }

        public void zza(UserDataType userdatatype, LatLngBounds latlngbounds, List list, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (userdatatype == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            userdatatype.writeToParcel(parcel, 0);
_L7:
            if (latlngbounds == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L8:
            parcel.writeStringList(list);
            if (placesparams == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L9:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_168;
            }
            userdatatype = zzi1.asBinder();
_L10:
            parcel.writeStrongBinder(userdatatype);
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            userdatatype;
            parcel1.recycle();
            parcel.recycle();
            throw userdatatype;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            userdatatype = null;
              goto _L10
        }

        public void zza(PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placesparams;
            parcel1.recycle();
            parcel.recycle();
            throw placesparams;
            parcel.writeInt(0);
              goto _L4
        }

        public void zza(PlaceAlias placealias, String s, String s1, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placealias == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placealias.writeToParcel(parcel, 0);
_L5:
            parcel.writeString(s);
            parcel.writeString(s1);
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_148;
            }
            placealias = zzi1.asBinder();
_L7:
            parcel.writeStrongBinder(placealias);
            zznJ.transact(16, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placealias;
            parcel1.recycle();
            parcel.recycle();
            throw placealias;
_L4:
            parcel.writeInt(0);
              goto _L6
            placealias = null;
              goto _L7
        }

        public void zza(LatLng latlng, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latlng == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlng.writeToParcel(parcel, 0);
_L7:
            if (placefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L8:
            if (placesparams == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L9:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            latlng = zzi1.asBinder();
_L10:
            parcel.writeStrongBinder(latlng);
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            latlng;
            parcel1.recycle();
            parcel.recycle();
            throw latlng;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            latlng = null;
              goto _L10
        }

        public void zza(LatLngBounds latlngbounds, int i, String s, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (latlngbounds == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L7:
            parcel.writeInt(i);
            parcel.writeString(s);
            if (placefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L8:
            if (placesparams == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L9:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_175;
            }
            latlngbounds = zzi1.asBinder();
_L10:
            parcel.writeStrongBinder(latlngbounds);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            latlngbounds;
            parcel1.recycle();
            parcel.recycle();
            throw latlngbounds;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            latlngbounds = null;
              goto _L10
        }

        public void zza(String s, int i, int j, int k, PlacesParams placesparams, zzh zzh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_135;
            }
            s = zzh1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(20, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void zza(String s, int i, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            s = zzi1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void zza(String s, PlacesParams placesparams, zzh zzh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            s = zzh1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void zza(String s, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            s = zzi1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void zza(String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            if (latlngbounds == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            latlngbounds.writeToParcel(parcel, 0);
_L7:
            if (autocompletefilter == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            autocompletefilter.writeToParcel(parcel, 0);
_L8:
            if (placesparams == null) goto _L6; else goto _L5
_L5:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L9:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_168;
            }
            s = zzi1.asBinder();
_L10:
            parcel.writeStrongBinder(s);
            zznJ.transact(13, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L7
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
_L4:
            parcel.writeInt(0);
              goto _L8
_L6:
            parcel.writeInt(0);
              goto _L9
            s = null;
              goto _L10
        }

        public void zza(List list, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeStringList(list);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            list = zzi1.asBinder();
_L4:
            parcel.writeStrongBinder(list);
            zznJ.transact(7, parcel, parcel1, 0);
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

        public void zzb(PlaceFilter placefilter, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placefilter == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placefilter.writeToParcel(parcel, 0);
_L5:
            if (placesparams == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L6:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_131;
            }
            placefilter = zzi1.asBinder();
_L7:
            parcel.writeStrongBinder(placefilter);
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L5
            placefilter;
            parcel1.recycle();
            parcel.recycle();
            throw placefilter;
_L4:
            parcel.writeInt(0);
              goto _L6
            placefilter = null;
              goto _L7
        }

        public void zzb(PlacesParams placesparams, PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (pendingintent == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            parcel.writeInt(1);
            pendingintent.writeToParcel(parcel, 0);
_L4:
            zznJ.transact(12, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            placesparams;
            parcel1.recycle();
            parcel.recycle();
            throw placesparams;
            parcel.writeInt(0);
              goto _L4
        }

        public void zzb(String s, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeString(s);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            s = zzi1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public void zzb(List list, PlacesParams placesparams, zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
            parcel.writeStringList(list);
            if (placesparams == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            placesparams.writeToParcel(parcel, 0);
_L3:
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            list = zzi1.asBinder();
_L4:
            parcel.writeStrongBinder(list);
            zznJ.transact(17, parcel, parcel1, 0);
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

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(AddPlaceRequest addplacerequest, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(NearbyAlertRequest nearbyalertrequest, PlacesParams placesparams, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(PlaceReport placereport, PlacesParams placesparams)
        throws RemoteException;

    public abstract void zza(PlaceRequest placerequest, PlacesParams placesparams, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(UserDataType userdatatype, LatLngBounds latlngbounds, List list, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(PlacesParams placesparams, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zza(PlaceAlias placealias, String s, String s1, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(LatLng latlng, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(LatLngBounds latlngbounds, int i, String s, PlaceFilter placefilter, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(String s, int i, int j, int k, PlacesParams placesparams, zzh zzh)
        throws RemoteException;

    public abstract void zza(String s, int i, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(String s, PlacesParams placesparams, zzh zzh)
        throws RemoteException;

    public abstract void zza(String s, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zza(List list, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zzb(PlaceFilter placefilter, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zzb(PlacesParams placesparams, PendingIntent pendingintent)
        throws RemoteException;

    public abstract void zzb(String s, PlacesParams placesparams, zzi zzi)
        throws RemoteException;

    public abstract void zzb(List list, PlacesParams placesparams, zzi zzi)
        throws RemoteException;
}
