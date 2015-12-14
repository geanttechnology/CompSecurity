// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

// Referenced classes of package com.rockerhieu.emojicon:
//            EmojiconHandler

public class EmojiconEditText extends EditText
{

    private int mEmojiconSize;
    private float mLinespacing;
    private boolean mSystemSupportEmoji;

    public EmojiconEditText(Context context)
    {
        super(context);
        mSystemSupportEmoji = false;
        mEmojiconSize = (int)getTextSize();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            mSystemSupportEmoji = true;
        }
    }

    public EmojiconEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSystemSupportEmoji = false;
        init(attributeset);
    }

    public EmojiconEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSystemSupportEmoji = false;
        init(attributeset);
    }

    private void init(AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            mSystemSupportEmoji = true;
        }
        if (attributeset == null)
        {
            mEmojiconSize = (int)getTextSize();
        } else
        {
            attributeset = getContext().obtainStyledAttributes(attributeset, R.styleable.Emojicon);
            mEmojiconSize = (int)attributeset.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize());
            attributeset.recycle();
        }
        if (mLinespacing != 0.0F)
        {
            setLineSpacing(mLinespacing, 1.0F);
        }
        if (!mSystemSupportEmoji)
        {
            setText(getText());
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (!mSystemSupportEmoji)
        {
            EmojiconHandler.addEmojis(getContext(), getText(), mEmojiconSize, mLinespacing);
            return;
        } else
        {
            super.onTextChanged(charsequence, i, j, k);
            return;
        }
    }

    public void setEmojiconSize(int i)
    {
        mEmojiconSize = i;
    }
}
