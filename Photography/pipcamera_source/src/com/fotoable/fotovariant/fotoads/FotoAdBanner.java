// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotovariant.fotoads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;
import ew;
import java.util.ArrayList;
import java.util.Random;

public abstract class FotoAdBanner extends FrameLayout
{

    public static String Helpr_BundleName = "com.fotoable.helpr";
    public static String InstaBeauty_BundleName = "com.fotoable.fotobeauty";
    public static String InstaMag_BundleName = "com.instamag.activity";
    public static String OnePic_BundleName = "com.fotoable.photo.editor";
    public static String OnePic_PIPCameraLite_BundleName = "com.foto.photo.editor";
    public static String PIP_BundleName = "com.pipcamera.activity";
    private static String TAG = "FotoAdBanner";
    public static String Wantu_BundleName = "com.wantu.activity";
    private String appToShow;
    public View fotoView;

    public FotoAdBanner(Context context)
    {
        super(context);
        fotoView = null;
    }

    public FotoAdBanner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fotoView = null;
    }

    public FotoAdBanner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        fotoView = null;
    }

    private int getAppBannerImage(String s)
    {
        if (s.compareTo(Wantu_BundleName) == 0)
        {
            if (ew.a())
            {
                return com.fotoable.fotovariant.R.drawable.wantubanner_cn;
            } else
            {
                return com.fotoable.fotovariant.R.drawable.wantubanner_en;
            }
        }
        if (s.compareTo(InstaMag_BundleName) == 0)
        {
            if (ew.a())
            {
                return com.fotoable.fotovariant.R.drawable.magbanner_cn;
            } else
            {
                return com.fotoable.fotovariant.R.drawable.magbanner_en;
            }
        }
        if (s.compareTo(InstaBeauty_BundleName) == 0)
        {
            if (ew.a())
            {
                return com.fotoable.fotovariant.R.drawable.beautybanner_cn;
            } else
            {
                return com.fotoable.fotovariant.R.drawable.beautybanner_en;
            }
        }
        if (s.compareTo(PIP_BundleName) == 0)
        {
            if (ew.a())
            {
                return com.fotoable.fotovariant.R.drawable.pipbanner_cn;
            } else
            {
                return com.fotoable.fotovariant.R.drawable.pipbanner_en;
            }
        }
        if (s.compareTo(Helpr_BundleName) == 0)
        {
            return com.fotoable.fotovariant.R.drawable.helprbanner;
        } else
        {
            return com.fotoable.fotovariant.R.drawable.wantubanner_cn;
        }
    }

    private String getAppDownloadUrl(String s)
    {
        String s1;
        s1 = getContext().getPackageName();
        if (s1.compareToIgnoreCase(OnePic_BundleName) != 0)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        if (!ew.a())
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
        if (!ew.a())
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
        if (!ew.a())
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
            s = getContext().getPackageManager().getPackageInfo(s, 0);
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
        if (!getContext().getPackageName().equalsIgnoreCase(InstaBeauty_BundleName))
        {
            arraylist.add(InstaBeauty_BundleName);
        }
        if (!getContext().getPackageName().equalsIgnoreCase(Wantu_BundleName))
        {
            arraylist.add(Wantu_BundleName);
        }
        if (!getContext().getPackageName().equalsIgnoreCase(InstaMag_BundleName))
        {
            arraylist.add(InstaMag_BundleName);
        }
        if (!getContext().getPackageName().equalsIgnoreCase(PIP_BundleName))
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

    public void createDefaultBanner()
    {
        if (fotoView == null)
        {
            setRandomAppToShow();
            fotoView = new View(getContext());
            fotoView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            fotoView.setBackgroundResource(getAppBannerImage(appToShow));
            addView(fotoView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        fotoView.setVisibility(0);
        fotoView.setOnClickListener(new android.view.View.OnClickListener() {

            final FotoAdBanner a;

            public void onClick(View view)
            {
                Log.v(FotoAdBanner.TAG, (new StringBuilder()).append(FotoAdBanner.TAG).append(" default View clicked").toString());
                if (!a.isInstall(a.appToShow))
                {
                    break MISSING_BLOCK_LABEL_110;
                }
                view = a.getContext().getPackageManager().getLaunchIntentForPackage(a.appToShow);
                view.addFlags(0x10000000);
                a.getContext().startActivity(view);
                if (ew.a())
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
                    view.printStackTrace();
                }
                return;
                if (!ew.a())
                {
                    break MISSING_BLOCK_LABEL_223;
                }
                FlurryAgent.logEvent("FBDefaultBannerClicked_CN");
_L1:
                view = new Intent("android.intent.action.VIEW", Uri.parse(a.getAppDownloadUrl(a.appToShow)));
                view.addFlags(0x10000000);
                a.getContext().startActivity(view);
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
                        a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(a.appToShow).toString())));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                    return;
                }
                  goto _L1
            }

            
            {
                a = FotoAdBanner.this;
                super();
            }
        });
    }

    public abstract void refreshBanner();





}
