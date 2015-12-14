// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import aaq;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Random;
import yp;

public class fotoableBanner extends FrameLayout
{

    static final boolean $assertionsDisabled;
    public static String Helpr_BundleName = "com.fotoable.helpr";
    public static String InstaBeauty_BundleName = "com.fotoable.fotobeauty";
    public static String InstaMag_BundleName = "com.instamag.activity";
    public static String OnePic_BundleName = "com.fotoable.photo.editor";
    public static String OnePic_PIPCameraLite_BundleName = "com.foto.photo.editor";
    public static String PIP_BundleName = "com.pipcamera.activity";
    private static String TAG = "fotoableBanner_TAG";
    public static String Wantu_BundleName = "com.wantu.activity";
    private String appToShow;
    private View fotoView;
    private Context mContext;
    private android.widget.FrameLayout.LayoutParams mLayoutParams;

    public fotoableBanner(Context context)
    {
        super(context);
        mContext = context;
        mLayoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        createDefaultBanner();
    }

    private void createDefaultBanner()
    {
        setRandomAppToShow();
        fotoView = new View(mContext);
        fotoView.setOnClickListener(new _cls1());
        fotoView.setLayoutParams(mLayoutParams);
        fotoView.setBackgroundResource(getAppBannerImage(appToShow));
        addView(fotoView, mLayoutParams);
    }

