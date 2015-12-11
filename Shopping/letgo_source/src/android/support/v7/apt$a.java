// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            apt

private static final class setDaemon extends Thread
{

    public void run()
    {
        do
        {
            apt apt1;
            do
            {
                apt1 = apt.access$000();
            } while (apt1 == null);
            try
            {
                apt1.timedOut();
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }

    public ption()
    {
        super("Okio Watchdog");
        setDaemon(true);
    }
}
