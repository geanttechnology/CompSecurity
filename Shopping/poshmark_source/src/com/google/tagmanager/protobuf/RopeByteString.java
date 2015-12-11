// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            ByteString, LiteralByteString, CodedInputStream

class RopeByteString extends ByteString
{
    private static class Balancer
    {

        private final Deque prefixesStack;

        private ByteString balance(ByteString bytestring, ByteString bytestring1)
        {
            doBalance(bytestring);
            doBalance(bytestring1);
            for (bytestring = (ByteString)prefixesStack.pop(); !prefixesStack.isEmpty(); bytestring = new RopeByteString((ByteString)prefixesStack.pop(), bytestring)) { }
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
                doBalance(((RopeByteString) (bytestring)).left);
                doBalance(((RopeByteString) (bytestring)).right);
                return;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Has a new type of ByteString been created? Found ").append(bytestring.getClass()).toString());
            }
        }

        private int getDepthBinForLength(int i)
        {
            int j = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
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
            int k = RopeByteString.minLengthByDepth[i + 1];
            if (prefixesStack.isEmpty() || ((ByteString)prefixesStack.peek()).size() >= k)
            {
                prefixesStack.push(bytestring);
                return;
            }
            i = RopeByteString.minLengthByDepth[i];
            Object obj;
            for (obj = (ByteString)prefixesStack.pop(); !prefixesStack.isEmpty() && ((ByteString)prefixesStack.peek()).size() < i; obj = new RopeByteString((ByteString)prefixesStack.pop(), ((ByteString) (obj)))) { }
            bytestring = new RopeByteString(((ByteString) (obj)), bytestring);
            do
            {
                if (prefixesStack.isEmpty())
                {
                    break;
                }
                int j = getDepthBinForLength(bytestring.size());
                j = RopeByteString.minLengthByDepth[j + 1];
                if (((ByteString)prefixesStack.peek()).size() >= j)
                {
                    break;
                }
                bytestring = new RopeByteString((ByteString)prefixesStack.pop(), bytestring);
            } while (true);
            prefixesStack.push(bytestring);
        }


