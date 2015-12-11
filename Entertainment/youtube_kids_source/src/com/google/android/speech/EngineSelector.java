// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech;

import java.util.List;

public interface EngineSelector
{

    public abstract List getEngineList();

    public abstract int getPrimaryEngine();

    public abstract int getSecondaryEngine();
}
