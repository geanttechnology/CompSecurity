// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.SharedPreferences;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarChangeRegister

class atarChangeListener
    implements android.content.redPreferenceChangeListener
{

    final AvatarChangeRegister this$0;
    final atarChangeListener val$avatarChangeListener;

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (AvatarChangeRegister.access$000(AvatarChangeRegister.this, 0x7f06002a).equals(s))
        {
            val$avatarChangeListener.onChanged();
        }
    }

    atarChangeListener()
    {
        this$0 = final_avatarchangeregister;
        val$avatarChangeListener = atarChangeListener.this;
        super();
    }
}
