// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            PoGAutocomplete

public class _cls9
{

    public static void inject(com.f2prateek.dart.r r, PoGAutocomplete pogautocomplete, Object obj)
    {
        Object obj1 = r.r(obj, "context");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'context' for field 'context' was not found. If this extra is optional add '@Optional' annotation.");
        }
        pogautocomplete.context = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "url")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'url' for field 'targetUrl' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            pogautocomplete.targetUrl = (String)r;
            return;
        }
    }

    public _cls9()
    {
    }
}
