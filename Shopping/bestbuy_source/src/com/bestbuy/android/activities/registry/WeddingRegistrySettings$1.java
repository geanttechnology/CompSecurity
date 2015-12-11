// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.widget.DatePicker;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingRegistrySettings

class a
    implements android.app.Listener
{

    final WeddingRegistrySettings a;

    private void a()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        WeddingRegistrySettings.b(a).setText(simpledateformat.format(WeddingRegistrySettings.a(a).getTime()));
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        WeddingRegistrySettings.a(a).set(1, i);
        WeddingRegistrySettings.a(a).set(2, j);
        WeddingRegistrySettings.a(a).set(5, k);
        a();
    }

    (WeddingRegistrySettings weddingregistrysettings)
    {
        a = weddingregistrysettings;
        super();
    }
}
