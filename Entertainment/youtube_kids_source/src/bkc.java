// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class bkc extends HttpEntityWrapper
{

    bkc(bkb bkb, HttpEntity httpentity)
    {
        super(httpentity);
    }

    public final InputStream getContent()
    {
        return new GZIPInputStream(wrappedEntity.getContent());
    }

    public final long getContentLength()
    {
        return -1L;
    }

    public final void writeTo(OutputStream outputstream)
    {
        InputStream inputstream = getContent();
        byte abyte0[] = new byte[2048];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }
}
