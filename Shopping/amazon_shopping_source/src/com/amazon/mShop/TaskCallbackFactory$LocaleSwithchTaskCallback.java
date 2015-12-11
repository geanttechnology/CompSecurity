// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.control.Cancellable;

// Referenced classes of package com.amazon.mShop:
//            TaskCallbackFactory, AmazonActivity, AmazonProgressDialog

public class <init> extends <init>
{

    final TaskCallbackFactory this$0;

    public void beginTask()
    {
        beginTaskProcessor(true);
    }

    public volatile void endTask()
    {
        super.beginTaskProcessor();
    }

    public void endTaskWithoutDismissProgDiag()
    {
        endTaskProcessor(false);
    }

    public AmazonProgressDialog getProgressDialog()
    {
        return TaskCallbackFactory.access$200(TaskCallbackFactory.this);
    }

    private (Cancellable cancellable, AmazonActivity amazonactivity, boolean flag, String s, AmazonProgressDialog amazonprogressdialog)
    {
        this$0 = TaskCallbackFactory.this;
        super(TaskCallbackFactory.this, cancellable, amazonactivity, flag, s, null);
        setProgressDialog(amazonprogressdialog);
    }

    setProgressDialog(Cancellable cancellable, AmazonActivity amazonactivity, boolean flag, String s, AmazonProgressDialog amazonprogressdialog, setProgressDialog setprogressdialog)
    {
        this(cancellable, amazonactivity, flag, s, amazonprogressdialog);
    }
}
