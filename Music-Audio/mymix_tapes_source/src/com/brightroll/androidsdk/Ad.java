// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.app.Activity;
import android.content.Intent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.brightroll.androidsdk:
//            AsyncHttpRequestDelegate, AdDelegate, AsyncHttpRequest, RTB, 
//            AdIdTask, AdActivity

public class Ad
    implements AsyncHttpRequestDelegate
{

    public static int REQUEST_CODE_ACTIVITY_COMPLETED = 1;
    public static Ad displayedAd;
    String adId;
    private AdIdTask adIdTask;
    Map additionalParameters;
    boolean allowsBrowse;
    boolean canShow;
    String clickThroughUrl;
    String content;
    AdDelegate _flddelegate;
    String endpointUrl;
    boolean hashesUserId;
    String host;
    AsyncHttpRequest request;
    RTB rtb;
    int sitePlacementId;
    boolean supressesBackBeforeCompletion;
    boolean supressesBackDuringLoad;
    String version;
    int videoHeight;
    String videoUrl;
    int videoWidth;

    public Ad()
    {
        setAllowsBrowse(true);
        additionalParameters = new HashMap();
        adId = "";
    }

    public void activityDestroyed()
    {
        if (_flddelegate != null)
        {
            _flddelegate.adDismissed(this);
        }
    }

    public void addParam(String s, String s1)
    {
        additionalParameters.put(s, s1);
    }

    public boolean allowsBrowse()
    {
        return allowsBrowse;
    }

    public void asyncHttpRequestCompleted(AsyncHttpRequest asynchttprequest)
    {
        asynchttprequest = new JSONTokener(asynchttprequest.getResponseContent());
        asynchttprequest = (JSONObject)asynchttprequest.nextValue();
        if (asynchttprequest.getBoolean("adAvailable"))
        {
            if (asynchttprequest.has("adId"))
            {
                adId = asynchttprequest.getString("adId");
            }
            content = asynchttprequest.getJSONObject("creative").getString("content");
            canShow = true;
            if (_flddelegate != null)
            {
                _flddelegate.adFetched(this);
                return;
            }
            break MISSING_BLOCK_LABEL_126;
        }
        try
        {
            if (_flddelegate != null)
            {
                _flddelegate.adFetchFailed(this);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (AsyncHttpRequest asynchttprequest)
        {
            asynchttprequest.printStackTrace();
            if (_flddelegate != null)
            {
                _flddelegate.adFetchFailed(this);
            }
        }
    }

    public void asyncHttpRequestFailed(AsyncHttpRequest asynchttprequest)
    {
        if (_flddelegate != null)
        {
            _flddelegate.adFetchFailed(this);
        }
    }

    public boolean canShow()
    {
        return canShow;
    }

    public void cancel()
    {
        request.cancel(true);
        request.setDelegate(null);
        setDelegate(null);
    }

    public String endpointUrl()
    {
        if (endpointUrl != null)
        {
            return endpointUrl;
        }
        Object obj1 = host;
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = "mobile.btrll.com";
        }
        Object obj2 = version;
        obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = "20140717";
        }
        obj = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder("http://")).append(((String) (obj))).append("/ad").toString()))).append(getRTB().queryString()).toString()))).append("&version=").append(((String) (obj1))).toString()))).append("&platform=android").toString()))).append("&integration=sdk").toString()))).append("&format=json").toString()))).append("&siteId=").append(String.valueOf(sitePlacementId)).toString()))).append("&n=").append(String.valueOf(System.currentTimeMillis())).toString();
        obj1 = obj;
        if (videoWidth != 0)
        {
            obj1 = (new StringBuilder(String.valueOf(obj))).append("&videoWidth=").append(String.valueOf(videoWidth)).toString();
        }
        obj = obj1;
        if (videoHeight != 0)
        {
            obj = (new StringBuilder(String.valueOf(obj1))).append("&videoHeight=").append(String.valueOf(videoHeight)).toString();
        }
        obj1 = obj;
        if (videoUrl != null)
        {
            try
            {
                obj1 = (new StringBuilder(String.valueOf(obj))).append("&videoUrl=").append(URLEncoder.encode(videoUrl, "UTF-8")).toString();
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception = ((UnsupportedEncodingException) (obj));
            }
        }
        obj = obj1;
        if (clickThroughUrl != null)
        {
            try
            {
                obj = (new StringBuilder(String.valueOf(obj1))).append("&clickThroughUrl=").append(URLEncoder.encode(clickThroughUrl, "UTF-8")).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = obj1;
            }
        }
        obj2 = additionalParameters.entrySet().iterator();
        if (!((Iterator) (obj2)).hasNext())
        {
            System.out.println(((String) (obj)));
            return ((String) (obj));
        }
        obj1 = (java.util.Map.Entry)((Iterator) (obj2)).next();
        obj1 = (new StringBuilder(String.valueOf(obj))).append("&").append((String)((java.util.Map.Entry) (obj1)).getKey()).append("=").append(URLEncoder.encode((String)((java.util.Map.Entry) (obj1)).getValue(), "UTF-8")).toString();
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_391;
_L1:
    }

    public void fetch()
    {
        adIdTask = new AdIdTask();
        adIdTask.setAd(this);
        adIdTask.execute(new Void[0]);
    }

    public String getAdId()
    {
        return adId;
    }

    public Map getAdditionalParameters()
    {
        return additionalParameters;
    }

    public AdDelegate getDelegate()
    {
        return _flddelegate;
    }

    public String getEndpointUrl()
    {
        return endpointUrl;
    }

    public boolean getHashesUserId()
    {
        return hashesUserId;
    }

    public String getHost()
    {
        return host;
    }

    public RTB getRTB()
    {
        if (rtb == null)
        {
            rtb = new RTB();
            rtb.setAd(this);
        }
        return rtb;
    }

    public int getSitePlacementId()
    {
        return sitePlacementId;
    }

    public boolean getSupressesBackBeforeCompletion()
    {
        return supressesBackBeforeCompletion;
    }

    public boolean getSupressesBackDuringLoad()
    {
        return supressesBackDuringLoad;
    }

    public String getVersion()
    {
        return version;
    }

    void justFetch()
    {
        String s = adIdTask.adId;
        if (s == null)
        {
            s = android.provider.Settings.Secure.getString(getDelegate().getAdActivity().getContentResolver(), "android_id");
            getRTB().setAndroidId(s);
        } else
        {
            getRTB().setAdId(s);
            getRTB().setDnt(adIdTask.isLimitAdTrackingEnabled);
        }
        request = new AsyncHttpRequest();
        request.setUrl(endpointUrl());
        request.setDelegate(this);
        request.start();
    }

    public void setAdId(String s)
    {
        adId = s;
    }

    public void setAllowsBrowse(boolean flag)
    {
        allowsBrowse = flag;
    }

    public void setClickThroughUrl(String s)
    {
        clickThroughUrl = s;
    }

    public void setDelegate(AdDelegate addelegate)
    {
        _flddelegate = addelegate;
    }

    public void setEndpointUrl(String s)
    {
        endpointUrl = s;
    }

    public void setHashesUserId(boolean flag)
    {
        hashesUserId = flag;
    }

    public void setHost(String s)
    {
        host = s;
    }

    public void setSitePlacementId(int i)
    {
        sitePlacementId = i;
    }

    public void setSupressesBackBeforeCompletion(boolean flag)
    {
        supressesBackBeforeCompletion = flag;
    }

    public void setSupressesBackDuringLoad(boolean flag)
    {
        supressesBackDuringLoad = flag;
    }

    public void setVersion(String s)
    {
        version = s;
    }

    public void setVideoHeight(int i)
    {
        videoHeight = i;
    }

    public void setVideoUrl(String s)
    {
        videoUrl = s;
    }

    public void setVideoWidth(int i)
    {
        videoWidth = i;
    }

    public void show()
    {
        if (_flddelegate != null)
        {
            Activity activity = _flddelegate.getAdActivity();
            Intent intent = new Intent(activity, com/brightroll/androidsdk/AdActivity);
            intent.putExtra("html", content);
            intent.putExtra("baseUrl", request.getUrl());
            activity.startActivityForResult(intent, REQUEST_CODE_ACTIVITY_COMPLETED);
            displayedAd = this;
        }
    }

}
