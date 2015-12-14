// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class Wire
{

    public static Wire CONTENT_WIRE = new Wire(LogFactory.getLog("httpclient.wire.content"));
    public static Wire HEADER_WIRE = new Wire(LogFactory.getLog("httpclient.wire.header"));
    private Log log;

    private Wire(Log log1)
    {
        log = log1;
    }

    private void wire(String s, InputStream inputstream)
        throws IOException
    {
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            int i = inputstream.read();
            if (i == -1)
            {
                break;
            }
            if (i == 13)
            {
                stringbuffer.append("[\\r]");
            } else
            if (i == 10)
            {
                stringbuffer.append("[\\n]\"");
                stringbuffer.insert(0, "\"");
                stringbuffer.insert(0, s);
                log.debug(stringbuffer.toString());
                stringbuffer.setLength(0);
            } else
            if (i < 32 || i > 127)
            {
                stringbuffer.append("[0x");
                stringbuffer.append(Integer.toHexString(i));
                stringbuffer.append("]");
            } else
            {
                stringbuffer.append((char)i);
            }
        } while (true);
        if (stringbuffer.length() > 0)
        {
            stringbuffer.append("\"");
            stringbuffer.insert(0, "\"");
            stringbuffer.insert(0, s);
            log.debug(stringbuffer.toString());
        }
    }

    public boolean enabled()
    {
        return log.isDebugEnabled();
    }

    public void input(int i)
        throws IOException
    {
        input(new byte[] {
            (byte)i
        });
    }

    public void input(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        } else
        {
            wire("<< ", inputstream);
            return;
        }
    }

    public void input(String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        } else
        {
            input(s.getBytes());
            return;
        }
    }

    public void input(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        } else
        {
            wire("<< ", new ByteArrayInputStream(abyte0));
            return;
        }
    }

    public void input(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Input may not be null");
        } else
        {
            wire("<< ", new ByteArrayInputStream(abyte0, i, j));
            return;
        }
    }

    public void output(int i)
        throws IOException
    {
        output(new byte[] {
            (byte)i
        });
    }

    public void output(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        } else
        {
            wire(">> ", inputstream);
            return;
        }
    }

    public void output(String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        } else
        {
            output(s.getBytes());
            return;
        }
    }

    public void output(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        } else
        {
            wire(">> ", new ByteArrayInputStream(abyte0));
            return;
        }
    }

    public void output(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Output may not be null");
        } else
        {
            wire(">> ", new ByteArrayInputStream(abyte0, i, j));
            return;
        }
    }

}
