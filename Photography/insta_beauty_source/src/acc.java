// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.fotoable.fotobeauty.SettingActivity;

public class acc
    implements android.widget.AdapterView.OnItemClickListener
{

    final SettingActivity a;

    public acc(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (TextView)view.findViewById(0x7f0d0463);
        view = adapterview.getText().toString();
        if (i == 0)
        {
            SettingActivity.a(a, adapterview, view);
        }
    }
}
