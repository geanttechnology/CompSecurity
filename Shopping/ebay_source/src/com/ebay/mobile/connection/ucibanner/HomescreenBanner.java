// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.ucibanner;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;

public interface HomescreenBanner
{

    public abstract SpannableString getText(Resources resources);

    public abstract void onBannerClick(Activity activity);

    public abstract void onBannerDismiss(Activity activity);

    public abstract boolean shouldShowBanner();
}
