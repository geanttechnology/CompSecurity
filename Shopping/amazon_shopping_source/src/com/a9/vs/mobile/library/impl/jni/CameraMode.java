// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class CameraMode extends Enum
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


    private static final CameraMode $VALUES[];
    public static final CameraMode FRONT_FACING;
    public static final CameraMode REAR_FACING;
    private final int swigValue;

    private CameraMode(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private CameraMode(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private CameraMode(String s, int i, CameraMode cameramode)
    {
        Enum(s, i);
        swigValue = cameramode.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static CameraMode swigToEnum(int i)
    {
        CameraMode acameramode[] = (CameraMode[])com/a9/vs/mobile/library/impl/jni/CameraMode.getEnumConstants();
        if (i >= acameramode.length || i < 0 || acameramode[i].swigValue != i) goto _L2; else goto _L1
_L1:
        CameraMode cameramode = acameramode[i];
_L4:
        return cameramode;
_L2:
        int k = acameramode.length;
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
                CameraMode cameramode1 = acameramode[j];
                cameramode = cameramode1;
                if (cameramode1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/CameraMode).append(" with value ").append(i).toString());
    }

    public static CameraMode valueOf(String s)
    {
        return (CameraMode)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/CameraMode, s);
    }

    public static CameraMode[] values()
    {
        return (CameraMode[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        REAR_FACING = new CameraMode("REAR_FACING", 0);
        FRONT_FACING = new CameraMode("FRONT_FACING", 1);
        $VALUES = (new CameraMode[] {
            REAR_FACING, FRONT_FACING
        });
    }
}
