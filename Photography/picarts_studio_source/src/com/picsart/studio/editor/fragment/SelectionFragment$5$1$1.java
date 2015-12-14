// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.g;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    private Bitmap a;
    private a b;

    public final void run()
    {
        if (SelectionFragment.x(b.b.b))
        {
            return;
        }
        if (SelectionFragment.b(b.b.b) != null)
        {
            SelectionFragment.b(b.b.b).c("selection");
        }
        b.b.b.d();
        AnalyticUtils.getInstance(b.b.b.getActivity()).track(new com.socialin.android.apiv3.events.ionCloseEvent(SelectionFragment.b(b.b.b).a, "done", (int)SelectionFragment.I(b.b.b).d()));
        SelectionFragment.a(b.b.b, a);
    }

    onCloseEvent(onCloseEvent oncloseevent, Bitmap bitmap)
    {
        b = oncloseevent;
        a = bitmap;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$5

/* anonymous class */
    final class SelectionFragment._cls5
        implements android.view.View.OnClickListener
    {

        final SelectionFragment a;

        public final void onClick(View view)
        {
            if (SelectionFragment.a(a))
            {
                return;
            } else
            {
                g.a(new SelectionFragment._cls5._cls1(this), true, SelectionFragment.D(a));
                SelectionFragment.a(a, true);
                view.setEnabled(false);
                SelectionFragment.F(a);
                return;
            }
        }

            
            {
                a = selectionfragment;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$5$1

/* anonymous class */
    final class SelectionFragment._cls5._cls1
        implements Runnable
    {

        final SelectionFragment._cls5 a;

        public final void run()
        {
            Activity activity = a.a.getActivity();
            if (SelectionFragment.x(a.a))
            {
                return;
            } else
            {
                activity.runOnUiThread(new SelectionFragment._cls5._cls1._cls1(this, SelectionFragment.p(a.a).a));
                return;
            }
        }

            
            {
                a = _pcls5;
                super();
            }
    }

}
