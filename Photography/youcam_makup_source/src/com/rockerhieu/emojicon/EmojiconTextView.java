// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rockerhieu.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package com.rockerhieu.emojicon:
//            EmojiconHandler

public class EmojiconTextView extends TextView
{

    private int mEmojiconSize;
    private float mLinespacing;
    private boolean mSystemSupportEmoji;

    public EmojiconTextView(Context context)
    {
        super(context);
        mLinespacing = 0.0F;
        mSystemSupportEmoji = false;
        init(null);
    }

    public EmojiconTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mLinespacing = 0.0F;
        mSystemSupportEmoji = false;
        init(attributeset);
    }

    public EmojiconTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mLinespacing = 0.0F;
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
            mLinespacing = attributeset.getDimension(R.styleable.Emojicon_emojiLineSpacingExtra, 0.0F);
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

    public void setEmojiconSize(int i)
    {
        mEmojiconSize = i;
    }

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        if (!mSystemSupportEmoji)
        {
            if (charsequence != null)
            {
                charsequence = new SpannableStringBuilder(charsequence);
                EmojiconHandler.addEmojis(getContext(), charsequence, mEmojiconSize, mLinespacing);
                super.setText(charsequence, buffertype);
                return;
            } else
            {
                super.setText(charsequence, buffertype);
                return;
            }
        } else
        {
            super.setText(charsequence, buffertype);
            return;
        }
    }
}
