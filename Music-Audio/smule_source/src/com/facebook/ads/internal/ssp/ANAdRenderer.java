// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.ssp;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.view.c;
import org.json.JSONObject;

public class ANAdRenderer
{

    public ANAdRenderer()
    {
    }

    public static View renderAd(Context context, JSONObject jsonobject, int i, int j, int k, Listener listener)
    {
        try
        {
            context = new c(context, l.a(jsonobject), k, listener);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            listener.onAdError(context);
            return null;
        }
        return context;
    }

    private class Listener
    {

        public abstract void onAdClick();

        public abstract void onAdClose();

        public abstract void onAdError(Throwable throwable);

        public abstract void onAdImpression();
    }

}
