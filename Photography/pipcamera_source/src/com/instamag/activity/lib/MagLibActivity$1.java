// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.instamag.activity.lib:
//            MagLibActivity

class a extends BroadcastReceiver
{

    final MagLibActivity a;

    public void onReceive(Context context, Intent intent)
    {
        intent.getAction();
    }

    (MagLibActivity maglibactivity)
    {
        a = maglibactivity;
        super();
    }
}
