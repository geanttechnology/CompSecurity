// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

// Referenced classes of package com.google.protobuf:
//            LiteralByteString, CodedInputStream, CodedOutputStream

public abstract class ByteString
    implements Iterable
{
    public static interface ByteIterator
        extends Iterator
    {

        public abstract byte nextByte();
    }

    static final class CodedBuilder
    {

        private final byte buffer[];
        private final CodedOutputStream output;

        public ByteString build()
        {
            output.checkNoSpaceLeft();
            return new LiteralByteString(buffer);
        }

        public CodedOutputStream getCodedOutput()
        {
            return output;
        }

        private CodedBuilder(int i)
        {
            buffer = new byte[i];
            output = CodedOutputStream.newInstance(buffer);
        }

    }


    static final boolean $assertionsDisabled;
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    ByteString()
    {
    }

    public static ByteString copyFrom(byte abyte0[])
    {
        return copyFrom(abyte0, 0, abyte0.length);
    }

    public static ByteString copyFrom(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new LiteralByteString(abyte1);
    }

    public static ByteString copyFromUtf8(String s)
    {
        try
        {
            s = new LiteralByteString(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported?", s);
        }
        return s;
    }

    static CodedBuilder newCodedBuilder(int i)
    {
        return new CodedBuilder(i);
    }

    public abstract byte byteAt(int i);

    public void copyTo(byte abyte0[], int i, int j, int k)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source offset < 0: ").append(i).toString());
        }
        if (j < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Target offset < 0: ").append(j).toString());
        }
        if (k < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Length < 0: ").append(k).toString());
        }
        if (i + k > size())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source end offset < 0: ").append(i + k).toString());
        }
        if (j + k > abyte0.length)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Target end offset < 0: ").append(j + k).toString());
        }
        if (k > 0)
        {
            copyToInternal(abyte0, i, j, k);
        }
    }

    protected abstract void copyToInternal(byte abyte0[], int i, int j, int k);

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract ByteIterator iterator();

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    protected abstract int partialHash(int i, int j, int k);

    protected abstract int partialIsValidUtf8(int i, int j, int k);

    protected abstract int peekCachedHashCode();

    public abstract int size();

    public byte[] toByteArray()
    {
        int i = size();
        byte abyte0[] = new byte[i];
        copyToInternal(abyte0, 0, 0, i);
        return abyte0;
    }

    public String toString()
    {
        return String.format("<ByteString@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())
        });
    }

    public abstract String toString(String s)
        throws UnsupportedEncodingException;

    public String toStringUtf8()
    {
        String s;
        try
        {
            s = toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported?", unsupportedencodingexception);
        }
        return s;
    }

    static 
    {
        boolean flag;
        if (!com/google/protobuf/ByteString.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
