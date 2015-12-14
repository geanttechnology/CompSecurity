// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity, LogBrowserActivity

class a
    implements android.view.iewActivity._cls3
{

    final ScrollTextViewActivity a;

    public void onClick(View view)
    {
        view = new Intent(a.a(), com/cyberlink/you/activity/LogBrowserActivity);
        view.putExtra("type", com.cyberlink.you.utility..ing());
        a.a().startActivity(view);
    }

    _cls9(ScrollTextViewActivity scrolltextviewactivity)
    {
        a = scrolltextviewactivity;
        super();
    }
}
