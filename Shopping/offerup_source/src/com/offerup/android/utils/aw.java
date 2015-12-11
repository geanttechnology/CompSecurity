// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import com.b.a.a.g;
import com.b.a.a.j;
import com.omniata.android.sdk.OmniataChannelResponseHandler;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.utils:
//            av

final class aw
    implements OmniataChannelResponseHandler
{

    private aw()
    {
    }

    aw(byte byte0)
    {
        this();
    }

    public final void onError(int i, Exception exception)
    {
        g.a(com/offerup/android/utils/av.getSimpleName(), exception);
    }

    public final void onSuccess(int i, JSONArray jsonarray)
    {
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() <= 0) goto _L2; else goto _L3
_L3:
        i = 0;
_L4:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        String s = jsonarray.getJSONObject(i).optString("label");
        if (StringUtils.isNotEmpty(s))
        {
            s = s.replace("\"", "");
            j.a().F(s);
            g.a(com/offerup/android/utils/av.getSimpleName(), (new StringBuilder("Received Omniata Channel label of = ")).append(s).toString());
        }
        i++;
        if (true) goto _L4; else goto _L2
        jsonarray;
        g.a(com/offerup/android/utils/av.getSimpleName(), jsonarray);
_L2:
    }
}
