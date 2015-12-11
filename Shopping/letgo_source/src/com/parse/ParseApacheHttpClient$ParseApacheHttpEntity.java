// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

// Referenced classes of package com.parse:
//            ParseApacheHttpClient, ParseHttpBody

private static class parseBody extends InputStreamEntity
{

    private ParseHttpBody parseBody;

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        parseBody.writeTo(outputstream);
    }

    public (ParseHttpBody parsehttpbody)
    {
        super(parsehttpbody.getContent(), parsehttpbody.getContentLength());
        super.setContentType(parsehttpbody.getContentType());
        parseBody = parsehttpbody;
    }
}
