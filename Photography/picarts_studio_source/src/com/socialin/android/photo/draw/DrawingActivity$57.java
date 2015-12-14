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

final class b
    implements android.view.r
{

    final DrawingActivity a;
    private View b;

    public final void onClick(View view)
    {
        view = new a(a);
        view.add(new b(0x7f0202f7, a.getString(0x7f08031f), null, true, 0x7f100029));
        view.add(new b(0x7f02031f, a.getString(0x7f0802a1), null, true, 0x7f100028));
        DrawingActivity drawingactivity = a;
        p p1 = WrappingListPopupWindow.a(a);
        p1.a = b;
        p1.b = view;
        p1.c = new android.widget.AdapterView.OnItemClickListener() {

            private DrawingActivity._cls57 a;

            public final void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                switch (i)
                {
                default:
                    return;

                case 0: // '\0'
                    DrawingActivity.am(a.a);
                    return;

                case 1: // '\001'
                    DrawingActivity.an(a.a);
                    break;
                }
            }

            
            {
                a = DrawingActivity._cls57.this;
                super();
            }
        };
        DrawingActivity.e(drawingactivity, p1.b());
    }

    _cls1.a(DrawingActivity drawingactivity, View view)
    {
        a = drawingactivity;
        b = view;
        super();
    }
}
