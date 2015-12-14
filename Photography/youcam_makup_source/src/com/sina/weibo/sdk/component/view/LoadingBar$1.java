// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;


// Referenced classes of package com.sina.weibo.sdk.component.view:
//            LoadingBar

class this._cls0
    implements Runnable
{

    final LoadingBar this$0;

    public void run()
    {
        LoadingBar loadingbar = LoadingBar.this;
        LoadingBar.access$1(loadingbar, LoadingBar.access$0(loadingbar) + 1);
        drawProgress(LoadingBar.access$0(LoadingBar.this));
    }

    ()
    {
        this$0 = LoadingBar.this;
        super();
    }
}
