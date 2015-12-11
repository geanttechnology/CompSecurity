// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.NetworkInfo;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.support.v7:
//            akh

class ala extends ThreadPoolExecutor
{
    private static final class a extends FutureTask
        implements Comparable
    {

        private final akh a;

        public int a(a a1)
        {
            aky.e e = a.n();
            aky.e e1 = a1.a.n();
            if (e == e1)
            {
                return a.a - a1.a.a;
            } else
            {
                return e1.ordinal() - e.ordinal();
            }
        }

        public int compareTo(Object obj)
        {
            return a((a)obj);
        }

        public a(akh akh1)
        {
            super(akh1, null);
            a = akh1;
        }
    }


    ala()
    {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new alj.e());
    }

    private void a(int i)
    {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    void a(NetworkInfo networkinfo)
    {
        if (networkinfo == null || !networkinfo.isConnectedOrConnecting())
        {
            a(3);
            return;
        }
        switch (networkinfo.getType())
        {
        default:
            a(3);
            return;

        case 1: // '\001'
        case 6: // '\006'
        case 9: // '\t'
            a(4);
            return;

        case 0: // '\0'
            switch (networkinfo.getSubtype())
            {
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            default:
                a(3);
                return;

            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
                a(3);
                return;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 12: // '\f'
                a(2);
                return;

            case 1: // '\001'
            case 2: // '\002'
                a(1);
                return;
            }
        }
    }

    public Future submit(Runnable runnable)
    {
        runnable = new a((akh)runnable);
        execute(runnable);
        return runnable;
    }
}
