// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class afs
    implements Runnable
{

    final afr a;

    afs(afr afr1)
    {
        a = afr1;
        super();
    }

    public void run()
    {
        a.a.i = uv.c().i();
        if (a.a.i == null || a.a.i.isRecycled())
        {
            a.a.runOnUiThread(new aft(this));
            return;
        } else
        {
            a.a.runOnUiThread(new afu(this));
            return;
        }
    }
}
