// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.picsart.studio.ads.h;
import com.picsart.studio.ads.i;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import java.util.ArrayList;
import java.util.Iterator;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.ads:
//            AdProviders, c, SocialinAdView, a, 
//            d

public final class SocialinAdManager
{

    private static h a = null;
    private static h b = null;

    public static h a(Context context, PicsArtInterstitialType picsartinterstitialtype)
    {
_L2:
        switch (_cls3.b[picsartinterstitialtype.ordinal()])
        {
        default:
            return context;

        case 1: // '\001'
            b = context;
            return context;

        case 2: // '\002'
            a = context;
            break;
        }
        return context;
        com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
        Object obj = AdProviders.ADMOB;
        try
        {
            obj = AdProviders.valueOf(data.adInterstitialExport);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = AdProviders.ADMOB;
        }
        if (Inventory.isAdsEnabled() && !"NONE".equals(data.adInterstitialExport) && obj != null)
        {
            final class _cls3
            {

                static final int a[];
                static final int b[];

                static 
                {
                    b = new int[PicsArtInterstitialType.values().length];
                    try
                    {
                        b[PicsArtInterstitialType.DRAW.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        b[PicsArtInterstitialType.EXPORT.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    a = new int[AdProviders.values().length];
                    try
                    {
                        a[AdProviders.MOPUB2.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[AdProviders.ADMOB.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3.a[((AdProviders) (obj)).ordinal()])
            {
            default:
                context = m.b(context, AdProviders.ADMOB, context.getString(0x7f0808a4));
                break;

            case 1: // '\001'
                context = m.b(context, ((AdProviders) (obj)), context.getString(0x7f080949));
                continue; /* Loop/switch isn't completed */

            case 2: // '\002'
                context = m.b(context, ((AdProviders) (obj)), context.getString(0x7f0808a4));
                continue; /* Loop/switch isn't completed */
            }
            break;
        }
        context = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static c a(ViewGroup viewgroup, Context context, String s, boolean flag)
    {
        viewgroup = new c(context, viewgroup, s, flag);
        viewgroup.c = m.a(((c) (viewgroup)).f, AdProviders.MOPUB2, ((c) (viewgroup)).a);
        if (((c) (viewgroup)).c != null)
        {
            context = new android.widget.FrameLayout.LayoutParams(((c) (viewgroup)).d, ((c) (viewgroup)).e);
            ((c) (viewgroup)).c.a().setLayoutParams(context);
            context = ((c) (viewgroup)).c.a();
            ((c) (viewgroup)).g.addView(context);
        }
        viewgroup.b = true;
        return viewgroup;
    }

    static String a(com.socialin.android.apiv3.model.AppProps.Data data, String s)
    {
        return b(data, s);
    }

    public static void a(ViewGroup viewgroup, Activity activity, a a1, com.socialin.android.ads.d d1)
    {
        if (m.d())
        {
            viewgroup.setVisibility(0);
            com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
            SocialinAdView socialinadview = new SocialinAdView(activity);
            activity = AdProviders.ADMOB;
            if (!TextUtils.isEmpty(data.adProvider))
            {
                try
                {
                    activity = AdProviders.valueOf(data.adProvider);
                }
                // Misplaced declaration of an exception variable
                catch (Activity activity)
                {
                    activity = AdProviders.ADMOB;
                }
            }
            socialinadview.setDefaultAdProvider(activity);
            socialinadview.stopFlipping();
            viewgroup.addView(socialinadview);
            a1.a(socialinadview);
            d1.a(socialinadview);
            return;
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    public static void a(SocialinAdView socialinadview)
    {
        if (socialinadview != null && socialinadview.a != null)
        {
            socialinadview.a.b();
            socialinadview.a = null;
        }
    }

    public static void a(SocialinAdView socialinadview, AdProviders adproviders, AppProps appprops, Handler handler, String s)
    {
        handler.post(new Runnable(adproviders, appprops, s, socialinadview) {

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
                String s1;
                s1 = SocialinAdManager.a(((com.socialin.android.apiv3.model.AppProps.Data) (obj2)), c);
                AdProviders.valueOf(s1);
                obj = s1;
_L1:
                Object obj3;
                Object obj1;
                if (!TextUtils.isEmpty(((com.socialin.android.apiv3.model.AppProps.Data) (obj2)).keyWords))
                {
                    obj1 = ((com.socialin.android.apiv3.model.AppProps.Data) (obj2)).keyWords;
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

            
            {
                a = adproviders;
                b = appprops;
                c = s;
                d = socialinadview;
                super();
            }
        });
    }

    public static boolean a(PicsArtInterstitialType picsartinterstitialtype)
    {
        Object obj = null;
        _cls3.b[picsartinterstitialtype.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 68
    //                   2 75;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_75;
_L1:
        picsartinterstitialtype = obj;
_L4:
        if (picsartinterstitialtype != null && picsartinterstitialtype.a())
        {
            (new Handler()).post(new Runnable(picsartinterstitialtype) {

                private h a;

                public final void run()
                {
                    a.b();
                }

            
            {
                a = h1;
                super();
            }
            });
            return true;
        } else
        {
            return false;
        }
_L2:
        picsartinterstitialtype = b;
          goto _L4
        picsartinterstitialtype = a;
          goto _L4
    }

    private static String b(com.socialin.android.apiv3.model.AppProps.Data data, String s)
    {
        Object obj;
        obj = SocialinAdView.b.name();
        Object obj1 = obj;
        if (data != null)
        {
            obj1 = obj;
            if (!TextUtils.isEmpty(data.adProvider))
            {
                obj1 = data.adProvider;
            }
        }
        obj = obj1;
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = obj1;
        if (TextUtils.isEmpty(data.adProviderNew))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = obj1;
        Object obj3;
        try
        {
            obj3 = AdProviders.valueOf(data.adProviderNew);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        obj1 = data.adProviderNew;
        obj = obj1;
        SocialinAdView.b = ((AdProviders) (obj3));
        obj = obj1;
_L11:
        if (data == null || TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        obj1 = data.adProviderLocItems;
        if (obj1 == null || ((ArrayList) (obj1)).size() <= 0) goto _L2; else goto _L3
_L3:
        obj1 = ((ArrayList) (obj1)).iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L4
_L4:
        obj3 = (com.socialin.android.apiv3.model.AppProps.AdProviderLocItem)((Iterator) (obj1)).next();
        if (!s.equalsIgnoreCase(((com.socialin.android.apiv3.model.AppProps.AdProviderLocItem) (obj3)).name)) goto _L6; else goto _L5
_L5:
        data = ((com.socialin.android.apiv3.model.AppProps.AdProviderLocItem) (obj3)).value;
        if (!d.b);
_L8:
        return data;
_L2:
        ArrayList arraylist;
label0:
        {
            s = ((String) (obj));
            if (data == null)
            {
                break label0;
            }
            Object obj2 = data.adProviderAndroidVersionItems;
            s = ((String) (obj));
            if (obj2 == null)
            {
                break label0;
            }
            s = ((String) (obj));
            if (((ArrayList) (obj2)).size() <= 0)
            {
                break label0;
            }
            int j = android.os.Build.VERSION.SDK_INT;
            obj2 = ((ArrayList) (obj2)).iterator();
            do
            {
                s = ((String) (obj));
                if (!((Iterator) (obj2)).hasNext())
                {
                    break label0;
                }
                s = (com.socialin.android.apiv3.model.AppProps.AdProviderAndroidVersionItem)((Iterator) (obj2)).next();
            } while (!String.valueOf(j).equals(((com.socialin.android.apiv3.model.AppProps.AdProviderAndroidVersionItem) (s)).name));
            s = ((com.socialin.android.apiv3.model.AppProps.AdProviderAndroidVersionItem) (s)).value;
            if (!d.b);
        }
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        arraylist = data.adProviderAppVersionItems;
        if (arraylist == null || arraylist.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_356;
        }
        data = null;
        obj = SocialinV3.getInstance().getContext();
        obj = ((Context) (obj)).getPackageManager().getPackageInfo(((Context) (obj)).getPackageName(), 0);
        data = ((com.socialin.android.apiv3.model.AppProps.Data) (obj));
_L9:
        int k = ((PackageInfo) (data)).versionCode;
        data = arraylist.iterator();
        com.socialin.android.apiv3.model.AppProps.AdProviderAppVersionItem adproviderappversionitem;
        do
        {
            if (!data.hasNext())
            {
                break MISSING_BLOCK_LABEL_356;
            }
            adproviderappversionitem = (com.socialin.android.apiv3.model.AppProps.AdProviderAppVersionItem)data.next();
        } while (!String.valueOf(k).equals(adproviderappversionitem.name));
        s = adproviderappversionitem.value;
        data = s;
        if (d.b)
        {
            return s;
        }
        if (true) goto _L8; else goto _L7
_L7:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L9
        return s;
        if (true) goto _L11; else goto _L10
_L10:
    }


    private class PicsArtInterstitialType extends Enum
    {

        private static final PicsArtInterstitialType $VALUES[];
        public static final PicsArtInterstitialType DRAW;
        public static final PicsArtInterstitialType EXPORT;

        public static PicsArtInterstitialType valueOf(String s)
        {
            return (PicsArtInterstitialType)Enum.valueOf(com/socialin/android/ads/SocialinAdManager$PicsArtInterstitialType, s);
        }

        public static PicsArtInterstitialType[] values()
        {
            return (PicsArtInterstitialType[])$VALUES.clone();
        }

        static 
        {
            DRAW = new PicsArtInterstitialType("DRAW", 0);
            EXPORT = new PicsArtInterstitialType("EXPORT", 1);
            $VALUES = (new PicsArtInterstitialType[] {
                DRAW, EXPORT
            });
        }

        private PicsArtInterstitialType(String s, int j)
        {
            super(s, j);
        }
    }

}
