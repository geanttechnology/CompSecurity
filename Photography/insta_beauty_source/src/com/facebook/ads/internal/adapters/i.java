// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.h;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            InterstitialAdapter, k, InterstitialAdapterListener, c

public class i extends InterstitialAdapter
{

    private final String a = UUID.randomUUID().toString();
    private Context b;
    private c c;
    private InterstitialAdapterListener d;
    private boolean e;
    private k f;
    private a g;
    private WebView h;

    public i()
    {
        e = false;
    }

    private int a()
    {
        int j = ((WindowManager)b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (g == a.b)
        {
            switch (j)
            {
            default:
                return 0;

            case 2: // '\002'
            case 3: // '\003'
                return 8;
            }
        }
        switch (j)
        {
        default:
            return 1;

        case 2: // '\002'
            return 9;
        }
    }

    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialadapterlistener, Map map)
    {
        b = context;
        d = interstitialadapterlistener;
        f = k.a((JSONObject)map.get("data"));
        if (com.facebook.ads.internal.util.f.a(context, f))
        {
            interstitialadapterlistener.onInterstitialError(this, AdError.NO_FILL);
        } else
        {
            c = new c(context, a, this, d);
            c.a();
            context = f.h();
            if (context.containsKey("orientation"))
            {
                g = a.a(Integer.parseInt((String)context.get("orientation")));
            }
            e = true;
            if (d != null)
            {
                d.onInterstitialAdLoaded(this);
                return;
            }
        }
    }

    public void onDestroy()
    {
        if (c != null)
        {
            c.b();
        }
        if (h != null)
        {
            com.facebook.ads.internal.util.h.a(h);
            h.destroy();
            h = null;
        }
    }

    public boolean show()
    {
        if (!e)
        {
            if (d != null)
            {
                d.onInterstitialError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        } else
        {
            Intent intent = new Intent(b, com/facebook/ads/InterstitialAdActivity);
            f.a(intent);
            intent.putExtra("predefinedOrientationKey", a());
            intent.putExtra("adInterstitialUniqueId", a);
            intent.putExtra("viewType", com.facebook.ads.InterstitialAdActivity.Type.DISPLAY);
            intent.addFlags(0x10000000);
            b.startActivity(intent);
            return true;
        }
    }

    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a a(int j)
        {
            if (j == 2)
            {
                return b;
            } else
            {
                return a;
            }
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/facebook/ads/internal/adapters/i$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("VERTICAL", 0);
            b = new a("HORIZONTAL", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }

}
