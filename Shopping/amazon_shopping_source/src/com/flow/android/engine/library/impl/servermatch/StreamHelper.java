// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamHelper
{

    public StreamHelper()
    {
    }

    public static void closeInputStream(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    public static void closeOutputStream(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        outputstream.flush();
        outputstream.close();
        return;
        outputstream;
    }
}
