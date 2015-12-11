// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.client.AppSessionListener;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            ResetPasswordActivity

private class <init> extends AppSessionListener
{

    final ResetPasswordActivity this$0;

    public void onResetPasswordComplete(String s, int i, String s1)
    {
        dismissDialog();
        i;
        JVM INSTR lookupswitch 2: default 36
    //                   200: 69
    //                   404: 75;
           goto _L1 _L2 _L3
_L1:
        i = 0x7f0e016f;
_L5:
        s = PromptDialogSupportFragment.newInstance(1);
        s.setMessage(i);
        s.setPositiveButton(0x7f0e0163);
        s.show(getSupportFragmentManager());
        return;
_L2:
        i = 0x7f0e016e;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f0e0170;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private A()
    {
        this$0 = ResetPasswordActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
