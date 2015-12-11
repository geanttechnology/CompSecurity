// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.crittercism.app.Crittercism;
import com.groupon.db.models.Finder;
import com.groupon.deeplink.DeepLinkValidator;
import com.groupon.deeplink.GenericDeepLinkValidator;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            FinderCardMapping

public class GtgPromoteCardWithDefaultsMapping extends FinderCardMapping
{

    public static final String GTG_JUMPOFF_CARD_WITH_DEFAULTS = "gtg_jumpoff_card_with_defaults";
    public static final String GTG_PROMO_CARD_WITH_DEFAULTS = "gtg_promo_card_with_defaults";
    private final DeepLinkValidator deepLinkValidator;
    private final String finderCardType;
    private final int layoutResId;
    private boolean spanAllColumns;

    public GtgPromoteCardWithDefaultsMapping(String s, int i)
    {
        deepLinkValidator = new GenericDeepLinkValidator();
        layoutResId = i;
        finderCardType = s;
    }

    public GtgPromoteCardWithDefaultsMapping(String s, int i, boolean flag)
    {
        this(s, i);
        spanAllColumns = flag;
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(layoutResId, null);
    }

    public boolean getSpanAllColumns()
    {
        return spanAllColumns;
    }

    public boolean isSupported(Object obj)
    {
        boolean flag = false;
        if (!(obj instanceof Finder))
        {
            return false;
        }
        obj = (Finder)obj;
        if (!Strings.equals(((Finder) (obj)).type, finderCardType)) goto _L2; else goto _L1
_L1:
        if (Strings.isEmpty(((Finder) (obj)).deepLink)) goto _L4; else goto _L3
_L3:
        boolean flag1 = deepLinkValidator.validateDeepLink(((Finder) (obj)).deepLink);
        if (!flag1) goto _L5; else goto _L4
_L4:
        flag = true;
_L6:
        return flag;
_L5:
        flag = false;
        continue; /* Loop/switch isn't completed */
        obj;
        if (Ln.isDebugEnabled())
        {
            Ln.e(((Throwable) (obj)));
        } else
        {
            Crittercism.logHandledException(((Throwable) (obj)));
        }
        if (true) goto _L6; else goto _L2
_L2:
        return false;
    }
}
