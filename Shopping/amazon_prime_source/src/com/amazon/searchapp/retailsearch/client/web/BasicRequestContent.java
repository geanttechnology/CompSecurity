// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            RequestContent

public abstract class BasicRequestContent
    implements RequestContent
{

    private final String encoding;
    private final long length;
    private final boolean repeatable;
    private final String type;

    public BasicRequestContent(long l, String s, String s1, boolean flag)
    {
        length = l;
        type = s;
        encoding = s1;
        repeatable = flag;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public long getLength()
    {
        return length;
    }

    public String getType()
    {
        return type;
    }

    public boolean isRepeatable()
    {
        return repeatable;
    }

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
