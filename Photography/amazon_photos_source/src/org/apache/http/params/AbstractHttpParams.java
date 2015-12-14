// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.params;


// Referenced classes of package org.apache.http.params:
//            HttpParams

public abstract class AbstractHttpParams
    implements HttpParams
{

    protected AbstractHttpParams()
    {
    }

    public HttpParams setIntParameter(String s, int i)
    {
        setParameter(s, new Integer(i));
        return this;
    }
}
