// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.e.a;
import android.widget.Toast;
import com.b.a.a.g;
import com.jumio.netverify.sdk.NetverifySDK;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.OfferResponse;
import com.offerup.android.dto.Person;
import com.offerup.android.network.d;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.c;
import com.offerup.android.utils.n;
import com.offerup.android.utils.v;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.activities:
//            ai, aj, BuyActivity, a, 
//            PaymentMethodActivity

public final class ah extends AsyncTask
{

    private BuyActivity a;

    protected ah(BuyActivity buyactivity)
    {
        a = buyactivity;
        super();
    }

    protected final Object doInBackground(Object aobj[])
    {
        ai aai[] = (ai[])aobj;
        aobj = null;
        if (aai.length > 0)
        {
            aobj = aai[0];
            OfferResponse offerresponse = d.a(com.offerup.android.activities.ai.a(((ai) (aobj))).getId(), ai.b(((ai) (aobj))).doubleValue());
            aobj = new aj(a, offerresponse, ((ai) (aobj)), (byte)0);
        }
        return ((Object) (aobj));
    }

    protected final void onPostExecute(Object obj)
    {
        int i;
        i = 1;
        obj = (aj)obj;
        a.i();
        if (obj == null || com.offerup.android.activities.aj.a(((aj) (obj))) == null || !com.offerup.android.activities.aj.a(((aj) (obj))).isSuccess())
        {
            break MISSING_BLOCK_LABEL_417;
        }
        Item item = com.offerup.android.activities.ai.a(aj.b(((aj) (obj))));
        if (item == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("bid_amount", ai.b(aj.b(((aj) (obj)))));
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("currency", "USD");
        jsonobject.put("item_id", item.getId());
        jsonobject.put("item_price", item.getPrice());
        if (item.getListingType() != 1)
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        av.a("ou_item_bid", jsonobject);
        c.a(a.getApplicationContext(), "ou_item_bid");
        am.a("ou_item_bid", jsonobject);
_L1:
        Bundle bundle = new Bundle();
        bundle.putString("fb_currency", "USD");
        if (a.a != null && a.a.getCategory() != null)
        {
            bundle.putString("fb_content_type", a.a.getCategory().getName());
        }
        v.a(a, "MadeBid", ai.b(aj.b(((aj) (obj)))).doubleValue(), bundle);
        JSONException jsonexception;
        if (a.a.isPayable() && NetverifySDK.isSupportedPlatform())
        {
            obj = a;
            com.offerup.android.activities.a a1 = ((BuyActivity) (obj)).f;
            Item item1 = ((BuyActivity) (obj)).a;
            double d1 = ((BuyActivity) (obj)).b;
            Intent intent = new Intent(a1.a, com/offerup/android/activities/PaymentMethodActivity);
            intent.putExtra("item", item1);
            intent.putExtra("price", d1);
            a1.a.startActivityForResult(intent, 3);
            ((BuyActivity) (obj)).finish();
            return;
        } else
        {
            Toast.makeText(a, "Offer Sent!", 0).show();
            android.support.v4.e.a.j();
            obj = new Intent();
            a.setResult(-1, ((Intent) (obj)));
            a.finish();
            return;
        }
        jsonexception;
        g.a(com/offerup/android/activities/BuyActivity.getSimpleName(), "Exception logging Omniata data", jsonexception);
          goto _L1
        if (obj == null)
        {
            com.offerup.android.activities.BuyActivity.a(a, null);
            return;
        }
        if (com.offerup.android.activities.aj.a(((aj) (obj))) != null && com.offerup.android.activities.aj.a(((aj) (obj))).getStatus() != null && com.offerup.android.activities.aj.a(((aj) (obj))).getStatus().getCode() != null && com.offerup.android.activities.aj.a(((aj) (obj))).getStatus().getCode().contains("418"))
        {
            n.a(a, a.a.getOwner().getId());
            return;
        } else
        {
            com.offerup.android.activities.BuyActivity.a(a, com.offerup.android.activities.aj.a(((aj) (obj))));
            return;
        }
    }

    protected final void onPreExecute()
    {
        a.g = ProgressDialog.show(a, "", "Please wait");
    }
}
