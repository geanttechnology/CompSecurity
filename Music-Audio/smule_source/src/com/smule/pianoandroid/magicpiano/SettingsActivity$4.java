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
    implements android.view.r
{

    final SettingsActivity a;

    public void onClick(View view)
    {
        if (UserManager.n().h())
        {
            view = new android.app.(a);
            view.setTitle(a.getString(0x7f0c01d9));
            String s = a.getString(0x7f0c01db);
            String s1 = a.getString(0x7f0c01d8);
            android.content.lickListener licklistener = new android.content.DialogInterface.OnClickListener() {

                final SettingsActivity._cls4 a;

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

            
            {
                a = SettingsActivity._cls4.this;
                super();
            }
            };
            view.setItems(new CharSequence[] {
                s, s1
            }, licklistener);
            view.show();
        }
    }

    _cls1.a(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
