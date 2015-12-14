// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;


// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSUtil

public static class ratio
{
    public static final class Part extends Enum
    {

        private static final Part $VALUES[];
        public static final Part ONE;
        public static final Part TWO;

        public static Part valueOf(String s)
        {
            return (Part)Enum.valueOf(com/amazon/gallery/thor/cds/CDSUtil$TwoPartProgress$Part, s);
        }

        public static Part[] values()
        {
            return (Part[])$VALUES.clone();
        }

        static 
        {
            ONE = new Part("ONE", 0);
            TWO = new Part("TWO", 1);
            $VALUES = (new Part[] {
                ONE, TWO
            });
        }

        private Part(String s, int i)
        {
            super(s, i);
        }
    }


    private int currentProgress;
    private final double ratio;

    public int getProgress()
    {
        return currentProgress;
    }

    public void setCurrentProgress(int i)
    {
        currentProgress = i;
    }

    public void update(double d, Part part)
    {
        int i = 0;
        .amazon.gallery.thor.cds.CDSUtil.TwoPartProgress.Part[part.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 58
    //                   2 70;
           goto _L1 _L2 _L3
_L1:
        i -= currentProgress;
        if (i > 0)
        {
            currentProgress = currentProgress + i;
        }
        return;
_L2:
        i = (int)(ratio * d);
        continue; /* Loop/switch isn't completed */
_L3:
        i = (int)((double)(int)((1.0D - ratio) * d) + 100D * ratio);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public Part(double d)
    {
        currentProgress = 0;
        ratio = d;
    }
}
