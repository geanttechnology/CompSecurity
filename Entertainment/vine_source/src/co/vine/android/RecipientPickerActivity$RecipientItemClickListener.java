// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import co.vine.android.api.VineRecipient;

// Referenced classes of package co.vine.android:
//            RecipientPickerActivity

public class position
    implements android.view.er
{

    private final int position;
    private final VineRecipient recipient;
    final RecipientPickerActivity this$0;

    public void onClick(View view)
    {
        onItemClick(recipient);
    }

    public (VineRecipient vinerecipient, int i)
    {
        this$0 = RecipientPickerActivity.this;
        super();
        recipient = vinerecipient;
        position = i;
    }
}
