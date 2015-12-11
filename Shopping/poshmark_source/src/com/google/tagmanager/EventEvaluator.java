// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            Runtime

class EventEvaluator
{

    private final ResourceUtil.ExpandedResource mResource;
    private final Runtime mRuntime;

    public EventEvaluator(Runtime runtime, ResourceUtil.ExpandedResource expandedresource)
    {
        if (runtime == null)
        {
            throw new NullPointerException("runtime cannot be null");
        }
        mRuntime = runtime;
        if (expandedresource != runtime.getResource())
        {
            throw new IllegalArgumentException("resource must be the same as the resource in runtime");
        } else
        {
            mResource = runtime.getResource();
            return;
        }
    }

    void evaluateEvent(String s)
    {
        throw new UnsupportedOperationException("this code not yet written");
    }
}
