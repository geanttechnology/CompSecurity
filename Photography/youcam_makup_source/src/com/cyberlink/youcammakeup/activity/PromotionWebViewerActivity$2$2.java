// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.net.Uri;
import android.webkit.WebView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ab;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ac;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ae;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.x;
import java.net.URI;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            PromotionWebViewerActivity

class a
    implements Runnable
{

    final ab a;
    final b b;

    public void run()
    {
        String s = Uri.parse(a.a(b.b).c.toString()).buildUpon().r("HideTopBar", "true").r().toString();
        if (PromotionWebViewerActivity.c(b.b) != null)
        {
            PromotionWebViewerActivity.d(b.b).loadUrl(s);
        }
    }

    a(a a1, ab ab1)
    {
        b = a1;
        a = ab1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/PromotionWebViewerActivity$2

/* anonymous class */
    class PromotionWebViewerActivity._cls2
        implements ae
    {

        final String a;
        final PromotionWebViewerActivity b;

        public void a(ab ab1)
        {
            String s = ab1.a(a).c.toString();
            if (s.equals("http://none"))
            {
                b.runOnUiThread(new PromotionWebViewerActivity._cls2._cls1());
                return;
            } else
            {
                PromotionWebViewerActivity.b(b).put(a, s);
                b.runOnUiThread(new PromotionWebViewerActivity._cls2._cls2(this, ab1));
                return;
            }
        }

        public void a(bn bn1)
        {
            Globals.d().i().a(b, x.a, bn1.toString(), false);
        }

        public volatile void a(Object obj)
        {
            a((ab)obj);
        }

        public void a(Void void1)
        {
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

            
            {
                b = promotionwebvieweractivity;
                a = s;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/activity/PromotionWebViewerActivity$2$1

/* anonymous class */
        class PromotionWebViewerActivity._cls2._cls1
            implements Runnable
        {

            final PromotionWebViewerActivity._cls2 a;

            public void run()
            {
                Globals.d().i().a(PromotionWebViewerActivity.a(a.b));
                Globals.d().i().a(a.b, x.a, a.b.getString(0x7f07051d).toString(), false);
            }

                    
                    {
                        a = PromotionWebViewerActivity._cls2.this;
                        super();
                    }
        }

    }

}
