// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.gotv.crackle.Application;

public class ParentalPinDialog extends Dialog
{

    private String mCode;
    private EditText mDigitFour;
    private EditText mDigitOne;
    private EditText mDigitThree;
    private EditText mDigitTwo;
    private boolean mWasCancelled;
    private boolean okayButtonWasFocused;
    private TextWatcher watcher = new TextWatcher() {

        final ParentalPinDialog this$0;

        public void afterTextChanged(Editable editable)
        {
            mCode = (new StringBuilder()).append(mDigitOne.getEditableText().toString()).append(mDigitTwo.getEditableText().toString()).append(mDigitThree.getEditableText().toString()).append(mDigitFour.getEditableText().toString()).toString();
            if (mCode.length() == 4)
            {
                dismiss();
            } else
            {
                if (mDigitOne.hasFocus())
                {
                    mDigitTwo.requestFocus();
                    return;
                }
                if (mDigitTwo.hasFocus())
                {
                    mDigitThree.requestFocus();
                    return;
                }
                if (mDigitThree.hasFocus())
                {
                    mDigitFour.requestFocus();
                    return;
                }
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

            
            {
                this$0 = ParentalPinDialog.this;
                super();
            }
    };

    public ParentalPinDialog(Context context)
    {
        super(context);
        mWasCancelled = false;
        mCode = "";
        okayButtonWasFocused = false;
        setContentView(0x7f030066);
        init();
    }

    public ParentalPinDialog(Context context, int i)
    {
        super(context, i);
        mWasCancelled = false;
        mCode = "";
        okayButtonWasFocused = false;
        setContentView(0x7f030066);
        init();
    }

    private EditText focusedEditText()
    {
        if (mDigitOne.hasFocus())
        {
            return mDigitOne;
        }
        if (mDigitTwo.hasFocus())
        {
            return mDigitTwo;
        }
        if (mDigitThree.hasFocus())
        {
            return mDigitThree;
        }
        if (mDigitFour.hasFocus())
        {
            return mDigitFour;
        } else
        {
            return null;
        }
    }

    private void incrementDigitForFocusedEditText()
    {
        EditText edittext = focusedEditText();
        if (edittext == null)
        {
            return;
        }
        String s = edittext.getEditableText().toString();
        if (s.equals(""))
        {
            edittext.setText("0");
            return;
        }
        int i = Integer.parseInt(s);
        if (i == 9)
        {
            i = 0;
        } else
        {
            i++;
        }
        edittext.setText((new StringBuilder()).append("").append(i).toString());
    }

    private void setWasCancelled(boolean flag)
    {
        mWasCancelled = flag;
    }

    public void cancel()
    {
        setWasCancelled(true);
        super.cancel();
    }

    public void clearInput()
    {
        mDigitOne.removeTextChangedListener(watcher);
        mDigitTwo.removeTextChangedListener(watcher);
        mDigitThree.removeTextChangedListener(watcher);
        mDigitFour.removeTextChangedListener(watcher);
        mDigitOne.setText("");
        mDigitTwo.setText("");
        mDigitThree.setText("");
        mDigitFour.setText("");
        init();
    }

    public String getCode()
    {
        return mCode;
    }

    public void init()
    {
        mDigitOne = (EditText)findViewById(0x7f0a0155);
        mDigitOne.requestFocus();
        mDigitTwo = (EditText)findViewById(0x7f0a0156);
        mDigitThree = (EditText)findViewById(0x7f0a0157);
        mDigitFour = (EditText)findViewById(0x7f0a0158);
        if (Application.isFanhattan())
        {
            mDigitOne.setCursorVisible(false);
            mDigitTwo.setCursorVisible(false);
            mDigitThree.setCursorVisible(false);
            mDigitFour.setCursorVisible(false);
        }
        if (!Application.isFanhattan())
        {
            mDigitOne.addTextChangedListener(watcher);
            mDigitTwo.addTextChangedListener(watcher);
            mDigitThree.addTextChangedListener(watcher);
            mDigitFour.addTextChangedListener(watcher);
        }
        Button button = (Button)findViewById(0x7f0a0159);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ParentalPinDialog this$0;

            public void onClick(View view)
            {
                cancel();
            }

            
            {
                this$0 = ParentalPinDialog.this;
                super();
            }
        });
        Button button1 = (Button)findViewById(0x7f0a015a);
        button1.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ParentalPinDialog this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    okayButtonWasFocused = true;
                }
            }

            
            {
                this$0 = ParentalPinDialog.this;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final ParentalPinDialog this$0;

            public void onClick(View view)
            {
                mCode = (new StringBuilder()).append(mDigitOne.getEditableText().toString()).append(mDigitTwo.getEditableText().toString()).append(mDigitThree.getEditableText().toString()).append(mDigitFour.getEditableText().toString()).toString();
                if (mCode.length() == 4)
                {
                    dismiss();
                }
            }

            
            {
                this$0 = ParentalPinDialog.this;
                super();
            }
        });
        if (Application.isFanhattan())
        {
            button.setVisibility(8);
            button1.setVisibility(0);
        }
        getWindow().setSoftInputMode(5);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 19)
        {
            if (okayButtonWasFocused)
            {
                okayButtonWasFocused = false;
                return false;
            } else
            {
                incrementDigitForFocusedEditText();
                return true;
            }
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void show()
    {
        clearInput();
        setWasCancelled(false);
        super.show();
    }

    public boolean wasCancelled()
    {
        return mWasCancelled;
    }



/*
    static String access$002(ParentalPinDialog parentalpindialog, String s)
    {
        parentalpindialog.mCode = s;
        return s;
    }

*/






/*
    static boolean access$502(ParentalPinDialog parentalpindialog, boolean flag)
    {
        parentalpindialog.okayButtonWasFocused = flag;
        return flag;
    }

*/
}
