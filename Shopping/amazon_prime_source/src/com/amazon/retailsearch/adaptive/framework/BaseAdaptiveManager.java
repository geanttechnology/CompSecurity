// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.framework;


// Referenced classes of package com.amazon.retailsearch.adaptive.framework:
//            AdaptiveManager

public abstract class BaseAdaptiveManager
    implements AdaptiveManager
{

    public BaseAdaptiveManager()
    {
    }

    protected abstract void updateAdaptiveTreatment();
}
