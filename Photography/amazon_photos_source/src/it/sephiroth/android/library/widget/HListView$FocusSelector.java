// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;


// Referenced classes of package it.sephiroth.android.library.widget:
//            HListView

private class <init>
    implements Runnable
{

    private int mPosition;
    private int mPositionLeft;
    final HListView this$0;

    public void run()
    {
        setSelectionFromLeft(mPosition, mPositionLeft);
    }

    public mPositionLeft setup(int i, int j)
    {
        mPosition = i;
        mPositionLeft = j;
        return this;
    }

    private A()
    {
        this$0 = HListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
