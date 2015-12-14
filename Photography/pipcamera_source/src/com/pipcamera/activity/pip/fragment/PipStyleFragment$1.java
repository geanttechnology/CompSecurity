// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import tu;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a extends BroadcastReceiver
{

    final PipStyleFragment a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        Log.v("PipStyleFragment", "PipStyleFragmentBroadcastReceiver on receiver");
        if (context != null && intent.getStringExtra("TYPE_MATERIAL") != null)
        {
            context = intent.getStringExtra("TYPE_MATERIAL");
            int i = intent.getIntExtra("RESID_MATERIAL", 0);
            if (context.equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE)))
            {
                PipStyleFragment.a(a, i);
            }
        }
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
