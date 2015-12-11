// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import io.presage.formats.NewFormatDescriptor;
import io.presage.if.b;
import io.presage.if.c;
import io.presage.model.Advertiser;
import io.presage.model.Parameter;
import java.util.Iterator;
import java.util.List;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.GsonBuilder;

// Referenced classes of package io.presage.ads:
//            e

public class NewAd
{
    public static interface a
    {

        public abstract void onFormatEvent(String s);
    }

    public static interface b
    {

        public abstract void onPageFinished(String s, boolean flag);
    }

    public static interface c
    {

        public abstract void onSDKAction(String s, String s1);
    }

    public static interface d
    {

        public abstract void onVideoError(String s);
    }

    public static interface e
    {

        public abstract String a();
    }


    public static final String ACTION_HIDE = "io.presage.ad.HIDE";
    public static final String ACTION_SHOW = "io.presage.ad.SHOW";
    public static final String EVENT_CANCEL = "cancel";
    public static final String EVENT_CLOSE_SYSTEM_DIALOG = "close_system_dialog";
    public static final String EVENT_COMPLETED = "completed";
    public static final String EVENT_FINISH = "finish";
    public static final String EVENT_SHOWN = "shown";
    public static final String EXTRA_AD_ID = "id";
    private Advertiser advertiser;
    private String campaignId;
    private NewFormatDescriptor formatDescriptor;
    private transient a formatEventListener;
    private String id;
    private String linkUrl;
    private transient b pageFinishedListener;
    private List params;
    private transient c sdkActionListener;
    private transient e videoCompletionCallback;
    private transient d videoErrorListener;

    public NewAd()
    {
    }

    public static NewAd fromJsonString(String s)
    {
        return (NewAd)(new GsonBuilder()).registerTypeAdapter(io/presage/model/Parameter, new io.presage.if.c()).registerTypeAdapter((new io.presage.ads.e()).getType(), new io.presage.if.b()).create().fromJson(s, io/presage/ads/NewAd);
    }

    public Advertiser getAdvertiser()
    {
        return advertiser;
    }

    public String getCampaignId()
    {
        return campaignId;
    }

    public NewFormatDescriptor getFormatDescriptor()
    {
        return formatDescriptor;
    }

    public String getId()
    {
        return id;
    }

    public String getLinkUrl()
    {
        return linkUrl;
    }

    public Parameter getOverridedParameter(String s)
    {
        Parameter parameter1 = getParameter(s);
        Parameter parameter = parameter1;
        if (parameter1 == null)
        {
            parameter = parameter1;
            if (formatDescriptor != null)
            {
                parameter = formatDescriptor.getParameter(s);
            }
        }
        return parameter;
    }

    public Object getOverridedParameterValue(String s, Class class1)
    {
        s = getOverridedParameter(s);
        if (s == null)
        {
            return null;
        } else
        {
            return s.get(class1);
        }
    }

    public Parameter getParameter(String s)
    {
label0:
        {
            if (params == null)
            {
                break label0;
            }
            Iterator iterator = params.iterator();
            Parameter parameter;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                parameter = (Parameter)iterator.next();
            } while (parameter == null || !s.equals(parameter.getName()));
            return parameter;
        }
        return null;
    }

    public String getVideoCompletionRate()
    {
        if (videoCompletionCallback != null)
        {
            return videoCompletionCallback.a();
        } else
        {
            return null;
        }
    }

    public void onFormatEvent(String s)
    {
        if (formatEventListener != null)
        {
            formatEventListener.onFormatEvent(s);
        }
    }

    public void onPageFinished(String s, boolean flag)
    {
        if (pageFinishedListener != null)
        {
            pageFinishedListener.onPageFinished(s, flag);
        }
    }

    public void onSDKAction(String s, String s1)
    {
        if (sdkActionListener != null)
        {
            sdkActionListener.onSDKAction(s, s1);
        }
    }

    public void onVideoError(String s)
    {
        if (videoErrorListener != null)
        {
            videoErrorListener.onVideoError(s);
        }
    }

    public void setFormatDescriptor(NewFormatDescriptor newformatdescriptor)
    {
        formatDescriptor = newformatdescriptor;
    }

    public void setOnFormatEventListener(a a1)
    {
        formatEventListener = a1;
    }

    public void setOnPageFinishedListener(b b1)
    {
        pageFinishedListener = b1;
    }

    public void setOnSDKActionListener(c c1)
    {
        sdkActionListener = c1;
    }

    public void setOnVideoErrorListener(d d1)
    {
        videoErrorListener = d1;
    }

    public void setVideoCompletionCallback(e e1)
    {
        videoCompletionCallback = e1;
    }
}
