// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads.internal:
//            AdWebView

class a
    implements DownloadListener
{

    final AdWebView a;

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        try
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setDataAndType(Uri.parse(s), s3);
            s2 = a.i();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            b.a((new StringBuilder()).append("Couldn't find an Activity to view url/mimetype: ").append(s).append(" / ").append(s3).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            b.b((new StringBuilder()).append("Unknown error trying to start activity to view URL: ").append(s).toString(), s1);
            return;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (AdUtil.a(s1, s2))
        {
            s2.startActivity(s1);
        }
    }

    ption(AdWebView adwebview)
    {
        a = adwebview;
        super();
    }
}
