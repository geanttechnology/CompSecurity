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

    final _cls1.a a;

    public final void run()
    {
        Activity activity = a.a.getActivity();
        if (SelectionFragment.x(a.a))
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(SelectionFragment.p(a.a).a) {

                private Bitmap a;
                private SelectionFragment._cls5._cls1 b;

                public final void run()
                {
                    if (SelectionFragment.x(b.a.a))
                    {
                        return;
                    }
                    if (SelectionFragment.b(b.a.a) != null)
                    {
                        SelectionFragment.b(b.a.a).c("selection");
                    }
                    b.a.a.d();
                    AnalyticUtils.getInstance(b.a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionCloseEvent(SelectionFragment.b(b.a.a).a, "done", (int)SelectionFragment.I(b.a.a).d()));
                    SelectionFragment.a(b.a.a, a);
                }

            
            {
                b = SelectionFragment._cls5._cls1.this;
                a = bitmap;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
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

}
