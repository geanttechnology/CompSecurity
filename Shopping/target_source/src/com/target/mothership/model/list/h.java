// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.c;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.a.a;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.util.i;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list:
//            e

public class h extends c
    implements e
{

    private GuestBase mGuest;
    private com.target.mothership.model.list.interfaces.a mList;

    public h(com.target.mothership.model.list.interfaces.a a1, GuestBase guestbase)
    {
        mList = a1;
        mGuest = guestbase;
    }

    public void a(d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("List Title", 3, false));
            return;
        }
    }

    public void a(ListItem listitem, int j, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("", false, "count set", 1, 1));
            return;
        }
    }

    public void a(ListItem listitem, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("", false, "item deleted", 1, 1));
            return;
        }
    }

    public void a(ListItem listitem, String s, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("", false, s, 1, 1));
            return;
        }
    }

    public void a(Product product, int j, int k, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            product = i.a("123-456-7890", true, "Specific Item", j, 0);
            ArrayList arraylist = new ArrayList();
            arraylist.add(product);
            d1.a(arraylist);
            return;
        }
    }

    public void a(Product product, int j, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            product = i.a("123-456-7890", true, "Specific Item", j, 0);
            ArrayList arraylist = new ArrayList();
            arraylist.add(product);
            d1.a(arraylist);
            return;
        }
    }

    public void a(String s, int j, int k, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            s = i.a(null, false, "Generic Item", 1, 0);
            ArrayList arraylist = new ArrayList();
            arraylist.add(s);
            d1.a(arraylist);
            return;
        }
    }

    public void a(String s, int j, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            s = i.a(null, false, "Generic Item", 1, 0);
            ArrayList arraylist = new ArrayList();
            arraylist.add(s);
            d1.a(arraylist);
            return;
        }
    }

    public void a(String s, String s1, String s2, String s3, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("Edit List", s3, s1, s, 2, false));
            return;
        }
    }

    public void b(d d1)
    {
        if (c().isDefaultList())
        {
            throw new IllegalArgumentException("Cannot delete the default list");
        }
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a("1000");
            return;
        }
    }

    public void b(ListItem listitem, int j, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            listitem = new ArrayList();
            listitem.add(i.a("", false, "count set", 1, 1));
            d1.a(listitem);
            return;
        }
    }

    public void b(ListItem listitem, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            listitem = new ArrayList();
            listitem.add(i.a("", false, "complete restored", 1, 1));
            d1.a(listitem);
            return;
        }
    }

    public com.target.mothership.model.list.interfaces.a c()
    {
        return mList;
    }

    public void c(d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void c(ListItem listitem, d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            listitem = new ArrayList();
            listitem.add(i.a("", false, "complete restored", 1, 1));
            d1.a(listitem);
            return;
        }
    }

    public void d(d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }
}
