// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.stericson.RootTools:
//            SanityCheckRootTools

private class <init> extends Handler
{

    public static final String ACTION = "action";
    public static final int ACTION_DISPLAY = 3;
    public static final int ACTION_HIDE = 2;
    public static final int ACTION_PDISPLAY = 4;
    public static final int ACTION_SHOW = 1;
    public static final String TEXT = "text";
    final SanityCheckRootTools this$0;

    public void handleMessage(Message message)
    {
        int i = message.getData().getInt("action");
        message = message.getData().getString("text");
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            SanityCheckRootTools.access$0(SanityCheckRootTools.this).show();
            SanityCheckRootTools.access$0(SanityCheckRootTools.this).setMessage("Running Root Library Tests...");
            return;

        case 2: // '\002'
            if (message != null)
            {
                print(message);
            }
            SanityCheckRootTools.access$0(SanityCheckRootTools.this).hide();
            return;

        case 3: // '\003'
            print(message);
            return;

        case 4: // '\004'
            SanityCheckRootTools.access$0(SanityCheckRootTools.this).setMessage(message);
            return;
        }
    }

    private ()
    {
        this$0 = SanityCheckRootTools.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
