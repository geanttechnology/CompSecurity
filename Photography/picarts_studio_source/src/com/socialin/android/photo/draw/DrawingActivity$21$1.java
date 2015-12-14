// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private boolean a;
    private b b;

    public final void run()
    {
        if (!a)
        {
            DrawingActivity.e(b.b);
        }
    }

    ( , boolean flag)
    {
        b = ;
        a = flag;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$21

/* anonymous class */
    final class DrawingActivity._cls21
        implements android.view.View.OnClickListener
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
                DrawingActivity.a(a, new DrawingActivity._cls21._cls1(this, flag));
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

            
            {
                a = drawingactivity;
                super();
            }
    }

}
