// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import java.lang.annotation.Annotation;

public interface DatabaseFieldSimple
    extends Annotation
{

    public abstract boolean canBeNull();

    public abstract String columnName();

    public abstract String defaultValue();

    public abstract int width();
}
