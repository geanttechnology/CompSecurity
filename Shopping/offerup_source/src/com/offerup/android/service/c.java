// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.e.a;
import com.b.a.a.g;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.dto.ItemListsResponse;
import com.offerup.android.gson.GsonManager;

// Referenced classes of package com.offerup.android.service:
//            ApplicationStartupService

final class c extends AsyncTask
{

    private ApplicationStartupService a;

    private c(ApplicationStartupService applicationstartupservice, Context context)
    {
        a = applicationstartupservice;
        super();
    }

    c(ApplicationStartupService applicationstartupservice, Context context, byte byte0)
    {
        this(applicationstartupservice, context);
    }

    private transient Void a()
    {
        Object obj = android.support.v4.e.a.b();
        if (obj != null)
        {
            try
            {
                if (((ItemListsResponse) (obj)).isSuccess())
                {
                    obj = GsonManager.getGson().toJson(((ItemListsResponse) (obj)).getItemLists());
                    g.a("MICHAEL", (new StringBuilder("About to save json listsJson string ")).append(((String) (obj)).length()).toString());
                    com.offerup.android.service.ApplicationStartupService.a(a).o(((String) (obj)));
                }
            }
            catch (Exception exception)
            {
                g.a(ApplicationStartupService.c(a), exception);
            }
        }
        return null;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }
}
