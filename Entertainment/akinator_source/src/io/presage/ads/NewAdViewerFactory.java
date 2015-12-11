// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

// Referenced classes of package io.presage.ads:
//            i, j, k, NewAdViewerDescriptor, 
//            NewAdController, NewAd, NewAdViewer

public class NewAdViewerFactory
{
    public static final class a
    {

        private Class a;

        public final NewAdViewer a(NewAdController newadcontroller, NewAd newad, int l)
        {
            newadcontroller = (NewAdViewer)a.getConstructor(new Class[] {
                io/presage/ads/NewAdController, io/presage/ads/NewAd, Integer.TYPE
            }).newInstance(new Object[] {
                newadcontroller, newad, Integer.valueOf(l)
            });
            return newadcontroller;
            newadcontroller;
            newadcontroller.printStackTrace();
_L2:
            return null;
            newadcontroller;
            newadcontroller.printStackTrace();
            continue; /* Loop/switch isn't completed */
            newadcontroller;
            newadcontroller.printStackTrace();
            continue; /* Loop/switch isn't completed */
            newadcontroller;
            newadcontroller.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }

        private a(Class class1)
        {
            a = class1;
        }

        a(Class class1, byte byte0)
        {
            this(class1);
        }
    }


    private static final Map a = new i();
    private static final Map b = new j();
    private static final Map c = new k();
    private static NewAdViewerFactory d;

    private NewAdViewerFactory()
    {
    }

    public static NewAdViewerFactory getInstance()
    {
        if (d == null)
        {
            d = new NewAdViewerFactory();
        }
        return d;
    }

    public a getViewer(NewAdViewerDescriptor newadviewerdescriptor)
    {
        if (newadviewerdescriptor == null)
        {
            return null;
        }
        Map map = (Map)c.get(newadviewerdescriptor.getClass());
        if (map == null)
        {
            return null;
        }
        if (!map.containsKey(newadviewerdescriptor.getType()))
        {
            return null;
        } else
        {
            return new a((Class)map.get(newadviewerdescriptor.getType()), (byte)0);
        }
    }



}
