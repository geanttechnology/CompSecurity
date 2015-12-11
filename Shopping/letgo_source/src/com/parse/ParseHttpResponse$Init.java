// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseHttpResponse

static abstract class 
{

    private InputStream content;
    private String contentType;
    private Map headers;
    private String reasonPhrase;
    private int statusCode;
    private int totalSize;

    abstract  self();

    public  setContent(InputStream inputstream)
    {
        content = inputstream;
        return self();
    }

    public self setContentType(String s)
    {
        contentType = s;
        return self();
    }

    public self setHeaders(Map map)
    {
        headers = Collections.unmodifiableMap(new HashMap(map));
        return self();
    }

    public self setReasonPhase(String s)
    {
        reasonPhrase = s;
        return self();
    }

    public self setStatusCode(int i)
    {
        statusCode = i;
        return self();
    }

    public self setTotalSize(int i)
    {
        totalSize = i;
        return self();
    }







    ()
    {
    }
}
