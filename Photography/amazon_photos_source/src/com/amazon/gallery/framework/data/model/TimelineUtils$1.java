// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import java.util.Calendar;
import java.util.TimeZone;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineUtils

static final class  extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Calendar initialValue()
    {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    }

    ()
    {
    }
}
