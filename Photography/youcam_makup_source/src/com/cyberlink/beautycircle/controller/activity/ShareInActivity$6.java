// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Html;
import android.widget.TextView;
import com.cyberlink.beautycircle.utility.x;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements Runnable
{

    final TextView a;
    final ShareInActivity b;

    public void run()
    {
        a.setText(Html.fromHtml(ShareInActivity.w(b).b).toString());
    }

    (ShareInActivity shareinactivity, TextView textview)
    {
        b = shareinactivity;
        a = textview;
        super();
    }
}
