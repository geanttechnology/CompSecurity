// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Context;
import android.graphics.Point;
import com.socialin.android.d;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

// Referenced classes of package com.picsart.studio:
//            h

public class PicsartContext
{

    public static final MemoryType a;
    public static final h b = f();
    private static final String c = com/picsart/studio/PicsartContext.getSimpleName();
    private static int d;

    public PicsartContext()
    {
    }

    public static int a()
    {
        return d;
    }

    public static int a(Context context)
    {
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorenter ;
        int i;
        i = b(context);
        d = i;
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorexit ;
        return i;
        context;
        throw context;
    }

    public static void a(Context context, int i)
    {
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorenter ;
        context = new File(context.getExternalCacheDir(), "config1.conf");
        Object obj = null;
        context = new DataOutputStream(new FileOutputStream(context));
        context.writeInt(i);
        context.close();
_L1:
        d = i;
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorexit ;
        return;
        context;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
          goto _L1
        context;
        throw context;
        context;
        context = null;
_L6:
        if (context == null) goto _L1; else goto _L2
_L2:
        context.close();
          goto _L1
        context;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
          goto _L1
        context;
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        ((DataOutputStream) (obj)).close();
_L3:
        throw context;
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L3
        Exception exception;
        exception;
        obj = context;
        context = exception;
        if (true) goto _L5; else goto _L4
_L4:
        IOException ioexception;
        ioexception;
          goto _L6
    }

    public static int b()
    {
        return d / 0x100000;
    }

    private static int b(Context context)
    {
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorenter ;
        int i = a.getRecomendedImageSizePixel();
        Object obj = null;
        DataInputStream datainputstream = new DataInputStream(new FileInputStream(new File(context.getExternalCacheDir(), "config1.conf")));
        obj = datainputstream;
        int j = datainputstream.readInt();
        datainputstream.close();
_L1:
        com/picsart/studio/PicsartContext;
        JVM INSTR monitorexit ;
        return j;
        context;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
          goto _L1
        context;
        throw context;
        obj;
        datainputstream = null;
_L6:
        obj = datainputstream;
        a(context, i);
        j = i;
        if (datainputstream == null) goto _L1; else goto _L2
_L2:
        datainputstream.close();
        j = i;
          goto _L1
        context;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        j = i;
          goto _L1
        context;
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        ((DataInputStream) (obj)).close();
_L3:
        throw context;
        Object obj1;
        obj1;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
          goto _L3
        context;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
    }

