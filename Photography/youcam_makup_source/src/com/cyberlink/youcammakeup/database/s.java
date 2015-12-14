// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.jniproxy.UIExifColorSpace;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.an;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.bd;
import com.cyberlink.youcammakeup.jniproxy.be;
import com.cyberlink.youcammakeup.jniproxy.bf;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.x;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            n, q, o, m, 
//            p, r

public class s
{

    private static final k a = new k(Globals.d().l());
    private static final n b = com.cyberlink.youcammakeup.c.e();
    private static final p c = com.cyberlink.youcammakeup.c.f();

    private static com.cyberlink.youcammakeup.database.m a(long l, q q1)
    {
        Object obj1 = b.b(l);
        if (obj1 == null)
        {
            q1.a = (new StringBuilder()).append("fileObj == null. file ID=").append(l).toString();
            return null;
        }
        Object obj3 = ((com.cyberlink.youcammakeup.database.o) (obj1)).b();
        Object obj = new ba();
        if (!a.a(((String) (obj3)), ((ba) (obj))))
        {
            q1.a = (new StringBuilder()).append("ImageCodec.GetMetadataFromFile() == null. file ID=").append(l).append(", path=").append(((String) (obj3))).toString();
            return null;
        }
        Object obj2 = ((ba) (obj)).c();
        obj = ((ba) (obj)).b();
        int i = (int)((an) (obj)).d();
        int j = (int)((an) (obj)).c();
        double d;
        Exception exception;
        String s1;
        long l1;
        long l2;
        boolean flag;
        if (i <= 0 || j <= 0)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(((String) (obj3)), options);
            i = options.outHeight;
            j = options.outWidth;
            flag = true;
        } else
        {
            flag = false;
        }
        if (i < 32 || j < 32)
        {
            q1.a = (new StringBuilder()).append("fileHeight or fileWidth < 32. file ID=").append(l).append(", path=").append(((String) (obj3))).append(", fileWidth=").append(j).append(", fileHeight=").append(i).append(", isDecodeWidthHeightFromBitmapFactory=").append(flag).toString();
            return null;
        }
        if (i > j)
        {
            d = i / j;
        } else
        {
            d = j / i;
        }
        if (d > 10D)
        {
            q1.a = (new StringBuilder()).append("ratio > 10. file ID=").append(l).append(", path=").append(((String) (obj3))).append(", fileWidth=").append(j).append(", fileHeight=").append(i).append(", isDecodeWidthHeightFromBitmapFactory=").append(flag).toString();
            return null;
        }
        l1 = ((com.cyberlink.youcammakeup.database.o) (obj1)).c();
        q1 = UIImageOrientation.a;
        obj = ((an) (obj)).e();
        q1 = ((q) (obj));
_L1:
        s1 = ((com.cyberlink.youcammakeup.database.o) (obj1)).a();
        l2 = ((com.cyberlink.youcammakeup.database.o) (obj1)).c();
        obj1 = UIExifColorSpace.e;
        obj = ((x) (obj2)).b();
        obj1 = obj;
_L2:
        obj2 = UIImageOrientation.a;
        obj = new bd();
        if (!a.a(((String) (obj3)), ((bd) (obj))))
        {
            obj = obj2;
        } else
        {
            obj3 = ((bd) (obj)).b();
            obj = obj2;
            if (((bf) (obj3)).b() > 0L)
            {
                obj = ((bf) (obj3)).a(0);
                try
                {
                    obj = ((be) (obj)).e();
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    exception = ((Exception) (obj2));
                }
            }
        }
        if (q1 != null && q1 == UIImageOrientation.a)
        {
            obj2 = UIImageOrientation.b;
        } else
        {
            obj2 = q1;
        }
        if (q1 != null && q1 == UIImageOrientation.a)
        {
            q1 = UIImageOrientation.b;
        }
        obj3 = obj;
        if (obj != null)
        {
            obj3 = obj;
            if (obj == UIImageOrientation.a)
            {
                obj3 = UIImageOrientation.b;
            }
        }
        return new com.cyberlink.youcammakeup.database.m(l1, ((UIImageOrientation) (obj2)), "", l, -1, s1, i, j, -1, "", l2, 0, ((UIImageOrientation) (obj3)), ((UIExifColorSpace) (obj1)), q1, -1L);
        exception;
          goto _L1
        exception;
          goto _L2
    }

    public static r a(long l)
    {
        p p1 = com.cyberlink.youcammakeup.c.f();
        return p1.a(p1.c(l));
    }

    public static r a(r r1, q q1)
    {
        Object obj = a(r1.f(), q1);
        if (obj == null)
        {
            m.d("database.Utility", (new StringBuilder()).append("DummyImageObj is null, can NOT readProperties, fileId: ").append(r1.f()).toString());
            obj = null;
        } else
        {
            r r2 = c.a(r1.w(), ((com.cyberlink.youcammakeup.database.m) (obj)));
            obj = r2;
            if (r2 == null)
            {
                q1.a = (new StringBuilder()).append("ImageDao.update() == null. image ID=").append(r1.w()).append(", file ID=").append(r1.f()).toString();
                return r2;
            }
        }
        return ((r) (obj));
    }

    public static boolean a(Context context, long l)
    {
        Object obj = com.cyberlink.youcammakeup.c.f();
        o o1 = Globals.d().i();
        o1.b(context);
        if (((p) (obj)).c(l) != null)
        {
            o1.h(context);
            return true;
        }
        int i;
        if ((new File(((p) (obj)).g(l))).isFile())
        {
            i = 0x7f070066;
        } else
        {
            i = 0x7f070060;
        }
        obj = context.getString(i);
        o1.h(context);
        o1.a(context, null, ((String) (obj)), false);
        return false;
    }

}
