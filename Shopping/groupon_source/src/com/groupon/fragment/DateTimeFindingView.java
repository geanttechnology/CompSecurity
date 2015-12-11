// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragmentPresenter

public interface DateTimeFindingView
{

    public abstract void animateDateTimeHeaderVisible(boolean flag);

    public abstract RapiSearchResultFragmentPresenter getPresenter();

    public abstract void setDateTimeHeaderString(String s);

    public abstract void setDateTimeHeaderVisible(boolean flag);

    public abstract void setHeaderToggleVisible(boolean flag);

    public abstract void setToggleHeader(boolean flag);

    public abstract void setToggleTitle(String s);
}
