// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ImageDef extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final ImageDef $VALUES[];
    public static final ImageDef FULL_RES;
    public static final ImageDef FULL_RES_COLOR;
    public static final ImageDef HALF_PROCESS_RES;
    public static final ImageDef NUM_IMAGEDEFS;
    public static final ImageDef PROCESS_RES;
    public static final ImageDef PROCESS_RES_COLOR;
    public static final ImageDef TRACKING_RES;
    private final int swigValue;

    private ImageDef(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ImageDef(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ImageDef(String s, int i, ImageDef imagedef)
    {
        Enum(s, i);
        swigValue = imagedef.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ImageDef swigToEnum(int i)
    {
        ImageDef aimagedef[] = (ImageDef[])com/a9/vs/mobile/library/impl/jni/ImageDef.getEnumConstants();
        if (i >= aimagedef.length || i < 0 || aimagedef[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ImageDef imagedef = aimagedef[i];
_L4:
        return imagedef;
_L2:
        int k = aimagedef.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                ImageDef imagedef1 = aimagedef[j];
                imagedef = imagedef1;
                if (imagedef1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ImageDef).append(" with value ").append(i).toString());
    }

    public static ImageDef valueOf(String s)
    {
        return (ImageDef)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ImageDef, s);
    }

    public static ImageDef[] values()
    {
        return (ImageDef[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        FULL_RES = new ImageDef("FULL_RES", 0, 0);
        FULL_RES_COLOR = new ImageDef("FULL_RES_COLOR", 1);
        PROCESS_RES = new ImageDef("PROCESS_RES", 2);
        PROCESS_RES_COLOR = new ImageDef("PROCESS_RES_COLOR", 3);
        HALF_PROCESS_RES = new ImageDef("HALF_PROCESS_RES", 4);
        TRACKING_RES = new ImageDef("TRACKING_RES", 5);
        NUM_IMAGEDEFS = new ImageDef("NUM_IMAGEDEFS", 6);
        $VALUES = (new ImageDef[] {
            FULL_RES, FULL_RES_COLOR, PROCESS_RES, PROCESS_RES_COLOR, HALF_PROCESS_RES, TRACKING_RES, NUM_IMAGEDEFS
        });
    }
}
