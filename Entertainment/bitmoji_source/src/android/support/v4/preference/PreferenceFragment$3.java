// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.preference;

import android.preference.Preference;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

// Referenced classes of package android.support.v4.preference:
//            PreferenceFragment

class this._cls0
    implements android.view.erenceFragment._cls3
{

    final PreferenceFragment this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (PreferenceFragment.access$100(PreferenceFragment.this).getSelectedItem() instanceof Preference)
        {
            PreferenceFragment.access$100(PreferenceFragment.this).getSelectedView();
        }
        return false;
    }

    ()
    {
        this$0 = PreferenceFragment.this;
        super();
    }
}
