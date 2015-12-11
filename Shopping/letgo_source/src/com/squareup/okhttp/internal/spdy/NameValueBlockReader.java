// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apx;
import android.support.v7.apy;
import android.support.v7.aqb;
import android.support.v7.aqd;
import android.support.v7.aqe;
import android.support.v7.aqk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, Spdy3

class NameValueBlockReader
{

    private int compressedLimit;
    private final aqd inflaterSource;
    private final apx source;

    public NameValueBlockReader(apx apx1)
    {
        inflaterSource = new aqd(new aqb(apx1) {

            final NameValueBlockReader this$0;

            public long read(apv apv, long l)
                throws IOException
            {
                if (compressedLimit != 0)
                {
                    if ((l = super.read(apv, Math.min(l, compressedLimit))) != -1L)
                    {
                        compressedLimit = (int)((long)compressedLimit - l);
                        return l;
                    }
                }
                return -1L;
            }

            
            {
                this$0 = NameValueBlockReader.this;
                super(aqk);
            }
        }, new Inflater() {

            final NameValueBlockReader this$0;

            public int inflate(byte abyte0[], int i, int j)
                throws DataFormatException
            {
                int l = super.inflate(abyte0, i, j);
                int k = l;
                if (l == 0)
                {
                    k = l;
                    if (needsDictionary())
                    {
                        setDictionary(Spdy3.DICTIONARY);
                        k = super.inflate(abyte0, i, j);
                    }
                }
                return k;
            }

            
            {
                this$0 = NameValueBlockReader.this;
                super();
            }
        });
        source = aqe.a(inflaterSource);
    }

    private void doneReading()
        throws IOException
    {
        if (compressedLimit > 0)
        {
            inflaterSource.a();
            if (compressedLimit != 0)
            {
                throw new IOException((new StringBuilder()).append("compressedLimit > 0: ").append(compressedLimit).toString());
            }
        }
    }

    private apy readByteString()
        throws IOException
    {
        int i = source.k();
        return source.c(i);
    }

    public void close()
        throws IOException
    {
        source.close();
    }

    public List readNameValueBlock(int i)
        throws IOException
    {
        compressedLimit = compressedLimit + i;
        int j = source.k();
        if (j < 0)
        {
            throw new IOException((new StringBuilder()).append("numberOfPairs < 0: ").append(j).toString());
        }
        if (j > 1024)
        {
            throw new IOException((new StringBuilder()).append("numberOfPairs > 1024: ").append(j).toString());
        }
        ArrayList arraylist = new ArrayList(j);
        for (i = 0; i < j; i++)
        {
            apy apy1 = readByteString().e();
            apy apy2 = readByteString();
            if (apy1.f() == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new Header(apy1, apy2));
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
}
