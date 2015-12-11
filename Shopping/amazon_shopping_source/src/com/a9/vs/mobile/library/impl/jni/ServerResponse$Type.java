// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            ServerResponse

public static final class swigValue extends Enum
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


    private static final JSON_VSEARCH $VALUES[];
    public static final JSON_VSEARCH JSON_IMGMATCH;
    public static final JSON_VSEARCH JSON_LOGO;
    public static final JSON_VSEARCH JSON_TERS;
    public static final JSON_VSEARCH JSON_TERS_TR;
    public static final JSON_VSEARCH JSON_TR;
    public static final JSON_VSEARCH JSON_VSEARCH;
    private final int swigValue;

    public static SwigNext swigToEnum(int i)
    {
        SwigNext aswignext[] = (SwigNext[])com/a9/vs/mobile/library/impl/jni/ServerResponse$Type.getEnumConstants();
        if (i >= aswignext.length || i < 0 || aswignext[i].swigValue != i) goto _L2; else goto _L1
_L1:
        SwigNext swignext = aswignext[i];
_L4:
        return swignext;
_L2:
        int k = aswignext.length;
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
                SwigNext swignext1 = aswignext[j];
                swignext = swignext1;
                if (swignext1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ServerResponse$Type).append(" with value ").append(i).toString());
    }

    public static swigValue valueOf(String s)
    {
        return (swigValue)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ServerResponse$Type, s);
    }

    public static swigValue[] values()
    {
        return (swigValue[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        JSON_TERS = new <init>("JSON_TERS", 0);
        JSON_TR = new <init>("JSON_TR", 1);
        JSON_TERS_TR = new <init>("JSON_TERS_TR", 2);
        JSON_IMGMATCH = new <init>("JSON_IMGMATCH", 3);
        JSON_LOGO = new <init>("JSON_LOGO", 4);
        JSON_VSEARCH = new <init>("JSON_VSEARCH", 5);
        $VALUES = (new .VALUES[] {
            JSON_TERS, JSON_TR, JSON_TERS_TR, JSON_IMGMATCH, JSON_LOGO, JSON_VSEARCH
        });
    }

    private SwigNext(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private swigValue(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private SwigNext.next(String s, int i, SwigNext.next next)
    {
        Enum(s, i);
        swigValue = next.swigValue;
        SwigNext.next = swigValue + 1;
    }
}
