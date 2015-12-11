// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;

import android.widget.CompoundButton;

// Referenced classes of package com.amazon.now.feature:
//            FeatureAdapter, FeatureController

class .Feature
    implements android.widget.CheckedChangeListener
{

    final FeatureAdapter this$0;
    final .Feature val$feature;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        FeatureController.getInstance().setFeatureOverride(val$feature, flag);
    }

    .Feature()
    {
        this$0 = final_featureadapter;
        val$feature = .Feature.this;
        super();
    }
}
