// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.app.Activity;
import android.widget.ProgressBar;
import android.widget.VideoView;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements Runnable
{
    final class a
        implements Runnable
    {

        final MraidView.c a;
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

        public a()
        {
            a = MraidView.c.this;
            super();
            b = false;
        }
    }


    final MraidView a;

    public final void run()
    {
        int i = 0;
_L2:
        if (MraidView.j(a) == null || MraidView.j(a).isPlaying())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Thread.sleep(50L);
        int j = i + 50;
        i = j;
        if (j < 10000)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Activity)MraidView.i(a)).runOnUiThread(new Runnable() {

            final MraidView.c a;

            public final void run()
            {
                if (MraidView.l(a.a) != null)
                {
                    MraidView.l(a.a).setVisibility(8);
                }
                (new Thread(a. new a())).start();
            }

            
            {
                a = MraidView.c.this;
                super();
            }
        });
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public _cls1.a(MraidView mraidview)
    {
        a = mraidview;
        super();
    }
}
