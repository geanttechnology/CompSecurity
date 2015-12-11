// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, aeu, agq, afh, 
//            agb, afa, aez, afm, 
//            afs

final class afk extends afl
{
    private static class a
        implements afm
    {

        private final agq a;
        private final boolean b;
        private final Class c;
        private final afh d;
        private final aez e;

        public afl a(aeu aeu1, agq agq1)
        {
            boolean flag;
            if (a != null)
            {
                if (a.equals(agq1) || b && a.b() == agq1.a())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = c.isAssignableFrom(agq1.a());
            }
            if (flag)
            {
                return new afk(d, e, aeu1, agq1, this);
            } else
            {
                return null;
            }
        }

        private a(Object obj, agq agq1, boolean flag, Class class1)
        {
            afh afh1;
            boolean flag1;
            if (obj instanceof afh)
            {
                afh1 = (afh)obj;
            } else
            {
                afh1 = null;
            }
            d = afh1;
            if (obj instanceof aez)
            {
                obj = (aez)obj;
            } else
            {
                obj = null;
            }
            e = ((aez) (obj));
            if (d != null || e != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            afs.a(flag1);
            a = agq1;
            b = flag;
            c = class1;
        }

    }


    private final afh a;
    private final aez b;
    private final aeu c;
    private final agq d;
    private final afm e;
    private afl f;

    private afk(afh afh1, aez aez1, aeu aeu1, agq agq1, afm afm)
    {
        a = afh1;
        b = aez1;
        c = aeu1;
        d = agq1;
        e = afm;
    }


    private afl a()
    {
        afl afl1 = f;
        if (afl1 != null)
        {
            return afl1;
        } else
        {
            afl afl2 = c.a(e, d);
            f = afl2;
            return afl2;
        }
    }

    public static afm a(agq agq1, Object obj)
    {
        return new a(obj, agq1, false, null);
    }

    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (a == null)
        {
            a().a(jsonwriter, obj);
            return;
        }
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            agb.a(a.a(obj, d.b(), c.b), jsonwriter);
            return;
        }
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        if (b == null)
        {
            return a().b(jsonreader);
        }
        jsonreader = agb.a(jsonreader);
        if (jsonreader.j())
        {
            return null;
        } else
        {
            return b.b(jsonreader, d.b(), c.a);
        }
    }
}
