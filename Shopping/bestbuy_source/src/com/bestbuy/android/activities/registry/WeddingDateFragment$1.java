// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.widget.DatePicker;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingDateFragment

class a
    implements android.app.eSetListener
{

    final WeddingDateFragment a;

    private void a()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        WeddingDateFragment.b(a).setText(simpledateformat.format(WeddingDateFragment.a(a).getTime()));
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        WeddingDateFragment.a(a).set(1, i);
        WeddingDateFragment.a(a).set(2, j);
        WeddingDateFragment.a(a).set(5, k);
        a();
    }

    (WeddingDateFragment weddingdatefragment)
    {
        a = weddingdatefragment;
        super();
    }
}
