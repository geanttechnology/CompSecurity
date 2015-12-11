// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
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
//            IGamesService, IGamesCallbacks, IGamesClient

public static abstract class attachInterface extends Binder
    implements IGamesService
{
    private static class Proxy
        implements IGamesService
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zzC(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            zznJ.transact(5065, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void zzD(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            zznJ.transact(8025, parcel, parcel1, 0);
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
            zznJ.transact(5001, parcel, parcel1, 0);
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
            zznJ.transact(5059, parcel, parcel1, 0);
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
            zznJ.transact(8013, parcel, parcel1, 0);
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
            zznJ.transact(10002, parcel, parcel1, 0);
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
            zznJ.transact(12012, parcel, parcel1, 0);
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
            zznJ.transact(15502, parcel, parcel1, 0);
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
            zznJ.transact(5033, parcel, parcel1, 0);
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
            zznJ.transact(10012, parcel, parcel1, 0);
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
            zznJ.transact(15503, parcel, parcel1, 0);
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
            zznJ.transact(13005, parcel, parcel1, 0);
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
            zznJ.transact(10021, parcel, parcel1, 0);
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
            zznJ.transact(10022, parcel, parcel1, 0);
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
            zznJ.transact(9011, parcel, parcel1, 0);
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
            zznJ.transact(12001, parcel, parcel1, 0);
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
            zznJ.transact(9031, parcel, parcel1, 0);
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
            zznJ.transact(14003, parcel, parcel1, 0);
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
            zznJ.transact(5005, parcel, parcel1, 0);
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
            zznJ.transact(12019, parcel, parcel1, 0);
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
            zznJ.transact(5002, parcel, parcel1, 0);
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
            zznJ.transact(10016, parcel, parcel1, 0);
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
            zznJ.transact(10009, parcel, parcel1, 0);
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
            zznJ.transact(5044, parcel, parcel1, 0);
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
            zznJ.transact(8004, parcel, parcel1, 0);
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
            zznJ.transact(14002, parcel, parcel1, 0);
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
            zznJ.transact(5015, parcel, parcel1, 0);
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
            zznJ.transact(10018, parcel, parcel1, 0);
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
            zznJ.transact(5058, parcel, parcel1, 0);
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
            zznJ.transact(8018, parcel, parcel1, 0);
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
            zznJ.transact(5021, parcel, parcel1, 0);
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
            zznJ.transact(5030, parcel, parcel1, 0);
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
            zznJ.transact(5031, parcel, parcel1, 0);
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
            zznJ.transact(5014, parcel, parcel1, 0);
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
            zznJ.transact(10011, parcel, parcel1, 0);
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
            zznJ.transact(5019, parcel, parcel1, 0);
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
            zznJ.transact(5025, parcel, parcel1, 0);
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
            zznJ.transact(8023, parcel, parcel1, 0);
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
            zznJ.transact(5045, parcel, parcel1, 0);
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
            zznJ.transact(6501, parcel, parcel1, 0);
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
            zznJ.transact(10019, parcel, parcel1, 0);
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
            zznJ.transact(5016, parcel, parcel1, 0);
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
            zznJ.transact(7002, parcel, parcel1, 0);
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
            zznJ.transact(5023, parcel, parcel1, 0);
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
            zznJ.transact(12007, parcel, parcel1, 0);
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
            zznJ.transact(5038, parcel, parcel1, 0);
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
            zznJ.transact(8001, parcel, parcel1, 0);
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
            zznJ.transact(10010, parcel, parcel1, 0);
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
            zznJ.transact(5039, parcel, parcel1, 0);
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
            zznJ.transact(9028, parcel, parcel1, 0);
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
            zznJ.transact(12033, parcel, parcel1, 0);
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
            zznJ.transact(6002, parcel, parcel1, 0);
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
            zznJ.transact(12015, parcel, parcel1, 0);
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
            zznJ.transact(10008, parcel, parcel1, 0);
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
            zznJ.transact(12028, parcel, parcel1, 0);
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
            zznJ.transact(5054, parcel, parcel1, 0);
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
            zznJ.transact(15001, parcel, parcel1, 0);
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
            zznJ.transact(8007, parcel, parcel1, 0);
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
            zznJ.transact(8008, parcel, parcel1, 0);
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
            zznJ.transact(8017, parcel, parcel1, 0);
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
            zznJ.transact(10005, parcel, parcel1, 0);
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
            zznJ.transact(6001, parcel, parcel1, 0);
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
            zznJ.transact(5063, parcel, parcel1, 0);
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
            zznJ.transact(12031, parcel, parcel1, 0);
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
            zznJ.transact(8003, parcel, parcel1, 0);
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
            zznJ.transact(12010, parcel, parcel1, 0);
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
            zznJ.transact(10006, parcel, parcel1, 0);
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
            zznJ.transact(12029, parcel, parcel1, 0);
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
            zznJ.transact(15501, parcel, parcel1, 0);
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
            zznJ.transact(13002, parcel, parcel1, 0);
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
            zznJ.transact(5068, parcel, parcel1, 0);
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
            zznJ.transact(12026, parcel, parcel1, 0);
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

        public void zzaf(boolean flag)
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
            zznJ.transact(13001, parcel, parcel1, 0);
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
            zznJ.transact(5034, parcel, parcel1, 0);
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
            zznJ.transact(9008, parcel, parcel1, 0);
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
            zznJ.transact(12030, parcel, parcel1, 0);
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
            zznJ.transact(8019, parcel, parcel1, 0);
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
            zznJ.transact(5017, parcel, parcel1, 0);
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
            zznJ.transact(5046, parcel, parcel1, 0);
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
            zznJ.transact(8012, parcel, parcel1, 0);
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
            zznJ.transact(8020, parcel, parcel1, 0);
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
            zznJ.transact(5018, parcel, parcel1, 0);
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
            zznJ.transact(12023, parcel, parcel1, 0);
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
            zznJ.transact(5020, parcel, parcel1, 0);
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
            zznJ.transact(7003, parcel, parcel1, 0);
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
            zznJ.transact(10017, parcel, parcel1, 0);
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
            zznJ.transact(5501, parcel, parcel1, 0);
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
            zznJ.transact(5024, parcel, parcel1, 0);
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
            zznJ.transact(5041, parcel, parcel1, 0);
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
            zznJ.transact(5040, parcel, parcel1, 0);
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
            zznJ.transact(12018, parcel, parcel1, 0);
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
            zznJ.transact(6506, parcel, parcel1, 0);
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
            zznJ.transact(6502, parcel, parcel1, 0);
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
            zznJ.transact(6503, parcel, parcel1, 0);
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
            zznJ.transact(10007, parcel, parcel1, 0);
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
            zznJ.transact(15002, parcel, parcel1, 0);
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
            zznJ.transact(9009, parcel, parcel1, 0);
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
            zznJ.transact(8021, parcel, parcel1, 0);
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
            zznJ.transact(5022, parcel, parcel1, 0);
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
            zznJ.transact(5048, parcel, parcel1, 0);
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
            zznJ.transact(10001, parcel, parcel1, 0);
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
            zznJ.transact(10003, parcel, parcel1, 0);
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
            zznJ.transact(5032, parcel, parcel1, 0);
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
            zznJ.transact(12024, parcel, parcel1, 0);
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
            zznJ.transact(9001, parcel, parcel1, 0);
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
            zznJ.transact(8011, parcel, parcel1, 0);
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
            zznJ.transact(12003, parcel, parcel1, 0);
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
            zznJ.transact(6504, parcel, parcel1, 0);
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
            zznJ.transact(8027, parcel, parcel1, 0);
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
            zznJ.transact(10020, parcel, parcel1, 0);
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
            zznJ.transact(5051, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzcX(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(12034, parcel, parcel1, 0);
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

        public String zzcZ(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(5064, parcel, parcel1, 0);
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
            zznJ.transact(10004, parcel, parcel1, 0);
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
            zznJ.transact(5026, parcel, parcel1, 0);
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
            zznJ.transact(6003, parcel, parcel1, 0);
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
            zznJ.transact(12011, parcel, parcel1, 0);
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
            zznJ.transact(12013, parcel, parcel1, 0);
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
            zznJ.transact(5037, parcel, parcel1, 0);
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
            zznJ.transact(9020, parcel, parcel1, 0);
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
            zznJ.transact(8015, parcel, parcel1, 0);
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
            zznJ.transact(6505, parcel, parcel1, 0);
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
            zznJ.transact(12002, parcel, parcel1, 0);
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
            zznJ.transact(8026, parcel, parcel1, 0);
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
            zznJ.transact(5035, parcel, parcel1, 0);
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

        public void zzdb(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(5050, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public int zzdc(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(5060, parcel, parcel1, 0);
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

        public Uri zzdd(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(5066, parcel, parcel1, 0);
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

        public void zzde(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(8002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzdf(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(9004, parcel, parcel1, 0);
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

        public ParcelFileDescriptor zzdg(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            zznJ.transact(9030, parcel, parcel1, 0);
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
            zznJ.transact(12014, parcel, parcel1, 0);
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
            zznJ.transact(5027, parcel, parcel1, 0);
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
            zznJ.transact(6004, parcel, parcel1, 0);
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
            zznJ.transact(5042, parcel, parcel1, 0);
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
            zznJ.transact(12021, parcel, parcel1, 0);
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
            zznJ.transact(8016, parcel, parcel1, 0);
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
            zznJ.transact(12006, parcel, parcel1, 0);
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
            zznJ.transact(12032, parcel, parcel1, 0);
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
            zznJ.transact(5047, parcel, parcel1, 0);
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
            zznJ.transact(5043, parcel, parcel1, 0);
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
            zznJ.transact(12022, parcel, parcel1, 0);
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
            zznJ.transact(12009, parcel, parcel1, 0);
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
            zznJ.transact(13006, parcel, parcel1, 0);
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
            zznJ.transact(12016, parcel, parcel1, 0);
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

        public void zzfW(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i);
            zznJ.transact(5036, parcel, parcel1, 0);
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
            zznJ.transact(5049, parcel, parcel1, 0);
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
            zznJ.transact(5052, parcel, parcel1, 0);
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
            zznJ.transact(13003, parcel, parcel1, 0);
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
            zznJ.transact(5053, parcel, parcel1, 0);
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
            zznJ.transact(5056, parcel, parcel1, 0);
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
            zznJ.transact(13004, parcel, parcel1, 0);
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
            zznJ.transact(5062, parcel, parcel1, 0);
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
            zznJ.transact(5061, parcel, parcel1, 0);
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
            zznJ.transact(17001, parcel, parcel1, 0);
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
            zznJ.transact(11001, parcel, parcel1, 0);
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
            zznJ.transact(5057, parcel, parcel1, 0);
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
            zznJ.transact(6507, parcel, parcel1, 0);
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
            zznJ.transact(7001, parcel, parcel1, 0);
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
            zznJ.transact(8005, parcel, parcel1, 0);
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

        public Intent zzm(String s, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            zznJ.transact(18001, parcel, parcel1, 0);
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
            zznJ.transact(8006, parcel, parcel1, 0);
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

        public Bundle zzmS()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5004, parcel, parcel1, 0);
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
            zznJ.transact(8009, parcel, parcel1, 0);
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
            zznJ.transact(8010, parcel, parcel1, 0);
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
            zznJ.transact(8014, parcel, parcel1, 0);
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

        public void zzp(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznJ.transact(12017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
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
            zznJ.transact(9002, parcel, parcel1, 0);
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
            zznJ.transact(5029, parcel, parcel1, 0);
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
            zznJ.transact(12020, parcel, parcel1, 0);
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
            zznJ.transact(5028, parcel, parcel1, 0);
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
            zznJ.transact(12005, parcel, parcel1, 0);
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
            zznJ.transact(12027, parcel, parcel1, 0);
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

        public void zzt(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznJ.transact(5055, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
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
            zznJ.transact(12008, parcel, parcel1, 0);
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
            zznJ.transact(10014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Intent zzuB()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9003, parcel, parcel1, 0);
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

        public Intent zzuC()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9005, parcel, parcel1, 0);
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

        public Intent zzuD()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9006, parcel, parcel1, 0);
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

        public Intent zzuE()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9007, parcel, parcel1, 0);
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

        public Intent zzuJ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9010, parcel, parcel1, 0);
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

        public Intent zzuK()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9012, parcel, parcel1, 0);
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

        public int zzuL()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9019, parcel, parcel1, 0);
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

        public String zzuM()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5003, parcel, parcel1, 0);
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

        public int zzuN()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(8024, parcel, parcel1, 0);
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

        public Intent zzuO()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(10015, parcel, parcel1, 0);
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

        public int zzuP()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(10013, parcel, parcel1, 0);
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

        public int zzuQ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(10023, parcel, parcel1, 0);
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

        public int zzuR()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(12035, parcel, parcel1, 0);
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

        public int zzuS()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(12036, parcel, parcel1, 0);
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

        public void zzuT()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5006, parcel, parcel1, 0);
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

        public DataHolder zzuV()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5013, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.zzag(parcel1);
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

        public boolean zzuW()
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
            zznJ.transact(5067, parcel, parcel1, 0);
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

        public DataHolder zzuX()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5502, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.zzag(parcel1);
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

        public void zzuY()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(8022, parcel, parcel1, 0);
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

        public Intent zzuZ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(9013, parcel, parcel1, 0);
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

        public String zzux()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5007, parcel, parcel1, 0);
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

        public String zzuy()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(5012, parcel, parcel1, 0);
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

        public Intent zzv(String s, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i);
            zznJ.transact(14001, parcel, parcel1, 0);
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

        public void zzva()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            zznJ.transact(11002, parcel, parcel1, 0);
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

        public boolean zzvb()
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
            zznJ.transact(12025, parcel, parcel1, 0);
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

        public void zzvc()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            p