// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.SharedPreferences;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSSyncHandler

class this._cls0
    implements android.content..OnSharedPreferenceChangeListener
{

    final CDSSyncHandler this$0;

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("coldBootStatus".equals(s) && sharedpreferences.getBoolean(s, false))
        {
            GLogger.i(CDSSyncHandler.access$000(), "Second stage sync complete... Cold boot has completed.", new Object[0]);
            CDSSyncHandler.access$500(CDSSyncHandler.this, 100D, ogress.Part.TWO);
            sharedpreferences.unregisterOnSharedPreferenceChangeListener(this);
            CDSSyncHandler.access$600(CDSSyncHandler.this);
        }
    }

    ogress.Part()
    {
        this$0 = CDSSyncHandler.this;
        super();
    }
}
