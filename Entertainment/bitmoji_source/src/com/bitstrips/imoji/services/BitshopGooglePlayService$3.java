// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.util.Log;
import com.bitstrips.imoji.models.BitshopPack;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.services:
//            BitshopGooglePlayService

class val.payload
    implements Callback
{

    final BitshopGooglePlayService this$0;
    final String val$payload;

    public void failure(RetrofitError retrofiterror)
    {
        Log.e("BitshopGooglePlayServ", retrofiterror.toString());
        BitshopGooglePlayService.access$300(BitshopGooglePlayService.this, 0x7f060033);
        try
        {
            retrofiterror = (new JSONObject(val$payload)).getJSONObject("purchase_pack").getString("application_pack_store_id");
            ((BitshopPack)packsMap.get(retrofiterror)).setUnpurchased();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RetrofitError retrofiterror)
        {
            Log.e("BitshopGooglePlayServ", "Failed to create or get product ID from payload JSON object");
        }
        retrofiterror.printStackTrace();
    }

    public volatile void success(Object obj, Response response)
    {
        success((Void)obj, response);
    }

    public void success(Void void1, Response response)
    {
        BitshopGooglePlayService.access$100(BitshopGooglePlayService.this);
    }

    ()
    {
        this$0 = final_bitshopgoogleplayservice;
        val$payload = String.this;
        super();
    }
}
