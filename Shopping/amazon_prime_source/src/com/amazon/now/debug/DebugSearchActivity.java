// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.os.Bundle;
import android.widget.ScrollView;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.retailsearch.android.api.debug.SearchDebugView;

public class DebugSearchActivity extends AmazonActivity
{

    public DebugSearchActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new ScrollView(this);
        bundle.addView(new SearchDebugView(this, new com.amazon.retailsearch.android.api.debug.SearchDebugView.DebugCallback() {

            final DebugSearchActivity this$0;

            public void envSelected()
            {
                finish();
            }

            
            {
                this$0 = DebugSearchActivity.this;
                super();
            }
        }));
        setRootView(bundle, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
    }
}
