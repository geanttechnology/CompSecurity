// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http.entityhandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

// Referenced classes of package net.tsz.afinal.http.entityhandler:
//            EntityCallBack

public class StringEntityHandler
{

    public StringEntityHandler()
    {
    }

    public Object handleEntity(HttpEntity httpentity, EntityCallBack entitycallback, String s)
        throws IOException
    {
        if (httpentity == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        long l2 = httpentity.getContentLength();
        long l = 0L;
        httpentity = httpentity.getContent();
        do
        {
            long l1;
            do
            {
                int i = httpentity.read(abyte0);
                if (i == -1)
                {
                    if (entitycallback != null)
                    {
                        entitycallback.callBack(l2, l, true);
                    }
                    entitycallback = bytearrayoutputstream.toByteArray();
                    bytearrayoutputstream.close();
                    httpentity.close();
                    return new String(entitycallback, s);
                }
                bytearrayoutputstream.write(abyte0, 0, i);
                l1 = l + (long)i;
                l = l1;
            } while (entitycallback == null);
            entitycallback.callBack(l2, l1, false);
            l = l1;
        } while (true);
    }
}
