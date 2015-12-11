// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            ResXMLTree, ResAttributes, Res_value, ResXMLTree_node, 
//            ResChunk_header, WordReader, ResXMLTree_namespaceExt, ResStringPool

public class ResXMLParser
{

    public static final int BAD_DOCUMENT = -1;
    public static final int END_DOCUMENT = 1;
    public static final int END_NAMESPACE = 257;
    public static final int END_TAG = 259;
    public static final int FIRST_CHUNK_CODE = 256;
    public static final int START_DOCUMENT = 0;
    public static final int START_NAMESPACE = 256;
    public static final int START_TAG = 258;
    public static final int TEXT = 260;
    private final ResAttributes mAttrs = new ResAttributes();
    private ResXMLTree_node mCurNode;
    private ResXMLTree_namespaceExt mCurrNamespace;
    private WordReader mData;
    private int mEventCode;
    private final byte mExtBuffer[];
    private final Stack mImpliedNamespaces = new Stack();
    private final SparseIntArray mNamespacePrefixMap = new SparseIntArray();
    private final Res_value mTextValue = new Res_value();
    private final ResXMLTree mTree = new ResXMLTree(this);

    private ResXMLParser()
    {
        mEventCode = -1;
        mExtBuffer = new byte[ResXMLTree.MAX_EXT_SIZE];
    }

    public static ResXMLParser makeParser(InputStream inputstream)
        throws IOException
    {
        ResXMLParser resxmlparser = new ResXMLParser();
        resxmlparser.setTo(inputstream);
        return resxmlparser;
    }

    private int nextNode(int i)
        throws IOException
    {
        if (mEventCode < 0)
        {
            return mEventCode;
        }
          goto _L1
_L8:
        int j = i;
_L10:
        int k;
        int l;
        int i1;
        i1 = mCurNode.header.headerSize;
        l = mCurNode.header.size;
        k = mCurNode.header.type;
        mEventCode = k;
        k;
        JVM INSTR tableswitch 256 260: default 92
    //                   256 202
    //                   257 202
    //                   258 228
    //                   259 238
    //                   260 248;
           goto _L2 _L3 _L3 _L4 _L5 _L6
_L2:
        j = l - j;
        if (Log.isLoggable("ResXMLParser", 5))
        {
            Log.w("ResXMLParser", String.format("Unknown XML block 0x%04x. Skipping %d bytes.", new Object[] {
                Integer.valueOf(mEventCode), Integer.valueOf(j)
            }));
        }
        mData.skip(j);
_L1:
        if (i != 0) goto _L8; else goto _L7
_L7:
        j = 0 + ResXMLTree_node.readHeader(mData, mCurNode);
        if (!mData.atEnd()) goto _L10; else goto _L9
_L9:
        mEventCode = 1;
        return 1;
        IOException ioexception;
        ioexception;
        if (!mData.atEnd())
        {
            throw ioexception;
        } else
        {
            mEventCode = 1;
            return 1;
        }
_L3:
        i = ResXMLTree.sizeof(ResXMLTree.Ext.ResXMLTree_namespaceExt);
_L12:
        if (i > mExtBuffer.length)
        {
            throw new RuntimeException("Ext buffer overrun!");
        }
        break; /* Loop/switch isn't completed */
_L4:
        i = ResXMLTree.sizeof(ResXMLTree.Ext.ResXMLTree_attrExt);
        continue; /* Loop/switch isn't completed */
_L5:
        i = ResXMLTree.sizeof(ResXMLTree.Ext.ResXMLTree_endElementExt);
        continue; /* Loop/switch isn't completed */
_L6:
        i = ResXMLTree.sizeof(ResXMLTree.Ext.ResXMLTree_cdataExt);
        if (true) goto _L12; else goto _L11
_L11:
        if (l - i1 < i)
        {
            throw new IOException("BAD DOCUMENT");
        }
        i = j + mData.readByteArray(mExtBuffer, 0, i);
        mEventCode;
        JVM INSTR tableswitch 256 258: default 324
    //                   256 412
    //                   257 481
    //                   258 386;
           goto _L13 _L14 _L15 _L16
_L13:
        i = l - i;
        if (Log.isLoggable("ResXMLParser", 3) && i > 0)
        {
            Log.d("ResXMLParser", String.format("%d bytes were not consumed for element 0x%04x", new Object[] {
                Integer.valueOf(i), Integer.valueOf(mEventCode)
            }));
        }
        mData.skip(i);
        return k;
_L16:
        i += ResAttributes.readAttributes(mData, i, mCurNode, mExtBuffer, mAttrs);
        continue; /* Loop/switch isn't completed */
_L14:
        if (mCurrNamespace != null)
        {
            mImpliedNamespaces.push(mCurrNamespace);
        }
        mCurrNamespace = new ResXMLTree_namespaceExt();
        i += ResXMLTree_namespaceExt.readNamespace(mExtBuffer, 0, mCurrNamespace);
        mNamespacePrefixMap.append(mCurrNamespace.uri, mCurrNamespace.prefix);
        continue; /* Loop/switch isn't completed */
_L15:
        if (mCurrNamespace != null)
        {
            mNamespacePrefixMap.delete(mCurrNamespace.uri);
        }
        if (mImpliedNamespaces.size() > 0)
        {
            mCurrNamespace = (ResXMLTree_namespaceExt)mImpliedNamespaces.pop();
        } else
        {
            mCurrNamespace = null;
        }
        if (true) goto _L13; else goto _L17
_L17:
    }

