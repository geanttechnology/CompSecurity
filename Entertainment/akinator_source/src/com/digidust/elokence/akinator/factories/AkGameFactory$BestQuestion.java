// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.factories;


// Referenced classes of package com.digidust.elokence.akinator.factories:
//            AkGameFactory

public class mQuestion
    implements Comparable
{

    public float mDiffTrouvitude;
    public int mIndice;
    public String mQuestion;
    final AkGameFactory this$0;

    public int compareTo(mQuestion mquestion)
    {
        return Integer.valueOf(mIndice).compareTo(Integer.valueOf(mquestion.mIndice));
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public void copy(compareTo compareto)
    {
        mIndice = compareto.mIndice;
        mDiffTrouvitude = compareto.mDiffTrouvitude;
        mQuestion = compareto.mQuestion;
    }

    public I()
    {
        this$0 = AkGameFactory.this;
        super();
        mIndice = 0;
        mDiffTrouvitude = 0.0F;
    }

    public mDiffTrouvitude(int i, float f, String s)
    {
        this$0 = AkGameFactory.this;
        super();
        mIndice = 0;
        mDiffTrouvitude = 0.0F;
        mIndice = i;
        mDiffTrouvitude = f;
        mQuestion = s;
    }
}
