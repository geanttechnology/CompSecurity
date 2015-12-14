// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import com.bumptech.glide.load.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.v:
//            ae, af, al

final class ak
    implements ae
{

    private final List a;
    private final android.support.v4.util.Pools.Pool b;

    ak(List list, android.support.v4.util.Pools.Pool pool)
    {
        a = list;
        b = pool;
    }

    public final af buildLoadData(Object obj, int i, int j, e e)
    {
        int l = a.size();
        ArrayList arraylist = new ArrayList(l);
        int k = 0;
        com.bumptech.glide.load.b b1 = null;
        for (; k < l; k++)
        {
            Object obj1 = (ae)a.get(k);
            if (!((ae) (obj1)).handles(obj))
            {
                continue;
            }
            obj1 = ((ae) (obj1)).buildLoadData(obj, i, j, e);
            if (obj1 != null)
            {
                b1 = ((af) (obj1)).a;
                arraylist.add(((af) (obj1)).c);
            }
        }

        if (!arraylist.isEmpty())
        {
            return new af(b1, new al(arraylist, b));
        } else
        {
            return null;
        }
    }

    public final boolean handles(Object obj)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((ae)iterator.next()).handles(obj))
            {
                return true;
            }
        }

        return false;
    }

    public final String toString()
    {
        return (new StringBuilder("MultiModelLoader{modelLoaders=")).append(Arrays.toString(a.toArray(new ae[a.size()]))).append('}').toString();
    }
}
