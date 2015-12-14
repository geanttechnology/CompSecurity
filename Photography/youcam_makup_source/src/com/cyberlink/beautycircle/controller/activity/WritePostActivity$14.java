// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;


// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements Runnable
{

    final WritePostActivity a;

    public void run()
    {
        a.setResult(0);
        WritePostActivity.n(a);
    }

    I(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
