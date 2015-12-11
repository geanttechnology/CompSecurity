// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONObject;

public class chk
    implements che
{

    private static final String a = chk.getCanonicalName();
    private final HttpClient b = a.y();
    private final chh c;

    public chk(chh chh1)
    {
        c = chh1;
    }

    private cgc a(cgm cgm1)
    {
        Object obj3;
        if (cgm1 == null)
        {
            return null;
        }
        obj3 = c.a(cgm1);
        Object obj = b.execute(((org.apache.http.client.methods.HttpUriRequest) (obj3)));
        cgm1 = ((cgm) (obj));
        int i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        cgm1 = ((cgm) (obj));
        if (((HttpResponse) (obj)).getEntity() == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        cgm1 = ((cgm) (obj));
        ((HttpResponse) (obj)).getEntity().consumeContent();
        cgm1 = ((cgm) (obj));
        Object obj1 = a;
        cgm1 = ((cgm) (obj));
        String s = String.valueOf(((HttpPost) (obj3)).getURI());
        cgm1 = ((cgm) (obj));
        Log.w(((String) (obj1)), (new StringBuilder(String.valueOf(s).length() + 42)).append("GET ").append(s).append(" failed. Response code is: ").append(i).toString());
        a.a(((HttpResponse) (obj)));
        return null;
        cgm1 = ((cgm) (obj));
        obj1 = (new chm((new JSONObject((new BasicResponseHandler()).handleResponse(((HttpResponse) (obj))))).getJSONObject("screen"))).a();
        a.a(((HttpResponse) (obj)));
        return ((cgc) (obj1));
        Object obj2;
        obj2;
        obj = null;
_L6:
        cgm1 = ((cgm) (obj));
        s = a;
        cgm1 = ((cgm) (obj));
        obj3 = String.valueOf(((HttpPost) (obj3)).getURI());
        cgm1 = ((cgm) (obj));
        Log.e(s, (new StringBuilder(String.valueOf(obj3).length() + 19)).append("Error loading from ").append(((String) (obj3))).toString(), ((Throwable) (obj2)));
        a.a(((HttpResponse) (obj)));
        return null;
        obj2;
        obj = null;
_L4:
        cgm1 = ((cgm) (obj));
        Log.e(a, "Error loading screen info.", ((Throwable) (obj2)));
        a.a(((HttpResponse) (obj)));
        return null;
        cgm1;
        obj2 = null;
        obj = cgm1;
_L2:
        a.a(((HttpResponse) (obj2)));
        throw obj;
        obj;
        obj2 = cgm1;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final volatile Object a(Object obj)
    {
        return a((cgm)obj);
    }

}
