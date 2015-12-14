// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.socialin.android.activity.BaseActivity;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.socialin.android.photo.deeplinking:
//            UrlDeepLinkingActivity

public class ShopDeepLinkingActivity extends BaseActivity
{

    private String a;
    private String b;
    private String c;

    public ShopDeepLinkingActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getData();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = bundle.toString();
        bundle = new LinkedHashMap();
        obj = UrlDeepLinkingActivity.b(((String) (obj)));
        bundle = ((Bundle) (obj));
_L3:
        UnsupportedEncodingException unsupportedencodingexception;
        boolean flag;
        if (bundle.containsKey("id"))
        {
            a = (String)bundle.get("id");
        } else
        if (bundle.containsKey("name"))
        {
            a = (String)bundle.get("name");
        } else
        if (bundle.containsKey("type"))
        {
            b = (String)bundle.get("type");
        } else
        if (bundle.containsKey("category"))
        {
            c = (String)bundle.get("category");
        }
        bundle = new Intent();
        if (a != null)
        {
            bundle.setClassName(getApplicationContext(), "com.picsart.shop.ShopItemActivity");
            bundle.putExtra("selectedShopItemId", a);
            flag = true;
        } else
        if (b != null)
        {
            bundle.setClassName(getApplicationContext(), "com.picsart.shop.ShopActivity");
            if (b.toLowerCase().equals("all"))
            {
                bundle.putExtra("type", 2);
            } else
            if (b.toLowerCase().equals("paid"))
            {
                bundle.putExtra("type", 0);
            } else
            if (b.toLowerCase().equals("free"))
            {
                bundle.putExtra("type", 1);
            }
            flag = true;
        } else
        if (c != null)
        {
            bundle.setClassName(getApplicationContext(), "com.picsart.shop.ShopItemsListActivity");
            bundle.putExtra("selectedTag", c);
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            startActivity(bundle);
        }
        finish();
_L2:
        return;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L3
    }
}
