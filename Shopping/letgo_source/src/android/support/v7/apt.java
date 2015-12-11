// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package android.support.v7:
//            aql, aqj, aqk, apv

public class apt extends aql
{
    private static final class a extends Thread
    {

        public void run()
        {
            do
            {
                apt apt1;
                do
                {
                    apt1 = apt.awaitTimeout();
                } while (apt1 == null);
                try
                {
                    apt1.timedOut();
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

        public a()
        {
            super("Okio Watchdog");
            setDaemon(true);
        }
    }


    private static apt head;
    private boolean inQueue;
    private apt next;
    private long timeoutAt;

    public apt()
    {
    }

    private static apt awaitTimeout()
        throws InterruptedException
    {
        Object obj = null;
        android/support/v7/apt;
        JVM INSTR monitorenter ;
        apt apt1 = head.next;
        if (apt1 != null) goto _L2; else goto _L1
_L1:
        android/support/v7/apt.wait();
_L4:
        android/support/v7/apt;
        JVM INSTR monitorexit ;
        return ((apt) (obj));
_L2:
        long l = apt1.remainingNanos(System.nanoTime());
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        long l1 = l / 0xf4240L;
        android/support/v7/apt.wait(l1, (int)(l - 0xf4240L * l1));
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        head.next = apt1.next;
        apt1.next = null;
        obj = apt1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static boolean cancelScheduledTimeout(apt apt1)
    {
        android/support/v7/apt;
        JVM INSTR monitorenter ;
        apt apt2 = head;
_L8:
        if (apt2 == null) goto _L2; else goto _L1
_L1:
        if (apt2.next != apt1) goto _L4; else goto _L3
_L3:
        apt2.next = apt1.next;
        apt1.next = null;
        boolean flag = false;
_L6:
        android/support/v7/apt;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        apt2 = apt2.next;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        apt1;
        throw apt1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private long remainingNanos(long l)
    {
        return timeoutAt - l;
    }

    private static void scheduleTimeout(apt apt1, long l, boolean flag)
    {
        android/support/v7/apt;
        JVM INSTR monitorenter ;
        long l1;
        if (head == null)
        {
            head = new apt();
            (new a()).start();
        }
        l1 = System.nanoTime();
        if (l == 0L || !flag) goto _L2; else goto _L1
_L1:
        apt1.timeoutAt = Math.min(l, apt1.deadlineNanoTime() - l1) + l1;
_L3:
        l = apt1.remainingNanos(l1);
        for (apt apt2 = head; apt2.next != null && l >= apt2.next.remainingNanos(l1); apt2 = apt2.next)
        {
            break MISSING_BLOCK_LABEL_175;
        }

        apt1.next = apt2.next;
        apt2.next = apt1;
        if (apt2 == head)
        {
            android/support/v7/apt.notify();
        }
        android/support/v7/apt;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        apt1.timeoutAt = l1 + l;
          goto _L3
        apt1;
        throw apt1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        apt1.timeoutAt = apt1.deadlineNanoTime();
          goto _L3
        throw new AssertionError();
    }

    public final void enter()
    {
        if (inQueue)
        {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l = timeoutNanos();
        boolean flag = hasDeadline();
        if (l == 0L && !flag)
        {
            return;
        } else
        {
            inQueue = true;
            scheduleTimeout(this, l, flag);
            return;
        }
    }

    final IOException exit(IOException ioexception)
        throws IOException
    {
        if (!exit())
        {
            return ioexception;
        } else
        {
            InterruptedIOException interruptedioexception = new InterruptedIOException("timeout");
            interruptedioexception.initCause(ioexception);
            return interruptedioexception;
        }
    }

    final void exit(boolean flag)
        throws IOException
    {
        if (exit() && flag)
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    public final boolean exit()
    {
        if (!inQueue)
        {
            return false;
        } else
        {
            inQueue = false;
            return cancelScheduledTimeout(this);
        }
    }

    public final aqj sink(aqj aqj)
    {
        return new aqj(aqj) {

            final aqj a;
            final apt b;

            public void close()
                throws IOException
            {
                b.enter();
                a.close();
                b.exit(true);
                return;
                Object obj;
                obj;
                throw b.exit(((IOException) (obj)));
                obj;
                b.exit(false);
                throw obj;
            }

            public void flush()
                throws IOException
            {
                b.enter();
                a.flush();
                b.exit(true);
                return;
                Object obj;
                obj;
                throw b.exit(((IOException) (obj)));
                obj;
                b.exit(false);
                throw obj;
            }

            public aql timeout()
            {
                return b;
            }

            public String toString()
            {
                return (new StringBuilder()).append("AsyncTimeout.sink(").append(a).append(")").toString();
            }

            public void write(apv apv, long l)
                throws IOException
            {
                b.enter();
                a.write(apv, l);
                b.exit(true);
                return;
                apv;
                throw b.exit(apv);
                apv;
                b.exit(false);
                throw apv;
            }

            
            {
                b = apt.this;
                a = aqj1;
                super();
            }
        };
    }

    public final aqk source(aqk aqk)
    {
        return new aqk(aqk) {

            final aqk a;
            final apt b;

            public void close()
                throws IOException
            {
                a.close();
                b.exit(true);
                return;
                Object obj;
                obj;
                throw b.exit(((IOException) (obj)));
                obj;
                b.exit(false);
                throw obj;
            }

            public long read(apv apv, long l)
                throws IOException
            {
                b.enter();
                l = a.read(apv, l);
                b.exit(true);
                return l;
                apv;
                throw b.exit(apv);
                apv;
                b.exit(false);
                throw apv;
            }

            public aql timeout()
            {
                return b;
            }

            public String toString()
            {
                return (new StringBuilder()).append("AsyncTimeout.source(").append(a).append(")").toString();
            }

            
            {
                b = apt.this;
                a = aqk1;
                super();
            }
        };
    }

    protected void timedOut()
    {
    }

}
