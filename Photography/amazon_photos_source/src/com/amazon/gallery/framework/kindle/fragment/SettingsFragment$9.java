// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.preference.Preference;
import com.amazon.gallery.thor.GalleryWebViewHelper;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceClickListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        GalleryWebViewHelper.startManageStorage(getActivity());
        return true;
    }

    ()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
