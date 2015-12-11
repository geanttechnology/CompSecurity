// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import java.io.IOException;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            ResChunk_header, WordReader

public class ResXMLTree_node
{

    public static final int sizeof = 8;
    public int commentIndex;
    public final ResChunk_header header = new ResChunk_header();
    public int lineNumber;

    public ResXMLTree_node()
    {
    }

    public static int readHeader(WordReader wordreader, ResChunk_header reschunk_header, ResXMLTree_node resxmltree_node)
        throws IOException
    {
        reschunk_header.copyTo(resxmltree_node.header);
        if (resxmltree_node.header.headerSize > 8)
        {
            resxmltree_node.lineNumber = wordreader.readDWord();
            resxmltree_node.commentIndex = wordreader.readDWord();
            return 8;
        } else
        {
            resxmltree_node.lineNumber = -1;
            resxmltree_node.commentIndex = -1;
            return 0;
        }
    }

    public static int readHeader(WordReader wordreader, ResXMLTree_node resxmltree_node)
        throws IOException
    {
        int i = ResChunk_header.readHeader(wordreader, resxmltree_node.header);
        if (resxmltree_node.header.headerSize > i)
        {
            resxmltree_node.lineNumber = wordreader.readDWord();
            resxmltree_node.commentIndex = wordreader.readDWord();
            return i + 8;
        } else
        {
            resxmltree_node.lineNumber = -1;
            resxmltree_node.commentIndex = -1;
            return i;
        }
    }

    public void copyTo(ResXMLTree_node resxmltree_node)
    {
        resxmltree_node.header.copyTo(resxmltree_node.header);
        resxmltree_node.lineNumber = lineNumber;
        resxmltree_node.commentIndex = commentIndex;
    }
}
