// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.brushlib.view.DrawingView;
import myobfuscated.ce.a;
import myobfuscated.ce.b;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.widget.ckListener
{

    private a a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            DrawingActivity.F(a.a);
            return;

        case 1: // '\001'
            com.socialin.android.photo.draw.DrawingActivity.b(a.a).a();
            return;

        case 2: // '\002'
            DrawingActivity.G(a.a);
            break;
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$16

/* anonymous class */
    final class DrawingActivity._cls16
        implements android.view.View.OnClickListener
    {

        final DrawingActivity a;
        private View b;

        public final void onClick(View view)
        {
            a a1;
            p p1;
            int i;
            if (DrawingActivity.c(a))
            {
                view = a.getString(0x7f080147);
            } else
            {
                view = a.getString(0x7f080146);
            }
            if (DrawingActivity.c(a))
            {
                i = 0x7f020451;
            } else
            {
                i = 0x7f02044a;
            }
            a1 = new a(a);
            a1.add(new b(0x7f020381, a.getString(0x7f0802d5), null, true, 0x7f10003c));
            a1.add(new b(0x7f02036e, a.getString(0x7f0802cc), null, true, 0x7f10003b));
            a1.add(new b(i, view, null, true, 0x7f10003d));
            view = a;
            p1 = WrappingListPopupWindow.a(a);
            p1.a = b;
            p1.b = a1;
            p1.c = new DrawingActivity._cls16._cls1(this);
            com.socialin.android.photo.draw.DrawingActivity.a(view, p1.b());
        }

            
            {
                a = drawingactivity;
                b = view;
                super();
            }
    }

}
