// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SynchronizedDateFormat extends SimpleDateFormat
{

    private static final long serialVersionUID = 0x5bc5dc3dfe38218aL;

    public SynchronizedDateFormat()
    {
    }

    public SynchronizedDateFormat(String s)
    {
        super(s);
    }

    public SynchronizedDateFormat(String s, Locale locale)
    {
        super(s, locale);
    }

    public void applyPattern(String s)
    {
        this;
        JVM INSTR monitorenter ;
        super.applyPattern(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Date parse(String s)
        throws ParseException
    {
        this;
        JVM INSTR monitorenter ;
        s = super.parse(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}
