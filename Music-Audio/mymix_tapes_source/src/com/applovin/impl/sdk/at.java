// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import java.util.TimerTask;

// Referenced classes of package com.applovin.impl.sdk:
//            as, ar, aq, au

class at extends TimerTask
{

    final as a;

    at(as as1)
    {
        a = as1;
        super();
    }

    public void run()
    {
        aq.a(a.a.a).runOnUiThread(new au(this));
    }
}
