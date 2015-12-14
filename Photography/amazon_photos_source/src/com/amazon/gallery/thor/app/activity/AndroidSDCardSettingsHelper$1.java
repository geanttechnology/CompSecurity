// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import com.amazon.gallery.thor.removablestorage.StorageLocationPreference;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidSDCardSettingsHelper

class this._cls0
    implements android.preference.istener
{

    final AndroidSDCardSettingsHelper this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            preference = StorageLocationPreference.USE_REMOVABLE;
        } else
        {
            preference = StorageLocationPreference.USE_INTERNAL;
        }
        AndroidSDCardSettingsHelper.access$000(AndroidSDCardSettingsHelper.this).getSharedPreferences("galleryKindleSharedPrefs", 0).edit().ring("removable_storage_manager_storage_preference_key", preference.toString()).();
        return true;
    }

    ()
    {
        this$0 = AndroidSDCardSettingsHelper.this;
        super();
    }
}
