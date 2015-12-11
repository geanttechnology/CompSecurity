// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;

import java.util.List;
import org.json.JSONArray;

// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class LoadModelsEvent extends RequesterEvent
{

    private List extras;
    private List keys;
    private boolean loadWithDefaultExtras;
    public JSONArray options;

    public LoadModelsEvent(List list, List list1, Object obj, Object obj1)
    {
        super(obj, obj1);
        extras = list1;
        keys = list;
        loadWithDefaultExtras = true;
    }

    public LoadModelsEvent(List list, List list1, boolean flag, Object obj, Object obj1)
    {
        super(obj, obj1);
        extras = list1;
        keys = list;
        loadWithDefaultExtras = flag;
    }

    public List getExtras()
    {
        return extras;
    }

    public List getKeys()
    {
        return keys;
    }

    public boolean isLoadWithDefaultExtras()
    {
        return loadWithDefaultExtras;
    }
}
