// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.util.SparseArray;
import java.io.IOException;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            WordReader, ResXMLTree, ResXMLTree_attribute, Res_value, 
//            ResXMLTree_node

public class ResAttributes
{

    private final SparseArray attributeCache = new SparseArray();
    public int attributeCount;
    private byte attributeData[];
    public int attributeSize;
    public int classIndex;
    public int idIndex;
    public int styleIndex;

    public ResAttributes()
    {
    }

    public static int readAttributes(WordReader wordreader, int i, ResXMLTree_node resxmltree_node, byte abyte0[], ResAttributes resattributes)
        throws IOException
    {
        char c = (char)(WordReader.readBytesFrom(abyte0, 8, 2) & 0xff);
        int k = 8 + 2;
        resattributes.attributeSize = WordReader.readBytesFrom(abyte0, k, 2);
        k += 2;
        resattributes.attributeCount = WordReader.readBytesFrom(abyte0, k, 2);
        k += 2;
        resattributes.idIndex = WordReader.readBytesFrom(abyte0, k, 2);
        k += 2;
        resattributes.classIndex = WordReader.readBytesFrom(abyte0, k, 2);
        k += 2;
        resattributes.styleIndex = WordReader.readBytesFrom(abyte0, k, 2);
        if (c != ResXMLTree.sizeof(ResXMLTree.Ext.ResXMLTree_attrExt))
        {
            throw new IOException("Unknown attribute ext data found.");
        } else
        {
            resxmltree_node = new byte[resattributes.attributeCount * resattributes.attributeSize];
            int j = wordreader.readByteArray(resxmltree_node);
            resattributes.attributeData = resxmltree_node;
            resattributes.attributeCache.clear();
            return i + j;
        }
    }

    private ResXMLTree_attribute readThroughCache(int i)
    {
        ResXMLTree_attribute resxmltree_attribute1 = (ResXMLTree_attribute)attributeCache.get(i);
        ResXMLTree_attribute resxmltree_attribute = resxmltree_attribute1;
        if (resxmltree_attribute1 == null)
        {
            int j = attributeSize * i;
            resxmltree_attribute = new ResXMLTree_attribute();
            resxmltree_attribute.ns = WordReader.readBytesFrom(attributeData, j, 4);
            j += 4;
            resxmltree_attribute.name = WordReader.readBytesFrom(attributeData, j, 4);
            j += 4;
            resxmltree_attribute.rawValue = WordReader.readBytesFrom(attributeData, j, 4);
            j += 4;
            resxmltree_attribute.typedValue.size = WordReader.readBytesFrom(attributeData, j, 2);
            j += 2;
            resxmltree_attribute.typedValue.res0 = WordReader.readBytesFrom(attributeData, j, 1);
            j++;
            resxmltree_attribute.typedValue.dataType = WordReader.readBytesFrom(attributeData, j, 1);
            j++;
            resxmltree_attribute.typedValue.data = WordReader.readBytesFrom(attributeData, j, 4);
            attributeCache.put(i, resxmltree_attribute);
        }
        return resxmltree_attribute;
    }

    public int getAttributeNameID(int i)
    {
        if (i < attributeCount)
        {
            return readThroughCache(i).name;
        } else
        {
            return -1;
        }
    }

    public int getAttributeNamespaceID(int i)
    {
        if (i < attributeCount)
        {
            return readThroughCache(i).ns;
        } else
        {
            return -2;
        }
    }

    public Res_value getAttributeValue(int i)
    {
        if (i < attributeCount)
        {
            return readThroughCache(i).typedValue;
        } else
        {
            return null;
        }
    }

    public int getAttributeValueStringID(int i)
    {
        if (i < attributeCount)
        {
            return readThroughCache(i).rawValue;
        } else
        {
            return -1;
        }
    }
}
