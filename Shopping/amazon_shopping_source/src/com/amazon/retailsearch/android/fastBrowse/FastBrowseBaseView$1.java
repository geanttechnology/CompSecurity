// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;


// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseBaseView

class this._cls0
    implements r.OnReturnListener
{

    final FastBrowseBaseView this$0;

    public void onReturn(String s)
    {
        if (FastBrowseBaseView.access$000(FastBrowseBaseView.this) != null)
        {
            FastBrowseBaseView.access$000(FastBrowseBaseView.this).onReturn(s);
        }
    }

    public void onReturnAIV()
    {
        if (FastBrowseBaseView.access$000(FastBrowseBaseView.this) != null)
        {
            FastBrowseBaseView.access$000(FastBrowseBaseView.this).onReturnAIV();
        }
    }

    public void onReturnAPP()
    {
        if (FastBrowseBaseView.access$000(FastBrowseBaseView.this) != null)
        {
            FastBrowseBaseView.access$000(FastBrowseBaseView.this).onReturnAPP();
        }
    }

    BackUrlListener()
    {
        this$0 = FastBrowseBaseView.this;
        super();
    }
}
