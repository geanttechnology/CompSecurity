// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;

import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

// Referenced classes of package com.amazon.now.feature:
//            FeatureAdapter, FeatureController

class val.featureSwitch
    implements android.view.ner
{

    final FeatureAdapter this$0;
    final .Feature val$feature;
    final Switch val$featureSwitch;

    public void onClick(View view)
    {
        FeatureController.getInstance().clearFeatureOverride(val$feature);
        val$featureSwitch.setChecked(FeatureController.getInstance().isFeatureEnabled(val$feature));
        FeatureController.getInstance().clearFeatureOverride(val$feature);
        Toast.makeText(FeatureAdapter.access$000(FeatureAdapter.this), 0x7f0700b5, 0).show();
    }

    .Feature()
    {
        this$0 = final_featureadapter;
        val$feature = feature1;
        val$featureSwitch = Switch.this;
        super();
    }
}
