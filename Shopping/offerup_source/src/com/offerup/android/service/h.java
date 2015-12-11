// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.a.a;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.SystemStatus;
import com.offerup.android.utils.az;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.service:
//            ServerStatusService

final class h
    implements Callback
{

    private ServerStatusService a;

    h(ServerStatusService serverstatusservice)
    {
        a = serverstatusservice;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(a, retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        boolean flag;
        flag = false;
        obj = (SystemStatus)obj;
        response = j.a();
        String s = ((SystemStatus) (obj)).getNoSearchResultsText();
        if (StringUtils.isNotBlank(s))
        {
            response.G(s);
        }
        if (a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionCode >= ((SystemStatus) (obj)).getReserveMinBuild())
        {
            flag = true;
        }
        try
        {
            response.b(flag);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            try
            {
                g.a(this, namenotfoundexception);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                g.a(a, ((Throwable) (obj)));
                return;
            }
        }
        response.c(((SystemStatus) (obj)).getAppMinBuildIceCreamSandwich());
        response.d(((SystemStatus) (obj)).getAppSoftMinBuildIceCreamSandwich());
        response.e(((SystemStatus) (obj)).getAppLatestBuildIceCreamSandwich());
        response.a(((SystemStatus) (obj)).getAppSoftExpDateIceCreamSandwich().toString());
        az.a(a.getApplicationContext());
        obj = new Intent("com.offerup.android.service.ServerStatusService");
        android.support.v4.b.h.a(a.getApplicationContext()).a(((Intent) (obj)));
        return;
    }
}
