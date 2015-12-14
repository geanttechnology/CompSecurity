// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import myobfuscated.ce.b;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b
    implements android.view.r
{

    final DrawingActivity a;
    private View b;

    public final void onClick(View view)
    {
        view = null;
        boolean flag1 = true;
        Object obj = com.socialin.android.photo.draw.DrawingActivity.b(a).c;
        Object obj1;
        boolean flag;
        int i;
        if (obj != null && ((a) (obj)).k != null && !((a) (obj)).k.isDraft())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = new myobfuscated.ce.a(a);
        ((myobfuscated.ce.a) (obj)).add(new b(0x7f0203ba, a.getString(0x7f080309), null, true, 0x7f100036));
        ((myobfuscated.ce.a) (obj)).add(new b(0x7f0203bf, a.getString(0x7f0804c2), null, true, 0x7f100037));
        ((myobfuscated.ce.a) (obj)).add(new b(0x7f02035b, a.getString(0x7f08056f), null, true, 0x7f10003a));
        if (flag)
        {
            i = 0x7f0203e5;
        } else
        {
            i = 0x7f0203e6;
        }
        obj1 = a.getString(0x7f08056e);
        if (flag)
        {
            view = a.getString(0x7f080129);
        }
        if (flag)
        {
            flag1 = false;
        }
        ((myobfuscated.ce.a) (obj)).add(new b(i, ((String) (obj1)), view, flag1, 0x7f100039));
        view = a;
        obj1 = WrappingListPopupWindow.a(a);
        obj1.a = b;
        obj1.b = ((android.widget.ListAdapter) (obj));
        obj1.c = new android.widget.AdapterView.OnItemClickListener() {

            private DrawingActivity._cls17 a;

            public final void onItemClick(AdapterView adapterview, View view1, int j, long l)
            {
                switch (j)
                {
                default:
                    return;

                case 0: // '\0'
                    DrawingActivity.H(a.a);
                    return;

                case 1: // '\001'
                    DrawingActivity.I(a.a);
                    return;

                case 2: // '\002'
                    DrawingActivity.J(a.a);
                    return;

                case 3: // '\003'
                    adapterview = a.a;
                    break;
                }
                boolean flag2;
                if (!com.socialin.android.photo.draw.DrawingActivity.b(a.a).c.k.isDraft())
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                DrawingActivity.c(adapterview, flag2);
            }

            
            {
                a = DrawingActivity._cls17.this;
                super();
            }
        };
        com.socialin.android.photo.draw.DrawingActivity.b(view, ((p) (obj1)).b());
    }

    _cls1.a(DrawingActivity drawingactivity, View view)
    {
        a = drawingactivity;
        b = view;
        super();
    }
}
