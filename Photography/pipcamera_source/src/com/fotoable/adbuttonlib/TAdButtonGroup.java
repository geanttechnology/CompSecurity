// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import es;
import ew;
import ix;
import ja;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdItem, TAdButton

public class TAdButtonGroup
    implements com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener
{

    private static String TAG = "TAdButtonGroup";
    static TAdButtonGroup _instance;
    public static boolean isGoogleApk = false;
    private Activity activity;
    int adButtonCount;
    List adButtonsList;
    List adJsonList;
    private OnAdButtonClickedLisener lisener;
    private Context mContext;
    private String mCurPackageName;
    int nativeIconCount;
    List nativeIcons;
    boolean needRequestWhenActivitySet;

    public TAdButtonGroup(Context context)
    {
        adButtonsList = new ArrayList();
        adJsonList = new ArrayList();
        nativeIcons = new ArrayList();
        nativeIconCount = 1;
        adButtonCount = 6;
        mCurPackageName = "";
        lisener = null;
        needRequestWhenActivitySet = false;
        mContext = context;
        mCurPackageName = ew.j(context);
        nativeIconCount = getNativeIconCount(context);
        adButtonCount = getAdButtonCount(context);
    }

    private TAdItem getDefault0()
    {
        TAdItem taditem = new TAdItem(activity, null);
        if (mCurPackageName.equalsIgnoreCase(es.b))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_wantu_2_beauty);
            taditem.setdefaultSchemeURL("com.fotoable.fotobeauty");
            taditem.setappId("com.fotoable.fotobeauty");
            taditem.adNameCN = "\u7F8E\u4E3D\u62CD";
            taditem.adNameEN = "InstaBeauty";
            taditem.adNameTW = "\u7F8E\u9E97\u62CD";
            if (ew.a())
            {
                taditem.setadUR("http://ad.apps.fm/-VQoKtod2LfGkJL8L2fKYa5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vv1WAE2arbSwHa1iCSD_fBHb7qunwzLLk_kxw-kSXlr9Q");
            } else
            {
                taditem.setadUR("http://ad.apps.fm/z_12upWN3E26CYnVHz1Apa5px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvHtNdqUPNTJs3lRJBqTPW4X8F0vcHnZ_WZIV6y3nbC5E");
            }
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.e))
        {
            if (ew.a())
            {
                taditem.setadUR("http://ad.apps.fm/NKHcPd0V2MFI34yMEfktO65px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EMaOCKE1cU_aEV6eg1TrqcRJsLf6sHmKLhWn5Z_15240");
            } else
            {
                taditem.setadUR("http://ad.apps.fm/BVyl4z8Xsh-KvT6H596Mk65px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EeCs4Cr7PIpigrHxOwhzw1c7RZsSDn0Hj9ESMED8NjmE");
            }
            if (isGoogleApk)
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_pip_mag);
            } else
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_pip_2_instamag);
            }
            taditem.setdefaultSchemeURL("com.instamag.activity");
            taditem.setappId("com.instamag.activity");
            taditem.adNameCN = "\u62FC\u7ACB\u5F97";
            taditem.adNameEN = "InstaMag";
            taditem.adNameTW = "\u62FC\u7ACB\u5F97";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.a))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_mag_2_wantu);
            taditem.setdefaultSchemeURL(es.b);
            taditem.setappId(es.b);
            taditem.mdefaultSchemeURL = es.b;
            if (ew.b())
            {
                taditem.madURL = "http://ad.apps.fm/iSrEsWG2k1kobUQZ3P-iS65px440Px0vtrw1ww5B54z5UZIndc4n0XL8vV1LOStSkYq0uiCibZp-ZCcw5mM_WvntgzwSIbwy3z-7RBdIM0s";
            } else
            {
                taditem.madURL = "http://ad.apps.fm/Rd8bqw_lEDLXt9kF7lBuIq5px440Px0vtrw1ww5B54z5UZIndc4n0XL8vV1LOStSkYq0uiCibZp-ZCcw5mM_WqUa35oWxLUGAbDIz5GWong";
            }
            taditem.adNameCN = "\u73A9\u56FE";
            taditem.adNameEN = "Fotorus";
            taditem.adNameTW = "\u73A9\u5716";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.c))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_beauty_2_wantu);
            taditem.setdefaultSchemeURL(es.b);
            taditem.setappId(es.b);
            taditem.adNameCN = "\u73A9\u56FE";
            taditem.adNameEN = "FotoRus";
            taditem.adNameTW = "\u73A9\u5716";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.k))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_makeup_1_wantu);
            taditem.setdefaultSchemeURL(es.b);
            taditem.setappId(es.b);
            taditem.adNameCN = "\u73A9\u56FE";
            taditem.adNameEN = "FotoRus";
            taditem.adNameTW = "\u73A9\u5716";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.l))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_beauty_2_wantu);
            taditem.setdefaultSchemeURL(es.b);
            taditem.setappId(es.b);
            taditem.adNameCN = "\u73A9\u56FE";
            taditem.adNameEN = "FotoRus";
            taditem.adNameTW = "\u73A9\u5716";
            taditem.openIfExist = true;
            return taditem;
        } else
        {
            taditem.openIfExist = true;
            return taditem;
        }
    }

    private TAdItem getDefault1()
    {
        TAdItem taditem = new TAdItem(activity, null);
        if (mCurPackageName.equalsIgnoreCase(es.b))
        {
            if (isGoogleApk)
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_wantu_2_mag);
                taditem.setdefaultSchemeURL(es.a);
                taditem.setappId(es.a);
                taditem.adNameCN = "\u62FC\u7ACB\u5F97";
                taditem.adNameEN = "InstaMag";
                taditem.adNameTW = "\u62FC\u7ACB\u5F97";
                taditem.setadUR("https://ad.apps.fm/y9PCdTTyRl1PBt7t9LZ-oa5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EGswKHjXEopiZj1aK8cWy9-GnOkz4U0n0SshOkqxVUaI");
                taditem.openIfExist = true;
            }
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.e))
        {
            if (ew.a())
            {
                taditem.setadUR("http://ad.apps.fm/s-OZW7CfoPXw3F9f-jM29K5px440Px0vtrw1ww5B54zqYm02ZgjOdrnbv6oz55qcsi37H5tPAUJ7f6pVvA0zGQrtMvN9OpGbYGPJVPiRzhA");
            } else
            {
                taditem.setadUR("http://ad.apps.fm/IShukUFGd7rn4zUhcB2SxK5px440Px0vtrw1ww5B54zqYm02ZgjOdrnbv6oz55qcR_ZsNzFsodOxS-YpGX7IQArtMvN9OpGbYGPJVPiRzhA");
            }
            if (isGoogleApk)
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_pip_wantu);
            } else
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_pip_2_wantu);
            }
            taditem.setdefaultSchemeURL(es.b);
            taditem.setappId(es.b);
            taditem.adNameCN = "\u73A9\u56FE";
            taditem.adNameEN = "FotoRus";
            taditem.adNameTW = "\u73A9\u5716";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.a))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_mag_2_pip);
            taditem.setdefaultSchemeURL(es.e);
            taditem.setappId(es.e);
            if (ew.b())
            {
                taditem.madURL = "http://ad.apps.fm/X1Z3Hpuy67yL8bvIHPmwda5px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T7VV0BBeaDjjOZRxfxtoLYjWpJAX06nzwIaS8AxDv137M";
            } else
            {
                taditem.madURL = "http://ad.apps.fm/mXfdV2rZu0kILtHWoANZf65px440Px0vtrw1ww5B54xNK9z491D6XdiiT2B2I3T7VV0BBeaDjjOZRxfxtoLYjdoGw8tfLodF_7VVZUE0nsc";
            }
            taditem.adNameCN = "\u753B\u4E2D\u753B";
            taditem.adNameEN = "PIP Camera";
            taditem.adNameTW = "\u756B\u4E2D\u756B";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.c))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_mag_2_pip);
            taditem.setdefaultSchemeURL(es.e);
            taditem.setappId(es.e);
            taditem.adNameCN = "\u753B\u4E2D\u753B";
            taditem.adNameEN = "PIP Camera";
            taditem.adNameTW = "\u756B\u4E2D\u756B";
            taditem.openIfExist = true;
            return taditem;
        }
        if (mCurPackageName.equalsIgnoreCase(es.k))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_makeup_0_instamag);
            taditem.setdefaultSchemeURL(es.a);
            taditem.setappId(es.a);
            taditem.adNameCN = "\u62FC\u7ACB\u5F97";
            taditem.adNameEN = "InstaMag";
            taditem.adNameTW = "\u62FC\u7ACB\u5F97";
            taditem.openIfExist = true;
            return taditem;
        } else
        {
            taditem.openIfExist = true;
            return taditem;
        }
    }

    private TAdItem getDefault2()
    {
        TAdItem taditem = new TAdItem(activity, null);
        if (mCurPackageName.equalsIgnoreCase(es.a))
        {
            if (ew.a())
            {
                taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_mag_2_beautypage);
                taditem.setdefaultSchemeURL("com.fotoable.helpr");
                taditem.madURL = "http://ad.apps.fm/muM0wPbmSWzrZGnBb11g2a5px440Px0vtrw1ww5B54xFYyAdzud_hdGHA2uuVLvYXDzVa9dSev9PtM_9jvvhZNA0WtviI5MkQuOpIwtzFiI";
                taditem.setappId("com.fotoable.instapage");
                taditem.adNameCN = "\u7F8E\u9875";
                taditem.adNameEN = "\u7F8E\u9875";
                taditem.adNameTW = "\u7F8E\u9875";
                taditem.openIfExist = true;
            }
            return taditem;
        } else
        {
            taditem.openIfExist = true;
            return taditem;
        }
    }

    private TAdItem getDefault3()
    {
        TAdItem taditem = new TAdItem(activity, null);
        taditem.openIfExist = true;
        return taditem;
    }

    private TAdItem getDefault4()
    {
        TAdItem taditem = new TAdItem(activity, null);
        if (mCurPackageName.equalsIgnoreCase(es.a))
        {
            taditem.setImageResId(com.fotoable.fotoadpackage.R.drawable.adbutton_mag_2_beauty);
            taditem.setdefaultSchemeURL("com.fotoable.fotobeauty");
            if (ew.b())
            {
                taditem.madURL = "http://ad.apps.fm/nWTovSyej_9V1_Rs4hzTD65px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvWqimC3uyRQKCYTq00g7O5nMv5HVpUy_0qfi2ajv16CQ";
            } else
            {
                taditem.madURL = "http://ad.apps.fm/0uLJpGblelv7s1Soa-RVn65px440Px0vtrw1ww5B54yRq5yycRabt2HbxOm1c-vvWqimC3uyRQKCYTq00g7O5oF_Vg6bKYYgz5pVSRQ2rWc";
            }
            taditem.setappId("com.fotoable.fotobeauty");
            taditem.adNameCN = "\u7F8E\u4E3D\u62CD";
            taditem.adNameEN = "InstaBeauty";
            taditem.adNameTW = "\u7F8E\u9E97\u62CD";
            taditem.openIfExist = true;
            return taditem;
        } else
        {
            taditem.openIfExist = true;
            return taditem;
        }
    }

    public static TAdButtonGroup instance(Application application)
    {
        if (_instance == null)
        {
            _instance = new TAdButtonGroup(application.getApplicationContext());
        }
        _instance.checkNativeIcons();
        return _instance;
    }

    public static TAdButtonGroup instance(Context context)
    {
        if (_instance == null)
        {
            _instance = new TAdButtonGroup(context);
        }
        _instance.checkNativeIcons();
        return _instance;
    }

    private void setJsonItemsToAdButton(TAdButton tadbutton, JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        Exception exception;
        int i;
        char c;
        try
        {
            tadbutton.clear();
        }
        // Misplaced declaration of an exception variable
        catch (TAdButton tadbutton)
        {
            tadbutton.printStackTrace();
            Crashlytics.logException(tadbutton);
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_data, "dataAbalyzeFail");
            return;
        }
        c = '\u0BB8';
        i = c;
        if (jsonobject.isNull("ti"))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        i = Integer.parseInt(jsonobject.getString("ti"));
        i *= 1000;
