// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;


// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander

private final class <init>
{

    private int mMinProgress;
    private float mProgressRange;
    final mProgressRange this$1;

    public final void publishProgress(float f)
    {
        int i = Math.round(mProgressRange * f);
        if (i >= 0 && mMinProgress + i <= 100)
        {
            mMinProgress(this._cls1.this, new Integer[] {
                Integer.valueOf(mMinProgress + i), Integer.valueOf(100)
            });
        }
    }

    public final void setPart(int i, int j)
    {
        mMinProgress = i;
        mProgressRange = j - i;
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
