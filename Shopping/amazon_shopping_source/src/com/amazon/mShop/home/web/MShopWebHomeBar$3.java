// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home.web;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.contentprovider.WidgetDatabaseHelper;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.DBException;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;

// Referenced classes of package com.amazon.mShop.home.web:
//            MShopWebHomeBar

class meShoveler
    implements Runnable
{

    final MShopWebHomeBar this$0;
    final HomeShoveler val$shoveler;

    public void run()
    {
        try
        {
            WidgetDatabaseHelper.getInstance(MShopWebHomeBar.access$200(MShopWebHomeBar.this)).cleanOldHomeShovelerContent();
            if (SSOUtil.isSSOSupported(getContext().getApplicationContext()))
            {
                WidgetDatabaseHelper.getInstance(MShopWebHomeBar.access$200(MShopWebHomeBar.this)).updateHomeShovelerItems(val$shoveler);
            }
            return;
        }
        catch (DBException dbexception)
        {
            Log.i("WebHomeBar", dbexception.getMessage());
        }
    }

    meShoveler()
    {
        this$0 = final_mshopwebhomebar;
        val$shoveler = HomeShoveler.this;
        super();
    }
}
