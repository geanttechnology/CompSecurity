// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import ew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import jc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdItem, TadvertiseUtil, TAdASyncItemsJsonRequest

public class TAdButton extends FrameLayout
    implements TAdItem.TAdItemCallbackListener
{

    public static String TAG_Native = "-19999";
    private String ADS;
    private String ITEM_ADURL;
    private String ITEM_APPID;
    private String ITEM_CLEARWHENCLICKED;
    private String ITEM_ID;
    private String ITEM_IMAGEURL;
    private String ITEM_OPENIFEXIST;
    private String ITEM_TESTSCHEME;
    private String KDefaultADId;
    private String TAG;
    private ArrayList adItemlist;
    private AdTimerTask adTask;
    private Timer adTimer;
    private ArrayList clickedAppIds;
    private boolean closeNative;
    private TAdItem defaultItem;
    private FrameLayout fBNativeClickView;
    Handler handler = new Handler() {

        final TAdButton this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                btnNext();
                break;
            }
        }

            
            {
                this$0 = TAdButton.this;
                super();
            }
    };
    private boolean hiddenImage;
    private int index;
    boolean isADActive;
    private TAdButtonLisener lisener;
    private Context mActivity;
    private int mAdButtonIndex;
    private TAdASyncItemsJsonRequest mAdJsonReqeust;
    private TAdButtonCallbackListener mCallbackListener;
    private TAdItem mCurrentAd;
    private JSONArray mJsonNames;
    private JSONArray mJsonValues;
    private ImageSwitcher m_Switcher;
    private TAdItem nativeAdItem;
    private FotoNativeIcon nativeIcon;
    private List reportList;
    private int tl;

    public TAdButton(Context context)
    {
        super(context);
        lisener = null;
        mAdButtonIndex = 0;
        TAG = "TAdButton";
        KDefaultADId = "-1";
        index = 0;
        mCallbackListener = null;
        adItemlist = new ArrayList();
        clickedAppIds = new ArrayList();
        ADS = "ads";
        ITEM_ID = "id";
        ITEM_IMAGEURL = "imageUrl";
        ITEM_ADURL = "adUrl";
        ITEM_APPID = "appid";
        ITEM_TESTSCHEME = "testScheme";
        ITEM_OPENIFEXIST = "openIfExist";
        ITEM_CLEARWHENCLICKED = "clearWhenClicked";
        tl = 3000;
        nativeIcon = null;
        nativeAdItem = null;
        closeNative = false;
        hiddenImage = false;
        isADActive = true;
        mActivity = context;
        ContructView();
        getLastClickedAppIds();
    }

    public TAdButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        lisener = null;
        mAdButtonIndex = 0;
        TAG = "TAdButton";
        KDefaultADId = "-1";
        index = 0;
        mCallbackListener = null;
        adItemlist = new ArrayList();
        clickedAppIds = new ArrayList();
        ADS = "ads";
        ITEM_ID = "id";
        ITEM_IMAGEURL = "imageUrl";
        ITEM_ADURL = "adUrl";
        ITEM_APPID = "appid";
        ITEM_TESTSCHEME = "testScheme";
        ITEM_OPENIFEXIST = "openIfExist";
        ITEM_CLEARWHENCLICKED = "clearWhenClicked";
        tl = 3000;
        nativeIcon = null;
        nativeAdItem = null;
        closeNative = false;
        hiddenImage = false;
        isADActive = true;
        mActivity = context;
        ContructView();
        getLastClickedAppIds();
    }

    private void addDefaultAdItems()
    {
        if (defaultItem != null)
        {
            adItemlist.add(defaultItem);
        }
    }

    private void btnNext()
    {
        index = index + 1;
        if (index >= adItemlist.size())
        {
            index = 0;
        }
        if (adItemlist.size() > index)
        {
            TAdItem taditem = (TAdItem)adItemlist.get(index);
            String s;
            if (taditem != null && taditem.madId.equalsIgnoreCase(TAG_Native))
            {
                fBNativeClickView.setVisibility(0);
            } else
            {
                fBNativeClickView.setVisibility(4);
            }
            if (lisener != null)
            {
                lisener.onAdButtonDisplay(mAdButtonIndex, taditem);
            }
            if (taditem.bitmapDrawable != null)
            {
                m_Switcher.setImageDrawable(taditem.bitmapDrawable);
                mCurrentAd = taditem;
            } else
            if (taditem.mImageByteArray != null)
            {
                m_Switcher.setImageDrawable(taditem.byte2drawable());
                mCurrentAd = taditem;
            }
            if (hiddenImage)
            {
                mCurrentAd = taditem;
            }
            if (reportList == null)
            {
                reportList = new ArrayList();
            }
            if (ew.a())
            {
                s = "CN";
            } else
            {
                s = "EN";
            }
            if (isADActive && !reportList.contains(String.valueOf(taditem.madId)))
            {
                reportList.add(String.valueOf(taditem.madId));
                FotoCustomReport.addStringToArray(FotoCustomReport.adBtnId, taditem.madId);
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_show, (new StringBuilder()).append(taditem.madId).append(s).toString());
            }
        }
    }

    private void clearNativeAd()
    {
        if (closeNative)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = adItemlist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                TAdItem taditem = (TAdItem)iterator.next();
                if (!taditem.madId.equalsIgnoreCase(TAG_Native))
                {
                    arraylist.add(taditem);
                }
            } while (true);
            if (!arraylist.isEmpty())
            {
                adItemlist.clear();
                adItemlist.addAll(arraylist);
            }
        }
    }

    private TAdItem getCurrentItem()
    {
        if (index >= adItemlist.size())
        {
            index = 0;
        }
        if (!hiddenImage && adItemlist.size() > index)
        {
            TAdItem taditem = (TAdItem)adItemlist.get(index);
            if (taditem.mImageByteArray != null)
            {
                mCurrentAd = taditem;
            }
            if (hiddenImage)
            {
                mCurrentAd = taditem;
            }
        }
        return mCurrentAd;
    }

    private boolean isHaveClicked(String s)
    {
        int i = 0;
        boolean flag = false;
        for (; i < clickedAppIds.size(); i++)
        {
            if (((String)clickedAppIds.get(i)).equalsIgnoreCase(s))
            {
                flag = true;
            }
        }

        return flag;
    }

    private void removeDefaultAditems()
    {
        Iterator iterator = adItemlist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((TAdItem)iterator.next()).madId.equalsIgnoreCase(KDefaultADId))
            {
                iterator.remove();
            }
        } while (true);
    }

    private void setAdItemShow(TAdItem taditem)
    {
        if (taditem == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= adItemlist.size()) goto _L2; else goto _L3
_L3:
        TAdItem taditem1 = (TAdItem)adItemlist.get(i);
        if (!taditem1.madId.equalsIgnoreCase(taditem.madId)) goto _L5; else goto _L4
_L4:
        if (taditem.mImageByteArray != null)
        {
            m_Switcher.setImageDrawable(taditem.byte2drawable());
            taditem.couldRecord = true;
            mCurrentAd = taditem;
            index = i;
        }
        if (hiddenImage)
        {
            mCurrentAd = taditem;
            index = i;
        }
        if (lisener != null)
        {
            lisener.onAdButtonDisplay(mAdButtonIndex, taditem);
        }
        setNativeClickedVisiableByItem(taditem1);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void setNativeClickedVisiableByItem(TAdItem taditem)
    {
        if (taditem.madId.equalsIgnoreCase(TAG_Native))
        {
            fBNativeClickView.setVisibility(0);
            return;
        }
        try
        {
            fBNativeClickView.setVisibility(4);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TAdItem taditem)
        {
            Crashlytics.logException(taditem);
        }
        return;
    }

    public void ContructView()
    {
        View view = LayoutInflater.from(getContext()).inflate(com.fotoable.fotoadpackage.R.layout.adbutton_view, this);
        m_Switcher = (ImageSwitcher)view.findViewById(com.fotoable.fotoadpackage.R.id.imageswitcher);
        m_Switcher.setFactory(new ViewFactoryImpl());
        m_Switcher.setOnClickListener(new android.view.View.OnClickListener() {

            final TAdButton this$0;

            public void onClick(View view1)
            {
                TAdItem taditem = getCurrentItem();
                if (taditem != null)
                {
                    getCurrentItem().handleClick();
                    FotoCustomReport.addStringToArray(FotoCustomReport.clickedAdBtnId, taditem.madId);
                    if (ew.a())
                    {
                        view1 = "CN";
                    } else
                    {
                        view1 = "EN";
                    }
                    StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_icon_click, (new StringBuilder()).append(taditem.madId).append(view1).toString());
                }
            }

            
            {
                this$0 = TAdButton.this;
                super();
            }
        });
        m_Switcher.setPersistentDrawingCache(1);
        fBNativeClickView = (FrameLayout)view.findViewById(com.fotoable.fotoadpackage.R.id.fbnative_clickedview);
        fBNativeClickView.setBackgroundColor(0);
        fBNativeClickView.setVisibility(4);
        fBNativeClickView.setOnClickListener(new android.view.View.OnClickListener() {

            final TAdButton this$0;

            public void onClick(View view1)
            {
                if (nativeAdItem != null && nativeAdItem.madId.equalsIgnoreCase(TAdButton.TAG_Native) && nativeIcon != null && nativeIcon.nativeItem != null)
                {
                    nativeIcon.nativeItem.b(TAdButton.this);
                }
            }

            
            {
                this$0 = TAdButton.this;
                super();
            }
        });
    }

    public void activeTimer()
    {
        cancelTimer();
        isADActive = true;
        try
        {
            if (adItemlist == null || adItemlist != null && adItemlist.size() <= 1)
            {
                btnNext();
                return;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
        adTimer = new Timer();
        if (adTask != null)
        {
            adTask.cancel();
            adTask = null;
        }
        adTask = new AdTimerTask();
        adTimer.schedule(adTask, 3000L, tl);
        return;
    }

    public void addAdItem(TAdItem taditem)
    {
        if (!isHaveClicked(taditem.madId) || !taditem.clearWhenClicked)
        {
            adItemlist.add(taditem);
            if (taditem.closeNativeAD)
            {
                closeNative = taditem.closeNativeAD;
            }
            if (defaultItem != null && adItemlist.contains(defaultItem))
            {
                adItemlist.remove(defaultItem);
            }
        }
    }

    public void addfbNativeAd(FotoNativeIcon fotonativeicon)
    {
        if (fotonativeicon != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String s;
        TAdItem taditem;
        try
        {
            nativeIcon = fotonativeicon;
            nativeIcon.nativeItem.a(fBNativeClickView);
            if (nativeAdItem != null)
            {
                nativeAdItem = null;
            }
            obj = nativeIcon.nativeItem.a();
        }
        // Misplaced declaration of an exception variable
        catch (FotoNativeIcon fotonativeicon)
        {
            Crashlytics.logException(fotonativeicon);
            return;
        }
        fotonativeicon = ((FotoNativeIcon) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        fotonativeicon = ((FotoNativeIcon) (obj));
        if (((String) (obj)).length() >= 8)
        {
            fotonativeicon = (new StringBuilder()).append(((String) (obj)).substring(0, 7)).append("...").toString();
        }
        s = nativeIcon.nativeItem.b();
        nativeAdItem = new TAdItem(getContext(), null);
        taditem = nativeAdItem;
        if (fotonativeicon == null)
        {
            obj = "";
        } else
        {
            obj = fotonativeicon;
        }
        taditem.adNameCN = ((String) (obj));
        taditem = nativeAdItem;
        if (fotonativeicon == null)
        {
            obj = "";
        } else
        {
            obj = fotonativeicon;
        }
        taditem.adNameEN = ((String) (obj));
        taditem = nativeAdItem;
        obj = fotonativeicon;
        if (fotonativeicon == null)
        {
            obj = "";
        }
        taditem.adNameTW = ((String) (obj));
        nativeAdItem.madURL = null;
        nativeAdItem.madId = TAG_Native;
        nativeAdItem.mimageURL = s;
        nativeAdItem.openIfExist = true;
        nativeAdItem.clearWhenClicked = false;
        if (nativeAdItem == null || adItemlist == null || adItemlist.size() < 0) goto _L1; else goto _L3
_L3:
        obj = adItemlist.iterator();
_L5:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_365;
            }
            fotonativeicon = (TAdItem)((Iterator) (obj)).next();
        } while (fotonativeicon == null);
        if (!((TAdItem) (fotonativeicon)).madId.contains(TAG_Native)) goto _L5; else goto _L4
_L4:
        for (; fotonativeicon == null; fotonativeicon = null)
        {
            break MISSING_BLOCK_LABEL_303;
        }

        adItemlist.remove(fotonativeicon);
        adItemlist.add(nativeAdItem);
        if (defaultItem != null && adItemlist.contains(defaultItem))
        {
            adItemlist.remove(defaultItem);
            return;
        }
          goto _L1
    }

    public void cancelTimer()
    {
        isADActive = false;
        try
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
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    public void clear()
    {
        cancelTimer();
        adItemlist.clear();
        if (nativeAdItem != null)
        {
            adItemlist.add(nativeAdItem);
        }
    }

    public void clearItemList()
    {
        adItemlist.clear();
    }

    public void getLastClickedAppIds()
    {
        int i = 0;
        String s = mActivity.getSharedPreferences("config", 0).getString("clickAdappIds", "");
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lastUpdateString :").append(s).toString());
        if (s.length() > 0)
        {
            clickedAppIds.clear();
            String as1[] = new String[10];
            for (String as[] = s.split(","); i < as.length; i++)
            {
                clickedAppIds.add(as[i]);
            }

        }
    }

    public int getTl()
    {
        return tl;
    }

    public void loadNetItem()
    {
        clearNativeAd();
        Iterator iterator = adItemlist.iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            TAdItem taditem = (TAdItem)iterator.next();
            if (!isHaveClicked(taditem.madId) || !taditem.clearWhenClicked)
            {
                taditem.setItemCallbackListener(this);
                if (!hiddenImage)
                {
                    taditem.loadImage();
                }
                flag = true;
            }
        } while (true);
        if (flag || defaultItem == null || hiddenImage || defaultItem.getImageResId() <= 0)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        Object obj = mActivity.getResources().getDrawable(defaultItem.getImageResId());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = new SAutoBgButtonBackgroundDrawable(((Drawable) (obj)));
        m_Switcher.setImageDrawable(((Drawable) (obj)));
        mCurrentAd = defaultItem;
        if (lisener != null)
        {
            lisener.onAdButtonDisplay(mAdButtonIndex, defaultItem);
        }
_L2:
        activeTimer();
        return;
        Object obj1;
        obj1;
        Crashlytics.logException(((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onAdItemClicked(TAdItem taditem)
    {
_L2:
        return;
        if (taditem == null || taditem.madId.equalsIgnoreCase(KDefaultADId) || adItemlist.size() <= 0 || !taditem.clearWhenClicked) goto _L2; else goto _L1
_L1:
        TAdItem taditem1;
        for (int i = 0; i >= adItemlist.size(); i++)
        {
            continue; /* Loop/switch isn't completed */
        }

        taditem1 = (TAdItem)adItemlist.get(i);
        if (!taditem.madId.equalsIgnoreCase(taditem1.madId))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        setLastClickedAppIds(taditem.madId);
        adItemlist.remove(taditem1);
        if (adItemlist.size() == 0)
        {
            addDefaultAdItems();
            setAdItemShow((TAdItem)adItemlist.get(0));
            activeTimer();
            return;
        }
        try
        {
            if (i <= adItemlist.size() - 1)
            {
                setAdItemShow((TAdItem)adItemlist.get(i));
                activeTimer();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (TAdItem taditem)
        {
            return;
        }
        setAdItemShow((TAdItem)adItemlist.get(0));
        activeTimer();
        return;
        if (true) goto _L2; else goto _L3
_L3:
    }

    public void onError(Exception exception)
    {
    }

    public void onLoaded(TAdItem taditem)
    {
        removeDefaultAditems();
        if (taditem != null && adItemlist.size() > 0)
        {
            TAdItem taditem1 = (TAdItem)adItemlist.get(0);
            if (taditem.madId.equalsIgnoreCase(taditem1.madId))
            {
                setAdItemShow(taditem);
                activeTimer();
            }
        }
    }

    public void pareseJsonRespose(String s)
    {
        boolean flag = false;
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        s = new JSONObject(s);
        mJsonNames = s.names();
        TAdItem taditem;
        int i;
        Object obj;
        String s1;
        try
        {
            mJsonValues = s.toJSONArray(mJsonNames);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                TadvertiseUtil.logMessage(null, 3, "Error in json string");
                if (mCallbackListener != null)
                {
                    mCallbackListener.onError(s);
                }
                s.printStackTrace();
                Crashlytics.logException(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            Crashlytics.logException(s);
            return;
        }
        i = 0;
        if (i >= mJsonNames.length())
        {
            break; /* Loop/switch isn't completed */
        }
        TadvertiseUtil.logMessage(null, 3, (new StringBuilder()).append("Key => ").append(mJsonNames.getString(i)).append(" Value => ").append(mJsonValues.getString(i)).toString());
        i++;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_40;
_L3:
        s = TadvertiseUtil.getJSONArray(s, ADS);
        i = ((flag) ? 1 : 0);
_L10:
        if (i >= s.length())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = s.getJSONObject(i);
        taditem = new TAdItem(mActivity, mCallbackListener);
        taditem.setItemCallbackListener(this);
        taditem.madId = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_ID);
        taditem.madURL = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_ADURL);
        taditem.mimageURL = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_IMAGEURL);
        taditem.mdefaultSchemeURL = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_TESTSCHEME);
        taditem.mappId = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_APPID);
        s1 = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_OPENIFEXIST);
        if (!s1.equalsIgnoreCase("1") && !s1.equalsIgnoreCase("YES")) goto _L6; else goto _L5
_L5:
        taditem.openIfExist = true;
_L7:
        obj = TadvertiseUtil.getJSONValue(((JSONObject) (obj)), ITEM_CLEARWHENCLICKED);
        if (!((String) (obj)).equalsIgnoreCase("1") && !((String) (obj)).equalsIgnoreCase("YES"))
        {
            break MISSING_BLOCK_LABEL_394;
        }
        taditem.clearWhenClicked = true;
_L8:
        if (!ew.a(mActivity, taditem.mdefaultSchemeURL) && (!isHaveClicked(taditem.madId) || !taditem.clearWhenClicked))
        {
            adItemlist.add(taditem);
            taditem.loadImage();
        }
        break MISSING_BLOCK_LABEL_402;
_L6:
        taditem.openIfExist = false;
          goto _L7
        taditem.clearWhenClicked = false;
          goto _L8
        i++;
        if (true) goto _L10; else goto _L9
_L9:
        if (true) goto _L1; else goto _L11
_L11:
    }

    public void setAdButtonLisener(int i, TAdButtonLisener tadbuttonlisener)
    {
        mAdButtonIndex = i;
        lisener = tadbuttonlisener;
    }

    public void setDefaultItem(TAdItem taditem)
    {
        taditem.madId = KDefaultADId;
        defaultItem = taditem;
        defaultItem.setItemCallbackListener(this);
    }

    public void setHideImage(boolean flag)
    {
        hiddenImage = flag;
    }

    public void setLastClickedAppIds(String s)
    {
        String s2 = "";
        String s1 = s2;
        if (clickedAppIds != null)
        {
            int i;
            if (clickedAppIds.size() > 10)
            {
                clickedAppIds.remove(0);
                clickedAppIds.add(s);
            } else
            {
                clickedAppIds.add(s);
            }
            i = 0;
            s = s2;
            do
            {
                s1 = s;
                if (i >= clickedAppIds.size())
                {
                    break;
                }
                if (i + 1 < clickedAppIds.size())
                {
                    s = (new StringBuilder()).append(s).append((String)clickedAppIds.get(i)).append(",").toString();
                } else
                {
                    s = (new StringBuilder()).append(s).append((String)clickedAppIds.get(i)).toString();
                }
                i++;
            } while (true);
        }
        Log.v(TAG, (new StringBuilder()).append(TAG).append(" lastUpdateString :").append(s1).toString());
        s = mActivity.getSharedPreferences("config", 0).edit();
        s.putString("clickAdappIds", s1);
        s.apply();
    }

    public void setTl(int i)
    {
        tl = i;
    }







    private class TAdButtonLisener
    {

        public abstract void onAdButtonDisplay(int i, TAdItem taditem);
    }


    private class ViewFactoryImpl
        implements android.widget.ViewSwitcher.ViewFactory
    {

        final TAdButton this$0;

        public View makeView()
        {
            ImageView imageview = new ImageView(mActivity);
            imageview.setBackgroundColor(0);
            imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            imageview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            return imageview;
        }

        private ViewFactoryImpl()
        {
            this$0 = TAdButton.this;
            super();
        }

    }


    private class AdTimerTask extends TimerTask
    {

        final TAdButton this$0;

        public void run()
        {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }

        AdTimerTask()
        {
            this$0 = TAdButton.this;
            super();
        }
    }


    private class SAutoBgButtonBackgroundDrawable extends LayerDrawable
    {

        protected int _disabledAlpha;
        protected int _fullAlpha;
        protected ColorFilter _pressedFilter;
        final TAdButton this$0;

        public boolean isStateful()
        {
            return true;
        }

        protected boolean onStateChange(int ai[])
        {
            boolean flag1 = false;
            int j = ai.length;
            int i = 0;
            boolean flag = false;
            while (i < j) 
            {
                int k = ai[i];
                boolean flag2;
                if (k == 0x101009e)
                {
                    flag2 = true;
                } else
                {
                    flag2 = flag;
                    if (k == 0x10100a7)
                    {
                        flag1 = true;
                        flag2 = flag;
                    }
                }
                i++;
                flag = flag2;
            }
            mutate();
            if (flag && flag1)
            {
                setColorFilter(_pressedFilter);
            } else
            if (!flag)
            {
                setColorFilter(null);
                setAlpha(_disabledAlpha);
            } else
            {
                setColorFilter(null);
                setAlpha(_fullAlpha);
            }
            invalidateSelf();
            return super.onStateChange(ai);
        }

        public SAutoBgButtonBackgroundDrawable(Drawable drawable)
        {
            this$0 = TAdButton.this;
            super(new Drawable[] {
                drawable
            });
            _pressedFilter = new LightingColorFilter(0xffcccccc, 1);
            _disabledAlpha = 100;
            _fullAlpha = 255;
        }
    }


    private class TAdButtonCallbackListener
    {

        public abstract void onAdClicked(TAdItem taditem);

        public abstract void onError(Exception exception);
    }

}
