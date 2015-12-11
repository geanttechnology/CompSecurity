// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.b;
import com.mopub.common.c.a;
import com.mopub.common.d.n;

// Referenced classes of package com.mopub.mobileads:
//            j, ar

public class f extends j
    implements ar.a
{

    boolean a;
    private final ar c;

    public f(Context context, b b)
    {
        super(context);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        getSettings().setJavaScriptEnabled(true);
        c = new ar(context, this, b);
        c.a = this;
        if (n.a().a(n.n))
        {
            a(true);
        }
        setBackgroundColor(0);
    }

    static ar a(f f1)
    {
        return f1.c;
    }

    public final void a()
    {
        a = true;
    }

    public void loadUrl(String s)
    {
        if (s != null)
        {
            com.mopub.common.c.a.b((new StringBuilder("Loading url: ")).append(s).toString());
            if (s.startsWith("javascript:"))
            {
                super.loadUrl(s);
                return;
            }
        }
    }

    // Unreferenced inner class com/mopub/mobileads/f$1

/* anonymous class */
    public final class _cls1
        implements android.view.View.OnTouchListener
    {

        final boolean a;
        final f b;

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            com.mopub.mobileads.f.a(b).a(motionevent);
            return motionevent.getAction() == 2 && !a;
        }

            public 
            {
                b = f.this;
                a = flag;
                super();
            }
    }

}
