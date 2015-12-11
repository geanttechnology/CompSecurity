// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.wearcom.b;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.o;
import java.util.List;
import org.b.b;
import org.b.c;

// Referenced classes of package com.shazam.android.wearcom.b:
//            c

public class a
    implements com.shazam.android.wearcom.b.c
{

    private static final b a = c.a(com/shazam/android/wearcom/b/a.getSimpleName());

    public a()
    {
    }

    public final Status a(com.google.android.gms.common.api.c c1, Intent intent)
    {
        byte abyte0[] = null;
        Object obj = intent.getStringExtra("extraNodeId");
        if (!com.shazam.android.wearcom.c.a.b(((String) (obj))))
        {
            obj = ((com.google.android.gms.wearable.m.a)o.d.a(c1).a()).b();
            if (obj != null && !((List) (obj)).isEmpty())
            {
                obj = ((l)((List) (obj)).get(0)).a();
            } else
            {
                obj = null;
            }
        }
        if (com.shazam.android.wearcom.c.a.a(((String) (obj))))
        {
            a.b("Falied to deliver message - No nodes found");
            return new Status(13);
        }
        String s = intent.getStringExtra("extraData");
        if (s != null)
        {
            abyte0 = s.getBytes();
        }
        return ((com.google.android.gms.wearable.j.b)o.c.a(c1, ((String) (obj)), intent.getAction(), abyte0).a()).a();
    }

}
