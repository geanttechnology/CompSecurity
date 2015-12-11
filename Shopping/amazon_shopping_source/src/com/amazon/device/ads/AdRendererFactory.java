// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            HtmlRenderer, MraidRenderer, AdRenderer, AdData, 
//            AdController

class AdRendererFactory
{

    public static final String LOG_TAG = "AdRendererFactory";

    public AdRendererFactory()
    {
    }

    protected AdRenderer createHtmlRenderer(AdData addata, AdController adcontroller, WebView webview, Context context)
    {
        return new HtmlRenderer(addata, adcontroller, webview, context);
    }

    protected AdRenderer createMraidRenderer(AdData addata, AdController adcontroller, WebView webview, Context context)
    {
        return new MraidRenderer(addata, adcontroller, webview, context);
    }

    public AdRenderer getAdRenderer(AdData.AAXCreative aaxcreative, AdData addata, AdController adcontroller, WebView webview, Context context)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$ads$AdData$AAXCreative[];

            static 
            {
                $SwitchMap$com$amazon$device$ads$AdData$AAXCreative = new int[AdData.AAXCreative.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$ads$AdData$AAXCreative[AdData.AAXCreative.HTML.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$ads$AdData$AAXCreative[AdData.AAXCreative.MRAID1.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.device.ads.AdData.AAXCreative[aaxcreative.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return createHtmlRenderer(addata, adcontroller, webview, context);

        case 2: // '\002'
            return createMraidRenderer(addata, adcontroller, webview, context);
        }
    }

    protected Class getAdRendererClass(AdData.AAXCreative aaxcreative)
    {
        switch (_cls1..SwitchMap.com.amazon.device.ads.AdData.AAXCreative[aaxcreative.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return com/amazon/device/ads/HtmlRenderer;

        case 2: // '\002'
            return com/amazon/device/ads/MraidRenderer;
        }
    }

    public boolean shouldCreateNewRenderer(AdData.AAXCreative aaxcreative, AdRenderer adrenderer)
    {
        return adrenderer == null || !adrenderer.shouldReuse() || adrenderer.getClass() != getAdRendererClass(aaxcreative);
    }
}
