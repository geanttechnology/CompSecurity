// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.fotoable.fotobeauty.SettingActivity;

public class acb
    implements android.widget.AdapterView.OnItemClickListener
{

    final SettingActivity a;

    public acb(SettingActivity settingactivity)
    {
        a = settingactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            adapterview = new Intent("android.intent.action.VIEW", Uri.parse("http://a.wap.myapp.com/and2/s?aid=detail&appid=50801"));
            a.startActivity(adapterview);
        }
    }
}
