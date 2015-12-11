// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements Runnable
{

    final MraidView a;

    public final void run()
    {
        while (!MraidView.m(a)) 
        {
            try
            {
                Thread.sleep(250L);
                MraidView.n(a);
            }
            catch (Exception exception) { }
        }
    }

    public (MraidView mraidview)
    {
        a = mraidview;
        super();
    }
}
