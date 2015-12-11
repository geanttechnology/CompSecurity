// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.widget.CompoundButton;

// Referenced classes of package com.comcast.cim.android.view.common:
//            SelectionListDialogFragment

class this._cls1
    implements android.widget.lectionListAdapter._cls2
{

    final ner.onSelectionChanged this$1;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag && compoundbutton.getId() != SelectionListDialogFragment.access$200(_fld0) || isToggleable)
        {
            onSelectionChangedListener.onSelectionChanged(compoundbutton.getId());
            return;
        } else
        {
            compoundbutton.setChecked(true);
            return;
        }
    }

    ner()
    {
        this$1 = this._cls1.this;
        super();
    }
}
