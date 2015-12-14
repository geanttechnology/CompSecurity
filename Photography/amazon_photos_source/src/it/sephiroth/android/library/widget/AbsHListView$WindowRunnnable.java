// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;


// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView

private class <init>
{

    private int mOriginalAttachCount;
    final AbsHListView this$0;

    public void rememberWindowAttachCount()
    {
        mOriginalAttachCount = AbsHListView.access$200(AbsHListView.this);
    }

    public boolean sameWindow()
    {
        return hasWindowFocus() && AbsHListView.access$300(AbsHListView.this) == mOriginalAttachCount;
    }

    private ()
    {
        this$0 = AbsHListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
