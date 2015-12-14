// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    final SelectionFragment a;

    public final void run()
    {
        Object obj = SelectionFragment.p(a).l;
        Bitmap bitmap;
        boolean flag;
        boolean flag1;
        if (SelectionFragment.p(a).n())
        {
            bitmap = ((b) (obj)).a(SelectionFragment.p(a).a, SelectionFragment.p(a).b);
        } else
        {
            bitmap = ((b) (obj)).a(SelectionFragment.p(a).a);
        }
        flag1 = ((b) (obj)).c;
        if (bitmap != null && !bitmap.isRecycled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = a.getActivity();
        if (SelectionFragment.x(a))
        {
            if (bitmap != null && !bitmap.isRecycled())
            {
                c.a(bitmap);
            }
            return;
        } else
        {
            ((Activity) (obj)).runOnUiThread(new Runnable(flag, bitmap, flag1, ((Activity) (obj))) {

                private boolean a;
                private Bitmap b;
                private boolean c;
                private Activity d;
                private SelectionFragment._cls11 e;

                public final void run()
                {
                    e.a.d();
                    if (a)
                    {
                        SelectionFragment.a(e.a, b);
                        return;
                    }
                    SelectionFragment.a(e.a, false);
                    if (c)
                    {
                        Utils.a(d, 0x7f0805ca);
                        return;
                    } else
                    {
                        SelectionFragment.K(e.a);
                        return;
                    }
                }

            
            {
                e = SelectionFragment._cls11.this;
                a = flag;
                b = bitmap;
                c = flag1;
                d = activity;
                super();
            }
            });
            return;
        }
    }

    _cls1.d(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
