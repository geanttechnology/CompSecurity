// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;

// Referenced classes of package cn.jpush.android.a:
//            b

final class c extends PhoneStateListener
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public final void onCellLocationChanged(CellLocation celllocation)
    {
        b.a(a, false);
    }

    public final void onSignalStrengthChanged(int i)
    {
        b.a(a, i);
    }
}
