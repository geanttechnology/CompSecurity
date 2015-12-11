// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface Page
{

    public abstract Link getLink();

    public abstract int getPage();

    public abstract String getType();

    public abstract void setLink(Link link);

    public abstract void setPage(int i);

    public abstract void setType(String s);
}
