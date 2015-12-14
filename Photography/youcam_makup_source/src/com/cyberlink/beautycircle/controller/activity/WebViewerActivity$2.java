// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.webkit.WebView;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.h;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WebViewerActivity

class a extends m
{

    final h a;
    final WebViewerActivity b;

    protected void a(int i)
    {
        b.l();
    }

    protected void a(com.cyberlink.beautycircle.model.network.leResult leresult)
    {
        if (android.os.T >= 19)
        {
            b.f.evaluateJavascript((new StringBuilder()).append("document.getElementById('fileId').value = '").append(leresult.fileId).append("'").toString(), null);
            b.f.evaluateJavascript((new StringBuilder()).append("document.getElementById('metadata').value = '").append(a.f.toString()).append("'").toString(), null);
        } else
        {
            b.f.loadUrl((new StringBuilder()).append("javascript:document.getElementById('fileId').value = '").append(leresult.fileId).append("'").toString());
            b.f.loadUrl((new StringBuilder()).append("javascript:document.getElementById('metadata').value = '").append(a.f.toString()).append("'").toString());
        }
        b.l();
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.leResult)obj);
    }

    lt(WebViewerActivity webvieweractivity, h h1)
    {
        b = webvieweractivity;
        a = h1;
        super();
    }
}