    public static Point c()
    {
        char c1;
        char c2;
        int i;
        i = a.getOptimalImageSize();
        c2 = '\u0400';
        c1 = '\u0300';
        i;
        JVM INSTR lookupswitch 3: default 52
    //                   1600: 62
    //                   2048: 73
    //                   3200: 84;
           goto _L1 _L2 _L3 _L4
_L1:
        return new Point(c2, c1);
_L2:
        c2 = '\u0640';
        c1 = '\u04B0';
        continue; /* Loop/switch isn't completed */
_L3:
        c2 = '\u0800';
        c1 = '\u0600';
        continue; /* Loop/switch isn't completed */
_L4:
        c2 = '\u0C80';
        c1 = '\u0960';
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static Point d()
    {
        char c1;
        char c2;
        int i;
        i = a.getOptimalImageSize();
        c2 = '\u0400';
        c1 = '\u0300';
        i;
        JVM INSTR lookupswitch 2: default 44
    //                   2048: 54
    //                   3200: 65;
           goto _L1 _L2 _L3
_L1:
        return new Point(c2, c1);
_L2:
        c2 = '\u0640';
        c1 = '\u04B0';
        continue; /* Loop/switch isn't completed */
_L3:
        c2 = '\u0800';
        c1 = '\u0600';
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static Point e()
    {
        char c1;
        char c2;
        int i;
        i = a.getOptimalImageSize();
        c2 = '\u0400';
        c1 = '\u0300';
        i;
        JVM INSTR lookupswitch 3: default 52
    //                   1600: 62
    //                   2048: 73
    //                   3200: 84;
           goto _L1 _L2 _L3 _L4
_L1:
        return new Point(c2, c1);
_L2:
        c2 = '\u0640';
        c1 = '\u04B0';
        continue; /* Loop/switch isn't completed */
_L3:
        c2 = '\u0800';
        c1 = '\u0600';
        continue; /* Loop/switch isn't completed */
_L4:
        c2 = '\u0C80';
        c1 = '\u0960';
        if (true) goto _L1; else goto _L5
_L5:
    }

    private static h f()
    {
        Object obj;
        Object obj1;
        Object obj2;
        int i;
        int j;
        obj = null;
        obj2 = null;
        StringBuilder stringbuilder;
        int k;
        try
        {
            stringbuilder = new StringBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(c, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
            });
            return new h(Runtime.getRuntime().availableProcessors(), ProcessorName.UNKNOWN, 0);
        }
        obj1 = new BufferedReader(new FileReader("/proc/cpuinfo"));
_L3:
        obj = ((BufferedReader) (obj1)).readLine();
        if (obj == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(((String) (obj)));
          goto _L3
        obj;
_L10:
        obj = obj1;
        obj2 = new h(Runtime.getRuntime().availableProcessors(), ProcessorName.UNKNOWN, 0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ((BufferedReader) (obj1)).close();
        return ((h) (obj2));
_L2:
        ((BufferedReader) (obj1)).close();
_L6:
        obj1 = stringbuilder.toString().replaceAll("\t", "").replaceAll(" ", "");
        i = ((String) (obj1)).indexOf("CPUarchitecture:");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        obj = ((String) (obj1)).substring(i + 16, i + 16 + 1);
_L12:
        i = ((String) (obj1)).indexOf("CPUrevision:");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        j = Integer.parseInt(((String) (obj1)).substring(i + 12, i + 12 + 1));
_L11:
        k = ((String) (obj1)).indexOf("processor:");
        i = 0;
_L5:
        if (k == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        k = ((String) (obj1)).indexOf("processor:", k + 10);
        i++;
        if (true) goto _L5; else goto _L4
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
          goto _L6
        obj;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
        });
        return ((h) (obj2));
        obj2;
        obj1 = obj;
        obj = obj2;
_L9:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_344;
        }
        ((BufferedReader) (obj1)).close();
_L7:
        throw obj;
        obj1;
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj1)).getMessage()).toString()
        });
          goto _L7
_L4:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        i = Runtime.getRuntime().availableProcessors();
        obj = new h(i, ProcessorName.fromString(((String) (obj))), j);
        return ((h) (obj));
        obj;
        if (true) goto _L9; else goto _L8
