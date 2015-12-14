// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.content.Intent;
import com.socialin.android.net.b;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.multiselect:
//            e

final class a
    implements b
{

    private ArrayList a;
    private e b;

    public final void a(Intent intent)
    {
        if (intent.getAction().equals("intent.action.download.complete"))
        {
            intent = intent.getStringArrayExtra("downloaded_file_paths");
            e.a(b, intent, a);
        }
    }

    (e e1, ArrayList arraylist)
    {
        b = e1;
        a = arraylist;
        super();
    }
}
