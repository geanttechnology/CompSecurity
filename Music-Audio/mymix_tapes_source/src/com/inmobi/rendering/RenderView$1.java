// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;


// Referenced classes of package com.inmobi.rendering:
//            RenderView

class a
    implements Runnable
{

    final String a;
    final RenderView b;

    public void run()
    {
        b.loadDataWithBaseURL("", a, "text/html", "UTF-8", null);
    }

    (RenderView renderview, String s)
    {
        b = renderview;
        a = s;
        super();
    }
}
