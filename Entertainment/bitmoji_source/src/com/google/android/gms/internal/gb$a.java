// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolderCreator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;

// Referenced classes of package com.google.android.gms.internal:
//            gb, gz, ha, gy, 
//            gx, ga

public static abstract class a.ky extends Binder
    implements gb
{
    private static class a
        implements gb
    {

        private IBinder ky;

        public int a(ga ga1, byte abyte0[], String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            ga1 = ga1.asBinder();
_L1:
            int i1;
            parcel.writeStrongBinder(ga1);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(5033, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public Intent a(int i1, int j1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(9008, parcel, parcel1, 0);
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

        public Intent a(int i1, byte abyte0[], int j1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i1);
            parcel.writeByteArray(abyte0);
            parcel.writeInt(j1);
            parcel.writeString(s);
            ky.transact(10012, parcel, parcel1, 0);
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

        public Intent a(RoomEntity roomentity, int i1)
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
            parcel.writeInt(i1);
            ky.transact(9011, parcel, parcel1, 0);
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

        public Intent a(gy gy1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (gy1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            gy1.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(10021, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            gy1 = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return gy1;
_L2:
            parcel.writeInt(0);
              goto _L3
            gy1;
            parcel1.recycle();
            parcel.recycle();
            throw gy1;
            gy1 = null;
              goto _L4
        }

        public Intent a(gz gz1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (gz1 == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            gz1.writeToParcel(parcel, 0);
_L3:
            parcel.writeString(s);
            ky.transact(10022, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            gz1 = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return gz1;
_L2:
            parcel.writeInt(0);
              goto _L3
            gz1;
            parcel1.recycle();
            parcel.recycle();
            throw gz1;
            gz1 = null;
              goto _L4
        }

        public Intent a(ParticipantEntity aparticipantentity[], String s, String s1, Uri uri, Uri uri1)
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
            ky.transact(9031, parcel, parcel1, 0);
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

        public void a(long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(8019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void a(IBinder ibinder, Bundle bundle)
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
            ky.transact(5005, parcel, parcel1, 0);
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

        public void a(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            ky.transact(10016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, int i1, int j1, int k1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            ky.transact(10009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, int i1, int j1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5044, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, int i1, int j1, String as[], Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(8004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void a(ga ga1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, int i1, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            parcel.writeIntArray(ai);
            ky.transact(10018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            ky.transact(5058, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(8018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, Bundle bundle, int i1, int j1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            ky.transact(5021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void a(ga ga1, IBinder ibinder, int i1, String as[], Bundle bundle, boolean flag, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L6:
            parcel.writeStrongBinder(ga1);
            parcel.writeStrongBinder(ibinder);
            parcel.writeInt(i1);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
              goto _L5
_L7:
            parcel.writeInt(i1);
            parcel.writeLong(l1);
            ky.transact(5030, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L6
_L4:
            parcel.writeInt(0);
              goto _L5
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
_L9:
            i1 = 0;
              goto _L7
_L5:
            if (!flag) goto _L9; else goto _L8
_L8:
            i1 = ((flag1) ? 1 : 0);
              goto _L7
        }

        public void a(ga ga1, IBinder ibinder, String s, boolean flag, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeStrongBinder(ibinder);
            parcel.writeString(s);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            parcel.writeLong(l1);
            ky.transact(5031, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            ky.transact(10011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(5025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void a(ga ga1, String s, int i1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(8023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5045, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag4;
            flag4 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag2)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag3)
            {
                i1 = ((flag4) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(6501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int i1, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            parcel.writeIntArray(ai);
            ky.transact(10019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeLong(l1);
            ky.transact(5016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, long l1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeLong(l1);
            parcel.writeString(s1);
            ky.transact(7002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(5023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void a(ga ga1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(5038, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, int i1, int j1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            ky.transact(8001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, int i1, int j1, int k1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            ky.transact(10010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5039, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(9028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String s1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            ky.transact(10008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5054, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, byte abyte0[], String s1, ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s1);
            parcel.writeTypedArray(aparticipantresult, 0);
            ky.transact(8007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, byte abyte0[], ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            parcel.writeTypedArray(aparticipantresult, 0);
            ky.transact(8008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeIntArray(ai);
            ky.transact(8017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String s, String as[], int i1, byte abyte0[], int j1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            parcel.writeInt(i1);
            parcel.writeByteArray(abyte0);
            parcel.writeInt(j1);
            ky.transact(10005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, boolean flag, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            if (!flag)
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(5063, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void a(ga ga1, int ai[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeIntArray(ai);
            ky.transact(8003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void a(ga ga1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeStringArray(as);
            ky.transact(10006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public int aA(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(5060, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Uri aB(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(5066, parcel, parcel1, 0);
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

        public void aC(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(8002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public ParcelFileDescriptor aD(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(9030, parcel, parcel1, 0);
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

        public void aU(int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i1);
            ky.transact(5036, parcel, parcel1, 0);
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

        public IBinder asBinder()
        {
            return ky;
        }

        public Intent au(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(9004, parcel, parcel1, 0);
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

        public String ax(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(5064, parcel, parcel1, 0);
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

        public String ay(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(5035, parcel, parcel1, 0);
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

        public void az(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            ky.transact(5050, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public int b(byte abyte0[], String s, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeByteArray(abyte0);
            parcel.writeString(s);
            parcel.writeStringArray(as);
            ky.transact(5034, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            abyte0;
            parcel1.recycle();
            parcel.recycle();
            throw abyte0;
        }

        public Intent b(int i1, int j1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(9009, parcel, parcel1, 0);
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

        public void b(long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(8021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void b(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5046, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            ky.transact(8012, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(8020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, int i1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(7003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void b(ga ga1, String s, int i1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(10017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null) goto _L2; else goto _L1
_L1:
            ga1 = ga1.asBinder();
_L5:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            ky.transact(5024, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            ga1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
              goto _L5
        }

        public void b(ga ga1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(5041, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, String s1, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5040, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6506, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6502, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6503, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(ga ga1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeStringArray(as);
            ky.transact(10007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void b(String s, String s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            ky.transact(5051, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void c(long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(10004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void c(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5022, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(5048, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            ky.transact(10001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, long l1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeLong(l1);
            parcel.writeString(s);
            ky.transact(10003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5032, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, String s, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(9001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(8011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6504, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(8027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(ga ga1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeStringArray(as);
            ky.transact(10020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void c(String s, String s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            ky.transact(8026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public Bundle cY()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5004, parcel, parcel1, 0);
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

        public void d(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void d(ga ga1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(6003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void d(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5037, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void d(ga ga1, String s, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(9020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void d(ga ga1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(8015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void d(ga ga1, String s, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(6505, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public ParcelFileDescriptor e(Uri uri)
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
            ky.transact(6507, parcel, parcel1, 0);
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

        public void e(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void e(ga ga1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeInt(i1);
            if (flag)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            if (flag1)
            {
                i1 = ((flag2) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            ky.transact(6004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void e(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5042, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void e(ga ga1, String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(8016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void f(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5047, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void f(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5043, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public int fA()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9019, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String fB()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5003, parcel, parcel1, 0);
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

        public int fC()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(8024, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent fD()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(10015, parcel, parcel1, 0);
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

        public int fE()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(10013, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public int fF()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(10023, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void fH()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5006, parcel, parcel1, 0);
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

        public DataHolder fI()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5013, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.createFromParcel(parcel1);
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

        public boolean fJ()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5067, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            if (i1 != 0)
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

        public DataHolder fK()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5502, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            DataHolder dataholder = DataHolder.CREATOR.createFromParcel(parcel1);
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

        public void fL()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(8022, parcel, parcel1, 0);
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

        public Intent fM()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9013, parcel, parcel1, 0);
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

        public String fn()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5007, parcel, parcel1, 0);
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

        public String fo()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(5012, parcel, parcel1, 0);
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

        public Intent fr()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9003, parcel, parcel1, 0);
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

        public Intent fs()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9005, parcel, parcel1, 0);
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

        public Intent ft()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9006, parcel, parcel1, 0);
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

        public Intent fu()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9007, parcel, parcel1, 0);
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

        public Intent fy()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9010, parcel, parcel1, 0);
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

        public Intent fz()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            ky.transact(9012, parcel, parcel1, 0);
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

        public void g(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5049, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void g(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5052, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public DataHolder h(ga ga1, String s)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5053, parcel, parcel1, 0);
            parcel1.readException();
            ga1 = obj;
            if (parcel1.readInt() != 0)
            {
                ga1 = DataHolder.CREATOR.createFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return ga1;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void h(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5056, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void i(ga ga1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            ky.transact(5062, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void i(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5061, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void j(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(5057, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void j(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(5065, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void k(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(7001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void k(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeString(s1);
            ky.transact(8025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void l(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(8005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void l(String s, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i1);
            ky.transact(5029, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void m(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(8006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void m(String s, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i1);
            ky.transact(5028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void n(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            ky.transact(5001, parcel, parcel1, 0);
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

        public void n(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(8009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void n(String s, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i1);
            ky.transact(5055, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void o(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            ky.transact(5059, parcel, parcel1, 0);
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

        public void o(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(8010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void o(String s, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s);
            parcel.writeInt(i1);
            ky.transact(10014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void p(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            ky.transact(8013, parcel, parcel1, 0);
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

        public void p(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(8014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void q(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            ky.transact(10002, parcel, parcel1, 0);
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

        public void q(ga ga1, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (ga1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ga1 = ga1.asBinder();
_L1:
            parcel.writeStrongBinder(ga1);
            parcel.writeString(s);
            ky.transact(9002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            ga1 = null;
              goto _L1
            ga1;
            parcel1.recycle();
            parcel.recycle();
            throw ga1;
        }

        public void y(boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            ky.transact(5068, parcel, parcel1, 0);
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

        a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public static gb J(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (iinterface != null && (iinterface instanceof gb))
        {
            return (gb)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj3 = null;
        Object obj4 = null;
        Object obj = null;
        boolean flag = false;
        boolean flag49 = false;
        boolean flag50 = false;
        boolean flag43 = false;
        boolean flag46 = false;
        boolean flag51 = false;
        int k = 0;
        boolean flag52 = false;
        boolean flag53 = false;
        boolean flag54 = false;
        boolean flag55 = false;
        boolean flag47 = false;
        boolean flag48 = false;
        boolean flag45 = false;
        boolean flag56 = false;
        boolean flag57 = false;
        boolean flag58 = false;
        boolean flag59 = false;
        boolean flag60 = false;
        boolean flag61 = false;
        boolean flag62 = false;
        boolean flag63 = false;
        boolean flag31 = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.games.internal.IGamesService");
            return true;

        case 5001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            n(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fB();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = cY();
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
            a(((IBinder) (obj)), parcel);
            parcel1.writeNoException();
            return true;

        case 5006: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fH();
            parcel1.writeNoException();
            return true;

        case 5007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fn();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5064: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = ax(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5065: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            j(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fo();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5013: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fI();
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
            a(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            i = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readInt() != 0)
            {
                flag31 = true;
            }
            a(((ga) (obj)), i, flag, flag31);
            parcel1.writeNoException();
            return true;

        case 5016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5018: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((ga) (obj)), ((String) (obj3)), i, j, k, flag);
            parcel1.writeNoException();
            return true;

        case 5020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b(((ga) (obj)), ((String) (obj3)), i, j, k, flag);
            parcel1.writeNoException();
            return true;

        case 5021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj3 = I(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                obj = null;
            }
            a(((ga) (obj3)), ((Bundle) (obj)), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5022: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(((ga) (obj)), ((String) (obj3)), ((IBinder) (obj4)), parcel);
            parcel1.writeNoException();
            return true;

        case 5024: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            b(((ga) (obj)), ((String) (obj3)), ((IBinder) (obj4)), parcel);
            parcel1.writeNoException();
            return true;

        case 5025: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            obj4 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(((ga) (obj)), ((String) (obj3)), i, ((IBinder) (obj4)), parcel);
            parcel1.writeNoException();
            return true;

        case 5026: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5027: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5028: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            m(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5029: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            l(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5058: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5059: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            o(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5030: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj3 = I(parcel.readStrongBinder());
            obj4 = parcel.readStrongBinder();
            i = parcel.readInt();
            String as[] = parcel.createStringArray();
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0)
            {
                flag = true;
            }
            a(((ga) (obj3)), ((IBinder) (obj4)), i, as, ((Bundle) (obj)), flag, parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5031: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga = I(parcel.readStrongBinder());
            obj3 = parcel.readStrongBinder();
            obj4 = parcel.readString();
            boolean flag1;
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a(ga, ((IBinder) (obj3)), ((String) (obj4)), flag1, parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5032: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5033: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = a(I(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5034: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = b(parcel.createByteArray(), parcel.readString(), parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5035: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = ay(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5036: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            aU(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5037: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5038: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5039: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga1 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            boolean flag2 = flag49;
            if (parcel.readInt() != 0)
            {
                flag2 = true;
            }
            a(ga1, ((String) (obj3)), ((String) (obj4)), i, j, k, flag2);
            parcel1.writeNoException();
            return true;

        case 5040: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga2 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            boolean flag3 = flag50;
            if (parcel.readInt() != 0)
            {
                flag3 = true;
            }
            b(ga2, ((String) (obj3)), ((String) (obj4)), i, j, k, flag3);
            parcel1.writeNoException();
            return true;

        case 5041: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5042: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5043: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5044: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga3 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            j = parcel.readInt();
            boolean flag4;
            boolean flag32;
            if (parcel.readInt() != 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag32 = true;
            } else
            {
                flag32 = false;
            }
            a(ga3, i, j, flag4, flag32);
            parcel1.writeNoException();
            return true;

        case 5045: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga4 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag5;
            boolean flag33;
            if (parcel.readInt() != 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag33 = true;
            } else
            {
                flag33 = false;
            }
            a(ga4, ((String) (obj3)), i, flag5, flag33);
            parcel1.writeNoException();
            return true;

        case 5046: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga5 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag6;
            boolean flag34;
            if (parcel.readInt() != 0)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            flag34 = flag43;
            if (parcel.readInt() != 0)
            {
                flag34 = true;
            }
            b(ga5, i, flag6, flag34);
            parcel1.writeNoException();
            return true;

        case 5047: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5048: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga6 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag7;
            boolean flag35;
            if (parcel.readInt() != 0)
            {
                flag7 = true;
            } else
            {
                flag7 = false;
            }
            flag35 = flag46;
            if (parcel.readInt() != 0)
            {
                flag35 = true;
            }
            c(ga6, i, flag7, flag35);
            parcel1.writeNoException();
            return true;

        case 5049: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            g(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5050: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            az(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5051: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5052: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            g(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5053: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = h(I(parcel.readStrongBinder()), parcel.readString());
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
            i = aA(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5054: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga7 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            boolean flag8 = flag51;
            if (parcel.readInt() != 0)
            {
                flag8 = true;
            }
            a(ga7, ((String) (obj3)), flag8);
            parcel1.writeNoException();
            return true;

        case 5061: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5055: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            n(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5067: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean flag9 = fJ();
            parcel1.writeNoException();
            i = k;
            if (flag9)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 5068: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean flag10 = flag52;
            if (parcel.readInt() != 0)
            {
                flag10 = true;
            }
            y(flag10);
            parcel1.writeNoException();
            return true;

        case 5056: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            h(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5057: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            j(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5062: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i(I(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5063: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga8 = I(parcel.readStrongBinder());
            boolean flag11 = flag53;
            if (parcel.readInt() != 0)
            {
                flag11 = true;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(ga8, flag11, parcel);
            parcel1.writeNoException();
            return true;

        case 5066: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = aB(parcel.readString());
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
            ga ga9 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag12;
            boolean flag36;
            if (parcel.readInt() != 0)
            {
                flag12 = true;
            } else
            {
                flag12 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag36 = true;
            } else
            {
                flag36 = false;
            }
            b(ga9, ((String) (obj3)), i, flag12, flag36);
            parcel1.writeNoException();
            return true;

        case 5502: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fK();
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
            ga ga10 = I(parcel.readStrongBinder());
            boolean flag13 = flag54;
            if (parcel.readInt() != 0)
            {
                flag13 = true;
            }
            a(ga10, flag13);
            parcel1.writeNoException();
            return true;

        case 6002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga11 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readString();
            boolean flag14 = flag55;
            if (parcel.readInt() != 0)
            {
                flag14 = true;
            }
            a(ga11, ((String) (obj3)), ((String) (obj4)), flag14);
            parcel1.writeNoException();
            return true;

        case 6003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga12 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag15;
            boolean flag37;
            if (parcel.readInt() != 0)
            {
                flag15 = true;
            } else
            {
                flag15 = false;
            }
            flag37 = flag47;
            if (parcel.readInt() != 0)
            {
                flag37 = true;
            }
            d(ga12, i, flag15, flag37);
            parcel1.writeNoException();
            return true;

        case 6004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga13 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag16;
            boolean flag38;
            if (parcel.readInt() != 0)
            {
                flag16 = true;
            } else
            {
                flag16 = false;
            }
            flag38 = flag48;
            if (parcel.readInt() != 0)
            {
                flag38 = true;
            }
            e(ga13, i, flag16, flag38);
            parcel1.writeNoException();
            return true;

        case 6501: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga14 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag17;
            boolean flag39;
            boolean flag44;
            if (parcel.readInt() != 0)
            {
                flag17 = true;
            } else
            {
                flag17 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag39 = true;
            } else
            {
                flag39 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag44 = true;
            } else
            {
                flag44 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag45 = true;
            }
            a(ga14, ((String) (obj3)), i, flag17, flag39, flag44, flag45);
            parcel1.writeNoException();
            return true;

        case 6502: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga15 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            boolean flag18 = flag56;
            if (parcel.readInt() != 0)
            {
                flag18 = true;
            }
            b(ga15, ((String) (obj3)), flag18);
            parcel1.writeNoException();
            return true;

        case 6503: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga16 = I(parcel.readStrongBinder());
            boolean flag19 = flag57;
            if (parcel.readInt() != 0)
            {
                flag19 = true;
            }
            b(ga16, flag19);
            parcel1.writeNoException();
            return true;

        case 6504: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga17 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            boolean flag20 = flag58;
            if (parcel.readInt() != 0)
            {
                flag20 = true;
            }
            c(ga17, ((String) (obj3)), flag20);
            parcel1.writeNoException();
            return true;

        case 6505: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga18 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            boolean flag21 = flag59;
            if (parcel.readInt() != 0)
            {
                flag21 = true;
            }
            d(ga18, ((String) (obj3)), flag21);
            parcel1.writeNoException();
            return true;

        case 6506: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga19 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readString();
            boolean flag22 = flag60;
            if (parcel.readInt() != 0)
            {
                flag22 = true;
            }
            b(ga19, ((String) (obj3)), ((String) (obj4)), flag22);
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
            parcel = e(parcel);
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
            k(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 7002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 7003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga20 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            obj4 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            b(ga20, ((String) (obj3)), i, ((IBinder) (obj4)), parcel);
            parcel1.writeNoException();
            return true;

        case 8001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            aC(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 8004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga21 = I(parcel.readStrongBinder());
            i = parcel.readInt();
            j = parcel.readInt();
            obj3 = parcel.createStringArray();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(ga21, i, j, ((String []) (obj3)), parcel);
            parcel1.writeNoException();
            return true;

        case 8005: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            l(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8006: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            m(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readString(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
            parcel1.writeNoException();
            return true;

        case 8008: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
            parcel1.writeNoException();
            return true;

        case 8009: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            n(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8010: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            o(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8011: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 8013: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            p(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 8014: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            p(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8024: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = fC();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 8025: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            k(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 8026: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8018: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8022: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fL();
            parcel1.writeNoException();
            return true;

        case 8023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga22 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag23 = flag61;
            if (parcel.readInt() != 0)
            {
                flag23 = true;
            }
            a(ga22, ((String) (obj3)), i, flag23);
            parcel1.writeNoException();
            return true;

        case 8027: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga23 = I(parcel.readStrongBinder());
            boolean flag24 = flag62;
            if (parcel.readInt() != 0)
            {
                flag24 = true;
            }
            c(ga23, flag24);
            parcel1.writeNoException();
            return true;

        case 9001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga24 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag25;
            boolean flag40;
            if (parcel.readInt() != 0)
            {
                flag25 = true;
            } else
            {
                flag25 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag40 = true;
            } else
            {
                flag40 = false;
            }
            c(ga24, ((String) (obj3)), i, flag25, flag40);
            parcel1.writeNoException();
            return true;

        case 9002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            q(I(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 9003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fr();
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
            parcel = au(parcel.readString());
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
            parcel = fs();
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
            parcel = ft();
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
            parcel = fu();
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
            boolean flag26;
            if (parcel.readInt() != 0)
            {
                flag26 = true;
            } else
            {
                flag26 = false;
            }
            parcel = a(i, j, flag26);
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
            boolean flag27;
            if (parcel.readInt() != 0)
            {
                flag27 = true;
            } else
            {
                flag27 = false;
            }
            parcel = b(i, j, flag27);
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
            parcel = fy();
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
            RoomEntity roomentity;
            if (parcel.readInt() != 0)
            {
                roomentity = (RoomEntity)RoomEntity.CREATOR.createFromParcel(parcel);
            } else
            {
                roomentity = null;
            }
            parcel = a(roomentity, parcel.readInt());
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
            parcel = fz();
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
            parcel = fM();
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
            obj3 = (ParticipantEntity[])parcel.createTypedArray(ParticipantEntity.CREATOR);
            obj4 = parcel.readString();
            String s1 = parcel.readString();
            Uri uri;
            if (parcel.readInt() != 0)
            {
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            } else
            {
                uri = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Uri)Uri.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            parcel = a(((ParticipantEntity []) (obj3)), ((String) (obj4)), s1, uri, parcel);
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
            i = fA();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 9020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga25 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            i = parcel.readInt();
            boolean flag28;
            boolean flag41;
            if (parcel.readInt() != 0)
            {
                flag28 = true;
            } else
            {
                flag28 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag41 = true;
            } else
            {
                flag41 = false;
            }
            d(ga25, ((String) (obj3)), i, flag28, flag41);
            parcel1.writeNoException();
            return true;

        case 9028: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga26 = I(parcel.readStrongBinder());
            obj3 = parcel.readString();
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag29;
            boolean flag42;
            if (parcel.readInt() != 0)
            {
                flag29 = true;
            } else
            {
                flag29 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag42 = true;
            } else
            {
                flag42 = false;
            }
            a(ga26, ((String) (obj3)), ((String) (obj4)), i, flag29, flag42);
            parcel1.writeNoException();
            return true;

        case 9030: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = aD(parcel.readString());
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
            c(I(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 10002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            q(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 10003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(I(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 10004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 10005: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10006: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 10007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(I(parcel.readStrongBinder()), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 10008: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray());
            parcel1.writeNoException();
            return true;

        case 10009: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10010: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10011: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = a(parcel.readInt(), parcel.createByteArray(), parcel.readInt(), parcel.readString());
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
            i = fE();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 10023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = fF();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 10015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = fD();
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
            Object obj1 = obj3;
            if (parcel.readInt() != 0)
            {
                obj1 = gz.CREATOR.am(parcel);
            }
            parcel = a(((gz) (obj1)), parcel.readString());
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
            o(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 10017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ga ga27 = I(parcel.readStrongBinder());
            String s = parcel.readString();
            i = parcel.readInt();
            boolean flag30 = flag63;
            if (parcel.readInt() != 0)
            {
                flag30 = true;
            }
            b(ga27, s, i, flag30);
            parcel1.writeNoException();
            return true;

        case 10021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            Object obj2 = obj4;
            if (parcel.readInt() != 0)
            {
                obj2 = gy.CREATOR.al(parcel);
            }
            parcel = a(((gy) (obj2)), parcel.readString(), parcel.readString());
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
            a(I(parcel.readStrongBinder()), parcel.readInt(), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 10019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(I(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 10020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(I(parcel.readStrongBinder()), parcel.createStringArray());
            parcel1.writeNoException();
            return true;
        }
    }
}
