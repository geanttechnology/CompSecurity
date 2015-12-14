// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import android.util.Pair;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            UserInfo

public class CircleType extends Model
{

    private static Map a = new HashMap();
    private static final ArrayList b = new ArrayList();
    private static boolean c = false;
    private static a d = new a() {

        public void a(UserInfo userinfo)
        {
            CircleType.c().clear();
        }

    };
    public String circleTypeName;
    public String defaultType;
    public Uri iconUrl;
    public Long id;
    public Date lastModified;

    public CircleType()
    {
        id = null;
        lastModified = null;
        circleTypeName = null;
        iconUrl = null;
        defaultType = null;
    }

    public static j a(Integer integer, Integer integer1)
    {
        Pair pair;
        j j1;
        pair = new Pair(integer, integer1);
        if (!a.isEmpty() && a.containsKey(pair))
        {
            return (new j(pair) {

                final Pair a;

                protected d a(Void void1)
                {
                    return (d)CircleType.c().get(a);
                }

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

            
            {
                a = pair;
                super();
            }
            }).d(null);
        }
        synchronized (b)
        {
            if (!c)
            {
                c = true;
                AccountManager.a(d);
            }
            j1 = new j(pair) {

                final Pair a;

                protected d a(Void void1)
                {
                    return (d)CircleType.c().get(a);
                }

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

            
            {
                a = pair;
                super();
            }
            };
            b.add(j1);
            if (b.size() == 1)
            {
                break MISSING_BLOCK_LABEL_107;
            }
        }
        return j1;
        integer;
        arraylist;
        JVM INSTR monitorexit ;
        throw integer;
        NetworkCircle.a(integer, integer1).a(new l(pair) {

            final Pair a;

            public void a()
            {
                super.a();
            }

            public void a(int i)
            {
                super.a(i);
                a(((d) (null)));
            }

            protected void a(d d1)
            {
                if (d1 != null)
                {
                    CircleType.c().put(a, d1);
                }
                d1 = com.cyberlink.beautycircle.model.CircleType.d();
                d1;
                JVM INSTR monitorenter ;
                for (Iterator iterator = com.cyberlink.beautycircle.model.CircleType.d().iterator(); iterator.hasNext(); ((j)iterator.next()).d(null)) { }
                break MISSING_BLOCK_LABEL_62;
                Exception exception;
                exception;
                d1;
                JVM INSTR monitorexit ;
                throw exception;
                com.cyberlink.beautycircle.model.CircleType.d().clear();
                d1;
                JVM INSTR monitorexit ;
            }

            protected void b(Object obj)
            {
                a((d)obj);
            }

            
            {
                a = pair;
                super();
            }
        });
        arraylist;
        JVM INSTR monitorexit ;
        return j1;
    }

    public static j a(String s)
    {
        return b().a(new j(s) {

            final String a;

            protected CircleType a(d d1)
            {
                if (d1 == null || d1.b == null)
                {
                    a(0x80000003);
                    return null;
                }
                for (d1 = d1.b.iterator(); d1.hasNext();)
                {
                    CircleType circletype = (CircleType)d1.next();
                    if (circletype != null && circletype.defaultType != null && circletype.defaultType.equals(a))
                    {
                        return circletype;
                    }
                }

                return null;
            }

            protected volatile Object a(Object obj)
            {
                return a((d)obj);
            }

            
            {
                a = s;
                super();
            }
        });
    }

    public static j b()
    {
        return (new j() {

            protected d a(Void void1)
            {
                d d1 = (d)com.cyberlink.beautycircle.model.CircleType.a(Integer.valueOf(0), Integer.valueOf(20)).d();
                int i;
                i = 0;
                void1 = null;
_L9:
                Void void2 = void1;
                if (d1 == null) goto _L2; else goto _L1
_L1:
                ArrayList arraylist = d1.b;
                void2 = void1;
                if (arraylist == null) goto _L2; else goto _L3
_L3:
                if (void1 != null) goto _L5; else goto _L4
_L4:
                void1 = d1;
_L7:
                Exception exception;
                int k;
                int l;
                try
                {
                    if (d1.b.size() < 20)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    k = ((d) (void1)).b.size();
                    l = ((d) (void1)).a.intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (k < l)
                {
                    break; /* Loop/switch isn't completed */
                }
                void2 = void1;
_L2:
                return void2;
_L5:
                ((d) (void1)).b.addAll(d1.b);
                void1.a = d1.a;
                if (true) goto _L7; else goto _L6
_L6:
                i += 20;
                d1 = (d)com.cyberlink.beautycircle.model.CircleType.a(Integer.valueOf(i), Integer.valueOf(20)).d();
                if (true) goto _L9; else goto _L8
                exception;
                void1 = null;
_L10:
                exception.printStackTrace();
                return void1;
                exception;
                if (true) goto _L10; else goto _L8
_L8:
                return void1;
            }

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

        }).d(null);
    }

    static Map c()
    {
        return a;
    }

    static ArrayList d()
    {
        return b;
    }

}
