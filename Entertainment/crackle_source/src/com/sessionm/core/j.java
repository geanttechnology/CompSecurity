// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.content.Context;
import android.util.Log;
import com.sessionm.c.a;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;
import com.sessionm.net.c;
import com.sessionm.net.http.d;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public class j
{

    protected static final String TAG = null;
    private Context bg;
    private ExecutorService bl;
    private List dW;
    private List dX;
    private RequestQueue dY;

    public j(Context context, ExecutorService executorservice, com.sessionm.net.a a1)
    {
        dW = new ArrayList();
        dX = new ArrayList();
        bg = context;
        a a2 = new a();
        ArrayList arraylist = new ArrayList();
        arraylist.add(a2);
        bl = executorservice;
        dY = new RequestQueue(context, arraylist, com.sessionm.net.RequestQueue.RequestQueueType.ga, executorservice, a1);
        context = new FileFilter() {

            final j dZ;

            public boolean accept(File file)
            {
                return file.getName().endsWith("complete");
            }

            
            {
                dZ = j.this;
                super();
            }
        };
        context = aE().listFiles(context);
        int k = context.length;
        for (int i = 0; i < k; i++)
        {
            if (!context[i].getName().startsWith("sm_"));
        }

    }

    static RequestQueue a(j j1)
    {
        return j1.dY;
    }

    static void a(j j1, String s1)
    {
        j1.s(s1);
    }

    private File aE()
    {
        return new File(bg.getCacheDir(), "SessionMVideos");
    }

    static File b(j j1, String s1)
    {
        return j1.u(s1);
    }

    static List b(j j1)
    {
        return j1.dX;
    }

    static File c(j j1, String s1)
    {
        return j1.t(s1);
    }

    static List c(j j1)
    {
        return j1.dW;
    }

    static ExecutorService d(j j1)
    {
        return j1.bl;
    }

    private void s(String s1)
    {
        aE().mkdirs();
        s1 = new Request(com.sessionm.net.Request.Type.fm, new Object[] {
            s1
        });
        s1.d(com.sessionm.net.Request.Header.eM.getKey(), "no-cache");
        s1.a(new c() {

            final j dZ;

            public void onReplyReceived(Request request)
            {
                com.sessionm.core.j.d(dZ).execute(new Runnable(this, request) {

                    final Request eb;
                    final _cls3 ec;

                    public void run()
                    {
                        if (Log.isLoggable(j.TAG, 3))
                        {
                            Log.d(j.TAG, String.format(Locale.US, "finished video preload request: %s", new Object[] {
                                eb.getURL()
                            }));
                        }
                        j.b(ec.dZ).remove(eb.getURL());
                        if (eb.ba() != com.sessionm.net.Request.State.fg || eb.aR().bz() == null)
                        {
                            break MISSING_BLOCK_LABEL_147;
                        }
                        if (j.b(ec.dZ, eb.getURL()).createNewFile())
                        {
                            com.sessionm.core.j.c(ec.dZ).add(com.sessionm.core.j.c(ec.dZ, eb.getURL()).getName());
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

            
            {
                ec = _pcls3;
                eb = request;
                super();
            }
                });
            }

            public File outputFileForRequest(Request request)
            {
                return com.sessionm.core.j.c(dZ, request.getURL());
            }

            
            {
                dZ = j.this;
                super();
            }
        });
        dY.d(s1);
    }

    private File t(String s1)
    {
        s1 = String.format(Locale.US, (new StringBuilder()).append("sm_").append(com.sessionm.a.a.c(s1, "SHA-1")).toString(), new Object[0]);
        return new File(aE(), s1);
    }

    private File u(String s1)
    {
        return new File(bg.getCacheDir(), String.format(Locale.US, "sm_%s.complete", new Object[] {
            com.sessionm.a.a.c(s1, "SHA-1")
        }));
    }

    public void a(String as[])
    {
        this;
        JVM INSTR monitorenter ;
        bl.execute(new Runnable(as) {

            final j dZ;
            final String ea[];

            public void run()
            {
                j j1 = dZ;
                j1;
                JVM INSTR monitorenter ;
                String as1[];
                int k;
                com.sessionm.core.j.a(dZ).start();
                as1 = ea;
                k = as1.length;
                int i = 0;
_L2:
                String s1;
                if (i >= k)
                {
                    break MISSING_BLOCK_LABEL_84;
                }
                s1 = as1[i];
                if (j.b(dZ).contains(s1) && !com.sessionm.core.j.c(dZ).contains(s1))
                {
                    com.sessionm.core.j.a(dZ, s1);
                }
                break MISSING_BLOCK_LABEL_92;
                j1;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                j1;
                JVM INSTR monitorexit ;
                throw exception;
                i++;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                dZ = j.this;
                ea = as;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        as;
        throw as;
    }

    public void aF()
    {
        this;
        JVM INSTR monitorenter ;
        dY.stop();
        dY.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String v(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = t(s1).getAbsolutePath();
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

}
