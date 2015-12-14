// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;

// Referenced classes of package com.applovin.impl.sdk:
//            ay, x, c, AppLovinSdkImpl, 
//            bm, az

public class NativeAdImpl
    implements ay, x
{

    public static final String QUERY_PARAM_IS_FIRST_PLAY = "fp";
    public static final String QUERY_PARAM_VIDEO_PERCENT_VIEWED = "pv";
    public static final AppLovinAdSize SIZE_NATIVE;
    public static final c SPEC_NATIVE;
    public static final AppLovinAdType TYPE_NATIVE;
    private final AppLovinSdkImpl a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private float l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private long s;

    private NativeAdImpl(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, float f1, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, long l1, AppLovinSdkImpl applovinsdkimpl)
    {
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = s7;
        j = s8;
        k = s9;
        l = f1;
        m = s10;
        n = s11;
        o = s12;
        p = s13;
        q = s14;
        r = s15;
        i = s16;
        s = l1;
        a = applovinsdkimpl;
    }

    NativeAdImpl(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, float f1, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16, long l1, AppLovinSdkImpl applovinsdkimpl, az az)
    {
        this(s1, s2, s3, s4, s5, s6, s7, s8, s9, f1, s10, s11, s12, s13, s14, s15, s16, l1, applovinsdkimpl);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (NativeAdImpl)obj;
            if (h == null ? ((NativeAdImpl) (obj)).h != null : !h.equals(((NativeAdImpl) (obj)).h))
            {
                return false;
            }
            if (r == null ? ((NativeAdImpl) (obj)).r != null : !r.equals(((NativeAdImpl) (obj)).r))
            {
                return false;
            }
            if (o == null ? ((NativeAdImpl) (obj)).o != null : !o.equals(((NativeAdImpl) (obj)).o))
            {
                return false;
            }
            if (i == null ? ((NativeAdImpl) (obj)).i != null : !i.equals(((NativeAdImpl) (obj)).i))
            {
                return false;
            }
            if (g == null ? ((NativeAdImpl) (obj)).g != null : !g.equals(((NativeAdImpl) (obj)).g))
            {
                return false;
            }
            if (n == null ? ((NativeAdImpl) (obj)).n != null : !n.equals(((NativeAdImpl) (obj)).n))
            {
                return false;
            }
            if (b == null ? ((NativeAdImpl) (obj)).b != null : !b.equals(((NativeAdImpl) (obj)).b))
            {
                return false;
            }
            if (c == null ? ((NativeAdImpl) (obj)).c != null : !c.equals(((NativeAdImpl) (obj)).c))
            {
                return false;
            }
            if (d == null ? ((NativeAdImpl) (obj)).d != null : !d.equals(((NativeAdImpl) (obj)).d))
            {
                return false;
            }
            if (e == null ? ((NativeAdImpl) (obj)).e != null : !e.equals(((NativeAdImpl) (obj)).e))
            {
                return false;
            }
            if (f == null ? ((NativeAdImpl) (obj)).f != null : !f.equals(((NativeAdImpl) (obj)).f))
            {
                return false;
            }
            if (q == null ? ((NativeAdImpl) (obj)).q != null : !q.equals(((NativeAdImpl) (obj)).q))
            {
                return false;
            }
            if (p == null ? ((NativeAdImpl) (obj)).p != null : !p.equals(((NativeAdImpl) (obj)).p))
            {
                return false;
            }
        }
        return true;
    }

    public long getAdId()
    {
        return s;
    }

    public String getCaptionText()
    {
        return h;
    }

    public String getClCode()
    {
        return r;
    }

    public String getClickUrl()
    {
        return o;
    }

    public String getCtaText()
    {
        return i;
    }

    public String getDescriptionText()
    {
        return g;
    }

    public String getIconUrl()
    {
        return j;
    }

    public String getImageUrl()
    {
        return k;
    }

    public String getImpressionTrackingUrl()
    {
        return n;
    }

    public String getSourceIconUrl()
    {
        return b;
    }

    public String getSourceImageUrl()
    {
        return c;
    }

    public String getSourceStarRatingImageUrl()
    {
        return d;
    }

    public String getSourceVideoUrl()
    {
        return e;
    }

    public float getStarRating()
    {
        return l;
    }

    public String getTitle()
    {
        return f;
    }

    public String getVideoEndTrackingUrl(int i1, boolean flag)
    {
        if (q == null)
        {
            return Uri.EMPTY.toString();
        }
        if (i1 < 0 || i1 > 100)
        {
            Log.e("AppLovinNativeAd", "Invalid percent viewed supplied.", new IllegalArgumentException("Percent viewed must be an integer between 0 and 100."));
        }
        return Uri.parse(q).buildUpon().appendQueryParameter("pv", Integer.toString(i1)).appendQueryParameter("fp", Boolean.toString(flag)).build().toString();
    }

    public String getVideoStartTrackingUrl()
    {
        return p;
    }

    public String getVideoUrl()
    {
        return m;
    }

    public int hashCode()
    {
        int i4 = 0;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        if (b != null)
        {
            i1 = b.hashCode();
        } else
        {
            i1 = 0;
        }
        if (c != null)
        {
            j1 = c.hashCode();
        } else
        {
            j1 = 0;
        }
        if (d != null)
        {
            k1 = d.hashCode();
        } else
        {
            k1 = 0;
        }
        if (e != null)
        {
            l1 = e.hashCode();
        } else
        {
            l1 = 0;
        }
        if (f != null)
        {
            i2 = f.hashCode();
        } else
        {
            i2 = 0;
        }
        if (g != null)
        {
            j2 = g.hashCode();
        } else
        {
            j2 = 0;
        }
        if (h != null)
        {
            k2 = h.hashCode();
        } else
        {
            k2 = 0;
        }
        if (i != null)
        {
            l2 = i.hashCode();
        } else
        {
            l2 = 0;
        }
        if (n != null)
        {
            i3 = n.hashCode();
        } else
        {
            i3 = 0;
        }
        if (o != null)
        {
            j3 = o.hashCode();
        } else
        {
            j3 = 0;
        }
        if (p != null)
        {
            k3 = p.hashCode();
        } else
        {
            k3 = 0;
        }
        if (q != null)
        {
            l3 = q.hashCode();
        } else
        {
            l3 = 0;
        }
        if (r != null)
        {
            i4 = r.hashCode();
        }
        return (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + i1 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i4;
    }

    public boolean isImagePrecached()
    {
        boolean flag;
        boolean flag1;
        if (j != null && !j.equals(b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k != null && !k.equals(c))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag1;
    }

    public boolean isVideoPrecached()
    {
        return m != null && !m.equals(e);
    }

    public void launchClickTarget(Context context)
    {
        a.getPersistentPostbackManager().a(o, null);
        AppLovinSdkUtils.openUrl(context, o, a);
    }

    public void setIconUrl(String s1)
    {
        j = s1;
    }

    public void setImageUrl(String s1)
    {
        k = s1;
    }

    public void setStarRating(float f1)
    {
        l = f1;
    }

    public void setVideoUrl(String s1)
    {
        m = s1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("WidgetSlot{clCode='").append(r).append('\'').append(", sourceIconUrl='").append(b).append('\'').append(", sourceImageUrl='").append(c).append('\'').append(", sourceStarRatingImageUrl='").append(d).append('\'').append(", sourceVideoUrl='").append(e).append('\'').append(", title='").append(f).append('\'').append(", descriptionText='").append(g).append('\'').append(", captionText='").append(h).append('\'').append(", ctaText='").append(i).append('\'').append(", iconUrl='").append(j).append('\'').append(", imageUrl='").append(k).append('\'').append(", starRating='").append(l).append('\'').append(", videoUrl='").append(m).append('\'').append(", impressionTrackingUrl='").append(n).append('\'').append(", clickUrl='").append(o).append('\'').append(", videoStartTrackingUrl='").append(p).append('\'').append(", videoEndTrackingUrl='").append(q).append('\'').append('}').toString();
    }

    static 
    {
        SIZE_NATIVE = new AppLovinAdSize("NATIVE");
        TYPE_NATIVE = new AppLovinAdType("NATIVE");
        SPEC_NATIVE = new c(SIZE_NATIVE, TYPE_NATIVE);
    }
}
