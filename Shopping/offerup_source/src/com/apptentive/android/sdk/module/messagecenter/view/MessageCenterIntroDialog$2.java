// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.apptentive.android.sdk.module.engagement.interaction.view.common.ApptentiveDialogButton;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter.view:
//            MessageCenterIntroDialog

class ialogButton
    implements TextWatcher
{

    final MessageCenterIntroDialog this$0;
    final ApptentiveDialogButton val$submitButton;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        MessageCenterIntroDialog.access$002(MessageCenterIntroDialog.this, charsequence);
        MessageCenterIntroDialog.access$100(MessageCenterIntroDialog.this, val$submitButton);
    }

    ialogButton()
    {
        this$0 = final_messagecenterintrodialog;
        val$submitButton = ApptentiveDialogButton.this;
        super();
    }
}
