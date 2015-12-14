// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.graphics.Bitmap;
import com.socialin.android.util.c;
import java.util.ArrayList;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateView, TemplateImage, TemplateActivity, h

final class a
    implements Runnable
{

    private lidate a;

    public final void run()
    {
        if (TemplateView.h(a.a).k == null || TemplateView.h(a.a).k.isRecycled())
        {
            a.a.a();
        }
        m.b(a.a, a.a.a);
        a.a.invalidate();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/template/TemplateView$2

/* anonymous class */
    final class TemplateView._cls2 extends Thread
    {

        final TemplateActivity a;
        final TemplateView b;
        private TemplateImage c;
        private Bitmap d;
        private TemplateImage e;
        private Bitmap f;

        public final void run()
        {
            int i;
            int j;
            boolean flag = false;
            c.k = TemplateView.a(c);
            Bitmap bitmap;
            if (d != null && !d.isRecycled())
            {
                e.k = TemplateView.a(e);
            } else
            {
                e.k = null;
            }
            if (f != null)
            {
                com.socialin.android.util.c.a(f);
            }
            if (d != null)
            {
                com.socialin.android.util.c.a(d);
            }
            i = 0;
_L5:
            j = ((flag) ? 1 : 0);
            if (i >= TemplateView.f(b).size()) goto _L2; else goto _L1
_L1:
            bitmap = ((h)TemplateView.f(b).get(i)).b;
            if (bitmap != null && !bitmap.isRecycled()) goto _L4; else goto _L3
_L3:
            ((h)TemplateView.f(b).get(i)).b = c.k;
            ((h)TemplateView.f(b).get(i)).c = c.l;
            ((h)TemplateView.f(b).get(i)).e = c.n;
            ((h)TemplateView.f(b).get(i)).f = c.o;
            ((h)TemplateView.f(b).get(i)).d = c.m;
            ((h)TemplateView.f(b).get(i)).a = c.p;
            j = ((flag) ? 1 : 0);
_L2:
            if (j < TemplateView.f(b).size())
            {
                bitmap = ((h)TemplateView.f(b).get(j)).b;
                if (bitmap != null && !bitmap.isRecycled())
                {
                    break MISSING_BLOCK_LABEL_507;
                }
                ((h)TemplateView.f(b).get(j)).b = e.k;
                ((h)TemplateView.f(b).get(j)).c = e.l;
                ((h)TemplateView.f(b).get(j)).e = e.n;
                ((h)TemplateView.f(b).get(j)).f = e.o;
                ((h)TemplateView.f(b).get(j)).d = e.m;
                ((h)TemplateView.f(b).get(j)).a = e.p;
            }
            TemplateView.g(b);
            ((Activity)b.getContext()).runOnUiThread(new TemplateView._cls2._cls1(this));
            return;
_L4:
            i++;
              goto _L5
            j++;
              goto _L2
        }

            
            {
                b = templateview;
                c = templateimage;
                d = bitmap;
                e = templateimage1;
                f = bitmap1;
                a = templateactivity;
                super();
            }
    }

}
