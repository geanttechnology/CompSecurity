// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;


public class SquareMatch
{
    public static final class SquareMatchRules extends Enum
    {

        private static final SquareMatchRules $VALUES[];
        public static final SquareMatchRules MATCH_GREATER;
        public static final SquareMatchRules MATCH_HEIGHT;
        public static final SquareMatchRules MATCH_LESS;
        public static final SquareMatchRules MATCH_WIDTH;

        public static SquareMatchRules valueOf(String s)
        {
            return (SquareMatchRules)Enum.valueOf(co/vine/android/views/SquareMatch$SquareMatchRules, s);
        }

        public static SquareMatchRules[] values()
        {
            return (SquareMatchRules[])$VALUES.clone();
        }

        static 
        {
            MATCH_WIDTH = new SquareMatchRules("MATCH_WIDTH", 0);
            MATCH_HEIGHT = new SquareMatchRules("MATCH_HEIGHT", 1);
            MATCH_GREATER = new SquareMatchRules("MATCH_GREATER", 2);
            MATCH_LESS = new SquareMatchRules("MATCH_LESS", 3);
            $VALUES = (new SquareMatchRules[] {
                MATCH_WIDTH, MATCH_HEIGHT, MATCH_GREATER, MATCH_LESS
            });
        }

        private SquareMatchRules(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface SquareMatchView
    {

        public abstract android.view.ViewGroup.LayoutParams getLayoutParams();

        public abstract Runnable getMatchLayoutRunnable();

        public abstract SquareMatchRules getMatchSpec();

        public abstract int getMeasuredHeight();

        public abstract int getMeasuredWidth();

        public abstract boolean post(Runnable runnable);

        public abstract void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams);

        public abstract void setMatchRule(SquareMatchRules squarematchrules);

        public abstract void setMeasuredDimension(int i);
    }


    public SquareMatch()
    {
    }

    public static void setMatchingLayoutAction(SquareMatchView squarematchview)
    {
        android.view.ViewGroup.LayoutParams layoutparams = squarematchview.getLayoutParams();
        layoutparams.height = squarematchview.getMeasuredHeight();
        layoutparams.width = squarematchview.getMeasuredWidth();
        squarematchview.setLayoutParams(layoutparams);
    }

    public static void setupSquareMatchView(SquareMatchView squarematchview)
    {
        int i;
        int j;
        i = squarematchview.getMeasuredWidth();
        j = squarematchview.getMeasuredHeight();
        if (i == j) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules[];

            static 
            {
                $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules = new int[SquareMatchRules.values().length];
                try
                {
                    $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules[SquareMatchRules.MATCH_WIDTH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules[SquareMatchRules.MATCH_HEIGHT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules[SquareMatchRules.MATCH_GREATER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$views$SquareMatch$SquareMatchRules[SquareMatchRules.MATCH_LESS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.co.vine.android.views.SquareMatch.SquareMatchRules[squarematchview.getMatchSpec().ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 88
    //                   2 91
    //                   3 96;
           goto _L3 _L4 _L5 _L6
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        if (i > j)
        {
            i = j;
        }
_L8:
        squarematchview.setMeasuredDimension(i);
        squarematchview.post(squarematchview.getMatchLayoutRunnable());
_L2:
        return;
_L5:
        i = j;
        continue; /* Loop/switch isn't completed */
_L6:
        if (i <= j)
        {
            i = j;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
