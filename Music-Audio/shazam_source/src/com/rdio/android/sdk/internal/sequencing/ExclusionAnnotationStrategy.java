// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal.sequencing;

import com.google.b.b;
import com.google.b.c;
import com.rdio.android.api.models.ExcludeFromSerialization;
import java.lang.reflect.Field;

public class ExclusionAnnotationStrategy
    implements b
{

    public ExclusionAnnotationStrategy()
    {
    }

    public boolean shouldSkipClass(Class class1)
    {
        return class1.getAnnotation(com/rdio/android/api/models/ExcludeFromSerialization) != null;
    }

    public boolean shouldSkipField(c c1)
    {
        return c1.a.getAnnotation(com/rdio/android/api/models/ExcludeFromSerialization) != null;
    }
}
