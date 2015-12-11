// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.util.Log;
import com.sessionm.net.Request;
import com.sessionm.net.c;
import com.sessionm.net.http.d;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.sessionm.core:
//            j

class eb
    implements Runnable
{

    final Request eb;
    final  ec;

    public void run()
    {
        if (Log.isLoggable(j.TAG, 3))
        {
            Log.d(j.TAG, String.format(Locale.US, "finished video preload request: %s", new Object[] {
                eb.getURL()
            }));
        }
        j.b(ec.).remove(eb.getURL());
        if (eb.ba() != com.sessionm.net.t.State.fg || eb.aR().bz() == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        if (j.b(ec., eb.getURL()).createNewFile())
        {
            com.sessionm.core.j.c(ec.).add(com.sessionm.core.j.c(ec., eb.getURL()).getName());
        }
_L1:
        return;
        IOException ioexception;
        ioexception;
        if (Log.isLoggable(j.TAG, 5))
        {
            Log.w(j.TAG, "Error saving video ", ioexception);
            return;
        }
          goto _L1
    }

    ( , Request request)
    {
        ec = ;
        eb = request;
        super();
    }

    // Unreferenced inner class com/sessionm/core/j$3

/* anonymous class */
    class j._cls3 extends c
    {

        final j dZ;

        public void onReplyReceived(Request request)
        {
            com.sessionm.core.j.d(dZ).execute(new j._cls3._cls1(this, request));
        }

        public File outputFileForRequest(Request request)
        {
            return com.sessionm.core.j.c(dZ, request.getURL());
        }

            
            {
                dZ = j1;
                super();
            }
    }

}
