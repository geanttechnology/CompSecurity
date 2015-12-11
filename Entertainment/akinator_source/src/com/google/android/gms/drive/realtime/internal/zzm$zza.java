// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            zzm, BeginCompoundOperationRequest, EndCompoundOperationRequest, ParcelableIndexReference, 
//            zzj, zzo, zzn, zzc, 
//            zzd, zze, zzh, zzi, 
//            zzl, zzg, zzf, zzk

public static abstract class zza.zznJ extends Binder
    implements zzm
{
    private static class zza
        implements zzm
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(int i, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeInt(i);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            zzj1 = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(zzj1);
            zznJ.transact(30, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzj1 = null;
              goto _L1
            zzj1;
            parcel1.recycle();
            parcel.recycle();
            throw zzj1;
        }

        public void zza(int i, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeInt(i);
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            zzo1 = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzo1);
            zznJ.transact(50, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzo1 = null;
              goto _L1
            zzo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzo1;
        }

        public void zza(DriveId driveid, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (driveid == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            driveid.writeToParcel(parcel, 0);
_L3:
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            driveid = zzo1.asBinder();
_L4:
            parcel.writeStrongBinder(driveid);
            zznJ.transact(48, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            driveid;
            parcel1.recycle();
            parcel.recycle();
            throw driveid;
            driveid = null;
              goto _L4
        }

        public void zza(BeginCompoundOperationRequest begincompoundoperationrequest, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (begincompoundoperationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            begincompoundoperationrequest.writeToParcel(parcel, 0);
_L3:
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            begincompoundoperationrequest = zzo1.asBinder();
_L4:
            parcel.writeStrongBinder(begincompoundoperationrequest);
            zznJ.transact(18, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            begincompoundoperationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw begincompoundoperationrequest;
            begincompoundoperationrequest = null;
              goto _L4
        }

        public void zza(EndCompoundOperationRequest endcompoundoperationrequest, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (endcompoundoperationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            endcompoundoperationrequest.writeToParcel(parcel, 0);
_L3:
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            endcompoundoperationrequest = zzj1.asBinder();
_L4:
            parcel.writeStrongBinder(endcompoundoperationrequest);
            zznJ.transact(41, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            endcompoundoperationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw endcompoundoperationrequest;
            endcompoundoperationrequest = null;
              goto _L4
        }

        public void zza(EndCompoundOperationRequest endcompoundoperationrequest, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (endcompoundoperationrequest == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            endcompoundoperationrequest.writeToParcel(parcel, 0);
_L3:
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            endcompoundoperationrequest = zzo1.asBinder();
_L4:
            parcel.writeStrongBinder(endcompoundoperationrequest);
            zznJ.transact(19, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            endcompoundoperationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw endcompoundoperationrequest;
            endcompoundoperationrequest = null;
              goto _L4
        }

        public void zza(ParcelableIndexReference parcelableindexreference, zzn zzn1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (parcelableindexreference == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            parcelableindexreference.writeToParcel(parcel, 0);
_L3:
            if (zzn1 == null)
            {
                break MISSING_BLOCK_LABEL_97;
            }
            parcelableindexreference = zzn1.asBinder();
_L4:
            parcel.writeStrongBinder(parcelableindexreference);
            zznJ.transact(26, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            parcelableindexreference;
            parcel1.recycle();
            parcel.recycle();
            throw parcelableindexreference;
            parcelableindexreference = null;
              goto _L4
        }

        public void zza(zzc zzc1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzc1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            zzc1 = zzc1.asBinder();
_L1:
            parcel.writeStrongBinder(zzc1);
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzc1 = null;
              goto _L1
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
        }

        public void zza(zzd zzd1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzd1 = zzd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzd1);
            zznJ.transact(32, parcel, parcel1, 0);
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

        public void zza(com.google.android.gms.drive.realtime.internal.zze zze1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zze1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zze1 = zze1.asBinder();
_L1:
            parcel.writeStrongBinder(zze1);
            zznJ.transact(31, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zze1 = null;
              goto _L1
            zze1;
            parcel1.recycle();
            parcel.recycle();
            throw zze1;
        }

        public void zza(zzh zzh1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzh1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzh1 = zzh1.asBinder();
_L1:
            parcel.writeStrongBinder(zzh1);
            zznJ.transact(36, parcel, parcel1, 0);
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

        public void zza(zzi zzi1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzi1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzi1 = zzi1.asBinder();
_L1:
            parcel.writeStrongBinder(zzi1);
            zznJ.transact(34, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzi1 = null;
              goto _L1
            zzi1;
            parcel1.recycle();
            parcel.recycle();
            throw zzi1;
        }

        public void zza(zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzj1 = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(zzj1);
            zznJ.transact(22, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzj1 = null;
              goto _L1
            zzj1;
            parcel1.recycle();
            parcel.recycle();
            throw zzj1;
        }

        public void zza(zzl zzl1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzl1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzl1 = zzl1.asBinder();
_L1:
            parcel.writeStrongBinder(zzl1);
            zznJ.transact(40, parcel, parcel1, 0);
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

        public void zza(zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            zzo1 = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzo1);
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzo1 = null;
              goto _L1
            zzo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzo1;
        }

        public void zza(String s, int i, int j, zzg zzg1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            if (zzg1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            s = zzg1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(17, parcel, parcel1, 0);
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

        public void zza(String s, int i, int j, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeInt(j);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            s = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(11, parcel, parcel1, 0);
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

        public void zza(String s, int i, DataHolder dataholder, zzg zzg1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            if (dataholder == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L3:
            if (zzg1 == null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            s = zzg1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(16, parcel, parcel1, 0);
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

        public void zza(String s, int i, DataHolder dataholder, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            if (dataholder == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L3:
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            s = zzj1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(15, parcel, parcel1, 0);
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

        public void zza(String s, int i, zzn zzn1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            if (zzn1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s = zzn1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(46, parcel, parcel1, 0);
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

        public void zza(String s, int i, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(28, parcel, parcel1, 0);
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

        public void zza(String s, int i, String s1, int j, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeString(s1);
            parcel.writeInt(j);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            s = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(37, parcel, parcel1, 0);
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

        public void zza(String s, int i, String s1, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeInt(i);
            parcel.writeString(s1);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            s = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(10, parcel, parcel1, 0);
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

        public void zza(String s, DataHolder dataholder, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (dataholder == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L3:
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            s = zzj1.asBinder();
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

        public void zza(String s, zzf zzf1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzf1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzf1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(20, parcel, parcel1, 0);
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

        public void zza(String s, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(7, parcel, parcel1, 0);
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

        public void zza(String s, zzk zzk1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzk1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzk1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(27, parcel, parcel1, 0);
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

        public void zza(String s, zzl zzl1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzl1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            s = zzl1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(5, parcel, parcel1, 0);
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

        public void zza(String s, zzn zzn1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzn1 == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            s = zzn1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(1, parcel, parcel1, 0);
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

        public void zza(String s, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(38, parcel, parcel1, 0);
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

        public void zza(String s, String s1, DataHolder dataholder, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (dataholder == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            dataholder.writeToParcel(parcel, 0);
_L3:
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            s = zzj1.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            zznJ.transact(43, parcel, parcel1, 0);
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

        public void zza(String s, String s1, zzf zzf1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (zzf1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            s = zzf1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(4, parcel, parcel1, 0);
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

        public void zza(String s, String s1, zzg zzg1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (zzg1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s = zzg1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(21, parcel, parcel1, 0);
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

        public void zza(String s, String s1, zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(12, parcel, parcel1, 0);
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

        public void zza(boolean flag, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_78;
            }
            zzo1 = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzo1);
            zznJ.transact(47, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzo1 = null;
              goto _L1
            zzo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzo1;
        }

        public void zzb(zzc zzc1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzc1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzc1 = zzc1.asBinder();
_L1:
            parcel.writeStrongBinder(zzc1);
            zznJ.transact(33, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzc1 = null;
              goto _L1
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
        }

        public void zzb(zzj zzj1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzj1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzj1 = zzj1.asBinder();
_L1:
            parcel.writeStrongBinder(zzj1);
            zznJ.transact(23, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzj1 = null;
              goto _L1
            zzj1;
            parcel1.recycle();
            parcel.recycle();
            throw zzj1;
        }

        public void zzb(zzl zzl1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzl1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzl1 = zzl1.asBinder();
_L1:
            parcel.writeStrongBinder(zzl1);
            zznJ.transact(29, parcel, parcel1, 0);
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

        public void zzb(zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzo1 = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzo1);
            zznJ.transact(35, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzo1 = null;
              goto _L1
            zzo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzo1;
        }

        public void zzb(String s, zzf zzf1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzf1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzf1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(13, parcel, parcel1, 0);
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

        public void zzb(String s, zzl zzl1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzl1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzl1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(8, parcel, parcel1, 0);
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

        public void zzb(String s, zzn zzn1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzn1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzn1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(9, parcel, parcel1, 0);
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

        public void zzb(String s, zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(39, parcel, parcel1, 0);
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

        public void zzb(String s, String s1, zzf zzf1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            if (zzf1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            s = zzf1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(42, parcel, parcel1, 0);
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

        public void zzc(zzc zzc1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzc1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzc1 = zzc1.asBinder();
_L1:
            parcel.writeStrongBinder(zzc1);
            zznJ.transact(45, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzc1 = null;
              goto _L1
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
        }

        public void zzc(zzo zzo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzo1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzo1 = zzo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzo1);
            zznJ.transact(49, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzo1 = null;
              goto _L1
            zzo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzo1;
        }

        public void zzc(String s, zzl zzl1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            parcel.writeString(s);
            if (zzl1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = zzl1.asBinder();
_L1:
            parcel.writeStrongBinder(s);
            zznJ.transact(14, parcel, parcel1, 0);
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

        public void zzd(zzc zzc1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzc1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzc1 = zzc1.asBinder();
_L1:
            parcel.writeStrongBinder(zzc1);
            zznJ.transact(24, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzc1 = null;
              goto _L1
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
        }

        public void zze(zzc zzc1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            if (zzc1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            zzc1 = zzc1.asBinder();
_L1:
            parcel.writeStrongBinder(zzc1);
            zznJ.transact(25, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzc1 = null;
              goto _L1
            zzc1;
            parcel1.recycle();
            parcel.recycle();
            throw zzc1;
        }

        public void zzrY()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zznJ.transact(44, parcel, parcel1, 0);
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

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zzm zzbg(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        if (iinterface != null && (iinterface instanceof zzm))
        {
            return (zzm)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        String s3 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj1 = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzbh(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzaW(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 33: // '!'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(zzaW(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 35: // '#'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 40: // '('
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzbf(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 45: // '-'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzc(zzaW(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 46: // '.'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), zzbh(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readString(), zzaZ(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzbf(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            s3 = parcel.readString();
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = DataHolder.CREATOR.zzag(parcel);
            }
            zza(s3, ((DataHolder) (obj)), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzaZ(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 21: // '\025'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readString(), zzba(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(parcel.readString(), zzbf(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(parcel.readString(), zzbh(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), parcel.readString(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), parcel.readInt(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readString(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(parcel.readString(), zzaZ(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzc(parcel.readString(), zzbf(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            String s = parcel.readString();
            i = parcel.readInt();
            obj = s3;
            if (parcel.readInt() != 0)
            {
                obj = DataHolder.CREATOR.zzag(parcel);
            }
            zza(s, i, ((DataHolder) (obj)), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            String s1 = parcel.readString();
            i = parcel.readInt();
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = DataHolder.CREATOR.zzag(parcel);
            }
            zza(s1, i, ((DataHolder) (obj)), zzba(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), parcel.readInt(), zzba(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 37: // '%'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((BeginCompoundOperationRequest) (obj)), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 41: // ')'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            obj = obj4;
            if (parcel.readInt() != 0)
            {
                obj = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((EndCompoundOperationRequest) (obj)), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 22: // '\026'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 23: // '\027'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 24: // '\030'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzd(zzaW(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 25: // '\031'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zze(zzaW(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 47: // '/'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zza(flag, zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 50: // '2'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readInt(), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 26: // '\032'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            obj = obj5;
            if (parcel.readInt() != 0)
            {
                obj = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(parcel);
            }
            zza(((ParcelableIndexReference) (obj)), zzbh(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 27: // '\033'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzbe(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 28: // '\034'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), parcel.readInt(), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 29: // '\035'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(zzbf(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 30: // '\036'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readInt(), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 31: // '\037'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzaY(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 32: // ' '
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzaX(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 34: // '"'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzbc(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 36: // '$'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(zzbb(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 38: // '&'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zza(parcel.readString(), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 39: // '\''
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(parcel.readString(), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 42: // '*'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzb(parcel.readString(), parcel.readString(), zzaZ(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 43: // '+'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            String s2 = parcel.readString();
            String s4 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                obj = DataHolder.CREATOR.zzag(parcel);
            }
            zza(s2, s4, ((DataHolder) (obj)), zzbd(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 44: // ','
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzrY();
            parcel1.writeNoException();
            return true;

        case 48: // '0'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            obj = obj6;
            if (parcel.readInt() != 0)
            {
                obj = (DriveId)DriveId.CREATOR.createFromParcel(parcel);
            }
            zza(((DriveId) (obj)), zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 49: // '1'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            zzc(zzbi(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            obj = obj7;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(parcel);
        }
        zza(((EndCompoundOperationRequest) (obj)), zzbi(parcel.readStrongBinder()));
        parcel1.writeNoException();
        return true;
    }
}
