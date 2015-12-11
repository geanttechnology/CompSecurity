// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FieldAnnotationInclusionStrategy
    implements ExclusionStrategy
{

    final Class annotationClass;

    public FieldAnnotationInclusionStrategy(Class class1)
    {
        annotationClass = class1;
    }

    public boolean shouldSkipClass(Class class1)
    {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes fieldattributes)
    {
        return fieldattributes.getAnnotation(annotationClass) == null;
    }
}
