// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            PoGSearch

public class 
{

    public static void inject(com.f2prateek.dart.r r, PoGSearch pogsearch, Object obj)
    {
        Object obj1 = r.r(obj, "context");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'context' for field 'contxt' was not found. If this extra is optional add '@Optional' annotation.");
        }
        pogsearch.contxt = (String)obj1;
        obj1 = r.r(obj, "url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'url' for field 'targetUrl' was not found. If this extra is optional add '@Optional' annotation.");
        }
        pogsearch.targetUrl = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "display_coach_mark")));
        if (r != null)
        {
            pogsearch.displayCoachMark = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
