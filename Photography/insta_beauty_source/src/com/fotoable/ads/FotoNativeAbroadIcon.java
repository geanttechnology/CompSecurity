// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import anw;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import gx;
import ha;

public class FotoNativeAbroadIcon extends FotoNativeIcon
{

    private Handler mThreadKillerHandler;
    private String madID;
    private ha nativeAbroadItem;

    public FotoNativeAbroadIcon(Context context)
    {
        super(context);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    public FotoNativeAbroadIcon(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    public FotoNativeAbroadIcon(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        nativeAbroadItem = null;
        madID = null;
        mThreadKillerHandler = null;
    }

    private void initNativeAd(String s)
    {
        madID = s;
        if (nativeAbroadItem == null)
        {
            nativeAbroadItem = new ha();
        }
        if (nativeItem == null)
        {
            nativeItem = nativeAbroadItem;
        }
    }

    public void destroyNativeIcon()
    {
        if (mThreadKillerHandler != null)
        {
            mThreadKillerHandler.getLooper().quit();
        }
    }

    public void loadNativeAd(String s, anw anw1)
    {
        if (!isLoading)
        {
            isLoading = true;
            if (NativeAdWrapper.needFBNativeIcon(getContext()))
            {
                try
                {
                    initNativeAd(s);
                    (new Thread(new gx(this, anw1))).start();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    isLoading = false;
                }
                s.printStackTrace();
                mThreadKillerHandler.getLooper().quit();
                return;
            }
            isLoading = false;
            if (anw1 != null)
            {
                anw1.adIconFailed();
                return;
            }
        }
    }

    public void registImpression()
    {
    }


/*
    public static Handler access$002(FotoNativeAbroadIcon fotonativeabroadicon, Handler handler)
    {
        fotonativeabroadicon.mThreadKillerHandler = handler;
        return handler;
    }

*/


}
