// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import com.fotoable.fotobeauty.SettingActivity;

public class acd
    implements android.widget.AdapterView.OnItemClickListener
{

    final SettingActivity a;

    public acd(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            (new android.app.AlertDialog.Builder(a)).setTitle(SettingActivity.d(a)).setIcon(0x108009b).setSingleChoiceItems(SettingActivity.b(a), SettingActivity.c(a).getInt(azo.a, 0), new ace(this)).setNegativeButton(SettingActivity.a(a), null).show();
        }
    }
}
