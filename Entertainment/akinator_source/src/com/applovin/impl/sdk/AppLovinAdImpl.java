// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.impl.adview.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

// Referenced classes of package com.applovin.impl.sdk:
//            ax, e

public class AppLovinAdImpl
    implements ax, AppLovinAd
{

    private final AppLovinAdSize a;
    private final AppLovinAdType b;
    private final long c;
    private final AdTarget d;
    private final String e;
    private final String f;
    private final float g;
    private final float h;
    private final int i;
    private final String j;
    private final v k;
    protected final String videoFilename;

    private AppLovinAdImpl(String s, AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, String s1, AdTarget adtarget, v v, float f1, 
            float f2, int l, long l1, String s2, String s3)
    {
        if (applovinadsize == null)
        {
            throw new IllegalArgumentException("No size specified");
        }
        if (applovinadtype == null)
        {
            throw new IllegalArgumentException("No type specified");
        } else
        {
            a = applovinadsize;
            b = applovinadtype;
            videoFilename = s1;
            c = l1;
            f = s;
            d = adtarget;
            g = f1;
            i = l;
            e = s2;
            k = v;
            h = f2;
            j = s3;
            return;
        }
    }

    AppLovinAdImpl(String s, AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, String s1, AdTarget adtarget, v v, float f1, 
            float f2, int l, long l1, String s2, String s3, e e1)
    {
        this(s, applovinadsize, applovinadtype, s1, adtarget, v, f1, f2, l, l1, s2, s3);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (AppLovinAdImpl)obj;
            if (getAdIdNumber() != ((AppLovinAdImpl) (obj)).getAdIdNumber() || !getType().equals(((AppLovinAdImpl) (obj)).getType()) || !getSize().equals(((AppLovinAdImpl) (obj)).getSize()) || !f.equals(((AppLovinAdImpl) (obj)).getHtmlSource()))
            {
                return false;
            }
        }
        return true;
    }

    public long getAdIdNumber()
    {
        return c;
    }

    public String getClCode()
    {
        return e;
    }

    public v getCloseStyle()
    {
        return k;
    }

    public String getCompletionUrl()
    {
        return j;
    }

    public int getCountdownLength()
    {
        return i;
    }

    public String getHtmlSource()
    {
        return f;
    }

    public String getParametrizedCompletionUrl(int l)
    {
        String s = getCompletionUrl();
        if (AppLovinSdkUtils.isValidString(s))
        {
            return Uri.parse(s.replace("{CLCODE}", getClCode())).buildUpon().appendQueryParameter("pv", Integer.toString(l)).build().toString();
        } else
        {
            return "";
        }
    }

    public float getPoststitialCloseDelay()
    {
        return h;
    }

    public AppLovinAdSize getSize()
    {
        return a;
    }

    public AdTarget getTarget()
    {
        return d;
    }

    public AppLovinAdType getType()
    {
        return b;
    }

    public float getVideoCloseDelay()
    {
        return g;
    }

    public String getVideoFilename()
    {
        return videoFilename;
    }

    public int hashCode()
    {
        return (int)getAdIdNumber();
    }

    public boolean isVideoAd()
    {
        return AppLovinSdkUtils.isValidString(videoFilename);
    }
}
