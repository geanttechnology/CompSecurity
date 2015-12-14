// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineQueryLogic

static final class cider
    implements cider
{

    public boolean decide(Object obj, Object obj1)
    {
        while (obj1 == null || obj1 == JSONObject.NULL || OfflineQueryLogic.access$000(obj, obj1) > 0) 
        {
            return false;
        }
        return true;
    }

    cider()
    {
    }
}
