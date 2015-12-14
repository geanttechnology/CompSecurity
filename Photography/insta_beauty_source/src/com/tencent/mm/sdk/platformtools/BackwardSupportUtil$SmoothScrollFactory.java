// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            SmoothScrollToPosition22, SmoothScrollToPosition21below

public class 
{

    public static void scrollTo(ListView listview, int i)
    {
        if (android.os.l.SmoothScrollFactory >= 8)
        {
            (new SmoothScrollToPosition22()).doScroll(listview, i);
            return;
        } else
        {
            (new SmoothScrollToPosition21below()).doScroll(listview, i);
            return;
        }
    }

    public static void scrollToTop(ListView listview)
    {
        if (android.os.tion21below.doScroll >= 8)
        {
            (new SmoothScrollToPosition22()).doScroll(listview);
            return;
        } else
        {
            (new SmoothScrollToPosition21below()).doScroll(listview);
            return;
        }
    }

    public ()
    {
    }
}
