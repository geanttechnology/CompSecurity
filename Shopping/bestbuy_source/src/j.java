// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONObject;

final class j
    implements Runnable
{

    private bb a;
    private ah b;
    private long c;
    private g d;

    j(g g1, bb bb1, ah ah1)
    {
        d = g1;
        super();
        c = -1L;
        a = bb1;
        b = ah1;
    }

    static long a(j j1, long l1)
    {
        j1.c = l1;
        return l1;
    }

    final void a()
    {
        if (c < 0L || System.currentTimeMillis() - c >= 0x493e0L)
        {
            bc.a("Attempting to schedule 'DynamicInfoPointVersionChecker' immediately.");
            c = System.currentTimeMillis();
            b.a(this, 0L);
        }
    }

    public final void run()
    {
        Object obj;
        obj = d.b().d();
        bc.a("Connecting to URL: %s to download infopoint version", ((e) (obj)).a());
        if (((e) (obj)).h() != 200)
        {
            bc.a((new StringBuilder("Warning: Invalid response from server = ")).append(((e) (obj)).h()).toString());
            return;
        }
        long l1;
        obj = bb.a(((e) (obj)).g());
        if (!((JSONObject) (obj)).has("infopVersion"))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        l1 = ((JSONObject) (obj)).getLong("infopVersion");
        if (l1 <= 0L)
        {
            try
            {
                if (l.d != null)
                {
                    l.d.a(-1L);
                }
                bc.a("No dynamic infopoints defined for this application");
                return;
            }
            catch (Exception exception)
            {
                bc.a("Error downloading infopoint version from server", exception);
            }
            return;
        }
        long l2 = l.d.e();
        if (l2 < l1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        bc.a("Current version %d is greater or equal to server version %d.Not scheduling dex download", Long.valueOf(l2), Long.valueOf(l1));
        return;
        this;
        JVM INSTR monitorenter ;
        if (g.a(d) < l1)
        {
            bc.a("Scheduling dex downloader for server version %d", Long.valueOf(l1));
            b.a(new i(d, l1, (byte)0), 0L);
            g.a(d, l1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        bc.a("Response has no dynamic infopoint version!");
        return;
    }
}
