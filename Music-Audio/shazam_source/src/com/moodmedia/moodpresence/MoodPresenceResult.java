// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


// Referenced classes of package com.moodmedia.moodpresence:
//            g

public class MoodPresenceResult
{
    public static final class Type extends Enum
    {

        public static final Type SONIC;
        public static final Type ULTRASONIC;
        private static final Type b[];
        private int a;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/moodmedia/moodpresence/MoodPresenceResult$Type, s);
        }

        public static Type[] values()
        {
            Type atype[] = b;
            int i = atype.length;
            Type atype1[] = new Type[i];
            System.arraycopy(atype, 0, atype1, 0, i);
            return atype1;
        }

        public final int getValue()
        {
            return a;
        }

        static 
        {
            SONIC = new Type("SONIC", 0, 0);
            ULTRASONIC = new Type("ULTRASONIC", 1, 1);
            b = (new Type[] {
                SONIC, ULTRASONIC
            });
        }

        private Type(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }


    private static final double e[][] = {
        {
            5.9604644775390625E-08D, 2.8610229492186831E-06D, 6.7234039306641248E-05D, 0.0010309219360351458D, 0.011597871780395534D
        }, {
            1.1641532182693481E-10D, 7.3341652750967163E-09D, 2.2735912352798956E-07D, 4.6229688450690671E-06D, 6.934453267603927E-05D, 0.00081826548557724528D, 0.0079098996939135028D
        }
    };
    private long a;
    private Type b;
    private int c;
    private int d;

    public MoodPresenceResult(long l, Type type, int i, int j)
    {
        b = type;
        a = l;
        c = i;
        d = j;
    }

    MoodPresenceResult(g g1)
    {
        if (g1.b() == g.a.a)
        {
            b = Type.SONIC;
        } else
        {
            b = Type.ULTRASONIC;
        }
        a = g1.a();
        c = g1.c();
        d = g1.d();
    }

    public boolean equals(MoodPresenceResult moodpresenceresult)
    {
        while (moodpresenceresult == null || moodpresenceresult.getType().getValue() != b.getValue() || moodpresenceresult.getPresenceId() != a) 
        {
            return false;
        }
        return true;
    }

    public int getErrors()
    {
        return c;
    }

    public double getFalsePositiveProbability()
    {
        if (a == -1L)
        {
            return -1D;
        } else
        {
            return e[b.getValue()][c];
        }
    }

    public int getHits()
    {
        return d;
    }

    public long getPresenceId()
    {
        return a;
    }

    public Type getType()
    {
        return b;
    }

}
