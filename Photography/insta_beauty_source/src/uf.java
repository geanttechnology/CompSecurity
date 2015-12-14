// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.net.Uri;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.fotobeauty.NewPhotoShareActivity;

class uf
    implements Runnable
{

    final String a;
    final Uri b;
    final ud c;

    uf(ud ud1, String s, Uri uri)
    {
        c = ud1;
        a = s;
        b = uri;
        super();
    }

    public void run()
    {
        if (a.equals("")) goto _L2; else goto _L1
_L1:
        if (MNewFotoBeautyActivity.v(c.a)) goto _L4; else goto _L3
_L3:
        Intent intent = new Intent(c.a, com/fotoable/fotobeauty/NewPhotoShareActivity);
        intent.putExtra("image_file_path", a);
        intent.putExtra(ActivityCameraNew.c, MNewFotoBeautyActivity.w(c.a));
        c.a.startActivity(intent);
        c.a.overridePendingTransition(0x7f040009, 0);
        MNewFotoBeautyActivity.x(c.a);
        JVM INSTR tableswitch 10 12: default 132
    //                   10 143
    //                   11 152
    //                   12 161;
           goto _L2 _L5 _L6 _L7
_L2:
        MNewFotoBeautyActivity.s(c.a);
        return;
_L5:
        FlurryAgent.logEvent("PhotoSave_Camera_Library");
        continue; /* Loop/switch isn't completed */
_L6:
        FlurryAgent.logEvent("PhotoSave_Camera");
        continue; /* Loop/switch isn't completed */
_L7:
        FlurryAgent.logEvent("PhotoSave_Library");
        continue; /* Loop/switch isn't completed */
_L4:
        Intent intent1 = new Intent();
        intent1.putExtra(MNewFotoBeautyActivity.d, b.toString());
        c.a.setResult(-1, intent1);
        c.a.finish();
        if (true) goto _L2; else goto _L8
_L8:
    }
}
