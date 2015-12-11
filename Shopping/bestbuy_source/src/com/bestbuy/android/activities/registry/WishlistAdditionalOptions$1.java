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
//            WishlistAdditionalOptions

class a
    implements android.app.stener
{

    final WishlistAdditionalOptions a;

    private void a()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        WishlistAdditionalOptions.b(a).setText(simpledateformat.format(WishlistAdditionalOptions.a(a).getTime()));
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        WishlistAdditionalOptions.a(a).set(1, i);
        WishlistAdditionalOptions.a(a).set(2, j);
        WishlistAdditionalOptions.a(a).set(5, k);
        a();
    }

    I(WishlistAdditionalOptions wishlistadditionaloptions)
    {
        a = wishlistadditionaloptions;
        super();
    }
}
