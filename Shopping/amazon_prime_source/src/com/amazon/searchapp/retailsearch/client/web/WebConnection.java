// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            WebResponse

public interface WebConnection
{

    public abstract void abort();

    public abstract void disconnect();

    public abstract WebResponse getResponse()
        throws IOException;
}
