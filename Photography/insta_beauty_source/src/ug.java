// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

public class ug
    implements android.view.View.OnClickListener
{

    final MNewFotoBeautyActivity a;

    public ug(MNewFotoBeautyActivity mnewfotobeautyactivity)
    {
        a = mnewfotobeautyactivity;
        super();
    }

    public void onClick(View view)
    {
        MNewFotoBeautyActivity.t(a);
        if (MNewFotoBeautyActivity.y(a) != null)
        {
            MNewFotoBeautyActivity.y(a).dismiss();
            MNewFotoBeautyActivity.a(a, null);
        }
    }
}
