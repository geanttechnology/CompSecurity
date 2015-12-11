// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.droidparts.annotation.json;

import java.lang.annotation.Annotation;

public interface Key
    extends Annotation
{

    public static final String SUB = "->\035";

    public abstract String name();

    public abstract boolean optional();
}
