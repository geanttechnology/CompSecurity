// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.receivers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.aqo;

// Referenced classes of package com.abtnprojects.ambatana.receivers:
//            a

public class OnUpgradeReceiver extends a
{

    public OnUpgradeReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        aqo.a("On update", new Object[0]);
        a(context);
    }
}
