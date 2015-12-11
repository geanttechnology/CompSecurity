// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import java.io.IOException;
import java.io.OutputStream;
import retrofit.mime.TypedOutput;

public class a
    implements TypedOutput
{

    public static final TypedOutput a = new a();

    private a()
    {
    }

    public String fileName()
    {
        return null;
    }

    public long length()
    {
        return 0L;
    }

    public String mimeType()
    {
        return "application/json";
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
    }

}
