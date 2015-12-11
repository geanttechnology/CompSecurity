// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Referenced classes of package com.google.tagmanager.protobuf:
//            RopeByteString, ByteString

private static class <init>
{

    private final Deque prefixesStack;

    private ByteString balance(ByteString bytestring, ByteString bytestring1)
    {
        doBalance(bytestring);
        doBalance(bytestring1);
        for (bytestring = (ByteString)prefixesStack.pop(); !prefixesStack.isEmpty(); bytestring = new RopeByteString((ByteString)prefixesStack.pop(), bytestring, null)) { }
        return bytestring;
    }

    private void doBalance(ByteString bytestring)
    {
        if (bytestring.isBalanced())
        {
            insert(bytestring);
            return;
        }
        if (bytestring instanceof RopeByteString)
        {
            bytestring = (RopeByteString)bytestring;
            doBalance(RopeByteString.access$500(bytestring));
            doBalance(RopeByteString.access$600(bytestring));
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Has a new type of ByteString been created? Found ").append(bytestring.getClass()).toString());
        }
    }

    private int getDepthBinForLength(int i)
    {
        int j = Arrays.binarySearch(RopeByteString.access$300(), i);
        i = j;
        if (j < 0)
        {
            i = -(j + 1) - 1;
        }
        return i;
    }

    private void insert(ByteString bytestring)
    {
        int i = getDepthBinForLength(bytestring.size());
        int k = RopeByteString.access$300()[i + 1];
        if (prefixesStack.isEmpty() || ((ByteString)prefixesStack.peek()).size() >= k)
        {
            prefixesStack.push(bytestring);
            return;
        }
        i = RopeByteString.access$300()[i];
        Object obj;
        for (obj = (ByteString)prefixesStack.pop(); !prefixesStack.isEmpty() && ((ByteString)prefixesStack.peek()).size() < i; obj = new RopeByteString((ByteString)prefixesStack.pop(), ((ByteString) (obj)), null)) { }
        bytestring = new RopeByteString(((ByteString) (obj)), bytestring, null);
        do
        {
            if (prefixesStack.isEmpty())
            {
                break;
            }
            int j = getDepthBinForLength(bytestring.size());
            j = RopeByteString.access$300()[j + 1];
            if (((ByteString)prefixesStack.peek()).size() >= j)
            {
                break;
            }
            bytestring = new RopeByteString((ByteString)prefixesStack.pop(), bytestring, null);
        } while (true);
        prefixesStack.push(bytestring);
    }


    private ()
    {
        prefixesStack = new ArrayDeque(RopeByteString.access$300().length);
    }

    _cls0(_cls0 _pcls0)
    {
        this();
    }
}
