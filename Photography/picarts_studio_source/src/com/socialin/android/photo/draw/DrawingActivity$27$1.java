// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
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
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 33
    //                   1 44
    //                   2 55
    //                   3 79;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        DrawingActivity.P(a.a);
        return;
_L3:
        DrawingActivity.Q(a.a);
        return;
_L4:
        if (!DrawingActivity.L(a.a))
        {
            DrawingActivity.R(a.a);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!DrawingActivity.L(a.a))
        {
            DrawingActivity.S(a.a);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$27

/* anonymous class */
    final class DrawingActivity._cls27
        implements android.view.View.OnClickListener
    {

        final DrawingActivity a;

        public final void onClick(View view)
        {
            boolean flag1 = true;
            Object obj;
            p p1;
            int i;
            int j;
            boolean flag;
            if (DrawingActivity.L(a))
            {
                i = 0x7f0202f2;
            } else
            {
                i = 0x7f0202f3;
            }
            if (DrawingActivity.L(a))
            {
                j = 0x7f020314;
            } else
            {
                j = 0x7f020315;
            }
            view = new a(a);
            view.add(new b(0x7f0202f4, a.getString(0x7f08022e), null, true, 0x7f100035));
            view.add(new b(0x7f0202f6, a.getString(0x7f0804cf), null, true, 0x7f100038));
            obj = a.getString(0x7f080092);
            if (!DrawingActivity.L(a))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.add(new b(i, ((String) (obj)), null, flag, 0x7f100031));
            obj = a.getString(0x7f080065);
            if (!DrawingActivity.L(a))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.add(new b(j, ((String) (obj)), null, flag, 0x7f100030));
            obj = a;
            p1 = WrappingListPopupWindow.a(a);
            p1.a = DrawingActivity.T(a);
            p1.b = view;
            p1.c = new DrawingActivity._cls27._cls1(this);
            DrawingActivity.c(((DrawingActivity) (obj)), p1.b());
        }

            
            {
                a = drawingactivity;
                super();
            }
    }

}
