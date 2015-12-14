// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import com.socialin.android.photo.clipart.e;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class b
    implements Runnable
{

    private boolean a;
    private boolean b;
    private c c;

    public final void run()
    {
        if (!SelectionFragment.x(c.c))
        {
            Activity activity = c.c.getActivity();
            c.c.d();
            SelectionFragment.a(c.c, false);
            if (!a)
            {
                if (b)
                {
                    Utils.a(activity, 0x7f0805ca);
                    return;
                } else
                {
                    SelectionFragment.K(c.c);
                    return;
                }
            }
        }
    }

    ( , boolean flag, boolean flag1)
    {
        c = ;
        a = flag;
        b = flag1;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$15

/* anonymous class */
    final class SelectionFragment._cls15
        implements Runnable
    {

        final SelectionFragment a;

        public final void run()
        {
            android.graphics.Bitmap bitmap;
            Activity activity;
            boolean flag;
            flag = false;
            activity = a.getActivity();
            SelectionDrawController selectiondrawcontroller = SelectionFragment.p(a);
            selectiondrawcontroller.z = false;
            boolean flag1;
            if (selectiondrawcontroller.n())
            {
                bitmap = selectiondrawcontroller.l.a(selectiondrawcontroller.a, selectiondrawcontroller.b);
            } else
            {
                bitmap = selectiondrawcontroller.l.a(selectiondrawcontroller.a);
            }
            if (bitmap != null) goto _L2; else goto _L1
_L1:
            selectiondrawcontroller.z = selectiondrawcontroller.l.c;
_L4:
            flag1 = SelectionFragment.p(a).z;
            if (activity != null && !activity.isFinishing())
            {
                activity.runOnUiThread(new SelectionFragment._cls15._cls1(this, flag, flag1));
            }
            return;
_L2:
            if (e.a(activity, bitmap, "selectionMainFragment") != null)
            {
                flag = true;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                a = selectionfragment;
                super();
            }
    }

}
