// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            p, au, AdUnit, cw, 
//            AdFrame, FlurryAds, ct, fd, 
//            aa, v, cy, AdSpaceLayout, 
//            UriUtils, fl, gt, gk, 
//            co, gg, n, y, 
//            FlurryFullscreenTakeoverActivity, bk, bh, s, 
//            bj

final class ft extends p
    implements android.content.DialogInterface.OnKeyListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener, au
{

    private Context Q;
    private View cJ;
    private int cK;
    private FrameLayout cM;
    private WebView eq;
    private WebViewClient er;
    private WebChromeClient es;
    private FlurryAds fI;
    private ProgressDialog fu;
    private MediaController fx;
    private gk hN;
    private boolean hO;
    private boolean hP;
    private android.webkit.WebChromeClient.CustomViewCallback hQ;
    private Dialog hR;
    private int hS;
    private Dialog hT;
    private FrameLayout hU;
    private boolean hV;
    private boolean hW;
    private boolean hX;
    private AlertDialog hY;
    private List hZ;
    private aa hk;
    private boolean ia;
    private Map ib;
    private Map ic;
    private Activity id;
    private String ie;
    private List _fldif;
    private final String p = getClass().getSimpleName();

    ft(Context context, FlurryAds flurryads, cw cw1, AdUnit adunit, int i1)
    {
        boolean flag = true;
        super(context, flurryads, cw1);
        ie = null;
        Q = context;
        if (context instanceof Activity)
        {
            id = (Activity)context;
        }
        setClickable(true);
        T = adunit;
        U = i1;
        S = cw1;
        if (T != null)
        {
            hZ = T.getAdFrames();
            if (T.getCombinable().intValue() != 1)
            {
                flag = false;
            }
            ia = flag;
            if (ia)
            {
                ic = new HashMap();
                ib = new HashMap();
                ic.put(cw1.aA(), cw1);
                ib.put(((AdFrame)adunit.getAdFrames().get(0)).getAdGuid().toString(), adunit);
            }
            fI = flurryads;
            hk = fI.hk;
            super.T = T;
            super.S = S;
            _fldif = new LinkedList();
        }
    }

    private cw I(String s1)
    {
        cw cw1;
        if (ic == null)
        {
            cw1 = null;
        } else
        {
            cw cw3 = (cw)ic.get(s1);
            cw1 = cw3;
            if (cw3 == null)
            {
                cw cw2 = ct.a(fI, s1);
                ic.put(s1, cw2);
                return cw2;
            }
        }
        return cw1;
    }

    private AdUnit J(String s1)
    {
        if (ib == null)
        {
            return null;
        } else
        {
            return (AdUnit)ib.get(s1);
        }
    }

    static int a(ft ft1, int i1)
    {
        ft1.cK = i1;
        return i1;
    }

    static Dialog a(ft ft1, Dialog dialog)
    {
        ft1.hR = dialog;
        return dialog;
    }

    static View a(ft ft1, View view)
    {
        ft1.cJ = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(ft ft1, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        ft1.hQ = customviewcallback;
        return customviewcallback;
    }

    static FrameLayout a(ft ft1, FrameLayout framelayout)
    {
        ft1.cM = framelayout;
        return framelayout;
    }

    static AdUnit a(ft ft1, String s1)
    {
        return ft1.J(s1);
    }

    static String a(ft ft1)
    {
        return ft1.p;
    }

    private void a(int i1, int j1)
    {
        if (hT == null)
        {
            return;
        }
        (new StringBuilder()).append("collapse(").append(i1).append(",").append(j1).append(")").toString();
        if (hT != null && hT.isShowing())
        {
            hT.hide();
            hT.setOnDismissListener(null);
            hT.dismiss();
        }
        hT = null;
        fd.a(id, hS);
        if (hU != null)
        {
            if (eq != null && -1 != hU.indexOfChild(eq))
            {
                hU.removeView(eq);
            }
            hU = null;
        }
        if (eq != null && eq.getParent() == null)
        {
            addView(eq);
        }
        R.onCloseFullScreen(Q, T.getAdSpace().toString());
    }

    static boolean a(ft ft1, boolean flag)
    {
        ft1.hW = flag;
        return flag;
    }

    static WebView b(ft ft1)
    {
        return ft1.eq;
    }

    static cw b(ft ft1, String s1)
    {
        return ft1.I(s1);
    }

    private List b(int i1, int j1)
    {
        List list = hk.b(Q, T.getAdSpace().toString(), j1);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AdUnit adunit = (AdUnit)iterator.next();
            if (adunit.getAdFrames().size() > 0)
            {
                ib.put(((AdFrame)adunit.getAdFrames().get(0)).getAdGuid().toString(), adunit);
            }
        } while (true);
        return list;
    }

    static boolean b(ft ft1, boolean flag)
    {
        ft1.hV = flag;
        return flag;
    }

    private AdFrame bA()
    {
        return (AdFrame)hZ.get(U);
    }

    private v bB()
    {
        Object obj;
        try
        {
            obj = getParent();
        }
        catch (ClassCastException classcastexception)
        {
            cy.g(p, (new StringBuilder()).append("AdUnityView parent not a BannerHolder:").append(classcastexception.getMessage()).toString());
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        obj = (v)obj;
        return ((v) (obj));
        return null;
    }

    private String bx()
    {
        return bA().getDisplay().toString();
    }

    private String by()
    {
        return bA().getAdSpaceLayout().getFormat().toString();
    }

    static void c(ft ft1)
    {
        if (!ft1.hP)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("javascript:(function() {");
            stringbuilder.append("var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial)return\"\";if(this.c&&typeof partial==\"string\")partial=this.c.compile(partial,this.options);return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0)return false;if(typeof val==\"function\")val=this.ls(val,ctx,partials,inverted,start,end,tags);pass=val===\"\"||!!val;if(!inverted&&pass&&ctx)ctx.push(typeof val==\"object\"?val:ctx[ctx.length-1]);return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2]))return ctx[ctx.length-1];for(var i=1;i<names.length;i++)if(val&&typeof val==\"object\"&&names[i]in val){cx=val;val=val[names[i]]}else val=\"\";if(returnFound&&!val)return false;if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found)return returnFound?false:\"\";if(!returnFound&&typeof val==\"function\")val=this.lv(val,ctx,partials);return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var t=val.call(cx,text,function(t){return compiler.compile(t,options).render(cx,partials)});this.b(compiler.compile(t.toString(),options).render(cx,partials));return false},b:useArrayBuffer?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:useArrayBuffer?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0)return this.ho(val,cx,partials,this.text.substring(start,end),tags);t=val.call(cx);if(typeof t==\"function\")if(inverted)return true;else if(this.c)return this.ho(t,cx,partials,this.text.substring(start,end),tags);return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\")result=result.call(cx);result=coerceToString(result);if(this.c&&~result.indexOf(\"{{\"))return this.c.compile(result,this.options).render(cx,partials);return result}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String(val===null||val===undefined?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,\"_v\":8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes[\"_v\"]||!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null;if(!isAllWhitespace)return false}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace())for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\")next.indent=tokens[j].toString();tokens.splice(j,1)}}else if(!noNewLine)tokens.push({tag:\"\\n\"});seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++)if(state==IN_TEXT)if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else if(text.charAt(i)==\"\\n\")filterLine(seenTag);else buf+=text.charAt(i);else if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag)i++;state=IN_TAG}seenTag=i}else if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:tagType==\"/\"?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\")if(ctag==\"}}\")i++;else cleanTripleStache(tokens[tokens.length-1])}else buf+=text.charAt(i);filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\")token.n=token.n.substring(0,token.n.length-1)}function trim(s){if(s.trim)return s.trim();return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0))return false;for(var i=1,l=tag.length;i<l;i++)if(text.charAt(index+i)!=tag.charAt(i))return false;return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else if(token.tag==\"/\"){if(stack.length===0)throw new Error(\"Closing tag without opener: /\"+token.n);opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags))throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n);opener.end=token.i;return instructions}else instructions.push(token)}if(stack.length>0)throw new Error(\"missing closing tag: \"+stack.pop().n);return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].o==token.n){token.tag=\"#\";return true}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].c==close&&tags[i].o==open)return true}function writeCode(tree){return'var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\"}Hogan.generate=function(code,text,options){if(options.asString)return\"function(c,p,i){\"+code+\";}\";return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return~s.indexOf(\".\")?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\")code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag);else if(tag==\"^\")code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n));else if(tag==\"<\"||tag==\">\")code+=partial(tree[i]);else if(tag==\"{\"||tag==\"&\")code+=tripleStache(tree[i].n,chooseMethod(tree[i].n));else if(tag==\"\\n\")code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"));else if(tag==\"_v\")code+=variable(tree[i].n,chooseMethod(tree[i].n));else if(tag===undefined)code+=text('\"'+esc(tree[i])+'\"')}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),'+\"c,p,0,\"+start+\",\"+end+',\"'+tags+'\")){'+\"_.rs(c,p,\"+\"function(c,p,_){\"+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t)return t;t=this.generate(writeCode(this.parse(this.scan(text,options.delimiters),text,options)),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);");
            stringbuilder.append("var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};");
            stringbuilder.append("window.Hogan=Hogan;window.flurryadapter=flurryBridgeCtor(window);");
            stringbuilder.append("window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();}");
            stringbuilder.append("})();");
            if (ft1.eq != null)
            {
                ft1.eq.loadUrl(stringbuilder.toString());
            }
            ft1.hP = true;
        }
    }

    static boolean d(ft ft1)
    {
        return ft1.hW;
    }

    static void e(ft ft1)
    {
        if (!ft1.hX)
        {
            String s1;
            StringBuilder stringbuilder;
            if (ft1.bz())
            {
                s1 = "interstitial";
            } else
            {
                s1 = "inline";
            }
            s1 = (new StringBuilder()).append("{useCustomClose:").append(false).append(",isModal:").append(false).append(",width:undefined,height:undefined,placementType:\"").append(s1).append("\"}").toString();
            stringbuilder = new StringBuilder();
            stringbuilder.append("javascript:(function() {");
            stringbuilder.append("var mraidCtor=function(flurryBridge,initState){var mraid={};var STATES=mraid.STATES={LOADING:\"loading\",UNKNOWN:\"unknown\",DEFAULT:\"default\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var EVENTS=mraid.EVENTS={ASSETREADY:\"assetReady\",ASSETREMOVED:\"assetRemoved\",ASSETRETIRED:\"assetRetired\",INFO:\"info\",ERROR:\"error\",ORIENTATIONCHANGE:\"orientationChange\",READY:\"ready\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\"};var listeners={};var currentState=STATES.LOADING;var expandProperties={width:initState.width,height:initState.height,isModal:initState.isModal,useCustomClose:false};var collapseProperties={};var placementType=initState.placementType;var disable=false;var closeId=\"flurry-mraid-default-close\";var imgUrl=\"http://flurry.cachefly.net/adSpaceStyles/images/bttn-close-bw.png\";var safeClose=function(){try{if(window.mraid)window.mraid.close();else if(window.flurryadapter)flurryadapter.executeCall(\"adWillClose\");else console.log(\"unable to close\")}catch(error){console.log(\"unable to close: \"+error)}};var makeDefaultClose=function(){var img=document.createElement(\"img\");img.src=imgUrl;img.id=closeId;img.style.position=\"absolute\";img.style.top=\"10px\";img.style.right=\"10px\";img.style.width=\"50px\";img.style.height=\"50px\";img.style.zIndex=1E4;return img};var updateDefaultClose=function(){if(!expandProperties.useCustomClose&&(placementType===\"interstitial\"||currentState===STATES.EXPANDED))addDefaultClose();else removeDefaultClose()};var addDefaultClose=function(){var closeButton=document.getElementById(closeId);if(!closeButton){closeButton=makeDefaultClose();document.body.appendChild(closeButton)}};var removeDefaultClose=function(){var closeButton=document.getElementById(closeId);if(closeButton)document.body.removeChild(closeButton)};var setupDefaultCloseHandler=function(){document.body.addEventListener(\"click\",function(e){e=e||window.event;var target=e.target||e.srcElement;if(target.id===closeId)safeClose()})};var contains=function(value,obj){for(var i in obj)if(obj[i]===value)return true;return false};var stringify=function(obj){if(typeof obj==\"object\")if(obj.push){var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(obj[p]);return\"[\"+out.join(\",\")+\"]\"}else{var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(\"'\"+p+\"':\"+obj[p]);return\"{\"+out.join(\",\")+\"}\"}else return new String(obj)};var broadcastEvent=function(){var args=new Array(arguments.length);for(var i=0;i<arguments.length;i++)args[i]=arguments[i];var event=args.shift();try{if(listeners[event])for(var j=0;j<listeners[event].length;j++)if(typeof listeners[event][j]===\"function\")listeners[event][j].apply(undefined,args);else if(typeof listeners[event][j]===\"string\"&&typeof window[listeners[event][j]]===\"function\")window[listeners[event][j]].apply(undefined,args)}catch(e){console.log(e)}};mraid.disable=function(){removeDefaultClose();disable=true};mraid.addEventListener=function(event,listener){if(disable)return;if(!event||!listener)broadcastEvent(EVENTS.ERROR,\"Both event and listener are required.\",\"addEventListener\");else if(!contains(event,EVENTS))broadcastEvent(EVENTS.ERROR,\"Unknown event: \"+event,\"addEventListener\");else if(!listeners[event])listeners[event]=[listener];else listeners[event].push(listener);flurryBridge.executeCall(\"eventListenerAdded\")};mraid.stateChange=function(newState){if(disable)return;if(currentState===newState)return;broadcastEvent(EVENTS.INFO,\"setting state to \"+stringify(newState));var oldState=currentState;currentState=newState;if(oldState===STATES.LOADING&&newState===STATES.DEFAULT){setupDefaultCloseHandler();updateDefaultClose();broadcastEvent(EVENTS.READY)}else if(oldState===STATES.HIDDEN||newState===STATES.HIDDEN)broadcastEvent(EVENTS.VIEWABLECHANGE);else if(oldState===STATES.DEFAULT&&newState===STATES.EXPANDED)updateDefaultClose();else if(newState===STATES.DEFAULT&&oldState===STATES.EXPANDED)updateDefaultClose();broadcastEvent(EVENTS.STATECHANGE,currentState)};mraid.close=function(){if(disable)return;var state=mraid.getState();if(state===STATES.DEFAULT){mraid.stateChange(STATES.HIDDEN);flurryBridge.executeCall(\"adWillClose\")}else if(state===STATES.EXPANDED){mraid.stateChange(STATES.DEFAULT);flurryBridge.executeCall(\"collapse\")}else console.log(\"close() called in state \"+state)};mraid.expand=function(url){if(disable)return;var state=mraid.getState();if(state!==STATES.DEFAULT){console.log(\"expand() called in state \"+state);return}if(placementType===\"interstitial\"){console.log(\"expand() called for placement type \"+placementType);return}if(url)flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height,\"url\",url);else flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height);mraid.stateChange(STATES.EXPANDED)};mraid.setExpandProperties=function(properties){if(disable)return;if(typeof properties.width===\"number\"&&!isNaN(properties.width))expandProperties.width=properties.width;if(typeof properties.height===\"number\"&&!isNaN(properties.height))expandProperties.height=properties.height;if(typeof properties.useCustomClose===\"boolean\"){expandProperties.useCustomClose=properties.useCustomClose;updateDefaultClose()}};mraid.getExpandProperties=function(properties){if(disable)return;var ret={};ret.width=expandProperties.width;ret.height=expandProperties.height;ret.isModal=expandProperties.isModal;ret.useCustomClose=expandProperties.useCustomClose;return ret};mraid.getPlacementType=function(){return placementType};mraid.getVersion=function(){if(disable)return\"\";return\"1.0\"};mraid.getState=function(){if(disable)return\"\";return currentState};mraid.isViewable=function(){if(disable)return false;if(mraid.getState()===\"hidden\")return false;else return true};mraid.open=function(url){if(disable)return;try{flurryBridge.executeCall(\"open\",\"url\",url)}catch(e){console.log(e)}};mraid.removeEventListener=function(event,listener){if(disable)return;if(!event)broadcastEvent(\"error\",\"Must specify an event.\",\"removeEventListener\");else if(listener&&listeners[event])for(var i=0;i<listeners[event].length;i++){if(listeners[event][i]===listener)listeners[event].splice(i,1)}else if(listeners[event])listeners[event]=[]};mraid.useCustomClose=function(use){if(disable)return;if(typeof use===\"boolean\"){expandProperties.useCustomClose=use;updateDefaultClose()}};return mraid};");
            stringbuilder.append((new StringBuilder()).append("window.mraid=mraidCtor(window.flurryadapter,").append(s1).append(");").toString());
            stringbuilder.append("})();");
            if (ft1.eq != null)
            {
                ft1.eq.loadUrl(stringbuilder.toString());
            }
            ft1.hX = true;
        }
    }

    static boolean f(ft ft1)
    {
        return ft1.hV;
    }

    static void g(ft ft1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:");
        stringbuilder.append("if(window.mraid){window.mraid.stateChange(window.mraid.STATES.DEFAULT);}");
        if (ft1.eq != null)
        {
            ft1.eq.loadUrl(stringbuilder.toString());
        }
    }

    static void h(ft ft1)
    {
        if (ft1.bz())
        {
            fd.a(ft1.id, fd.bf(), true);
        }
    }

    static void i(ft ft1)
    {
        ft1.hP = false;
    }

    private String j(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("'{\"adComponents\":[");
        String s1 = eq.getUrl();
        String s3 = UriUtils.root(s1);
        String s4 = UriUtils.relativize(s3, s1);
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s2 = ((AdFrame)((AdUnit)iterator.next()).getAdFrames().get(0)).getContent().toString();
            list = s2;
            if (!TextUtils.isEmpty(s2))
            {
                list = s2;
                if (!TextUtils.isEmpty(s4))
                {
                    list = s2;
                    if (s4 != s3)
                    {
                        list = s2.replace(s3, s4);
                    }
                }
            }
            stringbuilder.append(fl.G(list));
            if (iterator.hasNext())
            {
                stringbuilder.append(",");
            }
        } while (true);
        stringbuilder.append("]}'");
        return stringbuilder.toString();
    }

    static void j(ft ft1)
    {
        ft1.hX = false;
    }

    static void k(ft ft1)
    {
        Object obj = ft1.bA().getContent().toString();
        if (!ft1.ia && obj != null && ((String) (obj)).length() > 0 && !((String) (obj)).equals("{}"))
        {
            String s1 = ft1.eq.getUrl();
            String s2 = UriUtils.root(s1);
            String s3 = UriUtils.relativize(s2, s1);
            s1 = ((String) (obj));
            if (!TextUtils.isEmpty(s3))
            {
                s1 = ((String) (obj));
                if (s3 != s2)
                {
                    (new StringBuilder()).append("content before {{mustached}} tags replacement = '").append(((String) (obj))).append("'").toString();
                    s1 = ((String) (obj)).replace(s2, s3);
                    (new StringBuilder()).append("content after {{mustached}} tags replacement = '").append(s1).append("'").toString();
                }
            }
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("javascript:");
            ((StringBuilder) (obj)).append("(function(){");
            ((StringBuilder) (obj)).append("if(!window.Hogan){var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial)return\"\";if(this.c&&typeof partial==\"string\")partial=this.c.compile(partial,this.options);return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0)return false;if(typeof val==\"function\")val=this.ls(val,ctx,partials,inverted,start,end,tags);pass=val===\"\"||!!val;if(!inverted&&pass&&ctx)ctx.push(typeof val==\"object\"?val:ctx[ctx.length-1]);return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2]))return ctx[ctx.length-1];for(var i=1;i<names.length;i++)if(val&&typeof val==\"object\"&&names[i]in val){cx=val;val=val[names[i]]}else val=\"\";if(returnFound&&!val)return false;if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found)return returnFound?false:\"\";if(!returnFound&&typeof val==\"function\")val=this.lv(val,ctx,partials);return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var t=val.call(cx,text,function(t){return compiler.compile(t,options).render(cx,partials)});this.b(compiler.compile(t.toString(),options).render(cx,partials));return false},b:useArrayBuffer?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:useArrayBuffer?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0)return this.ho(val,cx,partials,this.text.substring(start,end),tags);t=val.call(cx);if(typeof t==\"function\")if(inverted)return true;else if(this.c)return this.ho(t,cx,partials,this.text.substring(start,end),tags);return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\")result=result.call(cx);result=coerceToString(result);if(this.c&&~result.indexOf(\"{{\"))return this.c.compile(result,this.options).render(cx,partials);return result}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String(val===null||val===undefined?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,\"_v\":8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes[\"_v\"]||!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null;if(!isAllWhitespace)return false}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace())for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\")next.indent=tokens[j].toString();tokens.splice(j,1)}}else if(!noNewLine)tokens.push({tag:\"\\n\"});seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++)if(state==IN_TEXT)if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else if(text.charAt(i)==\"\\n\")filterLine(seenTag);else buf+=text.charAt(i);else if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag)i++;state=IN_TAG}seenTag=i}else if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:tagType==\"/\"?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\")if(ctag==\"}}\")i++;else cleanTripleStache(tokens[tokens.length-1])}else buf+=text.charAt(i);filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\")token.n=token.n.substring(0,token.n.length-1)}function trim(s){if(s.trim)return s.trim();return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0))return false;for(var i=1,l=tag.length;i<l;i++)if(text.charAt(index+i)!=tag.charAt(i))return false;return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else if(token.tag==\"/\"){if(stack.length===0)throw new Error(\"Closing tag without opener: /\"+token.n);opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags))throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n);opener.end=token.i;return instructions}else instructions.push(token)}if(stack.length>0)throw new Error(\"missing closing tag: \"+stack.pop().n);return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].o==token.n){token.tag=\"#\";return true}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++)if(tags[i].c==close&&tags[i].o==open)return true}function writeCode(tree){return'var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\"}Hogan.generate=function(code,text,options){if(options.asString)return\"function(c,p,i){\"+code+\";}\";return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return~s.indexOf(\".\")?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\")code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag);else if(tag==\"^\")code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n));else if(tag==\"<\"||tag==\">\")code+=partial(tree[i]);else if(tag==\"{\"||tag==\"&\")code+=tripleStache(tree[i].n,chooseMethod(tree[i].n));else if(tag==\"\\n\")code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"));else if(tag==\"_v\")code+=variable(tree[i].n,chooseMethod(tree[i].n));else if(tag===undefined)code+=text('\"'+esc(tree[i])+'\"')}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),'+\"c,p,0,\"+start+\",\"+end+',\"'+tags+'\")){'+\"_.rs(c,p,\"+\"function(c,p,_){\"+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t)return t;t=this.generate(writeCode(this.parse(this.scan(text,options.delimiters),text,options)),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);window.Hogan=Hogan;}");
            ((StringBuilder) (obj)).append("if(!window.flurryadapter){var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};window.flurryadapter=flurryBridgeCtor(window);}");
            ((StringBuilder) (obj)).append("if(!window.flurryAdapterAvailable){window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();} }");
            s1 = fl.G(s1);
            ((StringBuilder) (obj)).append("var content='");
            ((StringBuilder) (obj)).append(s1);
            ((StringBuilder) (obj)).append("';var compiled=window.Hogan.compile(document.body.innerHTML);var rendered=compiled.render(JSON.parse(content));document.body.innerHTML=rendered;");
            ((StringBuilder) (obj)).append("})();");
            if (ft1.eq != null)
            {
                ft1.eq.loadUrl(((StringBuilder) (obj)).toString());
            }
        }
    }

    static List l(ft ft1)
    {
        return ft1._fldif;
    }

    static Context m(ft ft1)
    {
        return ft1.Q;
    }

    static Activity n(ft ft1)
    {
        return ft1.id;
    }

    static View o(ft ft1)
    {
        return ft1.cJ;
    }

    static WebChromeClient p(ft ft1)
    {
        return ft1.es;
    }

    static FrameLayout q(ft ft1)
    {
        return ft1.cM;
    }

    static Dialog r(ft ft1)
    {
        return ft1.hR;
    }

    static Dialog s(ft ft1)
    {
        return ft1.hT;
    }

    static int t(ft ft1)
    {
        return ft1.cK;
    }

    static android.webkit.WebChromeClient.CustomViewCallback u(ft ft1)
    {
        return ft1.hQ;
    }

    static gk v(ft ft1)
    {
        return ft1.hN;
    }

    final void a(String s1, Map map, AdUnit adunit, cw cw1, int i1, int j1)
    {
        (new StringBuilder()).append("fireEvent(event=").append(s1).append(",params=").append(map).append(")").toString();
        R.onEvent(new gt(s1, map, Q, adunit, cw1, i1), this, j1);
    }

    final boolean a(View view)
    {
        view = view.getParent();
        return view != null && view == this;
    }

    final int bw()
    {
        return bA().getBinding().intValue();
    }

    final boolean bz()
    {
        return by().equals("takeover");
    }

    public final void initLayout(Context context)
    {
        (new StringBuilder()).append("initLayout: ad creative layout: {width = ").append(bA().getAdSpaceLayout().getAdWidth()).append(", height = ").append(bA().getAdSpaceLayout().getAdHeight()).append("}").toString();
        removeAllViews();
        setFocusable(true);
        setFocusableInTouchMode(true);
        switch (bw())
        {
        default:
            a("renderFailed", Collections.emptyMap(), T, S, U, 0);
            return;

        case 3: // '\003'
            if (hN == null)
            {
                hN = new gk(context);
                hN.setOnPreparedListener(this);
                hN.setOnCompletionListener(this);
                hN.setOnErrorListener(this);
                fx = new MediaController(context);
                hN.setMediaController(fx);
            }
            hN.setVideoURI(Uri.parse(bx()));
            cy.c(p, (new StringBuilder()).append("URI: ").append(Uri.parse(bx()).toString()).toString());
            hN.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            addView(hN);
            ((RelativeLayout)hN.getParent()).setGravity(17);
            fu = new ProgressDialog(context);
            fu.setProgressStyle(0);
            fu.setMessage("Loading...");
            fu.setCancelable(true);
            fu.setOnKeyListener(this);
            fu.show();
            return;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        if (eq == null)
        {
            eq = new WebView(context);
            eq.getSettings().setJavaScriptEnabled(true);
            eq.setVerticalScrollBarEnabled(false);
            eq.setHorizontalScrollBarEnabled(false);
            eq.setBackgroundColor(0);
            eq.clearCache(false);
            es = new co(this);
            eq.setWebChromeClient(es);
            er = new gg(this);
            eq.setWebViewClient(er);
        }
        a("rendered", Collections.emptyMap(), T, S, U, 0);
        if (bw() != 1) goto _L2; else goto _L1
_L1:
        if (ie != null)
        {
            eq.loadUrl(ie);
        } else
        {
            context = bx();
            eq.loadUrl(context);
        }
_L4:
        eq.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        return;
_L2:
        if (bw() == 2)
        {
            eq.loadDataWithBaseURL("base://url/", bx(), "text/html", "utf-8", "base://url/");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a("videoCompleted", Collections.emptyMap(), T, S, U, 0);
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        if (fu != null && fu.isShowing())
        {
            fu.dismiss();
        }
        a("renderFailed", Collections.emptyMap(), T, S, U, 0);
        removeView(hN);
        return false;
    }

    public final boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
    {
        boolean flag1 = false;
        (new StringBuilder()).append("onkey,keycode=").append(i1).append(",event=").append(keyevent.getAction()).toString();
        boolean flag = flag1;
        if (dialoginterface == fu)
        {
            flag = flag1;
            if (i1 == 4)
            {
                flag = flag1;
                if (keyevent.getAction() == 0)
                {
                    a("adWillClose", Collections.emptyMap(), T, S, U, 0);
                    dialoginterface.dismiss();
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (bw() == 3)
        {
            if (fu.isShowing())
            {
                fu.dismiss();
            }
            if ((hY == null || !hY.isShowing()) && hN != null && hO)
            {
                hN.start();
            }
            a("rendered", Collections.emptyMap(), T, S, U, 0);
            a("videoStart", Collections.emptyMap(), T, S, U, 0);
        }
    }

    public final void pause()
    {
        if (eq != null && n.SDK_INT >= 11)
        {
            eq.onPause();
        }
        if (hN != null && bw() == 3)
        {
            hN.pause();
        }
        hO = false;
    }

    public final void performAction$3deb3ec3(y y1, FlurryAds flurryads, int i1)
    {
        Object obj;
        Object obj1;
        gt gt1;
        obj = y1.bi;
        gt1 = y1.bk;
        obj1 = y1.bj;
        if (i1 <= 10) goto _L2; else goto _L1
_L1:
        (new StringBuilder()).append("Maximum depth for event/action loop exceeded when performing action:").append(((String) (obj))).append(",").append(obj1).append(",triggered by:").append(gt1.jf).toString();
_L4:
        return;
_L2:
        String s1;
        if (!gt1.jf.equals("clicked"))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)gt1.bj.get("noop");
        if (s1 != null && s1.equals("true")) goto _L4; else goto _L3
_L3:
        int j1;
        (new StringBuilder()).append("performAction(action=").append(((String) (obj))).append(",params=").append(y1.bj).append(",triggering event=").append(gt1.jf).append(")").toString();
        if (!((String) (obj)).equals("nextFrame"))
        {
            break MISSING_BLOCK_LABEL_635;
        }
        j1 = U + 1;
        flurryads = (String)((Map) (obj1)).get("offset");
        i1 = j1;
        if (flurryads != null)
        {
            if (!flurryads.equals("next"))
            {
                continue; /* Loop/switch isn't completed */
            }
            i1 = U + 1;
        }
_L7:
        if (!ia)
        {
            if (i1 != U && i1 < hZ.size())
            {
                obj = (AdFrame)T.getAdFrames().get(i1);
                flurryads = by();
                obj = ((AdFrame) (obj)).getAdSpaceLayout().getFormat().toString();
                if (!((String) (obj)).equals(flurryads))
                {
                    if (((String) (obj)).equals("takeover"))
                    {
                        fI.b(S);
                        fI.a(T);
                        flurryads = new Intent(Q, com/flurry/android/FlurryFullscreenTakeoverActivity);
                        flurryads.putExtra("frameIndex", i1);
                        fI.a(Q, flurryads, T.getAdSpace().toString());
                    }
                } else
                {
                    U = i1;
                    initLayout(Q);
                }
            }
        } else
        {
            flurryads = (String)y1.bk.bj.get("guid");
            if (flurryads != null)
            {
                T = J(flurryads);
                hZ = T.getAdFrames();
                S = y1.bk.S;
                if (bz())
                {
                    fI.a(T);
                    fI.b(S);
                }
                U = i1;
                ia = false;
                initLayout(Q);
            }
        }
_L8:
        if (!_fldif.contains(y1.bk.jf) || eq == null) goto _L4; else goto _L5
_L5:
        eq.loadUrl((new StringBuilder()).append("javascript:flurryadapter.callComplete('").append(y1.bk.jf).append("');").toString());
        _fldif.remove(y1.bk.jf);
        return;
        if (flurryads.equals("current")) goto _L4; else goto _L6
_L6:
        try
        {
            i1 = Integer.parseInt(flurryads);
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAds flurryads)
        {
            (new StringBuilder()).append("caught: ").append(flurryads.getMessage()).toString();
            i1 = j1;
        }
          goto _L7
        if (((String) (obj)).equals("closeAd"))
        {
            if (bz())
            {
                try
                {
                    ((Activity)Q).finish();
                }
                // Misplaced declaration of an exception variable
                catch (FlurryAds flurryads)
                {
                    (new StringBuilder()).append("caught class cast exception: ").append(flurryads).toString();
                }
            }
        } else
        if (((String) (obj)).equals("notifyUser"))
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Q);
            if (((Map) (obj1)).containsKey("message") && ((Map) (obj1)).containsKey("confirmDisplay") && ((Map) (obj1)).containsKey("cancelDisplay"))
            {
                flurryads = (String)((Map) (obj1)).get("message");
                obj = (String)((Map) (obj1)).get("confirmDisplay");
                obj1 = (String)((Map) (obj1)).get("cancelDisplay");
            } else
            {
                flurryads = "Are you sure?";
                obj = "Cancel";
                obj1 = "OK";
            }
            builder.setMessage(flurryads).setCancelable(false).setPositiveButton(((CharSequence) (obj1)), new bk(this, gt1, i1)).setNegativeButton(((CharSequence) (obj)), new bh(this, gt1, i1));
            hY = builder.create();
            if (hN != null && bw() == 3)
            {
                hN.pause();
            }
            hY.show();
        } else
        if (((String) (obj)).equals("loadAdComponents"))
        {
            boolean flag = true;
            byte byte0 = 3;
            i1 = ((flag) ? 1 : 0);
            int k1 = byte0;
            if (((Map) (obj1)).containsKey("min"))
            {
                i1 = ((flag) ? 1 : 0);
                k1 = byte0;
                if (((Map) (obj1)).containsKey("max"))
                {
                    try
                    {
                        i1 = Integer.parseInt((String)((Map) (obj1)).get("min"));
                        k1 = Integer.parseInt((String)((Map) (obj1)).get("max"));
                    }
                    // Misplaced declaration of an exception variable
                    catch (FlurryAds flurryads)
                    {
                        i1 = 1;
                        k1 = 3;
                    }
                }
            }
            T.getAdSpace().toString();
            flurryads = b(i1, k1);
            if (flurryads.size() > 0)
            {
                T.getAdSpace().toString();
                obj = j(flurryads);
                if (eq != null)
                {
                    eq.loadUrl((new StringBuilder()).append("javascript:(function() {var multiadwraps=document.getElementsByClassName('multiAdWrap');if(multiadwraps.length>0){var template=document.getElementsByClassName('multiAdWrap')[0];var compiled=Hogan.compile(template.innerHTML);template.innerHTML='';template.innerHTML=compiled.render(JSON.parse(").append(((String) (obj))).append("));}})();").toString());
                    eq.loadUrl("javascript:flurryadapter.callComplete();");
                }
                for (flurryads = flurryads.iterator(); flurryads.hasNext(); a("rendered", ((Map) (obj1)), ((AdUnit) (obj)), I(((AdFrame)((AdUnit) (obj)).getAdFrames().get(0)).getAdGuid().toString()), 0, 0))
                {
                    obj = (AdUnit)flurryads.next();
                    obj1 = new HashMap();
                    ((Map) (obj1)).put("guid", ((AdFrame)((AdUnit) (obj)).getAdFrames().get(0)).getAdGuid().toString());
                }

                if (eq != null && !a(eq))
                {
                    addView(eq);
                }
            } else
            {
                a("renderFailed", Collections.emptyMap(), T, S, U, 0);
            }
        } else
        if (((String) (obj)).equals("doExpand"))
        {
            i1 = fl.q(Q);
            int l1 = fl.r(Q);
            if (y1.bk.bj.containsKey("width") && y1.bk.bj.containsKey("height"))
            {
                try
                {
                    i1 = fl.b(Q, Integer.parseInt((String)y1.bk.bj.get("width")));
                    l1 = fl.b(Q, Integer.parseInt((String)y1.bk.bj.get("height")));
                }
                // Misplaced declaration of an exception variable
                catch (FlurryAds flurryads)
                {
                    flurryads.getMessage();
                    i1 = fl.q(Q);
                    l1 = fl.r(Q);
                }
            }
            (new StringBuilder()).append("expand to width = ").append(i1).append(" height = ").append(l1).toString();
            if (bB() != null)
            {
                a("clicked", Collections.emptyMap(), T, S, U, 0);
                if (hT == null)
                {
                    (new StringBuilder()).append("expand(").append(i1).append(",").append(l1).append(")").toString();
                    if (eq != null && -1 != indexOfChild(eq))
                    {
                        removeView(eq);
                    }
                    hS = id.getRequestedOrientation();
                    if (hU == null)
                    {
                        hU = new FrameLayout(Q);
                        hU.setBackgroundColor(0xff000000);
                        if (eq != null && eq.getParent() == null)
                        {
                            hU.addView(eq, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
                        }
                    }
                    if (hT == null)
                    {
                        hT = new Dialog(Q, 0x103000a);
                        com.flurry.android.s.a(hT.getWindow());
                        hT.setContentView(hU, new android.view.ViewGroup.LayoutParams(-1, -1));
                        hT.setOnDismissListener(new bj(this));
                        hT.setCancelable(true);
                        hT.show();
                    }
                    fd.a(id, fd.bf(), true);
                    R.onOpenFullScreen(Q, T.getAdSpace().toString());
                }
            }
            if (y1.bk.bj.containsKey("url"))
            {
                ie = (String)y1.bk.bj.get("url");
                initLayout(Q);
            }
        } else
        if (((String) (obj)).equals("doCollapse"))
        {
            int i2 = bA().getAdSpaceLayout().getAdWidth().intValue();
            i1 = bA().getAdSpaceLayout().getAdHeight().intValue();
            i2 = fl.b(Q, i2);
            i1 = fl.b(Q, i1);
            if (ie != null)
            {
                ie = null;
                initLayout(Q);
            }
            if (bB() != null)
            {
                a(i2, i1);
            }
        } else
        {
            if (((String) (obj)).equals("directOpen"))
            {
                HashMap hashmap = new HashMap();
                hashmap.put("noop", "true");
                a("clicked", hashmap, T, S, U, 0);
            }
            R.performAction$3deb3ec3(y1, flurryads, i1);
        }
          goto _L8
    }

    public final void resume()
    {
        hO = true;
        if (eq != null && n.SDK_INT >= 11)
        {
            eq.onResume();
        }
        if (hN != null && bw() == 3 && fx != null)
        {
            fx.show(0);
        }
    }

    final boolean shouldRotate()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)Q.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        boolean flag1;
        if (networkinfo != null && networkinfo.isAvailable() && networkinfo.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (hT != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            if (hR != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1 && flag)
            {
                return true;
            }
        }
        return false;
    }

    public final void stop()
    {
        if (bw() == 3)
        {
            if (fu != null && fu.isShowing())
            {
                fu.dismiss();
            }
            if (hN != null && hN.isPlaying())
            {
                hN.stopPlayback();
            }
        }
        if (eq != null)
        {
            if (cJ != null && es != null)
            {
                es.onHideCustomView();
            }
            if (hT != null)
            {
                a(0, 0);
            }
            removeView(eq);
            eq.stopLoading();
            if (n.SDK_INT >= 11)
            {
                eq.onPause();
            }
            eq.destroy();
            eq = null;
        }
        if (bz())
        {
            a("adClosed", Collections.emptyMap(), T, S, U, 0);
        }
    }
}
