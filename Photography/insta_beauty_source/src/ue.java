// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.Toast;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;

class ue
    implements Runnable
{

    final ud a;

    ue(ud ud1)
    {
        a = ud1;
        super();
    }

    public void run()
    {
        Toast.makeText(a.a, 0x7f0601b8, 0).show();
        MNewFotoBeautyActivity.s(a.a);
    }
}
