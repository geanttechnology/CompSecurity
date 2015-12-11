// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            RopeByteString, LiteralByteString, ByteString

private static class <init>
    implements Iterator
{

    private final Deque breadCrumbs;
    private LiteralByteString next;

    private LiteralByteString getLeafByLeft(ByteString bytestring)
    {
        for (; bytestring instanceof RopeByteString; bytestring = RopeByteString.access$500(bytestring))
        {
            bytestring = (RopeByteString)bytestring;
            breadCrumbs.push(bytestring);
        }

        return (LiteralByteString)bytestring;
    }

    private LiteralByteString getNextNonEmptyLeaf()
    {
        LiteralByteString literalbytestring;
        do
        {
            if (breadCrumbs.isEmpty())
            {
                return null;
            }
            literalbytestring = getLeafByLeft(RopeByteString.access$600((RopeByteString)breadCrumbs.pop()));
        } while (literalbytestring.isEmpty());
        return literalbytestring;
    }

    public boolean hasNext()
    {
        return next != null;
    }

    public LiteralByteString next()
    {
        if (next == null)
        {
            throw new NoSuchElementException();
        } else
        {
            LiteralByteString literalbytestring = next;
            next = getNextNonEmptyLeaf();
            return literalbytestring;
        }
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    private A(ByteString bytestring)
    {
        breadCrumbs = new ArrayDeque(RopeByteString.access$300().length);
        next = getLeafByLeft(bytestring);
    }

    getLeafByLeft(ByteString bytestring, getLeafByLeft getleafbyleft)
    {
        this(bytestring);
    }
}
