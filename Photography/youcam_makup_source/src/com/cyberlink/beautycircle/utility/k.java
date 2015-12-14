// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.model.network.d;
import com.nostra13.universalimageloader.a.a.a;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.utility.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            j

class k
{

    final j a;
    private List b;
    private int c;
    private Object d;

    private k(j j)
    {
        a = j;
        super();
        b = new ArrayList();
        c = 0;
        d = new Object();
    }

    k(j j, j._cls1 _pcls1)
    {
        this(j);
    }

    public Uri a()
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        Object obj3 = d;
        obj3;
        JVM INSTR monitorenter ;
        Object obj = obj2;
        if (b.size() != 0) goto _L2; else goto _L1
_L1:
        obj = obj2;
        e.b(new Object[] {
            "The default cover list is empty."
        });
        obj1 = null;
_L7:
        obj = obj1;
        obj3;
        JVM INSTR monitorexit ;
        return ((Uri) (obj1));
_L2:
        obj = obj2;
        int i = c;
        obj = obj1;
_L9:
        obj1 = (Uri)b.get(c);
        obj = obj1;
        c = c + 1;
        obj = obj1;
        c = c % b.size();
        obj = obj1;
        if (com.cyberlink.beautycircle.model.network.c.a()) goto _L4; else goto _L3
_L3:
        obj = obj1;
        if (!f.b().d().a(((Uri) (obj1)).toString()).exists()) goto _L6; else goto _L5
_L5:
        obj = obj1;
        e.b(new Object[] {
            "No network, but has file cache."
        });
          goto _L7
        Exception exception;
        exception;
        obj1 = obj;
_L8:
        obj = obj1;
        obj3;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return ((Uri) (obj1));
        }
_L6:
        obj = obj1;
        if (i != c)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        obj = obj1;
        e.b(new Object[] {
            "No network and can't find next file"
        });
          goto _L7
_L4:
        obj = obj1;
        e.b(new Object[] {
            (new StringBuilder()).append("The current index is '").append(c).append("' and Uri is '").append(((Uri) (obj1)).toString()).append("'").toString()
        });
          goto _L7
        obj;
        return null;
        exception;
        obj1 = obj;
          goto _L8
        obj = obj1;
          goto _L9
    }

    public void a(d d1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        b.clear();
        d1 = d1.b.iterator();
        do
        {
            if (!d1.hasNext())
            {
                break;
            }
            com.cyberlink.beautycircle.model.network.NetworkUser.DefaultCover defaultcover = (com.cyberlink.beautycircle.model.network.NetworkUser.DefaultCover)d1.next();
            if (defaultcover.coverUrl != null)
            {
                b.add(defaultcover.coverUrl);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_72;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
        obj;
        JVM INSTR monitorexit ;
    }

    public Uri b()
    {
        Object obj1 = null;
        Object obj3 = d;
        obj3;
        JVM INSTR monitorenter ;
        Object obj2 = (Uri)b.get(c);
        Object obj = obj2;
        if (com.cyberlink.beautycircle.model.network.c.a()) goto _L2; else goto _L1
_L1:
        obj = obj2;
        int i = c;
        obj = obj2;
_L8:
        obj1 = obj;
        if (!f.b().d().a(((Uri) (obj)).toString()).exists()) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        e.b(new Object[] {
            "No network, but has file cache."
        });
_L7:
        obj2 = obj;
_L9:
        obj = obj2;
        obj3;
        JVM INSTR monitorexit ;
        return ((Uri) (obj2));
_L4:
        obj1 = obj;
        c = c + 1;
        obj1 = obj;
        c = c % b.size();
        obj1 = obj;
        if (i != c) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        e.b(new Object[] {
            "No network and can't find next file"
        });
          goto _L7
_L10:
        obj1 = obj2;
        obj3;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return ((Uri) (obj2));
        }
_L6:
        obj1 = obj;
        obj = (Uri)b.get(c);
          goto _L8
_L2:
        obj = obj2;
        e.b(new Object[] {
            (new StringBuilder()).append("The next index is '").append(c).append("' and Uri is '").append(((Uri) (obj2)).toString()).append("'").toString()
        });
          goto _L9
        obj1;
        obj2 = obj;
        obj = obj1;
          goto _L10
        Exception exception;
        exception;
        return null;
        exception;
        obj2 = obj1;
          goto _L10
    }
}
