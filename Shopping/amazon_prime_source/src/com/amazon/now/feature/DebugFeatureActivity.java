// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.feature;

import android.os.Bundle;
import android.widget.ListView;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.feature:
//            FeatureAdapter

public class DebugFeatureActivity extends AmazonActivity
{

    public DebugFeatureActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!AppUtils.isAppDebuggable(this))
        {
            finish();
        }
        bundle = new ListView(this);
        bundle.setOverScrollMode(2);
        bundle.setAdapter(new FeatureAdapter(this));
        setRootView(bundle, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
    }
}
