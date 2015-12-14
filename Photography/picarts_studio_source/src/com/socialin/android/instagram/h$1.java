// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.s;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cy.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.instagram:
//            h

final class a
    implements Runnable
{

    private Context a;

    public final void run()
    {
        Object obj = h.d(a);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            JSONArray jsonarray = new JSONArray();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s1 = (String)((Iterator) (obj)).next();
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("identifier", s1);
                    jsonarray.put(jsonobject);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
            }

            if (s.a(a))
            {
                myobfuscated.cy.a.a(a).edit().putLong("instagram.anal.date", (new Date()).getTime()).apply();
                AnalyticUtils.getInstance(a).trackDeviceContactInfo("instagram", jsonarray);
            }
        }
    }

    lyticUtils(Context context)
    {
        a = context;
        super();
    }
}
