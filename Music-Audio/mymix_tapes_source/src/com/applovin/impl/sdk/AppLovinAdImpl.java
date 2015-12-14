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
//            ay, d

public class AppLovinAdImpl
    implements ay, AppLovinAd
{

    private final AppLovinAdSize a;
    private final AppLovinAdType b;
    private final long c;
    private final String d;
    private final AdTarget e;
    private final String f;
    private final String g;
    private final float h;
    private final float i;
    private final int j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final v o;

    private AppLovinAdImpl(String s, AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, String s1, AdTarget adtarget, v v1, float f1, 
            float f2, int i1, long l1, String s2, String s3, String s4, 
            String s5, String s6)
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
            d = s1;
            c = l1;
            g = s;
            e = adtarget;
            h = f1;
            j = i1;
            f = s2;
            o = v1;
            i = f2;
            k = s3;
            l = s4;
            m = s5;
            n = s6;
            return;
        }
    }

    AppLovinAdImpl(String s, AppLovinAdSize applovinadsize, AppLovinAdType applovinadtype, String s1, AdTarget adtarget, v v1, float f1, 
            float f2, int i1, long l1, String s2, String s3, String s4, 
            String s5, String s6, d d1)
    {
        this(s, applovinadsize, applovinadtype, s1, adtarget, v1, f1, f2, i1, l1, s2, s3, s4, s5, s6);
    }

    public boolean equals(Object obj)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag3;
        if (obj == null) goto _L4; else goto _L3
_L3:
        flag = flag3;
        if (getClass() != obj.getClass()) goto _L4; else goto _L5
_L5:
        obj = (AppLovinAdImpl)obj;
        flag = flag3;
        if (c != ((AppLovinAdImpl) (obj)).c) goto _L4; else goto _L6
_L6:
        flag = flag3;
        if (Float.compare(((AppLovinAdImpl) (obj)).h, h) != 0) goto _L4; else goto _L7
_L7:
        flag = flag3;
        if (Float.compare(((AppLovinAdImpl) (obj)).i, i) != 0) goto _L4; else goto _L8
_L8:
        flag = flag3;
        if (j != ((AppLovinAdImpl) (obj)).j) goto _L4; else goto _L9
_L9:
        if (a == null) goto _L11; else goto _L10
_L10:
        flag = flag3;
        if (!a.equals(((AppLovinAdImpl) (obj)).a)) goto _L4; else goto _L12
_L12:
        if (b == null) goto _L14; else goto _L13
_L13:
        flag = flag3;
        if (!b.equals(((AppLovinAdImpl) (obj)).b)) goto _L4; else goto _L15
_L15:
        if (d == null) goto _L17; else goto _L16
_L16:
        flag = flag3;
        if (!d.equals(((AppLovinAdImpl) (obj)).d)) goto _L4; else goto _L18
_L18:
        flag = flag3;
        if (e != ((AppLovinAdImpl) (obj)).e) goto _L4; else goto _L19
_L19:
        if (f == null) goto _L21; else goto _L20
_L20:
        flag = flag3;
        if (!f.equals(((AppLovinAdImpl) (obj)).f)) goto _L4; else goto _L22
_L22:
        if (g == null) goto _L24; else goto _L23
_L23:
        flag = flag3;
        if (!g.equals(((AppLovinAdImpl) (obj)).g)) goto _L4; else goto _L25
_L25:
        if (k == null) goto _L27; else goto _L26
_L26:
        flag = flag3;
        if (!k.equals(((AppLovinAdImpl) (obj)).k)) goto _L4; else goto _L28
_L28:
        if (l == null) goto _L30; else goto _L29
_L29:
        flag = flag3;
        if (!l.equals(((AppLovinAdImpl) (obj)).l)) goto _L4; else goto _L31
_L31:
        if (m == null) goto _L33; else goto _L32
_L32:
        flag = flag3;
        if (!m.equals(((AppLovinAdImpl) (obj)).m)) goto _L4; else goto _L34
_L34:
        if (n == null)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        flag = flag3;
        if (!n.equals(((AppLovinAdImpl) (obj)).n)) goto _L4; else goto _L35
_L35:
        boolean flag1;
        if (o == ((AppLovinAdImpl) (obj)).o)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
_L11:
        if (((AppLovinAdImpl) (obj)).a != null)
        {
            return false;
        }
          goto _L12
_L14:
        if (((AppLovinAdImpl) (obj)).b != null)
        {
            return false;
        }
          goto _L15
_L17:
        if (((AppLovinAdImpl) (obj)).d != null)
        {
            return false;
        }
          goto _L18
_L21:
        if (((AppLovinAdImpl) (obj)).f != null)
        {
            return false;
        }
          goto _L22
_L24:
        if (((AppLovinAdImpl) (obj)).g != null)
        {
            return false;
        }
          goto _L25
_L27:
        if (((AppLovinAdImpl) (obj)).k != null)
        {
            return false;
        }
          goto _L28
_L30:
        if (((AppLovinAdImpl) (obj)).l != null)
        {
            return false;
        }
          goto _L31
