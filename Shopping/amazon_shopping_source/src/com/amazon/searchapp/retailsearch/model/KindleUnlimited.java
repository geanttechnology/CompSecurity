// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            StyledText, Link

public interface KindleUnlimited
{

    public abstract StyledText getBadge();

    public abstract boolean getIsSubscribed();

    public abstract Link getLink();

    public abstract List getMessages();

    public abstract String getPrice();
}
