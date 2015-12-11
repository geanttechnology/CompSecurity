// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;

import java.util.List;

// Referenced classes of package com.rdio.android.core.events:
//            RequesterEvent

public class ModelsLoadedEvent extends RequesterEvent
{

    private final boolean isFromStorage;
    private boolean isIncomplete;
    private int loadedCount;
    private List models;
    private List requestedKeys;

    public ModelsLoadedEvent(List list, List list1, int i, boolean flag, boolean flag1, Object obj, Object obj1)
    {
        super(obj, obj1);
        models = list;
        requestedKeys = list1;
        loadedCount = i;
        isFromStorage = flag1;
        isIncomplete = flag;
    }

    public int getLoadedCount()
    {
        return loadedCount;
    }

    public List getModels()
    {
        return models;
    }

    public int getRequestedCount()
    {
        return requestedKeys.size();
    }

    public List getRequestedKeys()
    {
        return requestedKeys;
    }

    public boolean isFromStorage()
    {
        return isFromStorage;
    }

    public boolean isIncomplete()
    {
        return isIncomplete;
    }
}
