// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.util.HashMap;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView, MorphRenderer

final class a
    implements Runnable
{

    private boolean a;
    private b b;

    public final void run()
    {
        b.b.b.d();
        if (b.b != null && !b.b.isRecycled())
        {
            c.a(b.b);
        }
        if (b.b.b.isFinishing())
        {
            return;
        }
        if (a)
        {
            Intent intent = new Intent();
            intent.putExtra("bufferData", StretchActivity.i(b.b.b));
            if (StretchActivity.j(b.b.b) != null)
            {
                AnalyticUtils.getInstance(b.b.b).track(new com.socialin.android.apiv3.events.tchEvent(StretchActivity.j(b.b.b)));
            }
            if (StretchActivity.f(b.b.b) != null)
            {
                StretchActivity.f(b.b.b).c("stretch");
                intent.putExtra("editing_data", StretchActivity.f(b.b.b));
            }
            b.b.b.setResult(-1, intent);
            AnalyticUtils.getInstance(b.b.b).track(new com.socialin.android.apiv3.events.tchCloseEvent(StretchActivity.f(b.b.b).a, "done", (int)StretchActivity.g(b.b.b).d()));
            b.b.b.finish();
        } else
        {
            Utils.b(b.b.b, 0x7f0805ca);
        }
        StretchActivity.a(b.b.b, false);
    }

    r(r r, boolean flag)
    {
        b = r;
        a = flag;
        super();
    }

    // Unreferenced inner class com/photo/morph/StretchActivity$9

/* anonymous class */
    final class StretchActivity._cls9
        implements android.view.View.OnClickListener
    {

        final StretchActivity a;

        public final void onClick(View view)
        {
            if (!StretchActivity.h(a))
            {
                if (StretchActivity.e(a) != null)
                {
                    StretchActivity.e(a).b();
                }
                StretchActivity.a(a, true);
                view = StretchActivity.e(a).b.i();
                if (view != null && !view.isRecycled())
                {
                    a.a(Integer.valueOf(0x7f080573));
                    (new Thread(new StretchActivity._cls9._cls1(this, view))).start();
                    return;
                }
            }
        }

            
            {
                a = stretchactivity;
                super();
            }
    }


    // Unreferenced inner class com/photo/morph/StretchActivity$9$1

/* anonymous class */
    final class StretchActivity._cls9._cls1
        implements Runnable
    {

        final Bitmap a;
        final StretchActivity._cls9 b;

        public final void run()
        {
            StretchActivity stretchactivity = b.a;
            Bitmap bitmap = a;
            boolean flag;
            if (w.a(stretchactivity))
            {
                stretchactivity.e = w.a((String)stretchactivity.e.get("path"), bitmap);
                flag = true;
            } else
            {
                flag = false;
            }
            b.a.runOnUiThread(new StretchActivity._cls9._cls1._cls1(this, flag));
        }

            
            {
                b = _pcls9;
                a = bitmap;
                super();
            }
    }

}