    public void close()
        throws IOException
    {
        mData.close();
    }

    public String findNamespacePrefix(int i)
    {
        return getString(findNamespacePrefixId(i));
    }

    public int findNamespacePrefixId(int i)
    {
        if (mNamespacePrefixMap.indexOfKey(i) < 0)
        {
            return -1;
        } else
        {
            return mNamespacePrefixMap.get(i);
        }
    }

    public int getAttributeCount()
    {
        if (mEventCode == 258)
        {
            return mAttrs.attributeCount;
        } else
        {
            return 0;
        }
    }

    public String getAttributeData(int i)
    {
        if (mEventCode == 258)
        {
            Res_value res_value = mAttrs.getAttributeValue(i);
            return TypedValue.coerceToString(res_value.dataType, res_value.data);
        } else
        {
            return null;
        }
    }

    public int getAttributeDataType(int i)
    {
        if (mEventCode == 258)
        {
            return mAttrs.getAttributeValue(i).dataType;
        } else
        {
            return 0;
        }
    }

    public String getAttributeName(int i)
    {
        return getString(getAttributeNameID(i));
    }

    public int getAttributeNameID(int i)
    {
        if (mEventCode == 258)
        {
            return mAttrs.getAttributeNameID(i);
        } else
        {
            return -1;
        }
    }

    public String getAttributeNamespace(int i)
    {
        return getString(getAttributeNamespaceID(i));
    }

    public int getAttributeNamespaceID(int i)
    {
        if (mEventCode == 258)
        {
            return mAttrs.getAttributeNamespaceID(i);
        } else
        {
            return -2;
        }
    }

    public String getAttributeStringValue(int i)
    {
        return getString(getAttributeValueStringID(i));
    }

    public int getAttributeValueStringID(int i)
    {
        if (mEventCode == 258)
        {
            return mAttrs.getAttributeValueStringID(i);
        } else
        {
            return -1;
        }
    }

    public String getComment()
    {
        return getString(getCommentID());
    }

    public int getCommentID()
    {
        if (mCurNode != null)
        {
            return mCurNode.commentIndex;
        } else
        {
            return -1;
        }
    }

    public String getElementName()
    {
        return getString(getElementNameID());
    }

    public int getElementNameID()
    {
        if (mEventCode == 258 || mEventCode == 259)
        {
            return WordReader.readBytesFrom(mExtBuffer, 4, 4);
        } else
        {
            return -1;
        }
    }

    public String getElementNamespace()
    {
        return getString(getElementNamespaceID());
    }

    public int getElementNamespaceID()
    {
        if (mEventCode == 258 || mEventCode == 259)
        {
            return WordReader.readBytesFrom(mExtBuffer, 0, 4);
        } else
        {
            return -1;
        }
    }

    public int getEventType()
    {
        return mEventCode;
    }

    public int getLineNumber()
    {
        if (mCurNode != null)
        {
            return mCurNode.lineNumber;
        } else
        {
            return -1;
        }
    }

    public String getNamespacePrefix()
    {
        return getString(getNamespacePrefixID());
    }

