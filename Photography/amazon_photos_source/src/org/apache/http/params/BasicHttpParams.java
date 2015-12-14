// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package org.apache.http.params:
//            AbstractHttpParams, HttpParams

public final class BasicHttpParams extends AbstractHttpParams
    implements Serializable, Cloneable
{

    private final HashMap parameters = new HashMap();

    public BasicHttpParams()
    {
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        BasicHttpParams basichttpparams = (BasicHttpParams)super.clone();
        copyParams(basichttpparams);
        return basichttpparams;
    }

    protected void copyParams(HttpParams httpparams)
    {
        Iterator iterator = parameters.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getKey() instanceof String)
            {
                httpparams.setParameter((String)entry.getKey(), entry.getValue());
            }
        } while (true);
    }

    public HttpParams setParameter(String s, Object obj)
    {
        parameters.put(s, obj);
        return this;
    }
}
