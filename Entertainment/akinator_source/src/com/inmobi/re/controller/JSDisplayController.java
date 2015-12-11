// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.controller:
//            JSController

public class JSDisplayController extends JSController
{

    private WindowManager a;
    private float b;
    private JSController.OrientationProperties c;
    private JSController.ResizeProperties d;

    public JSDisplayController(IMWebView imwebview, Context context)
    {
        super(imwebview, context);
        c = null;
        d = null;
        imwebview = new DisplayMetrics();
        a = (WindowManager)context.getSystemService("window");
        a.getDefaultDisplay().getMetrics(imwebview);
        b = ((Activity)mContext).getResources().getDisplayMetrics().density;
    }

    private JSController.ExpandProperties a(JSController.ExpandProperties expandproperties)
    {
        Display display = a.getDefaultDisplay();
        int k = ((Activity)mContext).getResources().getDisplayMetrics().widthPixels;
        int l = ((Activity)mContext).getResources().getDisplayMetrics().heightPixels;
        View view = ((Activity)mContext).getWindow().findViewById(0x1020002);
        expandproperties.topStuff = view.getTop();
        expandproperties.bottomStuff = l - view.getBottom();
        int i = DeviceInfo.getDisplayRotation(display);
        int j = i;
        if (DeviceInfo.isDefOrientationLandscape(i, k, l))
        {
            j = i + 1;
            i = j;
            if (j > 3)
            {
                i = 0;
            }
            j = i;
            if (DeviceInfo.isTablet(mContext))
            {
                imWebView.isTablet = true;
                j = i;
            }
        }
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Device current rotation: ").append(j).toString());
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Density of device: ").append(b).toString());
        expandproperties.width = (int)((float)expandproperties.width * b);
        expandproperties.height = (int)((float)expandproperties.height * b);
        expandproperties.x = (int)((float)expandproperties.x * b);
        expandproperties.y = (int)((float)expandproperties.y * b);
        expandproperties.currentX = 0;
        expandproperties.currentY = 0;
        imWebView.publisherOrientation = ((Activity)imWebView.getContext()).getRequestedOrientation();
        int ai[];
        if (j == 0 || j == 2)
        {
            expandproperties.rotationAtExpand = "portrait";
        } else
        {
            expandproperties.rotationAtExpand = "landscape";
        }
        if (expandproperties.height <= 0 || expandproperties.width <= 0)
        {
            expandproperties.height = l;
            expandproperties.width = k;
            expandproperties.zeroWidthHeight = true;
        }
        if (j == 0 || j == 2)
        {
            expandproperties.portraitWidthRequested = expandproperties.width;
            expandproperties.portraitHeightRequested = expandproperties.height;
        } else
        {
            expandproperties.portraitWidthRequested = expandproperties.height;
            expandproperties.portraitHeightRequested = expandproperties.width;
        }
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Device Width: ").append(k).append(" Device height: ").append(l).toString());
        i = l - expandproperties.topStuff;
        if (expandproperties.width > k)
        {
            expandproperties.width = k;
        }
        if (expandproperties.height > i)
        {
            expandproperties.height = i;
        }
        ai = new int[2];
        imWebView.getLocationOnScreen(ai);
        if (expandproperties.x < 0)
        {
            expandproperties.x = ai[0];
        }
        if (expandproperties.y < 0)
        {
            expandproperties.y = ai[1] - expandproperties.topStuff;
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("topStuff: ").append(expandproperties.topStuff).append(" ,bottomStuff: ").append(expandproperties.bottomStuff).toString());
        }
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("loc 0: ").append(ai[0]).append(" loc 1: ").append(ai[1]).toString());
        j = k - (expandproperties.x + expandproperties.width);
        if (j < 0)
        {
            expandproperties.x = j + expandproperties.x;
            if (expandproperties.x < 0)
            {
                expandproperties.width = expandproperties.width + expandproperties.x;
                expandproperties.x = 0;
            }
        }
        i -= expandproperties.y + expandproperties.height;
        if (i < 0)
        {
            expandproperties.y = i + expandproperties.y;
            if (expandproperties.y < 0)
            {
                expandproperties.height = expandproperties.height + expandproperties.y;
                expandproperties.y = 0;
            }
        }
        expandproperties.currentX = expandproperties.x;
        expandproperties.currentY = expandproperties.y;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("final expanded width after density : ").append(expandproperties.width).append("final expanded height after density ").append(expandproperties.height).append("portrait width requested :").append(expandproperties.portraitWidthRequested).append("portrait height requested :").append(expandproperties.portraitHeightRequested).toString());
        return expandproperties;
    }

    private void a(JSController.ExpandProperties expandproperties, JSController.ExpandProperties expandproperties1)
    {
        expandproperties.width = expandproperties1.width;
        expandproperties.height = expandproperties1.height;
        expandproperties.x = expandproperties1.x;
        expandproperties.y = expandproperties1.y;
        expandproperties.actualWidthRequested = expandproperties1.actualWidthRequested;
        expandproperties.actualHeightRequested = expandproperties1.actualHeightRequested;
        expandproperties.lockOrientation = expandproperties1.lockOrientation;
        expandproperties.isModal = expandproperties1.isModal;
        expandproperties.useCustomClose = expandproperties1.useCustomClose;
        expandproperties.orientation = expandproperties1.orientation;
        expandproperties.topStuff = expandproperties1.topStuff;
        expandproperties.bottomStuff = expandproperties1.bottomStuff;
        expandproperties.portraitWidthRequested = expandproperties1.portraitWidthRequested;
        expandproperties.portraitHeightRequested = expandproperties1.portraitHeightRequested;
        expandproperties.zeroWidthHeight = expandproperties1.zeroWidthHeight;
        expandproperties.rotationAtExpand = expandproperties1.rotationAtExpand;
        expandproperties.currentX = expandproperties1.currentX;
        expandproperties.currentY = expandproperties1.currentY;
    }

    private void a(JSController.ResizeProperties resizeproperties, JSController.ResizeProperties resizeproperties1)
    {
        resizeproperties.width = resizeproperties1.width;
        resizeproperties.height = resizeproperties1.height;
        resizeproperties.allowOffscreen = resizeproperties1.allowOffscreen;
        resizeproperties.customClosePosition = resizeproperties1.customClosePosition;
        resizeproperties.offsetX = resizeproperties1.offsetX;
        resizeproperties.offsetY = resizeproperties1.offsetY;
    }

    public void close()
    {
        Activity activity = null;
        try
        {
            ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(13), null));
            Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> close");
            if (imWebView.mOriginalWebviewForExpandUrl != null)
            {
                imWebView.mOriginalWebviewForExpandUrl.close();
            }
            if (imWebView.isExpanded())
            {
                activity = imWebView.getExpandedActivity();
            }
            imWebView.close();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception while closing the ad. ", exception);
            return;
        }
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        activity.finish();
    }

    public void disableCloseRegion(boolean flag)
    {
        imWebView.setDisableCloseRegion(flag);
    }

    public void expand(String s)
    {
        boolean flag;
        flag = false;
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(11), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> expand: url: ").append(s).toString());
        try
        {
            if (imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.EXPANDED || imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.EXPANDING)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> Already expanded state");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception while expanding the ad. ", s);
            return;
        }
        if (imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.HIDDEN)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> Expand cannot be called in hidden state. Doing nothing.");
            return;
        }
        imWebView.mExpandController.useLockOrient = false;
        if (imWebView.getStateVariable() != com.inmobi.re.container.IMWebView.ViewState.DEFAULT && imWebView.getStateVariable() != com.inmobi.re.container.IMWebView.ViewState.RESIZED && imWebView.getStateVariable() != com.inmobi.re.container.IMWebView.ViewState.RESIZING)
        {
            imWebView.raiseError("Current state is not default", "expand");
            return;
        }
        if (imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.DEFAULT && imWebView.mIsInterstitialAd)
        {
            imWebView.raiseError("Expand cannot be called on interstitial ad", "expand");
            return;
        }
        a(temporaryexpProps, expProps);
        JSController.ExpandProperties expandproperties = temporaryexpProps;
        temporaryexpProps.height = 0;
        expandproperties.width = 0;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> At the time of expand the properties are: Expandable width: ").append(temporaryexpProps.width).append(" Expandable height: ").append(temporaryexpProps.height).append(" Expandable orientation: ").append(temporaryexpProps.orientation).append(" Expandable lock orientation: ").append(temporaryexpProps.lockOrientation).append(" Expandable Modality: ").append(temporaryexpProps.isModal).append(" Expandable Use custom close ").append(temporaryexpProps.useCustomClose).toString());
        expProps = a(expProps);
        if (c == null) goto _L2; else goto _L1
