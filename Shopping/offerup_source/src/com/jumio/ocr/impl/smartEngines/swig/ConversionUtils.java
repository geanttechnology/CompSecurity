// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class ConversionUtils
{

    private long a;
    protected boolean swigCMemOwn;

    public ConversionUtils()
    {
        this(jniInterfaceJNI.new_ConversionUtils(), true);
    }

    protected ConversionUtils(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    public static int convertImage(byte abyte0[], ImageFormat imageformat, byte abyte1[])
    {
        return jniInterfaceJNI.ConversionUtils_convertImage(abyte0, imageformat.swigValue(), abyte1);
    }

    protected static long getCPtr(ConversionUtils conversionutils)
    {
        if (conversionutils == null)
        {
            return 0L;
        } else
        {
            return conversionutils.a;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniInterfaceJNI.delete_ConversionUtils(a);
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

    private class ImageFormat
    {

        public static final ImageFormat FORMAT_JPEG;
        public static final ImageFormat FORMAT_PNG;
        public static final ImageFormat FORMAT_TIFF;
        public static final ImageFormat FORMAT_UNKNOWN;
        public static final ImageFormat FORMAT_WEBP;
        private static ImageFormat a[];
        private static int b = 0;
        private final int c;
        private final String d;

        public static ImageFormat swigToEnum(int i)
        {
            if (i < a.length && i >= 0 && a[i].c == i)
            {
                return a[i];
            }
            for (int j = 0; j < a.length; j++)
            {
                if (a[j].c == i)
                {
                    return a[j];
                }
            }

            throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/ocr/impl/smartEngines/swig/ConversionUtils$ImageFormat).append(" with value ").append(i).toString());
        }

        public final int swigValue()
        {
            return c;
        }

        public final String toString()
        {
            return d;
        }

        static 
        {
            FORMAT_TIFF = new ImageFormat("FORMAT_TIFF");
            FORMAT_JPEG = new ImageFormat("FORMAT_JPEG");
            FORMAT_PNG = new ImageFormat("FORMAT_PNG");
            FORMAT_WEBP = new ImageFormat("FORMAT_WEBP");
            FORMAT_UNKNOWN = new ImageFormat("FORMAT_UNKNOWN");
            a = (new ImageFormat[] {
                FORMAT_TIFF, FORMAT_JPEG, FORMAT_PNG, FORMAT_WEBP, FORMAT_UNKNOWN
            });
        }

        private ImageFormat(String s)
        {
            d = s;
            int i = b;
            b = i + 1;
            c = i;
        }
    }

}
