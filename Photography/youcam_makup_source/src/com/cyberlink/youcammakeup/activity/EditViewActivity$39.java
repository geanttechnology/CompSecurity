// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, j, d

class a
    implements Runnable
{

    final EditViewActivity a;

    public void run()
    {
        EditViewActivity.g(a).a();
        EditViewActivity.h(a).a(true);
    }

    (EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
