// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a
    implements TextWatcher
{

    final MessageSettingActivity a;

    public void afterTextChanged(Editable editable)
    {
        MessageSettingActivity.b(a);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    _cls9(MessageSettingActivity messagesettingactivity)
    {
        a = messagesettingactivity;
        super();
    }
}
