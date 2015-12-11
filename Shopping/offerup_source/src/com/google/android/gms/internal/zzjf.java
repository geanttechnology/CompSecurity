// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzid

public class zzjf extends WebChromeClient
{

    private final zziz zzoM;

    public zzjf(zziz zziz1)
    {
        zzoM = zziz1;
    }

    private static void zza(android.app.AlertDialog.Builder builder, String s, JsResult jsresult)
    {
        builder.setMessage(s).setPositiveButton(0x104000a, new _cls3(jsresult)).setNegativeButton(0x1040000, new _cls2(jsresult)).setOnCancelListener(new _cls1(jsresult)).create().show();
    }

    private static void zza(Context context, android.app.AlertDialog.Builder builder, String s, String s1, JsPromptResult jspromptresult)
    {
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setOrientation(1);
        TextView textview = new TextView(context);
        textview.setText(s);
        context = new EditText(context);
        context.setText(s1);
        linearlayout.addView(textview);
        linearlayout.addView(context);
        builder.setView(linearlayout).setPositiveButton(0x104000a, new _cls6(jspromptresult, context)).setNegativeButton(0x1040000, new _cls5(jspromptresult)).setOnCancelListener(new _cls4(jspromptresult)).create().show();
    }

    private final Context zzc(WebView webview)
    {
        if (!(webview instanceof zziz))
        {
            webview = webview.getContext();
        } else
        {
            zziz zziz1 = (zziz)webview;
            android.app.Activity activity = zziz1.zzgZ();
            webview = activity;
            if (activity == null)
            {
                return zziz1.getContext();
            }
        }
        return webview;
    }

