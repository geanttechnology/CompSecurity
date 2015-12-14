// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.homewall;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import apu;
import apv;
import aqd;
import aqe;
import aqf;
import aqg;
import aqh;
import aqi;
import aqj;
import aqk;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.ad.HomeWallFactory;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.tgifview.TGifView;
import ie;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yn;
import yp;

public class THomewallView extends FrameLayout
    implements com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener
{

    private String KHomeWallAdUrl;
    final String TAG;
    private apv adRequest;
    private List adSizes;
    private aqj adTask;
    private Timer adTimer;
    private ArrayList clickedadIds;
    private apu curHomeWall;
    private int curIndex;
    private View gifView;
    private List gifViewList;
    public Handler handler;
    public boolean hasLeft;
    public boolean hasStartedPlay;
    private List homePageWalls;
    private List homeViewList;
    private List homeWalls;
    private Context mActivity;
    private int mAdPosition;
    private WeakReference mListenerWeakRef;
    private int mTimeInterval;
    private List reportList;
    private aqd requestCache;
    private List savePageViewList;
    private List savePageWalls;

    public THomewallView(Context context)
    {
        super(context);
        TAG = "THomewallView";
        curIndex = -1;
        mAdPosition = 1;
        mTimeInterval = 3000;
        mListenerWeakRef = null;
        gifViewList = new ArrayList();
        homeViewList = new ArrayList();
        savePageViewList = new ArrayList();
        homeWalls = new ArrayList();
        homePageWalls = new ArrayList();
        savePageWalls = new ArrayList();
        clickedadIds = new ArrayList();
        KHomeWallAdUrl = "http://ad.fotoable.com/v2/adwall/?";
        hasLeft = false;
        hasStartedPlay = false;
        handler = new aqh(this);
        mActivity = context;
        reportList = new ArrayList();
        initMyHomeWall(context);
        getLastClickedAdIds();
        setVisibility(0);
    }

    public THomewallView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "THomewallView";
        curIndex = -1;
        mAdPosition = 1;
        mTimeInterval = 3000;
        mListenerWeakRef = null;
        gifViewList = new ArrayList();
        homeViewList = new ArrayList();
        savePageViewList = new ArrayList();
        homeWalls = new ArrayList();
        homePageWalls = new ArrayList();
        savePageWalls = new ArrayList();
        clickedadIds = new ArrayList();
        KHomeWallAdUrl = "http://ad.fotoable.com/v2/adwall/?";
        hasLeft = false;
        hasStartedPlay = false;
        handler = new aqh(this);
        mActivity = context;
        reportList = new ArrayList();
        initMyHomeWall(context);
        getLastClickedAdIds();
        setVisibility(0);
    }

    public THomewallView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        TAG = "THomewallView";
        curIndex = -1;
        mAdPosition = 1;
        mTimeInterval = 3000;
        mListenerWeakRef = null;
        gifViewList = new ArrayList();
        homeViewList = new ArrayList();
        savePageViewList = new ArrayList();
        homeWalls = new ArrayList();
        homePageWalls = new ArrayList();
        savePageWalls = new ArrayList();
        clickedadIds = new ArrayList();
        KHomeWallAdUrl = "http://ad.fotoable.com/v2/adwall/?";
        hasLeft = false;
        hasStartedPlay = false;
        handler = new aqh(this);
        mActivity = context;
        reportList = new ArrayList();
        initMyHomeWall(context);
        getLastClickedAdIds();
        setVisibility(0);
    }

    private void ItemClicked()
    {
        if (!curHomeWall.c)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_click, "nativeAd");
