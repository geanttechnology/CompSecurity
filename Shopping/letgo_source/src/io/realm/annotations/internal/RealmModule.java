// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.annotations.internal;

import java.lang.annotation.Annotation;

public interface RealmModule
    extends Annotation
{

    public abstract boolean allClasses();

    public abstract Class[] classes();

    public abstract boolean library();
}
