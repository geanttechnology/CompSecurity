// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.util.Log;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.m;
import com.socialin.android.photo.tools.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import java.io.File;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    private SelectionFragment a;

    public final void run()
    {
        if (SelectionFragment.o(a) != null && !SelectionFragment.o(a).isRecycled())
        {
            c.a(SelectionFragment.o(a));
        }
        if (SelectionFragment.p(a) != null)
        {
            SelectionDrawController selectiondrawcontroller = SelectionFragment.p(a);
            if (selectiondrawcontroller.b != null && !selectiondrawcontroller.b.isRecycled())
            {
                selectiondrawcontroller.b.recycle();
            }
            if (selectiondrawcontroller.p != null)
            {
                m m1 = selectiondrawcontroller.p;
                m1.d();
                if (m1.c != null)
                {
                    m1.c.a();
                }
                if (m1.d != null)
                {
                    m1.d.a();
                }
            }
            if (selectiondrawcontroller.u != null)
            {
                selectiondrawcontroller.u.a();
            }
        }
        if (SelectionFragment.q(a) && SelectionFragment.p(a) != null)
        {
            Bitmap bitmap = SelectionFragment.p(a).a;
            if (bitmap != null && !bitmap.isRecycled())
            {
                c.a(bitmap);
            }
        }
        if (SelectionFragment.r(a) != null)
        {
            Utils.a(new File(SelectionFragment.r(a)));
        }
        if (SelectionFragment.s(a) != null && (new File((String)SelectionFragment.s(a).get("path"))).delete())
        {
            Log.e("ex1", "Selection file deleted");
        }
    }

    r(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
