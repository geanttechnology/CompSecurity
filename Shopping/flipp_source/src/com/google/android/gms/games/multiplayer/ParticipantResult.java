// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ha;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            e

public final class ParticipantResult
    implements SafeParcelable
{

    public static final e CREATOR = new e();
    final int a;
    final String b;
    final int c;
    final int d;

    public ParticipantResult(int i, String s, int j, int k)
    {
        a = i;
        b = (String)ha.a(s);
        j;
        JVM INSTR tableswitch 0 5: default 60
    //                   0 80
    //                   1 80
    //                   2 80
    //                   3 80
    //                   4 80
    //                   5 80;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        ha.a(flag);
        c = j;
        d = k;
        return;
_L2:
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ParticipantResult(String s, int i, int j)
    {
        this(1, s, i, j);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        e.a(this, parcel);
    }

}
