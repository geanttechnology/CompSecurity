// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.util.Log;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.fotobeauty.WantuActivity;

public class acr
    implements android.content.DialogInterface.OnClickListener
{

    final WantuActivity a;

    public acr(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Log.e("Hello", "startNewCameraClicked");
        ActivityCameraNew.b(a, 1113);
        pt.a(pt.r, a, false);
    }
}
