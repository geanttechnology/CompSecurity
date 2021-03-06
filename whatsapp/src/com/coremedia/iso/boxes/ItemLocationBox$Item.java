// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.coremedia.iso.boxes:
//            ItemLocationBox

public class t
{

    public long baseOffset;
    public int constructionMethod;
    public int dataReferenceIndex;
    public List extents;
    public int itemId;
    final ItemLocationBox this$0;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (t)obj;
            if (baseOffset != ((baseOffset) (obj)).baseOffset)
            {
                return false;
            }
            if (constructionMethod != ((constructionMethod) (obj)).constructionMethod)
            {
                return false;
            }
            if (dataReferenceIndex != ((dataReferenceIndex) (obj)).dataReferenceIndex)
            {
                return false;
            }
            if (itemId != ((itemId) (obj)).itemId)
            {
                return false;
            }
            if (extents == null ? ((extents) (obj)).extents != null : !extents.equals(((extents) (obj)).extents))
            {
                return false;
            }
        }
        return true;
    }

    public void getContent(ByteBuffer bytebuffer)
    {
        IsoTypeWriter.writeUInt16(bytebuffer, itemId);
        if (getVersion() == 1)
        {
            IsoTypeWriter.writeUInt16(bytebuffer, constructionMethod);
        }
        IsoTypeWriter.writeUInt16(bytebuffer, dataReferenceIndex);
        if (baseOffsetSize > 0)
        {
            IsoTypeWriterVariable.write(baseOffset, bytebuffer, baseOffsetSize);
        }
        IsoTypeWriter.writeUInt16(bytebuffer, extents.size());
        Iterator iterator = extents.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((t)iterator.next()).getContent(bytebuffer);
        } while (true);
    }

    public int getSize()
    {
        int i = 2;
        if (getVersion() == 1)
        {
            i = 2 + 2;
        }
        i = i + 2 + baseOffsetSize + 2;
        Iterator iterator = extents.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return i;
            }
            i += ((t)iterator.next()).getSize();
        } while (true);
    }

    public int hashCode()
    {
        int j = itemId;
        int k = constructionMethod;
        int l = dataReferenceIndex;
        int i1 = (int)(baseOffset ^ baseOffset >>> 32);
        int i;
        if (extents != null)
        {
            i = extents.hashCode();
        } else
        {
            i = 0;
        }
        return (((j * 31 + k) * 31 + l) * 31 + i1) * 31 + i;
    }

    public void setBaseOffset(long l)
    {
        baseOffset = l;
    }

    public String toString()
    {
        return (new StringBuilder("Item{baseOffset=")).append(baseOffset).append(", itemId=").append(itemId).append(", constructionMethod=").append(constructionMethod).append(", dataReferenceIndex=").append(dataReferenceIndex).append(", extents=").append(extents).append('}').toString();
    }

    public t(int i, int j, int k, long l, List list)
    {
        this$0 = ItemLocationBox.this;
        super();
        extents = new LinkedList();
        itemId = i;
        constructionMethod = j;
        dataReferenceIndex = k;
        baseOffset = l;
        extents = list;
    }

    public extents(ByteBuffer bytebuffer)
    {
        this$0 = ItemLocationBox.this;
        super();
        extents = new LinkedList();
        itemId = IsoTypeReader.readUInt16(bytebuffer);
        if (getVersion() == 1)
        {
            constructionMethod = IsoTypeReader.readUInt16(bytebuffer) & 0xf;
        }
        dataReferenceIndex = IsoTypeReader.readUInt16(bytebuffer);
        int i;
        int j;
        if (baseOffsetSize > 0)
        {
            baseOffset = IsoTypeReaderVariable.read(bytebuffer, baseOffsetSize);
        } else
        {
            baseOffset = 0L;
        }
        j = IsoTypeReader.readUInt16(bytebuffer);
        i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            extents.add(new t(ItemLocationBox.this, bytebuffer));
            i++;
        } while (true);
    }
}
