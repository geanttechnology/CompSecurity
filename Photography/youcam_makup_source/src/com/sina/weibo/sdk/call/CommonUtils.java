// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.call;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.sina.weibo.sdk.call:
//            WeiboNotInstalledException

class CommonUtils
{

    CommonUtils()
    {
    }

    public static String buildUriQuery(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            String s;
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    return stringbuilder.toString().replaceFirst("&", "?");
                }
                s = (String)iterator.next();
                s1 = (String)hashmap.get(s);
            } while (s1 == null);
            stringbuilder.append("&").append(s).append("=").append(s1);
        } while (true);
    }

    public static void openWeiboActivity(Context context, String s, String s1)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction(s);
            intent.setData(Uri.parse(s1));
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new WeiboNotInstalledException("\u65E0\u6CD5\u627E\u5230\u5FAE\u535A\u5B98\u65B9\u5BA2\u6237\u7AEF");
        }
    }

    public static void openWeiboActivity(Context context, String s, String s1, String s2)
    {
        if (s2 != null)
        {
            Intent intent1;
            try
            {
                Intent intent = new Intent();
                intent.setAction(s);
                intent.setData(Uri.parse(s1));
                intent.setPackage(s2);
                context.startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception) { }
            break MISSING_BLOCK_LABEL_79;
        }
        intent1 = new Intent();
        intent1.setAction(s);
        intent1.setData(Uri.parse(s1));
        context.startActivity(intent1);
        return;
        if (s2 != null)
        {
            try
            {
                s2 = new Intent();
                s2.setAction(s);
                s2.setData(Uri.parse(s1));
                context.startActivity(s2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new WeiboNotInstalledException("\u65E0\u6CD5\u627E\u5230\u5FAE\u535A\u5B98\u65B9\u5BA2\u6237\u7AEF");
            }
        } else
        {
            throw new WeiboNotInstalledException("\u65E0\u6CD5\u627E\u5230\u5FAE\u535A\u5B98\u65B9\u5BA2\u6237\u7AEF");
        }
    }
}
