// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsCommListener, GeneralParser

class FeedsUpdateListener
    implements FeedsCommListener
{

    public FeedsUpdateListener()
    {
    }

    public static FeedsUpdateListener intiListener()
    {
        return new FeedsUpdateListener();
    }

    public void handleError(int i)
    {
    }

    public void update(HttpEntity httpentity, String s)
    {
    }

    public void update(JSONObject jsonobject, String s, HashMap hashmap)
    {
        if (hashmap.containsKey("featuredCatEventType"))
        {
            s = "featuredCategoryEvent";
        }
        if (hashmap.containsKey("featuredTopSportEventType"))
        {
            s = "featuredTopSportEvent";
        }
        try
        {
            s = new GeneralParser(s);
            s.instantiateJSONParser();
            s.parse(jsonobject, hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Utils.sdkLog("Error", 5, jsonobject);
        }
        handleError(4);
        return;
    }
}
