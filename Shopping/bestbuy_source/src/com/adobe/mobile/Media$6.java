// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;


// Referenced classes of package com.adobe.mobile:
//            Media, MediaAnalytics

final class val.offset
    implements Runnable
{

    final String val$name;
    final double val$offset;

    public void run()
    {
        MediaAnalytics.sharedInstance().click(val$name, val$offset);
    }

    lytics()
    {
        val$name = s;
        val$offset = d;
        super();
    }
}