    public int getNamespacePrefixID()
    {
        if (mCurrNamespace != null)
        {
            return mCurrNamespace.prefix;
        } else
        {
            return -1;
        }
    }

    public String getNamespaceUri()
    {
        return getString(getNamespaceUriID());
    }

    public int getNamespaceUriID()
    {
        if (mCurrNamespace != null)
        {
            return mCurrNamespace.uri;
        } else
        {
            return -1;
        }
    }

    public String getString(int i)
    {
        if (i >= 0)
        {
            return mTree.mStrings.stringAt(i);
        } else
        {
            return null;
        }
    }

    public String getText()
    {
        return getString(getTextID());
    }

    public int getTextID()
    {
        if (mEventCode == 260)
        {
            return WordReader.readBytesFrom(mExtBuffer, 0, 4);
        } else
        {
            return -1;
        }
    }

    public String getTextValue()
    {
        if (mEventCode == 260)
        {
            Res_value.readValue(mExtBuffer, 4, mTextValue);
            return TypedValue.coerceToString(mTextValue.dataType, mTextValue.data);
        } else
        {
            return null;
        }
    }

    public int next()
        throws IOException
    {
        if (mEventCode == -1)
        {
            throw new IOException("next called on a parser that previously failed.");
        }
        if (mEventCode == 0)
        {
            mCurNode = mTree.mRootNode;
            int i = mTree.mRootCode;
            mEventCode = i;
            return i;
        }
        if (mEventCode < 256)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        int j = nextNode(0);
        return j;
        IOException ioexception;
        ioexception;
        if (!mData.atEnd())
        {
            throw ioexception;
        }
        if (Log.isLoggable("ResXMLParser", 5))
        {
            Log.w("ResXMLParser", String.format("The document ended unexpectedly. The last event code reported was 0x%04x", new Object[] {
                Integer.valueOf(mEventCode)
            }));
            mEventCode = -1;
        }
        return mEventCode;
    }

    void setTo(InputStream inputstream)
        throws IOException
    {
        mData = new WordReader(inputstream);
        mEventCode = 0;
        inputstream = new ResChunk_header();
        ResChunk_header.readHeader(mData, inputstream);
        if (((ResChunk_header) (inputstream)).type != 3)
        {
            throw new IOException(String.format("Non-xml resource passed into XML parser (Unknown type %04x found)", new Object[] {
                Integer.valueOf(((ResChunk_header) (inputstream)).type)
            }));
        }
        int i = ((ResChunk_header) (inputstream)).size;
        if (Log.isLoggable("ResXMLParser", 3))
        {
            Log.d("ResXMLParser", String.format("The Document has %d bytes of data.", new Object[] {
                Integer.valueOf(i)
            }));
        }
        do
        {
label0:
            {
                if (!mData.atEnd())
                {
                    int j = ResChunk_header.readHeader(mData, inputstream);
                    if (((ResChunk_header) (inputstream)).type == 1)
                    {
                        mTree.mStrings = ResStringPool.readStringPool(inputstream, mData);
                        continue;
                    }
                    if (((ResChunk_header) (inputstream)).type == 384)
                    {
                        j = (((ResChunk_header) (inputstream)).size - ((ResChunk_header) (inputstream)).headerSize) / 4;
                        mTree.mResIds = new int[j];
                        mData.readIntArray(mTree.mResIds);
                        continue;
                    }
                    if (((ResChunk_header) (inputstream)).type < 256 || ((ResChunk_header) (inputstream)).type > 383)
                    {
                        break label0;
                    }
                    mCurNode = new ResXMLTree_node();
                    nextNode(j + ResXMLTree_node.readHeader(mData, inputstream, mCurNode));
                    mTree.mRootNode = mCurNode;
                    mTree.mRootCode = mEventCode;
                }
                mCurNode = null;
                mEventCode = 0;
                return;
            }
            if (Log.isLoggable("ResXMLParser", 2))
            {
                Log.v("ResXMLParser", String.format("Skipping %d bytes in an unknown chunk of type %d", new Object[] {
                    Integer.valueOf(((ResChunk_header) (inputstream)).size), Integer.valueOf(((ResChunk_header) (inputstream)).type)
                }));
            }
            inputstream.skipToNext(mData, 0);
        } while (true);
    }
}