_L33:
        if (((AppLovinAdImpl) (obj)).m != null)
        {
            return false;
        }
          goto _L34
        if (((AppLovinAdImpl) (obj)).n != null)
        {
            return false;
        }
          goto _L35
    }

    public long getAdIdNumber()
    {
        return c;
    }

    public String getClCode()
    {
        return f;
    }

    public v getCloseStyle()
    {
        return o;
    }

    public String getCompletionUrl()
    {
        return k;
    }

    public int getCountdownLength()
    {
        return j;
    }

    public String getHtmlSource()
    {
        return g;
    }

    public String getMuteImageFilename()
    {
        return m;
    }

    public String getParametrizedCompletionUrl(int i1)
    {
        String s = getCompletionUrl();
        if (AppLovinSdkUtils.isValidString(s))
        {
            return Uri.parse(s.replace("{CLCODE}", getClCode())).buildUpon().appendQueryParameter("pv", Integer.toString(i1)).build().toString();
        } else
        {
            return "";
        }
    }

    public float getPoststitialCloseDelay()
    {
        return i;
    }

    public AppLovinAdSize getSize()
    {
        return a;
    }

    public String getSupplementalClickTrackingUrl()
    {
        String s = l;
        if (AppLovinSdkUtils.isValidString(s))
        {
            return s.replace("{CLCODE}", getClCode());
        } else
        {
            return "";
        }
    }

    public AdTarget getTarget()
    {
        return e;
    }

    public AppLovinAdType getType()
    {
        return b;
    }

    public String getUnmuteImageFilename()
    {
        return n;
    }

    public float getVideoCloseDelay()
    {
        return h;
    }

    public String getVideoFilename()
    {
        return d;
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
        int j4;
        int k4;
        if (a != null)
        {
            i1 = a.hashCode();
        } else
        {
            i1 = 0;
        }
        if (b != null)
        {
            j1 = b.hashCode();
        } else
        {
            j1 = 0;
        }
        j4 = (int)(c ^ c >>> 32);
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
        if (h != 0.0F)
        {
            k2 = Float.floatToIntBits(h);
        } else
        {
            k2 = 0;
        }
        if (i != 0.0F)
        {
            l2 = Float.floatToIntBits(i);
        } else
        {
            l2 = 0;
        }
        k4 = j;
        if (k != null)
        {
            i3 = k.hashCode();
        } else
        {
            i3 = 0;
        }
        if (l != null)
        {
            j3 = l.hashCode();
        } else
        {
            j3 = 0;
        }
        if (m != null)
        {
            k3 = m.hashCode();
        } else
        {
            k3 = 0;
        }
        if (n != null)
        {
            l3 = n.hashCode();
        } else
        {
            l3 = 0;
        }
        if (o != null)
        {
            i4 = o.hashCode();
        }
        return (l3 + (k3 + (j3 + (i3 + ((l2 + (k2 + (j2 + (i2 + (l1 + (k1 + ((j1 + i1 * 31) * 31 + j4) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + k4) * 31) * 31) * 31) * 31) * 31 + i4;
    }

    public boolean isVideoAd()
    {
        return AppLovinSdkUtils.isValidString(d);
    }

    public String toString()
    {
        return (new StringBuilder()).append("AppLovinAdImpl{size=").append(a).append(", type=").append(b).append(", adIdNumber=").append(c).append(", videoFilename='").append(d).append('\'').append(", target=").append(e).append(", clCode='").append(f).append('\'').append(", htmlSource='").append(g).append('\'').append(", videoCloseDelay=").append(h).append(", poststitialCloseDelay=").append(i).append(", countdownLength=").append(j).append(", completionUrl='").append(k).append('\'').append(", supplementalClickTrackingUrl='").append(l).append('\'').append(", muteImageFilename='").append(m).append('\'').append(", unmuteImageFilename='").append(n).append('\'').append(", closeStyle=").append(o).append('}').toString();
    }

    private class AdTarget extends Enum
    {

        public static final AdTarget ACTIVITY_LANDSCAPE;
        public static final AdTarget ACTIVITY_PORTRAIT;
        public static final AdTarget DEFAULT;
        private static final AdTarget a[];

        public static AdTarget valueOf(String s)
        {
            return (AdTarget)Enum.valueOf(com/applovin/impl/sdk/AppLovinAdImpl$AdTarget, s);
        }

        public static AdTarget[] values()
        {
            return (AdTarget[])a.clone();
        }

        static 
        {
            DEFAULT = new AdTarget("DEFAULT", 0);
            ACTIVITY_PORTRAIT = new AdTarget("ACTIVITY_PORTRAIT", 1);
            ACTIVITY_LANDSCAPE = new AdTarget("ACTIVITY_LANDSCAPE", 2);
            a = (new AdTarget[] {
                DEFAULT, ACTIVITY_PORTRAIT, ACTIVITY_LANDSCAPE
            });
        }

        private AdTarget(String s, int i1)
        {
            super(s, i1);
        }
    }

}
