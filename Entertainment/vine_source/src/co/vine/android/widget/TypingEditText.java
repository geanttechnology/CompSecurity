// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import co.vine.android.views.SdkEditText;

public class TypingEditText extends SdkEditText
{
    private class TypingHandler extends Handler
    {

        public static final int TYPING = 1;
        final TypingEditText this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            if (mListener != null)
            {
                mListener.onTypingTimeout(TypingEditText.this);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public TypingHandler()
        {
            this$0 = TypingEditText.this;
            super();
        }
    }

    public static interface TypingListener
    {

        public abstract void onTypingTimeout(View view);
    }

    private class TypingTextWatcher
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
            if (mHandler != null)
            {
                mHandler.removeMessages(1);
                mHandler.sendMessageDelayed(mHandler.obtainMessage(1), mTimeout);
            }
        }

        private TypingTextWatcher()
        {
            this$0 = TypingEditText.this;
            super();
        }

    }


    public static final int DEFAULT_TIMEOUT = 500;
    private Handler mHandler;
    private TypingListener mListener;
    private long mTimeout;

    public TypingEditText(Context context)
    {
        super(context);
        setup();
    }

    public TypingEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setup();
    }

    public TypingEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setup();
    }

    private void setup()
    {
        mTimeout = 500L;
        mHandler = new TypingHandler();
        addTextChangedListener(new TypingTextWatcher());
    }

    public void setTimeout(long l)
    {
        mTimeout = l;
    }

    public void setTypingListener(TypingListener typinglistener)
    {
        mListener = typinglistener;
    }



}
