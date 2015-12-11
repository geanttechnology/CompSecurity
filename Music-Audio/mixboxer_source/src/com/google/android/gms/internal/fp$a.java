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
//            fp, fo

public static abstract class a.dU extends Binder
    implements fp
{
    private static class a
        implements fp
    {

        private IBinder dU;

        public int a(fo fo1, byte abyte0[], String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            fo1 = fo1.asBinder();
_L1:
            int i1;
            parcel.writeStrongBinder(fo1);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(5033, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
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
            dU.transact(9011, parcel, parcel1, 0);
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

        public Intent a(ParticipantEntity aparticipantentity[], String s1, String s2, Uri uri, Uri uri1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeTypedArray(aparticipantentity, 0);
            parcel.writeString(s1);
            parcel.writeString(s2);
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
            dU.transact(9031, parcel, parcel1, 0);
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

        public void a(long l1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            parcel.writeString(s1);
            dU.transact(8019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
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
            dU.transact(5005, parcel, parcel1, 0);
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

        public void a(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, int i1, int j1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5044, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, int i1, int j1, String as[], Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeStringArray(as);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            dU.transact(8004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void a(fo fo1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeLong(l1);
            dU.transact(5058, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, long l1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeLong(l1);
            parcel.writeString(s1);
            dU.transact(8018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, Bundle bundle, int i1, int j1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            dU.transact(5021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void a(fo fo1, IBinder ibinder, int i1, String as[], Bundle bundle, boolean flag, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L6:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5030, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L6
_L4:
            parcel.writeInt(0);
              goto _L5
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
_L9:
            i1 = 0;
              goto _L7
_L5:
            if (!flag) goto _L9; else goto _L8
_L8:
            i1 = ((flag1) ? 1 : 0);
              goto _L7
        }

        public void a(fo fo1, IBinder ibinder, String s1, boolean flag, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeStrongBinder(ibinder);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            parcel.writeLong(l1);
            dU.transact(5031, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5019, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, int i1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            dU.transact(5025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void a(fo fo1, String s1, int i1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(8023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5045, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag4;
            flag4 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(6501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeLong(l1);
            dU.transact(5016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, long l1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeLong(l1);
            parcel.writeString(s2);
            dU.transact(7002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            dU.transact(5023, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void a(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(5009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, String s2, int i1, int j1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            dU.transact(8001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, String s2, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(5039, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, String s2, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
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
            dU.transact(9028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, String s2, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(5054, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, boolean flag, long al1[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            parcel.writeLongArray(al1);
            dU.transact(5011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, byte abyte0[], String s2, ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeByteArray(abyte0);
            parcel.writeString(s2);
            parcel.writeTypedArray(aparticipantresult, 0);
            dU.transact(8007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, byte abyte0[], ParticipantResult aparticipantresult[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeByteArray(abyte0);
            parcel.writeTypedArray(aparticipantresult, 0);
            dU.transact(8008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, String s1, int ai1[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeIntArray(ai1);
            dU.transact(8017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void a(fo fo1, boolean flag, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5063, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void a(fo fo1, int ai1[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeIntArray(ai1);
            dU.transact(8003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public Bundle aU()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5004, parcel, parcel1, 0);
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

        public String af(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(5064, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public String ag(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(5035, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void ah(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(5050, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public int ai(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(5060, parcel, parcel1, 0);
            parcel1.readException();
            i1 = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i1;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public Uri aj(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(5066, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s1 = (Uri)Uri.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s1;
_L2:
            s1 = null;
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void ak(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(8002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public ParcelFileDescriptor al(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(9030, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s1;
_L2:
            s1 = null;
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public IBinder asBinder()
        {
            return dU;
        }

        public int b(byte abyte0[], String s1, String as[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeByteArray(abyte0);
            parcel.writeString(s1);
            parcel.writeStringArray(as);
            dU.transact(5034, parcel, parcel1, 0);
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

        public void b(long l1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            parcel.writeString(s1);
            dU.transact(8021, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void b(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5017, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5046, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeLong(l1);
            dU.transact(8012, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, long l1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_81;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeLong(l1);
            parcel.writeString(s1);
            dU.transact(8020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, int i1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeInt(i1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            dU.transact(7003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void b(fo fo1, String s1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5501, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, IBinder ibinder, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null) goto _L2; else goto _L1
_L1:
            fo1 = fo1.asBinder();
_L5:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeStrongBinder(ibinder);
            if (bundle == null) goto _L4; else goto _L3
_L3:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L6:
            dU.transact(5024, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            fo1 = null;
              goto _L5
_L4:
            parcel.writeInt(0);
              goto _L6
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
              goto _L5
        }

        public void b(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(5038, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, String s2, int i1, int j1, int k1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag1;
            flag1 = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_123;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i1);
            parcel.writeInt(j1);
            parcel.writeInt(k1);
            i1 = ((flag1) ? 1 : 0);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(5040, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, String s2, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6506, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6502, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(fo fo1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6503, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void b(String s1, String s2, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i1);
            dU.transact(5051, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void c(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5022, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(5048, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, String s1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(9001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(5041, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6504, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(fo fo1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(8027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void c(String s1, String s2, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeString(s2);
            parcel.writeInt(i1);
            dU.transact(8026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void clearNotifications(int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeInt(i1);
            dU.transact(5036, parcel, parcel1, 0);
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

        public void d(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5026, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void d(fo fo1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(6003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void d(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5018, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void d(fo fo1, String s1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_110;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(9020, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void d(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(8011, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void d(fo fo1, String s1, boolean flag)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i1;
            i1 = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            if (flag)
            {
                i1 = 1;
            }
            parcel.writeInt(i1);
            dU.transact(6505, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public int dd()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9019, parcel, parcel1, 0);
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

        public void df()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5006, parcel, parcel1, 0);
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

        public DataHolder dg()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5013, parcel, parcel1, 0);
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

        public boolean dh()
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
            dU.transact(5067, parcel, parcel1, 0);
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

        public DataHolder di()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5502, parcel, parcel1, 0);
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

        public void dj()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(8022, parcel, parcel1, 0);
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

        public Intent dk()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9013, parcel, parcel1, 0);
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
            dU.transact(6507, parcel, parcel1, 0);
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

        public void e(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5027, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void e(fo fo1, int i1, boolean flag, boolean flag1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag2;
            flag2 = true;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_103;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
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
            dU.transact(6004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void e(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5032, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void e(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(8015, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void e(String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(5065, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void f(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5047, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void f(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5037, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void f(fo fo1, String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(8016, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void f(String s1, String s2)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeString(s2);
            dU.transact(8025, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void g(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5049, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void g(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5042, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public Intent getAchievementsIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9005, parcel, parcel1, 0);
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

        public Intent getAllLeaderboardsIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9003, parcel, parcel1, 0);
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

        public String getAppId()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5003, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String getCurrentAccountName()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5007, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String getCurrentPlayerId()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(5012, parcel, parcel1, 0);
            parcel1.readException();
            s1 = parcel1.readString();
            parcel1.recycle();
            parcel.recycle();
            return s1;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public Intent getInvitationInboxIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9007, parcel, parcel1, 0);
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

        public Intent getLeaderboardIntent(String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            dU.transact(9004, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
            s1 = (Intent)Intent.CREATOR.createFromParcel(parcel1);
_L4:
            parcel1.recycle();
            parcel.recycle();
            return s1;
_L2:
            s1 = null;
            if (true) goto _L4; else goto _L3
_L3:
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public Intent getMatchInboxIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9006, parcel, parcel1, 0);
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

        public int getMaxTurnBasedMatchDataSize()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i1;
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(8024, parcel, parcel1, 0);
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

        public Intent getPlayerSearchIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9010, parcel, parcel1, 0);
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

        public Intent getRealTimeSelectOpponentsIntent(int i1, int j1, boolean flag)
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
            dU.transact(9009, parcel, parcel1, 0);
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

        public Intent getSettingsIntent()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            dU.transact(9012, parcel, parcel1, 0);
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

        public Intent getTurnBasedSelectOpponentsIntent(int i1, int j1, boolean flag)
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
            dU.transact(9008, parcel, parcel1, 0);
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

        public void h(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5056, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void h(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5043, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void i(fo fo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            dU.transact(5062, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void i(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5052, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void i(String s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeInt(i1);
            dU.transact(5029, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public DataHolder j(fo fo1, String s1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            Parcel parcel1;
            obj = null;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5053, parcel, parcel1, 0);
            parcel1.readException();
            fo1 = obj;
            if (parcel1.readInt() != 0)
            {
                fo1 = DataHolder.CREATOR.createFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return fo1;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void j(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            dU.transact(5001, parcel, parcel1, 0);
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

        public void j(String s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeInt(i1);
            dU.transact(5028, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void k(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            dU.transact(5059, parcel, parcel1, 0);
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

        public void k(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5061, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void k(String s1, int i1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeString(s1);
            parcel.writeInt(i1);
            dU.transact(5055, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s1;
            parcel1.recycle();
            parcel.recycle();
            throw s1;
        }

        public void l(long l1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            parcel.writeLong(l1);
            dU.transact(8013, parcel, parcel1, 0);
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

        public void l(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(5057, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void m(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(7001, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void n(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(8005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void o(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(8006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void p(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(8009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void q(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(8010, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void r(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(8014, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void s(fo fo1, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
            if (fo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            fo1 = fo1.asBinder();
_L1:
            parcel.writeStrongBinder(fo1);
            parcel.writeString(s1);
            dU.transact(9002, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            fo1 = null;
              goto _L1
            fo1;
            parcel1.recycle();
            parcel.recycle();
            throw fo1;
        }

        public void s(boolean flag)
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
            dU.transact(5068, parcel, parcel1, 0);
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
            dU = ibinder;
        }
    }


    public static fp H(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (iinterface != null && (iinterface instanceof fp))
        {
            return (fp)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        Object obj5 = null;
        IBinder ibinder = null;
        Object obj6 = null;
        Object obj4 = null;
        Object obj = null;
        boolean flag = false;
        boolean flag46 = false;
        boolean flag40 = false;
        boolean flag43 = false;
        boolean flag47 = false;
        int k = 0;
        boolean flag48 = false;
        boolean flag49 = false;
        boolean flag50 = false;
        boolean flag51 = false;
        boolean flag44 = false;
        boolean flag45 = false;
        boolean flag42 = false;
        boolean flag52 = false;
        boolean flag53 = false;
        boolean flag54 = false;
        boolean flag55 = false;
        boolean flag56 = false;
        boolean flag57 = false;
        boolean flag58 = false;
        boolean flag28 = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.games.internal.IGamesService");
            return true;

        case 5001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            j(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = getAppId();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = aU();
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
            df();
            parcel1.writeNoException();
            return true;

        case 5007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = getCurrentAccountName();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5064: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = af(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5065: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5008: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5009: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5010: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5011: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((fo) (obj)), ((String) (obj4)), flag, parcel.createLongArray());
            parcel1.writeNoException();
            return true;

        case 5012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = getCurrentPlayerId();
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5013: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = dg();
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
            c(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
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
                flag28 = true;
            }
            a(((fo) (obj)), i, flag, flag28);
            parcel1.writeNoException();
            return true;

        case 5016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5018: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
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
            a(((fo) (obj)), ((String) (obj4)), i, j, k, flag);
            parcel1.writeNoException();
            return true;

        case 5020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
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
            b(((fo) (obj)), ((String) (obj4)), i, j, k, flag);
            parcel1.writeNoException();
            return true;

        case 5021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj4 = G(parcel.readStrongBinder());
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                obj = null;
            }
            a(((fo) (obj4)), ((Bundle) (obj)), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5022: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            obj5 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(((fo) (obj)), ((String) (obj4)), ((IBinder) (obj5)), parcel);
            parcel1.writeNoException();
            return true;

        case 5024: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            obj5 = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            b(((fo) (obj)), ((String) (obj4)), ((IBinder) (obj5)), parcel);
            parcel1.writeNoException();
            return true;

        case 5025: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj4 = G(parcel.readStrongBinder());
            obj5 = parcel.readString();
            i = parcel.readInt();
            ibinder = parcel.readStrongBinder();
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(((fo) (obj4)), ((String) (obj5)), i, ibinder, ((Bundle) (obj)));
            parcel1.writeNoException();
            return true;

        case 5026: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5027: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5028: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            j(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5029: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5058: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5059: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            k(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5030: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj4 = G(parcel.readStrongBinder());
            ibinder = parcel.readStrongBinder();
            i = parcel.readInt();
            obj6 = parcel.createStringArray();
            Object obj1 = obj5;
            if (parcel.readInt() != 0)
            {
                obj1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((fo) (obj4)), ibinder, i, ((String []) (obj6)), ((Bundle) (obj1)), flag, parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5031: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo = G(parcel.readStrongBinder());
            obj4 = parcel.readStrongBinder();
            String s2 = parcel.readString();
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(fo, ((IBinder) (obj4)), s2, flag, parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 5032: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5033: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = a(G(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString(), parcel.readString());
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
            parcel = ag(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 5036: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            clearNotifications(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5037: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5038: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5039: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo1 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            String s3 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            if (parcel.readInt() != 0)
            {
                flag = true;
            }
            a(fo1, ((String) (obj4)), s3, i, j, k, flag);
            parcel1.writeNoException();
            return true;

        case 5040: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo2 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            String s4 = parcel.readString();
            i = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            boolean flag1 = flag46;
            if (parcel.readInt() != 0)
            {
                flag1 = true;
            }
            b(fo2, ((String) (obj4)), s4, i, j, k, flag1);
            parcel1.writeNoException();
            return true;

        case 5041: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5042: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            g(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5043: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            h(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5044: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo3 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            j = parcel.readInt();
            boolean flag2;
            boolean flag29;
            if (parcel.readInt() != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag29 = true;
            } else
            {
                flag29 = false;
            }
            a(fo3, i, j, flag2, flag29);
            parcel1.writeNoException();
            return true;

        case 5045: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo4 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag3;
            boolean flag30;
            if (parcel.readInt() != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag30 = true;
            } else
            {
                flag30 = false;
            }
            a(fo4, ((String) (obj4)), i, flag3, flag30);
            parcel1.writeNoException();
            return true;

        case 5046: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo5 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag4;
            boolean flag31;
            if (parcel.readInt() != 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            flag31 = flag40;
            if (parcel.readInt() != 0)
            {
                flag31 = true;
            }
            b(fo5, i, flag4, flag31);
            parcel1.writeNoException();
            return true;

        case 5047: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5048: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo6 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag5;
            boolean flag32;
            if (parcel.readInt() != 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            flag32 = flag43;
            if (parcel.readInt() != 0)
            {
                flag32 = true;
            }
            c(fo6, i, flag5, flag32);
            parcel1.writeNoException();
            return true;

        case 5049: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            g(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5050: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ah(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5051: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5052: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5053: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = j(G(parcel.readStrongBinder()), parcel.readString());
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
            i = ai(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5054: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo7 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            boolean flag6 = flag47;
            if (parcel.readInt() != 0)
            {
                flag6 = true;
            }
            a(fo7, ((String) (obj4)), flag6);
            parcel1.writeNoException();
            return true;

        case 5061: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            k(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5055: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            k(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5067: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean flag7 = dh();
            parcel1.writeNoException();
            i = k;
            if (flag7)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 5068: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            boolean flag8 = flag48;
            if (parcel.readInt() != 0)
            {
                flag8 = true;
            }
            s(flag8);
            parcel1.writeNoException();
            return true;

        case 5056: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            h(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5057: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            l(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 5062: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i(G(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5063: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo8 = G(parcel.readStrongBinder());
            boolean flag9 = flag49;
            if (parcel.readInt() != 0)
            {
                flag9 = true;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            a(fo8, flag9, parcel);
            parcel1.writeNoException();
            return true;

        case 5066: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = aj(parcel.readString());
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
            fo fo9 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag10;
            boolean flag33;
            if (parcel.readInt() != 0)
            {
                flag10 = true;
            } else
            {
                flag10 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag33 = true;
            } else
            {
                flag33 = false;
            }
            b(fo9, ((String) (obj4)), i, flag10, flag33);
            parcel1.writeNoException();
            return true;

        case 5502: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = di();
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
            fo fo10 = G(parcel.readStrongBinder());
            boolean flag11 = flag50;
            if (parcel.readInt() != 0)
            {
                flag11 = true;
            }
            a(fo10, flag11);
            parcel1.writeNoException();
            return true;

        case 6002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo11 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            String s5 = parcel.readString();
            boolean flag12 = flag51;
            if (parcel.readInt() != 0)
            {
                flag12 = true;
            }
            a(fo11, ((String) (obj4)), s5, flag12);
            parcel1.writeNoException();
            return true;

        case 6003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo12 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag13;
            boolean flag34;
            if (parcel.readInt() != 0)
            {
                flag13 = true;
            } else
            {
                flag13 = false;
            }
            flag34 = flag44;
            if (parcel.readInt() != 0)
            {
                flag34 = true;
            }
            d(fo12, i, flag13, flag34);
            parcel1.writeNoException();
            return true;

        case 6004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo13 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            boolean flag14;
            boolean flag35;
            if (parcel.readInt() != 0)
            {
                flag14 = true;
            } else
            {
                flag14 = false;
            }
            flag35 = flag45;
            if (parcel.readInt() != 0)
            {
                flag35 = true;
            }
            e(fo13, i, flag14, flag35);
            parcel1.writeNoException();
            return true;

        case 6501: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo14 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag15;
            boolean flag36;
            boolean flag41;
            if (parcel.readInt() != 0)
            {
                flag15 = true;
            } else
            {
                flag15 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag36 = true;
            } else
            {
                flag36 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag41 = true;
            } else
            {
                flag41 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag42 = true;
            }
            a(fo14, ((String) (obj4)), i, flag15, flag36, flag41, flag42);
            parcel1.writeNoException();
            return true;

        case 6502: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo15 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            boolean flag16 = flag52;
            if (parcel.readInt() != 0)
            {
                flag16 = true;
            }
            b(fo15, ((String) (obj4)), flag16);
            parcel1.writeNoException();
            return true;

        case 6503: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo16 = G(parcel.readStrongBinder());
            boolean flag17 = flag53;
            if (parcel.readInt() != 0)
            {
                flag17 = true;
            }
            b(fo16, flag17);
            parcel1.writeNoException();
            return true;

        case 6504: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo17 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            boolean flag18 = flag54;
            if (parcel.readInt() != 0)
            {
                flag18 = true;
            }
            c(fo17, ((String) (obj4)), flag18);
            parcel1.writeNoException();
            return true;

        case 6505: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo18 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            boolean flag19 = flag55;
            if (parcel.readInt() != 0)
            {
                flag19 = true;
            }
            d(fo18, ((String) (obj4)), flag19);
            parcel1.writeNoException();
            return true;

        case 6506: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo19 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            String s6 = parcel.readString();
            boolean flag20 = flag56;
            if (parcel.readInt() != 0)
            {
                flag20 = true;
            }
            b(fo19, ((String) (obj4)), s6, flag20);
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
            m(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 7002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 7003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj4 = G(parcel.readStrongBinder());
            String s7 = parcel.readString();
            i = parcel.readInt();
            obj6 = parcel.readStrongBinder();
            Object obj2 = ibinder;
            if (parcel.readInt() != 0)
            {
                obj2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            b(((fo) (obj4)), s7, i, ((IBinder) (obj6)), ((Bundle) (obj2)));
            parcel1.writeNoException();
            return true;

        case 8001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            ak(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 8004: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            obj4 = G(parcel.readStrongBinder());
            i = parcel.readInt();
            j = parcel.readInt();
            String as[] = parcel.createStringArray();
            Object obj3 = obj6;
            if (parcel.readInt() != 0)
            {
                obj3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            a(((fo) (obj4)), i, j, as, ((Bundle) (obj3)));
            parcel1.writeNoException();
            return true;

        case 8005: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            n(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8006: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            o(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8007: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readString(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
            parcel1.writeNoException();
            return true;

        case 8008: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), (ParticipantResult[])parcel.createTypedArray(ParticipantResult.CREATOR));
            parcel1.writeNoException();
            return true;

        case 8009: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            p(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8010: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            q(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8011: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            d(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8012: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(G(parcel.readStrongBinder()), parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 8013: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            l(parcel.readLong());
            parcel1.writeNoException();
            return true;

        case 8014: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            r(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8024: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            i = getMaxTurnBasedMatchDataSize();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 8025: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8015: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            e(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8016: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            f(G(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8017: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray());
            parcel1.writeNoException();
            return true;

        case 8026: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            c(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8018: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(G(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8019: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            a(parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(G(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8021: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            b(parcel.readLong(), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 8022: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            dj();
            parcel1.writeNoException();
            return true;

        case 8023: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo20 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag21 = flag57;
            if (parcel.readInt() != 0)
            {
                flag21 = true;
            }
            a(fo20, ((String) (obj4)), i, flag21);
            parcel1.writeNoException();
            return true;

        case 8027: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo21 = G(parcel.readStrongBinder());
            boolean flag22 = flag58;
            if (parcel.readInt() != 0)
            {
                flag22 = true;
            }
            c(fo21, flag22);
            parcel1.writeNoException();
            return true;

        case 9001: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo22 = G(parcel.readStrongBinder());
            obj4 = parcel.readString();
            i = parcel.readInt();
            boolean flag23;
            boolean flag37;
            if (parcel.readInt() != 0)
            {
                flag23 = true;
            } else
            {
                flag23 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag37 = true;
            } else
            {
                flag37 = false;
            }
            c(fo22, ((String) (obj4)), i, flag23, flag37);
            parcel1.writeNoException();
            return true;

        case 9002: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            s(G(parcel.readStrongBinder()), parcel.readString());
            parcel1.writeNoException();
            return true;

        case 9003: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = getAllLeaderboardsIntent();
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
            parcel = getLeaderboardIntent(parcel.readString());
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
            parcel = getAchievementsIntent();
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
            parcel = getMatchInboxIntent();
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
            parcel = getInvitationInboxIntent();
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
            boolean flag24;
            if (parcel.readInt() != 0)
            {
                flag24 = true;
            } else
            {
                flag24 = false;
            }
            parcel = getTurnBasedSelectOpponentsIntent(i, j, flag24);
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
            boolean flag25;
            if (parcel.readInt() != 0)
            {
                flag25 = true;
            } else
            {
                flag25 = false;
            }
            parcel = getRealTimeSelectOpponentsIntent(i, j, flag25);
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
            parcel = getPlayerSearchIntent();
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
            parcel = getSettingsIntent();
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
            parcel = dk();
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
            ParticipantEntity aparticipantentity[] = (ParticipantEntity[])parcel.createTypedArray(ParticipantEntity.CREATOR);
            String s9 = parcel.readString();
            String s10 = parcel.readString();
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
                obj4 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            }
            parcel = a(aparticipantentity, s9, s10, uri, ((Uri) (obj4)));
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
            i = dd();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 9020: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo23 = G(parcel.readStrongBinder());
            String s = parcel.readString();
            i = parcel.readInt();
            boolean flag26;
            boolean flag38;
            if (parcel.readInt() != 0)
            {
                flag26 = true;
            } else
            {
                flag26 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag38 = true;
            } else
            {
                flag38 = false;
            }
            d(fo23, s, i, flag26, flag38);
            parcel1.writeNoException();
            return true;

        case 9028: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fo fo24 = G(parcel.readStrongBinder());
            String s1 = parcel.readString();
            String s8 = parcel.readString();
            i = parcel.readInt();
            boolean flag27;
            boolean flag39;
            if (parcel.readInt() != 0)
            {
                flag27 = true;
            } else
            {
                flag27 = false;
            }
            if (parcel.readInt() != 0)
            {
                flag39 = true;
            } else
            {
                flag39 = false;
            }
            a(fo24, s1, s8, i, flag27, flag39);
            parcel1.writeNoException();
            return true;

        case 9030: 
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            parcel = al(parcel.readString());
            parcel1.writeNoException();
            break;
        }
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
    }
}
