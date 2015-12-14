// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;

import com.pf.common.a;
import java.io.PrintStream;

// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            e, d

public class UIAthenaJNI
{

    public static final native boolean CUIAthena_addStrokePoint(long l, e e, float f, float f1);

    public static final native boolean CUIAthena_beginStroke(long l, e e, int i, int j);

    public static final native boolean CUIAthena_clear(long l, e e);

    public static final native boolean CUIAthena_endStroke(long l, e e);

    public static final native Object CUIAthena_getMask(long l, e e, boolean flag);

    public static final native boolean CUIAthena_initialize(long l, e e, long l1, d d);

    public static final native boolean CUIAthena_invert(long l, e e);

    public static final native boolean CUIAthena_uninitialize(long l, e e);

    public static final native void delete_CUIAthena(long l);

    public static final native long new_CUIAthena(String s);

    static 
    {
        try
        {
            a.b();
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            System.err.println((new StringBuilder()).append("JNI error: ").append(unsatisfiedlinkerror).toString());
            System.exit(1);
        }
    }
}
