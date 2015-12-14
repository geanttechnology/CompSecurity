// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.ad.StaticFlurryEvent;
import ie;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import yo;
import yp;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncImageRequest, TAdButtonImageCache, TAdButton, TadvertiseUtil, 
//            TAdButtonGroup

public class TAdItem
{

    String adNameCN;
    String adNameEN;
    String adNameTW;
    private TAdButtonImageCache adimageCache;
    public BitmapDrawable bitmapDrawable;
    protected boolean clearWhenClicked;
    protected boolean closeNativeAD;
    protected boolean couldRecord;
    private long endTime;
    private int imageResId;
    private String mAdbuttonCacheDir;
    private Context mContext;
    private TAdASyncImageRequest mDownload;
    protected byte mImageByteArray[];
    protected String madId;
    protected String madURL;
    protected String mappId;
    protected String mdefaultSchemeURL;
    protected String mimageURL;
    private TAdItemCallbackListener mitemCallbackListener;
    protected boolean openIfExist;
    private long startTime;

    public TAdItem(Context context, TAdButton.TAdButtonCallbackListener tadbuttoncallbacklistener)
    {
        imageResId = 0;
        clearWhenClicked = true;
        couldRecord = false;
        mImageByteArray = null;
        mDownload = new TAdASyncImageRequest();
        adimageCache = null;
        mAdbuttonCacheDir = "adImages";
        closeNativeAD = false;
        startTime = 0L;
        endTime = 0L;
        mContext = context;
        adimageCache = new TAdButtonImageCache(context, mAdbuttonCacheDir);
    }

