// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            TypedContent

public interface DynamicProductContent
{

    public abstract TypedContent getContent();

    public abstract boolean getIncludesImage();

    public abstract String getMessage();

    public abstract void setContent(TypedContent typedcontent);

    public abstract void setIncludesImage(boolean flag);

    public abstract void setMessage(String s);
}
