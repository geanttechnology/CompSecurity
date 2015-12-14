// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.fotoable.beautyui.gpuimage.sample.activity.fotobeautySettingActivity;
import com.fotoable.fotobeauty.StorePathActivity;

public class sl
    implements android.widget.AdapterView.OnItemClickListener
{

    final fotobeautySettingActivity a;

    public sl(fotobeautySettingActivity fotobeautysettingactivity)
    {
        a = fotobeautysettingactivity;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        fotobeautySettingActivity.a(a, 0);
        adapterview = new Intent(a, com/fotoable/fotobeauty/StorePathActivity);
        a.startActivity(adapterview);
    }
}
