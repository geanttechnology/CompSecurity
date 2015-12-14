// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.widget.TextView;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class b
    implements Runnable
{

    final String a;
    final String b;
    final ScrollTextViewActivity c;

    public void run()
    {
        ScrollTextViewActivity.d(c).setText((new StringBuilder()).append(ScrollTextViewActivity.d(c).getText().toString()).append("\n").append(a).append("\n").append(b).append("\n").toString());
        ScrollTextViewActivity.e(c);
    }

    _cls9(ScrollTextViewActivity scrolltextviewactivity, String s, String s1)
    {
        c = scrolltextviewactivity;
        a = s;
        b = s1;
        super();
    }
}
