// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.location.Store;
import com.amazon.now.location.StorefrontWebActivity;

// Referenced classes of package com.amazon.now.nav:
//            NavListAdapter

class val.store
    implements android.view.ner
{

    final NavListAdapter this$0;
    final Store val$store;

    public void onClick(View view)
    {
        view = new Intent(getContext(), com/amazon/now/location/StorefrontWebActivity);
        view.putExtra("intentUrlKey", val$store.getStoreUrl());
        view.putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.eLayout.NORMAL, val$store.getStoreColor(), true));
        NavListAdapter.access$000(NavListAdapter.this).startActivity(view);
        ((AmazonActivity)getContext()).closeLeftNav();
    }

    out()
    {
        this$0 = final_navlistadapter;
        val$store = Store.this;
        super();
    }
}
