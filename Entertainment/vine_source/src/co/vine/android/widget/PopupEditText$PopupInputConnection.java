// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import co.vine.android.api.VineEntity;

// Referenced classes of package co.vine.android.widget:
//            PopupEditText

private class this._cls0 extends InputConnectionWrapper
{

    final PopupEditText this$0;

    public boolean deleteSurroundingText(int i, int j)
    {
        if (PopupEditText.access$100(PopupEditText.this) != null && i > 0 && j == 0)
        {
            return sendKeyEvent(new KeyEvent(0, 67));
        } else
        {
            return super.deleteSurroundingText(i, j);
        }
    }

    public boolean sendKeyEvent(KeyEvent keyevent)
    {
        if (PopupEditText.access$100(PopupEditText.this) != null && keyevent.getAction() == 0 && keyevent.getKeyCode() == 67)
        {
            clearSelectedEntity(PopupEditText.access$100(PopupEditText.this).start, true);
            return true;
        } else
        {
            return super.sendKeyEvent(keyevent);
        }
    }

    public (InputConnection inputconnection, boolean flag)
    {
        this$0 = PopupEditText.this;
        super(inputconnection, flag);
    }
}
