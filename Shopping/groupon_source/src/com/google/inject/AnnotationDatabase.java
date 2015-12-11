// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import java.util.HashMap;
import java.util.HashSet;

public abstract class AnnotationDatabase
{

    protected AnnotationDatabase()
    {
    }

    public abstract void fillAnnotationClassesAndConstructors(HashMap hashmap);

    public abstract void fillAnnotationClassesAndFieldsNames(HashMap hashmap);

    public abstract void fillAnnotationClassesAndMethods(HashMap hashmap);

    public abstract void fillBindableClasses(HashSet hashset);

    public abstract void fillClassesContainingInjectionPointSet(HashSet hashset);
}
