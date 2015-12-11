// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.millennialmedia.android:
//            au, al

static final class _cls1.a
{

    // Unreferenced inner class com/millennialmedia/android/au$a$1

/* anonymous class */
    static final class _cls1
        implements Runnable
    {

        final String a;

        public final void run()
        {
            try
            {
                (new DefaultHttpClient()).execute(new HttpGet(a));
                (new StringBuilder("Executed Url :\"")).append(a).append("\"");
                al.b();
                return;
            }
            catch (IOException ioexception)
            {
                al.a("Utils", "Exception with HttpUtils: ", ioexception);
            }
        }

            
            {
                a = s;
                super();
            }
    }

}
