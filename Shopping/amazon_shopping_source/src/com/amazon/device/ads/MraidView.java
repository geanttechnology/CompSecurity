// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.amazon.device.ads:
//            AdWebViewClient, AdView, MraidDisplayController, AndroidTargetUtils, 
//            Log, MraidProperty, MraidBrowserController, WebViewFactory, 
//            AdUtils, WebRequest, MraidPlacementTypeProperty, InternalAdRegistration, 
//            IInternalAdRegistration, DeviceInfo, MraidCommandRegistry, MraidCommand

class MraidView extends FrameLayout
{
    static final class ExpansionStyle extends Enum
    {

        private static final ExpansionStyle $VALUES[];
        public static final ExpansionStyle DISABLED;
        public static final ExpansionStyle ENABLED;

        public static ExpansionStyle valueOf(String s)
        {
            return (ExpansionStyle)Enum.valueOf(com/amazon/device/ads/MraidView$ExpansionStyle, s);
        }

        public static ExpansionStyle[] values()
        {
            return (ExpansionStyle[])$VALUES.clone();
        }

        static 
        {
            ENABLED = new ExpansionStyle("ENABLED", 0);
            DISABLED = new ExpansionStyle("DISABLED", 1);
            $VALUES = (new ExpansionStyle[] {
                ENABLED, DISABLED
            });
        }

        private ExpansionStyle(String s, int i)
        {
            super(s, i);
        }
    }

