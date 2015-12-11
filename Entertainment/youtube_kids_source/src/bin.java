// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.FloatMath;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class bin extends bie
{

    private Map c;
    private final ReferenceQueue d = new ReferenceQueue();

    public bin(int i)
    {
        super(i);
        c = new HashMap((int)FloatMath.ceil((float)i / 0.75F) + 1, 0.75F);
    }

    public final Object a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = super.a(obj);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return obj1;
_L2:
        bio bio1 = (bio)c.get(obj);
        if (bio1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = bio1.get();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        super.a(obj, obj1);
        c.remove(obj);
        obj = obj1;
_L4:
        obj1 = obj;
        if (true) goto _L1; else goto _L3
        obj;
        throw obj;
_L3:
        obj = obj1;
          goto _L4
    }

    public final void a(bjo bjo1)
    {
        this;
        JVM INSTR monitorenter ;
        super.a(bjo1);
        Iterator iterator = c.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (bjo1.a(iterator.next()))
            {
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_60;
        bjo1;
        throw bjo1;
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        super.a(obj, obj1);
        i = c.size();
_L1:
        obj = (bio)d.poll();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        c.remove(bio.a(((bio) (obj))));
          goto _L1
        obj;
        throw obj;
        int j = i - c.size();
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        int k = c.size();
        bmo.e((new StringBuilder(83)).append(j).append(" out of ").append(i).append(" soft entries purged. SoftMap size is now ").append(k).toString());
        this;
        JVM INSTR monitorexit ;
    }

    public final Object b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = super.b(obj);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        c.put(obj, new bio(obj, obj1, d));
        this;
        JVM INSTR monitorexit ;
        return obj1;
        obj;
        throw obj;
    }

    public final String toString()
    {
        String s = String.valueOf(super.toString());
        String s1 = String.valueOf(c.toString());
        if (s1.length() != 0)
        {
            return s.concat(s1);
        } else
        {
            return new String(s);
        }
    }
}
