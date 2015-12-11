// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.droidparts.annotation.inject;

import java.lang.annotation.Annotation;

public interface InjectView
    extends Annotation
{

    public abstract boolean click();

    public abstract int id();
}
