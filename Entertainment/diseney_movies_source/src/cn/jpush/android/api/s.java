// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;

// Referenced classes of package cn.jpush.android.api:
//            q, r

final class s
    implements android.view.View.OnClickListener
{

    final WindowManager a;
    final WebView b;
    final ImageButton c;
    final r d;

    s(r r, WindowManager windowmanager, WebView webview, ImageButton imagebutton)
    {
        d = r;
        a = windowmanager;
        b = webview;
        c = imagebutton;
        super();
    }

    public final void onClick(View view)
    {
        q.a(a, b, c);
    }
}
