// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.w;

import android.text.TextUtils;
import com.bumptech.glide.load.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.v.ac;
import myobfuscated.v.ae;
import myobfuscated.v.af;
import myobfuscated.v.t;
import myobfuscated.v.u;

public abstract class a
    implements ae
{

    private final ae concreteLoader;
    private final ac modelCache;

    protected a(ae ae1)
    {
        this(ae1, null);
    }

    public a(ae ae1, ac ac1)
    {
        concreteLoader = ae1;
        modelCache = ac1;
    }

    private static List getAlternateKeys(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(new t((String)list.next()))) { }
        return arraylist;
    }

    public af buildLoadData(Object obj, int i, int j, e e)
    {
        Object obj1;
        t t1;
        if (modelCache != null)
        {
            obj1 = (t)modelCache.a(obj, i, j);
        } else
        {
            obj1 = null;
        }
        t1 = ((t) (obj1));
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj1 = getUrl(obj, i, j, e);
        if (!TextUtils.isEmpty(((CharSequence) (obj1)))) goto _L4; else goto _L3
_L3:
        obj = null;
_L6:
        return ((af) (obj));
_L4:
        obj1 = new t(((String) (obj1)), getHeaders(obj, i, j, e));
        t1 = ((t) (obj1));
        if (modelCache != null)
        {
            modelCache.a(obj, i, j, obj1);
            t1 = ((t) (obj1));
        }
_L2:
        obj1 = getAlternateUrls(obj, i, j, e);
        e = concreteLoader.buildLoadData(t1, i, j, e);
        obj = e;
        if (!((List) (obj1)).isEmpty())
        {
            return new af(((af) (e)).a, getAlternateKeys(((List) (obj1))), ((af) (e)).c);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected List getAlternateUrls(Object obj, int i, int j, e e)
    {
        return Collections.emptyList();
    }

    protected u getHeaders(Object obj, int i, int j, e e)
    {
        return u.a;
    }

    public abstract String getUrl(Object obj, int i, int j, e e);
}
