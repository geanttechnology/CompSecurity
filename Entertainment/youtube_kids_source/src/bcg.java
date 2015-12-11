// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;

final class bcg extends Thread
{

    final ContentResolver a;

    bcg(String s, ContentResolver contentresolver)
    {
        a = contentresolver;
        super(s);
    }

    public final void run()
    {
        Looper.prepare();
        a.registerContentObserver(bcf.a, true, new bch(this, new Handler(Looper.myLooper())));
        Looper.loop();
    }
}
