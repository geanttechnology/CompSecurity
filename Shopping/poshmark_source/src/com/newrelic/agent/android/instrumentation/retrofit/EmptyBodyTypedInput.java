// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

public class EmptyBodyTypedInput
    implements TypedInput
{

    public EmptyBodyTypedInput()
    {
    }

    public InputStream in()
        throws IOException
    {
        return new ByteArrayInputStream(new byte[0]);
    }

    public long length()
    {
        return 0L;
    }

    public String mimeType()
    {
        return "text/html;charset=utf-8";
    }
}
