// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package co.vine.android:
//            SettingsFragment

class this._cls0
    implements android.widget.electedListener
{

    final SettingsFragment this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        SettingsFragment.access$1202(SettingsFragment.this, SettingsFragment.access$1300(SettingsFragment.this).getEditionCode(i));
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    itionsSpinnerAdapter()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