        private Balancer()
        {
            prefixesStack = new ArrayDeque(RopeByteString.minLengthByDepth.length);
        }

    }

    private static class PieceIterator
        implements Iterator
    {

        private final Deque breadCrumbs;
        private LiteralByteString next;

        private LiteralByteString getLeafByLeft(ByteString bytestring)
        {
            for (; bytestring instanceof RopeByteString; bytestring = ((RopeByteString) (bytestring)).left)
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
                literalbytestring = getLeafByLeft(((RopeByteString)breadCrumbs.pop()).right);
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

        private PieceIterator(ByteString bytestring)
        {
            breadCrumbs = new ArrayDeque(RopeByteString.minLengthByDepth.length);
            next = getLeafByLeft(bytestring);
        }

    }

    private class RopeByteIterator
        implements ByteString.ByteIterator
    {

        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;
        final RopeByteString this$0;

        public boolean hasNext()
        {
            return bytesRemaining > 0;
        }

        public Byte next()
        {
            return Byte.valueOf(nextByte());
        }

        public volatile Object next()
        {
            return next();
        }

        public byte nextByte()
        {
            if (!bytes.hasNext())
            {
                bytes = pieces.next().iterator();
            }
            bytesRemaining = bytesRemaining - 1;
            return bytes.nextByte();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        private RopeByteIterator()
        {
            this$0 = RopeByteString.this;
            super();
            pieces = new PieceIterator(RopeByteString.this);
            bytes = pieces.next().iterator();
            bytesRemaining = size();
        }

    }

    private class RopeInputStream extends InputStream
    {

        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final RopeByteString this$0;

        private void advanceIfCurrentPieceFullyRead()
        {
label0:
            {
                if (currentPiece != null && currentPieceIndex == currentPieceSize)
                {
                    currentPieceOffsetInRope = currentPieceOffsetInRope + currentPieceSize;
                    currentPieceIndex = 0;
                    if (!pieceIterator.hasNext())
                    {
                        break label0;
                    }
                    currentPiece = pieceIterator.next();
                    currentPieceSize = currentPiece.size();
                }
                return;
            }
            currentPiece = null;
            currentPieceSize = 0;
        }

        private void initialize()
        {
            pieceIterator = new PieceIterator(RopeByteString.this);
            currentPiece = pieceIterator.next();
            currentPieceSize = currentPiece.size();
            currentPieceIndex = 0;
            currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte abyte0[], int i, int j)
        {
            int l = j;
            int k = i;
            for (i = l; i > 0;)
            {
                advanceIfCurrentPieceFullyRead();
                if (currentPiece == null)
                {
                    if (i == j)
                    {
                        return -1;
                    }
                    break;
                }
                int j1 = Math.min(currentPieceSize - currentPieceIndex, i);
                int i1 = k;
                if (abyte0 != null)
                {
                    currentPiece.copyTo(abyte0, currentPieceIndex, k, j1);
                    i1 = k + j1;
                }
                currentPieceIndex = currentPieceIndex + j1;
                i -= j1;
                k = i1;
            }

            return j - i;
        }

        public int available()
            throws IOException
        {
            int i = currentPieceOffsetInRope;
            int j = currentPieceIndex;
            return size() - (i + j);
        }

        public void mark(int i)
        {
            mark = currentPieceOffsetInRope + currentPieceIndex;
        }

        public boolean markSupported()
        {
            return true;
        }

        public int read()
            throws IOException
        {
            advanceIfCurrentPieceFullyRead();
            if (currentPiece == null)
            {
                return -1;
            } else
            {
                LiteralByteString literalbytestring = currentPiece;
                int i = currentPieceIndex;
                currentPieceIndex = i + 1;
                return literalbytestring.byteAt(i) & 0xff;
            }
        }

        public int read(byte abyte0[], int i, int j)
        {
            if (abyte0 == null)
            {
                throw new NullPointerException();
            }
            if (i < 0 || j < 0 || j > abyte0.length - i)
            {
                throw new IndexOutOfBoundsException();
            } else
            {
                return readSkipInternal(abyte0, i, j);
            }
        }

        public void reset()
        {
            this;
            JVM INSTR monitorenter ;
            initialize();
            readSkipInternal(null, 0, mark);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public long skip(long l)
        {
            if (l < 0L)
            {
                throw new IndexOutOfBoundsException();
            }
            long l1 = l;
            if (l > 0x7fffffffL)
            {
                l1 = 0x7fffffffL;
            }
            return (long)readSkipInternal(null, 0, (int)l1);
        }

        public RopeInputStream()
        {
            this$0 = RopeByteString.this;
            super();
            initialize();
        }
    }


    private static final int minLengthByDepth[];
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private RopeByteString(ByteString bytestring, ByteString bytestring1)
    {
        hash = 0;
        left = bytestring;
        right = bytestring1;
        leftLength = bytestring.size();
        totalLength = leftLength + bytestring1.size();
        treeDepth = Math.max(bytestring.getTreeDepth(), bytestring1.getTreeDepth()) + 1;
    }


    static ByteString concatenate(ByteString bytestring, ByteString bytestring1)
    {
        RopeByteString ropebytestring;
        if (bytestring instanceof RopeByteString)
        {
            ropebytestring = (RopeByteString)bytestring;
        } else
        {
            ropebytestring = null;
        }
        if (bytestring1.size() == 0)
        {
            return bytestring;
        }
        if (bytestring.size() == 0)
        {
            return bytestring1;
        }
        int i = bytestring.size() + bytestring1.size();
        if (i < 128)
        {
            return concatenateBytes(bytestring, bytestring1);
        }
        if (ropebytestring != null && ropebytestring.right.size() + bytestring1.size() < 128)
        {
            bytestring = concatenateBytes(ropebytestring.right, bytestring1);
            return new RopeByteString(ropebytestring.left, bytestring);
        }
        if (ropebytestring != null && ropebytestring.left.getTreeDepth() > ropebytestring.right.getTreeDepth() && ropebytestring.getTreeDepth() > bytestring1.getTreeDepth())
        {
            bytestring = new RopeByteString(ropebytestring.right, bytestring1);
            return new RopeByteString(ropebytestring.left, bytestring);
        }
        int j = Math.max(bytestring.getTreeDepth(), bytestring1.getTreeDepth());
        if (i >= minLengthByDepth[j + 1])
        {
            return new RopeByteString(bytestring, bytestring1);
        } else
        {
            return (new Balancer()).balance(bytestring, bytestring1);
        }
    }

    private static LiteralByteString concatenateBytes(ByteString bytestring, ByteString bytestring1)
    {
        int i = bytestring.size();
        int j = bytestring1.size();
        byte abyte0[] = new byte[i + j];
        bytestring.copyTo(abyte0, 0, 0, i);
        bytestring1.copyTo(abyte0, 0, i, j);
        return new LiteralByteString(abyte0);
    }

    private boolean equalsFragments(ByteString bytestring)
    {
        int j = 0;
        PieceIterator pieceiterator = new PieceIterator(this);
        LiteralByteString literalbytestring = (LiteralByteString)pieceiterator.next();
        int i = 0;
        PieceIterator pieceiterator1 = new PieceIterator(bytestring);
        bytestring = (LiteralByteString)pieceiterator1.next();
        int k = 0;
        do
        {
            int j1 = literalbytestring.size() - j;
            int l = bytestring.size() - i;
            int i1 = Math.min(j1, l);
            boolean flag;
            if (j == 0)
            {
                flag = literalbytestring.equalsRange(bytestring, i, i1);
            } else
            {
                flag = bytestring.equalsRange(literalbytestring, j, i1);
            }
            if (!flag)
            {
                return false;
            }
            k += i1;
            if (k >= totalLength)
            {
                if (k == totalLength)
                {
                    return true;
                } else
                {
                    throw new IllegalStateException();
                }
            }
            if (i1 == j1)
            {
                j = 0;
                literalbytestring = (LiteralByteString)pieceiterator.next();
            } else
            {
                j += i1;
            }
            if (i1 == l)
            {
                i = 0;
                bytestring = (LiteralByteString)pieceiterator1.next();
            } else
            {
                i += i1;
            }
        } while (true);
    }

    static RopeByteString newInstanceForTest(ByteString bytestring, ByteString bytestring1)
    {
        return new RopeByteString(bytestring, bytestring1);
    }

    public ByteBuffer asReadOnlyByteBuffer()
    {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List asReadOnlyByteBufferList()
    {
        ArrayList arraylist = new ArrayList();
        for (PieceIterator pieceiterator = new PieceIterator(this); pieceiterator.hasNext(); arraylist.add(pieceiterator.next().asReadOnlyByteBuffer())) { }
        return arraylist;
    }

    public byte byteAt(int i)
    {
        if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Index < 0: ").append(i).toString());
        }
        if (i > totalLength)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Index > length: ").append(i).append(", ").append(totalLength).toString());
        }
        if (i < leftLength)
        {
            return left.byteAt(i);
        } else
        {
            return right.byteAt(i - leftLength);
        }
    }

    public void copyTo(ByteBuffer bytebuffer)
    {
        left.copyTo(bytebuffer);
        right.copyTo(bytebuffer);
    }

    protected void copyToInternal(byte abyte0[], int i, int j, int k)
    {
        if (i + k <= leftLength)
        {
            left.copyToInternal(abyte0, i, j, k);
            return;
        }
        if (i >= leftLength)
        {
            right.copyToInternal(abyte0, i - leftLength, j, k);
            return;
        } else
        {
            int l = leftLength - i;
            left.copyToInternal(abyte0, i, j, l);
            right.copyToInternal(abyte0, 0, j + l, k - l);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ByteString))
            {
                return false;
            }
            obj = (ByteString)obj;
            if (totalLength != ((ByteString) (obj)).size())
            {
                return false;
            }
            if (totalLength != 0)
            {
                if (hash != 0)
                {
                    int i = ((ByteString) (obj)).peekCachedHashCode();
                    if (i != 0 && hash != i)
                    {
                        return false;
                    }
                }
                return equalsFragments(((ByteString) (obj)));
            }
        }
        return true;
    }

    protected int getTreeDepth()
    {
        return treeDepth;
    }

    public int hashCode()
    {
        int j = hash;
        int i = j;
        if (j == 0)
        {
            int k = partialHash(totalLength, 0, totalLength);
            i = k;
            if (k == 0)
            {
                i = 1;
            }
            hash = i;
        }
        return i;
    }

    protected boolean isBalanced()
    {
        return totalLength >= minLengthByDepth[treeDepth];
    }

    public boolean isValidUtf8()
    {
        boolean flag = false;
        int i = left.partialIsValidUtf8(0, 0, leftLength);
        if (right.partialIsValidUtf8(i, 0, right.size()) == 0)
        {
            flag = true;
        }
        return flag;
    }

    public ByteString.ByteIterator iterator()
    {
        return new RopeByteIterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public CodedInputStream newCodedInput()
    {
        return CodedInputStream.newInstance(new RopeInputStream());
    }

    public InputStream newInput()
    {
        return new RopeInputStream();
    }

    protected int partialHash(int i, int j, int k)
    {
        if (j + k <= leftLength)
        {
            return left.partialHash(i, j, k);
        }
        if (j >= leftLength)
        {
            return right.partialHash(i, j - leftLength, k);
        } else
        {
            int l = leftLength - j;
            i = left.partialHash(i, j, l);
            return right.partialHash(i, 0, k - l);
        }
    }

    protected int partialIsValidUtf8(int i, int j, int k)
    {
        if (j + k <= leftLength)
        {
            return left.partialIsValidUtf8(i, j, k);
        }
        if (j >= leftLength)
        {
            return right.partialIsValidUtf8(i, j - leftLength, k);
        } else
        {
            int l = leftLength - j;
            i = left.partialIsValidUtf8(i, j, l);
            return right.partialIsValidUtf8(i, 0, k - l);
        }
    }

    protected int peekCachedHashCode()
    {
        return hash;
    }

    public int size()
    {
        return totalLength;
    }

    public ByteString substring(int i, int j)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (j > totalLength)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("End index: ").append(j).append(" > ").append(totalLength).toString());
        }
        int k = j - i;
        if (k < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Beginning index larger than ending index: ").append(i).append(", ").append(j).toString());
        }
        if (k == 0)
        {
            return ByteString.EMPTY;
        }
        if (k == totalLength)
        {
            return this;
        }
        if (j <= leftLength)
        {
            return left.substring(i, j);
        }
        if (i >= leftLength)
        {
            return right.substring(i - leftLength, j - leftLength);
        } else
        {
            return new RopeByteString(left.substring(i), right.substring(0, j - leftLength));
        }
    }

    public String toString(String s)
        throws UnsupportedEncodingException
    {
        return new String(toByteArray(), s);
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        left.writeTo(outputstream);
        right.writeTo(outputstream);
    }

    void writeToInternal(OutputStream outputstream, int i, int j)
        throws IOException
    {
        if (i + j <= leftLength)
        {
            left.writeToInternal(outputstream, i, j);
            return;
        }
        if (i >= leftLength)
        {
            right.writeToInternal(outputstream, i - leftLength, j);
            return;
        } else
        {
            int k = leftLength - i;
            left.writeToInternal(outputstream, i, k);
            right.writeToInternal(outputstream, 0, j - k);
            return;
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        int k = 1;
        int i = 1;
        do
        {
            int l = k;
            if (i <= 0)
            {
                break;
            }
            arraylist.add(Integer.valueOf(i));
            k = i;
            i = l + i;
        } while (true);
        arraylist.add(Integer.valueOf(0x7fffffff));
        minLengthByDepth = new int[arraylist.size()];
        for (int j = 0; j < minLengthByDepth.length; j++)
        {
            minLengthByDepth[j] = ((Integer)arraylist.get(j)).intValue();
        }

    }



}
