// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    final DrawingActivity a;

    public final void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131755985: 
        default:
            return;

        case 2131755986: 
            boolean flag = DrawingActivity.c(a);
            DrawingActivity.d(a);
            DrawingActivity.a(a, new Runnable(flag) {

                private boolean a;
                private DrawingActivity._cls21 b;

                public final void run()
                {
                    if (!a)
                    {
                        DrawingActivity.e(b.a);
                    }
                }

            
            {
                b = DrawingActivity._cls21.this;
                a = flag;
                super();
            }
            });
            return;

        case 2131755987: 
            DrawingActivity.f(a);
            return;

        case 2131755988: 
            DrawingActivity.a(a, false);
            return;

        case 2131755984: 
            DrawingActivity.g(a);
            return;

        case 2131755983: 
            DrawingActivity.h(a);
            return;
        }
    }

    _cls1.a(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
