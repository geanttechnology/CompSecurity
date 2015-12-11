// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.indexing;


// Referenced classes of package io.branch.indexing:
//            BranchUniversalObject

public static final class A extends Enum
{

    private static final PRIVATE $VALUES[];
    public static final PRIVATE PRIVATE;
    public static final PRIVATE PUBLIC;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(io/branch/indexing/BranchUniversalObject$CONTENT_INDEX_MODE, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        PUBLIC = new <init>("PUBLIC", 0);
        PRIVATE = new <init>("PRIVATE", 1);
        $VALUES = (new .VALUES[] {
            PUBLIC, PRIVATE
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
