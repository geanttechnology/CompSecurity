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
        SettingsFragment.access$402(SettingsFragment.this, charsequence.toString());
        if (SettingsFragment.access$500(SettingsFragment.this) != null && !SettingsFragment.access$600(SettingsFragment.this).equals(SettingsFragment.access$400(SettingsFragment.this)))
        {
            SettingsFragment.access$702(SettingsFragment.this, false);
            return;
        } else
        {
            SettingsFragment.access$702(SettingsFragment.this, SettingsFragment.access$800(SettingsFragment.this));
            return;
        }
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
