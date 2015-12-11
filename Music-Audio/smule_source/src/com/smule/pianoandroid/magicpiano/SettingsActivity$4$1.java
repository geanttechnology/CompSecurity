// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements android.content.ckListener
{

    final tActivityForResult a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            dialoginterface = new Intent("android.intent.action.GET_CONTENT");
            dialoginterface.setType("image/*");
            dialoginterface = Intent.createChooser(dialoginterface, a.a.getString(0x7f0c01dc));
            a.a.startActivityForResult(dialoginterface, 1890);
            return;

        case 1: // '\001'
            dialoginterface = new Intent("android.media.action.IMAGE_CAPTURE");
            break;
        }
        a.a.startActivityForResult(dialoginterface, 1888);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/SettingsActivity$4

/* anonymous class */
    class SettingsActivity._cls4
        implements android.view.View.OnClickListener
    {

        final SettingsActivity a;

        public void onClick(View view)
        {
            if (UserManager.n().h())
            {
                view = new android.app.AlertDialog.Builder(a);
                view.setTitle(a.getString(0x7f0c01d9));
                String s = a.getString(0x7f0c01db);
                String s1 = a.getString(0x7f0c01d8);
                SettingsActivity._cls4._cls1 _lcls1 = new SettingsActivity._cls4._cls1(this);
                view.setItems(new CharSequence[] {
                    s, s1
                }, _lcls1);
                view.show();
            }
        }

            
            {
                a = settingsactivity;
                super();
            }
    }

}
