// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, ps, ab, or, 
//            qa, pz

public class pc
    implements ox
{

    public pc()
    {
    }

    public Class a()
    {
        return jumiomobile/ps;
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        Object obj = null;
        double d = 0.0D;
        if (concurrentlinkedqueue.size() > 1)
        {
            ab.e("TemplateMatcher", "Warning: more than 1 final results found");
        }
        for (Iterator iterator = concurrentlinkedqueue.iterator(); iterator.hasNext();)
        {
            or or1 = (or)iterator.next();
            if (!(or1 instanceof ps))
            {
                throw new IllegalArgumentException("Only ImageProcessingMeasurement allowed!");
            }
            d += ((ps)or1).d();
        }

        android.graphics.Bitmap abitmap[];
        if (!concurrentlinkedqueue.isEmpty())
        {
            obj = (ps)concurrentlinkedqueue.element();
            abitmap = ((ps) (obj)).b();
            obj = ((ps) (obj)).c();
        } else
        {
            abitmap = null;
        }
        return new qa(d, concurrentlinkedqueue.size(), "Overall Image Processing duration", abitmap, ((com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper) (obj)));
    }
}
