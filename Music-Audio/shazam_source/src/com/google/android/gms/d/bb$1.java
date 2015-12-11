// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.d:
//            bb, be, gm

final class a
    implements Runnable
{

    final bb a;

    public final void run()
    {
        Object obj2 = a;
_L5:
        Object obj;
        Object obj1;
        do
        {
            obj1 = (be)((bb) (obj2)).a.take();
            obj = ((be) (obj1)).c();
        } while (TextUtils.isEmpty(((CharSequence) (obj))));
        ((bb) (obj2)).c.putAll(((be) (obj1)).d());
        Object obj3 = ((bb) (obj2)).c;
        obj1 = Uri.parse(((bb) (obj2)).d).buildUpon();
        java.util.ntry ntry;
        for (obj3 = ((Map) (obj3)).entrySet().iterator(); ((Iterator) (obj3)).hasNext(); ((android.net.uilder) (obj1)).appendQueryParameter((String)ntry.getKey(), (String)ntry.getValue()))
        {
            ntry = (java.util.ntry)((Iterator) (obj3)).next();
        }

        break MISSING_BLOCK_LABEL_129;
        obj;
        b.a(5);
        return;
        String s;
        obj1 = new StringBuilder(((android.net.uilder) (obj1)).build().toString());
        ((StringBuilder) (obj1)).append("&it=").append(((String) (obj)));
        s = ((StringBuilder) (obj1)).toString();
        if (!((bb) (obj2)).g.get()) goto _L2; else goto _L1
_L1:
        obj1 = ((bb) (obj2)).h;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj = null;
        obj1 = new FileOutputStream(((java.io.File) (obj1)), true);
        obj = obj1;
        ((FileOutputStream) (obj1)).write(s.getBytes());
        obj = obj1;
        ((FileOutputStream) (obj1)).write(10);
        try
        {
            ((FileOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            b.a(5);
        }
          goto _L5
        obj;
        obj1 = null;
_L7:
        obj = obj1;
        b.a(5);
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.a(5);
            }
        }
          goto _L5
        obj2;
        obj1 = obj;
        obj = obj2;
_L6:
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                b.a(5);
            }
        }
        throw obj;
_L4:
        b.a(5);
          goto _L5
_L2:
        p.e();
        gm.a(((bb) (obj2)).e, ((bb) (obj2)).f, s);
          goto _L5
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
          goto _L6
        IOException ioexception;
        ioexception;
          goto _L7
    }

    (bb bb1)
    {
        a = bb1;
        super();
    }
}
