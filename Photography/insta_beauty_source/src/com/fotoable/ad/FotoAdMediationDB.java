// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import aaq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import ie;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.fotoable.ad:
//            FotoAdMediationUpdateRequest

public class FotoAdMediationDB
{

    static final boolean $assertionsDisabled;
    public static String FOTO_BANNER_ID = "FOTO_BANNER_ID";
    public static String FOTO_HOME_BANNER_ID = "FOTO_HOME_BANNER_ID";
    public static String FOTO_HOME_WALL_ID = "FOTO_HOME_WALL_ID";
    public static String FOTO_INTERSTITIAL_ID = "FOTO_INTERSTITIAL_ID";
    public static String FOTO_PAD_BANNER_ID = "FOTO_PAD_BANNER_ID";
    public static String FOTO_SPECIAL_INTERSTITAL_ID = "FOTO_SPECIAL_INTERSTITAL_ID";
    public static String FoodPix_BundleName = "";
    public static final String FotoAdMediationIDGroup = "FotoAdMediationIDGroup";
    public static String Hicollage_BundleName;
    public static String InstaBeauty_BundleName;
    public static String InstaDaily_BundleName = "";
    public static String InstaMag_BundleName;
    public static String PIP_BundleName;
    public static String PhotoEditor_BundleName;
    public static String Wantu_BundleName;
    private static long daySeconds = 0x15180L;
    private static Boolean mDebug = Boolean.valueOf(false);

    public FotoAdMediationDB()
    {
    }

