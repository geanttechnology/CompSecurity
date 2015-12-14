// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import java.util.Iterator;

// Referenced classes of package com.amazon.insights.delivery:
//            EventStore

public static interface 
    extends Iterator
{

    public abstract String peek();

    public abstract void removeReadEvents();
}
