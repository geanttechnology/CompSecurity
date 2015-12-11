// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.Arrays;
import java.util.List;

public class CSVEncodedNSTField extends EncodedNSTField
{

    private final Logger logger;
    private final List values;

    public transient CSVEncodedNSTField(Logger logger1, Object aobj[])
    {
        logger = logger1;
        values = Arrays.asList(aobj);
    }

    public String toEncodedString()
    {
        return logger.join(",", values);
    }
}
