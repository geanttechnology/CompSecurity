// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.BitArray;
import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header

final class HpackDraft05
{
    static final class Reader
    {

        private final List emittedHeaders = new ArrayList();
        BitArray emittedReferencedHeaders;
        int headerCount;
        Header headerTable[];
        int headerTableByteCount;
        private final Huffman.Codec huffmanCodec;
        private int maxHeaderTableByteCount;
        int nextHeaderIndex;
        BitArray referencedHeaders;
        private final BufferedSource source;

        private void clearHeaderTable()
        {
            clearReferenceSet();
            Arrays.fill(headerTable, null);
            nextHeaderIndex = headerTable.length - 1;
            headerCount = 0;
            headerTableByteCount = 0;
        }

        private void clearReferenceSet()
        {
            referencedHeaders.clear();
            emittedReferencedHeaders.clear();
        }

        private int evictToRecoverBytes(int i)
        {
            int j = 0;
            boolean flag = false;
            if (i > 0)
            {
                j = headerTable.length - 1;
                int k = i;
                i = ((flag) ? 1 : 0);
                for (; j >= nextHeaderIndex && k > 0; j--)
                {
                    k -= headerTable[j].hpackSize;
                    headerTableByteCount = headerTableByteCount - headerTable[j].hpackSize;
                    headerCount = headerCount - 1;
                    i++;
                }

                referencedHeaders.shiftLeft(i);
                emittedReferencedHeaders.shiftLeft(i);
                System.arraycopy(headerTable, nextHeaderIndex + 1, headerTable, nextHeaderIndex + 1 + i, headerCount);
                nextHeaderIndex = nextHeaderIndex + i;
                j = i;
            }
            return j;
        }

        private ByteString getName(int i)
        {
            if (isStaticHeader(i))
            {
                return HpackDraft05.STATIC_HEADER_TABLE[i - headerCount].name;
            } else
            {
                return headerTable[headerTableIndex(i)].name;
            }
        }

        private int headerTableIndex(int i)
        {
            return nextHeaderIndex + 1 + i;
        }

        private void insertIntoHeaderTable(int i, Header header)
        {
            int k = header.hpackSize;
            int j = k;
            if (i != -1)
            {
                j = k - headerTable[headerTableIndex(i)].hpackSize;
            }
            if (j > maxHeaderTableByteCount)
            {
                clearHeaderTable();
                emittedHeaders.add(header);
                return;
            }
            k = evictToRecoverBytes((headerTableByteCount + j) - maxHeaderTableByteCount);
            if (i == -1)
            {
                if (headerCount + 1 > headerTable.length)
                {
                    Header aheader[] = new Header[headerTable.length * 2];
                    System.arraycopy(headerTable, 0, aheader, headerTable.length, headerTable.length);
                    if (aheader.length == 64)
                    {
                        referencedHeaders = ((com.squareup.okhttp.internal.BitArray.FixedCapacity)referencedHeaders).toVariableCapacity();
                        emittedReferencedHeaders = ((com.squareup.okhttp.internal.BitArray.FixedCapacity)emittedReferencedHeaders).toVariableCapacity();
                    }
                    referencedHeaders.shiftLeft(headerTable.length);
                    emittedReferencedHeaders.shiftLeft(headerTable.length);
                    nextHeaderIndex = headerTable.length - 1;
                    headerTable = aheader;
                }
                i = nextHeaderIndex;
                nextHeaderIndex = i - 1;
                referencedHeaders.set(i);
                headerTable[i] = header;
                headerCount = headerCount + 1;
            } else
            {
                i += headerTableIndex(i) + k;
                referencedHeaders.set(i);
                headerTable[i] = header;
            }
            headerTableByteCount = headerTableByteCount + j;
        }

        private boolean isStaticHeader(int i)
        {
            return i >= headerCount;
        }

        private int readByte()
            throws IOException
        {
            return source.readByte() & 0xff;
        }

