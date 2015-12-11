// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package com.target.ui.view:
//            BackSpaceDetectorEditText

private class  extends InputConnectionWrapper
{

    private BackSpaceDetectorEditText customTargetEditText;
    final BackSpaceDetectorEditText this$0;

    public void a(BackSpaceDetectorEditText backspacedetectoredittext)
    {
        customTargetEditText = backspacedetectoredittext;
    }

    public boolean deleteSurroundingText(int i, int j)
    {
        if (i == 1 && j == 0)
        {
            return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
        } else
        {
            return super.deleteSurroundingText(i, j);
        }
    }

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        boolean flag = super.sendKeyEvent(keyevent);
        if (keyevent.getAction() == 0 && keyevent.getKeyCode() == 67)
        {
            BackSpaceDetectorEditText.a(BackSpaceDetectorEditText.this).a(customTargetEditText);
        }
        return Boolean.valueOf(flag).booleanValue();
    }

    public (InputConnection inputconnection, boolean flag)
    {
        this$0 = BackSpaceDetectorEditText.this;
        super(inputconnection, flag);
    }
}
