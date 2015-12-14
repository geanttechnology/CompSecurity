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
//            Pip2StyleFragment

class a extends BroadcastReceiver
{

    final Pip2StyleFragment a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        Log.v("Pip2StyleFragment", "Pip2StyleFragmentBroadcastReceiver on receiver");
        if (context != null && intent.getStringExtra("TYPE_MATERIAL") != null)
        {
            context = intent.getStringExtra("TYPE_MATERIAL");
            int i = intent.getIntExtra("RESID_MATERIAL", 0);
            if (context.equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE2)))
            {
                Pip2StyleFragment.a(a, i);
            }
        }
    }

    (Pip2StyleFragment pip2stylefragment)
    {
        a = pip2stylefragment;
        super();
    }
}