_L8:
        obj;
        obj1 = obj2;
          goto _L10
        j = 0;
          goto _L11
        obj = "";
          goto _L12
    }

    static 
    {
        a = MemoryType.getMemoryType((int)(Runtime.getRuntime().maxMemory() / 1024L / 1024L));
        com.socialin.android.d.b(c, new Object[] {
            (new StringBuilder("Memory type is ")).append(a).toString()
        });
        d = a.getRecomendedImageSizePixel();
    }

    private class MemoryType extends Enum
    {

        private static final MemoryType $VALUES[];
        public static final MemoryType HIGH;
        public static final MemoryType LOW;
        public static final MemoryType NORMAL;
        public static final MemoryType NORMAL_PLUS;
        public static final MemoryType XHIGH;
        public static final MemoryType XXHIGH;
        private final int maxAddPhotoCount;
        private final int maxCollageImage;
        private final int maxCollageSaveSize;
        private final int maxDrawingLayersCount;
        private final int maxImageSizeMegapixel;
        private final int memSize;
        private final int optimalImageSize;
        private final int recomendedImageSizeMegapixel;

        public static MemoryType getMemoryType(int i)
        {
            MemoryType amemorytype[] = values();
            MemoryType memorytype = amemorytype[0];
            int j = Math.abs(amemorytype[0].getSize() - i);
            int i1 = amemorytype.length;
            for (int k = 0; k < i1; k++)
            {
                MemoryType memorytype1 = amemorytype[k];
                int l = Math.abs(memorytype1.getSize() - i);
                if (l < j)
                {
                    memorytype = memorytype1;
                    j = l;
                }
            }

            return memorytype;
        }

        public static MemoryType valueOf(String s)
        {
            return (MemoryType)Enum.valueOf(com/picsart/studio/PicsartContext$MemoryType, s);
        }

        public static MemoryType[] values()
        {
            return (MemoryType[])$VALUES.clone();
        }

        public final int getAddPhotoMaxCount()
        {
            return maxAddPhotoCount;
        }

        public final int getCollageImageMaxSize()
        {
            return maxCollageImage;
        }

        public final int getMaxCollageSaveSize()
        {
            return maxCollageSaveSize;
        }

        public final int getMaxDrawingLayersCount()
        {
            return maxDrawingLayersCount;
        }

        public final int getMaxImageSizeMegapixel()
        {
            return maxImageSizeMegapixel;
        }

        public final int getMaxImageSizePixel()
        {
            return maxImageSizeMegapixel * 0x100000;
        }

        public final int getOptimalImageSize()
        {
            return optimalImageSize;
        }

        public final int getRecomendedImageSizeMegapixel()
        {
            return recomendedImageSizeMegapixel;
        }

        public final int getRecomendedImageSizePixel()
        {
            return recomendedImageSizeMegapixel * 0x100000;
        }

        public final int getSize()
        {
            return memSize;
        }

        static 
        {
            LOW = new MemoryType("LOW", 0, 24, 640, 1, 1, 450, 3, 5, 1024);
            NORMAL = new MemoryType("NORMAL", 1, 32, 1024, 1, 1, 640, 4, 5, 1024);
            NORMAL_PLUS = new MemoryType("NORMAL_PLUS", 2, 64, 1200, 1, 1, 640, 6, 5, 1200);
            HIGH = new MemoryType("HIGH", 3, 128, 2048, 3, 4, 1024, 10, 7, 2048);
            XHIGH = new MemoryType("XHIGH", 4, 256, 3200, 3, 6, 1024, 10, 10, 2048);
            XXHIGH = new MemoryType("XXHIGH", 5, 512, 3200, 5, 8, 2048, 10, 10, 2048);
            $VALUES = (new MemoryType[] {
                LOW, NORMAL, NORMAL_PLUS, HIGH, XHIGH, XXHIGH
            });
        }

        private MemoryType(String s, int i, int j, int k, int l, int i1, int j1, 
                int k1, int l1, int i2)
        {
            super(s, i);
            memSize = j;
            optimalImageSize = k;
            recomendedImageSizeMegapixel = l;
            maxImageSizeMegapixel = i1;
            maxCollageImage = j1;
            maxAddPhotoCount = k1;
            maxDrawingLayersCount = l1;
            maxCollageSaveSize = i2;
        }
    }


    private class ProcessorName extends Enum
    {

        private static final ProcessorName $VALUES[];
        public static final ProcessorName ARMV6;
        public static final ProcessorName ARMV7;
        public static final ProcessorName UNKNOWN;

        static ProcessorName fromString(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return UNKNOWN;
            }
            if (s.equalsIgnoreCase("6"))
            {
                return ARMV6;
            }
            if (s.equalsIgnoreCase("7"))
            {
                return ARMV7;
            } else
            {
                return UNKNOWN;
            }
        }

        public static ProcessorName valueOf(String s)
        {
            return (ProcessorName)Enum.valueOf(com/picsart/studio/PicsartContext$ProcessorName, s);
        }

        public static ProcessorName[] values()
        {
            return (ProcessorName[])$VALUES.clone();
        }

        static 
        {
            ARMV6 = new ProcessorName("ARMV6", 0);
            ARMV7 = new ProcessorName("ARMV7", 1);
            UNKNOWN = new ProcessorName("UNKNOWN", 2);
            $VALUES = (new ProcessorName[] {
                ARMV6, ARMV7, UNKNOWN
            });
        }

        private ProcessorName(String s, int i)
        {
            super(s, i);
        }
    }

}
