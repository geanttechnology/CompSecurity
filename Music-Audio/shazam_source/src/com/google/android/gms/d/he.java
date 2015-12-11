// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Context;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            v, hf, o

public interface he
    extends v
{

    public abstract void a();

    public abstract void a(int i1);

    public abstract void a(Context context, AdSizeParcel adsizeparcel);

    public abstract void a(AdSizeParcel adsizeparcel);

    public abstract void a(d d1);

    public abstract void a(String s);

    public abstract void a(String s, String s1);

    public abstract void a(String s, Map map);

    public abstract void a(String s, JSONObject jsonobject);

    public abstract void b();

    public abstract void b(d d1);

    public abstract void b(String s);

    public abstract void b(String s, JSONObject jsonobject);

    public abstract void b(boolean flag);

    public abstract Activity c();

    public abstract void c(String s);

    public abstract void c(boolean flag);

    public abstract Context d();

    public abstract void d(boolean flag);

    public abstract void destroy();

    public abstract com.google.android.gms.ads.internal.d e();

    public abstract d f();

    public abstract d g();

    public abstract Context getContext();

    public abstract android.view.ViewGroup.LayoutParams getLayoutParams();

    public abstract void getLocationOnScreen(int ai[]);

    public abstract int getMeasuredHeight();

    public abstract int getMeasuredWidth();

    public abstract ViewParent getParent();

    public abstract String getRequestId();

    public abstract int getRequestedOrientation();

    public abstract WebView getWebView();

    public abstract AdSizeParcel h();

    public abstract hf i();

    public abstract boolean j();

    public abstract o k();

    public abstract VersionInfoParcel l();

    public abstract void loadData(String s, String s1, String s2);

    public abstract void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4);

    public abstract void loadUrl(String s);

    public abstract boolean m();

    public abstract void measure(int i1, int j1);

    public abstract boolean n();

    public abstract void o();

    public abstract boolean p();

    public abstract void q();

    public abstract String r();

    public abstract void setBackgroundColor(int i1);

    public abstract void setContext(Context context);

    public abstract void setOnClickListener(android.view.View.OnClickListener onclicklistener);

    public abstract void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener);

    public abstract void setRequestedOrientation(int i1);

    public abstract void setWebViewClient(WebViewClient webviewclient);

    public abstract void setWillNotDraw(boolean flag);

    public abstract void stopLoading();

    public abstract boolean willNotDraw();
}
