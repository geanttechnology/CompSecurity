// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ln
{

    private static final String a = ln.getSimpleName();
    private ArrayList b;

    public ln(Context context)
    {
        try
        {
            b = (new ms(ni.a(context.getAssets().open("envsettings.json")))).a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private mt a(String s)
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            mt mt1 = (mt)iterator.next();
            if (mt1.a().compareTo(s) == 0)
            {
                return mt1;
            }
        }

        return null;
    }

    public ft a()
    {
        Object obj = nb.a().c();
        mt mt1 = a("SI");
        int i = ((SharedPreferences) (obj)).getInt("SI", -1);
        if (i != -1)
        {
            obj = (String)mt1.b().get(i);
        } else
        {
            obj = (String)mt1.b().get(mt1.d());
        }
        if (((String) (obj)).compareTo("Production") == 0)
        {
            return ft.a;
        }
        if (((String) (obj)).compareTo("QA1") == 0)
        {
            return ft.f;
        }
        if (((String) (obj)).compareTo("Stage") == 0)
        {
            return ft.d;
        } else
        {
            return null;
        }
    }

    public ft b()
    {
        Object obj = nb.a().c();
        mt mt1 = a("CartManager");
        int i = ((SharedPreferences) (obj)).getInt("CartManager", -1);
        if (i != -1)
        {
            obj = (String)mt1.b().get(i);
        } else
        {
            obj = (String)mt1.b().get(mt1.d());
        }
        if (((String) (obj)).compareTo("Production") == 0)
        {
            return ft.a;
        }
        if (((String) (obj)).compareTo("QA1") == 0)
        {
            return ft.f;
        }
        if (((String) (obj)).compareTo("QA3") == 0)
        {
            return ft.h;
        }
        if (((String) (obj)).compareTo("CDC") == 0)
        {
            return ft.i;
        }
        if (((String) (obj)).compareTo("Stage") == 0)
        {
            return ft.d;
        } else
        {
            return null;
        }
    }

    public ft c()
    {
        Object obj = nb.a().c();
        mt mt1 = a("Deals");
        int i = ((SharedPreferences) (obj)).getInt("Deals", -1);
        if (i != -1)
        {
            obj = (String)mt1.b().get(i);
        } else
        {
            obj = (String)mt1.b().get(mt1.d());
        }
        if (((String) (obj)).compareTo("Production") == 0)
        {
            return ft.a;
        }
        if (((String) (obj)).compareTo("QA1") == 0)
        {
            return ft.f;
        }
        if (((String) (obj)).compareTo("Prod Like") == 0)
        {
            return ft.b;
        } else
        {
            return null;
        }
    }

    public ft d()
    {
        Object obj = nb.a().c();
        mt mt1 = a("Experience Platform");
        int i = ((SharedPreferences) (obj)).getInt("Experience Platform", -1);
        if (i != -1)
        {
            obj = (String)mt1.b().get(i);
        } else
        {
            obj = (String)mt1.b().get(mt1.d());
        }
        if (((String) (obj)).compareTo("Production") == 0)
        {
            return ft.a;
        }
        if (((String) (obj)).compareTo("QA") == 0)
        {
            return ft.e;
        }
        if (((String) (obj)).compareTo("QA3") == 0)
        {
            return ft.h;
        }
        if (((String) (obj)).compareTo("Prod Like") == 0)
        {
            return ft.b;
        } else
        {
            return null;
        }
    }

    public ft e()
    {
        Object obj = nb.a().c();
        mt mt1 = a("Offers");
        int i = ((SharedPreferences) (obj)).getInt("Offers", -1);
        if (i != -1)
        {
            obj = (String)mt1.b().get(i);
        } else
        {
            obj = (String)mt1.b().get(mt1.d());
        }
        if (((String) (obj)).compareTo("Production") == 0)
        {
            return ft.a;
        }
        if (((String) (obj)).compareTo("QA") == 0)
        {
            return ft.e;
        } else
        {
            return null;
        }
    }

}
