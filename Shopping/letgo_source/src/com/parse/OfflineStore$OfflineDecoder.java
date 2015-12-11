// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDecoder, OfflineStore

private class <init> extends ParseDecoder
{

    private Map offlineObjects;
    final OfflineStore this$0;

    public Object decode(Object obj)
    {
        if ((obj instanceof JSONObject) && ((JSONObject)obj).optString("__type").equals("OfflineObject"))
        {
            obj = ((JSONObject)obj).optString("uuid");
            return ((cu)offlineObjects.get(obj)).e();
        } else
        {
            return super.decode(obj);
        }
    }

    private (Map map)
    {
        this$0 = OfflineStore.this;
        super();
        offlineObjects = map;
    }

    offlineObjects(Map map, offlineObjects offlineobjects)
    {
        this(map);
    }
}
