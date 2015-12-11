// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FloatPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.ShortPointer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

public static class doubleBuffer extends doubleBuffer
{
    protected static class ReleaseDeallocator extends opencv_core.CvMat
        implements com.googlecode.javacpp.Pointer.Deallocator
    {

        public volatile Object clone()
            throws CloneNotSupportedException
        {
            return clone();
        }

        public void deallocate()
        {
            opencv_core.cvReleaseMat(this);
        }

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        ReleaseDeallocator(opencv_core.CvMat cvmat)
        {
            super(cvmat);
        }
    }


    static final boolean $assertionsDisabled;
    private ByteBuffer byteBuffer;
    private DoubleBuffer doubleBuffer;
    private FloatBuffer floatBuffer;
    private int fullSize;
    private IntBuffer intBuffer;
    private ShortBuffer shortBuffer;

    private native void allocate();

    private native void allocateArray(int i);

    public static position create(int i, int j)
    {
        return create(i, j, 6, 1);
    }

    public static create create(int i, int j, int k)
    {
        create create1 = opencv_core.cvCreateMat(i, j, k);
        if (create1 != null)
        {
            create1.fullSize = create1.size();
            create1.deallocator(new ReleaseDeallocator(create1));
        }
        return create1;
    }

    public static ReleaseDeallocator create(int i, int j, int k, int l)
    {
        return create(i, j, opencv_core.CV_MAKETYPE(k, l));
    }

    public static ETYPE createHeader(int i, int j)
    {
        return createHeader(i, j, 6, 1);
    }

    public static createHeader createHeader(int i, int j, int k)
    {
        createHeader createheader = opencv_core.cvCreateMatHeader(i, j, k);
        if (createheader != null)
        {
            createheader.fullSize = createheader.size();
            createheader.deallocator(new ReleaseDeallocator(createheader));
        }
        return createheader;
    }

    public static ReleaseDeallocator createHeader(int i, int j, int k, int l)
    {
        return createHeader(i, j, opencv_core.CV_MAKETYPE(k, l));
    }

    public static ThreadLocal createHeaderThreadLocal(int i, int j)
    {
        return createHeaderThreadLocal(i, j, 6, 1);
    }

    public static ThreadLocal createHeaderThreadLocal(int i, int j, int k)
    {
        return new ThreadLocal(i, j, k) {

            final int val$cols;
            final int val$rows;
            final int val$type;

            protected opencv_core.CvMat initialValue()
            {
                return opencv_core.CvMat.createHeader(rows, cols, type);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                rows = i;
                cols = j;
                type = k;
                super();
            }
        };
    }

    public static ThreadLocal createHeaderThreadLocal(int i, int j, int k, int l)
    {
        return createHeaderThreadLocal(i, j, opencv_core.CV_MAKETYPE(k, l));
    }

    public static ThreadLocal createThreadLocal(int i, int j)
    {
        return createThreadLocal(i, j, 6, 1);
    }

    public static ThreadLocal createThreadLocal(int i, int j, int k)
    {
        return new ThreadLocal(i, j, k) {

            final int val$cols;
            final int val$rows;
            final int val$type;

            protected opencv_core.CvMat initialValue()
            {
                return opencv_core.CvMat.create(rows, cols, type);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                rows = i;
                cols = j;
                type = k;
                super();
            }
        };
    }

    public static ThreadLocal createThreadLocal(int i, int j, int k, int l)
    {
        return createThreadLocal(i, j, opencv_core.CV_MAKETYPE(k, l));
    }

    private int fullSize()
    {
        if (fullSize > 0)
        {
            return fullSize;
        } else
        {
            int i = size();
            fullSize = i;
            return i;
        }
    }

    public ge asIplImage()
    {
        ge ge = new ge();
        opencv_core.cvGetImage(this, ge);
        return ge;
    }

    public int channels()
    {
        return opencv_core.CV_MAT_CN(type());
    }

