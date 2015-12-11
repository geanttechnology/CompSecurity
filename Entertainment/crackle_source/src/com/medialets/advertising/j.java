// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.medialets.advertising:
//            a, d

final class j
    implements Runnable
{

    private List a;
    private int b;
    private d c;

    public j(List list, int i, d d1)
    {
        a = list;
        b = i;
        c = d1;
    }

    public final void run()
    {
        int k = a.size();
        int i = 0;
_L2:
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        int l;
        String s = ((String)a.get(i)).replace("[MM_RANDOM]", String.valueOf(b));
        HttpGet httpget = new HttpGet(s);
        com.medialets.advertising.a.d((new StringBuilder()).append("Executing tracking request for : ").append(s).toString());
        l = c.execute(httpget).getStatusLine().getStatusCode();
        com.medialets.advertising.a.d((new StringBuilder()).append("Tracking Pixel Status Code is: ").append(l).toString());
        if (l != 200)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        com.medialets.advertising.a.d("Successfully executed tracking pixel request.");
        break MISSING_BLOCK_LABEL_213;
        com.medialets.advertising.a.d((new StringBuilder()).append("TrackingPixel request failed with code: ").append(l).toString());
        break MISSING_BLOCK_LABEL_213;
        Object obj;
        obj;
        com.medialets.advertising.a.d((new StringBuilder()).append("TrackingPixel request failed with exception: ").append(((Exception) (obj)).toString()).toString());
        c.a();
        return;
        c.a();
        return;
        obj;
        c.a();
        throw obj;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
