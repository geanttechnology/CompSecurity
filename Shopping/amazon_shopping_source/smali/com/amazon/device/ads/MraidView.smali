.class Lcom/amazon/device/ads/MraidView;
.super Landroid/widget/FrameLayout;
.source "MraidView.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ViewConstructor"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/MraidView$MraidExecutor;,
        Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;,
        Lcom/amazon/device/ads/MraidView$OnOpenListener;,
        Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;,
        Lcom/amazon/device/ads/MraidView$OnFailureListener;,
        Lcom/amazon/device/ads/MraidView$OnReadyListener;,
        Lcom/amazon/device/ads/MraidView$OnCloseListener;,
        Lcom/amazon/device/ads/MraidView$OnExpandListener;,
        Lcom/amazon/device/ads/MraidView$MraidWebChromeClient;,
        Lcom/amazon/device/ads/MraidView$PlacementType;,
        Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;,
        Lcom/amazon/device/ads/MraidView$ExpansionStyle;,
        Lcom/amazon/device/ads/MraidView$ViewState;,
        Lcom/amazon/device/ads/MraidView$MraidListenerInfo;
    }
.end annotation


# static fields
.field private static final JAVASCRIPT_TEXT:Ljava/lang/String; = "(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent(\'ready\')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent(\'change\',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent(\'error\',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call=\'mraid://\'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+=\'?\';isFirstArgument=false}else{call+=\'&\'}call+=key+\'=\'+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION=\'1.0\';var STATES=mraid.STATES={LOADING:\'loading\',DEFAULT:\'default\',EXPANDED:\'expanded\',HIDDEN:\'hidden\',};var EVENTS=mraid.EVENTS={ERROR:\'error\',INFO:\'info\',READY:\'ready\',STATECHANGE:\'stateChange\',VIEWABLECHANGE:\'viewableChange\'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:\'unknown\',INLINE:\'inline\',INTERSTITIAL:\'interstitial\'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,\':\'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push(\'|\',id,\'|\')}return out.join(\'\')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj===\'object\'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return\'[\'+out.join(\',\')+\']\'}else{for(var p in obj)out.push(\"\'\"+p+\"\': \"+obj[p]);return\'{\'+out.join(\',\')+\'}\'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,\'\')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,\'Native SDK initialized.\')}state=val;broadcastEvent(EVENTS.INFO,\'Set state to \'+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,\'Set isViewable to \'+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,\'Set placementType to \'+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,\'Set screenSize to \'+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties[\'width\']=screenSize[\'width\'];expandProperties[\'height\']=screenSize[\'height\']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,\'Merging expandProperties with \'+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,\'Required object not provided.\',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,\'Object is missing required property: \'+i+\'.\',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,\'Value of property \'+prop+\' is invalid.\',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v===\'boolean\')},lockOrientation:function(v){return(typeof v===\'boolean\')}};bridge.addEventListener(\'change\',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener(\'error\',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener(\'ready\',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,\'Both event and listener are required.\',\'addEventListener\')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,\'Unknown MRAID event: \'+event,\'addEventListener\')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,\'Ad cannot be closed when it is already hidden.\',\'close\')}else bridge.executeNativeCall(\'close\')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=[\'playVideo\'];if(URL){args=args.concat([\'url\',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle=\'normal\',stopStyle=\'normal\';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle=\'normal\';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle=\'exit\'}if(position[0]==-1||position[1]==-1){startStyle=\'fullscreen\';autoPlay=true}args=args.concat([\'audioMuted\',audioMuted]);args=args.concat([\'autoPlay\',autoPlay]);args=args.concat([\'controls\',controls]);args=args.concat([\'loop\',loop]);args=args.concat([\'position\',position]);args=args.concat([\'startStyle\',startStyle]);args=args.concat([\'stopStyle\',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=[\'log\',\'level\',level,\'log\',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,\'Ad can only be expanded from the default state.\',\'expand\')}else{var args=[\'expand\'];if(hasSetCustomClose){args=args.concat([\'shouldUseCustomClose\',expandProperties.useCustomClose?\'true\':\'false\'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat([\'w\',expandProperties.width,\'h\',expandProperties.height])}}if(typeof expandProperties.lockOrientation!==\'undefined\'){args=args.concat([\'lockOrientation\',expandProperties.lockOrientation])}if(URL){args=args.concat([\'url\',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,\'URL is required.\',\'open\');else bridge.executeNativeCall(\'open\',\'url\',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,\'Event is required.\',\'removeEventListener\');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,\'Listener not currently registered for event.\',\'removeEventListener\');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,\'setExpandProperties\',true)){if(properties.hasOwnProperty(\'width\')||properties.hasOwnProperty(\'height\')){hasSetCustomSize=true}if(properties.hasOwnProperty(\'useCustomClose\'))hasSetCustomClose=true;var desiredProperties=[\'width\',\'height\',\'useCustomClose\',\'lockOrientation\'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall(\'usecustomclose\',\'shouldUseCustomClose\',shouldUseCustomClose)}}());"

