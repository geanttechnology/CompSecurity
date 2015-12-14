// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Activity;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.socialin.android.instagram:
//            d, h, a

public class e extends com.socialin.android.instagram.d
{

    private static final String c = com/socialin/android/instagram/e.getSimpleName();

    public e()
    {
    }

    public final List a()
    {
        ArrayList arraylist = new ArrayList();
        Object obj1 = h.a(getActivity().getApplicationContext());
        Object obj;
        obj = "";
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        obj = (new StringBuilder("&access_token=")).append(((a) (obj1)).a).toString();
        obj = ((JSONObject)(new JSONTokener(Utils.a((new URL((new StringBuilder("https://api.instagram.com/v1/media/popular/?client_id=c73708fbbf72408eb6b5dd676da16dba")).append(((String) (obj))).toString())).openConnection().getInputStream()))).nextValue()).getJSONArray("data");
        int i = 0;
_L1:
        String s;
        if (i >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj1 = ((JSONArray) (obj)).getJSONObject(i);
        s = ((JSONObject) (obj1)).optString("type", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (!"image".equals(s))
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj1 = a(((JSONObject) (obj1)));
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        arraylist.add(obj1);
        i++;
          goto _L1
        Exception exception;
        exception;
        d.b(c, "loadPhotos", exception);
        return arraylist;
    }

    public final void b()
    {
    }

}
