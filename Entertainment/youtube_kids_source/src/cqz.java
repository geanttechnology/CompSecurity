// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

public class cqz
    implements cot
{

    public final bkf a;
    private List b;
    private String c;

    public cqz(bkf bkf1, String s, List list)
    {
        b = (List)b.a(list);
        a = (bkf)b.a(bkf1);
        c = b.a(s, "contentType can't be null or empty");
    }

    public cqz(bkf bkf1, List list)
    {
        b = (List)b.a(list);
        a = (bkf)b.a(bkf1);
        c = null;
    }

    public Object a(Object obj)
    {
        return b((cqy)obj);
    }

    public HttpUriRequest a(cqy cqy1)
    {
        return a.a(cqy1.a);
    }

    public HttpUriRequest b(cqy cqy1)
    {
        b.a(cqy1);
        if (cqy1.c != null)
        {
            bkf bkf1 = a;
            boolean flag;
            if (bkf1 == bkf.b || bkf1 == bkf.c || bkf1 == bkf.d)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                cqy1 = String.valueOf(a);
                throw new IllegalArgumentException((new StringBuilder(String.valueOf(cqy1).length() + 29)).append("Content not allowed [method=").append(cqy1).append("]").toString());
            }
        }
        HttpUriRequest httpurirequest = a(cqy1);
        httpurirequest.setHeader("Accept-Encoding", "gzip");
        java.util.Map.Entry entry;
        for (Iterator iterator = cqy1.b.entrySet().iterator(); iterator.hasNext(); httpurirequest.setHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); ((crc)iterator1.next()).a(httpurirequest)) { }
        if (cqy1.c != null)
        {
            cqy1 = new ByteArrayEntity(cqy1.c);
            cqy1.setContentType(c);
            ((HttpEntityEnclosingRequestBase)httpurirequest).setEntity(cqy1);
        }
        return httpurirequest;
    }
}
