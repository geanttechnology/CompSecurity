// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            zza, PlayLoggerContext, LogEvent

class zznF
    implements zza
{

    private IBinder zznF;

    public IBinder asBinder()
    {
        return zznF;
    }

    public void zza(String s, PlayLoggerContext playloggercontext, LogEvent logevent)
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
        parcel.writeString(s);
        if (playloggercontext == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        playloggercontext.writeToParcel(parcel, 0);
_L3:
        if (logevent == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        parcel.writeInt(1);
        logevent.writeToParcel(parcel, 0);
_L4:
        zznF.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        s;
        parcel.recycle();
        throw s;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(String s, PlayLoggerContext playloggercontext, List list)
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
        parcel.writeString(s);
        if (playloggercontext == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        parcel.writeInt(1);
        playloggercontext.writeToParcel(parcel, 0);
_L1:
        parcel.writeTypedList(list);
        zznF.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel.recycle();
        throw s;
    }

    public void zza(String s, PlayLoggerContext playloggercontext, byte abyte0[])
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
        parcel.writeString(s);
        if (playloggercontext == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        parcel.writeInt(1);
        playloggercontext.writeToParcel(parcel, 0);
_L1:
        parcel.writeByteArray(abyte0);
        zznF.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        s;
        parcel.recycle();
        throw s;
    }

    ntext(IBinder ibinder)
    {
        zznF = ibinder;
    }
}
