// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.j;
import d.k;
import d.p;
import d.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header

class NameValueBlockReader
{

    private int compressedLimit;
    private final p inflaterSource;
    private final j source;

    public NameValueBlockReader(j j1)
    {
        inflaterSource = new p(new _cls1(j1), new _cls2());
        source = q.a(inflaterSource);
    }

    private void doneReading()
    {
        if (compressedLimit > 0)
        {
            inflaterSource.a();
            if (compressedLimit != 0)
            {
                throw new IOException((new StringBuilder("compressedLimit > 0: ")).append(compressedLimit).toString());
            }
        }
    }

    private k readByteString()
    {
        int i = source.i();
        return source.c(i);
    }

    public void close()
    {
        source.close();
    }

    public List readNameValueBlock(int i)
    {
        compressedLimit = compressedLimit + i;
        int l = source.i();
        if (l < 0)
        {
            throw new IOException((new StringBuilder("numberOfPairs < 0: ")).append(l).toString());
        }
        if (l > 1024)
        {
            throw new IOException((new StringBuilder("numberOfPairs > 1024: ")).append(l).toString());
        }
        ArrayList arraylist = new ArrayList(l);
        for (i = 0; i < l; i++)
        {
            k k1 = readByteString().d();
            k k2 = readByteString();
            if (k1.e() == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new Header(k1, k2));
        }

        doneReading();
        return arraylist;
    }



/*
    static int access$002(NameValueBlockReader namevalueblockreader, int i)
    {
        namevalueblockreader.compressedLimit = i;
        return i;
    }

*/

    private class _cls1 extends n
    {

        final NameValueBlockReader this$0;

        public long read(f f, long l)
        {
            if (compressedLimit != 0)
            {
                if ((l = super.read(f, Math.min(l, compressedLimit))) != -1L)
                {
                    compressedLimit = (int)((long)compressedLimit - l);
                    return l;
                }
            }
            return -1L;
        }

        _cls1(ab ab)
        {
            this$0 = NameValueBlockReader.this;
            super(ab);
        }
    }


    private class _cls2 extends Inflater
    {

        final NameValueBlockReader this$0;

        public int inflate(byte abyte0[], int i, int l)
        {
            int j1 = super.inflate(abyte0, i, l);
            int i1 = j1;
            if (j1 == 0)
            {
                i1 = j1;
                if (needsDictionary())
                {
                    setDictionary(Spdy3.DICTIONARY);
                    i1 = super.inflate(abyte0, i, l);
                }
            }
            return i1;
        }

        _cls2()
        {
            this$0 = NameValueBlockReader.this;
            super();
        }
    }

}
