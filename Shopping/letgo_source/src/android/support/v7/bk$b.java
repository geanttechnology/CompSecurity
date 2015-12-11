// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            bk, bl, be

static class _cls1.a extends _cls1.a
{

    public Object a(bk bk1)
    {
        return bl.a(new bl.a(bk1) {

            final bk a;
            final bk.b b;

            public Object a(int i)
            {
                be be1 = a.a(i);
                if (be1 == null)
                {
                    return null;
                } else
                {
                    return be1.a();
                }
            }

            public List a(String s, int i)
            {
                s = a.a(s, i);
                ArrayList arraylist = new ArrayList();
                int j = s.size();
                for (i = 0; i < j; i++)
                {
                    arraylist.add(((be)s.get(i)).a());
                }

                return arraylist;
            }

            public boolean a(int i, int j, Bundle bundle)
            {
                return a.a(i, j, bundle);
            }

            
            {
                b = bk.b.this;
                a = bk1;
                super();
            }
        });
    }

    _cls1.a()
    {
    }
}
