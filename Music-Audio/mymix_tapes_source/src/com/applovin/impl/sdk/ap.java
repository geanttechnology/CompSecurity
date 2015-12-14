// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Intent;
import com.applovin.adview.AppLovinConfirmationActivity;

// Referenced classes of package com.applovin.impl.sdk:
//            ao, bw, AppLovinSdkImpl, n

class ap
    implements Runnable
{

    final ao a;

    ap(ao ao1)
    {
        a = ao1;
        super();
    }

    public void run()
    {
        String s1 = (String)ao.a(a).a(bw.ab);
        String s = a.b();
        String s2 = (String)ao.a(a).a(bw.ag);
        if (n.a(com/applovin/adview/AppLovinConfirmationActivity, ao.b(a)))
        {
            try
            {
                Intent intent = new Intent(ao.b(a), com/applovin/adview/AppLovinConfirmationActivity);
                intent.putExtra("dialog_title", s1);
                intent.putExtra("dialog_body", s);
                intent.putExtra("dialog_button_text", s2);
                ao.b(a).startActivity(intent);
                return;
            }
            catch (Throwable throwable)
            {
                a.a(s, throwable);
            }
            return;
        } else
        {
            a.a(s, null);
            return;
        }
    }
}
