// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry;
import com.bumptech.glide.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.h;
import java.util.List;
import myobfuscated.af.g;
import myobfuscated.v.af;

// Referenced classes of package com.bumptech.glide.load.engine:
//            ad, DecodeJob, e, l, 
//            b, ac, g, af

class k
{

    final DataSource a;
    DecodeJob b;

    public k(DecodeJob decodejob, DataSource datasource)
    {
        b = decodejob;
        super();
        a = datasource;
    }

    public ad a(ad ad1)
    {
        Class class1 = ad1.b().getClass();
        Object obj;
        Object obj1;
        EncodeStrategy encodestrategy;
        Object obj2;
        Object obj3;
        int i;
        int j;
        boolean flag;
        if (a != DataSource.RESOURCE_DISK_CACHE)
        {
            obj1 = DecodeJob.a(b).c(class1);
            obj = ((h) (obj1)).a(ad1, com.bumptech.glide.load.engine.DecodeJob.b(b), DecodeJob.c(b));
        } else
        {
            obj = ad1;
            obj1 = null;
        }
        if (!ad1.equals(obj))
        {
            ad1.d();
        }
        if (DecodeJob.a(b).c.a.b.a(((ad) (obj)).a()) != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        ad1 = DecodeJob.a(b).c.a.b.a(((ad) (obj)).a());
        if (ad1 == null) goto _L4; else goto _L3
_L3:
        encodestrategy = ad1.a(com.bumptech.glide.load.engine.DecodeJob.d(b));
_L19:
        obj3 = DecodeJob.a(b);
        obj2 = DecodeJob.e(b);
        obj3 = ((e) (obj3)).a();
        j = ((List) (obj3)).size();
        i = 0;
_L12:
        if (i >= j) goto _L6; else goto _L5
_L5:
        if (!((af)((List) (obj3)).get(i)).a.equals(obj2)) goto _L8; else goto _L7
_L7:
        i = 1;
_L13:
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj2 = obj;
        if (!DecodeJob.f(b).a(flag, a, encodestrategy)) goto _L10; else goto _L9
_L9:
        if (ad1 == null)
        {
            throw new com.bumptech.glide.Registry.NoResultEncoderAvailableException(((ad) (obj)).b().getClass());
        }
          goto _L11
_L4:
        throw new com.bumptech.glide.Registry.NoResultEncoderAvailableException(((ad) (obj)).a());
_L2:
        encodestrategy = EncodeStrategy.NONE;
        ad1 = null;
        continue; /* Loop/switch isn't completed */
_L8:
        i++;
          goto _L12
_L6:
        i = 0;
          goto _L13
_L11:
        if (encodestrategy != EncodeStrategy.SOURCE) goto _L15; else goto _L14
_L14:
        obj1 = new com.bumptech.glide.load.engine.b(DecodeJob.e(b), com.bumptech.glide.load.engine.DecodeJob.g(b));
_L17:
        obj2 = ac.a(((ad) (obj)));
        obj = com.bumptech.glide.load.engine.DecodeJob.h(b);
        obj.a = ((b) (obj1));
        obj.b = ad1;
        obj.c = ((ac) (obj2));
_L10:
        return ((ad) (obj2));
_L15:
        if (encodestrategy != EncodeStrategy.TRANSFORMED)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = new com.bumptech.glide.load.engine.af(DecodeJob.e(b), com.bumptech.glide.load.engine.DecodeJob.g(b), com.bumptech.glide.load.engine.DecodeJob.b(b), DecodeJob.c(b), ((h) (obj1)), class1, com.bumptech.glide.load.engine.DecodeJob.d(b));
        if (true) goto _L17; else goto _L16
_L16:
        throw new IllegalArgumentException((new StringBuilder("Unknown strategy: ")).append(encodestrategy).toString());
        if (true) goto _L19; else goto _L18
_L18:
    }
}
