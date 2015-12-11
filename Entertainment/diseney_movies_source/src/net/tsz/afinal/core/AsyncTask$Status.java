// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;


// Referenced classes of package net.tsz.afinal.core:
//            AsyncTask

public static final class  extends Enum
{

    private static final FINISHED ENUM$VALUES[];
    public static final FINISHED FINISHED;
    public static final FINISHED PENDING;
    public static final FINISHED RUNNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(net/tsz/afinal/core/AsyncTask$Status, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        PENDING = new <init>("PENDING", 0);
        RUNNING = new <init>("RUNNING", 1);
        FINISHED = new <init>("FINISHED", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            PENDING, RUNNING, FINISHED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
