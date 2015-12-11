// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            RecipientPickerActivity

class this._cls0
    implements android.view.animation.r
{

    final RecipientPickerActivity this$0;

    public void onAnimationEnd(Animation animation)
    {
        RecipientPickerActivity.access$100(RecipientPickerActivity.this).setVisibility(8);
        RecipientPickerActivity.access$100(RecipientPickerActivity.this).setClickable(false);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    Listener()
    {
        this$0 = RecipientPickerActivity.this;
        super();
    }
}
