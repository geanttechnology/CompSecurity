// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Loader;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.loader.GroceryLoaderCallbacks;

// Referenced classes of package com.groupon.activity:
//            SnapGroceryDetails

class <init> extends GroceryLoaderCallbacks
{

    final SnapGroceryDetails this$0;

    public void onLoadFinished(Loader loader, SnapGroceryDetail snapgrocerydetail)
    {
        if (snapgrocerydetail != null)
        {
            SnapGroceryDetails.access$000(SnapGroceryDetails.this, snapgrocerydetail);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (SnapGroceryDetail)obj);
    }

    (Context context, String s, String s1)
    {
        this$0 = SnapGroceryDetails.this;
        super(context, s, s1);
    }
}
