// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

// Referenced classes of package com.amazon.now.home:
//            WelcomeScreen

class this._cls0
    implements TextWatcher
{

    final WelcomeScreen this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.toString().trim().length() < WelcomeScreen.access$500(WelcomeScreen.this) || !charsequence.toString().trim().matches(WelcomeScreen.access$600(WelcomeScreen.this))) goto _L2; else goto _L1
_L1:
        if (!WelcomeScreen.access$700(WelcomeScreen.this)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        WelcomeScreen.access$702(WelcomeScreen.this, true);
        WelcomeScreen.access$800(WelcomeScreen.this).setOnClickListener(new android.view.View.OnClickListener() {

            final WelcomeScreen._cls5 this$1;

            public void onClick(View view)
            {
                WelcomeScreen.access$300(this$0);
            }

            
            {
                this$1 = WelcomeScreen._cls5.this;
                super();
            }
        });
        charsequence = AnimationUtils.loadAnimation(WelcomeScreen.access$800(WelcomeScreen.this).getContext(), 0x7f040007);
        WelcomeScreen.access$800(WelcomeScreen.this).setAlpha(1.0F);
        WelcomeScreen.access$800(WelcomeScreen.this).startAnimation(charsequence);
        return;
_L2:
        if (WelcomeScreen.access$700(WelcomeScreen.this))
        {
            WelcomeScreen.access$702(WelcomeScreen.this, false);
            WelcomeScreen.access$800(WelcomeScreen.this).setOnClickListener(null);
            charsequence = AnimationUtils.loadAnimation(WelcomeScreen.access$800(WelcomeScreen.this).getContext(), 0x7f040008);
            WelcomeScreen.access$800(WelcomeScreen.this).setAlpha(1.0F);
            WelcomeScreen.access$800(WelcomeScreen.this).startAnimation(charsequence);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    _cls1.this._cls1()
    {
        this$0 = WelcomeScreen.this;
        super();
    }
}
