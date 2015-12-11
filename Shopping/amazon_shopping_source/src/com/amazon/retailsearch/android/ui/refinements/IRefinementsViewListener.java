// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.searchapp.retailsearch.model.Refinements;

public interface IRefinementsViewListener
{

    public abstract void onHide();

    public abstract void onRefinementClick(String s);

    public abstract void onUpdate(Refinements refinements);

    public abstract void onViewSizeChanged();
}
