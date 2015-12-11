// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.Bundle;
import android.util.Log;
import com.b.a.a.g;
import com.offerup.android.dto.Data;
import com.offerup.android.dto.OfferUpResponse;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.c;
import com.offerup.android.utils.v;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            hb, SearchActivity

final class ha
    implements Callback
{

    private int a;
    private final hb b;
    private SearchActivity c;

    private ha(SearchActivity searchactivity, int i, hb hb1)
    {
        c = searchactivity;
        super();
        if (hb1 == null)
        {
            b = hb.a;
        } else
        {
            b = hb1;
        }
        a = i;
    }

    ha(SearchActivity searchactivity, int i, hb hb1, byte byte0)
    {
        this(searchactivity, i, hb1);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        SearchActivity.d(c, false);
        c.i();
        SearchActivity.e(c, true);
    }

    public final void success(Object obj, Response response)
    {
        Bundle bundle;
        int i;
        i = 1;
        OfferUpResponse offerupresponse = (OfferUpResponse)obj;
        int j;
        try
        {
            SearchActivity.d(c, false);
            c.i();
            if (a == 1)
            {
                SearchActivity.j(c).clear();
                SearchActivity.h(c);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.c(getClass().getName(), Log.getStackTraceString(((Throwable) (obj))));
            return;
        }
        if (offerupresponse == null) goto _L2; else goto _L1
_L1:
        if (!offerupresponse.isSuccess()) goto _L2; else goto _L3
_L3:
        SearchActivity.a(c, offerupresponse.getData().getTotal());
        c.a(offerupresponse, a);
        if (!StringUtils.isNotEmpty(SearchActivity.a(c))) goto _L2; else goto _L4
_L4:
        j = a;
        if (j != 1) goto _L2; else goto _L5
_L5:
        obj = new JSONObject();
        ((JSONObject) (obj)).put("item_list", SearchActivity.k(c));
        ((JSONObject) (obj)).put("referrer", b.toString());
        if (offerupresponse == null) goto _L7; else goto _L6
_L6:
        if (!offerupresponse.isSuccess() || offerupresponse.getData().getTotal() <= 0) goto _L7; else goto _L8
_L8:
        ((JSONObject) (obj)).put("success", i);
        ((JSONObject) (obj)).put("keywords", SearchActivity.a(c));
        av.a("ou_search", ((JSONObject) (obj)));
        com.offerup.android.utils.c.a(c.getApplicationContext(), "ou_search");
        am.a("ou_search", ((JSONObject) (obj)));
_L14:
        bundle = new Bundle();
        if (!StringUtils.isNotEmpty(SearchActivity.l(c))) goto _L10; else goto _L9
_L9:
        obj = (new StringBuilder(", ")).append(SearchActivity.l(c)).toString();
_L15:
        if (!StringUtils.isNotEmpty(SearchActivity.k(c)))
        {
            break MISSING_BLOCK_LABEL_435;
        }
        response = (new StringBuilder(", ")).append(SearchActivity.k(c)).toString();
_L17:
        bundle.putString("fb_search_string", (new StringBuilder()).append(SearchActivity.a(c)).append(((String) (obj))).append(response).toString());
        if (offerupresponse == null) goto _L12; else goto _L11
_L11:
        if (!offerupresponse.isSuccess() || offerupresponse.getData().getTotal() <= 0) goto _L12; else goto _L13
_L13:
        bundle.putString("fb_success", "1");
_L16:
        v.a(c.getApplicationContext(), "fb_mobile_search", bundle);
        return;
        obj;
        g.a(com/offerup/android/activities/SearchActivity.getSimpleName(), "Exception logging Omniata data", ((Exception) (obj)));
          goto _L14
_L10:
        obj = "";
          goto _L15
_L12:
        bundle.putString("fb_success", "0");
          goto _L16
_L2:
        return;
_L7:
        i = 0;
          goto _L8
        response = "";
          goto _L17
    }
}
