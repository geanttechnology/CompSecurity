// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            BaseNativeAd, MediaLayout

public abstract class VideoNativeAd extends BaseNativeAd
    implements NativeVideoController.Listener
{

    private String mCallToAction;
    private String mClickDestinationUrl;
    private final Map mExtras = new HashMap();
    private String mIconImageUrl;
    private String mMainImageUrl;
    private String mPrivacyInformationIconClickThroughUrl;
    private String mText;
    private String mTitle;
    private String mVastVideo;

    public VideoNativeAd()
    {
    }

    public final void addExtra(String s, Object obj)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "addExtra key is not allowed to be null"))
        {
            return;
        } else
        {
            mExtras.put(s, obj);
            return;
        }
    }

    public void clear(View view)
    {
    }

    public void destroy()
    {
    }

    public String getCallToAction()
    {
        return mCallToAction;
    }

    public String getClickDestinationUrl()
    {
        return mClickDestinationUrl;
    }

    public final Object getExtra(String s)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(s, "getExtra key is not allowed to be null"))
        {
            return null;
        } else
        {
            return mExtras.get(s);
        }
    }

    public final Map getExtras()
    {
        return mExtras;
    }

    public String getIconImageUrl()
    {
        return mIconImageUrl;
    }

    public String getMainImageUrl()
    {
        return mMainImageUrl;
    }

    public String getPrivacyInformationIconClickThroughUrl()
    {
        return mPrivacyInformationIconClickThroughUrl;
    }

    public String getText()
    {
        return mText;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public String getVastVideo()
    {
        return mVastVideo;
    }

    public void prepare(View view)
    {
    }

    public void render(MediaLayout medialayout)
    {
    }

    public void setCallToAction(String s)
    {
        mCallToAction = s;
    }

    public void setClickDestinationUrl(String s)
    {
        mClickDestinationUrl = s;
    }

    public void setIconImageUrl(String s)
    {
        mIconImageUrl = s;
    }

    public void setMainImageUrl(String s)
    {
        mMainImageUrl = s;
    }

    public void setPrivacyInformationIconClickThroughUrl(String s)
    {
        mPrivacyInformationIconClickThroughUrl = s;
    }

    public void setText(String s)
    {
        mText = s;
    }

    public void setTitle(String s)
    {
        mTitle = s;
    }

    public void setVastVideo(String s)
    {
        mVastVideo = s;
    }
}
