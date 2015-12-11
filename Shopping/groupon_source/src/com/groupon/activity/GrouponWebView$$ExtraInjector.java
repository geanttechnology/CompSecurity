// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            GrouponWebView

public class 
{

    public static void inject(com.f2prateek.dart.r r, GrouponWebView grouponwebview, Object obj)
    {
        Object obj1 = r.r(obj, "url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'url' for field 'url' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponwebview.url = (String)obj1;
        obj1 = r.r(obj, "needs_x_cookies");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'needs_x_cookies' for field 'needsXCookies' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponwebview.needsXCookies = ((Boolean)obj1).booleanValue();
        obj1 = r.(obj, "needs_location");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'needs_location' for field 'needsLocation' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponwebview.needsLocation = ((Boolean)obj1).booleanValue();
        obj1 = r.(obj, "hide_header");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hide_header' for field 'hideHeader' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponwebview.hideHeader = ((Boolean)obj1).booleanValue();
        r = ((com.f2prateek.dart.) (r.(obj, "isDeepLinked")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'isDeepLinked' for field 'isDeepLinked' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            grouponwebview.isDeepLinked = ((Boolean)r).booleanValue();
            return;
        }
    }

    public ()
    {
    }
}
