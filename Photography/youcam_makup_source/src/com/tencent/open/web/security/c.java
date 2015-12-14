// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.a.k;
import com.tencent.open.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.tencent.open.web.security:
//            d

public class c extends a
{

    public c()
    {
    }

    public void a(String s, String s1, List list, b b1)
    {
        k.b("openSDK_LOG.SecureJs", (new StringBuilder()).append("-->getResult, objectName: ").append(s).append(" | methodName: ").append(s1).toString());
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            try
            {
                list.set(i, URLDecoder.decode((String)list.get(i), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }
            i++;
        }
        s = (com.tencent.open.c)a.get(s);
        if (s != null)
        {
            k.b("openSDK_LOG.SecureJs", "-->handler != null");
            s.a(s1, list, b1);
        } else
        {
            k.b("openSDK_LOG.SecureJs", "-->handler == null");
            if (b1 != null)
            {
                b1.a();
                return;
            }
        }
    }

    public boolean a(WebView webview, String s)
    {
        k.b("openSDK_LOG.SecureJs", (new StringBuilder()).append("-->canHandleUrl---url = ").append(s).toString());
        if (s == null)
        {
            return false;
        }
        if (!Uri.parse(s).getScheme().equals("jsbridge"))
        {
            return false;
        }
        ArrayList arraylist = new ArrayList(Arrays.asList((new StringBuilder()).append(s).append("/#").toString().split("/")));
        if (arraylist.size() < 7)
        {
            return false;
        }
        String s1 = (String)arraylist.get(2);
        String s2 = (String)arraylist.get(3);
        String s3 = (String)arraylist.get(4);
        String s4 = (String)arraylist.get(5);
        k.b("openSDK_LOG.SecureJs", (new StringBuilder()).append("-->canHandleUrl, objectName: ").append(s1).append(" | methodName: ").append(s2).append(" | snStr: ").append(s3).toString());
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
        {
            return false;
        }
        long l;
        try
        {
            l = Long.parseLong(s3);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return false;
        }
        webview = new d(webview, l, s, s4);
        a(s1, s2, arraylist.subList(6, arraylist.size() - 1), ((b) (webview)));
        return true;
    }
}
