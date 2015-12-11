// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

public class asf extends IOException
{

    public final arx a;

    public asf(IOException ioexception, arx arx)
    {
        super(ioexception);
        a = arx;
    }

    public asf(String s, arx arx)
    {
        super(s);
        a = arx;
    }

    public asf(String s, IOException ioexception, arx arx)
    {
        super(s, ioexception);
        a = arx;
    }
}
