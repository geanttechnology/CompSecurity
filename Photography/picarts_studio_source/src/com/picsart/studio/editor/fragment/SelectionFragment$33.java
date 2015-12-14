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

final class a
    implements android.view..SelectionFragment._cls33
{

    private SelectionFragment a;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "undo"));
        if (SelectionFragment.a(a))
        {
            return;
        }
        if (SelectionFragment.C(a))
        {
            SelectionFragment.a(a, true);
            view = new g() {

            };
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

    _cls1(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
