// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewParent;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.b:
//            ck, f

public interface cj
{

    public abstract void a();

    public abstract void a(int i1);

    public abstract void a(AdSizeParcel adsizeparcel);

    public abstract void a(c c1);

    public abstract void a(String s);

    public abstract void a(String s, Map map);

    public abstract void a(String s, JSONObject jsonobject);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(c c1);

    public abstract void b(boolean flag);

    public abstract Activity c();

    public abstract Context d();

    public abstract c e();

    public abstract c f();

    public abstract AdSizeParcel g();

    public abstract Context getContext();

    public abstract android.view.ViewGroup.LayoutParams getLayoutParams();

    public abstract void getLocationOnScreen(int ai[]);

    public abstract int getMeasuredHeight();

    public abstract int getMeasuredWidth();

    public abstract ViewParent getParent();

    public abstract WebView getWebView();

    public abstract ck h();

    public abstract boolean i();

    public abstract f j();

    public abstract VersionInfoParcel k();

    public abstract boolean l();

    public abstract void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4);

    public abstract void loadUrl(String s);

    public abstract boolean m();

    public abstract void measure(int i1, int j1);

    public abstract void n();

    public abstract void o();

    public abstract void setBackgroundColor(int i1);

    public abstract void setContext(Context context);

    public abstract void setRequestedOrientation(int i1);

    public abstract boolean willNotDraw();
}