_L4:
        tadbutton.setTl(i);
        if (jsonobject.isNull("ads"))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        jsonobject = jsonobject.getJSONArray("ads");
        i = 0;
_L2:
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject1 = jsonobject.getJSONObject(i);
        tadbutton.addAdItem(TAdItem.fromJson(activity, jsonobject1));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        break; /* Loop/switch isn't completed */
        exception;
        Crashlytics.logException(exception);
        i = c;
        if (true) goto _L4; else goto _L3
_L3:
        if (jsonobject.length() <= 0)
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_data, "dataEmpty");
        }
_L6:
        tadbutton.loadNetItem();
        return;
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_data, "dataEmpty");
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void activeTimer()
    {
        Iterator iterator;
        if (adButtonsList == null || adButtonsList.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        iterator = adButtonsList.iterator();
_L2:
        TAdButton tadbutton;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_64;
            }
            tadbutton = (TAdButton)iterator.next();
        } while (tadbutton == null);
        tadbutton.activeTimer();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        Crashlytics.logException(exception);
    }

    public void applyNativeIcon()
    {
        if (!mCurPackageName.equalsIgnoreCase(es.e) || isGoogleApk) goto _L2; else goto _L1
_L1:
        TAdButton tadbutton = (TAdButton)adButtonsList.get(1);
        FotoNativeIcon fotonativeicon = (FotoNativeIcon)nativeIcons.get(0);
        if (fotonativeicon.isLoaded && tadbutton != null)
        {
            tadbutton.addfbNativeAd(fotonativeicon);
            tadbutton.loadNetItem();
        }
_L4:
        return;
_L2:
        if (mCurPackageName.equalsIgnoreCase(es.a))
        {
            if (adButtonsList.size() >= 5)
            {
                TAdButton tadbutton1 = (TAdButton)adButtonsList.get(0);
                FotoNativeIcon fotonativeicon1 = (FotoNativeIcon)nativeIcons.get(0);
                if (fotonativeicon1.isLoaded && tadbutton1 != null)
                {
                    tadbutton1.addfbNativeAd(fotonativeicon1);
                    tadbutton1.loadNetItem();
                }
                if (nativeIcons.size() > 1)
                {
                    TAdButton tadbutton2 = (TAdButton)adButtonsList.get(4);
                    FotoNativeIcon fotonativeicon2 = (FotoNativeIcon)nativeIcons.get(1);
                    if (fotonativeicon2.isLoaded && tadbutton2 != null)
                    {
                        tadbutton2.addfbNativeAd(fotonativeicon2);
                        tadbutton2.loadNetItem();
                        return;
                    }
                }
            }
        } else
        {
            int i = 0;
            while (i < nativeIcons.size()) 
            {
                if (i < adButtonsList.size())
                {
                    TAdButton tadbutton3 = (TAdButton)adButtonsList.get(i);
                    FotoNativeIcon fotonativeicon3 = (FotoNativeIcon)nativeIcons.get(i);
                    if (fotonativeicon3.isLoaded && tadbutton3 != null)
                    {
                        tadbutton3.addfbNativeAd(fotonativeicon3);
                        tadbutton3.loadNetItem();
                    }
                }
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void cancelTimer()
    {
        Iterator iterator;
        if (adButtonsList == null || adButtonsList.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        iterator = adButtonsList.iterator();
_L2:
        TAdButton tadbutton;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_64;
            }
            tadbutton = (TAdButton)iterator.next();
        } while (tadbutton == null);
        tadbutton.cancelTimer();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        Crashlytics.logException(exception);
    }

    public void checkNativeIcons()
    {
        if (nativeIcons.size() == 0 && nativeIconCount > 0)
        {
            for (int i = 0; i < nativeIconCount; i++)
            {
                FotoNativeIcon fotonativeicon = ix.b(mContext);
                fotonativeicon.sortIndex = i;
                nativeIcons.add(fotonativeicon);
            }

        }
    }

    public void delayRequestNativeAd()
    {
        for (int i = 0; i < nativeIcons.size(); i++)
        {
            if (((FotoNativeIcon)nativeIcons.get(i)).activity == null)
            {
                needRequestWhenActivitySet = true;
                return;
            }
        }

        requestNativeAdForiegn();
    }

    public int getAdButtonCount(Context context)
    {
        boolean flag = true;
        byte byte0;
        if (mCurPackageName.equalsIgnoreCase(es.b))
        {
            byte0 = 3;
        } else
        {
            byte0 = flag;
            if (!mCurPackageName.equalsIgnoreCase(es.j))
            {
                if (mCurPackageName.equalsIgnoreCase(es.c))
                {
                    return 2;
                }
                if (mCurPackageName.equalsIgnoreCase(es.a))
                {
                    return 6;
                }
                if (mCurPackageName.equalsIgnoreCase(es.e))
                {
                    return 2;
                }
                if (mCurPackageName.equalsIgnoreCase(es.k))
                {
                    return 2;
                }
                byte0 = flag;
                if (!mCurPackageName.equalsIgnoreCase(es.l))
                {
                    return 2;
                }
            }
        }
        return byte0;
    }

    public OnAdButtonClickedLisener getClickedLisener()
    {
        return lisener;
    }

    public TAdItem getDefaultItemByIndex(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return getDefault0();

        case 1: // '\001'
            return getDefault1();

        case 2: // '\002'
            return getDefault2();

        case 3: // '\003'
            return getDefault3();

        case 4: // '\004'
            return getDefault4();
        }
    }

    public int getNativeIconCount(Context context)
    {
_L2:
        return 1;
        if (mCurPackageName.equalsIgnoreCase(es.b) || mCurPackageName.equalsIgnoreCase(es.j) || mCurPackageName.equalsIgnoreCase(es.c)) goto _L2; else goto _L1
_L1:
        if (!mCurPackageName.equalsIgnoreCase(es.a))
        {
            break; /* Loop/switch isn't completed */
        }
        if (isGoogleApk)
        {
            return 2;
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (!mCurPackageName.equalsIgnoreCase(es.e))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!isGoogleApk) goto _L2; else goto _L4
_L4:
        return 2;
        if (mCurPackageName.equalsIgnoreCase(es.l)) goto _L2; else goto _L5
_L5:
        return 0;
    }

    public void onAdInReterund(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        int i;
        JSONArray jsonarray;
        JSONObject jsonobject;
        try
        {
            adJsonList.clear();
            jsonarray = new JSONArray(FotoAdStrategy.getMadBtnInfo());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_data, "dataAbalyzeFail");
            return;
        }
        i = 0;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = jsonarray.getJSONObject(i);
        adJsonList.add(jsonobject);
        i++;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_27;
_L9:
        if (i >= adJsonList.size()) goto _L6; else goto _L5
_L5:
        if (adButtonsList.size() - 1 >= i)
        {
            Log.i("999999999", (new StringBuilder()).append("i").append(i).append(((JSONObject)adJsonList.get(i)).toString()).toString());
            setJsonItemsToAdButton((TAdButton)adButtonsList.get(i), (JSONObject)adJsonList.get(i));
        }
          goto _L7
_L6:
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_data, "dataAbalyzeSuccess");
_L2:
        return;
