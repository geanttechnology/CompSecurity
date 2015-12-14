// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;


// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            CustomerMetric

static class pe
{

    static final int $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[];

    static 
    {
        $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type = new int[pe.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[pe.EVENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[pe.SESSION.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$foundation$metrics$customer$CustomerMetric$Type[pe.FIRST_START.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
