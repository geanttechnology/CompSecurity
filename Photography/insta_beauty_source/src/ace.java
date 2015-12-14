// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.fotoable.fotobeauty.SettingActivity;

class ace
    implements android.content.DialogInterface.OnClickListener
{

    final acd a;

    ace(acd acd1)
    {
        a = acd1;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        android.content.SharedPreferences.Editor editor = SettingActivity.c(a.a).edit();
        editor.putInt(azo.a, i);
        editor.commit();
        SettingActivity.a(a.a, 0);
        dialoginterface.dismiss();
    }
}
