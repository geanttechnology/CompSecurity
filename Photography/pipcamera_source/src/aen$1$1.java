// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;

class g.Object
    implements Runnable
{

    final Uri a;
    final net.Uri b;

    public void run()
    {
        aen.a(b.b).a(a);
    }

    net.Uri(net.Uri uri, Uri uri1)
    {
        b = uri;
        a = uri1;
        super();
    }

    // Unreferenced inner class aen$1

/* anonymous class */
    class aen._cls1
        implements android.media.MediaScannerConnection.OnScanCompletedListener
    {

        final aen a;

        public void onScanCompleted(String s, Uri uri)
        {
            if (aen.a(a) != null)
            {
                aen.b(a).post(new aen._cls1._cls1(this, uri));
            }
        }

            
            {
                a = aen1;
                super();
            }
    }

}