    public static void UpdateMediaionDB(final Context context)
    {
        String s = "";
        String s1;
        String s2;
        s2 = context.getPackageName();
        s1 = Locale.getDefault().getCountry();
        if (s2.compareTo(Wantu_BundleName) != 0) goto _L2; else goto _L1
_L1:
        s = "wantu";
_L3:
        try
        {
            s = String.format("%s&%s&%s", new Object[] {
                "http://fotorus.fotoable.com/fotorus/?m=ADconf&a=get&os=android", (new StringBuilder()).append("appid=").append(s).toString(), (new StringBuilder()).append("countrycode=").append(s1).toString()
            });
            Log.v("UpdateMediaionDB", (new StringBuilder()).append("UpdateMediaionDB url:").append(s).toString());
            (new FotoAdMediationUpdateRequest()).download(s, new _cls1());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final Context context)
        {
            Crashlytics.logException(context);
        }
        break MISSING_BLOCK_LABEL_215;
_L2:
        if (s2.compareTo(InstaMag_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        s = "InstaMag";
          goto _L3
        if (s2.compareTo(Hicollage_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        s = "instacollage";
          goto _L3
        if (s2.compareTo(InstaBeauty_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        s = "instabeauty";
          goto _L3
        if (s2.compareTo(PIP_BundleName) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = "pipcam";
          goto _L3
        if ($assertionsDisabled) goto _L3; else goto _L4
_L4:
        throw new AssertionError();
    }

    public static String getAdBannerID(Context context)
    {
        String s = context.getPackageName();
        if (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName.contains(".156"))
        {
            return "ca-app-pub-3558952810980936/3421009007";
        }
        break MISSING_BLOCK_LABEL_40;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        Crashlytics.logException(namenotfoundexception);
        if (s.compareTo("com.wantu.activity") == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-2494758279535445/9176785219";
            } else
            {
                return "ca-app-pub-2494758279535445/2544098412";
            }
        }
        if (s.compareTo("com.instamag.activity") == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-3558952810980936/6940025806";
            } else
            {
                return "ca-app-pub-3558952810980936/4269814601";
            }
        }
        if (s.compareTo("com.pipcamera.activity") == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-2494758279535445/8757982817";
            } else
            {
                return "ca-app-pub-2494758279535445/1234716018";
            }
        }
        if (s.compareTo("com.hicollage.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_BANNER_ID, "8fea563233504b84");
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-3558952810980936/8975162200";
            } else
            {
                return "ca-app-pub-3558952810980936/8597944602";
            }
        }
        if (s.compareTo(PhotoEditor_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-2494758279535445/9176785219";
            } else
            {
                return "ca-app-pub-2494758279535445/2544098412";
            }
        }
        if (s.compareTo(ie.l) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "ca-app-pub-2494758279535445/9311968816";
            } else
            {
                return "ca-app-pub-2494758279535445/1788702011";
            }
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getAdmobUnitID(Context context)
    {
        if (isNeedNewUserUId(context))
        {
            return getNewAdmobUnitID(context);
        } else
        {
            return getOldAdmobUnitID(context);
        }
    }

    public static String getAliFullWallADID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "14670463";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "14670469";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "14670457";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "14670448";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getAliIconADID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "14670462";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "14670468";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "14670456";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "14670446";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getAliNativeLoopADID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "14670461";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "14670467";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "14670455";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "14670447";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getFBIconAdID(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo(PIP_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "382743411764062_1001028796602184";
            } else
            {
                return "382743411764062_978818755489855";
            }
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "156379654548669_469420209911277";
            } else
            {
                return "156379654548669_459248767595088";
            }
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "344391832332795_727512530687388";
            } else
            {
                return "344391832332795_735620063209968";
            }
        }
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "116913278412853_748853405218834";
            } else
            {
                return "116913278412853_733865600050948";
            }
        }
        if (s.compareTo(PhotoEditor_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "116913278412853_748853405218834";
            } else
            {
                return "116913278412853_733865600050948";
            }
        }
        if (s.compareTo(ie.l) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "971620106251483_972060019540825";
            } else
            {
                return "971620106251483_972059946207499";
            }
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getFBNativeADID(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "116913278412853_559540700816773";
            } else
            {
                return "116913278412853_704407012996807";
            }
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "344391832332795_698317390273569";
            } else
            {
                return "344391832332795_554999171272059";
            }
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "156379654548669_464558520397446";
            } else
            {
                return "156379654548669_296029607250339";
            }
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "382743411764062_951166971588367";
            } else
            {
                return "382743411764062_803090683062664";
            }
        }
        if (s.compareTo(PhotoEditor_BundleName) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "116913278412853_559540700816773";
            } else
            {
                return "116913278412853_704407012996807";
            }
        }
        if (s.compareTo(ie.l) == 0)
        {
            if (isNeedNewUserUId(context))
            {
                return "971620106251483_972059819540845";
            } else
            {
                return "971620106251483_972059722874188";
            }
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getFBPIPResIconAdID(Context context)
    {
        if (context.getPackageName().compareTo(PIP_BundleName) == 0)
        {
            return "382743411764062_979396388765425";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getFBResIconAdID(Context context)
    {
        if (context.getPackageName().compareTo(PIP_BundleName) == 0)
        {
            return "382743411764062_979396388765425";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getGDTAPPID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "1101194912";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "1101194736";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "1104897680";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "1101194924";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getGDTIconADID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "2020702691962013";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "7090500641063082";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "3040408681364280";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "5020505651966014";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getGDTSplashAdId(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "3050907723497328";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "1010608743694379";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "4060907783098451";
        }
label0:
        {
            if (context.compareTo(InstaBeauty_BundleName) == 0)
            {
                return "5080605773496420";
            }
            break label0;
        }
        context;
        return "";
    }

    public static String getGDTWallADID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "6010007537680274";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "2080806671759974";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "3090307641963119";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "6060103631567020";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getHomeAdBannerID(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo("com.wantu.activity") == 0)
        {
            context = getValueWithKeyAndDefault(context, FOTO_HOME_BANNER_ID, "ca-app-pub-2494758279535445/7299627614");
        } else
        if (s.compareTo("com.instamag.activity") == 0)
        {
            context = getValueWithKeyAndDefault(context, FOTO_HOME_BANNER_ID, "ca-app-pub-3558952810980936/2793081404");
            if (mDebug.booleanValue())
            {
                return "ca-app-pub-3558952810980936/2189575007";
            }
        } else
        {
            if (s.compareTo("com.pipcamera.activity") == 0)
            {
                return getValueWithKeyAndDefault(context, FOTO_HOME_BANNER_ID, "ca-app-pub-2494758279535445/1532295611");
            }
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            } else
            {
                return "";
            }
        }
        return context;
    }

    public static String getHomeWallId(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo("com.wantu.activity") == 0)
        {
            getValueWithKeyAndDefault(context, FOTO_HOME_BANNER_ID, "/139555494/fotorus_home");
        } else
        if (s.compareTo("com.instamag.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_HOME_BANNER_ID, "/139555494/instamag_home_300_250");
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getInMobiHomeIconAdID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "f4b67a249ac343c3a6655a908f07aa23";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "a21edca69f6c4cbf89777287f7e0a66a";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "a04addb0bf654df78c1184d1c8f23cb9";
        }
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "26995fbac9134417ae8749bdd7d952df";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static long getInMobiHomeIconAdLongID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return 0x51f6fb750e110L;
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return 0x1508fb0cd96L;
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return 0x150550fdde6L;
        }
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return 0x1507c49bbc3L;
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return 0L;
        }
    }

    public static String getInMobiMagResIconAdID(Context context)
    {
        if (context.getPackageName().compareTo(PIP_BundleName) == 0)
        {
            return "8ca8751066684d5fa9551165e222e8af";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getInMobiPIPResIconAdID(Context context, int i)
    {
        if (context.getPackageName().compareTo(PIP_BundleName) == 0)
        {
            switch (i)
            {
            default:
                return "5cba301b1c254b4d8f824bd1afe138e5";

            case 0: // '\0'
                return "5cba301b1c254b4d8f824bd1afe138e5";

            case 1: // '\001'
                return "7bc4ced7bafc481b8b69c7e3d4c0beb4";

            case 2: // '\002'
                return "0480f9f88b11403b89bf3fa03c08212c";

            case 3: // '\003'
                return "e4e9bfc045fe475cbeb1fc319d299956";

            case 4: // '\004'
                return "fa5c1d8c050a4712b25bbfc467aaca6b";

            case 5: // '\005'
                return "0e67cceae888499caee6efcce767a091";
            }
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    static String getInterstitialID(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo("com.wantu.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_INTERSTITIAL_ID, "ca-app-pub-2494758279535445/8421813614");
        }
        if (s.compareTo("com.instamag.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_INTERSTITIAL_ID, "ca-app-pub-3558952810980936/3516484605");
        }
        if (s.compareTo("com.pipcamera.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_INTERSTITIAL_ID, "ca-app-pub-2494758279535445/6102096017");
        }
        if (s.compareTo("com.hicollage.activity") == 0)
        {
            return getValueWithKeyAndDefault(context, FOTO_INTERSTITIAL_ID, "8fea563233504b84");
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getNativeID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo("com.wantu.activity") == 0)
        {
            return "ca-app-pub-2494758279535445/5058900016";
        }
        if (context.compareTo("com.instamag.activity") == 0)
        {
            return "ca-app-pub-3558952810980936/6802207001";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getNewAdmobUnitID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/9595587618";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "ca-app-pub-3558952810980936/9893492209";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "ca-app-pub-3558952810980936/1451895408";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/3269852419";
        }
        if (context.compareTo(PhotoEditor_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/9595587618";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public static String getOldAdmobUnitID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/1793119211";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "ca-app-pub-3558952810980936/2370225405";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "ca-app-pub-3558952810980936/4405361802";
        }
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/4746585617";
        }
        if (context.compareTo(PhotoEditor_BundleName) == 0)
        {
            return "ca-app-pub-2494758279535445/1793119211";
        }
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    static String getSpecialInterstitialID(Context context)
    {
        String s = context.getPackageName();
        if (s.compareTo("com.wantu.activity") == 0)
        {
            context = getValueWithKeyAndDefault(context, FOTO_SPECIAL_INTERSTITAL_ID, "ca-app-pub-2494758279535445/8421813614");
        } else
        if (s.compareTo("com.instamag.activity") == 0)
        {
            context = getValueWithKeyAndDefault(context, FOTO_SPECIAL_INTERSTITAL_ID, "ca-app-pub-3558952810980936/3516484605");
            if (mDebug.booleanValue())
            {
                return "ca-app-pub-3558952810980936/3666308209";
            }
        } else
        {
            if (s.compareTo("com.pipcamera.activity") == 0)
            {
                return getValueWithKeyAndDefault(context, FOTO_SPECIAL_INTERSTITAL_ID, "ca-app-pub-2494758279535445/4625362812");
            }
            if (s.compareTo("com.hicollage.activity") == 0)
            {
                return getValueWithKeyAndDefault(context, FOTO_SPECIAL_INTERSTITAL_ID, "8fea563233504b84");
            }
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            } else
            {
                return "";
            }
        }
        return context;
    }

    static String getValueWithKeyAndDefault(Context context, String s, String s1)
    {
        return context.getSharedPreferences("FotoAdMediationIDGroup", 32768).getString(s, s1);
    }

    public static String getdfBannerAppName(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo("com.wantu.activity") == 0)
        {
            return "com.instamag.activity";
        }
        if (context.compareTo("com.instamag.activity") == 0)
        {
            return "com.wantu.activity";
        }
label0:
        {
            if (context.compareTo("com.pipcamera.activity") == 0)
            {
                return "com.pipcamera.activity";
            }
            break label0;
        }
        context;
        return "";
    }

    public static int getdfBannerResource(Context context)
    {
        int i;
        context = context.getPackageName();
        if (context.compareTo("com.wantu.activity") == 0)
        {
            if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
            {
                if (Locale.getDefault().getCountry().compareTo("CN") == 0)
                {
                    return aaq.magbanner_cn;
                } else
                {
                    return aaq.magbanner_en;
                }
            } else
            {
                return aaq.magbanner_en;
            }
        }
        if (context.compareTo("com.instamag.activity") == 0)
        {
            if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
            {
                return aaq.wantubanner_cn;
            } else
            {
                return aaq.wantubanner_en;
            }
        }
        if (context.compareTo("com.pipcamera.activity") != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        i = aaq.wantubanner_en;
        return i;
        context;
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            return aaq.wantubanner_cn;
        } else
        {
            return aaq.wantubanner_en;
        }
    }

    public static String getsecondFBHomeAdID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "382743411764062_1000854703286260";
        }
        if (context.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "156379654548669_464558520397446";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "344391832332795_735070459931595";
        }
        if (context.compareTo(Wantu_BundleName) == 0)
        {
            return "116913278412853_741585429278965";
        } else
        {
            return "";
        }
    }

    public static String getsecondFBIconAdID(Context context)
    {
        context = context.getPackageName();
        if (context.compareTo(PIP_BundleName) == 0)
        {
            return "382743411764062_1001028796602184";
        }
        if (context.compareTo(InstaMag_BundleName) == 0)
        {
            return "344391832332795_735620063209968";
        } else
        {
            return "";
        }
    }

    private static boolean isNeedNewUserUId(Context context)
    {
        boolean flag = false;
        context = context.getSharedPreferences("FotoAdMediationDB", 0);
        int i = context.getInt("openTimes", 0);
        long l = context.getLong("firstDate", 0L);
        long l1 = context.getLong("lastDate", 0L);
        long l2 = (new Date()).getTime();
        Log.e("GADBanner", (new StringBuilder()).append("curent:").append(l2).append(" first:").append(l).append(" last:").append(l1).append(" open:").append(i).toString());
        if (i <= 5 || (l2 - l) / 1000L <= 3L * daySeconds || (l2 - l1) / 1000L >= 10L * daySeconds)
        {
            flag = true;
        }
        return flag;
    }

    public static void setUserRecord(Context context, int i)
    {
        context = context.getSharedPreferences("FotoAdMediationDB", 0);
        long l = context.getLong("firstDate", 0L);
        if (i == -1)
        {
            context.edit().putLong("lastDate", (new Date()).getTime()).apply();
            return;
        }
        if (i == 1 || l == 0L)
        {
            context.edit().putLong("firstDate", (new Date()).getTime()).apply();
            return;
        } else
        {
            context.edit().putInt("openTimes", i).apply();
            return;
        }
    }

    static void setValueWithKeyAndValue(Context context, String s, String s1)
    {
        context = context.getSharedPreferences("FotoAdMediationIDGroup", 32768);
        context.edit().putString(s, s1).apply();
        context.getString(s, "").compareTo(s1);
    }

    static 
    {
        boolean flag;
        if (!com/fotoable/ad/FotoAdMediationDB.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        InstaMag_BundleName = ie.a;
        Wantu_BundleName = ie.b;
        InstaBeauty_BundleName = ie.c;
        PIP_BundleName = ie.e;
        PhotoEditor_BundleName = ie.j;
        Hicollage_BundleName = ie.d;
    }

    private class _cls1
        implements FotoAdMediationUpdateRequest.requestCallback
    {

        final Context val$context;

        public void onRequestError(Error error)
        {
        }

        public void onRequestSuccess(String s)
        {
            if (s != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s1;
            Object obj;
            obj = new JSONObject(s);
            s1 = ((JSONObject) (obj)).getString("banner");
            String s2 = ((JSONObject) (obj)).getString("video");
            s = ((JSONObject) (obj)).getString("fullscreen");
            String s3;
            String s4;
            String s5;
            s5 = s;
            s4 = s2;
            s3 = s1;
            obj = ((JSONObject) (obj)).getString("padbanner");
            if (s1 != null && s1.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_BANNER_ID, s1);
            }
            if (s2 != null && s2.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_SPECIAL_INTERSTITAL_ID, s2);
            }
            if (s != null && s.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_INTERSTITIAL_ID, s);
            }
            if (obj != null && ((String) (obj)).length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_PAD_BANNER_ID, ((String) (obj)));
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            Object obj1;
            obj1;
            s = null;
            s2 = null;
            s1 = null;
_L7:
            s5 = s;
            s4 = s2;
            s3 = s1;
            ((Exception) (obj1)).printStackTrace();
            s5 = s;
            s4 = s2;
            s3 = s1;
            Crashlytics.logException(((Throwable) (obj1)));
            if (s1 != null && s1.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_BANNER_ID, s1);
            }
            if (s2 != null && s2.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_SPECIAL_INTERSTITAL_ID, s2);
            }
            if (s != null && s.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_INTERSTITIAL_ID, s);
            }
            if (true) goto _L1; else goto _L4
_L4:
            throw new NullPointerException();
            s;
            obj1 = null;
            s2 = null;
            s1 = null;
_L6:
            if (s1 != null && s1.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_BANNER_ID, s1);
            }
            if (s2 != null && s2.length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_SPECIAL_INTERSTITAL_ID, s2);
            }
            if (obj1 != null && ((String) (obj1)).length() > 5)
            {
                FotoAdMediationDB.setValueWithKeyAndValue(context, FotoAdMediationDB.FOTO_INTERSTITIAL_ID, ((String) (obj1)));
            }
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                throw s;
            }
            s;
            obj1 = null;
            s2 = null;
            continue; /* Loop/switch isn't completed */
            s;
            obj1 = null;
            continue; /* Loop/switch isn't completed */
            s;
            obj1 = s5;
            s2 = s4;
            s1 = s3;
            if (true) goto _L6; else goto _L5
_L5:
            obj1;
            s = null;
            s2 = null;
              goto _L7
            obj1;
            s = null;
              goto _L7
            obj1;
              goto _L7
        }

        _cls1()
        {
            context = context1;
            super();
        }
    }

}