_L3:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void registerAdButton(TAdButton tadbutton, int i)
    {
        if (adButtonsList.size() == 0)
        {
            for (int j = 0; j < adButtonCount; j++)
            {
                adButtonsList.add(new TAdButton(mContext));
            }

        }
        if (i < adButtonsList.size())
        {
            adButtonsList.set(i, tadbutton);
            applyNativeIcon();
            TAdItem taditem = getDefaultItemByIndex(i);
            if (taditem != null)
            {
                tadbutton.setDefaultItem(taditem);
                tadbutton.loadNetItem();
            }
            if (adJsonList.size() > i)
            {
                setJsonItemsToAdButton(tadbutton, (JSONObject)adJsonList.get(i));
                return;
            }
        }
    }

    public void removeAdButton(TAdButton tadbutton)
    {
        if (adButtonsList.contains(tadbutton))
        {
            tadbutton.clear();
            adButtonsList.remove(tadbutton);
        }
    }

    public void removeAllAdButton()
    {
        for (Iterator iterator = adButtonsList.iterator(); iterator.hasNext(); ((TAdButton)iterator.next()).clearItemList()) { }
        adButtonsList.clear();
        nativeIcons.clear();
    }

    public void request()
    {
        FotoAdStrategy.addListener(this);
        applyNativeIcon();
    }

    public void requestFbNative(final FotoNativeIcon nativeIcon, String s)
    {
        if (!ew.l(mContext))
        {
            return;
        } else
        {
            NativeAdWrapper.setNeedRefreshIconAd(false);
            Log.e("NativeIcon", (new StringBuilder()).append(TAG).append(" nativeIcon requesting...").toString());
            nativeIcon.isLoaded = false;
            nativeIcon.loadNativeAd(s, new ja() {

                final TAdButtonGroup this$0;
                final FotoNativeIcon val$nativeIcon;

                public void adDelayLoad(boolean flag)
                {
                    if (flag)
                    {
                        needRequestWhenActivitySet = true;
                    }
                }

                public void adIconClicked()
                {
                    Log.e(TAdButtonGroup.TAG, (new StringBuilder()).append(TAdButtonGroup.TAG).append(" nativeIcon clicked...").toString());
                }

                public void adIconFailed()
                {
                    Log.e(TAdButtonGroup.TAG, (new StringBuilder()).append(TAdButtonGroup.TAG).append(" nativeIcon failed...").toString());
                }

                public void adIconLoaded(FotoNativeIcon fotonativeicon)
                {
                    nativeIcon.isLoaded = true;
                    applyNativeIcon();
                    Log.e(TAdButtonGroup.TAG, (new StringBuilder()).append(TAdButtonGroup.TAG).append(" nativeIcon loaded...").toString());
                }

            
            {
                this$0 = TAdButtonGroup.this;
                nativeIcon = fotonativeicon;
                super();
            }
            });
            return;
        }
    }

    public void requestNativeAdForiegn()
    {
        int i = 0;
_L2:
        if (i >= nativeIcons.size())
        {
            break; /* Loop/switch isn't completed */
        }
        requestFbNative((FotoNativeIcon)nativeIcons.get(i), FotoAdMediationDB.getFBIconAdID(mContext));
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Crashlytics.logException(exception);
_L1:
    }

    public void resumeAllButtonShow()
    {
        for (Iterator iterator = adButtonsList.iterator(); iterator.hasNext(); ((TAdButton)iterator.next()).activeTimer()) { }
    }

    public void setAcitivity(Activity activity1)
    {
        activity = activity1;
        for (int i = 0; i < nativeIcons.size(); i++)
        {
            ((FotoNativeIcon)nativeIcons.get(i)).activity = activity;
        }

        if (adButtonsList.size() == 0)
        {
            for (int j = 0; j < adButtonCount; j++)
            {
                adButtonsList.add(new TAdButton(mContext));
            }

        }
        if (needRequestWhenActivitySet)
        {
            needRequestWhenActivitySet = false;
            requestNativeAdForiegn();
        }
    }

    public void setOnAdButtonClcikedLisener(OnAdButtonClickedLisener onadbuttonclickedlisener)
    {
        lisener = onadbuttonclickedlisener;
    }

    public void stopAllButtonShow()
    {
        for (Iterator iterator = adButtonsList.iterator(); iterator.hasNext(); ((TAdButton)iterator.next()).cancelTimer()) { }
    }


}