    private int getAppBannerImage(String s)
    {
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            if (yp.a())
            {
                return aaq.wantubanner_cn;
            } else
            {
                return aaq.wantubanner_en;
            }
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            if (yp.a())
            {
                return aaq.magbanner_cn;
            } else
            {
                return aaq.magbanner_en;
            }
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            if (yp.a())
            {
                return aaq.beautybanner_cn;
            } else
            {
                return aaq.beautybanner_en;
            }
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            if (yp.a())
            {
                return aaq.pipbanner_cn;
            } else
            {
                return aaq.pipbanner_en;
            }
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return aaq.helprbanner;
        } else
        {
            return aaq.wantubanner_cn;
        }
    }

    private String getAppDownloadUrl(String s)
    {
        String s1;
        s1 = mContext.getPackageName();
        if (s1.compareToIgnoreCase(OnePic_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/GLT62VUai5OZjYvh_-4N465px440Px0vtrw1ww5B54xZRrWMSFLexhBUNGqbLbGMzi46M51en1E7Ltue4OJfoV4pEVF99gec6trmi6voxWM";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/gEzUDPtoDawQGdNXNtRgMa5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ErlN1pAb2WkzYRvjJ1ASwivo9Bi7VVAzugLgnLeTZWf4";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/48luSbJ5x8dNVP7jc2cFsK5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvFqtgHezFHlEdh-SAboTgd7K73zb_wdXF2L0tG100fDo";
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            return "http://ad.apps.fm/6Ms77sJRBIQNz7q2pkeRWa5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T78CnYF8AXJnJ1tBQVqCXu61SuveM8DuAjKl_eq_n-HvA";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/l13AC1ImXhHyqmwpAd7b3K5px440Px0vtrw1ww5B54xZRrWMSFLexhBUNGqbLbGMGiX7gIhTdVI9Xbm7LRhm5V4pEVF99gec6trmi6voxWM";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/bb_uHCz6J-ZTLOyow46uzq5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9ErlN1pAb2WkzYRvjJ1ASwig8PCxaOM3OqER9DjzF54yQ";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/syM7N15baLkj-3CQ194EE65px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvFqtgHezFHlEdh-SAboTgd3DmwMUmH_x5pShMmXapxvo";
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            return "http://ad.apps.fm/39Rr9Gqkh9tO2MOq9GoKoa5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T78CnYF8AXJnJ1tBQVqCXu631DyR8-TC_basu5Kbh0Xuw";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        if (s1.compareToIgnoreCase(OnePic_PIPCameraLite_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/jw3uEcDCzXGVIFmpOGoJQa5px440Px0vtrw1ww5B54ydFwmoF1IJBngZJFApwlyg_VDnJmK94_AVtun-nKvxTrw2Bl2Yye9QLQ9uhr4BR9A";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/zTXf2QY3MiagZfLHW6pVrq5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9E_NmcM00Yqh2o_MwSK-8eMt_zk6XVqgqJhjBVmSxKPUc";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/02N15-lm88loNhlbK3nbna5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vv2HUC5o_MyHhtl-EETF5z9oZeqapyoCnI9T_OV-XSXBrwmGoCp43dyUyi8sCzsPeK";
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            return "http://ad.apps.fm/rhNLxTNPygG11YHmM3GtPq5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T7wI9pl58cQNsa9CtvlHFH8dVrROeWpgkZKubU9f7aM6jQQFtvGmGm78YegHkNWCxf";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/5mDET4KvjRGpG0JYxQVr4a5px440Px0vtrw1ww5B54ydFwmoF1IJBngZJFApwlyg_VDnJmK94_AVtun-nKvxTlytKFkfC7iRNFWKsvS8zfA";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/fcyoqcl5isWDk3ovNRDLiK5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9E_NmcM00Yqh2o_MwSK-8eMojZMIEsDHCg71hbp9UG2LM";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/T8Z-q0tNZU_Jc5gjv2jzNq5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vv2HUC5o_MyHhtl-EETF5z9k6QM8UiwsgxRFMsOqTzePrwmGoCp43dyUyi8sCzsPeK";
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            return "http://ad.apps.fm/xOXe46rnqwSiJMMInUUaga5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T7wI9pl58cQNsa9CtvlHFH8RKDH8UNwHvNkjHoflVADRnQQFtvGmGm78YegHkNWCxf";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        if (s1.compareToIgnoreCase(PIP_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_368;
        }
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/0_8iUqb0X8sUU8N2q-lWEq5px440Px0vtrw1ww5B54zqYm02ZgjOdrnbv6oz55qc1i_eJUaLbHF5Q-o-f4Nej9BAW28aYabvxh6AeQ1YLF8";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/0cnelf2mQQj8Cl6UkutIPq5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EssbuJIVIboaoStQpKWv6RExXWsvV57Dl5d-zGMcu3cI";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/0GvzmtCTzYUpZlpvLRIkKq5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvIRsnpJ59y84Aw9JG8Lc404ykfv24fiwF26iFmUgL1oU";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/ITwV-PGPewggVRF58VEI_65px440Px0vtrw1ww5B54zqYm02ZgjOdrnbv6oz55qcMh3DZSBn3BkjY7SWkXzg_NBAW28aYabvxh6AeQ1YLF8";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/61FhJvRjx3ojg2jIbITZAK5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EV1-hsRZ35ZHZfA3bGXJOSExXWsvV57Dl5d-zGMcu3cI";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/SR7Rq73l0lt-F3paRzLTCK5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvIRsnpJ59y84Aw9JG8Lc407FE0VUsRnE9meu6-jDD8aw";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        }
        break MISSING_BLOCK_LABEL_421;
        Exception exception;
        exception;
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "http://ad.apps.fm/PchgzSYhEteD2A3gsMljbK5px440Px0vtrw1ww5B54z5UZIndc4n0XL8vV1LOStSlvQxbv2GuqOMuPr0NkKnFNuAEIU3m85tThxwSNY1_oo";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "http://ad.apps.fm/5N83LCGv25XS9IK2Wouwqa5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EJfa5ANJkG7Cuc3SYZkhYu7J0qUk3OjfDYjebtGmHnyI";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "http://ad.apps.fm/YXde3hjb0mA8ZElwIAVkTa5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvFVvbF2eRetdEdAfiusigTWJlyO_BGOEochf42W8LWKI";
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            return "http://ad.apps.fm/oF7ZhrWhrguNUSSC6b03hK5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T7Chyj4BqVBTGDjRjDG6ojpPCYagKnjd3JTKLywLOw94o";
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return "http://ad.apps.fm/P_AOnb_ysHghvx6VJ12PGK5px440Px0vtrw1ww5B54wlgK0PhulYZ7M48L549WYYwYFiZ1lOVgyzGnHa5TYIDdBAW28aYabvxh6AeQ1YLF8";
        } else
        {
            return "http://ad.apps.fm/PchgzSYhEteD2A3gsMljbK5px440Px0vtrw1ww5B54z5UZIndc4n0XL8vV1LOStSlvQxbv2GuqOMuPr0NkKnFNuAEIU3m85tThxwSNY1_oo";
        }
    }

    private boolean isInstall(String s)
    {
        try
        {
            s = mContext.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        return s != null;
    }

    private void setRandomAppToShow()
    {
        ArrayList arraylist = new ArrayList();
        if (!mContext.getPackageName().equalsIgnoreCase(InstaBeauty_BundleName))
        {
            arraylist.add(InstaBeauty_BundleName);
        }
        if (!mContext.getPackageName().equalsIgnoreCase(Wantu_BundleName))
        {
            arraylist.add(Wantu_BundleName);
        }
        if (!mContext.getPackageName().equalsIgnoreCase(InstaMag_BundleName))
        {
            arraylist.add(InstaMag_BundleName);
        }
        if (!mContext.getPackageName().equalsIgnoreCase(PIP_BundleName))
        {
            arraylist.add(PIP_BundleName);
        }
        if (arraylist != null && arraylist.size() > 0)
        {
            int i = (new Random()).nextInt(arraylist.size());
            if (i >= 0 && i < arraylist.size())
            {
                appToShow = (String)arraylist.get(i);
            }
            return;
        } else
        {
            appToShow = "";
            return;
        }
    }

    public void destroy()
    {
    }

    public String getFBBannerADID()
    {
        String s = mContext.getPackageName();
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            return "116913278412853_546213168816193";
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            return "344391832332795_541701999268443";
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            return "156379654548669_379637078889591";
        }
label0:
        {
            if (s.compareTo(PIP_BundleName) == 0)
            {
                return "382743411764062_769274006444332";
            }
            break label0;
        }
        Exception exception;
        exception;
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        } else
        {
            return "";
        }
    }

    public void loadAd()
    {
        boolean flag;
        try
        {
            flag = yp.a();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        if (flag);
    }

    static 
    {
        boolean flag;
        if (!com/fotoable/ad/fotoableBanner.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }






    private class _cls1
        implements android.view.View.OnClickListener
    {

        final fotoableBanner this$0;

        public void onClick(View view)
        {
            Log.v(fotoableBanner.TAG, (new StringBuilder()).append(fotoableBanner.TAG).append(" default View clicked").toString());
            if (!isInstall(appToShow))
            {
                break MISSING_BLOCK_LABEL_110;
            }
            view = mContext.getPackageManager().getLaunchIntentForPackage(appToShow);
            view.addFlags(0x10000000);
            mContext.startActivity(view);
            if (yp.a())
            {
                FlurryAgent.logEvent("FBDefaultBannerClicked_Opened_CN");
                return;
            }
            try
            {
                FlurryAgent.logEvent("FBDefaultBannerClicked_Opened_EN");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
            }
            return;
            if (!yp.a())
            {
                break MISSING_BLOCK_LABEL_223;
            }
            FlurryAgent.logEvent("FBDefaultBannerClicked_CN");
_L1:
            view = new Intent("android.intent.action.VIEW", Uri.parse(getAppDownloadUrl(appToShow)));
            view.addFlags(0x10000000);
            mContext.startActivity(view);
            return;
            try
            {
                FlurryAgent.logEvent("FBDefaultBannerClicked_EN");
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                try
                {
                    mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(appToShow).toString())));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Crashlytics.logException(view);
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
                return;
            }
              goto _L1
        }

        _cls1()
        {
            this$0 = fotoableBanner.this;
            super();
        }
    }

}
