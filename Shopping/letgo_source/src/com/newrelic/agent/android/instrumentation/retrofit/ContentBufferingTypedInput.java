// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

// Referenced classes of package com.newrelic.agent.android.instrumentation.retrofit:
//            EmptyBodyTypedInput

public class ContentBufferingTypedInput
    implements TypedInput
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private TypedInput impl;
    private CountingInputStream inputStream;

    public ContentBufferingTypedInput(TypedInput typedinput)
    {
        Object obj = typedinput;
        if (typedinput == null)
        {
            obj = new EmptyBodyTypedInput();
        }
        impl = ((TypedInput) (obj));
        inputStream = null;
    }

    private void prepareInputStream()
        throws IOException
    {
        if (inputStream == null)
        {
            InputStream inputstream = impl.in();
            Object obj = inputstream;
            if (inputstream == null)
            {
                obj = new ByteArrayInputStream(new byte[0]);
            }
            inputStream = new CountingInputStream(((InputStream) (obj)), true);
        }
    }

    public InputStream in()
        throws IOException
    {
        prepareInputStream();
        return inputStream;
    }

    public long length()
    {
        int i;
        try
        {
            prepareInputStream();
            i = inputStream.available();
        }
        catch (IOException ioexception)
        {
            log.error("ContentBufferingTypedInput generated an IO exception: ", ioexception);
            return -1L;
        }
        return (long)i;
    }

    public String mimeType()
    {
        return impl.mimeType();
    }

}
