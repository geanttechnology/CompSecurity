// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.model.network.b;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.a;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            UserInfo

public class CampaignGroup extends Model
{

    private static ArrayList a = null;
    private static final ArrayList b = new ArrayList();
    private static boolean c = false;
    private static a d = new a() {

        public void a(UserInfo userinfo)
        {
            com.cyberlink.beautycircle.model.CampaignGroup.a(null);
        }

    };
    public ArrayList campaigns;
    public long id;
    public String name;
    public long rotationPeriod;

    public CampaignGroup()
    {
    }

    public static j a()
    {
        if (a != null && !a.isEmpty())
        {
            return (new j() {

                protected volatile Object a(Object obj1)
                {
                    return a((Void)obj1);
                }

                protected ArrayList a(Void void1)
                {
                    return com.cyberlink.beautycircle.model.CampaignGroup.b();
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
            obj = new j() {

                protected volatile Object a(Object obj1)
                {
                    return a((Void)obj1);
                }

                protected ArrayList a(Void void1)
                {
                    return com.cyberlink.beautycircle.model.CampaignGroup.b();
                }

            };
            b.add(obj);
            if (b.size() == 1)
            {
                break MISSING_BLOCK_LABEL_84;
            }
        }
        return ((j) (obj));
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        com.cyberlink.beautycircle.model.network.b.a(0, 20).a(new l() {

            public void a()
            {
                super.a();
                a(0x80000005);
            }

            public void a(int i)
            {
                super.a(i);
                a(((d) (null)));
            }

            protected void a(d d1)
            {
                if (d1 == null)
                {
                    return;
                }
                com.cyberlink.beautycircle.model.CampaignGroup.a(d1.b);
                d1 = CampaignGroup.c();
                d1;
                JVM INSTR monitorenter ;
                for (Iterator iterator = CampaignGroup.c().iterator(); iterator.hasNext(); ((j)iterator.next()).d(null)) { }
                break MISSING_BLOCK_LABEL_57;
                Exception exception;
                exception;
                d1;
                JVM INSTR monitorexit ;
                throw exception;
                CampaignGroup.c().clear();
                d1;
                JVM INSTR monitorexit ;
            }

            protected void b(Object obj1)
            {
                a((d)obj1);
            }

        });
        arraylist;
        JVM INSTR monitorexit ;
        return ((j) (obj));
    }

    public static j a(String s)
    {
        return a().a(new j(s) {

            final String a;

            public CampaignGroup a(ArrayList arraylist)
            {
                if (arraylist == null)
                {
                    return null;
                }
                for (arraylist = arraylist.iterator(); arraylist.hasNext();)
                {
                    CampaignGroup campaigngroup = (CampaignGroup)arraylist.next();
                    if (campaigngroup.name.equals(a.toString()))
                    {
                        return campaigngroup;
                    }
                }

                return null;
            }

            public volatile Object a(Object obj)
            {
                return a((ArrayList)obj);
            }

            
            {
                a = s;
                super();
            }
        });
    }

    static ArrayList a(ArrayList arraylist)
    {
        a = arraylist;
        return arraylist;
    }

    static ArrayList b()
    {
        return a;
    }

    static ArrayList c()
    {
        return b;
    }

}
