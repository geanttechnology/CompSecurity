// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;

public class sk
    implements android.widget.AdapterView.OnItemClickListener
{

    final fotobeautySettingActivity a;

    public sk(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            adapterview = new Intent("android.intent.action.VIEW");
            adapterview.setData(Uri.parse("market://details?id=com.fotoable.fotobeauty"));
            adapterview = Intent.createChooser(adapterview, null);
            a.startActivity(adapterview);
        } else
        if (i == 1)
        {
            adapterview = new Intent("android.intent.action.VIEW");
            adapterview.setData(Uri.parse("https://m.facebook.com/ads/ad_choices"));
            adapterview = Intent.createChooser(adapterview, null);
            a.startActivity(adapterview);
            return;
        }
    }
}
