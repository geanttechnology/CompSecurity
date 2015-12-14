// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.view.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class c
    implements Runnable
{

    private boolean a;
    private HashMap b;
    private HashMap c;
    private c d;

    public final void run()
    {
        if (SelectionFragment.x(d.d))
        {
            return;
        }
        Activity activity = d.d.getActivity();
        d.d.d();
        com.picsart.studio.editor.fragment.SelectionFragment.a(d.d, false);
        if (a)
        {
            com.picsart.studio.editor.fragment.SelectionFragment.a(d.d, b, c);
            return;
        } else
        {
            Utils.a(activity, 0x7f0805ca);
            return;
        }
    }

    b(b b1, boolean flag, HashMap hashmap, HashMap hashmap1)
    {
        d = b1;
        a = flag;
        b = hashmap;
        c = hashmap1;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$14

/* anonymous class */
    final class SelectionFragment._cls14
        implements Runnable
    {

        final SelectionFragment a;

        public final void run()
        {
            Object obj1 = null;
            boolean flag1 = true;
            Activity activity = a.getActivity();
            if (activity != null && !activity.isFinishing())
            {
                Object obj2 = SelectionFragment.p(a).l;
                Object obj;
                boolean flag;
                boolean flag2;
                if (SelectionFragment.p(a).n())
                {
                    obj = ((b) (obj2)).a(SelectionFragment.p(a).a, SelectionFragment.p(a).b);
                } else
                {
                    obj = ((b) (obj2)).a(SelectionFragment.p(a).a);
                }
                flag2 = ((b) (obj2)).c;
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    com.socialin.android.util.c.a(((Bitmap) (obj)));
                }
                if (!SelectionFragment.x(a))
                {
                    if (!flag)
                    {
                        activity.runOnUiThread(new SelectionFragment._cls14._cls1(flag2, activity));
                        return;
                    }
                    Bitmap bitmap = SelectionFragment.p(a).a;
                    obj2 = SelectionFragment.p(a).b;
                    int i = bitmap.getWidth();
                    int j = bitmap.getHeight();
                    obj = com.socialin.android.photo.view.a.b(i, j);
                    Bitmap bitmap1 = com.socialin.android.util.c.a(((Point) (obj)).x, ((Point) (obj)).y, android.graphics.Bitmap.Config.ARGB_8888);
                    if (bitmap1 != null)
                    {
                        bitmap1.eraseColor(0);
                        obj = new Canvas(bitmap1);
                        obj1 = new Paint();
                        ((Paint) (obj1)).setFilterBitmap(true);
                        ((Canvas) (obj)).drawBitmap(((Bitmap) (obj2)), new Rect(0, 0, i, j), new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), ((Paint) (obj1)));
                        ((Paint) (obj1)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
                        ((Paint) (obj1)).setColor(0xff000000);
                        ((Canvas) (obj)).drawPaint(((Paint) (obj1)));
                        obj = w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), bitmap1);
                        obj1 = w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), bitmap);
                        com.socialin.android.util.c.a(bitmap1);
                        com.picsart.studio.editor.fragment.SelectionFragment.b(a, w.a(com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a)), ((Bitmap) (obj2))));
                        SelectionFragment.L(a);
                    } else
                    {
                        obj = null;
                        flag1 = false;
                    }
                    if (activity != null && !activity.isFinishing())
                    {
                        activity.runOnUiThread(new SelectionFragment._cls14._cls2(this, flag1, ((HashMap) (obj1)), ((HashMap) (obj))));
                        return;
                    }
                }
            }
        }

            
            {
                a = selectionfragment;
                super();
            }

        // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$14$1

/* anonymous class */
        final class SelectionFragment._cls14._cls1
            implements Runnable
        {

            private boolean a;
            private Activity b;
            private SelectionFragment._cls14 c;

            public final void run()
            {
                c.a.d();
                com.picsart.studio.editor.fragment.SelectionFragment.a(c.a, false);
                if (a)
                {
                    Utils.a(b, 0x7f0805ca);
                    return;
                } else
                {
                    SelectionFragment.K(c.a);
                    return;
                }
            }

                    
                    {
                        c = SelectionFragment._cls14.this;
                        a = flag;
                        b = activity;
                        super();
                    }
        }

    }

}
