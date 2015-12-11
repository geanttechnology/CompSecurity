// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import com.b.a.a.g;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.dto.response.CategoryResponse;
import com.offerup.android.gson.GsonManager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.service:
//            ApplicationStartupService

final class a
    implements Callback
{

    private ApplicationStartupService a;

    a(ApplicationStartupService applicationstartupservice)
    {
        a = applicationstartupservice;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(a, retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (CategoryResponse)obj;
        if (obj != null && ((CategoryResponse) (obj)).getCategories() != null && ((CategoryResponse) (obj)).getCategories().length > 0)
        {
            ApplicationStartupService.a(a).n(GsonManager.getGson().toJson(((CategoryResponse) (obj)).getCategories()));
        }
    }
}
