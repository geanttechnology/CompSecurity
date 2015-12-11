// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.models:
//            PurchasedState

public class BitshopPack
{

    private static final transient int COLOR_BG_DEFAULT = Color.parseColor("#1e2025");
    private static final transient int COLOR_FG_DEFAULT = -1;
    private static final String TAG = "BitshopPack";
    String application_pack_store_id;
    String bg_color;
    String fg_color;
    boolean free;
    String logo_background_url;
    String logo_url;
    String name;
    String price;
    String purchased;
    List templates;
    int universal_pack_id;

    public BitshopPack()
    {
    }

    private String modifyUrlStringForAndroid(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return s.replace(".png", ".android.png");
        }
    }

    public String getApplicationPackStoreId()
    {
        return application_pack_store_id;
    }

    public int getBgColor()
    {
        int i = Color.parseColor(bg_color);
        return i;
        Object obj;
        obj;
_L2:
        return COLOR_BG_DEFAULT;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int getFgColor()
    {
        int i = Color.parseColor(fg_color);
        return i;
        Object obj;
        obj;
_L2:
        return -1;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getHeaderBackgroundUrl()
    {
        return modifyUrlStringForAndroid(logo_background_url);
    }

    public String getHeaderLogoUrl()
    {
        return modifyUrlStringForAndroid(logo_url);
    }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }

    public List getTemplates()
    {
        return templates;
    }

    public int getUniversalPackId()
    {
        return universal_pack_id;
    }

    public boolean isFree()
    {
        return free;
    }

    public boolean isPurchased()
    {
        return purchased.equals(PurchasedState.PURCHASED.toString());
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPurchased()
    {
        purchased = PurchasedState.PURCHASED.toString();
    }

    public void setUnpurchased()
    {
        purchased = PurchasedState.UNPURCHASED.toString();
    }

    public String toString()
    {
        return name;
    }

}
