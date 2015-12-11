// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import com.amazon.mShop.control.item.ClickStreamTag;

// Referenced classes of package com.amazon.mShop.wearable:
//            ResultListener, SearchResultListener

public interface WearableService
{

    public abstract void addProductToWishList(String s, ResultListener resultlistener);

    public abstract void addTextToWishlist(String s, ResultListener resultlistener);

    public abstract void addTimer(String s, String s1, double d);

    public abstract void emitClickStream(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, int i);

    public abstract void incrementMetricCounter(String s, String s1, int i);

    public abstract void logRefMarker(String s);

    public abstract void openLocaleSettings(ResultListener resultlistener);

    public abstract void openLoginUi(ResultListener resultlistener);

    public abstract void openMShopHome(String s);

    public abstract void openOneClickSettings(ResultListener resultlistener);

    public abstract void openProductPage(String s, String s1, String s2, ClickStreamTag clickstreamtag, ResultListener resultlistener);

    public abstract void openTextSearchResults(String s, ResultListener resultlistener);

    public abstract void purchaseProduct(String s, String s1, ClickStreamTag clickstreamtag, ResultListener resultlistener);

    public abstract void searchByText(String s, SearchResultListener searchresultlistener);
}