        private void readIndexedHeader(int i)
        {
            if (isStaticHeader(i))
            {
                Header header = HpackDraft05.STATIC_HEADER_TABLE[i - headerCount];
                if (maxHeaderTableByteCount == 0)
                {
                    emittedHeaders.add(header);
                    return;
                } else
                {
                    insertIntoHeaderTable(-1, header);
                    return;
                }
            }
            i = headerTableIndex(i);
            if (!referencedHeaders.get(i))
            {
                emittedHeaders.add(headerTable[i]);
                emittedReferencedHeaders.set(i);
            }
            referencedHeaders.toggle(i);
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i)
            throws IOException
        {
            insertIntoHeaderTable(-1, new Header(getName(i), readByteString(false)));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName()
            throws IOException
        {
            insertIntoHeaderTable(-1, new Header(readByteString(true), readByteString(false)));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i)
            throws IOException
        {
            ByteString bytestring = getName(i);
            ByteString bytestring1 = readByteString(false);
            emittedHeaders.add(new Header(bytestring, bytestring1));
        }

        private void readLiteralHeaderWithoutIndexingNewName()
            throws IOException
        {
            ByteString bytestring = readByteString(true);
            ByteString bytestring1 = readByteString(false);
            emittedHeaders.add(new Header(bytestring, bytestring1));
        }

        void emitReferenceSet()
        {
            for (int i = headerTable.length - 1; i != nextHeaderIndex; i--)
            {
                if (referencedHeaders.get(i) && !emittedReferencedHeaders.get(i))
                {
                    emittedHeaders.add(headerTable[i]);
                }
            }

        }

        List getAndReset()
        {
            ArrayList arraylist = new ArrayList(emittedHeaders);
            emittedHeaders.clear();
            emittedReferencedHeaders.clear();
            return arraylist;
        }

        void maxHeaderTableByteCount(int i)
        {
label0:
            {
                maxHeaderTableByteCount = i;
                if (maxHeaderTableByteCount < headerTableByteCount)
                {
                    if (maxHeaderTableByteCount != 0)
                    {
                        break label0;
                    }
                    clearHeaderTable();
                }
                return;
            }
            evictToRecoverBytes(headerTableByteCount - maxHeaderTableByteCount);
        }

        ByteString readByteString(boolean flag)
            throws IOException
        {
            int i = readByte();
            ByteString bytestring;
            ByteString bytestring1;
            boolean flag1;
            if ((i & 0x80) == 128)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            i = readInt(i, 127);
            bytestring1 = source.readByteString(i);
            bytestring = bytestring1;
            if (flag1)
            {
                bytestring = huffmanCodec.decode(bytestring1);
            }
            bytestring1 = bytestring;
            if (flag)
            {
                bytestring1 = bytestring.toAsciiLowercase();
            }
            return bytestring1;
        }

        void readHeaders()
            throws IOException
        {
            while (!source.exhausted()) 
            {
                int i = source.readByte() & 0xff;
                if (i == 128)
                {
                    clearReferenceSet();
                } else
                if ((i & 0x80) == 128)
                {
                    readIndexedHeader(readInt(i, 127) - 1);
                } else
                if (i == 64)
                {
                    readLiteralHeaderWithoutIndexingNewName();
                } else
                if ((i & 0x40) == 64)
                {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 63) - 1);
                } else
                if (i == 0)
                {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else
                if ((i & 0xc0) == 0)
                {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
                } else
                {
                    throw new AssertionError((new StringBuilder()).append("unhandled byte: ").append(Integer.toBinaryString(i)).toString());
                }
            }
        }

        int readInt(int i, int j)
            throws IOException
        {
            i &= j;
            if (i < j)
            {
                return i;
            }
            i = 0;
            do
            {
                int k = readByte();
                if ((k & 0x80) != 0)
                {
                    j += (k & 0x7f) << i;
                    i += 7;
                } else
                {
                    return j + (k << i);
                }
            } while (true);
        }

        Reader(boolean flag, int i, Source source1)
        {
            headerTable = new Header[8];
            nextHeaderIndex = headerTable.length - 1;
            headerCount = 0;
            referencedHeaders = new com.squareup.okhttp.internal.BitArray.FixedCapacity();
            emittedReferencedHeaders = new com.squareup.okhttp.internal.BitArray.FixedCapacity();
            headerTableByteCount = 0;
            Huffman.Codec codec;
            if (flag)
            {
                codec = Huffman.Codec.RESPONSE;
            } else
            {
                codec = Huffman.Codec.REQUEST;
            }
            huffmanCodec = codec;
            maxHeaderTableByteCount = i;
            source = Okio.buffer(source1);
        }
    }

    static final class Writer
    {

        private final OkBuffer out;

        void writeByteString(ByteString bytestring)
            throws IOException
        {
            writeInt(bytestring.size(), 127, 0);
            out.write(bytestring);
        }

        void writeHeaders(List list)
            throws IOException
        {
            int i = 0;
            int j = list.size();
            while (i < j) 
            {
                ByteString bytestring = ((Header)list.get(i)).name;
                Integer integer = (Integer)HpackDraft05.NAME_TO_FIRST_INDEX.get(bytestring);
                if (integer != null)
                {
                    writeInt(integer.intValue() + 1, 63, 64);
                    writeByteString(((Header)list.get(i)).value);
                } else
                {
                    out.writeByte(64);
                    writeByteString(bytestring);
                    writeByteString(((Header)list.get(i)).value);
                }
                i++;
            }
        }

        void writeInt(int i, int j, int k)
            throws IOException
        {
            if (i < j)
            {
                out.writeByte(k | i);
                return;
            }
            out.writeByte(k | j);
            for (i -= j; i >= 128; i >>>= 7)
            {
                out.writeByte(i & 0x7f | 0x80);
            }

            out.writeByte(i);
        }

        Writer(OkBuffer okbuffer)
        {
            out = okbuffer;
        }
    }


    private static final Map NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final Header STATIC_HEADER_TABLE[];

    private HpackDraft05()
    {
    }

    private static Map nameToFirstIndex()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        for (int i = 0; i < STATIC_HEADER_TABLE.length; i++)
        {
            if (!linkedhashmap.containsKey(STATIC_HEADER_TABLE[i].name))
            {
                linkedhashmap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }

        return Collections.unmodifiableMap(linkedhashmap);
    }

    static 
    {
        STATIC_HEADER_TABLE = (new Header[] {
            new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "500"), new Header(Header.RESPONSE_STATUS, "404"), 
            new Header(Header.RESPONSE_STATUS, "403"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "401"), new Header("accept-charset", ""), new Header("accept-encoding", ""), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), 
            new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), 
            new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), 
            new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), 
            new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")
        });
    }


}
