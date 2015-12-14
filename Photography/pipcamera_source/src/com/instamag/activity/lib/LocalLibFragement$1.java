// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import qy;
import tu;

// Referenced classes of package com.instamag.activity.lib:
//            LocalLibFragement

class a extends BroadcastReceiver
{

    final LocalLibFragement a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        Log.v(LocalLibFragement.a(a), (new StringBuilder()).append(LocalLibFragement.a(a)).append("BroadcastReceiver on receiver").toString());
        if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_ADDED")) goto _L2; else goto _L1
_L1:
        if (intent.getStringExtra("TYPE_MATERIAL") != null && intent.getStringExtra("TYPE_MATERIAL").equalsIgnoreCase(tu.getStringByResType(EOnlineResType.MAG_MASK_INFO)))
        {
            LocalLibFragement.b(a);
        }
_L4:
        return;
_L2:
        if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_CHANGE"))
        {
            continue; /* Loop/switch isn't completed */
        }
        LocalLibFragement.a(a, Boolean.valueOf(true));
        if (LocalLibFragement.c(a) == null) goto _L4; else goto _L3
_L3:
        LocalLibFragement.c(a).b();
        return;
        if (context == null || !context.equalsIgnoreCase("ACTION_MATERIAL_REMOVE") || LocalLibFragement.c(a) == null) goto _L4; else goto _L5
_L5:
        LocalLibFragement.b(a);
        return;
    }

    (LocalLibFragement locallibfragement)
    {
        a = locallibfragement;
        super();
    }
}
