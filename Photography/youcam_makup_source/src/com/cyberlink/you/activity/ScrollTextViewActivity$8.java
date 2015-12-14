// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.widget.ScrollView;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class a
    implements Runnable
{

    final ScrollView a;
    final ScrollTextViewActivity b;

    public void run()
    {
        a.fullScroll(130);
    }

    _cls9(ScrollTextViewActivity scrolltextviewactivity, ScrollView scrollview)
    {
        b = scrolltextviewactivity;
        a = scrollview;
        super();
    }
}
