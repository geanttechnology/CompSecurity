// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.utility:
//            h

public class w
{

    public static long a()
    {
        long l2;
        Object obj;
        Object obj1;
label0:
        {
            long l1 = -1L;
            obj = g.a().e();
            obj1 = new ArrayList();
            ((List) (obj1)).add(new BasicNameValuePair("token", ((String) (obj))));
            obj1 = (new l()).a("sticker", "pack.status", ((List) (obj1)));
            if (obj1 != null)
            {
                obj = (String)((Pair) (obj1)).first;
                obj1 = (String)((Pair) (obj1)).second;
                if (obj != null)
                {
                    break label0;
                }
                Log.d("StickerUtility", "[getNewestStickDate] Response is null");
                l1 = 0L;
            }
            return l1;
        }
        if (!((String) (obj)).equals("200"))
        {
            Log.d("StickerUtility", (new StringBuilder()).append("[getNewestStickDate] statusCode=").append(((String) (obj))).toString());
            return 0L;
        }
        JSONException jsonexception1;
        try
        {
            obj1 = h.a(((String) (obj1)));
        }
        catch (JSONException jsonexception)
        {
            Log.e("StickerUtility", "[getNewestStickDate] Get result failed");
            return -1L;
        }
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = null;
        obj1 = ((JSONObject) (obj1)).getJSONObject("lastPublished");
        obj = obj1;
_L3:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        l2 = ((JSONObject) (obj)).getLong("all");
        break MISSING_BLOCK_LABEL_187;
        jsonexception1;
        Log.e("StickerUtility", "[getNewestStickDate] Get lastPublished failed");
        if (true) goto _L3; else goto _L2
_L2:
        l2 = -1L;
        return l2;
    }
}
