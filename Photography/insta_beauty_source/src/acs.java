// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.fotoable.fotobeauty.WantuActivity;

public class acs
    implements android.content.DialogInterface.OnClickListener
{

    final WantuActivity a;

    public acs(WantuActivity wantuactivity)
    {
        a = wantuactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }
}
