// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.math;

import java.util.Locale;

// Referenced classes of package org.apache.commons.math:
//            MathRuntimeException

static final class val.arguments extends IllegalArgumentException
{

    final Object val$arguments[];
    final String val$pattern;

    public String getLocalizedMessage()
    {
        return MathRuntimeException.access$000(Locale.getDefault(), val$pattern, val$arguments);
    }

    (String s, String s1, Object aobj[])
    {
        val$pattern = s1;
        val$arguments = aobj;
        super(s);
    }
}
