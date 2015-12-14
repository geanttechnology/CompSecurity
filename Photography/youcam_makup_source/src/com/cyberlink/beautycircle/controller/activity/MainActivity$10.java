// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a
    implements android.view.Listener
{

    final MainActivity a;

    public boolean onLongClick(View view)
    {
        MainActivity.q++;
        if (MainActivity.q >= 3)
        {
            MainActivity.q = 0;
            a.v();
        }
        return false;
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