_L1:
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        if (curHomeWall != null && curHomeWall.h != null && !curHomeWall.h.equalsIgnoreCase(""))
        {
            if (curHomeWall.a && yp.a(mActivity, curHomeWall.h))
            {
                handOpenApp();
            } else
            if (!yp.a(mActivity, curHomeWall.h) && (curHomeWall.i == null || curHomeWall.i.equals("")))
            {
                ie.a(mActivity, curHomeWall.h);
            } else
            if (mListenerWeakRef != null && mListenerWeakRef.get() != null && curHomeWall != null && curHomeWall.i != null && !curHomeWall.i.equals(""))
            {
                if (curHomeWall.i.startsWith("market://"))
                {
                    ie.a(mActivity, curHomeWall.i);
                } else
                {
                    ((aqk)mListenerWeakRef.get()).GifViewClicked(curHomeWall.i);
                }
            }
        } else
        if (mListenerWeakRef != null && mListenerWeakRef.get() != null && curHomeWall != null && curHomeWall.i != null && !curHomeWall.i.equals(""))
        {
            ((aqk)mListenerWeakRef.get()).GifViewClicked(curHomeWall.i);
        }
        if (curHomeWall != null)
        {
            String s;
            if (yp.a())
            {
                s = "CN";
            } else
            {
                s = "EN";
            }
            if (mAdPosition == 2)
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_click, (new StringBuilder()).append(curHomeWall.f).append("_save_").append(s).toString());
            } else
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_click, (new StringBuilder()).append(curHomeWall.f).append("_home_").append(s).toString());
            }
        }
        if (curHomeWall != null)
        {
            setLastClickedAdIds(curHomeWall.f);
        }
        if (curHomeWall != null && curHomeWall.f != 0 && curHomeWall.b && homeWalls.size() > curIndex)
        {
            homeWalls.remove(curIndex);
            gifViewList.remove(curIndex);
            if (homeWalls.size() == 0)
            {
                curHomeWall = null;
            }
            if (homeWalls.size() == 1)
            {
                cancelTimer();
            }
            playAd();
            return;
        }
          goto _L1
    }

    private void changeWallList()
    {
        homeWalls.clear();
        gifViewList.clear();
        if (mAdPosition != 1) goto _L2; else goto _L1
_L1:
        homeWalls.addAll(homePageWalls);
        gifViewList.addAll(homeViewList);
_L4:
        clearNativeIfClosed();
        return;
_L2:
        if (mAdPosition == 2)
        {
            homeWalls.addAll(savePageWalls);
            gifViewList.addAll(savePageViewList);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void clearNativeIfClosed()
    {
        Iterator iterator = homeWalls.iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            apu apu1 = (apu)iterator.next();
            if (!apu1.c && apu1.k)
            {
                flag = true;
            }
        } while (true);
        if (flag)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator1 = homeWalls.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                apu apu2 = (apu)iterator1.next();
                if (!apu2.c)
                {
                    arraylist.add(apu2);
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                homeWalls.clear();
                homeWalls.addAll(arraylist);
            }
            arraylist = new ArrayList();
            iterator1 = gifViewList.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                View view = (View)iterator1.next();
                if (view instanceof TGifView)
                {
                    arraylist.add(view);
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                gifViewList.clear();
                gifViewList.addAll(arraylist);
            }
        }
    }

    private void clearNativeItemFromList(List list, List list1)
    {
        if (list != null && list.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator1 = list.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                apu apu1 = (apu)iterator1.next();
                if (apu1.c)
                {
                    arraylist.add(apu1);
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                list.removeAll(arraylist);
                arraylist.clear();
            }
        }
        if (list1 != null && list1.size() > 0)
        {
            list = new ArrayList();
            Iterator iterator = list1.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                View view = (View)iterator.next();
                if (!(view instanceof TGifView))
                {
                    list.add(view);
                }
            } while (true);
            if (!list.isEmpty())
            {
                list1.removeAll(list);
                list.clear();
            }
        }
    }

    private int dip2px(Context context, float f)
    {
        return (int)(context.getResources().getDisplayMetrics().density * f + 0.5F);
    }

    private String getHomeActivityName()
    {
        String s = mActivity.getPackageName();
        if (s.equalsIgnoreCase("com.wantu.activity"))
        {
            return "com.wantu.activity.WantuActivity";
        }
        if (s.equalsIgnoreCase("com.instamag.activity"))
        {
            return "com.instamag.activity.InstaMagActivity";
        }
        if (s.equalsIgnoreCase("com.pipcamera.activity"))
        {
            return "com.pipcamera.activity.PIPCameraActivity";
        }
        if (s.equalsIgnoreCase("com.hicollage.activity"))
        {
            return "com.hicollage.activity.MainActivity";
        }
        if (s.equalsIgnoreCase("com.fotoable.fotobeauty"))
        {
            return "com.fotoable.fotobeauty.WantuActivity";
        }
        break MISSING_BLOCK_LABEL_83;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return "";
    }

    private void handOpenApp()
    {
        while (curHomeWall.h == null || !yp.a(mActivity, curHomeWall.h)) 
        {
            return;
        }
        try
        {
            Intent intent = mActivity.getPackageManager().getLaunchIntentForPackage(curHomeWall.h);
            intent.addFlags(0x10000000);
            mActivity.startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    private void initMyHomeWall(Context context)
    {
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
        setBackgroundColor(0);
        requestCache = new aqd(context, "homewallcache");
        setOnClickListener(new aqg(this));
    }

    private boolean isHaveClicked(int i)
    {
        int j = 0;
        boolean flag = false;
        for (; j < clickedadIds.size(); j++)
        {
            if (((String)clickedadIds.get(j)).equalsIgnoreCase(String.valueOf(i)))
            {
                flag = true;
            }
        }

        return flag;
    }

    private void loadGifViewByAds(List list)
    {
_L2:
        return;
        if (list == null || list.size() <= 0) goto _L2; else goto _L1
_L1:
        try
        {
            if (homeViewList != null)
            {
                Iterator iterator = homeViewList.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    View view = (View)iterator.next();
                    if (view instanceof TGifView)
                    {
                        homeViewList.remove(view);
                    }
                } while (true);
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Crashlytics.logException(list);
            return;
        }
        if (savePageViewList != null)
        {
            for (Iterator iterator1 = savePageViewList.iterator(); iterator1.hasNext();)
            {
                View view1 = (View)iterator1.next();
                if (view1 instanceof TGifView)
                {
                    savePageViewList.remove(view1);
                }
            }

        }
        break MISSING_BLOCK_LABEL_397;
_L3:
        float f;
        float f1;
        apu apu1;
        TGifView tgifview;
        String s;
        int i;
        for (; i >= list.size(); i++)
        {
            continue; /* Loop/switch isn't completed */
        }

        apu1 = (apu)list.get(i);
        if (apu1.c)
        {
            break MISSING_BLOCK_LABEL_403;
        }
        f = mActivity.getResources().getDisplayMetrics().widthPixels;
        f1 = f - (2.0F * f * (320F - (float)apu1.d.a)) / 320F;
        f = f1;
        if (f1 <= (float)apu1.d.a)
        {
            f = dip2px(mActivity, apu1.d.a);
        }
        f1 = ((float)apu1.d.b * f) / (float)apu1.d.a;
        tgifview = new TGifView(mActivity);
        tgifview.setShowDimension((int)f, (int)f1);
        s = yn.a(apu1.j);
        tgifview.loadImage(apu1.j, s, new aqi(this, apu1));
        if (gifViewList == null)
        {
            gifViewList = new ArrayList();
        }
        if (apu1.g == 1)
        {
            homeViewList.add(tgifview);
            break MISSING_BLOCK_LABEL_403;
        }
        if (apu1.g == 2)
        {
            savePageViewList.add(tgifview);
        }
        break MISSING_BLOCK_LABEL_403;
        i = 0;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private void playAd()
    {
        if (gifViewList.size() == 0)
        {
            removeAllViews();
            if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
            {
                if (mAdPosition == 1)
                {
                    HomeWallFactory.IsHomawallLoaded = false;
                }
                if (mAdPosition == 2)
                {
                    HomeWallFactory.IsSavewallLoaded = false;
                }
                ((aqk)mListenerWeakRef.get()).GifViewfailed();
                setVisibility(4);
                if (homeWalls == null || homeWalls.size() <= 1)
                {
                    cancelTimer();
                    return;
                }
            }
            break MISSING_BLOCK_LABEL_512;
        }
        try
        {
            setVisibility(0);
            curIndex = curIndex + 1;
            if (curIndex >= gifViewList.size())
            {
                curIndex = 0;
            }
            if (gifViewList.size() > curIndex && gifViewList.size() == homeWalls.size())
            {
                curHomeWall = (apu)homeWalls.get(curIndex);
                if (curHomeWall != null && (curHomeWall.g == mAdPosition || curHomeWall.c))
                {
                    if (gifView != null)
                    {
                        if (gifView.getParent() != null)
                        {
                            ((ViewGroup)gifView.getParent()).removeView(gifView);
                        }
                        gifView = null;
                    }
                    if (gifViewList != null)
                    {
                        float f = mActivity.getResources().getDisplayMetrics().widthPixels;
                        f -= (2.0F * f * (320F - (float)curHomeWall.d.a)) / 320F;
                        if (f <= (float)curHomeWall.d.a)
                        {
                            f = dip2px(mActivity, curHomeWall.d.a);
                        }
                        float f1 = ((float)curHomeWall.d.b * f) / (float)curHomeWall.d.a;
                        gifView = (View)gifViewList.get(curIndex);
                        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)getLayoutParams();
                        layoutparams.width = (int)f;
                        layoutparams.height = (int)f1;
                        requestLayout();
                        if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
                        {
                            ((aqk)mListenerWeakRef.get()).GifViewDisplayed(curHomeWall.d);
                            ((aqk)mListenerWeakRef.get()).GifViewSizeChanged(curHomeWall.d);
                        }
                        addView(gifView);
                        hasStartedPlay = true;
                        recordWallDisplay();
                        return;
                    }
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    private void recordWallDisplay()
    {
        if (curHomeWall.l && !reportList.contains(String.valueOf(curHomeWall.f)))
        {
            String s;
            if (yp.a())
            {
                s = "CN";
            } else
            {
                s = "EN";
            }
            if (mAdPosition == 2)
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_show, (new StringBuilder()).append(curHomeWall.f).append("_save_").append(s).toString());
            } else
            {
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_show, (new StringBuilder()).append(curHomeWall.f).append("_home_").append(s).toString());
            }
            curHomeWall.m = true;
            reportList.add(String.valueOf(curHomeWall.f));
        }
    }

    private aqf wallGroupfromJson(JSONObject jsonobject)
    {
        aqf aqf1 = new aqf();
        if (!jsonobject.isNull("ti"))
        {
            aqf1.b(jsonobject.getInt("ti"));
        }
        if (!jsonobject.isNull("position"))
        {
            aqf1.a(jsonobject.getInt("position"));
        }
        if (aqf1.c == null)
        {
            aqf1.c = new ArrayList();
        }
        if (jsonobject.isNull("ads"))
        {
            break MISSING_BLOCK_LABEL_163;
        }
        jsonobject = jsonobject.getJSONArray("ads");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (jsonobject.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        int i = 0;
_L1:
        apu apu1;
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        apu1 = apu.a(jsonobject.getJSONObject(i));
        if (apu1 == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (isSizeContent(apu1.a()))
        {
            aqf1.c.add(apu1);
        }
        i++;
          goto _L1
        jsonobject;
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        return aqf1;
    }

    public void activeTimer()
    {
        if (homeWalls == null || homeWalls.size() <= 1)
        {
            return;
        }
        if (adTimer == null)
        {
            adTimer = new Timer();
        }
        if (adTask != null)
        {
            adTask.cancel();
            adTask = null;
        }
        adTask = new aqj(this);
        adTimer.schedule(adTask, 1000L, mTimeInterval);
    }

    public void addNativeAdView(View view)
    {
        if (view == null)
        {
            return;
        }
        try
        {
            apu apu1 = new apu();
            apu1.f = 9999;
            apu1.g = 1;
            apu1.c(true);
            apu1.a(new aqe(300, 207));
            if (homeWalls == null)
            {
                homeWalls = new ArrayList();
            }
            if (homePageWalls == null)
            {
                homeWalls = new ArrayList();
            }
            if (gifViewList == null)
            {
                gifViewList = new ArrayList();
            }
            if (homeViewList == null)
            {
                homeViewList = new ArrayList();
            }
            if (savePageWalls == null)
            {
                savePageWalls = new ArrayList();
            }
            if (homeViewList == null)
            {
                homeViewList = new ArrayList();
            }
            homeWalls.add(0, apu1);
            gifViewList.add(0, view);
            homePageWalls.add(0, apu1);
            homeViewList.add(0, view);
            savePageWalls.add(0, apu1);
            savePageViewList.add(0, view);
            start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
        }
    }

    public void addSize(aqe aqe1)
    {
        if (adSizes == null)
        {
            adSizes = new ArrayList();
        }
        adSizes.add(aqe1);
    }

    public void cancelTimer()
    {
        if (adTimer != null)
        {
            if (adTask != null)
            {
                adTask.cancel();
                adTask = null;
            }
            adTimer.cancel();
            adTimer.purge();
            adTimer = null;
        }
    }

    public void clearNativeAD()
    {
        clearNativeItemFromList(homeWalls, gifViewList);
        clearNativeItemFromList(homePageWalls, homeViewList);
        clearNativeItemFromList(savePageWalls, savePageViewList);
    }

    public void decoderValueFromString(String s)
    {
        s = new JSONObject(s);
        if (!String.valueOf(s.getString("status")).equalsIgnoreCase("1")) goto _L2; else goto _L1
_L1:
        s = s.getJSONArray("data");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (s.length() > 0)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
        {
            ((aqk)mListenerWeakRef.get()).GifViewfailed();
        }
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataEmpty_json");
        return;
        if (homePageWalls == null) goto _L4; else goto _L3
_L3:
        int i = homePageWalls.size();
_L20:
        if (i <= 0) goto _L4; else goto _L5
_L5:
        if (!((apu)homePageWalls.get(i - 1)).c)
        {
            homePageWalls.remove(i - 1);
        }
          goto _L6
_L4:
        if (savePageWalls == null) goto _L8; else goto _L7
_L7:
        i = savePageWalls.size();
_L21:
        if (i <= 0) goto _L8; else goto _L9
_L22:
        if (i >= s.length()) goto _L11; else goto _L10
_L10:
        aqf aqf1;
        aqf1 = wallGroupfromJson(s.getJSONObject(i));
        setTimerInterval(aqf1.b);
        iterator = aqf1.c.iterator();
_L15:
        if (!iterator.hasNext()) goto _L13; else goto _L12
_L12:
        apu apu1 = (apu)iterator.next();
        if (yp.a(mActivity, apu1.h) && !apu1.a || isHaveClicked(apu1.f) && apu1.b) goto _L15; else goto _L14
_L14:
        if (apu1.g != 1) goto _L17; else goto _L16
_L16:
        homePageWalls.add(apu1);
          goto _L15
_L9:
        Iterator iterator;
        try
        {
            if (!((apu)savePageWalls.get(i - 1)).c)
            {
                savePageWalls.remove(i - 1);
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataAnalyzeFailed");
        if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
        {
            ((aqk)mListenerWeakRef.get()).GifViewfailed();
        }
_L19:
        s = new ArrayList();
        s.addAll(homePageWalls);
        s.addAll(savePageWalls);
        loadGifViewByAds(s);
        return;
_L17:
        if (apu1.g != 2) goto _L15; else goto _L18
_L18:
        savePageWalls.add(apu1);
          goto _L15
_L13:
        if (aqf1.a == 1 && (aqf1.c == null || aqf1.c.size() <= 0))
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataEmpty_json");
        }
        if (aqf1.a == 1 && aqf1.c != null && aqf1.c.size() > 0 && (homePageWalls == null || homePageWalls.size() <= 0))
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataEmpty_filter");
        }
        break MISSING_BLOCK_LABEL_590;
_L11:
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataAnalyzeSuccess");
          goto _L19
_L2:
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_data, "dataStateFailed");
          goto _L19
_L6:
        i--;
          goto _L20
        i--;
          goto _L21
_L8:
        i = 0;
          goto _L22
        i++;
          goto _L22
    }

    public boolean getHasLeft()
    {
        return hasLeft;
    }

    public void getLastClickedAdIds()
    {
        int i = 0;
        String s = mActivity.getSharedPreferences("config", 0).getString("clickAdadIds", "");
        Log.v("THomewallView", (new StringBuilder()).append("THomewallView lastUpdateString :").append(s).toString());
        if (s.length() > 0)
        {
            clickedadIds.clear();
            String as1[] = new String[10];
            for (String as[] = s.split(","); i < as.length; i++)
            {
                clickedadIds.add(as[i]);
            }

        }
    }

    public boolean isCurrentActivity()
    {
        ComponentName componentname;
        boolean flag;
        try
        {
            componentname = ((android.app.ActivityManager.RunningTaskInfo)((ActivityManager)mActivity.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return true;
        }
        if (componentname == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        flag = componentname.getClassName().equalsIgnoreCase(getHomeActivityName());
        if (flag)
        {
            return true;
        }
        return false;
    }

    public boolean isSizeContent(aqe aqe1)
    {
        for (Iterator iterator = adSizes.iterator(); iterator.hasNext();)
        {
            aqe aqe2 = (aqe)iterator.next();
            if (aqe2.a == aqe1.a && aqe2.b == aqe1.b)
            {
                return true;
            }
        }

        return false;
    }

    public void onAdInReterund(boolean flag)
    {
        if (flag)
        {
            try
            {
                decoderValueFromString(FotoAdStrategy.getMadWallInfo());
                start();
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            break MISSING_BLOCK_LABEL_54;
        }
        if (mListenerWeakRef != null && mListenerWeakRef.get() != null)
        {
            ((aqk)mListenerWeakRef.get()).GifViewfailed();
            return;
        }
    }

    public void onlineRequest(String s)
    {
        FotoAdStrategy.addListener(this);
    }

    public void resetlayout(android.widget.FrameLayout.LayoutParams layoutparams)
    {
        ((android.widget.FrameLayout.LayoutParams)getLayoutParams()).gravity = layoutparams.gravity;
        requestLayout();
    }

    public void setAdPosition(int i)
    {
        mAdPosition = i;
    }

    public void setGifViewListener(aqk aqk1)
    {
        mListenerWeakRef = new WeakReference(aqk1);
    }

    public void setHasLeft(boolean flag)
    {
        hasLeft = flag;
    }

    public void setLastClickedAdIds(int i)
    {
        String s1 = String.valueOf(i);
        Object obj = "";
        String s = ((String) (obj));
        if (clickedadIds != null)
        {
            if (clickedadIds.size() > 10)
            {
                clickedadIds.remove(0);
                clickedadIds.add(s1);
            } else
            {
                clickedadIds.add(s1);
            }
            i = 0;
            do
            {
                s = ((String) (obj));
                if (i >= clickedadIds.size())
                {
                    break;
                }
                if (i + 1 < clickedadIds.size())
                {
                    obj = (new StringBuilder()).append(((String) (obj))).append((String)clickedadIds.get(i)).append(",").toString();
                } else
                {
                    obj = (new StringBuilder()).append(((String) (obj))).append((String)clickedadIds.get(i)).toString();
                }
                i++;
            } while (true);
        }
        Log.v("THomewallView", (new StringBuilder()).append("THomewallView lastUpdateString :").append(s).toString());
        obj = mActivity.getSharedPreferences("config", 0).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("clickAdadIds", s);
        ((android.content.SharedPreferences.Editor) (obj)).apply();
    }

    public void setTimerInterval(int i)
    {
        mTimeInterval = i * 1000;
    }

    public void start()
    {
        changeWallList();
        if (homeWalls.size() == 1 || homeWalls.size() == 0)
        {
            cancelTimer();
            playAd();
            return;
        }
        try
        {
            activeTimer();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
    }



}
