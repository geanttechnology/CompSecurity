// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.f.a;
import com.google.a.a.e;
import com.target.ui.util.deep_link.f;
import com.target.ui.util.deep_link.m;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, t, s, i

class ay extends com.target.ui.analytics.a.f
{

    private static Map sRefToChannelMap;
    private com.target.ui.util.deep_link.e mDeepLinkArguments;
    private Class mFragmentClass;
    private Uri mUri;

    private ay(f f1)
    {
        Object obj;
        if (f1.d().b())
        {
            obj = ((Fragment)f1.d().c()).getClass();
        } else
        {
            obj = null;
        }
        mFragmentClass = ((Class) (obj));
        if (f1.f().b())
        {
            obj = (Uri)f1.f().c();
        } else
        {
            obj = null;
        }
        mUri = ((Uri) (obj));
        mDeepLinkArguments = f1.b();
    }

    static ay a(f f1)
    {
        return new ay(f1);
    }

    private String a(Uri uri)
    {
        if (uri == null)
        {
            return null;
        } else
        {
            return uri.toString();
        }
    }

    private String a(com.target.ui.util.deep_link.e e1)
    {
        if (e1 == null || !e1.d().b())
        {
            return null;
        } else
        {
            return (String)e1.d().c();
        }
    }

    private String a(m m1)
    {
        if (m1 == null || !m1.b().b())
        {
            return null;
        } else
        {
            return (String)m1.b().c();
        }
    }

    private String a(Class class1)
    {
        if (class1 == null)
        {
            return null;
        } else
        {
            return com.target.ui.analytics.a.t.a(class1).toString();
        }
    }

    private String b(com.target.ui.util.deep_link.e e1)
    {
        if (e1 == null || !e1.e().b())
        {
            return null;
        } else
        {
            return (String)e1.e().c();
        }
    }

    private String b(m m1)
    {
        if (m1 == null || !m1.a().b())
        {
            return null;
        } else
        {
            return (String)m1.a().c();
        }
    }

    private String c(m m1)
    {
        if (m1 == null || !m1.c().b())
        {
            return null;
        } else
        {
            return (String)m1.c().c();
        }
    }

    private String d(m m1)
    {
        if (m1 != null)
        {
            e e1 = m1.a();
            e e2 = m1.b();
            e e3 = m1.c();
            if (e1.b() && e2.b() && e3.b())
            {
                e e4 = m1.e();
                m1 = m1.d();
                if (e4.b() || m1.b())
                {
                    if (e4.b())
                    {
                        return (new StringBuilder()).append((String)e1.c()).append(":").append((String)e2.c()).append(":").append((String)e3.c()).append(":").append((String)e4.c()).toString();
                    } else
                    {
                        return (new StringBuilder()).append((String)e1.c()).append(":").append((String)e2.c()).append(":").append((String)e3.c()).append(":").append((String)m1.c()).toString();
                    }
                }
            }
        }
        return null;
    }

    private String e(m m1)
    {
        if (m1 == null || !m1.a().b())
        {
            m1 = null;
        } else
        {
            String s1 = (String)sRefToChannelMap.get(m1.a().c());
            m1 = s1;
            if (s1 == null)
            {
                return "unknown paid channel";
            }
        }
        return m1;
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "entryScreenName", a(mFragmentClass));
        com.target.ui.analytics.a.i.a(map, "deepLinkURI", a(mUri));
        com.target.ui.analytics.a.i.a(map, "affiliateID", a(mDeepLinkArguments.a()));
        com.target.ui.analytics.a.i.a(map, "ref", b(mDeepLinkArguments.a()));
        com.target.ui.analytics.a.i.a(map, "cpng", c(mDeepLinkArguments.a()));
        com.target.ui.analytics.a.i.a(map, "marketingCampaignID", d(mDeepLinkArguments.a()));
        com.target.ui.analytics.a.i.a(map, "marketingChannel", e(mDeepLinkArguments.a()));
        com.target.ui.analytics.a.i.a(map, "src", a(mDeepLinkArguments));
        com.target.ui.analytics.a.i.a(map, "trackingId", b(mDeepLinkArguments));
        return map;
    }

    protected s c()
    {
        return s.Unknown;
    }

    protected List d()
    {
        return null;
    }

    protected Long i()
    {
        return null;
    }

    static 
    {
        sRefToChannelMap = new a();
        sRefToChannelMap.put("tgt_adv_xc", "display ad");
        sRefToChannelMap.put("tgt_adv_xp", "display ad");
        sRefToChannelMap.put("tgt_email", "email");
        sRefToChannelMap.put("tgt_adv_xa", "affiliates");
        sRefToChannelMap.put("tgt_adv", "internal");
        sRefToChannelMap.put("tgt_df", "shop comparison");
        sRefToChannelMap.put("tgt_adv_short", "short url");
        sRefToChannelMap.put("tgt_adv_qr", "qr code");
        sRefToChannelMap.put("tgt_adv_xs", "paid search");
        sRefToChannelMap.put("tgt_soc", "social media");
    }
}
