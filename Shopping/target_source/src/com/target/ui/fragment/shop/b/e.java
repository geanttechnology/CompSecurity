// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.b;

import android.support.v4.app.Fragment;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.util.deep_link.PromotionParams;
import java.util.Random;

public interface e
{

    public static final Random ID_GENERATOR_FOR_CHANGING_FRAGMENTS = new Random();

    public abstract Fragment a(PromotionParams promotionparams, ShopOverrides shopoverrides);

    public abstract String a();

    public abstract long b();

}
