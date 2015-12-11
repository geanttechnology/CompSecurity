// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            PoGWebview

public class 
{

    public static void inject(com.f2prateek.dart.r r, PoGWebview pogwebview, Object obj)
    {
        Object obj1 = r.r(obj, "url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'url' for field 'url' was not found. If this extra is optional add '@Optional' annotation.");
        }
        pogwebview.url = (String)obj1;
        obj1 = r.r(obj, "context");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'context' for field 'contxt' was not found. If this extra is optional add '@Optional' annotation.");
        }
        pogwebview.contxt = (String)obj1;
        obj1 = r.r(obj, "placeId");
        if (obj1 != null)
        {
            pogwebview.placeId = (String)obj1;
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "survey_id")));
        if (r != null)
        {
            pogwebview.surveyId = (String)r;
        }
    }

    public ()
    {
    }
}
