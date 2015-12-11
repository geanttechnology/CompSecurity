// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ImageDef, ImageFormat, SWIGTYPE_p_unsigned_char

public class ImageBuffer
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ImageBuffer()
    {
        this(A9VSMobileJNI.new_ImageBuffer__SWIG_0(), true);
    }

    protected ImageBuffer(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public ImageBuffer(ImageDef imagedef, ImageFormat imageformat, int i, int j, int k, int l, SWIGTYPE_p_unsigned_char swigtype_p_unsigned_char)
    {
        this(A9VSMobileJNI.new_ImageBuffer__SWIG_1(imagedef.swigValue(), imageformat.swigValue(), i, j, k, l, SWIGTYPE_p_unsigned_char.getCPtr(swigtype_p_unsigned_char)), true);
    }

    protected static long getCPtr(ImageBuffer imagebuffer)
    {
        if (imagebuffer == null)
        {
            return 0L;
        } else
        {
            return imagebuffer.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_ImageBuffer(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int fillBuffer(byte abyte0[], int i)
    {
        return A9VSMobileJNI.ImageBuffer_fillBuffer(swigCPtr, this, abyte0, i);
    }

    protected void finalize()
    {
        delete();
    }

    public int getAllocLen()
    {
        return A9VSMobileJNI.ImageBuffer_allocLen_get(swigCPtr, this);
    }

    public SWIGTYPE_p_unsigned_char getData()
    {
        long l = A9VSMobileJNI.ImageBuffer_data_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new SWIGTYPE_p_unsigned_char(l, false);
        }
    }

    public ImageDef getDefinition()
    {
        return ImageDef.swigToEnum(A9VSMobileJNI.ImageBuffer_definition_get(swigCPtr, this));
    }

    public ImageFormat getFormat()
    {
        return ImageFormat.swigToEnum(A9VSMobileJNI.ImageBuffer_format_get(swigCPtr, this));
    }

    public int getHeight()
    {
        return A9VSMobileJNI.ImageBuffer_height_get(swigCPtr, this);
    }

    public int getNumChannels()
    {
        return A9VSMobileJNI.ImageBuffer_numChannels_get(swigCPtr, this);
    }

    public int getWidth()
    {
        return A9VSMobileJNI.ImageBuffer_width_get(swigCPtr, this);
    }

    public int getWidthStep()
    {
        return A9VSMobileJNI.ImageBuffer_widthStep_get(swigCPtr, this);
    }

    public void setAllocLen(int i)
    {
        A9VSMobileJNI.ImageBuffer_allocLen_set(swigCPtr, this, i);
    }

    public void setData(SWIGTYPE_p_unsigned_char swigtype_p_unsigned_char)
    {
        A9VSMobileJNI.ImageBuffer_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(swigtype_p_unsigned_char));
    }

    public void setDefinition(ImageDef imagedef)
    {
        A9VSMobileJNI.ImageBuffer_definition_set(swigCPtr, this, imagedef.swigValue());
    }

    public void setFormat(ImageFormat imageformat)
    {
        A9VSMobileJNI.ImageBuffer_format_set(swigCPtr, this, imageformat.swigValue());
    }

    public void setHeight(int i)
    {
        A9VSMobileJNI.ImageBuffer_height_set(swigCPtr, this, i);
    }

    public void setNumChannels(int i)
    {
        A9VSMobileJNI.ImageBuffer_numChannels_set(swigCPtr, this, i);
    }

    public void setWidth(int i)
    {
        A9VSMobileJNI.ImageBuffer_width_set(swigCPtr, this, i);
    }

    public void setWidthStep(int i)
    {
        A9VSMobileJNI.ImageBuffer_widthStep_set(swigCPtr, this, i);
    }
}
