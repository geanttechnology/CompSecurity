// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsWelcomeLetterHelper, AlbumsMetricsHelper

class val.sharedPrefs
    implements android.content.tener
{

    final AlbumsWelcomeLetterHelper this$0;
    final SharedPreferences val$sharedPrefs;

    public void onDismiss(DialogInterface dialoginterface)
    {
        dialoginterface = vent.PhotoAlbumsLetterClose;
        AlbumsWelcomeLetterHelper.access$000(AlbumsWelcomeLetterHelper.this).trackEvent(dialoginterface, AlbumsMetricsHelper.createMetricsExtra(dialoginterface.name(), null, null));
        val$sharedPrefs.edit().Boolean("show_albums_welcome_letter", false).ly();
    }

    vent()
    {
        this$0 = final_albumswelcomeletterhelper;
        val$sharedPrefs = SharedPreferences.this;
        super();
    }
}
