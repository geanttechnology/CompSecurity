// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;

public class chi
    implements chl
{

    private static final String a = chi.getCanonicalName();
    private final HttpClient b = a.y();
    private final chh c;

    public chi(chh chh1)
    {
        c = chh1;
    }

    static String a()
    {
        return a;
    }

    private Map a(Set set)
    {
        HttpResponse httpresponse;
        Object obj1;
        HttpPost httppost;
        b.b();
        httppost = c.a(set);
        obj1 = null;
        set = null;
        httpresponse = null;
        HttpResponse httpresponse1 = b.execute(httppost);
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        int i = httpresponse1.getStatusLine().getStatusCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        Object obj2 = a;
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        String s = String.valueOf(httppost.getURI());
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        Log.w(((String) (obj2)), (new StringBuilder(String.valueOf(s).length() + 43)).append("POST ").append(s).append(" failed. Response code is: ").append(i).toString());
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        obj2 = new ByteArrayOutputStream();
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        httpresponse1.getEntity().writeTo(((java.io.OutputStream) (obj2)));
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        obj2 = Collections.emptyMap();
        a.a(httpresponse1);
        return ((Map) (obj2));
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        set = httpresponse1;
        obj2 = (new chj(this, (new BasicResponseHandler()).handleResponse(httpresponse1))).a();
        a.a(httpresponse1);
        return ((Map) (obj2));
        obj1;
        set = httpresponse;
        Log.e(a, String.format("Error loading from %s, %s", new Object[] {
            httppost.getURI(), ((IOException) (obj1)).getMessage()
        }));
        a.a(httpresponse);
_L2:
        return Collections.emptyMap();
        Object obj;
        obj;
        set = ((Set) (obj1));
        Log.e(a, "Error loading screen status.", ((Throwable) (obj)));
        a.a(((HttpResponse) (obj1)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        a.a(set);
        throw obj;
    }

    public final Map a(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            return Collections.emptyMap();
        }
        HashMap hashmap = new HashMap();
        cgc cgc1;
        for (collection = collection.iterator(); collection.hasNext(); hashmap.put(cgc1.f, cgc1))
        {
            cgc1 = (cgc)collection.next();
        }

        collection = a(hashmap.keySet());
        HashMap hashmap1 = new HashMap();
        cgj cgj1;
        for (Iterator iterator = collection.keySet().iterator(); iterator.hasNext(); hashmap1.put(hashmap.get(cgj1), collection.get(cgj1)))
        {
            cgj1 = (cgj)iterator.next();
        }

        return hashmap1;
    }

}
