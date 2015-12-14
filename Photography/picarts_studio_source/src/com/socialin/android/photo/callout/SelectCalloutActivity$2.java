// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity, b, Callout

final class e extends Thread
{

    final SelectCalloutActivity a;
    private String b[];
    private int c;
    private int d;
    private int e;

    public final void run()
    {
        SelectCalloutActivity.a(a, true);
        SelectCalloutActivity.a(a, new HashMap());
        for (int i = 0; i < b.E.size(); i++)
        {
            Callout callout = new Callout(a, b, (HashMap)b.E.get(i), "ABC", c, d, e, e, false, 1);
            SelectCalloutActivity.a(a).put(Integer.valueOf(i), callout);
        }

        a.runOnUiThread(new Runnable() {

            private SelectCalloutActivity._cls2 a;

            public final void run()
            {
                SelectCalloutActivity.a(a.a, false);
                SelectCalloutActivity.b(a.a);
            }

            
            {
                a = SelectCalloutActivity._cls2.this;
                super();
            }
        });
    }

    _cls1.a(SelectCalloutActivity selectcalloutactivity, String as[], int i, int j, int k)
    {
        a = selectcalloutactivity;
        b = as;
        c = i;
        d = j;
        e = k;
        super();
    }
}
