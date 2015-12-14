// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.DatePicker;
import android.widget.TextView;
import com.cyberlink.beautycircle.utility.i;
import java.util.Calendar;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleFillDataActivity

class a
    implements android.app.tener
{

    final FreeSampleFillDataActivity a;

    public void onDateSet(DatePicker datepicker, int j, int k, int l)
    {
        FreeSampleFillDataActivity.b(a).set(1, j);
        FreeSampleFillDataActivity.b(a).set(2, k);
        FreeSampleFillDataActivity.b(a).set(5, l);
        FreeSampleFillDataActivity.n(a).setText(i.c(FreeSampleFillDataActivity.b(a).getTime()));
    }

    Q(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        a = freesamplefilldataactivity;
        super();
    }
}
