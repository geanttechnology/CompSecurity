// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.widget.VideoView;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class b
    implements Runnable
{

    final Url a;
    private boolean b;

    public final void run()
    {
_L5:
        if (MraidView.j(a.a) == null) goto _L2; else goto _L1
_L1:
        Thread.sleep(100L);
        if (b == MraidView.j(a.a).isPlaying()) goto _L4; else goto _L3
_L3:
        b = MraidView.j(a.a).isPlaying();
        String s;
        if (b)
        {
            s = "videoplay";
        } else
        {
            s = "videopause";
        }
        try
        {
            a.a.loadUrl((new StringBuilder("javascript:try{Tapjoy.AdUnit.dispatchEvent('")).append(s).append("')}catch(e){}").toString());
        }
        catch (Exception exception) { }
_L4:
        if (true) goto _L5; else goto _L2
_L2:
    }

    public ( )
    {
        a = ;
        super();
        b = false;
    }
}
