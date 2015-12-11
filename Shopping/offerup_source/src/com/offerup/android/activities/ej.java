// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.dto.response.CategoryResponse;
import com.offerup.android.gson.GsonManager;
import com.offerup.android.h.c;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            NewPostActivity

final class ej
    implements Callback
{

    private c a;
    private NewPostActivity b;

    ej(NewPostActivity newpostactivity, c c1)
    {
        b = newpostactivity;
        a = c1;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a(b, retrofiterror);
        a.a();
    }

    public final void success(Object obj, Response response)
    {
        obj = (CategoryResponse)obj;
        if (obj != null && ((CategoryResponse) (obj)).getCategories() != null && ((CategoryResponse) (obj)).getCategories().length > 0)
        {
            b.e.n(GsonManager.getGson().toJson(obj));
            a.a(((CategoryResponse) (obj)).getCategories());
        }
    }
}
