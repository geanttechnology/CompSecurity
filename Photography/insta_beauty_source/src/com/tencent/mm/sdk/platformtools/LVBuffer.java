// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

public class LVBuffer
{

    public static final int LENGTH_ALLOC_PER_NEW = 4096;
    public static final int MAX_STRING_LENGTH = 2048;
    private ByteBuffer ap;
    private boolean aq;

    public LVBuffer()
    {
    }

    private int a(int i)
    {
        if (ap.limit() - ap.position() > i)
        {
            return 0;
        } else
        {
            ByteBuffer bytebuffer = ByteBuffer.allocate(ap.limit() + 4096);
            bytebuffer.put(ap.array(), 0, ap.position());
            ap = bytebuffer;
            return 0;
        }
    }

    public byte[] buildFinish()
    {
        if (!aq)
        {
            throw new Exception("Buffer For Parse");
        } else
        {
            a(1);
            ap.put((byte)125);
            byte abyte0[] = new byte[ap.position()];
            System.arraycopy(ap.array(), 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public boolean checkGetFinish()
    {
        return ap.limit() - ap.position() <= 1;
    }

    public int getInt()
    {
        if (aq)
        {
            throw new Exception("Buffer For Build");
        } else
        {
            return ap.getInt();
        }
    }

    public long getLong()
    {
        if (aq)
        {
            throw new Exception("Buffer For Build");
        } else
        {
            return ap.getLong();
        }
    }

    public String getString()
    {
        if (aq)
        {
            throw new Exception("Buffer For Build");
        }
        short word0 = ap.getShort();
        if (word0 > 2048)
        {
            ap = null;
            throw new Exception("Buffer String Length Error");
        }
        if (word0 == 0)
        {
            return "";
        } else
        {
            byte abyte0[] = new byte[word0];
            ap.get(abyte0, 0, word0);
            return new String(abyte0);
        }
    }

    public int initBuild()
    {
        ap = ByteBuffer.allocate(4096);
        ap.put((byte)123);
        aq = true;
        return 0;
    }

    public int initParse(byte abyte0[])
    {
        byte byte0;
        if (abyte0 == null || abyte0.length == 0)
        {
            byte0 = -1;
        } else
        if (abyte0[0] != 123)
        {
            byte0 = -2;
        } else
        if (abyte0[abyte0.length - 1] != 125)
        {
            byte0 = -3;
        } else
        {
            byte0 = 0;
        }
        if (byte0 != 0)
        {
            ap = null;
            throw new Exception((new StringBuilder("Parse Buffer Check Failed :")).append(byte0).toString());
        } else
        {
            ap = ByteBuffer.wrap(abyte0);
            ap.position(1);
            aq = false;
            return 0;
        }
    }

    public int putInt(int i)
    {
        if (!aq)
        {
            throw new Exception("Buffer For Parse");
        } else
        {
            a(4);
            ap.putInt(i);
            return 0;
        }
    }

    public int putLong(long l)
    {
        if (!aq)
        {
            throw new Exception("Buffer For Parse");
        } else
        {
            a(8);
            ap.putLong(l);
            return 0;
        }
    }

    public int putString(String s)
    {
        if (!aq)
        {
            throw new Exception("Buffer For Parse");
        }
        byte abyte0[] = null;
        if (s != null)
        {
            abyte0 = s.getBytes();
        }
        s = abyte0;
        if (abyte0 == null)
        {
            s = new byte[0];
        }
        if (s.length > 2048)
        {
            throw new Exception("Buffer String Length Error");
        }
        a(s.length + 2);
        ap.putShort((short)s.length);
        if (s.length > 0)
        {
            ap.put(s);
        }
        return 0;
    }
}
