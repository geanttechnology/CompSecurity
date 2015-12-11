// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            RecipientPickerActivity

class this._cls0
    implements android.view.._cls2
{

    final RecipientPickerActivity this$0;

    public void onClick(View view)
    {
        view = AnimationUtils.loadAnimation(RecipientPickerActivity.this, 0x7f04000f);
        view.setAnimationListener(RecipientPickerActivity.access$000(RecipientPickerActivity.this));
        RecipientPickerActivity.access$100(RecipientPickerActivity.this).startAnimation(view);
    }

    ()
    {
        this$0 = RecipientPickerActivity.this;
        super();
    }
}