    public type clone()
    {
        type type1 = opencv_core.cvCloneMat(this);
        if (type1 != null)
        {
            type1.deallocator(new ReleaseDeallocator(type1));
        }
        return type1;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public native int cols();

    public native clone cols(int i);

    public  cvSize()
    {
        return opencv_core.cvSize(cols(), rows());
    }

    public native DoublePointer data_db();

    public native rows data_db(DoublePointer doublepointer);

    public native FloatPointer data_fl();

    public native rows data_fl(FloatPointer floatpointer);

    public native IntPointer data_i();

    public native rows data_i(IntPointer intpointer);

    public native BytePointer data_ptr();

    public native rows data_ptr(BytePointer bytepointer);

    public native ShortPointer data_s();

    public native rows data_s(ShortPointer shortpointer);

    public int depth()
    {
        return opencv_core.CV_MAT_DEPTH(type());
    }

    public int elemSize()
    {
        switch (depth())
        {
        default:
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            } else
            {
                return 0;
            }

        case 0: // '\0'
        case 1: // '\001'
            return 1;

        case 2: // '\002'
        case 3: // '\003'
            return 2;

        case 4: // '\004'
        case 5: // '\005'
            return 4;

        case 6: // '\006'
            return 8;
        }
    }

    public boolean empty()
    {
        return length() == 0;
    }

    public double get(int i)
    {
        switch (depth())
        {
        default:
            if (!$assertionsDisabled)
            {
                throw new AssertionError();
            } else
            {
                return (0.0D / 0.0D);
            }

        case 0: // '\0'
            return (double)(getByteBuffer().get(i) & 0xff);

        case 1: // '\001'
            return (double)getByteBuffer().get(i);

        case 2: // '\002'
            return (double)(getShortBuffer().get(i) & 0xffff);

        case 3: // '\003'
            return (double)getShortBuffer().get(i);

        case 4: // '\004'
            return (double)getIntBuffer().get(i);

        case 5: // '\005'
            return (double)getFloatBuffer().get(i);

        case 6: // '\006'
            return getDoubleBuffer().get(i);
        }
    }

    public double get(int i, int j)
    {
        return get((step() * i) / elemSize() + channels() * j);
    }

    public double get(int i, int j, int k)
    {
        return get((step() * i) / elemSize() + channels() * j + k);
    }

    public channels get(int i, double ad[])
    {
        return get(i, ad, 0, ad.length);
    }

