// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.Channel;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper

public class WidgetOnGoodsSyncHelper extends WidgetsSyncHelper
{

    private static final String GOODS_MEGAMIND_SCENARIO_PREFIX = "android_goods_tab_";

    public WidgetOnGoodsSyncHelper(Context context)
    {
        super(context, "GOODS", Channel.GOODS.toString(), "android_goods_tab_");
    }
}
