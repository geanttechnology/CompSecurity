// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface Merchant
{

    public abstract String getDisplayName();

    public abstract String getId();

    public abstract Link getLink();

    public abstract void setDisplayName(String s);

    public abstract void setId(String s);

    public abstract void setLink(Link link);
}
