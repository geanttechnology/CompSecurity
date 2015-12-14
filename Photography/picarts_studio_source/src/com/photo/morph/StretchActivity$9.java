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
    implements android.view.er
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
                (new Thread(new Runnable(view) {

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
                        b.a.runOnUiThread(new Runnable(this, flag) {

                            private boolean a;
                            private _cls1 b;

                            public final void run()
                            {
                                b.b.a.d();
                                if (b.a != null && !b.a.isRecycled())
                                {
                                    c.a(b.a);
                                }
                                if (b.b.a.isFinishing())
                                {
                                    return;
                                }
                                if (a)
                                {
                                    Intent intent = new Intent();
                                    intent.putExtra("bufferData", StretchActivity.i(b.b.a));
                                    if (StretchActivity.j(b.b.a) != null)
                                    {
                                        AnalyticUtils.getInstance(b.b.a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchEvent(StretchActivity.j(b.b.a)));
                                    }
                                    if (StretchActivity.f(b.b.a) != null)
                                    {
                                        StretchActivity.f(b.b.a).c("stretch");
                                        intent.putExtra("editing_data", StretchActivity.f(b.b.a));
                                    }
                                    b.b.a.setResult(-1, intent);
                                    AnalyticUtils.getInstance(b.b.a).track(new com.socialin.android.apiv3.events.EventsFactory.ToolStretchCloseEvent(StretchActivity.f(b.b.a).a, "done", (int)StretchActivity.g(b.b.a).d()));
                                    b.b.a.finish();
                                } else
                                {
                                    Utils.b(b.b.a, 0x7f0805ca);
                                }
                                StretchActivity.a(b.b.a, false);
                            }

            
            {
                b = _pcls1;
                a = flag;
                super();
            }
                        });
                    }

            
            {
                b = StretchActivity._cls9.this;
                a = bitmap;
                super();
            }
                })).start();
                return;
            }
        }
    }

    _cls1.a(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
