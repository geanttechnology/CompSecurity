// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.impl.adview.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, dg, c, AppLovinSdkImpl, 
//            y, bw, w

class cv extends bv
    implements dg
{

    private final Collection a = d();
    private final JSONObject b;
    private final AppLovinAdLoadListener c;
    private final y d;
    private boolean i;
    private c j;

    cv(JSONObject jsonobject, AppLovinAdLoadListener applovinadloadlistener, AppLovinSdkImpl applovinsdkimpl)
    {
        super("RenderAd", applovinsdkimpl);
        j = new c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
        b = jsonobject;
        c = applovinadloadlistener;
        d = applovinsdkimpl.getFileManager();
    }

    private float a(String s, AppLovinAdType applovinadtype, int k)
    {
        while (applovinadtype.equals(AppLovinAdType.INCENTIVIZED) || applovinadtype.equals(AppLovinAdType.REGULAR) && s != null && k == -1) 
        {
            return 0.5F;
        }
        return 0.0F;
    }

    private v a(int k)
    {
        if (k == 1)
        {
            return v.b;
        } else
        {
            return v.a;
        }
    }

    private v a(String s)
    {
        if (s != null)
        {
            return v.b;
        } else
        {
            return v.a;
        }
    }

    private String a(String s, String s1)
    {
        Object obj = s1.replace("/", "_");
        obj = d.a(((String) (obj)), f.getApplicationContext(), true);
        if (obj != null)
        {
            if (((File) (obj)).exists())
            {
                g.d(e, (new StringBuilder()).append("Loaded ").append(s1).append(" from cache: file://").append(((File) (obj)).getAbsolutePath()).toString());
                return (new StringBuilder()).append("file://").append(((File) (obj)).getAbsolutePath()).toString();
            }
            s = (new StringBuilder()).append(s).append(s1).toString();
            if (d.a(((File) (obj)), s))
            {
                return (new StringBuilder()).append("file://").append(((File) (obj)).getAbsolutePath()).toString();
            }
        }
        return null;
    }

    private void a(JSONObject jsonobject)
    {
        Object obj;
        AppLovinAdSize applovinadsize;
        AppLovinAdImpl.AdTarget adtarget;
        AppLovinAdType applovinadtype;
        String s1;
        String s4;
        String s = jsonobject.getString("html");
        if (jsonobject.has("size"))
        {
            applovinadsize = AppLovinAdSize.fromString(jsonobject.getString("size"));
        } else
        {
            applovinadsize = AppLovinAdSize.BANNER;
        }
        s1 = null;
        obj = null;
        if (s == null || s.length() <= 0) goto _L2; else goto _L1
_L1:
        s4 = b(s);
        if (jsonobject.has("ad_target"))
        {
            adtarget = AppLovinAdImpl.AdTarget.valueOf(jsonobject.getString("ad_target").toUpperCase(Locale.ENGLISH));
        } else
        {
            adtarget = AppLovinAdImpl.AdTarget.DEFAULT;
        }
        if (jsonobject.has("ad_type"))
        {
            applovinadtype = AppLovinAdType.fromString(jsonobject.getString("ad_type").toUpperCase(Locale.ENGLISH));
        } else
        {
            applovinadtype = AppLovinAdType.REGULAR;
        }
        j = new c(applovinadsize, applovinadtype);
        if (!jsonobject.has("video")) goto _L4; else goto _L3
_L3:
        s = jsonobject.getString("video");
        if (s == null || s.isEmpty()) goto _L6; else goto _L5
_L5:
        try
        {
            s = d.a(h, s);
        }
        catch (Exception exception)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = s;
        i = true;
        obj = s;
_L9:
        if (obj == null)
        {
            c();
            return;
        }
        s1 = ((String) (obj));
_L4:
        float f1;
        int l;
        long l1 = -1L;
        if (jsonobject.has("ad_id"))
        {
            l1 = jsonobject.getLong("ad_id");
        }
        int k;
        int i1;
        if (jsonobject.has("countdown_length"))
        {
            try
            {
                k = jsonobject.getInt("countdown_length");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                k = 0;
            }
        } else
        {
            k = 0;
        }
        if (jsonobject.has("close_delay"))
        {
            try
            {
                l = jsonobject.getInt("close_delay");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                l = 0;
            }
        } else
        {
            l = 0;
        }
        if (!jsonobject.has("close_delay_graphic"))
        {
            break MISSING_BLOCK_LABEL_611;
        }
        i1 = jsonobject.getInt("close_delay_graphic");
        f1 = i1;
_L7:
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        String s2;
        String s3;
        if (jsonobject.has("close_style"))
        {
            try
            {
                obj = a(jsonobject.getInt("close_style"));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = a(s1);
            }
        } else
        {
            obj = a(s1);
        }
        if (jsonobject.has("clcodes"))
        {
            try
            {
                obj1 = ((JSONArray)jsonobject.get("clcodes")).getString(0);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                obj1 = "";
            }
        } else
        {
            obj1 = "";
        }
        obj3 = "";
        obj2 = obj3;
        if (jsonobject.has("video_end_url"))
        {
            try
            {
                obj2 = jsonobject.getString("video_end_url");
            }
            catch (Exception exception1)
            {
                exception1 = ((Exception) (obj3));
            }
        }
        obj4 = "";
        obj3 = obj4;
        if (jsonobject.has("mute_image"))
        {
            try
            {
                obj3 = f.getFileManager().a(h, jsonobject.getString("mute_image"), false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj3)
            {
                obj3 = obj4;
            }
        }
        s2 = "";
        obj4 = s2;
        if (jsonobject.has("unmute_image"))
        {
            try
            {
                obj4 = f.getFileManager().a(h, jsonobject.getString("unmute_image"), false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj4)
            {
                obj4 = s2;
            }
        }
        s3 = "";
        s2 = s3;
        if (jsonobject.has("click_tracking_url"))
        {
            try
            {
                s2 = jsonobject.getString("click_tracking_url");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                s2 = s3;
            }
        }
        a(((AppLovinAd) ((new AppLovinAdImpl.Builder()).setHtml(s4).setSize(applovinadsize).setType(applovinadtype).setVideoFilename(s1).setTarget(adtarget).setCloseStyle(((v) (obj))).setVideoCloseDelay(l).setPoststitialCloseDelay(f1).setCountdownLength(k).setCurrentAdIdNumber(l1).setClCode(((String) (obj1))).setCompletionUrl(((String) (obj2))).setSupplementalClickTrackingUrl(s2).setMuteImageFilename(((String) (obj3))).setUnmuteImageFilename(((String) (obj4))).build())));
        return;
        obj;
        f1 = a(s1, applovinadtype, l);
          goto _L7
        f1 = a(s1, applovinadtype, l);
          goto _L7
_L2:
        g.e(e, "No HTML received for requested ad");
        c();
        return;
_L6:
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private String b(String s)
    {
        String s1 = s;
        if (((Boolean)f.a(bw.H)).booleanValue())
        {
            s1 = c(s);
        }
        return s1;
    }

    private String c(String s)
    {
        s = new StringBuilder(s);
        String as[] = ((String)f.a(bw.I)).split(",");
        int l1 = as.length;
        int l = 0;
label0:
        do
        {
            if (l < l1)
            {
                String s1 = as[l];
                int k1 = 0;
                int j1 = 0;
                do
                {
                    int i1;
label1:
                    {
                        if (j1 < s.length())
                        {
                            i1 = s.indexOf(s1, k1);
                            if (i1 != -1)
                            {
                                break label1;
                            }
                        }
                        l++;
                        continue label0;
                    }
                    j1 = s.length();
                    int k;
                    for (k = i1; !a.contains(Character.valueOf(s.charAt(k))) && k < j1; k++) { }
                    if (k > i1 && k != j1)
                    {
                        String s2 = a(s1, s.substring(s1.length() + i1, k));
                        k1 = k;
                        j1 = i1;
                        if (s2 != null)
                        {
                            s.replace(i1, k, s2);
                            k1 = k;
                            j1 = i1;
                        }
                    } else
                    {
                        g.d(e, "Unable to cache resource; ad HTML is invalid.");
                        k1 = k;
                        j1 = i1;
                    }
                } while (true);
            }
            return s.toString();
        } while (true);
    }

    private Collection d()
    {
        HashSet hashset = new HashSet();
        char ac[] = ((String)f.a(bw.ap)).toCharArray();
        int l = ac.length;
        for (int k = 0; k < l; k++)
        {
            hashset.add(Character.valueOf(ac[k]));
        }

        hashset.add(Character.valueOf('"'));
        return hashset;
    }

    void a(AppLovinAd applovinad)
    {
        f.getLogger().d(a(), (new StringBuilder()).append("Rendered new ad:").append(applovinad).toString());
        if (c != null)
        {
            c.adReceived(applovinad);
        }
    }

    void c()
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (c instanceof w)
        {
            ((w)c).a(j, -6);
            return;
        }
        try
        {
            c.failedToReceiveAd(-6);
            return;
        }
        catch (Throwable throwable)
        {
            g.e(e, "Unable process a failure to receive an ad", throwable);
        }
    }

    public String e()
    {
        return "tRA";
    }

    public boolean f()
    {
        return i;
    }

    public void run()
    {
        g.d(e, "Rendering ad...");
        try
        {
            a(b);
            return;
        }
        catch (JSONException jsonexception)
        {
            g.e(e, "Unable to parse ad service response", jsonexception);
            c();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            g.e(e, "Ad response is not valid", illegalargumentexception);
            c();
            return;
        }
        catch (Exception exception)
        {
            g.e(e, "Unable to render ad", exception);
        }
        c();
    }
}
