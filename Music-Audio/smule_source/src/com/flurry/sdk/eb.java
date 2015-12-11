// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdSpaceLayout;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ec, gd, i, aa, 
//            p, v, cx, cn, 
//            hn, a, b, s, 
//            aw, ap, cu, ed, 
//            dq, dr, gk, gy, 
//            fn, cv, hp, el, 
//            co, fz, av, ds, 
//            cy, fy, r, fp, 
//            fx, dt, hq

public class eb extends ec
    implements android.content.DialogInterface.OnKeyListener
{

    private boolean A;
    private boolean B;
    private ec.a C;
    String a;
    fy b;
    private boolean c;
    private final String d = com/flurry/sdk/eb.getSimpleName();
    private dq e;
    private boolean f;
    private WebView g;
    private ImageButton h;
    private int i;
    private boolean j;
    private WebViewClient k;
    private WebChromeClient l;
    private View m;
    private int n;
    private android.webkit.WebChromeClient.CustomViewCallback o;
    private Dialog p;
    private FrameLayout q;
    private int r;
    private Dialog s;
    private FrameLayout t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private AlertDialog z;

    public eb(Context context, r r1, ec.a a1, boolean flag)
    {
        super(context, r1, a1);
        c = false;
        y = false;
        a = null;
        B = true;
        b = new fy() {

            final eb a;

            public void a(ed ed1)
            {
                fp.a().a(new Runnable(this, ed1) {

                    final ed a;
                    final _cls1 b;

                    public void run()
                    {
                        ed.a a1 = a.a;
                        class _cls8
                        {

                            static final int a[];

                            static 
                            {
                                a = new int[ed.a.values().length];
                                try
                                {
                                    a[ed.a.a.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror4) { }
                                try
                                {
                                    a[ed.a.b.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror3) { }
                                try
                                {
                                    a[ed.a.d.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                try
                                {
                                    a[ed.a.c.ordinal()] = 4;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    a[ed.a.e.ordinal()] = 5;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls8.a[a1.ordinal()])
                        {
                        default:
                            return;

                        case 1: // '\001'
                            eb.a(b.a, a);
                            return;

                        case 2: // '\002'
                            eb.a(b.a);
                            return;

                        case 3: // '\003'
                            eb.a(b.a, a.b);
                            return;

                        case 4: // '\004'
                            eb.b(b.a, a.b);
                            return;

                        case 5: // '\005'
                            eb.c(b.a, a.b);
                            break;
                        }
                    }

            
            {
                b = _pcls1;
                a = ed1;
                super();
            }
                });
            }

            public void notify(fx fx)
            {
                a((ed)fx);
            }

            
            {
                a = eb.this;
                super();
            }
        };
        C = new ec.a() {

            final eb a;

            public void a()
            {
                if (eb.o(a) == 3 && eb.b(a) != null)
                {
                    if (a.isViewAttachedToActivity() && a.a(eb.b(a)))
                    {
                        a.removeView(eb.b(a));
                    }
                    eb.b(a).cleanupLayout();
                    eb.a(a, null);
                }
            }

            public void b()
            {
                if (eb.o(a) == 3 && eb.b(a) != null)
                {
                    if (a.isViewAttachedToActivity() && a.a(eb.b(a)))
                    {
                        a.removeView(eb.b(a));
                    }
                    eb.b(a).cleanupLayout();
                    eb.a(a, null);
                }
            }

            public void c()
            {
                if (eb.o(a) == 3 && eb.b(a) != null)
                {
                    eb.b(a).cleanupLayout();
                    eb.a(a, null);
                }
            }

            
            {
                a = eb.this;
                super();
            }
        };
        setClickable(true);
        c = flag;
        if (getContext() instanceof Activity)
        {
            i = ((Activity)getContext()).getRequestedOrientation();
        }
        if (getAdUnit() != null)
        {
            w = getAdUnit().supportMRAID;
            return;
        } else
        {
            gd.a(3, d, "adunit is Null");
            return;
        }
    }

    static int A(eb eb1)
    {
        return eb1.n;
    }

    static android.webkit.WebChromeClient.CustomViewCallback B(eb eb1)
    {
        return eb1.o;
    }

    static int a(eb eb1, int i1)
    {
        eb1.n = i1;
        return i1;
    }

    static Dialog a(eb eb1, Dialog dialog)
    {
        eb1.p = dialog;
        return dialog;
    }

    private Uri a(String s1)
    {
        Uri uri = null;
        File file;
        gd.a(3, d, (new StringBuilder()).append("Precaching: Getting video from cache: ").append(s1).toString());
        file = com.flurry.sdk.i.a().l().a(getAdObject(), s1);
        Object obj = uri;
        if (file != null)
        {
            try
            {
                obj = Uri.parse((new StringBuilder()).append("file://").append(file.getAbsolutePath()).toString());
            }
            catch (Exception exception)
            {
                gd.a(3, d, "Precaching: Error accessing cached file.", exception);
                exception = uri;
            }
        }
        uri = ((Uri) (obj));
        if (obj == null)
        {
            gd.a(3, d, (new StringBuilder()).append("Precaching: Error using cached file. Loading with url: ").append(s1).toString());
            uri = Uri.parse(s1);
        }
        return uri;
    }

    static View a(eb eb1, View view)
    {
        eb1.m = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(eb eb1, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        eb1.o = customviewcallback;
        return customviewcallback;
    }

    static FrameLayout a(eb eb1, FrameLayout framelayout)
    {
        eb1.q = framelayout;
        return framelayout;
    }

    static dq a(eb eb1, dq dq1)
    {
        eb1.e = dq1;
        return dq1;
    }

    private void a(int i1, int j1)
    {
        if (!(getContext() instanceof Activity))
        {
            gd.a(3, d, "no activity present");
        } else
        {
            Activity activity = (Activity)getContext();
            if (s == null)
            {
                gd.a(3, d, (new StringBuilder()).append("expand(").append(i1).append(",").append(j1).append(")").toString());
                com.flurry.sdk.i.a().d().b(getContext());
                com.flurry.sdk.i.a().e().a(getContext());
                if (g != null && -1 != indexOfChild(g))
                {
                    removeView(g);
                }
                r = activity.getRequestedOrientation();
                if (t == null)
                {
                    t = new FrameLayout(activity);
                    t.setBackgroundColor(0xff000000);
                    if (g != null && g.getParent() == null)
                    {
                        t.addView(g, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
                    }
                }
                if (s == null)
                {
                    s = new Dialog(activity, 0x103000a);
                    cx.a(s.getWindow());
                    s.setContentView(t, new android.view.ViewGroup.LayoutParams(-1, -1));
                    s.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                        final eb a;

                        public void onDismiss(DialogInterface dialoginterface)
                        {
                            gd.a(3, eb.c(a), "extendedWebViewDialog.onDismiss()");
                            if (eb.d(a) != null)
                            {
                                eb.d(a).loadUrl("javascript:if(window.mraid){window.mraid.close();};");
                            }
                        }

            
            {
                a = eb.this;
                super();
            }
                    });
                    s.setCancelable(true);
                    s.show();
                }
                cn.a(activity, cn.a(), true);
                return;
            }
        }
    }

    private void a(a a1)
    {
        int i1 = hn.f();
        int j1 = hn.g();
        gd.a(3, d, (new StringBuilder()).append("expand to width = ").append(i1).append(" height = ").append(j1).toString());
        r r1 = a1.c().b();
        ap ap1 = a1.c().c();
        if ((r1 instanceof s) && ((s)r1).s() != null)
        {
            a(aw.h, Collections.emptyMap(), ap1, 0);
            a(i1, j1);
        }
        if (a1.c().b.containsKey("url"))
        {
            a = (String)a1.c().b.get("url");
            ap1.a(true);
            cu.a(getContext(), a, false, r1, true, false);
        }
    }

    private void a(aw aw1)
    {
        if (aw1.equals(aw.x))
        {
            l();
        }
    }

    private void a(aw aw1, Uri uri)
    {
label0:
        {
            if (aw1.equals(aw.S))
            {
                aw1 = uri.getQueryParameter("useCustomClose");
                if (TextUtils.isEmpty(aw1) || !aw1.equals("true"))
                {
                    break label0;
                }
                setMraidButtonVisibility(false);
            }
            return;
        }
        setMraidButtonVisibility(true);
    }

    static void a(eb eb1)
    {
        eb1.m();
    }

    static void a(eb eb1, a a1)
    {
        eb1.b(a1);
    }

    static void a(eb eb1, aw aw1)
    {
        eb1.b(aw1);
    }

    static void a(eb eb1, aw aw1, Uri uri)
    {
        eb1.a(aw1, uri);
    }

    static void a(eb eb1, ed ed1)
    {
        eb1.a(ed1);
    }

    private void a(ed ed1)
    {
        a a1;
        int i1;
        gd.a(6, d, "show Video dialog.");
        a1 = ed1.b;
        i1 = ed1.c;
        if (isViewAttachedToActivity()) goto _L2; else goto _L1
_L1:
        gd.a(6, d, "View not attached to any window.");
_L4:
        return;
_L2:
        String s1;
        String s2;
        android.app.AlertDialog.Builder builder;
label0:
        {
            builder = new android.app.AlertDialog.Builder(getContext());
            s2 = a1.a("message");
            s1 = a1.a("confirmDisplay");
            String s3 = a1.a("cancelDisplay");
            if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s1))
            {
                ed1 = s3;
                if (!TextUtils.isEmpty(s3))
                {
                    break label0;
                }
            }
            s2 = "Are you sure?";
            s1 = "Cancel";
            ed1 = "OK";
        }
        builder.setMessage(s2);
        builder.setCancelable(false);
        builder.setPositiveButton(ed1, new android.content.DialogInterface.OnClickListener(a1, i1) {

            final a a;
            final int b;
            final eb c;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("sourceEvent", a.c().a.a());
                c.a(aw.q, hashmap, c.getAdController(), b + 1);
                dialoginterface.dismiss();
            }

            
            {
                c = eb.this;
                a = a1;
                b = i1;
                super();
            }
        });
        builder.setNegativeButton(s1, new android.content.DialogInterface.OnClickListener(a1, i1) {

            final a a;
            final int b;
            final eb c;

            public void onClick(DialogInterface dialoginterface, int j1)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("sourceEvent", a.c().a.a());
                c.a(aw.r, hashmap, c.getAdController(), b + 1);
                dialoginterface.dismiss();
                if (eb.b(c) != null)
                {
                    j1 = c.getAdController().m().a();
                    eb.b(c).a(j1);
                }
            }

            
            {
                c = eb.this;
                a = a1;
                b = i1;
                super();
            }
        });
        if (e != null && isViewAttachedToActivity())
        {
            z = builder.create();
            z.show();
            e.c();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(String s1, ds ds1)
    {
        if (s1 == null)
        {
            return;
        }
        Context context = getContext();
        if (e == null)
        {
            e = dr.a(context, ds1, getAdObject(), C);
            e.setVideoUri(a(s1));
            e.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            e.initLayout();
        }
        addView(e);
    }

    private boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = j;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(eb eb1, boolean flag)
    {
        eb1.v = flag;
        return flag;
    }

    static dq b(eb eb1)
    {
        return eb1.e;
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a())
        {
            d();
            setFlurryJsEnvInitialized(true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(int i1, int j1)
    {
        if (!(getContext() instanceof Activity))
        {
            gd.a(3, d, "no activity present");
        } else
        {
            Activity activity = (Activity)getContext();
            com.flurry.sdk.i.a().d().c(getContext());
            com.flurry.sdk.i.a().e().b(getContext());
            if (s != null)
            {
                gd.a(3, d, (new StringBuilder()).append("collapse(").append(i1).append(",").append(j1).append(")").toString());
                if (s != null && s.isShowing())
                {
                    s.hide();
                    s.setOnDismissListener(null);
                    s.dismiss();
                }
                s = null;
                cn.a(activity, r);
                if (t != null)
                {
                    if (g != null && -1 != t.indexOfChild(g))
                    {
                        t.removeView(g);
                    }
                    t = null;
                }
                if (g != null && g.getParent() == null)
                {
                    addView(g);
                    return;
                }
            }
        }
    }

    private void b(a a1)
    {
        int j1 = getCurrentAdFrame().adSpaceLayout.adWidth;
        int i1 = getCurrentAdFrame().adSpaceLayout.adHeight;
        j1 = hn.b(j1);
        i1 = hn.b(i1);
        if (a != null)
        {
            a = null;
            initLayout();
        }
        a1 = a1.c().b();
        if ((a1 instanceof s) && ((s)a1).s() != null)
        {
            b(j1, i1);
        }
    }

    private void b(aw aw1)
    {
        if (aw1.equals(aw.R))
        {
            p();
        }
    }

    static void b(eb eb1, a a1)
    {
        eb1.a(a1);
    }

    static void b(eb eb1, aw aw1)
    {
        eb1.a(aw1);
    }

    private void b(String s1)
    {
        gk gk1 = new gk();
        gk1.a(s1);
        gk1.a(10000);
        gk1.b(new gy());
        gk1.a(new gk.a(s1) {

            final String a;
            final eb b;

            public volatile void a(gk gk2, Object obj)
            {
                a(gk2, (String)obj);
            }

            public void a(gk gk2, String s2)
            {
                int i1 = gk2.e();
                gd.a(3, eb.c(b), (new StringBuilder()).append("Prerender: HTTP status code is:").append(i1).append(" for url: ").append(a).toString());
                if (gk2.c())
                {
                    gk2 = cv.c(a);
                    b.a(aw.f, Collections.emptyMap(), b.getAdController(), 0);
                    fp.a().a(new hq(this, gk2, s2) {

                        final String a;
                        final String b;
                        final _cls5 c;

                        public void safeRun()
                        {
                            if (eb.d(c.b) != null)
                            {
                                eb.d(c.b).loadDataWithBaseURL(a, b, "text/html", "utf-8", a);
                            }
                        }

            
            {
                c = _pcls5;
                a = s1;
                b = s2;
                super();
            }
                    });
                    return;
                } else
                {
                    fp.a().a(new hq(this) {

                        final _cls5 a;

                        public void safeRun()
                        {
                            HashMap hashmap = new HashMap();
                            hashmap.put("errorCode", Integer.toString(av.k.a()));
                            a.b.a(aw.g, hashmap, a.b.getAdController(), 0);
                        }

            
            {
                a = _pcls5;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                b = eb.this;
                a = s1;
                super();
            }
        });
        fn.a().a(this, gk1);
    }

    static boolean b(eb eb1, boolean flag)
    {
        eb1.u = flag;
        return flag;
    }

    static String c(eb eb1)
    {
        return eb1.d;
    }

    private void c()
    {
        this;
        JVM INSTR monitorenter ;
        setFlurryJsEnvInitialized(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void c(a a1)
    {
        if (g != null)
        {
            gd.a(3, d, (new StringBuilder()).append("Callcomplete ").append(a1.c().a.a()).toString());
            g.loadUrl((new StringBuilder()).append("javascript:flurryadapter.callComplete('").append(a1.c().a.a()).append("');").toString());
        }
    }

    static void c(eb eb1, a a1)
    {
        eb1.c(a1);
    }

    static boolean c(eb eb1, boolean flag)
    {
        eb1.B = flag;
        return flag;
    }

    static WebView d(eb eb1)
    {
        return eb1.g;
    }

    private void d()
    {
        gd.a(3, d, "initializeFlurryJsEnv");
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:(function() {");
        stringbuilder.append("var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial){return\"\"}if(this.c&&typeof partial==\"string\"){partial=this.c.compile(partial,this.options)}return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0){return false}if(typeof val==\"function\"){val=this.ls(val,ctx,partials,inverted,start,end,tags)}pass=(val===\"\")||!!val;if(!inverted&&pass&&ctx){ctx.push((typeof val==\"object\")?val:ctx[ctx.length-1])}return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2])){return ctx[ctx.length-1]}for(var i=1;i<names.length;i++){if(val&&typeof val==\"object\"&&names[i] in val){cx=val;val=val[names[i]]}else{val=\"\"}}if(returnFound&&!val){return false}if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found){return(returnFound)?false:\"\"}if(!returnFound&&typeof val==\"function\"){val=this.lv(val,ctx,partials)}return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var text=val.call(cx,text);text=(text==null)?String(text):text.toString();this.b(compiler.compile(text,options).render(cx,partials));return false},b:(useArrayBuffer)?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:(useArrayBuffer)?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0){return this.ho(val,cx,partials,this.text.substring(start,end),tags)}t=val.call(cx);if(typeof t==\"function\"){if(inverted){return true}else{if(this.c){return this.ho(t,cx,partials,this.text.substring(start,end),tags)}}}return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\"){result=coerceToString(result.call(cx));if(this.c&&~result.indexOf(\"{\\u007B\")){return this.c.compile(result,this.options).render(cx,partials)}}return coerceToString(result)}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String((val===null||val===undefined)?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,_v:8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=(tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes._v)||(!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null);if(!isAllWhitespace){return false}}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace()){for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\"){next.indent=tokens[j].toString()}tokens.splice(j,1)}}}else{if(!noNewLine){tokens.push({tag:\"\\n\"})}}seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++){if(state==IN_TEXT){if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else{if(text.charAt(i)==\"\\n\"){filterLine(seenTag)}else{buf+=text.charAt(i)}}}else{if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag){i++}state=IN_TAG}seenTag=i}else{if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:(tagType==\"/\")?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\"){if(ctag==\"}}\"){i++}else{cleanTripleStache(tokens[tokens.length-1])}}}else{buf+=text.charAt(i)}}}}filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\"){token.n=token.n.substring(0,token.n.length-1)}}function trim(s){if(s.trim){return s.trim()}return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0)){return false}for(var i=1,l=tag.length;i<l;i++){if(text.charAt(index+i)!=tag.charAt(i)){return false}}return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else{if(token.tag==\"/\"){if(stack.length===0){throw new Error(\"Closing tag without opener: /\"+token.n)}opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags)){throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n)}opener.end=token.i;return instructions}else{instructions.push(token)}}}if(stack.length>0){throw new Error(\"missing closing tag: \"+stack.pop().n)}return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].o==token.n){token.tag=\"#\";return true}}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].c==close&&tags[i].o==open){return true}}}Hogan.generate=function(tree,text,options){var code='var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\";if(options.asString){return\"function(c,p,i){\"+code+\";}\"}return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return(~s.indexOf(\".\"))?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\"){code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag)}else{if(tag==\"^\"){code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"<\"||tag==\">\"){code+=partial(tree[i])}else{if(tag==\"{\"||tag==\"&\"){code+=tripleStache(tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"\\n\"){code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"))}else{if(tag==\"_v\"){code+=variable(tree[i].n,chooseMethod(tree[i].n))}else{if(tag===undefined){code+=text('\"'+esc(tree[i])+'\"')}}}}}}}}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,0,'+start+\",\"+end+',\"'+tags+'\")){_.rs(c,p,function(c,p,_){'+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t){return t}t=this.generate(this.parse(this.scan(text,options.delimiters),text,options),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);");
        stringbuilder.append("var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};");
        stringbuilder.append("window.Hogan=Hogan;window.flurryadapter=flurryBridgeCtor(window);");
        stringbuilder.append("window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();}");
        stringbuilder.append("})();");
        if (g != null)
        {
            g.loadUrl(stringbuilder.toString());
        }
    }

    private void e()
    {
        gd.a(3, d, "activateFlurryJsEnv");
        Object obj = getCurrentContent();
        if (obj != null && ((String) (obj)).length() > 0 && !((String) (obj)).equals("{}"))
        {
            String s1 = g.getUrl();
            String s2 = cv.b(s1);
            String s3 = cv.a(s2, s1);
            s1 = ((String) (obj));
            if (!TextUtils.isEmpty(s3))
            {
                s1 = ((String) (obj));
                if (!s3.equals(s2))
                {
                    gd.a(3, d, (new StringBuilder()).append("content before {{mustached}} tags replacement = '").append(((String) (obj))).append("'").toString());
                    s1 = ((String) (obj)).replace(s2, s3);
                    gd.a(3, d, (new StringBuilder()).append("content after {{mustached}} tags replacement = '").append(s1).append("'").toString());
                }
            }
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append("javascript:");
            ((StringBuilder) (obj)).append("(function(){");
            ((StringBuilder) (obj)).append("if(!window.Hogan){var Hogan={};(function(Hogan,useArrayBuffer){Hogan.Template=function(renderFunc,text,compiler,options){this.r=renderFunc||this.r;this.c=compiler;this.options=options;this.text=text||\"\";this.buf=useArrayBuffer?[]:\"\"};Hogan.Template.prototype={r:function(context,partials,indent){return\"\"},v:hoganEscape,t:coerceToString,render:function render(context,partials,indent){return this.ri([context],partials||{},indent)},ri:function(context,partials,indent){return this.r(context,partials,indent)},rp:function(name,context,partials,indent){var partial=partials[name];if(!partial){return\"\"}if(this.c&&typeof partial==\"string\"){partial=this.c.compile(partial,this.options)}return partial.ri(context,partials,indent)},rs:function(context,partials,section){var tail=context[context.length-1];if(!isArray(tail)){section(context,partials,this);return}for(var i=0;i<tail.length;i++){context.push(tail[i]);section(context,partials,this);context.pop()}},s:function(val,ctx,partials,inverted,start,end,tags){var pass;if(isArray(val)&&val.length===0){return false}if(typeof val==\"function\"){val=this.ls(val,ctx,partials,inverted,start,end,tags)}pass=(val===\"\")||!!val;if(!inverted&&pass&&ctx){ctx.push((typeof val==\"object\")?val:ctx[ctx.length-1])}return pass},d:function(key,ctx,partials,returnFound){var names=key.split(\".\"),val=this.f(names[0],ctx,partials,returnFound),cx=null;if(key===\".\"&&isArray(ctx[ctx.length-2])){return ctx[ctx.length-1]}for(var i=1;i<names.length;i++){if(val&&typeof val==\"object\"&&names[i] in val){cx=val;val=val[names[i]]}else{val=\"\"}}if(returnFound&&!val){return false}if(!returnFound&&typeof val==\"function\"){ctx.push(cx);val=this.lv(val,ctx,partials);ctx.pop()}return val},f:function(key,ctx,partials,returnFound){var val=false,v=null,found=false;for(var i=ctx.length-1;i>=0;i--){v=ctx[i];if(v&&typeof v==\"object\"&&key in v){val=v[key];found=true;break}}if(!found){return(returnFound)?false:\"\"}if(!returnFound&&typeof val==\"function\"){val=this.lv(val,ctx,partials)}return val},ho:function(val,cx,partials,text,tags){var compiler=this.c;var options=this.options;options.delimiters=tags;var text=val.call(cx,text);text=(text==null)?String(text):text.toString();this.b(compiler.compile(text,options).render(cx,partials));return false},b:(useArrayBuffer)?function(s){this.buf.push(s)}:function(s){this.buf+=s},fl:(useArrayBuffer)?function(){var r=this.buf.join(\"\");this.buf=[];return r}:function(){var r=this.buf;this.buf=\"\";return r},ls:function(val,ctx,partials,inverted,start,end,tags){var cx=ctx[ctx.length-1],t=null;if(!inverted&&this.c&&val.length>0){return this.ho(val,cx,partials,this.text.substring(start,end),tags)}t=val.call(cx);if(typeof t==\"function\"){if(inverted){return true}else{if(this.c){return this.ho(t,cx,partials,this.text.substring(start,end),tags)}}}return t},lv:function(val,ctx,partials){var cx=ctx[ctx.length-1];var result=val.call(cx);if(typeof result==\"function\"){result=coerceToString(result.call(cx));if(this.c&&~result.indexOf(\"{\\u007B\")){return this.c.compile(result,this.options).render(cx,partials)}}return coerceToString(result)}};var rAmp=/&/g,rLt=/</g,rGt=/>/g,rApos=/\\'/g,rQuot=/\\\"/g,hChars=/[&<>\\\"\\']/;function coerceToString(val){return String((val===null||val===undefined)?\"\":val)}function hoganEscape(str){str=coerceToString(str);return hChars.test(str)?str.replace(rAmp,\"&amp;\").replace(rLt,\"&lt;\").replace(rGt,\"&gt;\").replace(rApos,\"&#39;\").replace(rQuot,\"&quot;\"):str}var isArray=Array.isArray||function(a){return Object.prototype.toString.call(a)===\"[object Array]\"}})(typeof exports!==\"undefined\"?exports:Hogan);(function(Hogan){var rIsWhitespace=/\\S/,rQuot=/\\\"/g,rNewline=/\\n/g,rCr=/\\r/g,rSlash=/\\\\/g,tagTypes={\"#\":1,\"^\":2,\"/\":3,\"!\":4,\">\":5,\"<\":6,\"=\":7,_v:8,\"{\":9,\"&\":10};Hogan.scan=function scan(text,delimiters){var len=text.length,IN_TEXT=0,IN_TAG_TYPE=1,IN_TAG=2,state=IN_TEXT,tagType=null,tag=null,buf=\"\",tokens=[],seenTag=false,i=0,lineStart=0,otag=\"{{\",ctag=\"}}\";function addBuf(){if(buf.length>0){tokens.push(new String(buf));buf=\"\"}}function lineIsWhitespace(){var isAllWhitespace=true;for(var j=lineStart;j<tokens.length;j++){isAllWhitespace=(tokens[j].tag&&tagTypes[tokens[j].tag]<tagTypes._v)||(!tokens[j].tag&&tokens[j].match(rIsWhitespace)===null);if(!isAllWhitespace){return false}}return isAllWhitespace}function filterLine(haveSeenTag,noNewLine){addBuf();if(haveSeenTag&&lineIsWhitespace()){for(var j=lineStart,next;j<tokens.length;j++){if(!tokens[j].tag){if((next=tokens[j+1])&&next.tag==\">\"){next.indent=tokens[j].toString()}tokens.splice(j,1)}}}else{if(!noNewLine){tokens.push({tag:\"\\n\"})}}seenTag=false;lineStart=tokens.length}function changeDelimiters(text,index){var close=\"=\"+ctag,closeIndex=text.indexOf(close,index),delimiters=trim(text.substring(text.indexOf(\"=\",index)+1,closeIndex)).split(\" \");otag=delimiters[0];ctag=delimiters[1];return closeIndex+close.length-1}if(delimiters){delimiters=delimiters.split(\" \");otag=delimiters[0];ctag=delimiters[1]}for(i=0;i<len;i++){if(state==IN_TEXT){if(tagChange(otag,text,i)){--i;addBuf();state=IN_TAG_TYPE}else{if(text.charAt(i)==\"\\n\"){filterLine(seenTag)}else{buf+=text.charAt(i)}}}else{if(state==IN_TAG_TYPE){i+=otag.length-1;tag=tagTypes[text.charAt(i+1)];tagType=tag?text.charAt(i+1):\"_v\";if(tagType==\"=\"){i=changeDelimiters(text,i);state=IN_TEXT}else{if(tag){i++}state=IN_TAG}seenTag=i}else{if(tagChange(ctag,text,i)){tokens.push({tag:tagType,n:trim(buf),otag:otag,ctag:ctag,i:(tagType==\"/\")?seenTag-ctag.length:i+otag.length});buf=\"\";i+=ctag.length-1;state=IN_TEXT;if(tagType==\"{\"){if(ctag==\"}}\"){i++}else{cleanTripleStache(tokens[tokens.length-1])}}}else{buf+=text.charAt(i)}}}}filterLine(seenTag,true);return tokens};function cleanTripleStache(token){if(token.n.substr(token.n.length-1)===\"}\"){token.n=token.n.substring(0,token.n.length-1)}}function trim(s){if(s.trim){return s.trim()}return s.replace(/^\\s*|\\s*$/g,\"\")}function tagChange(tag,text,index){if(text.charAt(index)!=tag.charAt(0)){return false}for(var i=1,l=tag.length;i<l;i++){if(text.charAt(index+i)!=tag.charAt(i)){return false}}return true}function buildTree(tokens,kind,stack,customTags){var instructions=[],opener=null,token=null;while(tokens.length>0){token=tokens.shift();if(token.tag==\"#\"||token.tag==\"^\"||isOpener(token,customTags)){stack.push(token);token.nodes=buildTree(tokens,token.tag,stack,customTags);instructions.push(token)}else{if(token.tag==\"/\"){if(stack.length===0){throw new Error(\"Closing tag without opener: /\"+token.n)}opener=stack.pop();if(token.n!=opener.n&&!isCloser(token.n,opener.n,customTags)){throw new Error(\"Nesting error: \"+opener.n+\" vs. \"+token.n)}opener.end=token.i;return instructions}else{instructions.push(token)}}}if(stack.length>0){throw new Error(\"missing closing tag: \"+stack.pop().n)}return instructions}function isOpener(token,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].o==token.n){token.tag=\"#\";return true}}}function isCloser(close,open,tags){for(var i=0,l=tags.length;i<l;i++){if(tags[i].c==close&&tags[i].o==open){return true}}}Hogan.generate=function(tree,text,options){var code='var _=this;_.b(i=i||\"\");'+walk(tree)+\"return _.fl();\";if(options.asString){return\"function(c,p,i){\"+code+\";}\"}return new Hogan.Template(new Function(\"c\",\"p\",\"i\",code),text,Hogan,options)};function esc(s){return s.replace(rSlash,\"\\\\\\\\\").replace(rQuot,'\\\\\"').replace(rNewline,\"\\\\n\").replace(rCr,\"\\\\r\")}function chooseMethod(s){return(~s.indexOf(\".\"))?\"d\":\"f\"}function walk(tree){var code=\"\";for(var i=0,l=tree.length;i<l;i++){var tag=tree[i].tag;if(tag==\"#\"){code+=section(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n),tree[i].i,tree[i].end,tree[i].otag+\" \"+tree[i].ctag)}else{if(tag==\"^\"){code+=invertedSection(tree[i].nodes,tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"<\"||tag==\">\"){code+=partial(tree[i])}else{if(tag==\"{\"||tag==\"&\"){code+=tripleStache(tree[i].n,chooseMethod(tree[i].n))}else{if(tag==\"\\n\"){code+=text('\"\\\\n\"'+(tree.length-1==i?\"\":\" + i\"))}else{if(tag==\"_v\"){code+=variable(tree[i].n,chooseMethod(tree[i].n))}else{if(tag===undefined){code+=text('\"'+esc(tree[i])+'\"')}}}}}}}}return code}function section(nodes,id,method,start,end,tags){return\"if(_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,0,'+start+\",\"+end+',\"'+tags+'\")){_.rs(c,p,function(c,p,_){'+walk(nodes)+\"});c.pop();}\"}function invertedSection(nodes,id,method){return\"if(!_.s(_.\"+method+'(\"'+esc(id)+'\",c,p,1),c,p,1,0,0,\"\")){'+walk(nodes)+\"};\"}function partial(tok){return'_.b(_.rp(\"'+esc(tok.n)+'\",c,p,\"'+(tok.indent||\"\")+'\"));'}function tripleStache(id,method){return\"_.b(_.t(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function variable(id,method){return\"_.b(_.v(_.\"+method+'(\"'+esc(id)+'\",c,p,0)));'}function text(id){return\"_.b(\"+id+\");\"}Hogan.parse=function(tokens,text,options){options=options||{};return buildTree(tokens,\"\",[],options.sectionTags||[])},Hogan.cache={};Hogan.compile=function(text,options){options=options||{};var key=text+\"||\"+!!options.asString;var t=this.cache[key];if(t){return t}t=this.generate(this.parse(this.scan(text,options.delimiters),text,options),text,options);return this.cache[key]=t}})(typeof exports!==\"undefined\"?exports:Hogan);window.Hogan=Hogan;}");
            ((StringBuilder) (obj)).append("if(!window.flurryadapter){var flurryBridgeCtor=function(w){var flurryadapter={};flurryadapter.flurryCallQueue=[];flurryadapter.flurryCallInProgress=false;flurryadapter.callComplete=function(cmd){if(this.flurryCallQueue.length==0){this.flurryCallInProgress=false;return}var adapterCall=this.flurryCallQueue.splice(0,1)[0];this.executeNativeCall(adapterCall);return\"OK\"};flurryadapter.executeCall=function(command){var adapterCall=\"flurry://flurrycall?event=\"+command;var value;for(var i=1;i<arguments.length;i+=2){value=arguments[i+1];if(value==null)continue;adapterCall+=\"&\"+arguments[i]+\"=\"+escape(value)}if(this.flurryCallInProgress)this.flurryCallQueue.push(adapterCall);else this.executeNativeCall(adapterCall)};flurryadapter.executeNativeCall=function(adapterCall){if(adapterCall.length==0)return;this.flurryCallInProgress=true;w.location=adapterCall};return flurryadapter};window.flurryadapter=flurryBridgeCtor(window);}");
            ((StringBuilder) (obj)).append("if(!window.flurryAdapterAvailable){window.flurryAdapterAvailable=true;if(typeof window.FlurryAdapterReady === 'function'){window.FlurryAdapterReady();} }");
            s1 = hp.g(s1);
            ((StringBuilder) (obj)).append("var content='");
            ((StringBuilder) (obj)).append(s1);
            ((StringBuilder) (obj)).append("';var compiled=window.Hogan.compile(document.body.innerHTML);var rendered=compiled.render(JSON.parse(content));document.body.innerHTML=rendered;");
            ((StringBuilder) (obj)).append("})();");
            if (g != null)
            {
                g.loadUrl(((StringBuilder) (obj)).toString());
            }
        }
    }

    static void e(eb eb1)
    {
        eb1.b();
    }

    static boolean f(eb eb1)
    {
        return eb1.v;
    }

    private boolean g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = A;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean g(eb eb1)
    {
        return eb1.w;
    }

    private AdFrame getCurrentAdFrame()
    {
        return getAdController().j();
    }

    private int getCurrentBinding()
    {
        return getCurrentAdFrame().binding;
    }

    private String getCurrentContent()
    {
        return getCurrentAdFrame().content;
    }

    private String getCurrentDisplay()
    {
        return getCurrentAdFrame().display;
    }

    private String getCurrentFormat()
    {
        return getCurrentAdFrame().adSpaceLayout.format;
    }

    private void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (!g())
        {
            j();
            setMraidJsEnvInitialized(true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void h(eb eb1)
    {
        eb1.h();
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        setMraidJsEnvInitialized(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean i(eb eb1)
    {
        return eb1.u;
    }

    private void j()
    {
        gd.a(3, d, "initializeMraid");
        String s1;
        StringBuilder stringbuilder;
        if (r())
        {
            s1 = "interstitial";
        } else
        {
            s1 = "inline";
        }
        s1 = (new StringBuilder()).append("{useCustomClose:").append(false).append(",isModal:").append(false).append(",width:undefined,height:undefined,placementType:\"").append(s1).append("\"}").toString();
        stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:(function() {");
        stringbuilder.append("var mraidCtor=function(flurryBridge,initState){var mraid={};var STATES=mraid.STATES={LOADING:\"loading\",UNKNOWN:\"unknown\",DEFAULT:\"default\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var EVENTS=mraid.EVENTS={ASSETREADY:\"assetReady\",ASSETREMOVED:\"assetRemoved\",ASSETRETIRED:\"assetRetired\",INFO:\"info\",ERROR:\"error\",ORIENTATIONCHANGE:\"orientationChange\",READY:\"ready\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\"};var listeners={};var currentState=STATES.LOADING;var expandProperties={width:initState.width,height:initState.height,isModal:initState.isModal,useCustomClose:false};var collapseProperties={};var placementType=initState.placementType;var disable=false;var safeCloseEnabled=false;var closeId=\"flurry-mraid-default-close\";var imgUrl=\"http://flurry.cachefly.net/adSpaceStyles/images/bttn-close-bw.png\";var safeClose=function(){try{if(window.mraid)window.mraid.close();else if(window.flurryadapter)flurryadapter.executeCall(\"adWillClose\");else console.log(\"unable to close\")}catch(error){console.log(\"unable to close: \"+error)}};var makeDefaultClose=function(){var img=document.createElement(\"img\");img.src=imgUrl;img.id=closeId;img.style.position=\"absolute\";img.style.top=\"10px\";img.style.right=\"10px\";img.style.width=\"50px\";img.style.height=\"50px\";img.style.zIndex=1E4;return img};var updateDefaultClose=function(){if(!expandProperties.useCustomClose&&(placementType===\"interstitial\"||currentState===STATES.EXPANDED)){addDefaultClose();flurryBridge.executeCall(\"mraidCloseButtonVisible\", \"useCustomClose\", \"true\");safeCloseEnabled=true;console.log('close button added');}else {removeDefaultClose(); console.log('close button removed');}};var addDefaultClose=function(){var closeButton=document.getElementById(closeId);if(!closeButton){closeButton=makeDefaultClose();document.body.appendChild(closeButton)}};var removeDefaultClose=function(){var closeButton=document.getElementById(closeId);if(closeButton)document.body.removeChild(closeButton)};var setupDefaultCloseHandler=function(){document.body.addEventListener(\"click\",function(e){e=e||window.event;var target=e.target||e.srcElement;if(target.id===closeId)safeClose()})};var contains=function(value,obj){for(var i in obj)if(obj[i]===value)return true;return false};var stringify=function(obj){if(typeof obj==\"object\")if(obj.push){var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(obj[p]);return\"[\"+out.join(\",\")+\"]\"}else{var out=[];for(var p in obj)if(obj.hasOwnProperty(p))out.push(\"'\"+p+\"':\"+obj[p]);return\"{\"+out.join(\",\")+\"}\"}else return new String(obj)};var broadcastEvent=function(){var args=new Array(arguments.length);for(var i=0;i<arguments.length;i++)args[i]=arguments[i];var event=args.shift();try{if(listeners[event])for(var j=0;j<listeners[event].length;j++)if(typeof listeners[event][j]===\"function\")listeners[event][j].apply(undefined,args);else if(typeof listeners[event][j]===\"string\"&&typeof window[listeners[event][j]]===\"function\")window[listeners[event][j]].apply(undefined,args)}catch(e){console.log(e)}};mraid.disable=function(){removeDefaultClose();disable=true};mraid.addEventListener=function(event,listener){if(disable)return;if(!event||!listener)broadcastEvent(EVENTS.ERROR,\"Both event and listener are required.\",\"addEventListener\");else if(!contains(event,EVENTS))broadcastEvent(EVENTS.ERROR,\"Unknown event: \"+event,\"addEventListener\");else if(!listeners[event])listeners[event]=[listener];else listeners[event].push(listener);updateDefaultClose();flurryBridge.executeCall(\"eventListenerAdded\")};mraid.stateChange=function(newState){if(disable)return;if(currentState===newState)return;broadcastEvent(EVENTS.INFO,\"setting state to \"+stringify(newState));var oldState=currentState;currentState=newState;if(oldState===STATES.LOADING&&newState===STATES.DEFAULT){setupDefaultCloseHandler();broadcastEvent(EVENTS.READY)}else if(oldState===STATES.HIDDEN||newState===STATES.HIDDEN)broadcastEvent(EVENTS.VIEWABLECHANGE);else if(oldState===STATES.DEFAULT&&newState===STATES.EXPANDED)updateDefaultClose();else if(newState===STATES.DEFAULT&&oldState===STATES.EXPANDED)updateDefaultClose();broadcastEvent(EVENTS.STATECHANGE,currentState)};mraid.close=function(){if(disable)return;var state=mraid.getState();if(state===STATES.DEFAULT){mraid.stateChange(STATES.HIDDEN);flurryBridge.executeCall(\"adWillClose\")}else if(state===STATES.EXPANDED){mraid.stateChange(STATES.DEFAULT);flurryBridge.executeCall(\"collapse\")}else console.log(\"close() called in state \"+state)};mraid.expand=function(url){if(disable)return;var state=mraid.getState();if(state!==STATES.DEFAULT){console.log(\"expand() called in state \"+state);return}if(placementType===\"interstitial\"){console.log(\"expand() called for placement type \"+placementType);return}if(url)flurryBridge.executeCall(\"open\",\"url\",url);else flurryBridge.executeCall(\"expand\",\"width\",expandProperties.width,\"height\",expandProperties.height);mraid.stateChange(STATES.EXPANDED)};mraid.setExpandProperties=function(properties){if(disable)return;if(typeof properties.width===\"number\"&&!isNaN(properties.width))expandProperties.width=properties.width;if(typeof properties.height===\"number\"&&!isNaN(properties.height))expandProperties.height=properties.height;if(typeof properties.useCustomClose===\"boolean\"){expandProperties.useCustomClose=properties.useCustomClose;updateDefaultClose()}};mraid.getExpandProperties=function(properties){if(disable)return;var ret={};ret.width=expandProperties.width;ret.height=expandProperties.height;ret.isModal=expandProperties.isModal;ret.useCustomClose=expandProperties.useCustomClose;return ret};mraid.getPlacementType=function(){return placementType};mraid.getVersion=function(){if(disable)return\"\";return\"1.0\"};mraid.getState=function(){if(disable)return\"\";return currentState};mraid.isViewable=function(){if(disable)return false;if(mraid.getState()===\"hidden\")return false;else return true};mraid.open=function(url){if(disable)return;try{flurryBridge.executeCall(\"open\",\"url\",url)}catch(e){console.log(e)}};mraid.playVideo=function(url){if(disable){return;}try{flurryBridge.executeCall(\"playVideo\",\"url\",url);}catch(e){console.log(e);}};mraid.removeEventListener=function(event,listener){if(disable)return;if(!event)broadcastEvent(\"error\",\"Must specify an event.\",\"removeEventListener\");else if(listener&&listeners[event])for(var i=0;i<listeners[event].length;i++){if(listeners[event][i]===listener)listeners[event].splice(i,1)}else if(listeners[event])listeners[event]=[]};mraid.useCustomClose=function(use){if(disable)return;if(typeof use===\"boolean\"){expandProperties.useCustomClose=use;updateDefaultClose();if (safeCloseEnabled){flurryBridge.executeCall(\"mraidCloseButtonVisible\", \"useCustomClose\", \"true\");}else{flurryBridge.executeCall(\"mraidCloseButtonVisible\", \"useCustomClose\", use);}}};return mraid};");
        stringbuilder.append("window.mraid=mraidCtor(window.flurryadapter,");
        stringbuilder.append(s1);
        stringbuilder.append(");");
        stringbuilder.append("})();");
        if (g != null)
        {
            g.loadUrl(stringbuilder.toString());
        }
    }

    static void j(eb eb1)
    {
        eb1.k();
    }

    private void k()
    {
        gd.a(3, d, "activateMraid");
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("javascript:");
        stringbuilder.append("if(window.mraid){window.mraid.stateChange(window.mraid.STATES.DEFAULT);}");
        if (g != null)
        {
            g.loadUrl(stringbuilder.toString());
        }
    }

    static void k(eb eb1)
    {
        eb1.n();
    }

    private void l()
    {
        if (!(getContext() instanceof Activity))
        {
            gd.a(3, d, "no activity present");
        } else
        {
            Activity activity = (Activity)getContext();
            if (r())
            {
                cn.a(activity, cn.a(), true);
                return;
            }
        }
    }

    static void l(eb eb1)
    {
        eb1.o();
    }

    private void m()
    {
        gd.a(3, d, "closing ad unity view");
        onViewClose();
    }

    static void m(eb eb1)
    {
        eb1.p();
    }

    private void n()
    {
        g.loadUrl("javascript:(function() { document.getElementById('flurry_interstitial_close').style.display = 'none'; })()");
    }

    static boolean n(eb eb1)
    {
        return eb1.r();
    }

    static int o(eb eb1)
    {
        return eb1.getCurrentBinding();
    }

    private void o()
    {
        if (r() && !x)
        {
            x = true;
            h = new ImageButton(getContext());
            Object obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            float f1 = getResources().getDisplayMetrics().density;
            ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, (int)(10F * f1), (int)(10F * f1), 0);
            int i1 = (int)(50F * f1);
            int j1 = (int)(f1 * 50F);
            obj.height = i1;
            obj.width = j1;
            h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new el();
            ((el) (obj)).h();
            obj = ((el) (obj)).e();
            h.setBackgroundColor(0);
            h.setImageBitmap(((android.graphics.Bitmap) (obj)));
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final eb a;

                public void onClick(View view)
                {
                    a.a(aw.s, Collections.emptyMap(), a.getAdController(), 0);
                }

            
            {
                a = eb.this;
                super();
            }
            });
            setMraidButtonVisibility(false);
            addView(h);
        }
    }

    private void p()
    {
        g.loadUrl("javascript:if(window.mraid && typeof window.mraid.disable === 'function'){window.mraid.disable();}");
    }

    static void p(eb eb1)
    {
        eb1.q();
    }

    private void q()
    {
        g.loadUrl("javascript:var closeButtonDiv =  document.getElementById('flurry_interstitial_close');if (typeof(closeButtonDiv) == 'undefined' || closeButtonDiv == null){var newdiv = document.createElement('div');var divIdName = 'flurry_interstitial_close';newdiv.setAttribute('id',divIdName);newdiv.innerHTML = '<a href=\"flurry://flurrycall?event=adWillClose\"><div id=\"rtb_close\"><img src=\"http://cdn.flurry.com/adSpaceStyles.dev/images/bttn-close-bw.png\" alt=\"close advertisement\" /></div></a></div>';document.body.appendChild(newdiv);}");
    }

    static void q(eb eb1)
    {
        eb1.c();
    }

    static void r(eb eb1)
    {
        eb1.i();
    }

    private boolean r()
    {
        return getCurrentFormat().equals("takeover");
    }

    private void s()
    {
        if (getContext() instanceof Activity)
        {
            Activity activity = (Activity)getContext();
            if (r())
            {
                int i1 = cn.a(activity, getAdUnit().screenOrientation);
                if (-1 != i1)
                {
                    cn.a(activity, i1, true);
                    return;
                }
            }
        }
    }

    static void s(eb eb1)
    {
        eb1.e();
    }

    private void setFlurryJsEnvInitialized(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        j = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void setMraidButtonVisibility(boolean flag)
    {
label0:
        {
            if (h != null)
            {
                if (!flag)
                {
                    break label0;
                }
                h.setVisibility(0);
            }
            return;
        }
        h.setVisibility(4);
    }

    private void setMraidJsEnvInitialized(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        A = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean t(eb eb1)
    {
        return eb1.B;
    }

    static boolean u(eb eb1)
    {
        return eb1.c;
    }

    static View v(eb eb1)
    {
        return eb1.m;
    }

    static WebChromeClient w(eb eb1)
    {
        return eb1.l;
    }

    static FrameLayout x(eb eb1)
    {
        return eb1.q;
    }

    static Dialog y(eb eb1)
    {
        return eb1.p;
    }

    static Dialog z(eb eb1)
    {
        return eb1.s;
    }

    public void a(aw aw1, Map map, ap ap1, int i1)
    {
        gd.a(3, d, (new StringBuilder()).append("fireEvent(event=").append(aw1).append(",params=").append(map).append(")").toString());
        co.a(aw1, map, getContext(), getAdObject(), ap1, i1);
    }

    boolean a(View view)
    {
        view = view.getParent();
        return view != null && view == this;
    }

    public void cleanupLayout()
    {
        if (e != null)
        {
            e.cleanupLayout();
            e = null;
        }
        fz.a().a(b);
    }

    public void initLayout()
    {
        gd.a(3, d, (new StringBuilder()).append("initLayout: ad creative layout: {width = ").append(getCurrentAdFrame().adSpaceLayout.adWidth).append(", height = ").append(getCurrentAdFrame().adSpaceLayout.adHeight).append(", adFrameIndex = ").append(getAdController().c()).append(", context = ").append(getContext()).append("}").toString());
        cleanupLayout();
        fz.a().a("com.flurry.android.impl.ads.views.AdViewEvent", b);
        Object obj = getContext();
        removeAllViews();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestLayout();
        switch (getCurrentBinding())
        {
        default:
            obj = new HashMap();
            ((Map) (obj)).put("errorCode", Integer.toString(av.f.a()));
            a(aw.g, ((Map) (obj)), getAdController(), 0);
            return;

        case 3: // '\003'
            a(getCurrentDisplay(), ds.c);
            return;

        case 2: // '\002'
            cy cy1 = getAdController().d(getAdFrameIndex());
            if (cy1 != null)
            {
                a(cy1.f(), ds.a);
                return;
            }
            if (g == null)
            {
                g = new WebView(((Context) (obj)));
                g.getSettings().setJavaScriptEnabled(true);
                g.setVerticalScrollBarEnabled(false);
                g.setHorizontalScrollBarEnabled(false);
                g.setBackgroundColor(0);
                g.clearCache(false);
                l = new a();
                g.setWebChromeClient(l);
                k = new b();
                g.setWebViewClient(k);
            }
            g.loadDataWithBaseURL("base://url/", getCurrentDisplay(), "text/html", "utf-8", "base://url/");
            a(aw.f, Collections.emptyMap(), getAdController(), 0);
            g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            dismissProgressDialog();
            if (r())
            {
                showProgressDialog();
            }
            s();
            return;

        case 1: // '\001'
            break;
        }
        if (g == null)
        {
            g = new WebView(((Context) (obj)));
            g.getSettings().setJavaScriptEnabled(true);
            g.setVerticalScrollBarEnabled(false);
            g.setHorizontalScrollBarEnabled(false);
            g.setBackgroundColor(0);
            g.clearCache(false);
            l = new a();
            g.setWebChromeClient(l);
            k = new b();
            g.setWebViewClient(k);
        }
        if (a != null)
        {
            b(a);
        } else
        if (getAdFrameIndex() == 0)
        {
            String s1 = getAdController().v();
            if (s1 == null)
            {
                b(getCurrentDisplay());
            } else
            {
                String s2 = cv.c(getCurrentDisplay());
                g.loadDataWithBaseURL(s2, s1, "text/html", "utf-8", s2);
                a(aw.f, Collections.emptyMap(), getAdController(), 0);
            }
        } else
        {
            b(getCurrentDisplay());
        }
        g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        dismissProgressDialog();
        if (r())
        {
            showProgressDialog();
        }
        s();
    }

    public void onActivityDestroy()
    {
        gd.a(3, d, "onDestroy");
        if (z != null && z.isShowing())
        {
            z.dismiss();
            z = null;
        }
        dismissProgressDialog();
        if (e != null)
        {
            e.onActivityDestroy();
        }
        if (g != null)
        {
            if (l != null)
            {
                l.onHideCustomView();
            }
            if (s != null)
            {
                b(0, 0);
            }
            y = false;
            removeView(g);
            g.stopLoading();
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                g.onPause();
            }
            g.destroy();
            g = null;
        }
    }

    public void onActivityPause()
    {
        if (g != null && android.os.Build.VERSION.SDK_INT >= 11)
        {
            g.onPause();
        }
        if (e != null)
        {
            e.onActivityPause();
        }
        f = false;
        B = true;
    }

    public void onActivityResume()
    {
        fz.a().a("com.flurry.android.impl.ads.views.AdViewEvent", b);
        if (g != null && android.os.Build.VERSION.SDK_INT >= 11)
        {
            f = true;
            g.onResume();
        }
        if (e != null)
        {
            e.onActivityResume();
        }
        if (e != null)
        {
            f = true;
        }
        B = true;
    }

    public void onActivityStop()
    {
        if (z != null && z.isShowing())
        {
            z.dismiss();
            z = null;
        }
        if (e != null)
        {
            e.onActivityStop();
        }
        dismissProgressDialog();
    }

    public boolean onBackKey()
    {
        a(aw.s, Collections.emptyMap(), getAdController(), 0);
        return true;
    }

    protected void onViewLoadTimeout()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("errorCode", Integer.toString(av.c.a()));
        co.a(aw.s, hashmap, getContext(), getAdObject(), getAdController(), 0);
    }

    private class a extends WebChromeClient
    {

        final eb a;

        public void onHideCustomView()
        {
            gd.a(3, eb.c(a), "onHideCustomView()");
            if (!(a.getContext() instanceof Activity))
            {
                gd.a(3, eb.c(a), "no activity present");
            } else
            {
                Activity activity = (Activity)a.getContext();
                if (eb.v(a) != null)
                {
                    if (eb.z(a) != null)
                    {
                        eb.z(a).show();
                    }
                    ((ViewGroup)activity.getWindow().getDecorView()).removeView(eb.x(a));
                    eb.x(a).removeView(eb.v(a));
                    if (eb.y(a) != null && eb.y(a).isShowing())
                    {
                        eb.y(a).hide();
                        eb.y(a).setOnDismissListener(null);
                        eb.y(a).dismiss();
                    }
                    eb.a(a, null);
                    cn.a(activity, eb.A(a));
                    eb.B(a).onCustomViewHidden();
                    eb.a(a, null);
                    eb.a(a, null);
                    eb.a(a, null);
                    return;
                }
            }
        }

        public void onShowCustomView(View view, int i1, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            gd.a(3, eb.c(a), "onShowCustomView(14)");
            if (!(a.getContext() instanceof Activity))
            {
                gd.a(3, eb.c(a), "no activity present");
                return;
            }
            Activity activity = (Activity)a.getContext();
            if (eb.v(a) != null && eb.w(a) != null)
            {
                eb.w(a).onHideCustomView();
                return;
            }
            eb.a(a, view);
            eb.a(a, activity.getRequestedOrientation());
            eb.a(a, customviewcallback);
            eb.a(a, new FrameLayout(activity));
            eb.x(a).setBackgroundColor(0xff000000);
            eb.x(a).addView(eb.v(a), new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
            ((ViewGroup)activity.getWindow().getDecorView()).addView(eb.x(a), -1, -1);
            if (eb.y(a) == null)
            {
                eb.a(a, new Dialog(activity, 0x1030011, activity) {

                    final Activity a;
                    final a b;

                    public boolean dispatchTouchEvent(MotionEvent motionevent)
                    {
                        return a.dispatchTouchEvent(motionevent);
                    }

                    public boolean dispatchTrackballEvent(MotionEvent motionevent)
                    {
                        return a.dispatchTrackballEvent(motionevent);
                    }

                
                {
                    b = a.this;
                    a = activity;
                    super(context, i1);
                }
                });
                eb.y(a).getWindow().setType(1000);
                eb.y(a).setOnShowListener(new android.content.DialogInterface.OnShowListener() {

                    final a a;

                    public void onShow(DialogInterface dialoginterface)
                    {
                        if (eb.z(a.a) != null)
                        {
                            eb.z(a.a).hide();
                        }
                    }

                
                {
                    a = a.this;
                    super();
                }
                });
                eb.y(a).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                    final a a;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        gd.a(3, eb.c(a.a), "customViewFullScreenDialog.onDismiss()");
                        if (eb.v(a.a) != null && eb.w(a.a) != null)
                        {
                            eb.w(a.a).onHideCustomView();
                        }
                    }

                
                {
                    a = a.this;
                    super();
                }
                });
                eb.y(a).setCancelable(true);
                eb.y(a).show();
            }
            cn.a(activity, i1, true);
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            gd.a(3, eb.c(a), "onShowCustomView(7)");
            if (!(a.getContext() instanceof Activity))
            {
                gd.a(3, eb.c(a), "no activity present");
                return;
            } else
            {
                onShowCustomView(view, ((Activity)a.getContext()).getRequestedOrientation(), customviewcallback);
                return;
            }
        }

        private a()
        {
            a = eb.this;
            super();
        }

    }


    private class b extends WebViewClient
    {

        final eb a;

        public void onLoadResource(WebView webview, String s1)
        {
            gd.a(3, eb.c(a), (new StringBuilder()).append("onLoadResource: url = ").append(s1).toString());
            super.onLoadResource(webview, s1);
            if (s1 != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (!s1.equalsIgnoreCase(eb.d(a).getUrl()))
            {
                eb.e(a);
            }
            if (!eb.f(a) && Uri.parse(s1).getLastPathSegment() != null)
            {
                if (!eb.g(a))
                {
                    continue; /* Loop/switch isn't completed */
                }
                eb.a(a, true);
                eb.h(a);
                if (eb.i(a))
                {
                    eb.j(a);
                    eb.k(a);
                    eb.l(a);
                    return;
                }
            }
            continue; /* Loop/switch isn't completed */
            if (!eb.i(a)) goto _L1; else goto _L3
_L3:
            eb.m(a);
            if (eb.n(a) && eb.o(a) == 2)
            {
                eb.p(a);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void onPageFinished(WebView webview, String s1)
        {
            gd.a(3, eb.c(a), (new StringBuilder()).append("onPageFinished: url = ").append(s1).append(" adcontroller index: ").append(a.getAdController().c()).toString());
            if (s1 != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            eb.e(a);
            eb.s(a);
            a.dismissProgressDialog();
            if (!a.a(eb.d(a)) && (eb.o(a) == 2 || eb.o(a) == 1))
            {
                gd.a(3, eb.c(a), "adding WebView to AdUnityView");
                a.addView(eb.d(a));
            }
            eb.b(a, true);
            if (!eb.g(a))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (eb.f(a))
            {
                eb.j(a);
                eb.k(a);
                eb.l(a);
                return;
            }
            continue; /* Loop/switch isn't completed */
            if (!eb.f(a)) goto _L1; else goto _L3
_L3:
            webview = com.flurry.sdk.b.a("mraidAdNotSupported");
            eb.a(a, webview);
            s1 = new HashMap();
            a.a(webview, s1, a.getAdController(), 0);
            if (eb.n(a) && eb.o(a) == 2)
            {
                eb.p(a);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            gd.a(3, eb.c(a), (new StringBuilder()).append("onPageStarted: url = ").append(s1).toString());
            if (s1 == null || webview == null || webview != eb.d(a))
            {
                return;
            } else
            {
                eb.q(a);
                eb.r(a);
                eb.b(a, false);
                eb.a(a, false);
                return;
            }
        }

        public void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            gd.a(3, eb.c(a), (new StringBuilder()).append("onReceivedError: url = ").append(s2).toString());
            a.dismissProgressDialog();
            webview = Uri.parse(s2);
            if ("market".equals(webview.getScheme()))
            {
                s1 = new Intent("android.intent.action.VIEW");
                s1.setData(webview);
                a.getContext().startActivity(s1);
                eb.a(a);
                return;
            } else
            {
                webview = new HashMap();
                webview.put("errorCode", Integer.toString(av.q.a()));
                webview.put("webViewErrorCode", Integer.toString(i1));
                webview.put("failingUrl", s2);
                a.a(aw.g, webview, a.getAdController(), 0);
                return;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            boolean flag;
            flag = true;
            gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s1).toString());
            if (s1 != null && webview != null && webview == eb.d(a)) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            webview = cv.c(eb.d(a).getUrl());
            if (TextUtils.isEmpty(webview) || !s1.startsWith(webview))
            {
                break; /* Loop/switch isn't completed */
            }
            webview = s1.substring(webview.length());
            Uri uri = Uri.parse(webview);
            if (!uri.isHierarchical() || TextUtils.isEmpty(uri.getScheme()) || TextUtils.isEmpty(uri.getAuthority()))
            {
                break; /* Loop/switch isn't completed */
            }
            gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: target url = ").append(webview).toString());
_L5:
            s1 = Uri.parse(webview);
            gd.a(3, eb.c(a), (new StringBuilder()).append("shouldOverrideUrlLoading: getScheme = ").append(s1.getScheme()).toString());
            if ("flurry".equals(s1.getScheme()))
            {
                webview = s1.getQueryParameter("event");
                if (!TextUtils.isEmpty(webview))
                {
                    webview = com.flurry.sdk.b.a(webview);
                    eb.b(a, webview);
                    eb.a(a, webview, s1);
                    s1 = hp.h(s1.getEncodedQuery());
                    s1.put("requiresCallComplete", "true");
                    a.a(webview, s1, a.getAdController(), 0);
                    return true;
                }
            } else
            {
                if (eb.t(a))
                {
                    eb.c(a, false);
                    s1 = new HashMap();
                    a.a(aw.h, s1, a.getAdController(), 0);
                }
                if (a.getAdController().l())
                {
                    boolean flag1;
                    boolean flag2;
                    if (cv.d(webview))
                    {
                        gd.a(3, eb.c(a), "shouldOverrideUrlLoading: isMarketUrl ");
                        flag1 = cu.a(a.getContext(), webview);
                    } else
                    {
                        flag1 = false;
                    }
                    flag2 = flag1;
                    if (!flag1)
                    {
                        flag2 = flag1;
                        if (cv.f(webview))
                        {
                            gd.a(3, eb.c(a), "shouldOverrideUrlLoading: isGooglePlayUrl ");
                            flag2 = cu.b(a.getContext(), webview);
                        }
                    }
                    if (flag2)
                    {
                        a.a(aw.O, Collections.emptyMap(), a.getAdController(), 0);
                        return true;
                    } else
                    {
                        gd.a(3, eb.c(a), "shouldOverrideUrlLoading: loadUrl doGenericLaunch ");
                        com.flurry.sdk.i.a().o().a(a.getContext(), webview, true, a.getAdObject(), true, eb.u(a));
                        return true;
                    }
                } else
                {
                    gd.a(3, eb.c(a), "shouldOverrideUrlLoading: doGenericLaunch ");
                    com.flurry.sdk.i.a().o().a(a.getContext(), webview, true, a.getAdObject(), true, eb.u(a));
                    return true;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            webview = s1;
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        private b()
        {
            a = eb.this;
            super();
        }

    }

}
