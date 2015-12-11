// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

// Referenced classes of package co.vine.android.views:
//            SquareMatch

public class SquareRelativeLayout extends RelativeLayout
    implements Runnable, SquareMatch.SquareMatchView
{

    private SquareMatch.SquareMatchRules mSpec;

    public SquareRelativeLayout(Context context)
    {
        super(context);
        mSpec = SquareMatch.SquareMatchRules.MATCH_LESS;
    }

    public SquareRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSpec = SquareMatch.SquareMatchRules.MATCH_LESS;
    }

    public SquareRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSpec = SquareMatch.SquareMatchRules.MATCH_LESS;
    }

    public Runnable getMatchLayoutRunnable()
    {
        return this;
    }

    public SquareMatch.SquareMatchRules getMatchSpec()
    {
        return mSpec;
    }

    public void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        SquareMatch.setupSquareMatchView(this);
    }

    public void run()
    {
        SquareMatch.setMatchingLayoutAction(this);
    }

    public void setMatchRule(SquareMatch.SquareMatchRules squarematchrules)
    {
        mSpec = squarematchrules;
    }

    public void setMeasuredDimension(int i)
    {
        setMeasuredDimension(i, i);
    }
}
