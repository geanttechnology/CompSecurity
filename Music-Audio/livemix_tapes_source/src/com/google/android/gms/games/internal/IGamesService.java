// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

// Referenced classes of package com.google.android.gms.games.internal:
//            IGamesCallbacks, IGamesClient

public interface IGamesService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IGamesService
    {

        public static IGamesService zzbQ(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            if (iinterface != null && (iinterface instanceof IGamesService))
            {
                return (IGamesService)iinterface;
            } else
            {
                return new Proxy(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj1 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj4 = null;
            IBinder ibinder1 = null;
            Object obj = null;
            boolean flag1 = false;
            boolean flag24 = false;
            boolean flag18 = false;
            boolean flag21 = false;
            boolean flag25 = false;
            int k = 0;
            boolean flag26 = false;
            boolean flag27 = false;
            boolean flag28 = false;
            boolean flag29 = false;
            boolean flag22 = false;
            boolean flag23 = false;
            boolean flag20 = false;
            boolean flag30 = false;
            boolean flag31 = false;
            boolean flag32 = false;
            boolean flag33 = false;
            boolean flag34 = false;
            boolean flag35 = false;
            boolean flag36 = false;
            boolean flag37 = false;
            boolean flag38 = false;
            boolean flag39 = false;
            boolean flag40 = false;
            boolean flag = false;
            boolean flag41 = false;
            boolean flag42 = false;
            boolean flag43 = false;
            boolean flag44 = false;
            boolean flag45 = false;
            boolean flag46 = false;
            boolean flag47 = false;
            boolean flag48 = false;
            boolean flag49 = false;
            boolean flag50 = false;
            boolean flag51 = false;
            boolean flag52 = false;
            boolean flag2 = false;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.games.internal.IGamesService");
                return true;

            case 5001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzE(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztW();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 5004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzmw();
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

            case 5005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((IBinder) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 5006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzud();
                parcel1.writeNoException();
                return true;

            case 5007: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztH();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 5064: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzda(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 5065: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzA(parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5012: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztI();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 5013: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzuf();
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

            case 5014: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5015: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag2 = true;
                }
                zza(((IGamesCallbacks) (obj)), i, flag1, flag2);
                parcel1.writeNoException();
                return true;

            case 5016: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5017: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5018: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5019: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                j = parcel.readInt();
                k = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), i, j, k, flag1);
                parcel1.writeNoException();
                return true;

            case 5020: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                j = parcel.readInt();
                k = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), i, j, k, flag1);
                parcel1.writeNoException();
                return true;

            case 5021: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                zza(((IGamesCallbacks) (obj1)), ((Bundle) (obj)), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5022: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5023: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), ((IBinder) (obj4)), parcel);
                parcel1.writeNoException();
                return true;

            case 5024: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), ((IBinder) (obj4)), parcel);
                parcel1.writeNoException();
                return true;

            case 5025: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj4 = parcel.readString();
                i = parcel.readInt();
                ibinder1 = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                zza(((IGamesCallbacks) (obj1)), ((String) (obj4)), i, ibinder1, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 5026: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5027: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zze(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5028: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzs(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5029: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzr(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5058: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5059: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzF(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5030: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj4 = parcel.readStrongBinder();
                i = parcel.readInt();
                ibinder1 = parcel.createStringArray();
                obj = obj5;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj1)), ((IBinder) (obj4)), i, ibinder1, ((Bundle) (obj)), flag1, parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5031: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readStrongBinder();
                obj4 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj)), ((IBinder) (obj1)), ((String) (obj4)), flag1, parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 5032: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5033: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 5034: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zzb(parcel.createByteArray(), parcel.readString(), parcel.createStringArray());
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 5035: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzdb(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 5036: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzfN(parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5037: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5038: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5039: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readString();
                i = parcel.readInt();
                j = parcel.readInt();
                k = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), ((String) (obj4)), i, j, k, flag1);
                parcel1.writeNoException();
                return true;

            case 5040: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readString();
                i = parcel.readInt();
                j = parcel.readInt();
                k = parcel.readInt();
                flag1 = flag24;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), ((String) (obj4)), i, j, k, flag1);
                parcel1.writeNoException();
                return true;

            case 5041: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5042: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zze(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5043: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzf(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5044: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                j = parcel.readInt();
                boolean flag3;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                zza(((IGamesCallbacks) (obj)), i, j, flag1, flag3);
                parcel1.writeNoException();
                return true;

            case 5045: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                boolean flag4;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), i, flag1, flag4);
                parcel1.writeNoException();
                return true;

            case 5046: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                boolean flag5;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag5 = flag18;
                if (parcel.readInt() != 0)
                {
                    flag5 = true;
                }
                zzb(((IGamesCallbacks) (obj)), i, flag1, flag5);
                parcel1.writeNoException();
                return true;

            case 5047: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzf(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5048: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                boolean flag6;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag6 = flag21;
                if (parcel.readInt() != 0)
                {
                    flag6 = true;
                }
                zzc(((IGamesCallbacks) (obj)), i, flag1, flag6);
                parcel1.writeNoException();
                return true;

            case 5049: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzg(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5050: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzdc(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5051: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5052: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzg(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5053: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzh(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
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

            case 5060: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zzdd(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 5054: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                flag1 = flag25;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), flag1);
                parcel1.writeNoException();
                return true;

            case 5061: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzi(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5055: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzu(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 5067: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                flag1 = zzug();
                parcel1.writeNoException();
                i = k;
                if (flag1)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 5068: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                flag1 = flag26;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzac(flag1);
                parcel1.writeNoException();
                return true;

            case 5056: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzh(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5057: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzj(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 5062: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzi(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5063: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag27;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((IGamesCallbacks) (obj)), flag1, parcel);
                parcel1.writeNoException();
                return true;

            case 5066: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzde(parcel.readString());
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

            case 5501: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                boolean flag7;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), i, flag1, flag7);
                parcel1.writeNoException();
                return true;

            case 5502: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzuh();
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

            case 6001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag28;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 6002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readString();
                flag1 = flag29;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), ((String) (obj4)), flag1);
                parcel1.writeNoException();
                return true;

            case 6003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                boolean flag8;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag8 = flag22;
                if (parcel.readInt() != 0)
                {
                    flag8 = true;
                }
                zzd(((IGamesCallbacks) (obj)), i, flag1, flag8);
                parcel1.writeNoException();
                return true;

            case 6004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                boolean flag9;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag9 = flag23;
                if (parcel.readInt() != 0)
                {
                    flag9 = true;
                }
                zze(((IGamesCallbacks) (obj)), i, flag1, flag9);
                parcel1.writeNoException();
                return true;

            case 6501: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                boolean flag10;
                boolean flag19;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag10 = true;
                } else
                {
                    flag10 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag19 = true;
                } else
                {
                    flag19 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag20 = true;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), i, flag1, flag10, flag19, flag20);
                parcel1.writeNoException();
                return true;

            case 6502: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                flag1 = flag30;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), flag1);
                parcel1.writeNoException();
                return true;

            case 6503: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag31;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzb(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 6504: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                flag1 = flag32;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzc(((IGamesCallbacks) (obj)), ((String) (obj1)), flag1);
                parcel1.writeNoException();
                return true;

            case 6505: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                flag1 = flag33;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzd(((IGamesCallbacks) (obj)), ((String) (obj1)), flag1);
                parcel1.writeNoException();
                return true;

            case 6506: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                obj4 = parcel.readString();
                flag1 = flag34;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzb(((IGamesCallbacks) (obj)), ((String) (obj1)), ((String) (obj4)), flag1);
                parcel1.writeNoException();
                return true;

            case 6507: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                if (parcel.readInt() != 0)
                {
                    parcel = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zzk(parcel);
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

            case 7001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzk(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 7002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 7003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj4 = parcel.readString();
                i = parcel.readInt();
                ibinder1 = parcel.readStrongBinder();
                obj = obj6;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                zzb(((IGamesCallbacks) (obj1)), ((String) (obj4)), i, ibinder1, ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 8001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 8002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzdf(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.createIntArray());
                parcel1.writeNoException();
                return true;

            case 8004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                j = parcel.readInt();
                obj4 = parcel.createStringArray();
                obj = obj7;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                zza(((IGamesCallbacks) (obj1)), i, j, ((String []) (obj4)), ((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 8005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzl(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzm(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8007: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readString(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
                parcel1.writeNoException();
                return true;

            case 8008: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
                parcel1.writeNoException();
                return true;

            case 8009: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzn(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8010: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzo(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8011: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8012: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 8013: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzG(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 8014: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzp(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8024: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zztX();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 8025: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzB(parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8015: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8016: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zze(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8017: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray());
                parcel1.writeNoException();
                return true;

            case 8026: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 8018: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8019: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8020: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8021: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 8022: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzui();
                parcel1.writeNoException();
                return true;

            case 8023: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                flag1 = flag35;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), ((String) (obj1)), i, flag1);
                parcel1.writeNoException();
                return true;

            case 8027: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag36;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzc(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 9001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj1 = parcel.readString();
                i = parcel.readInt();
                boolean flag11;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag11 = true;
                } else
                {
                    flag11 = false;
                }
                zzc(((IGamesCallbacks) (obj)), ((String) (obj1)), i, flag1, flag11);
                parcel1.writeNoException();
                return true;

            case 9002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzq(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 9003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztL();
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

            case 9004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzdg(parcel.readString());
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

            case 9005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztM();
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

            case 9006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztN();
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

            case 9007: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztO();
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

            case 9008: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = parcel.readInt();
                j = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                parcel = zzb(i, j, flag1);
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

            case 9009: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = parcel.readInt();
                j = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                parcel = zzc(i, j, flag1);
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

            case 9010: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztT();
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

            case 9011: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                if (parcel.readInt() != 0)
                {
                    obj = (RoomEntity)RoomEntity.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                parcel = zza(((RoomEntity) (obj)), parcel.readInt());
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

            case 9012: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztU();
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

            case 9013: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzuj();
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

            case 9031: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj4 = (ParticipantEntity[])parcel.createTypedArray(ParticipantEntity.CREATOR);
                ibinder1 = parcel.readString();
                String s16 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    obj1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                parcel = zza(((ParticipantEntity []) (obj4)), ibinder1, s16, ((Uri) (obj)), ((Uri) (obj1)));
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

            case 9019: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zztV();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 9020: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s = parcel.readString();
                i = parcel.readInt();
                boolean flag12;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag12 = true;
                } else
                {
                    flag12 = false;
                }
                zzd(((IGamesCallbacks) (obj)), s, i, flag1, flag12);
                parcel1.writeNoException();
                return true;

            case 9028: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s1 = parcel.readString();
                obj4 = parcel.readString();
                i = parcel.readInt();
                boolean flag13;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag13 = true;
                } else
                {
                    flag13 = false;
                }
                zza(((IGamesCallbacks) (obj)), s1, ((String) (obj4)), i, flag1, flag13);
                parcel1.writeNoException();
                return true;

            case 9030: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzdh(parcel.readString());
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

            case 10001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 10002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzH(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 10003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 10004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 10005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 10007: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 10008: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 10009: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10010: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10011: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10012: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zza(parcel.readInt(), parcel.createByteArray(), parcel.readInt(), parcel.readString());
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

            case 10013: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zztZ();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 10023: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zzua();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 10015: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zztY();
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

            case 10022: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = obj8;
                if (parcel.readInt() != 0)
                {
                    obj = GameRequestCluster.CREATOR.zzdS(parcel);
                }
                parcel = zza(((GameRequestCluster) (obj)), parcel.readString());
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

            case 10014: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzv(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10016: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 10017: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s2 = parcel.readString();
                i = parcel.readInt();
                flag1 = flag37;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzb(((IGamesCallbacks) (obj)), s2, i, flag1);
                parcel1.writeNoException();
                return true;

            case 10021: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = obj9;
                if (parcel.readInt() != 0)
                {
                    obj = ZInvitationCluster.CREATOR.zzdQ(parcel);
                }
                parcel = zza(((ZInvitationCluster) (obj)), parcel.readString(), parcel.readString());
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

            case 10018: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readInt(), parcel.createIntArray());
                parcel1.writeNoException();
                return true;

            case 10019: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.createIntArray());
                parcel1.writeNoException();
                return true;

            case 10020: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 11001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzj(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 11002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzuk();
                parcel1.writeNoException();
                return true;

            case 12001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = parcel.readString();
                boolean flag14;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag14 = true;
                } else
                {
                    flag14 = false;
                }
                parcel = zza(((String) (obj)), flag1, flag14, parcel.readInt());
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

            case 12002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag38;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzd(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 12003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s3 = parcel.readString();
                obj4 = parcel.readString();
                flag1 = flag39;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzc(((IGamesCallbacks) (obj)), s3, ((String) (obj4)), flag1);
                parcel1.writeNoException();
                return true;

            case 12006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s4 = parcel.readString();
                flag1 = flag40;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zze(((IGamesCallbacks) (obj)), s4, flag1);
                parcel1.writeNoException();
                return true;

            case 12007: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                IGamesCallbacks igamescallbacks = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                obj4 = parcel.readString();
                if (parcel.readInt() != 0)
                {
                    obj = SnapshotMetadataChangeEntity.CREATOR.zzee(parcel);
                } else
                {
                    obj = null;
                }
                if (parcel.readInt() != 0)
                {
                    parcel = (Contents)Contents.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(igamescallbacks, ((String) (obj4)), ((SnapshotMetadataChangeEntity) (obj)), parcel);
                parcel1.writeNoException();
                return true;

            case 12019: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                if (parcel.readInt() != 0)
                {
                    parcel = (Contents)Contents.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(parcel);
                parcel1.writeNoException();
                return true;

            case 12020: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzr(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12033: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                ibinder1 = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s17 = parcel.readString();
                String s19 = parcel.readString();
                Object obj2;
                if (parcel.readInt() != 0)
                {
                    obj = SnapshotMetadataChangeEntity.CREATOR.zzee(parcel);
                } else
                {
                    obj = null;
                }
                obj2 = obj4;
                if (parcel.readInt() != 0)
                {
                    obj2 = (Contents)Contents.CREATOR.createFromParcel(parcel);
                }
                zza(ibinder1, s17, s19, ((SnapshotMetadataChangeEntity) (obj)), ((Contents) (obj2)));
                parcel1.writeNoException();
                return true;

            case 12035: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zzub();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 12036: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                i = zzuc();
                parcel1.writeNoException();
                parcel1.writeInt(i);
                return true;

            case 12005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzs(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12023: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 12024: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzc(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 12021: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s5 = parcel.readString();
                i = parcel.readInt();
                boolean flag15;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag15 = true;
                } else
                {
                    flag15 = false;
                }
                zze(((IGamesCallbacks) (obj)), s5, i, flag1, flag15);
                parcel1.writeNoException();
                return true;

            case 12022: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s6 = parcel.readString();
                i = parcel.readInt();
                boolean flag16;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag16 = true;
                } else
                {
                    flag16 = false;
                }
                zzf(((IGamesCallbacks) (obj)), s6, i, flag1, flag16);
                parcel1.writeNoException();
                return true;

            case 12025: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                flag1 = zzul();
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                if (flag1)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 12026: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                flag1 = flag41;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzad(flag1);
                parcel1.writeNoException();
                return true;

            case 12027: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzt(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12032: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag42;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zze(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 12016: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag43;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzf(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 12031: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag44;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), flag1, parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 12017: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzq(parcel.readString(), parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 12008: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzu(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12009: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzf(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12010: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                int ai[] = parcel.createIntArray();
                i = parcel.readInt();
                flag1 = flag45;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), ai, i, flag1);
                parcel1.writeNoException();
                return true;

            case 12029: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String as[] = parcel.createStringArray();
                flag1 = flag46;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), as, flag1);
                parcel1.writeNoException();
                return true;

            case 12015: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s7 = parcel.readString();
                String s13 = parcel.readString();
                ibinder1 = parcel.createIntArray();
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj)), s7, s13, ibinder1, i, flag1);
                parcel1.writeNoException();
                return true;

            case 12028: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s8 = parcel.readString();
                String s14 = parcel.readString();
                ibinder1 = parcel.createStringArray();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj)), s8, s14, ibinder1, flag1);
                parcel1.writeNoException();
                return true;

            case 12011: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 12013: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzd(IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12012: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzI(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 12014: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zze(parcel.readLong(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 12030: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzb(parcel.createIntArray());
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

            case 12034: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzcY(parcel.readString());
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

            case 12018: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s9 = parcel.readString();
                String s15 = parcel.readString();
                i = parcel.readInt();
                boolean flag17;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (parcel.readInt() != 0)
                {
                    flag17 = true;
                } else
                {
                    flag17 = false;
                }
                zzb(((IGamesCallbacks) (obj)), s9, s15, i, flag1, flag17);
                parcel1.writeNoException();
                return true;

            case 13001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                flag1 = flag47;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzae(flag1);
                parcel1.writeNoException();
                return true;

            case 13002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = parcel.readString();
                IBinder ibinder = parcel.readStrongBinder();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                zza(((String) (obj)), ibinder, parcel);
                parcel1.writeNoException();
                return true;

            case 13003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag48;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzg(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 13004: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag49;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzh(((IGamesCallbacks) (obj)), flag1);
                parcel1.writeNoException();
                return true;

            case 13005: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                if (parcel.readInt() != 0)
                {
                    parcel = (AchievementEntity)AchievementEntity.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zza(parcel);
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

            case 13006: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s10 = parcel.readString();
                flag1 = flag50;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zzf(((IGamesCallbacks) (obj)), s10, flag1);
                parcel1.writeNoException();
                return true;

            case 14001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzw(parcel.readString(), parcel.readInt());
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

            case 14002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                i = parcel.readInt();
                String s11 = parcel.readString();
                String as1[] = parcel.createStringArray();
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zza(((IGamesCallbacks) (obj)), i, s11, as1, flag1);
                parcel1.writeNoException();
                return true;

            case 14003: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                ParticipantEntity aparticipantentity[] = (ParticipantEntity[])parcel.createTypedArray(ParticipantEntity.CREATOR);
                String s18 = parcel.readString();
                String s20 = parcel.readString();
                Object obj3;
                if (parcel.readInt() != 0)
                {
                    obj = (Uri)Uri.CREATOR.createFromParcel(parcel);
                } else
                {
                    obj = null;
                }
                obj3 = ibinder1;
                if (parcel.readInt() != 0)
                {
                    obj3 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                }
                parcel = zza(aparticipantentity, s18, s20, ((Uri) (obj)), ((Uri) (obj3)), parcel.readString());
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

            case 15001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                String s12 = parcel.readString();
                flag1 = flag51;
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                zza(((IGamesCallbacks) (obj)), s12, flag1, parcel.readInt());
                parcel1.writeNoException();
                return true;

            case 15002: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzb(parcel.createStringArray());
                parcel1.writeNoException();
                return true;

            case 15501: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zza(IGamesClient.Stub.zzbP(parcel.readStrongBinder()), parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 15502: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzJ(parcel.readLong());
                parcel1.writeNoException();
                return true;

            case 15503: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                if (parcel.readInt() != 0)
                {
                    parcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                parcel = zza(parcel);
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

            case 15504: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                zzum();
                parcel1.writeNoException();
                return true;

            case 16001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                parcel = zzun();
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

            case 17001: 
                parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                obj = IGamesCallbacks.Stub.zzbO(parcel.readStrongBinder());
                flag1 = flag52;
                break;
            }
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            }
            zzi(((IGamesCallbacks) (obj)), flag1);
            parcel1.writeNoException();
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }
    }

    private static class Stub.Proxy
        implements IGamesService
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zzA(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(5065, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzB(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(8025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzE(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(5001, parcel, parcel1, 0);
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

        public void zzF(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(5059, parcel, parcel1, 0);
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

        public void zzG(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(8013, parcel, parcel1, 0);
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

        public void zzH(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(10002, parcel, parcel1, 0);
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

        public void zzI(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(12012, parcel, parcel1, 0);
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

        public void zzJ(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            zznI.transact(15502, parcel, parcel1, 0);
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

        public int zza(IGamesCallbacks igamescallbacks, byte abyte0[], String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            int i;
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(5033, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public Intent zza(int i, byte abyte0[], int j, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i);
            parcel.writeByteArray(abyte0);
            parcel.writeInt(j);
            parcel.writeString(s);
            zznI.transact(10012, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            abyte0 = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return abyte0;
_L2:
            abyte0 = null;
            if (true) goto _L4; else goto _L3
_L3:
            abyte0;
            parcel1.recycle();
            parcel.recycle();
            throw abyte0;
        }

        public Intent zza(PlayerEntity playerentity)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (playerentity == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            playerentity.writeToParcel(parcel, 0);
_L3:
            zznI.transact(15503, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            playerentity = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return playerentity;
_L2:
            parcel.writeInt(0);
              goto _L3
            playerentity;
            parcel1.recycle();
            parcel.recycle();
            throw playerentity;
            playerentity = null;
              goto _L4
        }

        public Intent zza(AchievementEntity achievemententity)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (achievemententity == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            achievemententity.writeToParcel(parcel, 0);
_L3:
            zznI.transact(13005, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            achievemententity = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return achievemententity;
_L2:
            parcel.writeInt(0);
              goto _L3
            achievemententity;
            parcel1.recycle();
            parcel.recycle();
            throw achievemententity;
            achievemententity = null;
              goto _L4
        }

        public Intent zza(ZInvitationCluster zinvitationcluster, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (zinvitationcluster == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            zinvitationcluster.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(10021, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            zinvitationcluster = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return zinvitationcluster;
_L2:
            parcel.writeInt(0);
              goto _L3
            zinvitationcluster;
            parcel1.recycle();
            parcel.recycle();
            throw zinvitationcluster;
            zinvitationcluster = null;
              goto _L4
        }

        public Intent zza(GameRequestCluster gamerequestcluster, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (gamerequestcluster == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            gamerequestcluster.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s);
            zznI.transact(10022, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            gamerequestcluster = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return gamerequestcluster;
_L2:
            parcel.writeInt(0);
              goto _L3
            gamerequestcluster;
            parcel1.recycle();
            parcel.recycle();
            throw gamerequestcluster;
            gamerequestcluster = null;
              goto _L4
        }

        public Intent zza(RoomEntity roomentity, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (roomentity == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            roomentity.writeToParcel(parcel, 0);
_L3:
            parcel.writeInt(i);
            zznI.transact(9011, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            roomentity = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return roomentity;
_L2:
            parcel.writeInt(0);
              goto _L3
            roomentity;
            parcel1.recycle();
            parcel.recycle();
            throw roomentity;
            roomentity = null;
              goto _L4
        }

        public Intent zza(String s, boolean flag, boolean flag1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            int j;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            if (flag1)
            {
                j = ((flag2) ? 1 : 0);
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            parcel.writeInt(i);
            zznI.transact(12001, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Intent)Intent.CREATOR.createFromParcel(parcel1);
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

        public Intent zza(ParticipantEntity aparticipantentity[], String s, String s1, Uri uri, Uri uri1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeTypedArray(aparticipantentity, 0);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L5:
            if (uri1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            uri1.writeToParcel(parcel, 0);
_L6:
            zznI.transact(9031, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_162;
            }
            aparticipantentity = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L7:
            parcel1.recycle();
            parcel.recycle();
            return aparticipantentity;
_L2:
            parcel.writeInt(0);
              goto _L5
            aparticipantentity;
            parcel1.recycle();
            parcel.recycle();
            throw aparticipantentity;
_L4:
            parcel.writeInt(0);
              goto _L6
            aparticipantentity = null;
              goto _L7
        }

        public Intent zza(ParticipantEntity aparticipantentity[], String s, String s1, Uri uri, Uri uri1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeTypedArray(aparticipantentity, 0);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L5:
            if (uri1 == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            uri1.writeToParcel(parcel, 0);
_L6:
            parcel.writeString(s2);
            zznI.transact(14003, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_169;
            }
            aparticipantentity = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L7:
            parcel1.recycle();
            parcel.recycle();
            return aparticipantentity;
_L2:
            parcel.writeInt(0);
              goto _L5
            aparticipantentity;
            parcel1.recycle();
            parcel.recycle();
            throw aparticipantentity;
_L4:
            parcel.writeInt(0);
              goto _L6
            aparticipantentity = null;
              goto _L7
        }

        public void zza(IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeStrongBinder(ibinder);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            zznI.transact(5005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            ibinder;
            parcel1.recycle();
            parcel.recycle();
            throw ibinder;
        }

        public void zza(Contents contents)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (contents == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            parcel.writeInt(1);
            contents.writeToParcel(parcel, 0);
_L1:
            zznI.transact(12019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            contents;
            parcel1.recycle();
            parcel.recycle();
            throw contents;
        }

        public void zza(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            zznI.transact(10016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, int j, int k)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            zznI.transact(10009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, int j, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            parcel.writeInt(j);
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
            zznI.transact(5044, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, int j, String as[], Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(8004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, String s, String as[], boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_106;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(14002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
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
            zznI.transact(5015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int i, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
            parcel.writeIntArray(ai);
            zznI.transact(10018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            zznI.transact(5058, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(8018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, Bundle bundle, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            parcel.writeInt(i);
            parcel.writeInt(j);
            zznI.transact(5021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zza(IGamesCallbacks igamescallbacks, IBinder ibinder, int i, String as[], Bundle bundle, boolean flag, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L6:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStrongBinder(ibinder);
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
              goto _L5
_L7:
            parcel.writeInt(i);
            parcel.writeLong(l);
            zznI.transact(5030, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L6
_L4:
            parcel.writeInt(0);
              goto _L5
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
_L9:
            i = 0;
              goto _L7
_L5:
            if (!flag) goto _L9; else goto _L8
_L8:
            i = ((flag1) ? 1 : 0);
              goto _L7
        }

        public void zza(IGamesCallbacks igamescallbacks, IBinder ibinder, String s, boolean flag, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStrongBinder(ibinder);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            parcel.writeLong(l);
            zznI.transact(5031, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(10011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, int j, int k, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(5025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(8023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(5045, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1, boolean flag2, boolean flag3)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag4;
            flag4 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (flag2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (flag3)
            {
                i = ((flag4) ? 1 : 0);
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            zznI.transact(6501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int i, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeIntArray(ai);
            zznI.transact(10019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeLong(l);
            zznI.transact(5016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, long l, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeLong(l);
            parcel.writeString(s1);
            zznI.transact(7002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(5023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, SnapshotMetadataChangeEntity snapshotmetadatachangeentity, Contents contents)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (snapshotmetadatachangeentity == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            snapshotmetadatachangeentity.writeToParcel(parcel, 0);
_L6:
            if (contents == null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            parcel.writeInt(1);
            contents.writeToParcel(parcel, 0);
_L7:
            zznI.transact(12007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
            parcel.writeInt(0);
              goto _L7
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(5038, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            zznI.transact(8001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            zznI.transact(10010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5039, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
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
            zznI.transact(9028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, SnapshotMetadataChangeEntity snapshotmetadatachangeentity, Contents contents)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (snapshotmetadatachangeentity == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            snapshotmetadatachangeentity.writeToParcel(parcel, 0);
_L6:
            if (contents == null)
            {
                break MISSING_BLOCK_LABEL_145;
            }
            parcel.writeInt(1);
            contents.writeToParcel(parcel, 0);
_L7:
            zznI.transact(12033, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
            parcel.writeInt(0);
              goto _L7
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, int ai[], int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_116;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeIntArray(ai);
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            zznI.transact(10008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String s1, String as[], boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5054, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, boolean flag, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int j;
            j = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                j = 1;
            }
            parcel.writeInt(j);
            parcel.writeInt(i);
            zznI.transact(15001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s1);
            parcel.writeTypedArray(aparticipantresult, 0);
            zznI.transact(8007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, byte abyte0[], ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            parcel.writeTypedArray(aparticipantresult, 0);
            zznI.transact(8008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeIntArray(ai);
            zznI.transact(8017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String s, String as[], int i, byte abyte0[], int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            parcel.writeInt(i);
            parcel.writeByteArray(abyte0);
            parcel.writeInt(j);
            zznI.transact(10005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, boolean flag, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            if (!flag)
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(5063, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zza(IGamesCallbacks igamescallbacks, boolean flag, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            parcel.writeStringArray(as);
            zznI.transact(12031, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeIntArray(ai);
            zznI.transact(8003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, int ai[], int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeIntArray(ai);
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStringArray(as);
            zznI.transact(10006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesCallbacks igamescallbacks, String as[], boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStringArray(as);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12029, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zza(IGamesClient igamesclient, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamesclient == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            igamesclient = igamesclient.asBinder();
_L1:
            parcel.writeStrongBinder(igamesclient);
            parcel.writeLong(l);
            zznI.transact(15501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamesclient = null;
              goto _L1
            igamesclient;
            parcel1.recycle();
            parcel.recycle();
            throw igamesclient;
        }

        public void zza(String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            zznI.transact(13002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzac(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5068, parcel, parcel1, 0);
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

        public void zzad(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12026, parcel, parcel1, 0);
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

        public void zzae(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(13001, parcel, parcel1, 0);
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

        public int zzb(byte abyte0[], String s, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeByteArray(abyte0);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            zznI.transact(5034, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            abyte0;
            parcel1.recycle();
            parcel.recycle();
            throw abyte0;
        }

        public Intent zzb(int i, int j, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i);
            parcel.writeInt(j);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(9008, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zzb(int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeIntArray(ai);
            zznI.transact(12030, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            ai = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return ai;
_L2:
            ai = null;
            if (true) goto _L4; else goto _L3
_L3:
            ai;
            parcel1.recycle();
            parcel.recycle();
            throw ai;
        }

        public void zzb(long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(8019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzb(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
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
            zznI.transact(5046, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            zznI.transact(8012, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(8020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(12023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, int i, int j, int k, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, int i, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(7003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, int i, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(10017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(5501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null) goto _L2; else goto _L1
_L1:
            igamescallbacks = igamescallbacks.asBinder();
_L5:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            zznI.transact(5024, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            igamescallbacks = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
              goto _L5
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(5041, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(5040, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, String s1, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
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
            zznI.transact(12018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6506, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6502, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6503, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(IGamesCallbacks igamescallbacks, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStringArray(as);
            zznI.transact(10007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzb(String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeStringArray(as);
            zznI.transact(15002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            as;
            parcel1.recycle();
            parcel.recycle();
            throw as;
        }

        public Intent zzc(int i, int j, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i);
            parcel.writeInt(j);
            i = ((flag1) ? 1 : 0);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(9009, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzc(long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(8021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzc(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5022, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
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
            zznI.transact(5048, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            zznI.transact(10001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(10003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5032, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(12024, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(9001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(8011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6504, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(8027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(IGamesCallbacks igamescallbacks, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeStringArray(as);
            zznI.transact(10020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzc(String s, String s1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            zznI.transact(5051, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzcY(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(12034, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Intent)Intent.CREATOR.createFromParcel(parcel1);
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

        public void zzd(long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(10004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzd(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
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
            zznI.transact(6003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            zznI.transact(12011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(12013, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5037, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(9020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(8015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(6505, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzd(String s, String s1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            zznI.transact(8026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public String zzda(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(5064, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public String zzdb(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(5035, parcel, parcel1, 0);
            parcel1.readException();
            s = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzdc(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(5050, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public int zzdd(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(5060, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Uri zzde(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(5066, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Uri)Uri.CREATOR.createFromParcel(parcel1);
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

        public void zzdf(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(8002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzdg(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(9004, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Intent)Intent.CREATOR.createFromParcel(parcel1);
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

        public ParcelFileDescriptor zzdh(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznI.transact(9030, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
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

        public void zze(long l, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l);
            parcel.writeString(s);
            zznI.transact(12014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zze(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeInt(i);
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
            zznI.transact(6004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5042, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(12021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(8016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zze(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12032, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5047, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5043, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeInt(i);
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
            zznI.transact(12022, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznI.transact(12009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(13006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzf(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(12016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzfN(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i);
            zznI.transact(5036, parcel, parcel1, 0);
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

        public void zzg(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5049, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzg(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5052, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzg(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(13003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public RoomEntity zzh(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5053, parcel, parcel1, 0);
            parcel1.readException();
            igamescallbacks = obj;
            if (parcel1.readInt() != 0)
            {
                igamescallbacks = (RoomEntity)RoomEntity.CREATOR.createFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return igamescallbacks;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzh(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5056, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzh(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(13004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzi(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(5062, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzi(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5061, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzi(IGamesCallbacks igamescallbacks, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            zznI.transact(17001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzj(IGamesCallbacks igamescallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            zznI.transact(11001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzj(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(5057, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public ParcelFileDescriptor zzk(Uri uri)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (uri == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
_L3:
            zznI.transact(6507, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            uri = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return uri;
_L2:
            parcel.writeInt(0);
              goto _L3
            uri;
            parcel1.recycle();
            parcel.recycle();
            throw uri;
            uri = null;
              goto _L4
        }

        public void zzk(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(7001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzl(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(8005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzm(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(8006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public Bundle zzmw()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5004, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return bundle;
_L2:
            bundle = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzn(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(8009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzo(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(8010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzp(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(8014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzq(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(9002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzq(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(12017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzr(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(12020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzr(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(5029, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzs(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(12005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzs(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(5028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzt(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(12027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public String zztH()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5007, parcel, parcel1, 0);
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

        public String zztI()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5012, parcel, parcel1, 0);
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

        public Intent zztL()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9003, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztM()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9005, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztN()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9006, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztO()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9007, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztT()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9010, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztU()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9012, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public int zztV()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9019, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String zztW()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5003, parcel, parcel1, 0);
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

        public int zztX()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(8024, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent zztY()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(10015, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public int zztZ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(10013, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzu(IGamesCallbacks igamescallbacks, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (igamescallbacks == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            igamescallbacks = igamescallbacks.asBinder();
_L1:
            parcel.writeStrongBinder(igamescallbacks);
            parcel.writeString(s);
            zznI.transact(12008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            igamescallbacks = null;
              goto _L1
            igamescallbacks;
            parcel1.recycle();
            parcel.recycle();
            throw igamescallbacks;
        }

        public void zzu(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(5055, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public int zzua()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(10023, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public int zzub()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(12035, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public int zzuc()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(12036, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzud()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5006, parcel, parcel1, 0);
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

        public DataHolder zzuf()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5013, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.zzaa(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return dataholder;
_L2:
            dataholder = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public boolean zzug()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5067, parcel, parcel1, 0);
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

        public DataHolder zzuh()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(5502, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.zzaa(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return dataholder;
_L2:
            dataholder = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzui()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(8022, parcel, parcel1, 0);
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

        public Intent zzuj()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(9013, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzuk()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(11002, parcel, parcel1, 0);
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

        public boolean zzul()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(12025, parcel, parcel1, 0);
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

        public void zzum()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(15504, parcel, parcel1, 0);
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

        public Intent zzun()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznI.transact(16001, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return intent;
_L2:
            intent = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void zzv(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(10014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzw(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznI.transact(14001, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s = (Intent)Intent.CREATOR.createFromParcel(parcel1);
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

        Stub.Proxy(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zzA(String s, String s1)
        throws RemoteException;

    public abstract void zzB(String s, String s1)
        throws RemoteException;

    public abstract void zzE(long l)
        throws RemoteException;

    public abstract void zzF(long l)
        throws RemoteException;

    public abstract void zzG(long l)
        throws RemoteException;

    public abstract void zzH(long l)
        throws RemoteException;

    public abstract void zzI(long l)
        throws RemoteException;

    public abstract void zzJ(long l)
        throws RemoteException;

    public abstract int zza(IGamesCallbacks igamescallbacks, byte abyte0[], String s, String s1)
        throws RemoteException;

    public abstract Intent zza(int i, byte abyte0[], int j, String s)
        throws RemoteException;

    public abstract Intent zza(PlayerEntity playerentity)
        throws RemoteException;

    public abstract Intent zza(AchievementEntity achievemententity)
        throws RemoteException;

    public abstract Intent zza(ZInvitationCluster zinvitationcluster, String s, String s1)
        throws RemoteException;

    public abstract Intent zza(GameRequestCluster gamerequestcluster, String s)
        throws RemoteException;

    public abstract Intent zza(RoomEntity roomentity, int i)
        throws RemoteException;

    public abstract Intent zza(String s, boolean flag, boolean flag1, int i)
        throws RemoteException;

    public abstract Intent zza(ParticipantEntity aparticipantentity[], String s, String s1, Uri uri, Uri uri1)
        throws RemoteException;

    public abstract Intent zza(ParticipantEntity aparticipantentity[], String s, String s1, Uri uri, Uri uri1, String s2)
        throws RemoteException;

    public abstract void zza(IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zza(Contents contents)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, int j, int k)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, int j, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, int j, String as[], Bundle bundle)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, String s, String as[], boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int i, int ai[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, long l)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, long l, String s)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, Bundle bundle, int i, int j)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, IBinder ibinder, int i, String as[], Bundle bundle, boolean flag, long l)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, IBinder ibinder, String s, boolean flag, long l)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, int j, int k, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1, boolean flag2, boolean flag3)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int i, int ai[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, long l)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, long l, String s1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, SnapshotMetadataChangeEntity snapshotmetadatachangeentity, Contents contents)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, SnapshotMetadataChangeEntity snapshotmetadatachangeentity, Contents contents)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, int ai[], int i, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, String as[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String s1, String as[], boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, boolean flag, int i)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, byte abyte0[], ParticipantResult aparticipantresult[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, int ai[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String s, String as[], int i, byte abyte0[], int j)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, boolean flag, Bundle bundle)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, boolean flag, String as[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int ai[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, int ai[], int i, boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String as[])
        throws RemoteException;

    public abstract void zza(IGamesCallbacks igamescallbacks, String as[], boolean flag)
        throws RemoteException;

    public abstract void zza(IGamesClient igamesclient, long l)
        throws RemoteException;

    public abstract void zza(String s, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zzac(boolean flag)
        throws RemoteException;

    public abstract void zzad(boolean flag)
        throws RemoteException;

    public abstract void zzae(boolean flag)
        throws RemoteException;

    public abstract int zzb(byte abyte0[], String s, String as[])
        throws RemoteException;

    public abstract Intent zzb(int i, int j, boolean flag)
        throws RemoteException;

    public abstract Intent zzb(int ai[])
        throws RemoteException;

    public abstract void zzb(long l, String s)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, long l)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, long l, String s)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, int i)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, int i, int j, int k, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, int i, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, int i, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, IBinder ibinder, Bundle bundle)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, String s1, int i, int j, int k, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, String s1, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzb(IGamesCallbacks igamescallbacks, String as[])
        throws RemoteException;

    public abstract void zzb(String as[])
        throws RemoteException;

    public abstract Intent zzc(int i, int j, boolean flag)
        throws RemoteException;

    public abstract void zzc(long l, String s)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, long l)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, long l, String s)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s, int i)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s, String s1, boolean flag)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzc(IGamesCallbacks igamescallbacks, String as[])
        throws RemoteException;

    public abstract void zzc(String s, String s1, int i)
        throws RemoteException;

    public abstract Intent zzcY(String s)
        throws RemoteException;

    public abstract void zzd(long l, String s)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, long l)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, long l, String s)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zzd(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzd(String s, String s1, int i)
        throws RemoteException;

    public abstract String zzda(String s)
        throws RemoteException;

    public abstract String zzdb(String s)
        throws RemoteException;

    public abstract void zzdc(String s)
        throws RemoteException;

    public abstract int zzdd(String s)
        throws RemoteException;

    public abstract Uri zzde(String s)
        throws RemoteException;

    public abstract void zzdf(String s)
        throws RemoteException;

    public abstract Intent zzdg(String s)
        throws RemoteException;

    public abstract ParcelFileDescriptor zzdh(String s)
        throws RemoteException;

    public abstract void zze(long l, String s)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zze(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks, String s, int i, boolean flag, boolean flag1)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks, String s, String s1)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks, String s, boolean flag)
        throws RemoteException;

    public abstract void zzf(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzfN(int i)
        throws RemoteException;

    public abstract void zzg(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzg(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzg(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract RoomEntity zzh(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzh(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzh(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzi(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzi(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzi(IGamesCallbacks igamescallbacks, boolean flag)
        throws RemoteException;

    public abstract void zzj(IGamesCallbacks igamescallbacks)
        throws RemoteException;

    public abstract void zzj(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract ParcelFileDescriptor zzk(Uri uri)
        throws RemoteException;

    public abstract void zzk(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzl(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzm(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract Bundle zzmw()
        throws RemoteException;

    public abstract void zzn(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzo(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzp(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzq(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzq(String s, int i)
        throws RemoteException;

    public abstract void zzr(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzr(String s, int i)
        throws RemoteException;

    public abstract void zzs(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzs(String s, int i)
        throws RemoteException;

    public abstract void zzt(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract String zztH()
        throws RemoteException;

    public abstract String zztI()
        throws RemoteException;

    public abstract Intent zztL()
        throws RemoteException;

    public abstract Intent zztM()
        throws RemoteException;

    public abstract Intent zztN()
        throws RemoteException;

    public abstract Intent zztO()
        throws RemoteException;

    public abstract Intent zztT()
        throws RemoteException;

    public abstract Intent zztU()
        throws RemoteException;

    public abstract int zztV()
        throws RemoteException;

    public abstract String zztW()
        throws RemoteException;

    public abstract int zztX()
        throws RemoteException;

    public abstract Intent zztY()
        throws RemoteException;

    public abstract int zztZ()
        throws RemoteException;

    public abstract void zzu(IGamesCallbacks igamescallbacks, String s)
        throws RemoteException;

    public abstract void zzu(String s, int i)
        throws RemoteException;

    public abstract int zzua()
        throws RemoteException;

    public abstract int zzub()
        throws RemoteException;

    public abstract int zzuc()
        throws RemoteException;

    public abstract void zzud()
        throws RemoteException;

    public abstract DataHolder zzuf()
        throws RemoteException;

    public abstract boolean zzug()
        throws RemoteException;

    public abstract DataHolder zzuh()
        throws RemoteException;

    public abstract void zzui()
        throws RemoteException;

    public abstract Intent zzuj()
        throws RemoteException;

    public abstract void zzuk()
        throws RemoteException;

    public abstract boolean zzul()
        throws RemoteException;

    public abstract void zzum()
        throws RemoteException;

    public abstract Intent zzun()
        throws RemoteException;

    public abstract void zzv(String s, int i)
        throws RemoteException;

    public abstract Intent zzw(String s, int i)
        throws RemoteException;
}
