// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.b.a.a.g;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.ReportResponse;
import com.offerup.android.utils.as;
import org.apache.commons.lang3.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ItemDetailActivity, a, OfferUpWebViewActivity

final class cu
    implements Callback
{

    private ItemDetailActivity a;

    private cu(ItemDetailActivity itemdetailactivity)
    {
        a = itemdetailactivity;
        super();
    }

    cu(ItemDetailActivity itemdetailactivity, byte byte0)
    {
        this(itemdetailactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        try
        {
            a.i();
            a.a("Error", a.getString(0x7f09017b));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RetrofitError retrofiterror)
        {
            Log.e(com/offerup/android/activities/ItemDetailActivity.getSimpleName(), Log.getStackTraceString(retrofiterror));
        }
    }

    public final void success(Object obj, Response response)
    {
        response = (ReportResponse)obj;
        a.i();
        if (response == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        long l;
        if (!StringUtils.isNotEmpty(response.getToken()))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = a.f;
        response = response.getToken();
        l = ItemDetailActivity.c(a).getId();
        try
        {
            Intent intent = new Intent(((a) (obj)).a, com/offerup/android/activities/OfferUpWebViewActivity);
            intent.putExtra("uri", as.a((new StringBuilder("https://offerupnow.com/")).append("report/item/").append(l).toString(), response));
            intent.putExtra("hideMenuOptions", true);
            ((a) (obj)).a.startActivityForResult(intent, 545);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Response response) { }
        try
        {
            g.a(obj, response);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(com/offerup/android/activities/ItemDetailActivity.getSimpleName(), Log.getStackTraceString(((Throwable) (obj))));
        }
        return;
        a.a("Error", a.getString(0x7f09017b));
        return;
    }
}
