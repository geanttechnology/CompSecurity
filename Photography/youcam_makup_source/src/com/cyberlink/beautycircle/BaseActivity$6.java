// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class a
    implements Runnable
{

    final BaseActivity a;

    public void run()
    {
        if (BaseActivity.d(a) != null)
        {
            BaseActivity.d(a).setText("");
            BaseActivity.d(a).setVisibility(8);
        }
        if (BaseActivity.e(a) != null)
        {
            BaseActivity.e(a).setVisibility(8);
        }
    }

    (BaseActivity baseactivity)
    {
        a = baseactivity;
        super();
    }
}
