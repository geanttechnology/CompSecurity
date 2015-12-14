// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.unittest.viewengine;


public class b extends Thread
{

    ViewEngineTestActivity.InnerSurfaceView a;
    boolean b;

    public b(ViewEngineTestActivity.InnerSurfaceView innersurfaceview)
    {
        b = true;
        a = innersurfaceview;
    }

    public void run()
    {
        while (b) 
        {
            a.a();
        }
    }
}
