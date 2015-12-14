// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.DatePicker;
import java.util.Calendar;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            BeautyProfileActivity

class a
    implements android.app.etListener
{

    final BeautyProfileActivity a;

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        BeautyProfileActivity.k(a).set(1, i);
        BeautyProfileActivity.k(a).set(2, j);
        BeautyProfileActivity.k(a).set(5, k);
        BeautyProfileActivity.l(a);
    }

    (BeautyProfileActivity beautyprofileactivity)
    {
        a = beautyprofileactivity;
        super();
    }
}
