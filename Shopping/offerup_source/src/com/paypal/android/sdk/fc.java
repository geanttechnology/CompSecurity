// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.paypal.android.sdk:
//            cl, cm

public final class fc
{

    public LinearLayout a;
    public TextView b;
    private LinearLayout c;

    public fc(Context context)
    {
        c = new LinearLayout(context);
        c.setOrientation(0);
        b = new TextView(context);
        b.setText("server");
        b.setTextColor(-1);
        b.setBackgroundColor(cl.e);
        b.setGravity(17);
        c.addView(b);
        cm.a(b, "8dip", "8dip", "8dip", "8dip");
        cm.a(b, -2, -2);
        cm.b(b, null, "15dip", null, "15dip");
        cm.a(b, 1, 1.0F);
        a = c;
    }
}
