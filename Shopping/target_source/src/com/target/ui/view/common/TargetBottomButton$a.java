// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;


// Referenced classes of package com.target.ui.view.common:
//            TargetBottomButton

private class mRightText
{

    private final String mCentreText;
    private boolean mHighlightCentre;
    private boolean mHighlightLeft;
    private boolean mHighlightRight;
    private final String mLeftText;
    private final String mRightText;
    final TargetBottomButton this$0;

    public String a()
    {
        return mLeftText;
    }

    public void a(boolean flag)
    {
        mHighlightLeft = flag;
    }

    public String b()
    {
        return mCentreText;
    }

    public void b(boolean flag)
    {
        mHighlightCentre = flag;
    }

    public String c()
    {
        return mRightText;
    }

    public void c(boolean flag)
    {
        mHighlightRight = flag;
    }

    public boolean d()
    {
        return mHighlightLeft;
    }

    public boolean e()
    {
        return mHighlightCentre;
    }

    public boolean f()
    {
        return mHighlightRight;
    }

    (String s, String s1, String s2)
    {
        this$0 = TargetBottomButton.this;
        super();
        mLeftText = s;
        mCentreText = s1;
        mRightText = s2;
    }
}
