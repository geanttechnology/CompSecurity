// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import java.lang.annotation.Annotation;

public interface DatabaseFieldIndex
    extends Annotation
{

    public abstract boolean index();

    public abstract String indexName();

    public abstract boolean unique();

    public abstract boolean uniqueCombo();

    public abstract boolean uniqueIndex();

    public abstract String uniqueIndexName();
}
