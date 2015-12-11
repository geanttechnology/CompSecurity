// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

// Referenced classes of package com.parse:
//            ParseApacheHttpClient

private static class parseBody extends InputStreamEntity
{

    private ParseHttpBody parseBody;

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        parseBody.writeTo(outputstream);
    }

    public (ParseHttpBody parsehttpbody)
        throws IOException
    {
        super(parsehttpbody.getContent(), parsehttpbody.getContentLength());
        super.setContentType(parsehttpbody.getContentType());
        parseBody = parsehttpbody;
    }
}
