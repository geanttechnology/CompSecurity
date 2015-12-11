// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.params;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.params:
//            AbstractHttpParams, HttpParams

public final class DefaultedHttpParams extends AbstractHttpParams
{

    private final HttpParams defaults;
    private final HttpParams local;

    public HttpParams getDefaults()
    {
        return defaults;
    }

    public Object getParameter(String s)
    {
        Object obj1 = local.getParameter(s);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (defaults != null)
            {
                obj = defaults.getParameter(s);
            }
        }
        return obj;
    }

    public HttpParams setParameter(String s, Object obj)
    {
        return local.setParameter(s, obj);
    }
}
