// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.widget.ImageView;

// Referenced classes of package co.vine.android:
//            RecipientPickerActivity

class val.gray extends ImageView
{

    final RecipientPickerActivity this$0;
    final int val$gray;

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        int i;
        if (flag)
        {
            i = RecipientPickerActivity.access$200(RecipientPickerActivity.this);
        } else
        {
            i = val$gray;
        }
        setColorFilter(new PorterDuffColorFilter(i, android.graphics.t>));
    }

    (int i)
    {
        this$0 = final_recipientpickeractivity;
        val$gray = i;
        super(Context.this);
    }
}
