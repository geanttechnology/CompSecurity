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
    implements android.view.
{

    final SelectionFragment a;

    public final void onClick(View view)
    {
        if (SelectionFragment.a(a))
        {
            return;
        } else
        {
            g.a(new Runnable() {

                final SelectionFragment._cls5 a;

                public final void run()
                {
                    Activity activity = a.a.getActivity();
                    if (SelectionFragment.x(a.a))
                    {
                        return;
                    } else
                    {
                        activity.runOnUiThread(new Runnable(this, SelectionFragment.p(a.a).a) {

                            private Bitmap a;
                            private _cls1 b;

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
                b = _pcls1;
                a = bitmap;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                a = SelectionFragment._cls5.this;
                super();
            }
            }, true, SelectionFragment.D(a));
            SelectionFragment.a(a, true);
            view.setEnabled(false);
            SelectionFragment.F(a);
            return;
        }
    }

    _cls1.a(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
