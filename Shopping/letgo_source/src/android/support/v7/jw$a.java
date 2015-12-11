// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.h;
import com.facebook.k;
import java.util.UUID;

// Referenced classes of package android.support.v7:
//            jw, kb

public static final class <init>
{

    private final UUID a;
    private final String b;
    private final String c;
    private Bitmap d;
    private Uri e;
    private boolean f;
    private boolean g;

    static boolean a(<init> <init>1)
    {
        return <init>1.g;
    }

    static UUID b(g g1)
    {
        return g1.a;
    }

    static String c(a a1)
    {
        return a1.c;
    }

    static Bitmap d(c c1)
    {
        return c1.d;
    }

    static Uri e(d d1)
    {
        return d1.e;
    }

    static boolean f(e e1)
    {
        return e1.f;
    }

    public String a()
    {
        return b;
    }

    private tentProvider(UUID uuid, Bitmap bitmap, Uri uri)
    {
        boolean flag;
        flag = true;
        super();
        a = uuid;
        d = bitmap;
        e = uri;
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        bitmap = uri.getScheme();
        if (!"content".equalsIgnoreCase(bitmap)) goto _L2; else goto _L1
_L1:
        f = true;
        if (uri.getAuthority() == null || uri.getAuthority().startsWith("media"))
        {
            flag = false;
        }
        g = flag;
_L5:
        if (!g)
        {
            bitmap = null;
        } else
        {
            bitmap = UUID.randomUUID().toString();
        }
        c = bitmap;
        if (!g)
        {
            uuid = e.toString();
        } else
        {
            uuid = FacebookContentProvider.a(k.i(), uuid, c);
        }
        b = uuid;
        return;
_L2:
        if (!"file".equalsIgnoreCase(uri.getScheme())) goto _L4; else goto _L3
_L3:
        g = true;
          goto _L5
_L4:
        if (kb.b(uri)) goto _L5; else goto _L6
_L6:
        throw new h((new StringBuilder()).append("Unsupported scheme for media Uri : ").append(bitmap).toString());
        if (bitmap != null)
        {
            g = true;
        } else
        {
            throw new h("Cannot share media without a bitmap or Uri set");
        }
          goto _L5
    }

    g(UUID uuid, Bitmap bitmap, Uri uri, g g1)
    {
        this(uuid, bitmap, uri);
    }
}
