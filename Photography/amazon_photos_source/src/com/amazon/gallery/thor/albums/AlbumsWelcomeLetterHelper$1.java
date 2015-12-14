// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import android.content.SharedPreferences;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumsWelcomeLetterHelper

class val.sharedPrefs
    implements android.content.ener
{

    final AlbumsWelcomeLetterHelper this$0;
    final SharedPreferences val$sharedPrefs;

    public void onCancel(DialogInterface dialoginterface)
    {
        val$sharedPrefs.edit().Boolean("show_albums_welcome_letter", false).ly();
    }

    ()
    {
        this$0 = final_albumswelcomeletterhelper;
        val$sharedPrefs = SharedPreferences.this;
        super();
    }
}
