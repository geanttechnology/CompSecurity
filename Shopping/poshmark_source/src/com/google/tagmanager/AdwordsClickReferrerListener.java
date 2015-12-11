// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            InstallReferrerUtil

class AdwordsClickReferrerListener
    implements DataLayer.Listener
{

    private final Context context;

    public AdwordsClickReferrerListener(Context context1)
    {
        context = context1;
    }

    public void changed(Map map)
    {
        Object obj1 = map.get("gtm.url");
        Object obj = obj1;
        if (obj1 == null)
        {
            map = ((Map) (map.get("gtm")));
            obj = obj1;
            if (map != null)
            {
                obj = obj1;
                if (map instanceof Map)
                {
                    obj = ((Map)map).get("url");
                }
            }
        }
        if (obj != null && (obj instanceof String))
        {
            if ((map = Uri.parse((String)obj).getQueryParameter("referrer")) != null)
            {
                InstallReferrerUtil.addClickReferrer(context, map);
                return;
            }
        }
    }
}