_L1:
        imWebView.mExpandController.lockOrientationValueForExpand = c.allowOrientationChange;
        imWebView.mExpandController.orientationValueForExpand = c.forceOrientation;
_L3:
        imWebView.expand(s, a(temporaryexpProps));
        return;
_L2:
        MRAIDExpandController mraidexpandcontroller = imWebView.mExpandController;
        if (!temporaryexpProps.lockOrientation)
        {
            flag = true;
        }
        mraidexpandcontroller.lockOrientationValueForExpand = flag;
        imWebView.mExpandController.orientationValueForExpand = temporaryexpProps.orientation;
          goto _L3
    }

    public String getExpandProperties()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(4), null));
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", expProps.width);
            jsonobject.put("height", expProps.height);
            jsonobject.put("isModal", expProps.isModal);
            jsonobject.put("useCustomClose", expProps.useCustomClose);
            jsonobject.put("lockOrientation", expProps.lockOrientation);
            jsonobject.put("orientation", expProps.orientation);
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Failed to get expand props");
        }
        return jsonobject.toString();
    }

    public String getOrientation()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(16), null));
        String s;
        try
        {
            s = imWebView.getCurrentRotation(imWebView.getIntegerCurrentRotation());
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> getOrientation: ").append(s).toString());
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Error getOrientation: ").append("-1").toString(), exception);
            return "-1";
        }
        return s;
    }

    public String getOrientationProperties()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(5), null));
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("allowOrientationChange", c.allowOrientationChange);
            jsonobject.put("orientation", c.forceOrientation);
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Failed to get orientation props");
        }
        return jsonobject.toString();
    }

    public String getPlacementType()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(15), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> getPlacementType");
        return imWebView.getPlacementType();
    }

    public String getResizeProperties()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(6), null));
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", d.width);
            jsonobject.put("height", d.height);
            jsonobject.put("offsetX", d.offsetX);
            jsonobject.put("offsetY", d.offsetY);
            jsonobject.put("customClosePosition", d.customClosePosition);
            jsonobject.put("allowOffscreen", d.allowOffscreen);
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Failed to get resize properties");
        }
        return jsonobject.toString();
    }

    public String getState()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(3), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> getState");
        return imWebView.getState();
    }

    public boolean isViewable()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(14), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> isViewable").append(imWebView.isViewable()).toString());
        return imWebView.isViewable();
    }

    public void onOrientationChange()
    {
        imWebView.onOrientationEventChange();
    }

    public void open(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(1), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> open: url: ").append(s).toString());
        imWebView.openURL(s);
    }

    public void reset()
    {
        if (expProps != null)
        {
            expProps.reinitializeExpandProperties();
        }
        if (d != null)
        {
            d.initializeResizeProperties();
        }
    }

    public void resize()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(12), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> resize");
        try
        {
            if (imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.RESIZING)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> Already resize state");
                return;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception while expanding the ad. ", exception);
            return;
        }
        if (imWebView.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.HIDDEN)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "JSDisplayController-> Resize cannot be called in hidden state. Doing nothing.");
            return;
        }
        if (imWebView.getStateVariable() != com.inmobi.re.container.IMWebView.ViewState.DEFAULT && imWebView.getStateVariable() != com.inmobi.re.container.IMWebView.ViewState.RESIZED)
        {
            imWebView.raiseError("Current state is neither default nor resized", "resize");
            return;
        }
        if (imWebView.mIsInterstitialAd)
        {
            imWebView.raiseError("Resize cannot be called on interstitial ad", "resize");
            return;
        }
        JSController.ResizeProperties resizeproperties = new JSController.ResizeProperties();
        a(resizeproperties, d);
        resizeproperties.width = (int)((float)resizeproperties.width * imWebView.getDensity());
        resizeproperties.height = (int)((float)resizeproperties.height * imWebView.getDensity());
        resizeproperties.offsetX = (int)((float)resizeproperties.offsetX * imWebView.getDensity());
        resizeproperties.offsetY = (int)((float)resizeproperties.offsetY * imWebView.getDensity());
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> At the time of resize the properties are: Resize width: ").append(resizeproperties.width).append(" Resize height: ").append(resizeproperties.height).append(" Resize offsetX: ").append(resizeproperties.offsetX).append(" Resize offsetY: ").append(resizeproperties.offsetY).append(" customClosePosition: ").append(resizeproperties.customClosePosition).append(" allowOffscreen: ").append(resizeproperties.allowOffscreen).toString());
        imWebView.resize(resizeproperties);
        return;
    }

    public void setExpandProperties(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(7), null));
        expProps = (JSController.ExpandProperties)getFromJSON(new JSONObject(s), com/inmobi/re/controller/JSController$ExpandProperties);
        expProps.isModal = true;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> ExpandProperties is set: Expandable Width: ").append(expProps.width).append(" Expandable height: ").append(expProps.height).append(" Expandable orientation: ").append(expProps.orientation).append(" Expandable lock orientation: ").append(expProps.lockOrientation).append(" Expandable Modality: ").append(expProps.isModal).append(" Expandable Use Custom close: ").append(expProps.useCustomClose).toString());
        imWebView.setCustomClose(expProps.useCustomClose);
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        s = imWebView;
        boolean flag;
        if (!expProps.lockOrientation)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.setOrientationPropertiesForInterstitial(flag, expProps.orientation);
        return;
        s;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Exception while setting the expand properties ").append(s).toString());
        return;
    }

    public void setOrientationProperties(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(8), null));
        try
        {
            c = (JSController.OrientationProperties)getFromJSON(new JSONObject(s), com/inmobi/re/controller/JSController$OrientationProperties);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> OrientationProperties is set: Expandable orientation: ").append(expProps.orientation).append(" Expandable lock orientation: ").append(expProps.lockOrientation).toString());
            imWebView.setOrientationPropertiesForInterstitial(c.allowOrientationChange, c.forceOrientation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Exception while setting the expand properties ").append(s).toString());
        }
    }

    public void setResizeProperties(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(9), null));
        try
        {
            d = (JSController.ResizeProperties)getFromJSON(new JSONObject(s), com/inmobi/re/controller/JSController$ResizeProperties);
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> ResizeProperties is set: Resize Width: ").append(d.width).append(" Resize height: ").append(d.height).append(" Resize offsetX: ").append(d.offsetX).append(" Resize offsetY: ").append(d.offsetY).append(" customClosePosition: ").append(d.customClosePosition).append(" allowOffscreen: ").append(d.allowOffscreen).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Exception while setting the expand properties ").append(s).toString());
        }
    }

    public void stopAllListeners()
    {
    }

    public void useCustomClose(boolean flag)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(10), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSDisplayController-> useCustomClose").append(flag).toString());
        imWebView.setCustomClose(flag);
    }
}
