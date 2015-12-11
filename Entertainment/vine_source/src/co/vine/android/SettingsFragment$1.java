// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package co.vine.android:
//            SettingsFragment

class this._cls0
    implements TextWatcher
{

    final SettingsFragment this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        SettingsFragment.access$102(SettingsFragment.this, charsequence.toString());
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
