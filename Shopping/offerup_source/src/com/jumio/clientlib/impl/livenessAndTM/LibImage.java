// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            PixelFormatType, jniLivenessAndTMJNI, SWIGTYPE_p_unsigned_char

public class LibImage
{

    private long a;
    private boolean b;

    protected LibImage(long l, boolean flag)
    {
        b = flag;
        a = l;
    }

    public LibImage(byte abyte0[], PixelFormatType pixelformattype, int i, int j, long l, int k, 
            int i1, int j1, int k1)
    {
        this(jniLivenessAndTMJNI.new_LibImage__SWIG_1(abyte0, pixelformattype.swigValue(), i, j, l, k, i1, j1, k1), true);
    }

    public LibImage(byte abyte0[], PixelFormatType pixelformattype, int i, int j, long l, int k, 
            int i1, int j1, int k1, boolean flag)
    {
        this(jniLivenessAndTMJNI.new_LibImage__SWIG_0(abyte0, pixelformattype.swigValue(), i, j, l, k, i1, j1, k1, flag), true);
    }

    protected static long getCPtr(LibImage libimage)
    {
        if (libimage == null)
        {
            return 0L;
        } else
        {
            return libimage.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (b)
            {
                b = false;
                jniLivenessAndTMJNI.delete_LibImage(a);
            }
            a = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public int getChannelDepth()
    {
        return jniLivenessAndTMJNI.LibImage_getChannelDepth(a, this);
    }

    public int getChannels()
    {
        return jniLivenessAndTMJNI.LibImage_getChannels(a, this);
    }

    public PixelFormatType getFormat()
    {
        return PixelFormatType.swigToEnum(jniLivenessAndTMJNI.LibImage_getFormat(a, this));
    }

    public SWIGTYPE_p_unsigned_char getFrameBuffer()
    {
        long l = jniLivenessAndTMJNI.LibImage_getFrameBuffer__SWIG_0(a, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new SWIGTYPE_p_unsigned_char(l, false);
        }
    }

    public void getFrameBuffer(byte abyte0[])
    {
        jniLivenessAndTMJNI.LibImage_getFrameBuffer__SWIG_1(a, this, abyte0);
    }

    public int getFrameIndex()
    {
        return jniLivenessAndTMJNI.LibImage_getFrameIndex(a, this);
    }

    public int getHeight()
    {
        return jniLivenessAndTMJNI.LibImage_getHeight(a, this);
    }

    public long getStride()
    {
        return jniLivenessAndTMJNI.LibImage_getStride(a, this);
    }

    public int getTimeStamp()
    {
        return jniLivenessAndTMJNI.LibImage_getTimeStamp(a, this);
    }

    public int getWidth()
    {
        return jniLivenessAndTMJNI.LibImage_getWidth(a, this);
    }
}
