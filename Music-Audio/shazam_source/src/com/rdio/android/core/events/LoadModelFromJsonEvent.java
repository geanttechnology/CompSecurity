// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;

import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class LoadModelFromJsonEvent extends RequesterEvent
{

    private boolean loadWithDefaultExtras;
    private JSONObject modelJson;

    public LoadModelFromJsonEvent(JSONObject jsonobject, boolean flag, Object obj, Object obj1)
    {
        super(obj, obj1);
        modelJson = jsonobject;
        loadWithDefaultExtras = flag;
    }

    public JSONObject getModelJson()
    {
        return modelJson;
    }

    public boolean isLoadWithDefaultExtras()
    {
        return loadWithDefaultExtras;
    }
}
