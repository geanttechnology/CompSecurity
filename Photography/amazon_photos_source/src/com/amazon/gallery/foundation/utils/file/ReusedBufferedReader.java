// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import android.util.Pair;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReusedBufferedReader extends Reader
{

    private static final ThreadLocal STATIC_BUFFERS = new ThreadLocal() {

        protected Pair initialValue()
        {
            return new Pair(new AtomicBoolean(false), new char[ReusedBufferedReader.defaultCharBufferSize]);
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

    };
    private static int defaultCharBufferSize = 8192;
    private static int defaultExpectedLineLength = 80;
    private char cb[];
    private Reader in;
    private int markedChar;
    private boolean markedSkipLF;
    private int nChars;
    private int nextChar;
    private int readAheadLimit;
    private boolean skipLF;

    public ReusedBufferedReader(Reader reader)
    {
        super(reader);
        markedChar = -1;
        readAheadLimit = 0;
        skipLF = false;
        markedSkipLF = false;
        if (((AtomicBoolean)((Pair)STATIC_BUFFERS.get()).first).get())
        {
            throw new RuntimeException("Shared buffer is still in use,\nDid you forget to close the previous ReusedBufferedReader?");
        } else
        {
            in = reader;
            ((AtomicBoolean)((Pair)STATIC_BUFFERS.get()).first).set(true);
            cb = (char[])((Pair)STATIC_BUFFERS.get()).second;
            nChars = 0;
            nextChar = 0;
            return;
        }
    }

    private void ensureOpen()
        throws IOException
    {
        if (in == null)
        {
            throw new IOException("Stream closed");
        } else
        {
            return;
        }
    }

    private void fill()
        throws IOException
    {
        int i;
        int j;
        if (markedChar <= -1)
        {
            i = 0;
        } else
        {
            int k = nextChar - markedChar;
            if (k >= readAheadLimit)
            {
                markedChar = -2;
                readAheadLimit = 0;
                i = 0;
            } else
            {
                if (readAheadLimit <= cb.length)
                {
                    System.arraycopy(cb, markedChar, cb, 0, k);
                    markedChar = 0;
                } else
                {
                    char ac[] = new char[readAheadLimit];
                    System.arraycopy(cb, markedChar, ac, 0, k);
                    cb = ac;
                    markedChar = 0;
                }
                i = k;
                nChars = k;
                nextChar = k;
            }
        }
        do
        {
            j = in.read(cb, i, cb.length - i);
        } while (j == 0);
        if (j > 0)
        {
            nChars = i + j;
            nextChar = i;
        }
    }

    private int read1(char ac[], int i, int j)
        throws IOException
    {
        byte byte0 = -1;
        if (nextChar < nChars) goto _L2; else goto _L1
_L1:
        if (j < cb.length || markedChar > -1 || skipLF) goto _L4; else goto _L3
_L3:
        int k = in.read(ac, i, j);
_L6:
        return k;
_L4:
        fill();
_L2:
        k = byte0;
        if (nextChar >= nChars) goto _L6; else goto _L5
_L5:
        if (!skipLF)
        {
            break; /* Loop/switch isn't completed */
        }
        skipLF = false;
        if (cb[nextChar] != '\n')
        {
            break; /* Loop/switch isn't completed */
        }
        nextChar = nextChar + 1;
        if (nextChar >= nChars)
        {
            fill();
        }
        k = byte0;
        if (nextChar >= nChars) goto _L6; else goto _L7
_L7:
        j = Math.min(j, nChars - nextChar);
        System.arraycopy(cb, nextChar, ac, i, j);
        nextChar = nextChar + j;
        return j;
    }

    public void close()
        throws IOException
    {
label0:
        {
            synchronized (lock)
            {
                if (in != null)
                {
                    break label0;
                }
            }
            return;
        }
        in.close();
        in = null;
        cb = null;
        ((AtomicBoolean)((Pair)STATIC_BUFFERS.get()).first).set(false);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void mark(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Read-ahead limit < 0");
        }
        synchronized (lock)
        {
            ensureOpen();
            readAheadLimit = i;
            markedChar = nextChar;
            markedSkipLF = skipLF;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int read()
        throws IOException
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureOpen();
_L1:
        if (nextChar < nChars)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        fill();
        if (nextChar < nChars)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        return -1;
        if (!skipLF)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        skipLF = false;
        if (cb[nextChar] != '\n')
        {
            break MISSING_BLOCK_LABEL_85;
        }
        nextChar = nextChar + 1;
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        char ac[];
        int i;
        ac = cb;
        i = nextChar;
        nextChar = i + 1;
        i = ac[i];
        obj;
        JVM INSTR monitorexit ;
        return i;
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureOpen();
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (i > ac.length || j < 0)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (i + j <= ac.length && i + j >= 0)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        throw new IndexOutOfBoundsException();
        ac;
        obj;
        JVM INSTR monitorexit ;
        throw ac;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj;
        JVM INSTR monitorexit ;
        return 0;
        int l = read1(ac, i, j);
        int k;
        k = l;
        if (l > 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj;
        JVM INSTR monitorexit ;
        return l;
_L2:
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (!in.ready())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        l = read1(ac, i + k, j - k);
        if (l > 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj;
        JVM INSTR monitorexit ;
        return k;
        k += l;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String readLine()
        throws IOException
    {
        return readLine(false);
    }

    String readLine(boolean flag)
        throws IOException
    {
        char c = '\0';
        Object obj1 = lock;
        obj1;
        JVM INSTR monitorenter ;
        ensureOpen();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        flag = skipLF;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        c = '\001';
        Object obj = null;
_L4:
        if (nextChar >= nChars)
        {
            fill();
        }
        if (nextChar < nChars) goto _L2; else goto _L1
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (((StringBuffer) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = ((StringBuffer) (obj)).toString();
        return ((String) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return null;
        obj;
_L5:
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L2:
        boolean flag1;
        int j;
        j = 0;
        flag1 = false;
        if (c == 0)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        if (cb[nextChar] == '\n')
        {
            nextChar = nextChar + 1;
        }
        skipLF = false;
        boolean flag2 = false;
        int i = nextChar;
        c = flag1;
_L7:
        flag1 = j;
        if (i >= nChars)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        c = cb[i];
        if (c != '\n' && c != '\r')
        {
            break MISSING_BLOCK_LABEL_320;
        }
        break MISSING_BLOCK_LABEL_314;
_L6:
        j = nextChar;
        nextChar = i;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj = new String(cb, j, i - j);
_L3:
        nextChar = nextChar + 1;
        if (c != '\r')
        {
            break MISSING_BLOCK_LABEL_241;
        }
        skipLF = true;
        obj1;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        ((StringBuffer) (obj)).append(cb, j, i - j);
        obj = ((StringBuffer) (obj)).toString();
          goto _L3
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        obj = new StringBuffer(defaultExpectedLineLength);
        ((StringBuffer) (obj)).append(cb, j, i - j);
        c = flag2;
          goto _L4
        obj;
          goto _L5
        flag1 = true;
          goto _L6
        i++;
          goto _L7
    }

    public boolean ready()
        throws IOException
    {
        boolean flag = false;
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureOpen();
        if (skipLF)
        {
            if (nextChar >= nChars && in.ready())
            {
                fill();
            }
            if (nextChar < nChars)
            {
                if (cb[nextChar] == '\n')
                {
                    nextChar = nextChar + 1;
                }
                skipLF = false;
            }
        }
        Exception exception;
        if (nextChar < nChars || in.ready())
        {
            flag = true;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void reset()
        throws IOException
    {
        Object obj1 = lock;
        obj1;
        JVM INSTR monitorenter ;
        ensureOpen();
        if (markedChar >= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        Object obj;
        if (markedChar == -2)
        {
            obj = "Mark invalid";
        } else
        {
            obj = "Stream not marked";
        }
        throw new IOException(((String) (obj)));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        nextChar = markedChar;
        skipLF = markedSkipLF;
        obj1;
        JVM INSTR monitorexit ;
    }

    public long skip(long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("skip value is negative");
        }
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ensureOpen();
        long l1 = l;
_L7:
        long l2 = l1;
        if (l1 <= 0L) goto _L2; else goto _L1
_L1:
        if (nextChar >= nChars)
        {
            fill();
        }
        if (nextChar < nChars) goto _L4; else goto _L3
_L3:
        l2 = l1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return l - l2;
_L4:
        if (skipLF)
        {
            skipLF = false;
            if (cb[nextChar] == '\n')
            {
                nextChar = nextChar + 1;
            }
        }
        l2 = nChars - nextChar;
        if (l1 > l2)
        {
            break; /* Loop/switch isn't completed */
        }
        nextChar = (int)((long)nextChar + l1);
        l2 = 0L;
        if (true) goto _L2; else goto _L5
_L5:
        l1 -= l2;
        nextChar = nChars;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }


}
