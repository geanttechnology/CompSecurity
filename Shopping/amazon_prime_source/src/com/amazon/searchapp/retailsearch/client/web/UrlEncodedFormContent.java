// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            BasicRequestContent, UrlMaker, CollectionMap

public class UrlEncodedFormContent extends BasicRequestContent
{

    private final CollectionMap params;

    public UrlEncodedFormContent(CollectionMap collectionmap)
    {
        super(-1L, "application/x-www-form-urlencoded", "UTF-8", true);
        params = collectionmap;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        if (outputstream != null && params != null)
        {
            String s = UrlMaker.urlEncode(params);
            if (s != null)
            {
                outputstream = new BufferedWriter(new OutputStreamWriter(outputstream, "UTF-8"));
                outputstream.write(s);
                outputstream.flush();
                return;
            }
        }
    }
}
