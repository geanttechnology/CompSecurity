// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.clickstream.page;

import com.amazon.avod.clickstream.PageInfo;
import com.amazon.avod.clickstream.PageInfoSource;

public interface ComponentPageInfoHolder
    extends PageInfoSource
{

    public abstract void resetToMainPage(String s);

    public abstract void transitionToPage(String s, PageInfo pageinfo);
}
