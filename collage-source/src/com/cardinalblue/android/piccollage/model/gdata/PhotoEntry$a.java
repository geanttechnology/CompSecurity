// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cardinalblue.android.piccollage.model.gdata;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;

// Referenced classes of package com.cardinalblue.android.piccollage.model.gdata:
//            PhotoEntry

public static class 
    implements k
{

    public PhotoEntry a(l l1, Type type, j j)
        throws p
    {
        if (l1 != null && l1.j()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((l1 = l1.m()).b("gphoto$videostatus") || ((type = l1.e("media$group")) == null || !type.b("media$content") || !type.b("media$thumbnail"))) goto _L1; else goto _L3
_L3:
        l1 = new PhotoEntry();
        j = type.d("media$content");
        if (j.a() < 1) goto _L1; else goto _L4
_L4:
        j = j.a(0).m();
        if (j == null) goto _L1; else goto _L5
_L5:
        if (!j.b("url")) goto _L1; else goto _L6
_L6:
        l1.b(j.c("url").c());
        type = type.d("media$thumbnail");
        if (type.a() >= 1) goto _L8; else goto _L7
_L7:
        l1.a(l1.b());
_L10:
        return l1;
_L8:
        type = type.a(0).m();
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        if (type.b("url"))
        {
            l1.a(type.c("url").c());
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            l1.a(l1.b());
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            try
            {
                l1.a(l1.b());
            }
            // Misplaced declaration of an exception variable
            catch (l l1)
            {
                return null;
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Object deserialize(l l1, Type type, j j)
        throws p
    {
        return a(l1, type, j);
    }

    public ()
    {
    }
}
