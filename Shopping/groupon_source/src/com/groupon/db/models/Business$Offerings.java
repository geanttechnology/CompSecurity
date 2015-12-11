// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.db.models:
//            Business

protected static class specials
{

    public List deals;
    public List ordering;
    public List specials;

    protected ()
    {
        ordering = Collections.emptyList();
        deals = Collections.emptyList();
        specials = Collections.emptyList();
    }
}
