// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.ad.interfaces.ICreativeRenditionAsset;
import tv.freewheel.ad.interfaces.ISlot;
import tv.freewheel.renderers.interfaces.IActivityCallbackListener;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.renderer.RendererTimer;

// Referenced classes of package tv.freewheel.renderers.html:
//            Parameters, MRAIDPresentationInterstitial, IMRAIDPresentation, MRAIDPresentationInLine, 
//            MRAIDWebView

public class HTMLRenderer
    implements IRenderer, tv.freewheel.utils.renderer.RendererTimer.IRendererTimerService
{
    private static final class MRAIDState extends Enum
    {

        private static final MRAIDState $VALUES[];
        public static final MRAIDState DEFAULT;
        public static final MRAIDState EXPANDED;
        public static final MRAIDState HIDDEN;
        public static final MRAIDState LOADING;
        public static final MRAIDState RESIZED;

        public static MRAIDState valueOf(String s)
        {
            return (MRAIDState)Enum.valueOf(tv/freewheel/renderers/html/HTMLRenderer$MRAIDState, s);
        }

        public static MRAIDState[] values()
        {
            return (MRAIDState[])$VALUES.clone();
        }

        static 
        {
            LOADING = new MRAIDState("LOADING", 0);
            DEFAULT = new MRAIDState("DEFAULT", 1);
            EXPANDED = new MRAIDState("EXPANDED", 2);
            RESIZED = new MRAIDState("RESIZED", 3);
            HIDDEN = new MRAIDState("HIDDEN", 4);
            $VALUES = (new MRAIDState[] {
                LOADING, DEFAULT, EXPANDED, RESIZED, HIDDEN
            });
        }

        private MRAIDState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Set closePositionOptions = new HashSet(Arrays.asList(new String[] {
        "top-left", "top-right", "center", "bottom-left", "bottom-right", "top-center", "bottom-center"
    }));
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
    private Activity activity;
    private IActivityCallbackListener activityCallbackListener;
    private boolean allowOffscreen;
    private IConstants constants;
    private int creativeRequiredExpandHeight;
    private int creativeRequiredExpandWidth;
    private int creativeRequiredResizeHeight;
    private int creativeRequiredResizeOffsetX;
    private int creativeRequiredResizeOffsetY;
    private int creativeRequiredResizeWidth;
    private String customClosePosition;
    private double duration;
    private String expandURL;
    private AtomicInteger headTime;
    private boolean isInterstitial;
    private boolean isMRAIDAd;
    private boolean isStopped;
    private boolean isUseCustomClose;
    private boolean isViewable;
    private Logger logger;
    private Handler mainLoopHandler;
    private Parameters parameters;
    private boolean pauseNotificationSentWhenExternalBrowserOpened;
    private String placementType;
    private IMRAIDPresentation presentation;
    private IRendererContext rendererContext;
    private RendererTimer rendererTimer;
    private boolean shouldEndAfterDuration;
    private boolean shouldPauseResumeMainVideoOnActivityStateChange;
    private boolean shouldPauseResumeMainVideoWhenExpand;
    private boolean showedPresentation;
    private ISlot slot;
    private MRAIDState state;
    private int stateOfExternalWebBrowserActivity;

    public HTMLRenderer()
    {
        parameters = null;
        placementType = null;
        state = MRAIDState.LOADING;
        isViewable = true;
        isUseCustomClose = false;
        pauseNotificationSentWhenExternalBrowserOpened = false;
        showedPresentation = false;
        duration = -1D;
        headTime = new AtomicInteger(-1);
        stateOfExternalWebBrowserActivity = 0;
        creativeRequiredExpandWidth = -1;
        creativeRequiredExpandHeight = -1;
        creativeRequiredResizeWidth = -1;
        creativeRequiredResizeHeight = -1;
        creativeRequiredResizeOffsetX = -1;
        creativeRequiredResizeOffsetY = -1;
        customClosePosition = "top-right";
        allowOffscreen = true;
        isMRAIDAd = false;
        shouldEndAfterDuration = false;
        shouldPauseResumeMainVideoWhenExpand = false;
        shouldPauseResumeMainVideoOnActivityStateChange = false;
        rendererContext = null;
        constants = null;
        slot = null;
        mainLoopHandler = null;
        isStopped = false;
        logger = Logger.getLogger(this);
        logger.info((new StringBuilder()).append("Android SDK Version: ").append(android.os.Build.VERSION.SDK).append(", API Version: ").append(android.os.Build.VERSION.SDK_INT).toString());
    }

    private String CLASSTAG()
    {
        return (new StringBuilder()).append("@").append(hashCode()).append("-").append(placementType).append("|").append(getPrintableTimePositionClass()).append("|").toString();
    }

    private String MRAIDTAG()
    {
        return (new StringBuilder()).append(CLASSTAG()).append(":=STATE(").append(getPrintableState()).append(")").toString();
    }

    private void _close()
    {
        logger.info((new StringBuilder()).append(MRAIDTAG()).append(" _close()").toString());
        if (isMRAIDAd && stateOfExternalWebBrowserActivity == 1)
        {
            logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" An external web browser opened. It will delay close operation to resume from browser activity.").toString());
            stateOfExternalWebBrowserActivity = 2;
            return;
        }
        if (isInState(MRAIDState.EXPANDED) || isInState(MRAIDState.RESIZED))
        {
            transferTo(MRAIDState.DEFAULT);
            return;
        }
        if (isInState(MRAIDState.DEFAULT) || isInState(MRAIDState.LOADING))
        {
            _stop();
            return;
        } else
        {
            logger.error((new StringBuilder()).append(MRAIDTAG()).append(" Invalid state to close").toString());
            return;
        }
    }

    private void _load(IRendererContext irenderercontext)
    {
        logger.info("load");
        rendererContext = irenderercontext;
        constants = irenderercontext.getConstants();
        slot = irenderercontext.getAdInstance().getSlot();
        activity = irenderercontext.getActivity();
        mainLoopHandler = new Handler(activity.getMainLooper());
        Object obj = activity.getResources().getDisplayMetrics();
        logger.debug((new StringBuilder()).append("Display size: ").append(((DisplayMetrics) (obj)).widthPixels).append("x").append(((DisplayMetrics) (obj)).heightPixels).append(" px, app size: ").append(getAppWidth()).append("x").append(getAppHeight()).toString());
        obj = irenderercontext.getAdInstance().getActiveCreativeRendition().getCreativeAPI();
        isMRAIDAd = ((String) (obj)).toLowerCase().contains("mraid");
        logger.debug((new StringBuilder()).append("creativeApi: ").append(((String) (obj))).append(", isMRAIDAd:").append(isMRAIDAd).toString());
        parameters = new Parameters(irenderercontext);
        placementType = parameters.placementType;
        int i;
        if (placementType == null)
        {
            if ("app-interstitial".equalsIgnoreCase(irenderercontext.getAdInstance().getActiveCreativeRendition().getBaseUnit()))
            {
                placementType = "interstitial";
            } else
            {
                placementType = "inline";
            }
        }
        if ("interstitial".equalsIgnoreCase(placementType))
        {
            isInterstitial = true;
        } else
        if ("inline".equalsIgnoreCase(placementType))
        {
            isInterstitial = false;
        } else
        {
            logger.debug((new StringBuilder()).append("Invalid placement type:").append(placementType).append(", use inline type as default").toString());
            isInterstitial = false;
            placementType = "inline";
        }
        logger.debug((new StringBuilder()).append("isInterstitial:").append(isInterstitial).toString());
        if (isInterstitial)
        {
            presentation = new MRAIDPresentationInterstitial(activity, this, isMRAIDAd);
        } else
        {
            presentation = new MRAIDPresentationInLine(activity, this, rendererContext, Boolean.valueOf(isMRAIDAd));
        }
        i = slot.getTimePositionClass();
        if (!isInterstitial && isMRAIDAd)
        {
            irenderercontext.setRendererCapability(constants.EVENT_AD_ACCEPT_INVITATION(), constants.CAPABILITY_STATUS_ON());
            irenderercontext.setRendererCapability(constants.EVENT_AD_CLOSE(), constants.CAPABILITY_STATUS_ON());
            irenderercontext.setRendererCapability(constants.EVENT_AD_EXPAND(), constants.CAPABILITY_STATUS_ON());
            irenderercontext.setRendererCapability(constants.EVENT_AD_COLLAPSE(), constants.CAPABILITY_STATUS_ON());
        } else
        if (isInterstitial && i == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            failWithError(constants.ERROR_INVALID_SLOT(), "The interstitial ad is not supported in overlay slot");
            return;
        }
        if (i == constants.TIME_POSITION_CLASS_DISPLAY() || i == constants.TIME_POSITION_CLASS_OVERLAY())
        {
            shouldPauseResumeMainVideoOnActivityStateChange = true;
            if (!isInterstitial && isMRAIDAd)
            {
                shouldPauseResumeMainVideoWhenExpand = true;
            }
        }
        logger.debug((new StringBuilder()).append("shouldPauseResumeMainVideoOnActivityStateChange:").append(shouldPauseResumeMainVideoOnActivityStateChange).append(", shouldPauseResumeMainVideoWhenExpand:").append(shouldPauseResumeMainVideoWhenExpand).toString());
        obj = parameters.shouldEndAfterDuration;
        if (obj != null)
        {
            String s;
            boolean flag;
            if (((Boolean) (obj)).booleanValue() && constants.TIME_POSITION_CLASS_DISPLAY() != i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            shouldEndAfterDuration = flag;
        } else
        {
            boolean flag1;
            if (constants.TIME_POSITION_CLASS_DISPLAY() != i)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            shouldEndAfterDuration = flag1;
        }
        if (shouldEndAfterDuration)
        {
            duration = irenderercontext.getAdInstance().getActiveCreativeRendition().getDuration();
            headTime = new AtomicInteger(0);
            rendererTimer = new RendererTimer((int)duration, this);
        }
        obj = irenderercontext.getAdInstance().getActiveCreativeRendition().getPrimaryCreativRenditionAsset();
        s = ((ICreativeRenditionAsset) (obj)).getURL();
        if (s != null && s.length() != 0)
        {
            presentation.loadCreativeWithScript(s, null, null);
        } else
        {
            obj = ((ICreativeRenditionAsset) (obj)).getContent();
            if (obj != null && ((String) (obj)).length() != 0)
            {
                obj = ((String) (obj)).replaceFirst("[\\s,]*target-densitydpi = device-dpi[\\s]*", "");
                presentation.loadCreativeWithScript(null, ((String) (obj)), null);
            } else
            {
                failWithError(constants.ERROR_NULL_ASSET(), "No creative asset");
                return;
            }
        }
        irenderercontext.dispatchEvent(constants.EVENT_AD_LOADED());
    }

    private void _loadFail(int i, String s)
    {
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" errorCode:").append(i).append(",description:").append(s).toString());
        failWithError(constants.ERROR_IO(), "Load failed");
    }

    private void _loaded()
    {
        logger.info((new StringBuilder()).append(MRAIDTAG()).append(" _loaded()").toString());
        if (isInState(MRAIDState.LOADING))
        {
            transferTo(MRAIDState.DEFAULT);
            return;
        }
        if (isInState(MRAIDState.DEFAULT))
        {
            logger.info((new StringBuilder()).append(MRAIDTAG()).append(" expanded view loaded.").toString());
            return;
        } else
        {
            logger.error((new StringBuilder()).append(MRAIDTAG()).append(" Invalid state to have been loaded").toString());
            return;
        }
    }

    private void _stop()
    {
        logger.info((new StringBuilder()).append(CLASSTAG()).append(" _stop, isStopped=").append(isStopped).toString());
        if (isStopped)
        {
            return;
        } else
        {
            isStopped = true;
            transferTo(MRAIDState.HIDDEN);
            return;
        }
    }

    private void _synchStateToPresentation(boolean flag)
    {
        Object obj;
        JSONObject jsonobject;
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        JSONObject jsonobject3;
        JSONObject jsonobject4;
        DisplayMetrics displaymetrics;
        if (!isMRAIDAd)
        {
            return;
        }
        displaymetrics = activity.getResources().getDisplayMetrics();
        obj = new JSONObject();
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        jsonobject2 = new JSONObject();
        jsonobject3 = new JSONObject();
        jsonobject4 = new JSONObject();
        int ai[];
        MRAIDWebView mraidwebview;
        ((JSONObject) (obj)).put("width", (int)((float)expandWidth() / displaymetrics.density)).put("height", (int)((float)expandHeight() / displaymetrics.density)).put("useCustomClose", isUseCustomClose).put("isModal", true);
        if (creativeRequiredResizeWidth > 0 && creativeRequiredResizeHeight > 0)
        {
            jsonobject.put("width", (int)((float)creativeRequiredResizeWidth / displaymetrics.density)).put("height", (int)((float)creativeRequiredResizeHeight / displaymetrics.density)).put("offsetX", (int)((float)creativeRequiredResizeOffsetX / displaymetrics.density)).put("offsetY", (int)((float)creativeRequiredResizeOffsetY / displaymetrics.density)).put("customClosePosition", customClosePosition).put("allowOffscreen", allowOffscreen);
        }
        jsonobject1.put("width", (int)((float)getAppWidth() / displaymetrics.density)).put("height", (int)((float)getAppHeight() / displaymetrics.density));
        jsonobject2.put("width", (int)((float)getScreenWidth() / displaymetrics.density)).put("height", (int)((float)getScreenHeight() / displaymetrics.density));
        ai = new int[2];
        getAppView().getLocationOnScreen(ai);
        int ai1[] = new int[4];
        presentation.getDefaultPositionOnScreen(ai1);
        jsonobject3.put("x", (int)((float)(ai1[0] - ai[0]) / displaymetrics.density)).put("y", (int)((float)(ai1[1] - ai[1]) / displaymetrics.density)).put("width", (int)((float)ai1[2] / displaymetrics.density)).put("height", (int)((float)ai1[3] / displaymetrics.density));
        mraidwebview = presentation.getCurrentView();
        if (mraidwebview == null)
        {
            break MISSING_BLOCK_LABEL_669;
        }
        try
        {
            int ai2[] = new int[2];
            mraidwebview.getLocationOnScreen(ai2);
            jsonobject4.put("x", (int)((float)(ai2[0] - ai[0]) / displaymetrics.density)).put("y", (int)((float)(ai2[1] - ai[1]) / displaymetrics.density)).put("width", (int)((float)mraidwebview.getWidth() / displaymetrics.density)).put("height", (int)((float)mraidwebview.getHeight() / displaymetrics.density));
        }
        catch (JSONException jsonexception)
        {
            logger.error((new StringBuilder()).append(MRAIDTAG()).append(" error in sync MRAID state ").append(jsonexception.getMessage()).toString());
        }
        obj = String.format("window.mraid._Update('%s', %s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s);", new Object[] {
            getPrintableState(), Boolean.valueOf(isViewable), placementType, obj, jsonobject, jsonobject1, jsonobject2, jsonobject3, jsonobject4, Boolean.valueOf(flag)
        });
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" synchStateToPresentation(script='").append(((String) (obj))).append("'").toString());
        presentation.runJavaScript(((String) (obj)));
        return;
        jsonobject4.put("x", 0).put("y", 0).put("width", 0).put("height", 0);
        break MISSING_BLOCK_LABEL_543;
    }

    private int expandHeight()
    {
        if (creativeRequiredExpandHeight > 0 && creativeRequiredExpandHeight < getScreenHeight())
        {
            return creativeRequiredExpandHeight;
        } else
        {
            return getScreenHeight();
        }
    }

    private int expandWidth()
    {
        if (creativeRequiredExpandWidth > 0 && creativeRequiredExpandWidth < getScreenWidth())
        {
            return creativeRequiredExpandWidth;
        } else
        {
            return getScreenWidth();
        }
    }

    private void failWithError(String s, String s1)
    {
        logger.error((new StringBuilder()).append(CLASSTAG()).append(" failWithError errorCode:").append(s).append(", errorMessage:").append(s1).toString());
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), s);
        bundle.putString(constants.INFO_KEY_ERROR_INFO(), s1);
        s = new HashMap();
        s.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), s);
    }

    private int getAppHeight()
    {
        return getAppView().getHeight();
    }

    private View getAppView()
    {
        return activity.getWindow().findViewById(0x1020002);
    }

    private int getAppWidth()
    {
        return getAppView().getWidth();
    }

    private String getPrintableState()
    {
        return getPrintableState(state);
    }

    private String getPrintableState(MRAIDState mraidstate)
    {
        static class _cls15
        {

            static final int $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[];

            static 
            {
                $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState = new int[MRAIDState.values().length];
                try
                {
                    $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[MRAIDState.LOADING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[MRAIDState.DEFAULT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[MRAIDState.EXPANDED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[MRAIDState.RESIZED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$tv$freewheel$renderers$html$HTMLRenderer$MRAIDState[MRAIDState.HIDDEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls15..SwitchMap.tv.freewheel.renderers.html.HTMLRenderer.MRAIDState[mraidstate.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return "loading";

        case 2: // '\002'
            return "default";

        case 3: // '\003'
            return "expanded";

        case 4: // '\004'
            return "resized";

        case 5: // '\005'
            return "hidden";
        }
    }

    private String getPrintableTimePositionClass()
    {
        if (slot == null)
        {
            return "";
        }
        int j = slot.getTimePositionClass();
        int ai[] = new int[5];
        ai[0] = constants.TIME_POSITION_CLASS_DISPLAY();
        ai[1] = constants.TIME_POSITION_CLASS_OVERLAY();
        ai[2] = constants.TIME_POSITION_CLASS_PREROLL();
        ai[3] = constants.TIME_POSITION_CLASS_MIDROLL();
        ai[4] = constants.TIME_POSITION_CLASS_POSTROLL();
        for (int i = 0; i < ai.length; i++)
        {
            if (ai[i] == j)
            {
                return (new String[] {
                    "display", "overlay", "preroll", "midroll", "postroll"
                })[i];
            }
        }

        return "";
    }

    private int getScreenHeight()
    {
        return activity.getResources().getDisplayMetrics().heightPixels;
    }

    private int getScreenWidth()
    {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    private boolean isInState(MRAIDState mraidstate)
    {
        return state.equals(mraidstate);
    }

    public static boolean isIntentAvailable(Context context, Intent intent)
    {
        return !context.getPackageManager().queryIntentActivities(intent, 0x10000).isEmpty();
    }

    private void pingBack(String s)
    {
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" pingBack(").append(s).append(")").toString());
        if (!isInterstitial)
        {
            rendererContext.dispatchEvent(s);
        }
    }

    private void setMraidFeatures()
    {
        String s = (new StringBuilder()).append("window.mraid._setSupportingFeatures(").append(isIntentAvailable(activity, new Intent("android.intent.action.VIEW", Uri.parse("sms:")))).append(", ").append(isIntentAvailable(activity, new Intent("android.intent.action.VIEW", Uri.parse("tel:")))).append(", ").append("false, ").append("false, ").append(presentation.supportsInlineVideo()).append(");").toString();
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" setMraidFeatures(script='").append(s).append("'").toString());
        presentation.runJavaScript(s);
    }

    private void transferTo(MRAIDState mraidstate)
    {
        boolean flag2;
        flag2 = false;
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" transferTo:").append(getPrintableState(mraidstate)).toString());
        if (!isInState(mraidstate) || isInState(MRAIDState.RESIZED)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        boolean flag1;
        flag1 = true;
        if (!mraidstate.equals(MRAIDState.EXPANDED))
        {
            break; /* Loop/switch isn't completed */
        }
        if (rendererTimer != null)
        {
            rendererTimer.pause();
        }
        if (shouldPauseResumeMainVideoWhenExpand)
        {
            rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_PAUSE());
        }
        String s;
        IMRAIDPresentation imraidpresentation;
        if (expandURL == null)
        {
            pingBack(constants.EVENT_AD_EXPAND());
        } else
        {
            pingBack(constants.EVENT_AD_ACCEPT_INVITATION());
        }
        if (expandURL == null)
        {
            s = null;
        } else
        {
            s = presentation.getAbsoluteURL(expandURL);
        }
        imraidpresentation = presentation;
        if (!isUseCustomClose)
        {
            flag2 = true;
        }
        imraidpresentation.setCloseButtonVisibility(flag2);
        presentation.expand(s, expandWidth(), expandHeight());
        flag = flag1;
_L4:
        if (flag && !isInterstitial)
        {
            state = mraidstate;
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (mraidstate.equals(MRAIDState.DEFAULT))
        {
            if (isInState(MRAIDState.LOADING))
            {
                setMraidFeatures();
                if (rendererTimer != null)
                {
                    rendererTimer.start();
                }
                state = mraidstate;
                _synchStateToPresentation(false);
                return;
            }
            if (isInState(MRAIDState.EXPANDED))
            {
                if (shouldPauseResumeMainVideoWhenExpand)
                {
                    rendererContext.dispatchEvent(constants.EVENT_REQUEST_CONTENT_VIDEO_RESUME());
                }
                if (rendererTimer != null)
                {
                    rendererTimer.resume();
                }
                if (expandURL == null)
                {
                    pingBack(constants.EVENT_AD_COLLAPSE());
                    presentation.collapse();
                    flag = flag1;
                } else
                {
                    pingBack(constants.EVENT_AD_CLOSE());
                    presentation.close();
                    flag = flag1;
                }
            } else
            if (isInState(MRAIDState.RESIZED))
            {
                presentation.close();
                flag = flag1;
            } else
            {
                flag = false;
                logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" Invalid transfer").toString());
            }
        } else
        if (mraidstate.equals(MRAIDState.HIDDEN))
        {
            if (rendererTimer != null)
            {
                rendererTimer.stop();
            }
            if (!isInState(MRAIDState.LOADING) || showedPresentation)
            {
                presentation.close();
            }
            presentation.dispose();
            rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
            flag = flag1;
            if (isInState(MRAIDState.LOADING))
            {
                flag = flag1;
                if (isInterstitial)
                {
                    state = mraidstate;
                    return;
                }
            }
        } else
        if (mraidstate.equals(MRAIDState.RESIZED))
        {
            if (isInState(MRAIDState.EXPANDED))
            {
                dispatchMraidError("resize called in expanded state", "resize");
                flag = false;
            } else
            if (isInState(MRAIDState.RESIZED) || isInState(MRAIDState.DEFAULT))
            {
                presentation.resize(creativeRequiredResizeOffsetX, creativeRequiredResizeOffsetY, creativeRequiredResizeWidth, creativeRequiredResizeHeight, customClosePosition, allowOffscreen);
                flag = flag1;
            } else
            {
                flag = false;
                logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" resize called in ").append(getPrintableState()).append(" state, no effect").toString());
            }
        } else
        {
            flag = false;
            logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" Invalid transfer").toString());
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void dispatchMraidError(String s, String s1)
    {
        logger.debug((new StringBuilder()).append(MRAIDTAG()).append(" Dispatch MRAID error (").append(s).append(", ").append(s1).append(")").toString());
        s = (new StringBuilder()).append("window.mraid.dispatchEvent('error', '").append(s).append("', '").append(s1).append("');").toString();
        presentation.runJavaScript(s);
    }

    public void dispose()
    {
        logger.info((new StringBuilder()).append(CLASSTAG()).append(" dispose").toString());
        stop();
    }

    public double getDuration()
    {
        return duration;
    }

    public void load(final IRendererContext rendererContextFinalRef)
    {
        rendererContextFinalRef.getActivity().runOnUiThread(new Runnable() {

            final HTMLRenderer this$0;
            final IRendererContext val$rendererContextFinalRef;

            public void run()
            {
                _load(rendererContextFinalRef);
            }

            
            {
                this$0 = HTMLRenderer.this;
                rendererContextFinalRef = irenderercontext;
                super();
            }
        });
    }

    public void mraidClose()
    {
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;

            public void run()
            {
                _close();
            }

            
            {
                this$0 = HTMLRenderer.this;
                super();
            }
        });
    }

    public void mraidLoadFail(final int errorCode, final String description)
    {
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;
            final String val$description;
            final int val$errorCode;

            public void run()
            {
                _loadFail(errorCode, description);
            }

            
            {
                this$0 = HTMLRenderer.this;
                errorCode = i;
                description = s;
                super();
            }
        });
    }

    public void mraidLoaded()
    {
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;

            public void run()
            {
                _loaded();
            }

            
            {
                this$0 = HTMLRenderer.this;
                super();
            }
        });
    }

    public Parameters parameters()
    {
        return parameters;
    }

    public void playHeadTime(int i)
    {
        headTime.set(i);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        logger.debug((new StringBuilder()).append("shouldOverrideUrlLoading for url: ").append(s).toString());
        if (webview.getHitTestResult() != null && webview.getHitTestResult().getType() > 0 && !isMRAIDAd)
        {
            webview = new Bundle();
            webview.putString(constants.INFO_KEY_URL(), s);
            s = new HashMap();
            s.put(constants.INFO_KEY_EXTRA_INFO(), webview);
            rendererContext.dispatchEvent(constants.EVENT_AD_CLICK(), s);
            return true;
        } else
        {
            return false;
        }
    }

    public void start()
    {
        logger.info((new StringBuilder()).append(CLASSTAG()).append("start").toString());
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;

            public void run()
            {
                activityCallbackListener = new IActivityCallbackListener() {

                    final _cls3 this$1;

            
            {
                this$1 = _cls3.this;
                super();
            }
                };
                rendererContext.addOnActivityCallbackListener(activityCallbackListener);
                presentation.show();
                showedPresentation = true;
                rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
            }

            
            {
                this$0 = HTMLRenderer.this;
                super();
            }
        });
        if (rendererTimer != null && !isMRAIDAd)
        {
            rendererTimer.start();
        }
    }

    public void stop()
    {
        logger.info((new StringBuilder()).append(CLASSTAG()).append(" stop").toString());
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;

            public void run()
            {
                if (isInState(MRAIDState.EXPANDED) || isInState(MRAIDState.RESIZED))
                {
                    transferTo(MRAIDState.DEFAULT);
                }
                _stop();
            }

            
            {
                this$0 = HTMLRenderer.this;
                super();
            }
        });
    }

    public void synchStateToPresentation(final boolean isResized)
    {
        mainLoopHandler.post(new Runnable() {

            final HTMLRenderer this$0;
            final boolean val$isResized;

            public void run()
            {
                _synchStateToPresentation(isResized);
            }

            
            {
                this$0 = HTMLRenderer.this;
                isResized = flag;
                super();
            }
        });
    }

    public void timeOut()
    {
        stop();
    }






/*
    static boolean access$1402(HTMLRenderer htmlrenderer, boolean flag)
    {
        htmlrenderer.showedPresentation = flag;
        return flag;
    }

*/







/*
    static IActivityCallbackListener access$202(HTMLRenderer htmlrenderer, IActivityCallbackListener iactivitycallbacklistener)
    {
        htmlrenderer.activityCallbackListener = iactivitycallbacklistener;
        return iactivitycallbacklistener;
    }

*/




}
