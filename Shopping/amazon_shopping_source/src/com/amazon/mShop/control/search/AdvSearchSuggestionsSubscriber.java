// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.mShop.control.GenericSubscriber;
import java.util.List;

public interface AdvSearchSuggestionsSubscriber
    extends GenericSubscriber
{

    public abstract void onSearchSuggestionsReceived(List list);
}
