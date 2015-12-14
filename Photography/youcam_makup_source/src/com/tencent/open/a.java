// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.tencent.open:
//            c, b

public class a
{

    protected HashMap a;

    public a()
    {
        a = new HashMap();
    }

    public void a(c c1, String s)
    {
        a.put(s, c1);
    }

    public void a(String s, String s1, List list, b b1)
    {
        k.b("openSDK_LOG.JsBridge", (new StringBuilder()).append("getResult---objName = ").append(s).append(" methodName = ").append(s1).toString());
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
        s = (c)a.get(s);
        if (s != null)
        {
            k.b("openSDK_LOG.JsBridge", "call----");
            s.a(s1, list, b1);
        } else
        {
            k.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
            if (b1 != null)
            {
                b1.a();
                return;
            }
        }
    }

    public boolean a(WebView webview, String s)
    {
        k.b("openSDK_LOG.JsBridge", (new StringBuilder()).append("-->canHandleUrl---url = ").append(s).toString());
        break MISSING_BLOCK_LABEL_24;
        if (s != null && Uri.parse(s).getScheme().equals("jsbridge"))
        {
            Object obj = new ArrayList(Arrays.asList((new StringBuilder()).append(s).append("/#").toString().split("/")));
            if (((ArrayList) (obj)).size() >= 6)
            {
                String s1 = (String)((ArrayList) (obj)).get(2);
                String s2 = (String)((ArrayList) (obj)).get(3);
                obj = ((ArrayList) (obj)).subList(4, ((ArrayList) (obj)).size() - 1);
                s = new b(webview, 4L, s);
                webview.getUrl();
                a(s1, s2, ((List) (obj)), ((b) (s)));
                return true;
            }
        }
        return false;
    }
}