.field private static final LOGTAG:Ljava/lang/String;

.field private static mraidViewCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/ads/MraidView;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field protected adView:Lcom/amazon/device/ads/AdView;

.field private context_:Landroid/content/Context;

.field private mAttached:Z

.field private mBrowserController:Lcom/amazon/device/ads/MraidBrowserController;

.field private mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

.field private mGoingAway:Z

.field private mHasFiredReadyEvent:Z

.field private mLastVisibility:I

.field private mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

.field private final mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;

.field private mWebChromeClient:Landroid/webkit/WebChromeClient;

.field private mWebViewClient:Landroid/webkit/WebViewClient;

.field protected scalingMultiplier_:D

.field protected shouldForceRenderFailure:Z

.field private webView_:Landroid/webkit/WebView;

.field private windowHeight_:I

.field private windowWidth_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;)V
    .locals 11
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;
    .param p2, "windowWidth"    # I
    .param p3, "windowHeight"    # I
    .param p4, "scalingMultiplier"    # D
    .param p6, "context"    # Landroid/content/Context;
    .param p7, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 150
    sget-object v8, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->ENABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    sget-object v9, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->AD_CONTROLLED:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v10, Lcom/amazon/device/ads/MraidView$PlacementType;->INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-wide v4, p4

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    invoke-direct/range {v0 .. v10}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;Lcom/amazon/device/ads/MraidView$PlacementType;)V

    .line 159
    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;Lcom/amazon/device/ads/MraidView$PlacementType;)V
    .locals 2
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;
    .param p2, "windowWidth"    # I
    .param p3, "windowHeight"    # I
    .param p4, "scalingMultiplier"    # D
    .param p6, "context"    # Landroid/content/Context;
    .param p7, "webView"    # Landroid/webkit/WebView;
    .param p8, "expStyle"    # Lcom/amazon/device/ads/MraidView$ExpansionStyle;
    .param p9, "buttonStyle"    # Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;
    .param p10, "placementType"    # Lcom/amazon/device/ads/MraidView$PlacementType;

    .prologue
    const/4 v1, 0x0

    .line 170
    invoke-direct {p0, p6}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 63
    iput-boolean v1, p0, Lcom/amazon/device/ads/MraidView;->mAttached:Z

    .line 64
    const/16 v0, 0x8

    iput v0, p0, Lcom/amazon/device/ads/MraidView;->mLastVisibility:I

    .line 65
    iput-boolean v1, p0, Lcom/amazon/device/ads/MraidView;->shouldForceRenderFailure:Z

    .line 95
    iput-boolean v1, p0, Lcom/amazon/device/ads/MraidView;->mGoingAway:Z

    .line 172
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    .line 173
    iput-object p10, p0, Lcom/amazon/device/ads/MraidView;->mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;

    .line 174
    iput p3, p0, Lcom/amazon/device/ads/MraidView;->windowHeight_:I

    .line 175
    iput p2, p0, Lcom/amazon/device/ads/MraidView;->windowWidth_:I

    .line 176
    iput-wide p4, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    .line 177
    iput-object p6, p0, Lcom/amazon/device/ads/MraidView;->context_:Landroid/content/Context;

    .line 178
    iput-object p7, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    .line 180
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->setWebViewHeightToAdHeight()V

    .line 182
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->addView(Landroid/view/View;)V

    .line 183
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->shouldDisableWebViewHardwareAcceleration()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 185
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->disableHardwareAcceleration()V

    .line 187
    :cond_0
    invoke-virtual {p0, p8, p9}, Lcom/amazon/device/ads/MraidView;->initialize(Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;)V

    .line 188
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;Landroid/webkit/WebView;)V
    .locals 11
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "webView"    # Landroid/webkit/WebView;

    .prologue
    const/4 v2, 0x0

    .line 139
    const-wide/16 v4, 0x0

    sget-object v8, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    sget-object v9, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_HIDDEN:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v10, Lcom/amazon/device/ads/MraidView$PlacementType;->INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

    move-object v0, p0

    move-object v1, p1

    move v3, v2

    move-object v6, p2

    move-object v7, p3

    invoke-direct/range {v0 .. v10}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;IIDLandroid/content/Context;Landroid/webkit/WebView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;Lcom/amazon/device/ads/MraidView$PlacementType;)V

    .line 142
    return-void
