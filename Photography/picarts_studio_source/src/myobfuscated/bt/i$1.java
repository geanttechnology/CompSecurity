// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.content.Intent;
import com.socialin.android.net.b;

// Referenced classes of package myobfuscated.bt:
//            i

final class it>
    implements b
{

    private i a;

    public final void a(Intent intent)
    {
        if (intent.getAction().equals("intent.action.download.complete"))
        {
            intent = intent.getStringArrayExtra("downloaded_file_paths");
            i.a(a, intent);
        }
    }

    nt(i j)
    {
        a = j;
        super();
    }
}
