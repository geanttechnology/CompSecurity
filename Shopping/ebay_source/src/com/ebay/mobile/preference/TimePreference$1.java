// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.widget.TimePicker;

// Referenced classes of package com.ebay.mobile.preference:
//            TimePreference

class this._cls0
    implements android.widget.ChangedListener
{

    final TimePreference this$0;

    public void onTimeChanged(TimePicker timepicker, int i, int j)
    {
        TimePreference.access$100(TimePreference.this, TimePreference.access$000(TimePreference.this, timepicker));
    }

    ner()
    {
        this$0 = TimePreference.this;
        super();
    }
}
