// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import okio.ByteString;
import okio.d;
import okio.f;
import okio.i;
import okio.k;
import okio.l;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, Spdy3

class NameValueBlockReader
{

    private int compressedLimit;
    private final k inflaterSource;
    private final f source;

    public NameValueBlockReader(f f1)
    {
        inflaterSource = new k(new i(f1) , new Inflater() {

            final NameValueBlockReader this$0;

            public int inflate(byte abyte0[], int i, int j)
            {
                int j1 = inflate(abyte0, i, j);
                int i1 = j1;
                if (j1 == 0)
                {
                    i1 = j1;
                    if (needsDictionary())
                    {
                        setDictionary(Spdy3.DICTIONARY);
                        i1 = inflate(abyte0, i, j);
                    }
                }
                return i1;
            }

            
            {
                this$0 = NameValueBlockReader.this;
                super();
            }
        });
        source = l.a(inflaterSource);
    }

    private void doneReading()
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

    private ByteString readByteString()
    {
        int i = source.j();
        return source.c(i);
    }

    public void close()
    {
        source.close();
    }

    public List readNameValueBlock(int i)
    {
        compressedLimit = compressedLimit + i;
        int j = source.j();
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
            ByteString bytestring = readByteString().d();
            ByteString bytestring1 = readByteString();
            if (bytestring.e() == 0)
            {
                throw new IOException("name.size == 0");
            }
            arraylist.add(new Header(bytestring, bytestring1));
        }

        doneReading();
        return arraylist;
    }



/*
    static int access$022(NameValueBlockReader namevalueblockreader, long l1)
    {
        int i = (int)((long)namevalueblockreader.compressedLimit - l1);
        namevalueblockreader.compressedLimit = i;
        return i;
    }

*/
}
