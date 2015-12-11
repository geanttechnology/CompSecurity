// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Dialog;
import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.comcast.cim.android.view.common:
//            SelectionListDialogFragment

class this._cls1
    implements android.view.SelectionListAdapter._cls1
{

    final d this$1;

    public void onClick(View view)
    {
        boolean flag = false;
        int j = view.getId();
        if (SelectionListDialogFragment.access$200(_fld0) < 0 || SelectionListDialogFragment.access$200(_fld0) != j || isToggleable)
        {
            view = _fld0;
            int i = j;
            if (SelectionListDialogFragment.access$200(_fld0) == j)
            {
                i = -1;
            }
            SelectionListDialogFragment.access$202(view, i);
            j = SelectionListDialogFragment.access$300(_fld0).getFirstVisiblePosition();
            view = SelectionListDialogFragment.access$300(_fld0).getChildAt(0);
            if (view == null)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = view.getTop();
            }
            ((is._cls0)SelectionListDialogFragment.access$300(_fld0).getAdapter()).tifyDataSetInvalidated();
            SelectionListDialogFragment.access$300(_fld0).setSelectionFromTop(j, i);
            if (cancelOnSelectionChanged)
            {
                getDialog().cancel();
                return;
            }
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
