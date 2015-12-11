// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.harvest.crash.Crash;
import java.util.List;

public interface CrashStore
{

    public abstract void clear();

    public abstract int count();

    public abstract void delete(Crash crash);

    public abstract List fetchAll();

    public abstract void store(Crash crash);
}
