// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.internal.lang.annotation;

import java.lang.annotation.Annotation;

public interface ajcITD
    extends Annotation
{

    public abstract int modifiers();

    public abstract String name();

    public abstract String targetType();
}
