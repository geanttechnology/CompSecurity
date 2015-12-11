// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package com.target.ui.view:
//            TargetEditText

public class BackSpaceDetectorEditText extends TargetEditText
{
    public static interface a
    {

        public abstract void a(BackSpaceDetectorEditText backspacedetectoredittext);
    }

    private class b extends InputConnectionWrapper
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

        public b(InputConnection inputconnection, boolean flag)
        {
            this$0 = BackSpaceDetectorEditText.this;
            super(inputconnection, flag);
        }
    }


    private static final int DELETE_THRESHOLD_MAX_LENGTH = 1;
    private static final int DELETE_THRESHOLD_MIN_LENGTH = 0;
    private a mBackSpacePressListener;

    public BackSpaceDetectorEditText(Context context)
    {
        super(context);
    }

    public BackSpaceDetectorEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BackSpaceDetectorEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(BackSpaceDetectorEditText backspacedetectoredittext)
    {
        return backspacedetectoredittext.mBackSpacePressListener;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        editorinfo = new b(super.onCreateInputConnection(editorinfo), true);
        editorinfo.a(this);
        return editorinfo;
    }

    public void setBackSpacePressListener(a a1)
    {
        mBackSpacePressListener = a1;
    }
}
