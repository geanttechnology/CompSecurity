// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;

public interface MagicConstant
    extends Annotation
{

    public abstract long[] flags();

    public abstract Class flagsFromClass();

    public abstract long[] intValues();

    public abstract String[] stringValues();

    public abstract Class valuesFromClass();
}
