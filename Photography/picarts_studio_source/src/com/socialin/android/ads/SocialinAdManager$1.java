// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.text.TextUtils;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.ads:
//            SocialinAdManager, AdProviders, SocialinAdView

final class d
    implements Runnable
{

    private AdProviders a;
    private AppProps b;
    private String c;
    private SocialinAdView d;

    public final void run()
    {
        Object obj;
        Object obj2;
        obj = a.name();
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj2 = b.getData();
        (new StringBuilder("Country code :: ")).append(c);
        String s;
        s = SocialinAdManager.a(((com.socialin.android.apiv3.model.) (obj2)), c);
        AdProviders.valueOf(s);
        obj = s;
_L1:
        Object obj3;
        Object obj1;
        if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.) (obj2)).ds))
        {
            obj1 = ((com.socialin.android.apiv3.model.ds) (obj2)).ds;
        } else
        {
            obj1 = "photo";
        }
        obj3 = obj;
        obj2 = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            d.setKeywords(((String) (obj1)));
            obj2 = obj1;
            obj3 = obj;
        }
_L2:
        if (!TextUtils.isEmpty(((CharSequence) (obj3))))
        {
            try
            {
                obj = AdProviders.valueOf(((String) (obj3)));
                if (!((AdProviders) (obj)).equals(d.c))
                {
                    com.socialin.android.d.b("SocialinAdManager - ", new Object[] {
                        "prepare() - changing provider to adProvider:", obj, "  !!"
                    });
                    d.a(((AdProviders) (obj)));
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (d.c.equals(AdProviders.NONE))
        {
            try
            {
                d.a(a);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
        if (!((String) (obj2)).equals(""))
        {
            d.setKeywords(((String) (obj2)));
        }
        return;
        obj1;
          goto _L1
        obj2 = "photo";
        obj3 = obj;
          goto _L2
    }

    a(AdProviders adproviders, AppProps appprops, String s, SocialinAdView socialinadview)
    {
        a = adproviders;
        b = appprops;
        c = s;
        d = socialinadview;
        super();
    }
}
