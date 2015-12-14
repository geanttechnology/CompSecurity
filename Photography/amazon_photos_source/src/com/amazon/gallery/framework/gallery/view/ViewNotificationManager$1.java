// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewNotificationManager

static final class I extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Collection initialValue()
    {
        return new ArrayList();
    }

    I()
    {
    }
}
