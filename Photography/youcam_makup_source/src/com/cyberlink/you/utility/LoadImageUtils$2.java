// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.os.AsyncTask;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.cyberlink.you.utility:
//            g, LoadImageUtils, d, m

final class b
    implements g
{

    final String a;
    final m b;

    public void a()
    {
        Log.d("LoadImageUtils", "download fail");
    }

    public void a(int i)
    {
        Log.d("LoadImageUtils", (new StringBuilder()).append("download progress=").append(i).toString());
    }

    public void a(String s)
    {
        Log.d("LoadImageUtils", (new StringBuilder()).append("download success=").append(s).toString());
        d.b(s, a);
        s = new File(s);
        if (s.exists())
        {
            s.delete();
        }
        b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    (String s, m m1)
    {
        a = s;
        b = m1;
        super();
    }
}
