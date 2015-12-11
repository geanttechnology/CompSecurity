// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.model;

import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.QuartzBacklink;

public class MixedCorrectionsModel
{

    private DidYouMean didYouMean;
    private QuartzBacklink quartzBacklink;

    public MixedCorrectionsModel()
    {
    }

    public DidYouMean getDidYouMean()
    {
        return didYouMean;
    }

    public QuartzBacklink getQuartzBacklink()
    {
        return quartzBacklink;
    }

    public boolean isEmpty()
    {
        return didYouMean == null && (quartzBacklink == null || Utils.isEmpty(quartzBacklink.getFormattedLabel()));
    }

    public void setDidYouMean(DidYouMean didyoumean)
    {
        didYouMean = didyoumean;
    }

    public void setQuartzBacklink(QuartzBacklink quartzbacklink)
    {
        quartzBacklink = quartzbacklink;
    }
}
