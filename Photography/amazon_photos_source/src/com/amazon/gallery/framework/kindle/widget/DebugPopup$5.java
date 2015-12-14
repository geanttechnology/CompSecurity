// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.app.DatePickerDialog;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import java.util.Calendar;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

class this._cls0
    implements bugCallback
{

    final DebugPopup this$0;

    public void run(String s, Object obj)
    {
        s = ThisDayUtils.getThisDayDate(context);
        (new DatePickerDialog(context, DebugPopup.this, s.get(1), s.get(2), s.get(5))).show();
    }

    bugCallback()
    {
        this$0 = DebugPopup.this;
        super();
    }
}