    public get get(int i, double ad[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        int l = depth();
        l;
        JVM INSTR tableswitch 0 6: default 292
    //                   0 71
    //                   1 71
    //                   2 131
    //                   3 131
    //                   4 189
    //                   5 228
    //                   6 267;
           goto _L1 _L2 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
          goto _L7
        ad;
        this;
        JVM INSTR monitorexit ;
        throw ad;
_L2:
        Object obj;
        obj = getByteBuffer();
        ((ByteBuffer) (obj)).position(i);
        i = 0;
_L18:
        if (i >= k) goto _L7; else goto _L8
_L8:
        if (l != 0) goto _L10; else goto _L9
_L9:
        ad[i + j] = ((ByteBuffer) (obj)).get(i) & 0xff;
          goto _L11
_L10:
        ad[i + j] = ((ByteBuffer) (obj)).get(i);
          goto _L11
_L3:
        obj = getShortBuffer();
        ((ShortBuffer) (obj)).position(i);
        i = 0;
_L19:
        if (i >= k) goto _L7; else goto _L12
_L12:
        if (l != 2) goto _L14; else goto _L13
_L13:
        ad[i + j] = ((ShortBuffer) (obj)).get() & 0xffff;
          goto _L15
_L14:
        ad[i + j] = ((ShortBuffer) (obj)).get();
          goto _L15
_L4:
        obj = getIntBuffer();
        ((IntBuffer) (obj)).position(i);
        i = 0;
_L16:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ad[i + j] = ((IntBuffer) (obj)).get();
        i++;
        if (true) goto _L16; else goto _L7
_L5:
        obj = getFloatBuffer();
        ((FloatBuffer) (obj)).position(i);
        i = 0;
_L17:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ad[i + j] = ((FloatBuffer) (obj)).get();
        i++;
        if (true) goto _L17; else goto _L7
_L6:
        getDoubleBuffer().position(i);
        getDoubleBuffer().get(ad, j, k);
_L7:
        this;
        JVM INSTR monitorexit ;
        return this;
_L11:
        i++;
          goto _L18
_L15:
        i++;
          goto _L19
    }

    public getDoubleBuffer get(double ad[])
    {
        return get(0, ad);
    }

    public double[] get()
    {
        double ad[] = new double[fullSize() / elemSize()];
        get(ad);
        return ad;
    }

    public ByteBuffer getByteBuffer()
    {
        if (byteBuffer == null)
        {
            byteBuffer = data_ptr().capacity(fullSize()).asBuffer();
        }
        byteBuffer.position(0);
        return byteBuffer;
    }

    public DoubleBuffer getDoubleBuffer()
    {
        if (doubleBuffer == null)
        {
            doubleBuffer = data_db().capacity(fullSize() / 8).asBuffer();
        }
        doubleBuffer.position(0);
        return doubleBuffer;
    }

    public FloatBuffer getFloatBuffer()
    {
        if (floatBuffer == null)
        {
            floatBuffer = data_fl().capacity(fullSize() / 4).asBuffer();
        }
        floatBuffer.position(0);
        return floatBuffer;
    }

    public IntBuffer getIntBuffer()
    {
        if (intBuffer == null)
        {
            intBuffer = data_i().capacity(fullSize() / 4).asBuffer();
        }
        intBuffer.position(0);
        return intBuffer;
    }

    public ShortBuffer getShortBuffer()
    {
        if (shortBuffer == null)
        {
            shortBuffer = data_s().capacity(fullSize() / 2).asBuffer();
        }
        shortBuffer.position(0);
        return shortBuffer;
    }

    public native int hdr_refcount();

    public native shortBuffer hdr_refcount(int i);

    public boolean isContinuous()
    {
        return opencv_core.CV_IS_MAT_CONT(type());
    }

    public int length()
    {
        return rows() * cols();
    }

    public int nChannels()
    {
        return opencv_core.CV_MAT_CN(type());
    }

    public volatile Pointer position(int i)
    {
        return position(i);
    }

    public position position(int i)
    {
        return (position)super.position(i);
    }

    public position put(int i, double d)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        switch (depth())
                        {
                        default:
                            if (!$assertionsDisabled)
                            {
                                throw new AssertionError();
                            }
                            break;

                        case 2: // '\002'
                        case 3: // '\003'
                            break label3;

                        case 4: // '\004'
                            break label2;

                        case 5: // '\005'
                            break label1;

                        case 6: // '\006'
                            break label0;

                        case 0: // '\0'
                        case 1: // '\001'
                            getByteBuffer().put(i, (byte)(int)d);
                            break;
                        }
                        return this;
                    }
                    getShortBuffer().put(i, (short)(int)d);
                    return this;
                }
                getIntBuffer().put(i, (int)d);
                return this;
            }
            getFloatBuffer().put(i, (float)d);
            return this;
        }
        getDoubleBuffer().put(i, d);
        return this;
    }

    public getDoubleBuffer put(int i, int j, double d)
    {
        return put((step() * i) / elemSize() + channels() * j, d);
    }

    public channels put(int i, int j, int k, double d)
    {
        return put((step() * i) / elemSize() + channels() * j + k, d);
    }

    public channels put(int i, int j, int k, channels channels1, int l, int i1, int j1)
    {
        this;
        JVM INSTR monitorenter ;
        if (rows() != channels1.rows() || cols() != channels1.cols() || step() != channels1.step() || type() != channels1.type() || i != 0 || j != 0 || k != 0 || l != 0 || i1 != 0 || j1 != 0) goto _L2; else goto _L1
_L1:
        getByteBuffer().clear();
        channels1.getByteBuffer().clear();
        getByteBuffer().put(channels1.getByteBuffer());
_L5:
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        int j2;
        int k2;
        int l2;
        j2 = Math.min(rows() - i, channels1.rows() - l);
        k2 = Math.min(cols() - j, channels1.cols() - i1);
        l2 = Math.min(channels() - k, channels1.channels() - j1);
        int k1;
        k1 = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        int i2;
        if (i2 >= l2)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        int l1;
        put(k1 + i, l1 + j, i2 + k, channels1.get(k1 + l, l1 + i1, i2 + j1));
        i2++;
          goto _L3
        channels1;
        throw channels1;
        if (k1 >= j2) goto _L5; else goto _L4
_L4:
        l1 = 0;
        for (l1++; l1 >= k2;)
        {
            k1++;
            continue; /* Loop/switch isn't completed */
        }

        i2 = 0;
          goto _L3
    }

    public transient get put(int i, double ad[])
    {
        return put(i, ad, 0, ad.length);
    }

    public put put(int i, double ad[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        depth();
        JVM INSTR tableswitch 0 6: default 256
    //                   0 67
    //                   1 67
    //                   2 108
    //                   3 108
    //                   4 149
    //                   5 189
    //                   6 229;
           goto _L1 _L2 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
        if (!$assertionsDisabled)
        {
            throw new AssertionError();
        }
          goto _L7
        ad;
        this;
        JVM INSTR monitorexit ;
        throw ad;
_L2:
        Object obj;
        obj = getByteBuffer();
        ((ByteBuffer) (obj)).position(i);
        i = 0;
_L8:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ByteBuffer) (obj)).put((byte)(int)ad[i + j]);
        i++;
        if (true) goto _L8; else goto _L7
