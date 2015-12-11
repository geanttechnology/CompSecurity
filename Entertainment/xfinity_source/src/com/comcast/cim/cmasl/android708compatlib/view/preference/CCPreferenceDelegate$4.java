// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android708compatlib.view.preference;

import android.preference.ListPreference;
import android.preference.Preference;

// Referenced classes of package com.comcast.cim.cmasl.android708compatlib.view.preference:
//            CCPreferenceDelegate, CCPreviewPreference

class val.preview
    implements android.preference.ChangeListener
{

    final CCPreferenceDelegate this$0;
    final referenceStore val$ccPrefStore;
    final CCPreviewPreference val$preview;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (String)obj;
        int i = Integer.valueOf(((String) (obj))).intValue();
        val$ccPrefStore.setCCEdgeType(i);
        ((ListPreference)preference).setValue(((String) (obj)));
        preference.setSummary(((ListPreference)preference).getEntry());
        val$preview.updatePreviewText();
        return false;
    }

    referenceStore()
    {
        this$0 = final_ccpreferencedelegate;
        val$ccPrefStore = referencestore;
        val$preview = CCPreviewPreference.this;
        super();
    }
}
