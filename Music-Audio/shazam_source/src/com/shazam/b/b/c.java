// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class c
{

    public static transient List a(Object aobj[])
    {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(aobj)));
    }
}
