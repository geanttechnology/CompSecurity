// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.concurrent;


class ThreadFixer
{

    static final ThreadFixer NORMAL_NON_DAEMON_FIXER = new ThreadFixer(false, 5);
    private final boolean daemon;
    private final int priority;

    ThreadFixer(boolean flag, int i)
    {
        daemon = flag;
        priority = i;
    }

    public void fix(Thread thread)
    {
        if (thread.isDaemon() != daemon)
        {
            thread.setDaemon(daemon);
        }
        if (thread.getPriority() != priority)
        {
            thread.setPriority(priority);
        }
    }

}
