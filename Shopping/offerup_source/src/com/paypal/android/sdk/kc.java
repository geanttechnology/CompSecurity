// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

public final class kc extends Exception
{

    public kc(IOException ioexception)
    {
        super(ioexception);
    }

    public final IOException a()
    {
        return (IOException)super.getCause();
    }

    public final volatile Throwable getCause()
    {
        return (IOException)super.getCause();
    }
}
