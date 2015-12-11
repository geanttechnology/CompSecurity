// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import com.amazon.mShop.wearable.model.WearableSearchResult;

// Referenced classes of package com.amazon.mShop.wearable:
//            ResultListener

public interface SearchResultListener
    extends ResultListener
{

    public abstract void onFoundProduct(WearableSearchResult wearablesearchresult);
}
