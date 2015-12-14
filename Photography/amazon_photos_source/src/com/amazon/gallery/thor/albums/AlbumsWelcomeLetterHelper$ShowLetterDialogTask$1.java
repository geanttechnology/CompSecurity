// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import android.content.SharedPreferences;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsWelcomeLetterHelper

class val.sharedPrefs
    implements android.content.erDialogTask._cls1
{

    final val.sharedPrefs this$1;
    final SharedPreferences val$sharedPrefs;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$sharedPrefs.edit().sharedPrefs("show_albums_welcome_letter", false).sharedPrefs();
        dialoginterface.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$sharedPrefs = SharedPreferences.this;
        super();
    }
}