.end method

.method static synthetic access$700()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;

    return-object v0
.end method

.method public static cacheMraidView(Ljava/lang/String;Lcom/amazon/device/ads/MraidView;)V
    .locals 1
    .param p0, "uniqueId"    # Ljava/lang/String;
    .param p1, "mraidView"    # Lcom/amazon/device/ads/MraidView;

    .prologue
    .line 568
    invoke-static {}, Lcom/amazon/device/ads/MraidView;->getMraidViewCache()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 569
    return-void
.end method

.method public static getCachedMraidView(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView;
    .locals 1
    .param p0, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 588
    invoke-static {}, Lcom/amazon/device/ads/MraidView;->getMraidViewCache()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView;

    return-object v0
.end method

.method static getMraidViewCache()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/device/ads/MraidView;",
            ">;"
        }
    .end annotation

    .prologue
    .line 593
    sget-object v0, Lcom/amazon/device/ads/MraidView;->mraidViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 595
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/MraidView;->mraidViewCache:Ljava/util/HashMap;

    .line 597
    :cond_0
    sget-object v0, Lcom/amazon/device/ads/MraidView;->mraidViewCache:Ljava/util/HashMap;

    return-object v0
.end method

.method private notifyOnFailureListener()V
    .locals 1

    .prologue
    .line 406
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$000(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnFailureListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$000(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnFailureListener;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/MraidView$OnFailureListener;->onFailure(Lcom/amazon/device/ads/MraidView;)V

    .line 409
    :cond_0
    return-void
.end method

.method public static removeCachedMraidView(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView;
    .locals 1
    .param p0, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 578
    invoke-static {}, Lcom/amazon/device/ads/MraidView;->getMraidViewCache()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView;

    return-object v0
.end method

.method private setupAdWebViewClient()V
    .locals 3

    .prologue
    .line 282
    new-instance v0, Lcom/amazon/device/ads/AdWebViewClient;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->context_:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdWebViewClient;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    .line 283
    .local v0, "adWebViewClient":Lcom/amazon/device/ads/AdWebViewClient;
    const-string/jumbo v1, "mraid"

    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->createMraidExecutor()Lcom/amazon/device/ads/MraidView$MraidExecutor;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdWebViewClient;->putUrlExecutor(Ljava/lang/String;Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;)V

    .line 284
    const-string/jumbo v1, "amazonmobile"

    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v2}, Lcom/amazon/device/ads/AdView;->getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdWebViewClient;->putUrlExecutor(Ljava/lang/String;Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;)V

    .line 285
    iput-object v0, p0, Lcom/amazon/device/ads/MraidView;->mWebViewClient:Landroid/webkit/WebViewClient;

    .line 286
    iget-object v1, p0, Lcom/amazon/device/ads/MraidView;->mWebViewClient:Landroid/webkit/WebViewClient;

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidView;->setWebViewsWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 287
    return-void
.end method


# virtual methods
.method protected createMraidExecutor()Lcom/amazon/device/ads/MraidView$MraidExecutor;
    .locals 1

    .prologue
    .line 296
    new-instance v0, Lcom/amazon/device/ads/MraidView$MraidExecutor;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/MraidView$MraidExecutor;-><init>(Lcom/amazon/device/ads/MraidView;)V

    return-object v0
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->destroy()V

    .line 339
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->removeView(Landroid/view/View;)V

    .line 340
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 341
    return-void
.end method

.method protected disableHardwareAcceleration()V
    .locals 0

    .prologue
    .line 195
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils;->disableHardwareAcceleration(Landroid/view/View;)V

    .line 196
    return-void
.end method

.method protected fireChangeEventForProperties(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/device/ads/MraidProperty;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "properties":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/device/ads/MraidProperty;>;"
    const/4 v4, 0x1

    .line 527
    invoke-virtual {p1}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v1

    .line 528
    .local v1, "props":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x2

    if-ge v2, v3, :cond_0

    .line 533
    :goto_0
    return-void

    .line 530
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "{"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 531
    .local v0, "json":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "window.mraidbridge.fireChangeEvent("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ");"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/amazon/device/ads/MraidView;->injectJavaScript(Ljava/lang/String;)V

    .line 532
    sget-object v2, Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v3, "Fire changes: %s"

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V
    .locals 5
    .param p1, "property"    # Lcom/amazon/device/ads/MraidProperty;

    .prologue
    .line 521
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "{"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/device/ads/MraidProperty;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 522
    .local v0, "json":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "window.mraidbridge.fireChangeEvent("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ");"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/device/ads/MraidView;->injectJavaScript(Ljava/lang/String;)V

    .line 523
    sget-object v1, Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;

    const-string/jumbo v2, "Fire change: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 524
    return-void
.end method

.method protected fireErrorEvent(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 536
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "window.mraidbridge.fireErrorEvent(\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\', \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\');"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->injectJavaScript(Ljava/lang/String;)V

    .line 537
    return-void
.end method

.method protected fireNativeCommandCompleteEvent(Ljava/lang/String;)V
    .locals 2
    .param p1, "command"    # Ljava/lang/String;

    .prologue
    .line 544
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "window.mraidbridge.nativeCallComplete(\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\');"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->injectJavaScript(Ljava/lang/String;)V

    .line 545
    return-void
.end method

.method protected fireReadyEvent()V
    .locals 1

    .prologue
    .line 540
    const-string/jumbo v0, "window.mraidbridge.fireReadyEvent();"

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->injectJavaScript(Ljava/lang/String;)V

    .line 541
    return-void
.end method

.method protected getAdView()Lcom/amazon/device/ads/AdView;
    .locals 1

    .prologue
    .line 261
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    return-object v0
.end method

.method protected getBrowserController()Lcom/amazon/device/ads/MraidBrowserController;
    .locals 1

    .prologue
    .line 414
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mBrowserController:Lcom/amazon/device/ads/MraidBrowserController;

    return-object v0
.end method

.method protected getDisplayController()Lcom/amazon/device/ads/MraidDisplayController;
    .locals 1

    .prologue
    .line 418
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    return-object v0
.end method

.method public getOnCloseButtonStateChangeListener()Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;
    .locals 1

    .prologue
    .line 460
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseButtonListener:Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$400(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnCloseListener()Lcom/amazon/device/ads/MraidView$OnCloseListener;
    .locals 1

    .prologue
    .line 436
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseListener:Lcom/amazon/device/ads/MraidView$OnCloseListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$200(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnCloseListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnExpandListener()Lcom/amazon/device/ads/MraidView$OnExpandListener;
    .locals 1

    .prologue
    .line 428
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnExpandListener:Lcom/amazon/device/ads/MraidView$OnExpandListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$100(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnExpandListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnFailureListener()Lcom/amazon/device/ads/MraidView$OnFailureListener;
    .locals 1

    .prologue
    .line 452
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$000(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnFailureListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnOpenListener()Lcom/amazon/device/ads/MraidView$OnOpenListener;
    .locals 1

    .prologue
    .line 468
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnOpenListener:Lcom/amazon/device/ads/MraidView$OnOpenListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$500(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnOpenListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnReadyListener()Lcom/amazon/device/ads/MraidView$OnReadyListener;
    .locals 1

    .prologue
    .line 444
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnReadyListener:Lcom/amazon/device/ads/MraidView$OnReadyListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$300(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnReadyListener;

    move-result-object v0

    return-object v0
.end method

.method public getOnSpecialUrlClickListener()Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;
    .locals 1

    .prologue
    .line 476
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # getter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnSpecialUrlClickListener:Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$600(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    move-result-object v0

    return-object v0
.end method

.method protected getScalingMultiplier()D
    .locals 2

    .prologue
    .line 256
    iget-wide v0, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    return-wide v0
.end method

.method public getShouldForceRenderFailure()Z
    .locals 1

    .prologue
    .line 277
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->shouldForceRenderFailure:Z

    return v0
.end method

.method public getWebView()Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    return-object v0
.end method

.method protected getWindowHeight()I
    .locals 1

    .prologue
    .line 251
    iget v0, p0, Lcom/amazon/device/ads/MraidView;->windowHeight_:I

    return v0
.end method

.method protected getWindowWidth()I
    .locals 1

    .prologue
    .line 246
    iget v0, p0, Lcom/amazon/device/ads/MraidView;->windowWidth_:I

    return v0
.end method

.method protected initialize(Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;)V
    .locals 4
    .param p1, "expStyle"    # Lcom/amazon/device/ads/MraidView$ExpansionStyle;
    .param p2, "buttonStyle"    # Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 224
    new-instance v2, Lcom/amazon/device/ads/MraidBrowserController;

    invoke-direct {v2, p0}, Lcom/amazon/device/ads/MraidBrowserController;-><init>(Lcom/amazon/device/ads/MraidView;)V

    iput-object v2, p0, Lcom/amazon/device/ads/MraidView;->mBrowserController:Lcom/amazon/device/ads/MraidBrowserController;

    .line 225
    new-instance v2, Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {v2, p0, p1, p2}, Lcom/amazon/device/ads/MraidDisplayController;-><init>(Lcom/amazon/device/ads/MraidView;Lcom/amazon/device/ads/MraidView$ExpansionStyle;Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;)V

    iput-object v2, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    .line 227
    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->setScrollContainer(Z)V

    .line 228
    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 229
    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 230
    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v2, v1}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 234
    iget-object v2, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    sget-object v3, Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;

    invoke-static {v0, v2, v3}, Lcom/amazon/device/ads/WebViewFactory;->setJavaScriptEnabledForWebView(ZLandroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->shouldForceRenderFailure:Z

    .line 236
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidView;->setupAdWebViewClient()V

    .line 238
    new-instance v0, Lcom/amazon/device/ads/MraidView$MraidWebChromeClient;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/MraidView$MraidWebChromeClient;-><init>(Lcom/amazon/device/ads/MraidView;)V

    iput-object v0, p0, Lcom/amazon/device/ads/MraidView;->mWebChromeClient:Landroid/webkit/WebChromeClient;

    .line 239
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    iget-object v1, p0, Lcom/amazon/device/ads/MraidView;->mWebChromeClient:Landroid/webkit/WebChromeClient;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 241
    new-instance v0, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    invoke-direct {v0}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .line 242
    return-void

    :cond_0
    move v0, v1

    .line 234
    goto :goto_0
.end method

.method protected injectJavaScript(Ljava/lang/String;)V
    .locals 3
    .param p1, "js"    # Ljava/lang/String;

    .prologue
    .line 517
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "javascript:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 518
    :cond_0
    return-void
.end method

.method public loadHtmlData(Ljava/lang/String;)Z
    .locals 1
    .param p1, "data"    # Ljava/lang/String;

    .prologue
    .line 355
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/device/ads/MraidView;->loadHtmlData(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public loadHtmlData(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 6
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 360
    const-string/jumbo v0, "<html>"

    invoke-virtual {p2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 361
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "<html><meta name=\"viewport\" content=\"width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/MraidView;->windowWidth_:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", height="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/MraidView;->windowHeight_:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", initial-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    invoke-static {v1, v2}, Lcom/amazon/device/ads/AdUtils;->getViewportInitialScale(D)D

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", minimum-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", maximum-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\"/>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "<head></head><body style=\'margin:0;padding:0;\'>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "</body></html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 378
    :cond_0
    const-string/jumbo v0, "<head>"

    const-string/jumbo v1, "<head><script type=\'text/javascript\'>(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent(\'ready\')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent(\'change\',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent(\'error\',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call=\'mraid://\'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+=\'?\';isFirstArgument=false}else{call+=\'&\'}call+=key+\'=\'+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION=\'1.0\';var STATES=mraid.STATES={LOADING:\'loading\',DEFAULT:\'default\',EXPANDED:\'expanded\',HIDDEN:\'hidden\',};var EVENTS=mraid.EVENTS={ERROR:\'error\',INFO:\'info\',READY:\'ready\',STATECHANGE:\'stateChange\',VIEWABLECHANGE:\'viewableChange\'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:\'unknown\',INLINE:\'inline\',INTERSTITIAL:\'interstitial\'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,\':\'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push(\'|\',id,\'|\')}return out.join(\'\')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj===\'object\'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return\'[\'+out.join(\',\')+\']\'}else{for(var p in obj)out.push(\"\'\"+p+\"\': \"+obj[p]);return\'{\'+out.join(\',\')+\'}\'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,\'\')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,\'Native SDK initialized.\')}state=val;broadcastEvent(EVENTS.INFO,\'Set state to \'+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,\'Set isViewable to \'+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,\'Set placementType to \'+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,\'Set screenSize to \'+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties[\'width\']=screenSize[\'width\'];expandProperties[\'height\']=screenSize[\'height\']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,\'Merging expandProperties with \'+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,\'Required object not provided.\',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,\'Object is missing required property: \'+i+\'.\',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,\'Value of property \'+prop+\' is invalid.\',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v===\'boolean\')},lockOrientation:function(v){return(typeof v===\'boolean\')}};bridge.addEventListener(\'change\',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener(\'error\',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener(\'ready\',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,\'Both event and listener are required.\',\'addEventListener\')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,\'Unknown MRAID event: \'+event,\'addEventListener\')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,\'Ad cannot be closed when it is already hidden.\',\'close\')}else bridge.executeNativeCall(\'close\')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=[\'playVideo\'];if(URL){args=args.concat([\'url\',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle=\'normal\',stopStyle=\'normal\';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle=\'normal\';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle=\'exit\'}if(position[0]==-1||position[1]==-1){startStyle=\'fullscreen\';autoPlay=true}args=args.concat([\'audioMuted\',audioMuted]);args=args.concat([\'autoPlay\',autoPlay]);args=args.concat([\'controls\',controls]);args=args.concat([\'loop\',loop]);args=args.concat([\'position\',position]);args=args.concat([\'startStyle\',startStyle]);args=args.concat([\'stopStyle\',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=[\'log\',\'level\',level,\'log\',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,\'Ad can only be expanded from the default state.\',\'expand\')}else{var args=[\'expand\'];if(hasSetCustomClose){args=args.concat([\'shouldUseCustomClose\',expandProperties.useCustomClose?\'true\':\'false\'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat([\'w\',expandProperties.width,\'h\',expandProperties.height])}}if(typeof expandProperties.lockOrientation!==\'undefined\'){args=args.concat([\'lockOrientation\',expandProperties.lockOrientation])}if(URL){args=args.concat([\'url\',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,\'URL is required.\',\'open\');else bridge.executeNativeCall(\'open\',\'url\',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,\'Event is required.\',\'removeEventListener\');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,\'Listener not currently registered for event.\',\'removeEventListener\');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,\'setExpandProperties\',true)){if(properties.hasOwnProperty(\'width\')||properties.hasOwnProperty(\'height\')){hasSetCustomSize=true}if(properties.hasOwnProperty(\'useCustomClose\'))hasSetCustomClose=true;var desiredProperties=[\'width\',\'height\',\'useCustomClose\',\'lockOrientation\'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall(\'usecustomclose\',\'shouldUseCustomClose\',shouldUseCustomClose)}}());</script>"

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p2

    .line 379
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    const-string/jumbo v3, "text/html"

    const-string/jumbo v4, "UTF-8"

    const/4 v5, 0x0

    move-object v1, p1

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    const/4 v0, 0x1

    return v0
.end method

.method public loadUrlForTwoPartExpansionView(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 385
    invoke-static {}, Lcom/amazon/device/ads/WebRequest;->createNewWebRequest()Lcom/amazon/device/ads/WebRequest;

    move-result-object v1

    .line 386
    .local v1, "request":Lcom/amazon/device/ads/WebRequest;
    invoke-virtual {v1, p1}, Lcom/amazon/device/ads/WebRequest;->setUrlString(Ljava/lang/String;)V

    .line 387
    const/4 v2, 0x0

    .line 389
    .local v2, "response":Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 397
    invoke-virtual {v2}, Lcom/amazon/device/ads/WebRequest$WebResponse;->getBody()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/device/ads/MraidView;->loadHtmlData(Ljava/lang/String;)Z

    .line 398
    :goto_0
    return-void

    .line 391
    :catch_0
    move-exception v0

    .line 393
    .local v0, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidView;->notifyOnFailureListener()V

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 300
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mGoingAway:Z

    if-eqz v0, :cond_1

    .line 306
    :cond_0
    :goto_0
    return-void

    .line 301
    :cond_1
    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    .line 302
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mAttached:Z

    .line 303
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    if-eqz v0, :cond_0

    .line 304
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->registerReceivers()V

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 317
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 318
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mAttached:Z

    .line 319
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    if-eqz v0, :cond_0

    .line 320
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->unregisterReceivers()V

    .line 322
    :cond_0
    return-void
.end method

.method protected onPageFinished()V
    .locals 1

    .prologue
    .line 549
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mHasFiredReadyEvent:Z

    if-nez v0, :cond_1

    .line 551
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->initializeJavaScriptState()V

    .line 552
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;

    invoke-static {v0}, Lcom/amazon/device/ads/MraidPlacementTypeProperty;->createWithType(Lcom/amazon/device/ads/MraidView$PlacementType;)Lcom/amazon/device/ads/MraidPlacementTypeProperty;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/MraidView;->fireChangeEventForProperty(Lcom/amazon/device/ads/MraidProperty;)V

    .line 553
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->fireReadyEvent()V

    .line 554
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->getOnReadyListener()Lcom/amazon/device/ads/MraidView$OnReadyListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 555
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->getOnReadyListener()Lcom/amazon/device/ads/MraidView$OnReadyListener;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/MraidView$OnReadyListener;->onReady(Lcom/amazon/device/ads/MraidView;)V

    .line 556
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mHasFiredReadyEvent:Z

    .line 557
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->surfaceAd()V

    .line 559
    :cond_1
    return-void
.end method

.method protected onWindowVisibilityChanged(I)V
    .locals 1
    .param p1, "visibility"    # I

    .prologue
    .line 326
    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mAttached:Z

    if-eqz v0, :cond_0

    .line 327
    iget v0, p0, Lcom/amazon/device/ads/MraidView;->mLastVisibility:I

    if-eq v0, p1, :cond_0

    .line 328
    if-eqz p1, :cond_0

    .line 329
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    if-eqz v0, :cond_0

    .line 330
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->unregisterReceivers()V

    .line 335
    :cond_0
    return-void
.end method

.method public prepareToGoAway()V
    .locals 1

    .prologue
    .line 309
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/MraidView;->mGoingAway:Z

    .line 310
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->detachExpandedView()V

    .line 314
    :cond_0
    return-void
.end method

.method public registerReceivers()V
    .locals 1

    .prologue
    .line 350
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->registerReceivers()V

    .line 351
    return-void
.end method

.method public setAdView(Lcom/amazon/device/ads/AdView;)V
    .locals 0
    .param p1, "adView"    # Lcom/amazon/device/ads/AdView;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    .line 267
    invoke-virtual {p0}, Lcom/amazon/device/ads/MraidView;->setWebViewHeightToAdHeight()V

    .line 268
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidView;->setupAdWebViewClient()V

    .line 269
    return-void
.end method

.method protected setMraidBrowserController(Lcom/amazon/device/ads/MraidBrowserController;)V
    .locals 0
    .param p1, "browserController"    # Lcom/amazon/device/ads/MraidBrowserController;

    .prologue
    .line 483
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->mBrowserController:Lcom/amazon/device/ads/MraidBrowserController;

    .line 484
    return-void
.end method

.method protected setMraidDisplayController(Lcom/amazon/device/ads/MraidDisplayController;)V
    .locals 0
    .param p1, "controller"    # Lcom/amazon/device/ads/MraidDisplayController;

    .prologue
    .line 490
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    .line 491
    return-void
.end method

.method protected setMraidListenerInfo(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;)V
    .locals 0
    .param p1, "info"    # Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .prologue
    .line 511
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    .line 512
    return-void
.end method

.method public setOnCloseButtonStateChange(Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    .prologue
    .line 456
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseButtonListener:Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$402(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;)Lcom/amazon/device/ads/MraidView$OnCloseButtonStateChangeListener;

    .line 457
    return-void
.end method

.method public setOnCloseListener(Lcom/amazon/device/ads/MraidView$OnCloseListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnCloseListener;

    .prologue
    .line 432
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnCloseListener:Lcom/amazon/device/ads/MraidView$OnCloseListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$202(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnCloseListener;)Lcom/amazon/device/ads/MraidView$OnCloseListener;

    .line 433
    return-void
.end method

.method public setOnExpandListener(Lcom/amazon/device/ads/MraidView$OnExpandListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnExpandListener;

    .prologue
    .line 424
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnExpandListener:Lcom/amazon/device/ads/MraidView$OnExpandListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$102(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnExpandListener;)Lcom/amazon/device/ads/MraidView$OnExpandListener;

    .line 425
    return-void
.end method

.method public setOnFailureListener(Lcom/amazon/device/ads/MraidView$OnFailureListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnFailureListener;

    .prologue
    .line 448
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnFailureListener:Lcom/amazon/device/ads/MraidView$OnFailureListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$002(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnFailureListener;)Lcom/amazon/device/ads/MraidView$OnFailureListener;

    .line 449
    return-void
.end method

.method public setOnOpenListener(Lcom/amazon/device/ads/MraidView$OnOpenListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnOpenListener;

    .prologue
    .line 464
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnOpenListener:Lcom/amazon/device/ads/MraidView$OnOpenListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$502(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnOpenListener;)Lcom/amazon/device/ads/MraidView$OnOpenListener;

    .line 465
    return-void
.end method

.method public setOnReadyListener(Lcom/amazon/device/ads/MraidView$OnReadyListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnReadyListener;

    .prologue
    .line 440
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnReadyListener:Lcom/amazon/device/ads/MraidView$OnReadyListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$302(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnReadyListener;)Lcom/amazon/device/ads/MraidView$OnReadyListener;

    .line 441
    return-void
.end method

.method public setOnSpecialUrlClickListener(Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    .prologue
    .line 472
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mListenerInfo:Lcom/amazon/device/ads/MraidView$MraidListenerInfo;

    # setter for: Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->mOnSpecialUrlClickListener:Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;
    invoke-static {v0, p1}, Lcom/amazon/device/ads/MraidView$MraidListenerInfo;->access$602(Lcom/amazon/device/ads/MraidView$MraidListenerInfo;Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;)Lcom/amazon/device/ads/MraidView$OnSpecialUrlClickListener;

    .line 473
    return-void
.end method

.method protected setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    .locals 0
    .param p1, "client"    # Landroid/webkit/WebChromeClient;

    .prologue
    .line 504
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->mWebChromeClient:Landroid/webkit/WebChromeClient;

    .line 505
    return-void
.end method

.method protected setWebViewClient(Landroid/webkit/WebViewClient;)V
    .locals 0
    .param p1, "client"    # Landroid/webkit/WebViewClient;

    .prologue
    .line 497
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView;->mWebViewClient:Landroid/webkit/WebViewClient;

    .line 498
    return-void
.end method

.method protected setWebViewHeightToAdHeight()V
    .locals 5

    .prologue
    .line 204
    iget-object v1, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v1}, Lcom/amazon/device/ads/AdView;->getHeight()I

    move-result v1

    int-to-double v1, v1

    iget-wide v3, p0, Lcom/amazon/device/ads/MraidView;->scalingMultiplier_:D

    mul-double/2addr v1, v3

    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/ads/DeviceInfo;->getScalingFactorAsFloat()F

    move-result v3

    float-to-double v3, v3

    mul-double/2addr v1, v3

    double-to-int v0, v1

    .line 207
    .local v0, "height":I
    if-lez v0, :cond_0

    .line 209
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/amazon/device/ads/MraidView;->setWebViewLayoutParams(II)V

    .line 211
    :cond_0
    return-void
.end method

.method protected setWebViewLayoutParams(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 220
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, p1, p2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 221
    return-void
.end method

.method protected setWebViewsWebViewClient(Landroid/webkit/WebViewClient;)V
    .locals 1
    .param p1, "webViewClient"    # Landroid/webkit/WebViewClient;

    .prologue
    .line 291
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->webView_:Landroid/webkit/WebView;

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 292
    return-void
.end method

.method public shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->adView:Lcom/amazon/device/ads/AdView;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdView;->shouldDisableWebViewHardwareAcceleration()Z

    move-result v0

    return v0
.end method

.method public unregisterReceivers()V
    .locals 1

    .prologue
    .line 345
    iget-object v0, p0, Lcom/amazon/device/ads/MraidView;->mDisplayController:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->unregisterReceivers()V

    .line 346
    return-void
.end method
