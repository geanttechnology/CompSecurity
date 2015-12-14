// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class avx
    implements android.content.DialogInterface.OnClickListener
{

    final TTieZhiActivity a;

    public avx(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        TTieZhiActivity.d(a);
    }
}
