// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.facebook.ads.NativeAd;

public class eg extends jc
{

    public NativeAd a;

    public eg()
    {
        a = null;
    }

    public String a()
    {
        if (a != null && a.isAdLoaded())
        {
            return a.getAdTitle();
        } else
        {
            return null;
        }
    }

    public void a(View view)
    {
        if (a != null && a.isAdLoaded())
        {
            a.registerViewForInteraction(view);
        }
    }

    public String b()
    {
        if (a != null && a.isAdLoaded())
        {
            return a.getAdIcon().getUrl();
        } else
        {
            return null;
        }
    }

    public void b(View view)
    {
    }

    public void c()
    {
        if (a != null)
        {
            a.unregisterView();
        }
    }
}
