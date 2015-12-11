// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import java.lang.annotation.Annotation;

public interface DatabaseFieldForeign
    extends Annotation
{

    public abstract boolean foreign();

    public abstract boolean foreignAutoCreate();

    public abstract boolean foreignAutoRefresh();

    public abstract int maxForeignAutoRefreshLevel();
}
