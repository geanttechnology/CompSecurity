// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.net.UrlLogger;

// Referenced classes of package com.amazon.mShop.details:
//            AmazonAppStoreProxy, AmazonMp3Proxy, AmazonKindleProxy, FriendAppProxy

public class FriendAppAction
    implements android.view.View.OnClickListener
{

    private final Context context;
    private final ProductController product;
    private final FriendAppProxy proxy;

    public FriendAppAction(Context context1, ProductController productcontroller)
    {
        context = context1;
        product = productcontroller;
        proxy = FriendAppProxy.Factory.getProxy(productcontroller);
    }

    public static void logRefMarker(FriendAppProxy friendappproxy)
    {
        if (friendappproxy instanceof AmazonAppStoreProxy)
        {
            RefMarkerObserver.logRefMarker("dp_appstr");
        } else
        {
            if (friendappproxy instanceof AmazonMp3Proxy)
            {
                RefMarkerObserver.logRefMarker("dp_mp3");
                return;
            }
            if (friendappproxy instanceof AmazonKindleProxy)
            {
                RefMarkerObserver.logRefMarker("dp_kindle");
                return;
            }
        }
    }

    public static void startProxyActivity(Context context1, FriendAppProxy friendappproxy, Intent intent)
    {
        friendappproxy = friendappproxy.getRefTagForFriendApp(context1);
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        context1.startActivity(intent);
        UrlLogger.logRefTag((new StringBuilder()).append("fa_").append(friendappproxy).toString());
        return;
        context1;
        Log.d("Amazon.FriendAppAction", (new StringBuilder()).append("Activity is unknown for intent ").append(intent.toString()).toString());
        return;
    }

    public void onClick(View view)
    {
        view = proxy.getIntentForFriendApp(context, product);
        startProxyActivity(context, proxy, view);
        logRefMarker(proxy);
    }
}
