// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package co.vine.android.widget:
//            TypingEditText

private class <init>
    implements TextWatcher
{

    final TypingEditText this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (TypingEditText.access$100(TypingEditText.this) != null)
        {
            TypingEditText.access$100(TypingEditText.this).removeMessages(1);
            TypingEditText.access$100(TypingEditText.this).sendMessageDelayed(TypingEditText.access$100(TypingEditText.this).obtainMessage(1), TypingEditText.access$200(TypingEditText.this));
        }
    }

    private ()
    {
        this$0 = TypingEditText.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
