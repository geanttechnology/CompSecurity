// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.ref.ObjectReference;

// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, UriRequest, LoaderContext

public abstract class UriLoader extends ResourceLoader
{

    private final UriRequest uriRequest;

    public UriLoader(LoaderContext loadercontext, Class class1, ObjectReference objectreference, long l, UriRequest urirequest)
    {
        super(loadercontext, class1, objectreference, l);
        uriRequest = urirequest;
    }

    public Object getResourceRequest()
    {
        return uriRequest;
    }
}
