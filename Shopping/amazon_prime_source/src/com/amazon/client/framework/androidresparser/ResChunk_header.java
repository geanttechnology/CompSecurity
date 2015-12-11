// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import java.io.IOException;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            WordReader

public class ResChunk_header
{

    public static final int RES_NULL_TYPE = 0;
    public static final int RES_STRING_POOL_TYPE = 1;
    public static final int RES_TABLE_PACKAGE_TYPE = 512;
    public static final int RES_TABLE_TYPE = 2;
    public static final int RES_TABLE_TYPE_SPEC_TYPE = 514;
    public static final int RES_TABLE_TYPE_TYPE = 513;
    public static final int RES_XML_CDATA_TYPE = 260;
    public static final int RES_XML_END_ELEMENT_TYPE = 259;
    public static final int RES_XML_END_NAMESPACE_TYPE = 257;
    public static final int RES_XML_FIRST_CHUNK_TYPE = 256;
    public static final int RES_XML_LAST_CHUNK_TYPE = 383;
    public static final int RES_XML_RESOURCE_MAP_TYPE = 384;
    public static final int RES_XML_START_ELEMENT_TYPE = 258;
    public static final int RES_XML_START_NAMESPACE_TYPE = 256;
    public static final int RES_XML_TYPE = 3;
    public static final int sizeof = 8;
    public int headerSize;
    public int size;
    public int type;

    public ResChunk_header()
    {
    }

    public static int readHeader(WordReader wordreader, ResChunk_header reschunk_header)
        throws IOException
    {
        reschunk_header.type = wordreader.readWord();
        reschunk_header.headerSize = wordreader.readWord();
        reschunk_header.size = wordreader.readDWord();
        if (reschunk_header.headerSize < 8 || reschunk_header.headerSize > reschunk_header.size)
        {
            throw new IOException("Invalid header");
        } else
        {
            return 8;
        }
    }

    public void copyTo(ResChunk_header reschunk_header)
    {
        reschunk_header.type = type;
        reschunk_header.headerSize = headerSize;
        reschunk_header.size = size;
    }

    public void skipToNext(WordReader wordreader, int i)
        throws IOException
    {
        if (i > size - headerSize)
        {
            throw new IOException("Skip called after reading all of a section.");
        } else
        {
            wordreader.skip(size - headerSize - i);
            return;
        }
    }
}