    private final boolean zzhE()
    {
        return zzp.zzbv().zza(zzoM.getContext().getPackageManager(), zzoM.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzp.zzbv().zza(zzoM.getContext().getPackageManager(), zzoM.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final void onCloseWindow(WebView webview)
    {
        if (!(webview instanceof zziz))
        {
            zzb.zzaH("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        webview = ((zziz)webview).zzhc();
        if (webview == null)
        {
            zzb.zzaH("Tried to close an AdWebView not associated with an overlay.");
            return;
        } else
        {
            webview.close();
            return;
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        String s;
        s = (new StringBuilder("JS: ")).append(consolemessage.message()).append(" (").append(consolemessage.sourceId()).append(":").append(consolemessage.lineNumber()).append(")").toString();
        if (s.contains("Application Cache"))
        {
            return super.onConsoleMessage(consolemessage);
        }
        _cls7.zzKG[consolemessage.messageLevel().ordinal()];
        JVM INSTR tableswitch 1 5: default 108
    //                   1 118
    //                   2 125
    //                   3 132
    //                   4 132
    //                   5 139;
           goto _L1 _L2 _L3 _L4 _L4 _L5
_L1:
        zzb.zzaG(s);
_L7:
        return super.onConsoleMessage(consolemessage);
_L2:
        zzb.e(s);
        continue; /* Loop/switch isn't completed */
_L3:
        zzb.zzaH(s);
        continue; /* Loop/switch isn't completed */
_L4:
        zzb.zzaG(s);
        continue; /* Loop/switch isn't completed */
_L5:
        zzb.zzaF(s);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        android.webkit.WebView.WebViewTransport webviewtransport = (android.webkit.WebView.WebViewTransport)message.obj;
        webview = new WebView(webview.getContext());
        webview.setWebViewClient(zzoM.zzhe());
        webviewtransport.setWebView(webview);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        long l3;
        l3 = 0x500000L - l2;
        if (l3 <= 0L)
        {
            quotaupdater.updateQuota(l);
            return;
        }
        if (l != 0L) goto _L2; else goto _L1
_L1:
        if (l1 > l3 || l1 > 0x100000L)
        {
            l1 = 0L;
        }
_L4:
        quotaupdater.updateQuota(l1);
        return;
_L2:
        if (l1 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        l2 = Math.min(Math.min(0x20000L, l3) + l, 0x100000L);
_L5:
        l1 = l2;
        if (true) goto _L4; else goto _L3
_L3:
        l2 = l;
        if (l1 <= Math.min(0x100000L - l, l3))
        {
            l2 = l + l1;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public final void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
    {
        if (callback != null)
        {
            callback.invoke(s, zzhE(), true);
        }
    }

    public final void onHideCustomView()
    {
        zzd zzd1 = zzoM.zzhc();
        if (zzd1 == null)
        {
            zzb.zzaH("Could not get ad overlay when hiding custom view.");
            return;
        } else
        {
            zzd1.zzeD();
            return;
        }
    }

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        return zza(zzc(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        return zza(zzc(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        return zza(zzc(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        return zza(zzc(webview), s, s1, s2, null, jspromptresult, true);
    }

    public final void onReachedMaxAppCacheSize(long l, long l1, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        l = 0x20000L + l;
        if (0x500000L - l1 < l)
        {
            quotaupdater.updateQuota(0L);
            return;
        } else
        {
            quotaupdater.updateQuota(l);
            return;
        }
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        zza(view, -1, customviewcallback);
    }

    protected final void zza(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        zzd zzd1 = zzoM.zzhc();
        if (zzd1 == null)
        {
            zzb.zzaH("Could not get ad overlay when showing custom view.");
            customviewcallback.onCustomViewHidden();
            return;
        } else
        {
            zzd1.zza(view, customviewcallback);
            zzd1.setRequestedOrientation(i);
            return;
        }
    }

    protected boolean zza(Context context, String s, String s1, String s2, JsResult jsresult, JsPromptResult jspromptresult, boolean flag)
    {
        android.app.AlertDialog.Builder builder;
        builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(s);
        if (flag)
        {
            try
            {
                zza(context, builder, s1, s2, jspromptresult);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                zzb.zzd("Fail to display Dialog.", context);
            }
            break MISSING_BLOCK_LABEL_55;
        }
        zza(builder, s1, jsresult);
        return true;
    }

    private class _cls3
        implements android.content.DialogInterface.OnClickListener
    {

        final JsResult zzKD;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            zzKD.confirm();
        }

        _cls3(JsResult jsresult)
        {
            zzKD = jsresult;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnClickListener
    {

        final JsResult zzKD;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            zzKD.cancel();
        }

        _cls2(JsResult jsresult)
        {
            zzKD = jsresult;
            super();
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnCancelListener
    {

        final JsResult zzKD;

        public final void onCancel(DialogInterface dialoginterface)
        {
            zzKD.cancel();
        }

        _cls1(JsResult jsresult)
        {
            zzKD = jsresult;
            super();
        }
    }


    private class _cls6
        implements android.content.DialogInterface.OnClickListener
    {

        final JsPromptResult zzKE;
        final EditText zzKF;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            zzKE.confirm(zzKF.getText().toString());
        }

        _cls6(JsPromptResult jspromptresult, EditText edittext)
        {
            zzKE = jspromptresult;
            zzKF = edittext;
            super();
        }
    }


    private class _cls5
        implements android.content.DialogInterface.OnClickListener
    {

        final JsPromptResult zzKE;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            zzKE.cancel();
        }

        _cls5(JsPromptResult jspromptresult)
        {
            zzKE = jspromptresult;
            super();
        }
    }


    private class _cls4
        implements android.content.DialogInterface.OnCancelListener
    {

        final JsPromptResult zzKE;

        public final void onCancel(DialogInterface dialoginterface)
        {
            zzKE.cancel();
        }

        _cls4(JsPromptResult jspromptresult)
        {
            zzKE = jspromptresult;
            super();
        }
    }


    private class _cls7
    {

        static final int zzKG[];

        static 
        {
            zzKG = new int[android.webkit.ConsoleMessage.MessageLevel.values().length];
            try
            {
                zzKG[android.webkit.ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                zzKG[android.webkit.ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                zzKG[android.webkit.ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                zzKG[android.webkit.ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                zzKG[android.webkit.ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
