// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.squareup.okhttp.OkHttpClient;
import org.json.JSONArray;

// Referenced classes of package android.support.v7:
//            iy

class b
    implements Runnable
{

    final JSONArray a;
    final long b;
    final iy c;

    public void run()
    {
        c.a(new OkHttpClient(), a.toString(), b);
    }

    tpClient(iy iy1, JSONArray jsonarray, long l)
    {
        c = iy1;
        a = jsonarray;
        b = l;
        super();
    }
}