    class MraidExecutor
        implements AdWebViewClient.UrlExecutor
    {

        final MraidView this$0;

        public boolean execute(String s)
        {
            Object obj = URI.create(s);
            s = ((URI) (obj)).getHost();
            Object obj1 = URLEncodedUtils.parse(((URI) (obj)), "UTF-8");
            obj = new HashMap();
            NameValuePair namevaluepair;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj)).put(namevaluepair.getName(), namevaluepair.getValue()))
            {
                namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
            }

            obj = MraidCommandRegistry.createCommand(s, ((Map) (obj)), MraidView.this);
            if (obj == null)
            {
                fireNativeCommandCompleteEvent(s);
                return false;
            } else
            {
                ((MraidCommand) (obj)).execute();
                fireNativeCommandCompleteEvent(s);
                return true;
            }
        }

        MraidExecutor()
        {
            this$0 = MraidView.this;
            super();
        }
    }

    static class MraidListenerInfo
    {

        private OnCloseButtonStateChangeListener mOnCloseButtonListener;
        private OnCloseListener mOnCloseListener;
        private OnExpandListener mOnExpandListener;
        private OnFailureListener mOnFailureListener;
        private OnOpenListener mOnOpenListener;
        private OnReadyListener mOnReadyListener;
        private OnSpecialUrlClickListener mOnSpecialUrlClickListener;



/*
        static OnFailureListener access$002(MraidListenerInfo mraidlistenerinfo, OnFailureListener onfailurelistener)
        {
            mraidlistenerinfo.mOnFailureListener = onfailurelistener;
            return onfailurelistener;
        }

*/



/*
        static OnExpandListener access$102(MraidListenerInfo mraidlistenerinfo, OnExpandListener onexpandlistener)
        {
            mraidlistenerinfo.mOnExpandListener = onexpandlistener;
            return onexpandlistener;
        }

*/



/*
        static OnCloseListener access$202(MraidListenerInfo mraidlistenerinfo, OnCloseListener oncloselistener)
        {
            mraidlistenerinfo.mOnCloseListener = oncloselistener;
            return oncloselistener;
        }

*/



/*
        static OnReadyListener access$302(MraidListenerInfo mraidlistenerinfo, OnReadyListener onreadylistener)
        {
            mraidlistenerinfo.mOnReadyListener = onreadylistener;
            return onreadylistener;
        }

*/



/*
        static OnCloseButtonStateChangeListener access$402(MraidListenerInfo mraidlistenerinfo, OnCloseButtonStateChangeListener onclosebuttonstatechangelistener)
        {
            mraidlistenerinfo.mOnCloseButtonListener = onclosebuttonstatechangelistener;
            return onclosebuttonstatechangelistener;
        }

*/



/*
        static OnOpenListener access$502(MraidListenerInfo mraidlistenerinfo, OnOpenListener onopenlistener)
        {
            mraidlistenerinfo.mOnOpenListener = onopenlistener;
            return onopenlistener;
        }

*/



/*
        static OnSpecialUrlClickListener access$602(MraidListenerInfo mraidlistenerinfo, OnSpecialUrlClickListener onspecialurlclicklistener)
        {
            mraidlistenerinfo.mOnSpecialUrlClickListener = onspecialurlclicklistener;
            return onspecialurlclicklistener;
        }

*/

        MraidListenerInfo()
        {
        }
    }

    protected class MraidWebChromeClient extends WebChromeClient
    {

        final MraidView this$0;

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            Log.d(MraidView.LOGTAG, s1);
            return false;
        }

        protected MraidWebChromeClient()
        {
            this$0 = MraidView.this;
            super();
        }
    }

    static final class NativeCloseButtonStyle extends Enum
    {

        private static final NativeCloseButtonStyle $VALUES[];
        public static final NativeCloseButtonStyle AD_CONTROLLED;
        public static final NativeCloseButtonStyle ALWAYS_HIDDEN;
        public static final NativeCloseButtonStyle ALWAYS_VISIBLE;

        public static NativeCloseButtonStyle valueOf(String s)
        {
            return (NativeCloseButtonStyle)Enum.valueOf(com/amazon/device/ads/MraidView$NativeCloseButtonStyle, s);
        }

        public static NativeCloseButtonStyle[] values()
        {
            return (NativeCloseButtonStyle[])$VALUES.clone();
        }

        static 
        {
            ALWAYS_VISIBLE = new NativeCloseButtonStyle("ALWAYS_VISIBLE", 0);
            ALWAYS_HIDDEN = new NativeCloseButtonStyle("ALWAYS_HIDDEN", 1);
            AD_CONTROLLED = new NativeCloseButtonStyle("AD_CONTROLLED", 2);
            $VALUES = (new NativeCloseButtonStyle[] {
                ALWAYS_VISIBLE, ALWAYS_HIDDEN, AD_CONTROLLED
            });
        }

        private NativeCloseButtonStyle(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnCloseButtonStateChangeListener
    {

        public abstract void onCloseButtonStateChange(MraidView mraidview, boolean flag);
    }

    public static interface OnCloseListener
    {

        public abstract void onClose(MraidView mraidview, ViewState viewstate);
    }

    public static interface OnExpandListener
    {

        public abstract void onExpand(MraidView mraidview);
    }

    public static interface OnFailureListener
    {

        public abstract void onFailure(MraidView mraidview);
    }

    public static interface OnOpenListener
    {

        public abstract void onOpen(MraidView mraidview);
    }

    public static interface OnReadyListener
    {

        public abstract void onReady(MraidView mraidview);
    }

    public static interface OnSpecialUrlClickListener
    {

        public abstract void onSpecialUrlClick(MraidView mraidview, String s);
    }

    static final class PlacementType extends Enum
    {

        private static final PlacementType $VALUES[];
        public static final PlacementType INLINE;
        public static final PlacementType INTERSTITIAL;

        public static PlacementType valueOf(String s)
        {
            return (PlacementType)Enum.valueOf(com/amazon/device/ads/MraidView$PlacementType, s);
        }

        public static PlacementType[] values()
        {
            return (PlacementType[])$VALUES.clone();
        }

        static 
        {
            INLINE = new PlacementType("INLINE", 0);
            INTERSTITIAL = new PlacementType("INTERSTITIAL", 1);
            $VALUES = (new PlacementType[] {
                INLINE, INTERSTITIAL
            });
        }

        private PlacementType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ViewState extends Enum
    {

        private static final ViewState $VALUES[];
        public static final ViewState DEFAULT;
        public static final ViewState EXPANDED;
        public static final ViewState HIDDEN;
        public static final ViewState LOADING;

        public static ViewState valueOf(String s)
        {
            return (ViewState)Enum.valueOf(com/amazon/device/ads/MraidView$ViewState, s);
        }

        public static ViewState[] values()
        {
            return (ViewState[])$VALUES.clone();
        }

        static 
        {
            LOADING = new ViewState("LOADING", 0);
            DEFAULT = new ViewState("DEFAULT", 1);
            EXPANDED = new ViewState("EXPANDED", 2);
            HIDDEN = new ViewState("HIDDEN", 3);
            $VALUES = (new ViewState[] {
                LOADING, DEFAULT, EXPANDED, HIDDEN
            });
        }

        private ViewState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String JAVASCRIPT_TEXT = "(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent('ready')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent('change',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent('error',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call='mraid://'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+='?';isFirstArgument=false}else{call+='&'}call+=key+'='+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION='1.0';var STATES=mraid.STATES={LOADING:'loading',DEFAULT:'default',EXPANDED:'expanded',HIDDEN:'hidden',};var EVENTS=mraid.EVENTS={ERROR:'error',INFO:'info',READY:'ready',STATECHANGE:'stateChange',VIEWABLECHANGE:'viewableChange'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:'unknown',INLINE:'inline',INTERSTITIAL:'interstitial'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,':'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push('|',id,'|')}return out.join('')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj==='object'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return'['+out.join(',')+']'}else{for(var p in obj)out.push(\"'\"+p+\"': \"+obj[p]);return'{'+out.join(',')+'}'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,'')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,'Native SDK initialized.')}state=val;broadcastEvent(EVENTS.INFO,'Set state to '+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,'Set isViewable to '+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,'Set placementType to '+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,'Set screenSize to '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties['width']=screenSize['width'];expandProperties['height']=screenSize['height']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,'Merging expandProperties with '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,'Required object not provided.',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,'Object is missing required property: '+i+'.',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,'Value of property '+prop+' is invalid.',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v==='boolean')},lockOrientation:function(v){return(typeof v==='boolean')}};bridge.addEventListener('change',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener('error',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener('ready',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,'Both event and listener are required.','addEventListener')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,'Unknown MRAID event: '+event,'addEventListener')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,'Ad cannot be closed when it is already hidden.','close')}else bridge.executeNativeCall('close')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=['playVideo'];if(URL){args=args.concat(['url',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle='normal',stopStyle='normal';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle='normal';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle='exit'}if(position[0]==-1||position[1]==-1){startStyle='fullscreen';autoPlay=true}args=args.concat(['audioMuted',audioMuted]);args=args.concat(['autoPlay',autoPlay]);args=args.concat(['controls',controls]);args=args.concat(['loop',loop]);args=args.concat(['position',position]);args=args.concat(['startStyle',startStyle]);args=args.concat(['stopStyle',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=['log','level',level,'log',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,'Ad can only be expanded from the default state.','expand')}else{var args=['expand'];if(hasSetCustomClose){args=args.concat(['shouldUseCustomClose',expandProperties.useCustomClose?'true':'false'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat(['w',expandProperties.width,'h',expandProperties.height])}}if(typeof expandProperties.lockOrientation!=='undefined'){args=args.concat(['lockOrientation',expandProperties.lockOrientation])}if(URL){args=args.concat(['url',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,'URL is required.','open');else bridge.executeNativeCall('open','url',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,'Event is required.','removeEventListener');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,'Listener not currently registered for event.','removeEventListener');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,'setExpandProperties',true)){if(properties.hasOwnProperty('width')||properties.hasOwnProperty('height')){hasSetCustomSize=true}if(properties.hasOwnProperty('useCustomClose'))hasSetCustomClose=true;var desiredProperties=['width','height','useCustomClose','lockOrientation'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall('usecustomclose','shouldUseCustomClose',shouldUseCustomClose)}}());";
    private static final String LOGTAG = com/amazon/device/ads/MraidView.getSimpleName();
    private static HashMap mraidViewCache;
    protected AdView adView;
    private Context context_;
    private boolean mAttached;
    private MraidBrowserController mBrowserController;
    private MraidDisplayController mDisplayController;
    private boolean mGoingAway;
    private boolean mHasFiredReadyEvent;
    private int mLastVisibility;
    private MraidListenerInfo mListenerInfo;
    private final PlacementType mPlacementType;
    private WebChromeClient mWebChromeClient;
    private WebViewClient mWebViewClient;
    protected double scalingMultiplier_;
    protected boolean shouldForceRenderFailure;
    private WebView webView_;
    private int windowHeight_;
    private int windowWidth_;

    public MraidView(AdView adview, int i, int j, double d, Context context, WebView webview)
    {
        this(adview, i, j, d, context, webview, ExpansionStyle.ENABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INLINE);
    }

    MraidView(AdView adview, int i, int j, double d, Context context, WebView webview, 
            ExpansionStyle expansionstyle, NativeCloseButtonStyle nativeclosebuttonstyle, PlacementType placementtype)
    {
        super(context);
        mAttached = false;
        mLastVisibility = 8;
        shouldForceRenderFailure = false;
        mGoingAway = false;
        adView = adview;
        mPlacementType = placementtype;
        windowHeight_ = j;
        windowWidth_ = i;
        scalingMultiplier_ = d;
        context_ = context;
        webView_ = webview;
        setWebViewHeightToAdHeight();
        addView(webView_);
        if (android.os.Build.VERSION.SDK_INT >= 11 && shouldDisableWebViewHardwareAcceleration())
        {
            disableHardwareAcceleration();
        }
        initialize(expansionstyle, nativeclosebuttonstyle);
    }

    public MraidView(AdView adview, Context context, WebView webview)
    {
        this(adview, 0, 0, 0.0D, context, webview, ExpansionStyle.DISABLED, NativeCloseButtonStyle.ALWAYS_HIDDEN, PlacementType.INLINE);
    }

    public static void cacheMraidView(String s, MraidView mraidview)
    {
        getMraidViewCache().put(s, mraidview);
    }

    public static MraidView getCachedMraidView(String s)
    {
        return (MraidView)getMraidViewCache().get(s);
    }

    static HashMap getMraidViewCache()
    {
        if (mraidViewCache == null)
        {
            mraidViewCache = new HashMap();
        }
        return mraidViewCache;
    }

    private void notifyOnFailureListener()
    {
        if (mListenerInfo.mOnFailureListener != null)
        {
            mListenerInfo.mOnFailureListener.onFailure(this);
        }
    }

    public static MraidView removeCachedMraidView(String s)
    {
        return (MraidView)getMraidViewCache().remove(s);
    }

    private void setupAdWebViewClient()
    {
        AdWebViewClient adwebviewclient = new AdWebViewClient(adView, context_);
        adwebviewclient.putUrlExecutor("mraid", createMraidExecutor());
        adwebviewclient.putUrlExecutor("amazonmobile", adView.getSpecialUrlExecutor());
        mWebViewClient = adwebviewclient;
        setWebViewsWebViewClient(mWebViewClient);
    }

    protected MraidExecutor createMraidExecutor()
    {
        return new MraidExecutor();
    }

    public void destroy()
    {
        mDisplayController.destroy();
        removeView(webView_);
        webView_.destroy();
    }

    protected void disableHardwareAcceleration()
    {
        AndroidTargetUtils.disableHardwareAcceleration(this);
    }

    protected void fireChangeEventForProperties(ArrayList arraylist)
    {
        arraylist = arraylist.toString();
        if (arraylist.length() < 2)
        {
            return;
        } else
        {
            arraylist = (new StringBuilder()).append("{").append(arraylist.substring(1, arraylist.length() - 1)).append("}").toString();
            injectJavaScript((new StringBuilder()).append("window.mraidbridge.fireChangeEvent(").append(arraylist).append(");").toString());
            Log.d(LOGTAG, "Fire changes: %s", new Object[] {
                arraylist
            });
            return;
        }
    }

    protected void fireChangeEventForProperty(MraidProperty mraidproperty)
    {
        mraidproperty = (new StringBuilder()).append("{").append(mraidproperty.toString()).append("}").toString();
        injectJavaScript((new StringBuilder()).append("window.mraidbridge.fireChangeEvent(").append(mraidproperty).append(");").toString());
        Log.d(LOGTAG, "Fire change: %s", new Object[] {
            mraidproperty
        });
    }

    protected void fireErrorEvent(String s, String s1)
    {
        injectJavaScript((new StringBuilder()).append("window.mraidbridge.fireErrorEvent('").append(s).append("', '").append(s1).append("');").toString());
    }

    protected void fireNativeCommandCompleteEvent(String s)
    {
        injectJavaScript((new StringBuilder()).append("window.mraidbridge.nativeCallComplete('").append(s).append("');").toString());
    }

    protected void fireReadyEvent()
    {
        injectJavaScript("window.mraidbridge.fireReadyEvent();");
    }

    protected AdView getAdView()
    {
        return adView;
    }

    protected MraidBrowserController getBrowserController()
    {
        return mBrowserController;
    }

    protected MraidDisplayController getDisplayController()
    {
        return mDisplayController;
    }

    public OnCloseButtonStateChangeListener getOnCloseButtonStateChangeListener()
    {
        return mListenerInfo.mOnCloseButtonListener;
    }

    public OnCloseListener getOnCloseListener()
    {
        return mListenerInfo.mOnCloseListener;
    }

    public OnExpandListener getOnExpandListener()
    {
        return mListenerInfo.mOnExpandListener;
    }

    public OnFailureListener getOnFailureListener()
    {
        return mListenerInfo.mOnFailureListener;
    }

    public OnOpenListener getOnOpenListener()
    {
        return mListenerInfo.mOnOpenListener;
    }

    public OnReadyListener getOnReadyListener()
    {
        return mListenerInfo.mOnReadyListener;
    }

    public OnSpecialUrlClickListener getOnSpecialUrlClickListener()
    {
        return mListenerInfo.mOnSpecialUrlClickListener;
    }

    protected double getScalingMultiplier()
    {
        return scalingMultiplier_;
    }

    public boolean getShouldForceRenderFailure()
    {
        return shouldForceRenderFailure;
    }

    public WebView getWebView()
    {
        return webView_;
    }

    protected int getWindowHeight()
    {
        return windowHeight_;
    }

    protected int getWindowWidth()
    {
        return windowWidth_;
    }

    protected void initialize(ExpansionStyle expansionstyle, NativeCloseButtonStyle nativeclosebuttonstyle)
    {
        boolean flag = true;
        mBrowserController = new MraidBrowserController(this);
        mDisplayController = new MraidDisplayController(this, expansionstyle, nativeclosebuttonstyle);
        webView_.setScrollContainer(false);
        webView_.setBackgroundColor(0);
        webView_.setVerticalScrollBarEnabled(false);
        webView_.setHorizontalScrollBarEnabled(false);
        if (WebViewFactory.setJavaScriptEnabledForWebView(true, webView_, LOGTAG))
        {
            flag = false;
        }
        shouldForceRenderFailure = flag;
        setupAdWebViewClient();
        mWebChromeClient = new MraidWebChromeClient();
        webView_.setWebChromeClient(mWebChromeClient);
        mListenerInfo = new MraidListenerInfo();
    }

    protected void injectJavaScript(String s)
    {
        if (s != null)
        {
            webView_.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    public boolean loadHtmlData(String s)
    {
        return loadHtmlData(null, s);
    }

    public boolean loadHtmlData(String s, String s1)
    {
        String s2 = s1;
        if (s1.indexOf("<html>") == -1)
        {
            s2 = (new StringBuilder()).append("<html><meta name=\"viewport\" content=\"width=").append(windowWidth_).append(", height=").append(windowHeight_).append(", initial-scale=").append(AdUtils.getViewportInitialScale(scalingMultiplier_)).append(", minimum-scale=").append(scalingMultiplier_).append(", maximum-scale=").append(scalingMultiplier_).append("\"/>").append("<head></head><body style='margin:0;padding:0;'>").append(s1).append("</body></html>").toString();
        }
        s1 = s2.replace("<head>", "<head><script type='text/javascript'>(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent('ready')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent('change',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent('error',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call='mraid://'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+='?';isFirstArgument=false}else{call+='&'}call+=key+'='+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION='1.0';var STATES=mraid.STATES={LOADING:'loading',DEFAULT:'default',EXPANDED:'expanded',HIDDEN:'hidden',};var EVENTS=mraid.EVENTS={ERROR:'error',INFO:'info',READY:'ready',STATECHANGE:'stateChange',VIEWABLECHANGE:'viewableChange'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:'unknown',INLINE:'inline',INTERSTITIAL:'interstitial'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,':'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push('|',id,'|')}return out.join('')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj==='object'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return'['+out.join(',')+']'}else{for(var p in obj)out.push(\"'\"+p+\"': \"+obj[p]);return'{'+out.join(',')+'}'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,'')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,'Native SDK initialized.')}state=val;broadcastEvent(EVENTS.INFO,'Set state to '+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,'Set isViewable to '+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,'Set placementType to '+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,'Set screenSize to '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties['width']=screenSize['width'];expandProperties['height']=screenSize['height']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,'Merging expandProperties with '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,'Required object not provided.',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,'Object is missing required property: '+i+'.',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,'Value of property '+prop+' is invalid.',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v==='boolean')},lockOrientation:function(v){return(typeof v==='boolean')}};bridge.addEventListener('change',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener('error',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener('ready',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,'Both event and listener are required.','addEventListener')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,'Unknown MRAID event: '+event,'addEventListener')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,'Ad cannot be closed when it is already hidden.','close')}else bridge.executeNativeCall('close')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=['playVideo'];if(URL){args=args.concat(['url',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle='normal',stopStyle='normal';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle='normal';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle='exit'}if(position[0]==-1||position[1]==-1){startStyle='fullscreen';autoPlay=true}args=args.concat(['audioMuted',audioMuted]);args=args.concat(['autoPlay',autoPlay]);args=args.concat(['controls',controls]);args=args.concat(['loop',loop]);args=args.concat(['position',position]);args=args.concat(['startStyle',startStyle]);args=args.concat(['stopStyle',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=['log','level',level,'log',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,'Ad can only be expanded from the default state.','expand')}else{var args=['expand'];if(hasSetCustomClose){args=args.concat(['shouldUseCustomClose',expandProperties.useCustomClose?'true':'false'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat(['w',expandProperties.width,'h',expandProperties.height])}}if(typeof expandProperties.lockOrientation!=='undefined'){args=args.concat(['lockOrientation',expandProperties.lockOrientation])}if(URL){args=args.concat(['url',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,'URL is required.','open');else bridge.executeNativeCall('open','url',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,'Event is required.','removeEventListener');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,'Listener not currently registered for event.','removeEventListener');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,'setExpandProperties',true)){if(properties.hasOwnProperty('width')||properties.hasOwnProperty('height')){hasSetCustomSize=true}if(properties.hasOwnProperty('useCustomClose'))hasSetCustomClose=true;var desiredProperties=['width','height','useCustomClose','lockOrientation'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall('usecustomclose','shouldUseCustomClose',shouldUseCustomClose)}}());</script>");
        webView_.loadDataWithBaseURL(s, s1, "text/html", "UTF-8", null);
        return true;
    }

    public void loadUrlForTwoPartExpansionView(String s)
    {
        WebRequest webrequest = WebRequest.createNewWebRequest();
        webrequest.setUrlString(s);
        try
        {
            s = webrequest.makeCall();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            notifyOnFailureListener();
            return;
        }
        loadHtmlData(s.getBody());
    }

    protected void onAttachedToWindow()
    {
        if (!mGoingAway)
        {
            super.onAttachedToWindow();
            mAttached = true;
            if (mDisplayController != null)
            {
                mDisplayController.registerReceivers();
                return;
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAttached = false;
        if (mDisplayController != null)
        {
            mDisplayController.unregisterReceivers();
        }
    }

    protected void onPageFinished()
    {
        if (!mHasFiredReadyEvent)
        {
            mDisplayController.initializeJavaScriptState();
            fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(mPlacementType));
            fireReadyEvent();
            if (getOnReadyListener() != null)
            {
                getOnReadyListener().onReady(this);
            }
            mHasFiredReadyEvent = true;
            mDisplayController.surfaceAd();
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        if (mAttached && mLastVisibility != i && i != 0 && mDisplayController != null)
        {
            mDisplayController.unregisterReceivers();
        }
    }

    public void prepareToGoAway()
    {
        mGoingAway = true;
        if (mDisplayController != null)
        {
            mDisplayController.detachExpandedView();
        }
    }

    public void registerReceivers()
    {
        mDisplayController.registerReceivers();
    }

    public void setAdView(AdView adview)
    {
        adView = adview;
        setWebViewHeightToAdHeight();
        setupAdWebViewClient();
    }

    protected void setMraidBrowserController(MraidBrowserController mraidbrowsercontroller)
    {
        mBrowserController = mraidbrowsercontroller;
    }

    protected void setMraidDisplayController(MraidDisplayController mraiddisplaycontroller)
    {
        mDisplayController = mraiddisplaycontroller;
    }

    protected void setMraidListenerInfo(MraidListenerInfo mraidlistenerinfo)
    {
        mListenerInfo = mraidlistenerinfo;
    }

    public void setOnCloseButtonStateChange(OnCloseButtonStateChangeListener onclosebuttonstatechangelistener)
    {
        mListenerInfo.mOnCloseButtonListener = onclosebuttonstatechangelistener;
    }

    public void setOnCloseListener(OnCloseListener oncloselistener)
    {
        mListenerInfo.mOnCloseListener = oncloselistener;
    }

    public void setOnExpandListener(OnExpandListener onexpandlistener)
    {
        mListenerInfo.mOnExpandListener = onexpandlistener;
    }

    public void setOnFailureListener(OnFailureListener onfailurelistener)
    {
        mListenerInfo.mOnFailureListener = onfailurelistener;
    }

    public void setOnOpenListener(OnOpenListener onopenlistener)
    {
        mListenerInfo.mOnOpenListener = onopenlistener;
    }

    public void setOnReadyListener(OnReadyListener onreadylistener)
    {
        mListenerInfo.mOnReadyListener = onreadylistener;
    }

    public void setOnSpecialUrlClickListener(OnSpecialUrlClickListener onspecialurlclicklistener)
    {
        mListenerInfo.mOnSpecialUrlClickListener = onspecialurlclicklistener;
    }

    protected void setWebChromeClient(WebChromeClient webchromeclient)
    {
        mWebChromeClient = webchromeclient;
    }

    protected void setWebViewClient(WebViewClient webviewclient)
    {
        mWebViewClient = webviewclient;
    }

    protected void setWebViewHeightToAdHeight()
    {
        int i = (int)((double)adView.getHeight() * scalingMultiplier_ * (double)InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat());
        if (i > 0)
        {
            setWebViewLayoutParams(-1, i);
        }
    }

    protected void setWebViewLayoutParams(int i, int j)
    {
        webView_.setLayoutParams(new android.widget.FrameLayout.LayoutParams(i, j));
    }

    protected void setWebViewsWebViewClient(WebViewClient webviewclient)
    {
        webView_.setWebViewClient(webviewclient);
    }

    public boolean shouldDisableWebViewHardwareAcceleration()
    {
        return adView.shouldDisableWebViewHardwareAcceleration();
    }

    public void unregisterReceivers()
    {
        mDisplayController.unregisterReceivers();
    }


}
