// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.Context;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            DebugPopup

private static class  extends 
{

    boolean CheckPreferenceEquality(Context context, String s)
    {
        return FeatureManager.isFeatureEnabled(Features.valueOf(s)) == ((Boolean)value).booleanValue();
    }

    void saveValue(Context context, String s)
    {
        FeatureManager.setFeatureEnabled(context, Features.valueOf(s), ((Boolean)value).booleanValue());
    }

    public (Boolean boolean1)
    {
        super(boolean1);
    }
}
