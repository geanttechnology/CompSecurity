// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.os.AsyncTask;
import com.b.a.a.g;
import com.b.a.a.j;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.offerup.android.utils.ba;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.service:
//            e, ApplicationStartupService

final class d extends AsyncTask
{

    final ApplicationStartupService a;

    private d(ApplicationStartupService applicationstartupservice)
    {
        a = applicationstartupservice;
        super();
    }

    d(ApplicationStartupService applicationstartupservice, byte byte0)
    {
        this(applicationstartupservice);
    }

    private transient Void a()
    {
        if (!ba.a()) goto _L2; else goto _L1
_L1:
        Object obj = ba.b();
        if (!StringUtils.isNotEmpty(((CharSequence) (obj)))) goto _L2; else goto _L3
_L3:
        obj = AccessToken.getCurrentAccessToken();
        if (obj == null) goto _L5; else goto _L4
_L4:
        Exception exception;
        try
        {
            GraphRequest.newMeRequest(((AccessToken) (obj)), new e(this)).executeAndWait();
            if (StringUtils.isNotEmpty(((AccessToken) (obj)).getToken()))
            {
                ApplicationStartupService.a(a).f(((AccessToken) (obj)).getToken());
            }
        }
        catch (Exception exception1)
        {
            g.a(ApplicationStartupService.c(a), exception1);
        }
_L2:
        return null;
_L5:
        g.a(ApplicationStartupService.c(a), "Logging user out due to null or closed FB session");
        ba.a(a.getApplicationContext());
          goto _L2
        exception;
        g.a(ApplicationStartupService.c(a), exception);
          goto _L2
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
