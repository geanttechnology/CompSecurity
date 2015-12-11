// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util.mediator;

import java.util.List;

public interface Task
{

    public abstract void end(String s);

    public abstract String getId();

    public abstract List getInputDependency();

    public abstract void removeInputDependency(String s);

    public abstract void start();
}
