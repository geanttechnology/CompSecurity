// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.ListAdapter;
import com.groupon.adapter.GuestsPickerAdapter;

// Referenced classes of package com.groupon.view:
//            GuestsPickerDialog, FixedPositionListView

class this._cls0
    implements .OnPositionChangedListener
{

    final GuestsPickerDialog this$0;

    public void onStartScroll()
    {
        ((GuestsPickerAdapter)GuestsPickerDialog.access$100(GuestsPickerDialog.this).getAdapter()).setSelectedPosition(-1);
    }

    public void onStopScroll(int i)
    {
        GuestsPickerDialog.access$002(GuestsPickerDialog.this, ((Integer)GuestsPickerDialog.access$100(GuestsPickerDialog.this).getAdapter().getItem(i)).intValue());
        ((GuestsPickerAdapter)GuestsPickerDialog.access$100(GuestsPickerDialog.this).getAdapter()).setSelectedPosition(i);
        GuestsPickerDialog.access$200(GuestsPickerDialog.this);
    }

    r()
    {
        this$0 = GuestsPickerDialog.this;
        super();
    }
}
