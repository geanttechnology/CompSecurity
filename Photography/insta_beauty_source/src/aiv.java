// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class aiv
    implements Runnable
{

    final ProEditSlimBodyActivity a;

    public aiv(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = uv.c().i();
        a.runOnUiThread(new aiw(this, bitmap));
    }
}
