// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import java.lang.ref.WeakReference;
import java.util.Map;

public class ScopedObjects
{

    private WeakReference contextWeakReference;
    private Map scopedObjects;

    public ScopedObjects(WeakReference weakreference, Map map)
    {
        contextWeakReference = weakreference;
        scopedObjects = map;
    }

    public WeakReference getContextWeakReference()
    {
        return contextWeakReference;
    }

    public Map getScopedObjects()
    {
        return scopedObjects;
    }
}
