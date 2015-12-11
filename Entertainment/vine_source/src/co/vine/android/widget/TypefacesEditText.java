// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import co.vine.android.views.SdkEditText;

// Referenced classes of package co.vine.android.widget:
//            Typefaces

public class TypefacesEditText extends SdkEditText
{
    public static interface KeyboardListener
    {

        public abstract void onKeyboardDismissed();

        public abstract boolean sendKeyEvent(KeyEvent keyevent);
    }

    private class TypeFacesInputConnection extends InputConnectionWrapper
    {

        final TypefacesEditText this$0;

        public boolean sendKeyEvent(KeyEvent keyevent)
        {
            return mKeyboardListener != null && mKeyboardListener.sendKeyEvent(keyevent) || super.sendKeyEvent(keyevent);
        }

        public TypeFacesInputConnection(InputConnection inputconnection, boolean flag)
        {
            this$0 = TypefacesEditText.this;
            super(inputconnection, flag);
        }
    }


    private KeyboardListener mKeyboardListener;
    private int mWeight;

    public TypefacesEditText(Context context)
    {
        super(context);
        mKeyboardListener = null;
    }

    public TypefacesEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mKeyboardListener = null;
        init(context, attributeset);
    }

    public TypefacesEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mKeyboardListener = null;
        init(context, attributeset);
    }

    public void init(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.VineTextView, 0x7f010047, 0);
        int i = attributeset.getInt(1, 0);
        mWeight = attributeset.getInt(0, 2);
        attributeset.recycle();
        setTypeface(Typefaces.get(context).getContentTypeface(i, mWeight), i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        return new TypeFacesInputConnection(super.onCreateInputConnection(editorinfo), true);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4 && mKeyboardListener != null)
        {
            mKeyboardListener.onKeyboardDismissed();
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void setKeyboardListener(KeyboardListener keyboardlistener)
    {
        mKeyboardListener = keyboardlistener;
    }

    public void setTypeface(Typeface typeface, int i)
    {
        super.setTypeface(Typefaces.get(getContext()).getContentTypeface(i, mWeight));
    }

}
