// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypewriterTextView extends TextView
{

    private String animatedText;
    private int animatedTextInIndex;
    private int animatedTextOutIndex;
    private Runnable characterAddRunnable = new Runnable() {

        final TypewriterTextView this$0;

        public void run()
        {
            setText(animatedText.subSequence(0, int i = ((access._cls200) (this)).access$200));
            if (animatedTextInIndex <= animatedText.length())
            {
                handler.postDelayed(characterAddRunnable, characterDelay);
            }
        }

            
            {
                this$0 = TypewriterTextView.this;
                super();
            }
    };
    private long characterDelay;
    private Runnable characterRemoveRunnable = new Runnable() ;
    private Handler handler;

    public TypewriterTextView(Context context)
    {
        super(context);
        characterDelay = 500L;
        handler = new Handler();
    }

    public TypewriterTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        characterDelay = 500L;
        handler = new Handler();
    }

    public void animateInText(String s)
    {
        handler.removeCallbacks(characterAddRunnable);
        handler.removeCallbacks(characterRemoveRunnable);
        animatedText = s;
        animatedTextInIndex = 0;
        handler.postDelayed(characterAddRunnable, characterDelay);
    }

    public void animateOutText(String s)
    {
        handler.removeCallbacks(characterAddRunnable);
        handler.removeCallbacks(characterRemoveRunnable);
        animatedText = s;
        animatedTextOutIndex = s.length();
        setText(s);
        handler.postDelayed(characterRemoveRunnable, characterDelay);
    }

    public void setCharacterDelay(long l)
    {
        characterDelay = l;
    }



/*
    static int access$008(TypewriterTextView typewritertextview)
    {
        int i = typewritertextview.animatedTextInIndex;
        typewritertextview.animatedTextInIndex = i + 1;
        return i;
    }

*/







/*
    static int access$510(TypewriterTextView typewritertextview)
    {
        int i = typewritertextview.animatedTextOutIndex;
        typewritertextview.animatedTextOutIndex = i - 1;
        return i;
    }

*/

}