    public static TAdItem fromJson(Context context, JSONObject jsonobject)
    {
        context = new TAdItem(context, null);
        String s;
        context.madId = jsonobject.getString("id");
        if (!jsonobject.isNull("imageUrl"))
        {
            context.mimageURL = jsonobject.getString("imageUrl");
        }
        if (!jsonobject.isNull("adUrl"))
        {
            context.madURL = jsonobject.getString("adUrl");
        }
        if (!jsonobject.isNull("appid"))
        {
            s = jsonobject.getString("appid");
            if (!s.equalsIgnoreCase("0"))
            {
                break MISSING_BLOCK_LABEL_229;
            }
            context.mappId = null;
        }
_L1:
        if (!jsonobject.isNull("schemurl"))
        {
            context.mdefaultSchemeURL = jsonobject.getString("schemurl");
        }
        if (!jsonobject.isNull("openIfExist"))
        {
            context.openIfExist = Boolean.valueOf(jsonobject.getBoolean("openIfExist")).booleanValue();
        }
        if (!jsonobject.isNull("clearWhenClicked"))
        {
            context.clearWhenClicked = jsonobject.getBoolean("clearWhenClicked");
        }
        if (!jsonobject.isNull("nameCN"))
        {
            context.adNameCN = jsonobject.getString("nameCN");
        }
        if (!jsonobject.isNull("nameEN"))
        {
            context.adNameEN = jsonobject.getString("nameEN");
        }
        if (!jsonobject.isNull("nameTW"))
        {
            context.adNameTW = jsonobject.getString("nameTW");
        }
        if (jsonobject.isNull("closeNativeAD"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        context.closeNativeAD = jsonobject.getBoolean("closeNativeAD");
        return context;
        context.mappId = s;
          goto _L1
        jsonobject;
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
        return context;
    }

    private String getNativeAdImageKey()
    {
        String s;
        String s1;
        s1 = TAdButton.TAG_Native;
        s = s1;
        if (mimageURL != null)
        {
            s = s1;
            try
            {
                if (!mimageURL.isEmpty())
                {
                    s = mimageURL.substring(mimageURL.lastIndexOf("/") + 1);
                    s = String.format("%s_%s", new Object[] {
                        TAdButton.TAG_Native, s
                    });
                }
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
                return s1;
            }
        }
        return s;
    }

    private int getOSVersionSDK()
    {
        int i;
        try
        {
            i = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i;
    }

    private void handOpenApp()
    {
        if (mdefaultSchemeURL != null)
        {
            ArrayList arraylist = TadvertiseUtil.getPackages(mContext);
            int i = 0;
            while (i < arraylist.size()) 
            {
                if (((TadvertiseUtil.PInfo)arraylist.get(i)).getpname().equalsIgnoreCase(mdefaultSchemeURL))
                {
                    Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mdefaultSchemeURL);
                    intent.addFlags(0x10000000);
                    mContext.startActivity(intent);
                    return;
                }
                i++;
            }
        }
    }

    private void handOpenApp1()
    {
        if (mContext != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mdefaultSchemeURL == null) goto _L1; else goto _L3
_L3:
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mdefaultSchemeURL);
        intent.addFlags(0x10000000);
        mContext.startActivity(intent);
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    private void handOpenUrl()
    {
        if (mContext != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.e("AdItem Clicked", (new StringBuilder()).append("item appid:").append(mappId).append(" url:").append(madURL).toString());
        if (madURL == null || madURL.equals(""))
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (madURL != null && madURL.startsWith("market://"))
            {
                ie.a(mContext, madURL);
                return;
            }
        }
        catch (Exception exception)
        {
            if (mitemCallbackListener != null)
            {
                mitemCallbackListener.onError(exception);
            }
            exception.printStackTrace();
            return;
        }
        if (TAdButtonGroup._instance.getClickedLisener() != null)
        {
            TAdButtonGroup._instance.getClickedLisener().onAdButtonClicked(madURL);
        }
        if (mitemCallbackListener == null) goto _L1; else goto _L3
_L3:
        mitemCallbackListener.onAdItemClicked(this);
        return;
        if (mdefaultSchemeURL == null || mdefaultSchemeURL.length() <= 0) goto _L1; else goto _L4
_L4:
        ie.a(mContext, mdefaultSchemeURL);
        return;
    }

    private void postAdButtonIconRequestTime(boolean flag)
    {
        float f = 10F;
        float f1;
        endTime = (new Date()).getTime();
        f1 = (float)(endTime - startTime) / 1000F;
        if (f1 < 10F) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        f = (int)Math.ceil(f);
        hashmap = new HashMap();
        if (flag) goto _L4; else goto _L3
_L3:
        hashmap.put("AdButtonImageDownloadSuccess", (new StringBuilder()).append(String.valueOf(f)).append(" s").toString());
        if (yp.a())
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageLoadTimeCN, (new StringBuilder()).append(String.valueOf(f)).append(" s").toString());
            return;
        }
        try
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageLoadTimeEN, (new StringBuilder()).append(String.valueOf(f)).append(" s").toString());
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        return;
_L6:
        f = f1;
        continue; /* Loop/switch isn't completed */
_L4:
        return;
_L2:
        if (f1 > 0.0F) goto _L6; else goto _L5
_L5:
        f = 0.0F;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public Drawable byte2drawable()
    {
        Object obj1 = null;
        BitmapDrawable bitmapdrawable;
        if (bitmapDrawable != null)
        {
            bitmapdrawable = bitmapDrawable;
        } else
        {
            bitmapdrawable = obj1;
            if (mImageByteArray != null)
            {
                bitmapdrawable = obj1;
                if (mImageByteArray.length != 0)
                {
                    Object obj;
                    try
                    {
                        obj = yo.a(mImageByteArray, mImageByteArray, true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        Crashlytics.logException(((Throwable) (obj)));
                        obj = null;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        Crashlytics.logException(((Throwable) (obj)));
                        obj = null;
                    }
                    bitmapdrawable = obj1;
                    if (obj != null)
                    {
                        if (madId.equalsIgnoreCase(TAdButton.TAG_Native))
                        {
                            obj = new BitmapDrawable(mContext.getResources(), yo.a(((android.graphics.Bitmap) (obj))));
                        } else
                        {
                            obj = new BitmapDrawable(mContext.getResources(), yo.a(((android.graphics.Bitmap) (obj)), 5F));
                        }
                        bitmapDrawable = ((BitmapDrawable) (obj));
                        return ((Drawable) (obj));
                    }
                }
            }
        }
        return bitmapdrawable;
    }

    protected void byte2drawable(final OnByte2DrawableHandle handleWeakReference)
    {
        handleWeakReference = new WeakReference(handleWeakReference);
        if (bitmapDrawable != null && handleWeakReference.get() != null)
        {
            ((OnByte2DrawableHandle)handleWeakReference.get()).onDrawableLoaded(bitmapDrawable);
        }
        (new Thread(new _cls2())).start();
    }

    public String getDisplayName()
    {
        if (yp.b())
        {
            return adNameCN;
        }
        if (yp.c())
        {
            return adNameTW;
        } else
        {
            return adNameEN;
        }
    }

    public String getExtension(String s)
    {
        String s2 = "jpg";
        String s1 = s2;
        if (s != null)
        {
            s1 = s2;
            if (s.length() > 0)
            {
                int i = s.lastIndexOf('.');
                s1 = s2;
                if (i > -1)
                {
                    s1 = s2;
                    if (i < s.length() - 1)
                    {
                        s1 = s.substring(i + 1);
                    }
                }
            }
        }
        return s1;
    }

    public int getImageResId()
    {
        return imageResId;
    }

    public String getNameCN()
    {
        return adNameCN;
    }

    public String getNameEN()
    {
        return adNameEN;
    }

    public String getNameTW()
    {
        return adNameTW;
    }

    public String getadId()
    {
        return madId;
    }

    public String getadURL()
    {
        return madURL;
    }

    public String getappId()
    {
        return mappId;
    }

    public String getdefaultSchemeURL()
    {
        return mdefaultSchemeURL;
    }

    public String getimageURL()
    {
        return mimageURL;
    }

    protected void handleClick()
    {
        if (openIfExist && yp.a(mContext, mdefaultSchemeURL))
        {
            handOpenApp1();
            return;
        } else
        {
            handOpenUrl();
            return;
        }
    }

    protected void loadImage()
    {
        if (imageResId == 0);
        if (mimageURL != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        startTime = (new Date()).getTime();
        if (adimageCache == null)
        {
            break; /* Loop/switch isn't completed */
        }
        String s = getExtension(mimageURL);
        s = (new StringBuilder()).append(madId).append(".").append(s).toString();
        if (madId.equalsIgnoreCase(TAdButton.TAG_Native))
        {
            s = getNativeAdImageKey();
        }
        if (!adimageCache.isExistTAdImage(s).booleanValue())
        {
            break; /* Loop/switch isn't completed */
        }
        mImageByteArray = adimageCache.get(s);
        if (mImageByteArray == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mitemCallbackListener != null)
        {
            mitemCallbackListener.onLoaded(this);
            postAdButtonIconRequestTime(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "startDownload");
        startTime = (new Date()).getTime();
        mDownload.download(mimageURL, new _cls1());
        return;
    }

    public void setImageResId(int i)
    {
        imageResId = i;
    }

    public void setItemCallbackListener(TAdItemCallbackListener taditemcallbacklistener)
    {
        mitemCallbackListener = taditemcallbacklistener;
    }

    public void setadIdd(String s)
    {
        madId = s;
    }

    public void setadUR(String s)
    {
        madURL = s;
    }

    public void setappId(String s)
    {
        mappId = s;
    }

    public void setdefaultSchemeURL(String s)
    {
        mdefaultSchemeURL = s;
    }

    public void setimageURL(String s)
    {
        mimageURL = s;
    }






    private class TAdItemCallbackListener
    {

        public abstract void onAdItemClicked(TAdItem taditem);

        public abstract void onError(Exception exception);

        public abstract void onLoaded(TAdItem taditem);
    }


    private class OnByte2DrawableHandle
    {

        public abstract void onDrawableLoaded(Drawable drawable);
    }


    private class _cls2
        implements Runnable
    {

        final TAdItem this$0;
        final WeakReference val$handleWeakReference;

        public void run()
        {
            if (mImageByteArray == null) goto _L2; else goto _L1
_L1:
            if (mImageByteArray.length == 0) goto _L4; else goto _L3
_L3:
            Object obj = null;
            android.graphics.Bitmap bitmap = yo.a(mImageByteArray, mImageByteArray, true);
            obj = bitmap;
_L5:
            if (obj != null)
            {
                class _cls1
                    implements Runnable
                {

                    final _cls2 this$1;

                    public void run()
                    {
                        if (handleWeakReference.get() != null)
                        {
                            ((OnByte2DrawableHandle)handleWeakReference.get()).onDrawableLoaded(bitmapDrawable);
                        }
                    }

                _cls1()
                {
                    this$1 = _cls2.this;
                    super();
                }
                }

                Object obj1;
                if (madId.equalsIgnoreCase(TAdButton.TAG_Native))
                {
                    obj = new BitmapDrawable(mContext.getResources(), yo.a(((android.graphics.Bitmap) (obj))));
                } else
                {
                    obj = new BitmapDrawable(mContext.getResources(), yo.a(((android.graphics.Bitmap) (obj)), 5F));
                }
                bitmapDrawable = ((BitmapDrawable) (obj));
            }
_L4:
            (new Handler(mContext.getMainLooper())).post(new _cls1());
_L2:
            return;
            obj1;
            Crashlytics.logException(((Throwable) (obj1)));
              goto _L5
            obj1;
            Crashlytics.logException(((Throwable) (obj1)));
              goto _L5
        }

        _cls2()
        {
            this$0 = TAdItem.this;
            handleWeakReference = weakreference;
            super();
        }
    }


    private class _cls1
        implements TAdASyncImageRequest.DownloadCallback
    {

        final TAdItem this$0;

        public void downLoaded(String s, byte abyte0[])
        {
            Log.v("TAdItem ImagedownLoaded", "ImagedownLoaded");
            mImageByteArray = abyte0;
            s = getExtension(mimageURL);
            s = (new StringBuilder()).append(madId).append(".").append(s).toString();
            if (madId.equalsIgnoreCase(TAdButton.TAG_Native))
            {
                s = getNativeAdImageKey();
            }
            adimageCache.put(s, abyte0);
            if (mitemCallbackListener != null)
            {
                mitemCallbackListener.onLoaded(TAdItem.this);
                postAdButtonIconRequestTime(false);
            }
        }

        public void downLoadedError(Exception exception)
        {
            if (mitemCallbackListener != null)
            {
                mitemCallbackListener.onError(exception);
                StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_imageRequest, "downloadFailed");
            }
        }

        _cls1()
        {
            this$0 = TAdItem.this;
            super();
        }
    }

}
