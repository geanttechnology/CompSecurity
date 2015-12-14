// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import java.util.Comparator;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo:
//            f

final class 
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (JSONObject)obj;
        obj1 = (JSONObject)obj1;
        if (((JSONObject) (obj)).optInt("usedCount") == ((JSONObject) (obj1)).optInt("usedCount")) goto _L2; else goto _L1
_L1:
        if (((JSONObject) (obj1)).optInt("usedCount") >= ((JSONObject) (obj)).optInt("usedCount")) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        return 1;
_L2:
        if (((JSONObject) (obj1)).optInt("last_date") >= ((JSONObject) (obj)).optInt("last_date"))
        {
            return ((JSONObject) (obj1)).optInt("last_date") != ((JSONObject) (obj)).optInt("last_date") ? 1 : 0;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    ()
    {
    }
}
