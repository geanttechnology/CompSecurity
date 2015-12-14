// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import java.util.List;
import tu;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

class a extends BroadcastReceiver
{

    final MagComposeActivity a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append("BroadcastReceiver on receiver").toString());
        if (context != null && context.equalsIgnoreCase("ACTION_MATERIAL_ADDED") && intent.getStringExtra("TYPE_MATERIAL") != null && intent.getStringExtra("TYPE_MATERIAL").equalsIgnoreCase(tu.getStringByResType(EOnlineResType.MAG_MASK_INFO)))
        {
            int i = intent.getIntExtra("INSTAMAG_RESID", -1);
            int j = intent.getIntExtra("INSTAMAG_IMAGE_COUNT", -1);
            Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver resid:").append(i).toString());
            Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver imagecount:").append(j).toString());
            if (j == a.h().size())
            {
                a.g = i;
                Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" BroadcastReceiver on receiver _needResetrid:").append(a.g).toString());
            }
        }
    }

    (MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }
}
