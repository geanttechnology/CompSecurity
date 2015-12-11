// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package android.support.v7:
//            qq

class b
    implements android.content.gInterface.OnClickListener
{

    final String a;
    final String b;
    final qq c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (DownloadManager)qq.a(c).getSystemService("download");
        try
        {
            dialoginterface.enqueue(c.a(a, b));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            c.b("Could not store picture.");
        }
    }

    ception(qq qq1, String s, String s1)
    {
        c = qq1;
        a = s;
        b = s1;
        super();
    }
}