_L3:
        obj = getShortBuffer();
        ((ShortBuffer) (obj)).position(i);
        i = 0;
_L9:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ShortBuffer) (obj)).put((short)(int)ad[i + j]);
        i++;
        if (true) goto _L9; else goto _L7
_L4:
        obj = getIntBuffer();
        ((IntBuffer) (obj)).position(i);
        i = 0;
_L10:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((IntBuffer) (obj)).put((int)ad[i + j]);
        i++;
        if (true) goto _L10; else goto _L7
_L5:
        obj = getFloatBuffer();
        ((FloatBuffer) (obj)).position(i);
        i = 0;
_L11:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((FloatBuffer) (obj)).put((float)ad[i + j]);
        i++;
        if (true) goto _L11; else goto _L7
_L6:
        DoubleBuffer doublebuffer = getDoubleBuffer();
        doublebuffer.position(i);
        doublebuffer.put(ad, j, k);
_L7:
        this;
        JVM INSTR monitorexit ;
        return this;
    }

    public getDoubleBuffer put(getDoubleBuffer getdoublebuffer)
    {
        return put(0, 0, 0, getdoublebuffer, 0, 0, 0);
    }

    public transient put put(double ad[])
    {
        return put(0, ad);
    }

    public native int raw_type();

    public native put raw_type(int i);

    public native IntPointer refcount();

    public native put refcount(IntPointer intpointer);

    public void release()
    {
        deallocate();
    }

    public void reset()
    {
        fullSize = 0;
        byteBuffer = null;
        shortBuffer = null;
        intBuffer = null;
        floatBuffer = null;
        doubleBuffer = null;
    }

    public native int rows();

    public native doubleBuffer rows(int i);

    public int size()
    {
        int i = rows();
        int j = cols();
        int k = elemSize();
        int l = channels();
        if (i > 1)
        {
            i = step() * (i - 1);
        } else
        {
            i = 0;
        }
        return i + l * (j * k);
    }

    public native int step();

    public native step step(int i);

    public String toString()
    {
        return toString(0);
    }

    public String toString(int i)
    {
        StringBuilder stringbuilder = new StringBuilder("[ ");
        int j1 = channels();
        for (int j = 0; j < rows(); j++)
        {
            for (int k = 0; k < cols(); k++)
            {
                ar ar = opencv_core.cvGet2D(this, j, k);
                if (j1 > 1)
                {
                    stringbuilder.append("(");
                }
                for (int i1 = 0; i1 < j1; i1++)
                {
                    stringbuilder.append((float)ar.val(i1));
                    if (i1 < j1 - 1)
                    {
                        stringbuilder.append(", ");
                    }
                }

                if (j1 > 1)
                {
                    stringbuilder.append(")");
                }
                if (k < cols() - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            if (j >= rows() - 1)
            {
                continue;
            }
            stringbuilder.append("\n  ");
            for (int l = 0; l < i; l++)
            {
                stringbuilder.append(' ');
            }

        }

        stringbuilder.append(" ]");
        return stringbuilder.toString();
    }

    public int total()
    {
        return rows() * cols();
    }

    public int type()
    {
        return opencv_core.CV_MAT_TYPE(raw_type());
    }

    public void type(int i, int j)
    {
        raw_type(opencv_core.CV_MAKETYPE(i, j) | 0x42420000);
    }

    static 
    {
        boolean flag;
        if (!com/googlecode/javacv/cpp/opencv_core.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

    public _cls2.val.type()
    {
        fullSize = 0;
        byteBuffer = null;
        shortBuffer = null;
        intBuffer = null;
        floatBuffer = null;
        doubleBuffer = null;
        allocate();
        zero();
    }

    public zero(int i)
    {
        fullSize = 0;
        byteBuffer = null;
        shortBuffer = null;
        intBuffer = null;
        floatBuffer = null;
        doubleBuffer = null;
        allocateArray(i);
        zero();
    }

    public zero(Pointer pointer)
    {
        super(pointer);
        fullSize = 0;
        byteBuffer = null;
        shortBuffer = null;
        intBuffer = null;
        floatBuffer = null;
        doubleBuffer = null;
    }
}
