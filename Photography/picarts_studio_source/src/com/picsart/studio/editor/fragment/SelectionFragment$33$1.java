// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.util.Log;
import android.view.View;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.select.g;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class ionTryEvent extends g
{

    ionTryEvent()
    {
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$33

/* anonymous class */
    final class SelectionFragment._cls33
        implements android.view.View.OnClickListener
    {

        private SelectionFragment a;

        public final void onClick(View view)
        {
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionTryEvent(SelectionFragment.b(a).a, "undo"));
            if (SelectionFragment.a(a))
            {
                return;
            }
            if (SelectionFragment.C(a))
            {
                SelectionFragment.a(a, true);
                view = new SelectionFragment._cls33._cls1();
                view.i = SelectionFragment.p(a);
                view.a = 2;
                view.b = a;
                view.executeOnExecutor(SelectionFragment.D(a), new Void[] {
                    null
                });
                Log.e("ex1", "maskHasHistory()");
            } else
            {
                SelectionFragment.E(a);
            }
            SelectionFragment.F(a);
        }

            
            {
                a = selectionfragment;
                super();
            }
    }

}
