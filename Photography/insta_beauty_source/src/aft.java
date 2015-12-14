// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

class aft
    implements Runnable
{

    final afs a;

    aft(afs afs1)
    {
        a = afs1;
        super();
    }

    public void run()
    {
        Log.e("ProEditFilterActivity", "process bitmap is null");
        a.a.a.c();
        a.a.a.finish();
    }
}
