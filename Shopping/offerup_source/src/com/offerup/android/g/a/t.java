// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.d;
import com.b.a.a.g;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.offerup.android.dto.ItemDetailLinearLayoutConfig;
import com.offerup.android.gson.GsonManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.a:
//            y, aj, ag, k, 
//            j, u, a

public final class t
{

    private static final String a[] = {
        "seller_profile", "item_actions", "item_condition", "item_description", "item_location", "item_photo", "item_title_and_category"
    };
    private List b;
    private int c;

    public t()
    {
        c = 0;
    }

    private static List b(Context context, int i)
    {
        Object obj1;
        Object obj2;
        List list;
        obj2 = null;
        obj1 = null;
        list = Collections.emptyList();
        context = context.getResources().openRawResource(i);
        Object obj;
        Object obj3;
        Exception exception;
        try
        {
            obj1 = new InputStreamReader(context, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj1 = null;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = null;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
_L1:
            obj = new JsonReader(((java.io.Reader) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = ((ItemDetailLinearLayoutConfig)GsonManager.getGson().fromJson(((JsonReader) (obj)), com/offerup/android/dto/ItemDetailLinearLayoutConfig)).getSections();
        try
        {
            ((JsonReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a("ItemDetailSectionBuilder", ((Exception) (obj)));
        }
        try
        {
            ((InputStreamReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a("ItemDetailSectionBuilder", ((Exception) (obj)));
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.a("ItemDetailSectionBuilder", context);
                return ((List) (obj2));
            }
        }
        return ((List) (obj2));
        obj2;
        obj3 = null;
        obj = null;
        context = ((Context) (obj1));
        obj1 = obj3;
_L4:
        g.a("ItemDetailSectionBuilder", ((Exception) (obj2)));
        if (obj != null)
        {
            try
            {
                ((JsonReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                g.a("ItemDetailSectionBuilder", ((Exception) (obj)));
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStreamReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                g.a("ItemDetailSectionBuilder", ((Exception) (obj)));
            }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.a("ItemDetailSectionBuilder", context);
                return list;
            }
            return list;
        } else
        {
            return list;
        }
        obj;
        obj1 = null;
        context = null;
_L2:
        if (obj2 != null)
        {
            try
            {
                ((JsonReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                g.a("ItemDetailSectionBuilder", ((Exception) (obj2)));
            }
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStreamReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                g.a("ItemDetailSectionBuilder", ((Exception) (obj1)));
            }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.a("ItemDetailSectionBuilder", context);
            }
        }
        throw obj;
        exception;
        obj2 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj2 = obj;
        obj = exception;
        if (true) goto _L2; else goto _L1
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final t a(int i)
    {
        c = 0x7f1000da;
        return this;
    }

    public final t a(Context context, int i)
    {
        b = b(context, i);
        return this;
    }

    public final void a(aa aa1, boolean flag)
    {
        an an1;
        int i;
        if (c == 0)
        {
            g.c("ItemDetailSectionBuilder", "cannot build fragments without container");
            i = 1;
        } else
        {
            i = 0;
        }
        if (b == null || b.isEmpty())
        {
            g.c("ItemDetailSectionBuilder", "cannot build fragments without specifying fragments");
            i = 1;
        }
        if (i != 0)
        {
            return;
        }
        if (flag)
        {
            d.a(aa1);
        }
        an1 = aa1.a();
        i = 0;
        while (i < b.size()) 
        {
            aa1 = (String)b.get(i);
            if ("item_photo".equals(aa1))
            {
                aa1 = y.a();
            } else
            if ("item_title_and_category".equals(aa1))
            {
                aa1 = aj.a();
            } else
            if ("seller_profile".equals(aa1))
            {
                aa1 = ag.a();
            } else
            if ("item_description".equals(aa1))
            {
                aa1 = k.a();
            } else
            if ("item_condition".equals(aa1))
            {
                aa1 = j.a();
            } else
            if ("item_location".equals(aa1))
            {
                aa1 = u.a();
            } else
            if ("item_actions".equals(aa1))
            {
                aa1 = com.offerup.android.g.a.a.a();
            } else
            {
                aa1 = null;
            }
            if (aa1 != null)
            {
                an1.a(c, aa1);
            } else
            {
                g.c("ItemDetailSectionBuilder", String.format("attempted to initialize unknown fragment [%s].  Known fragments are: [%s]", new Object[] {
                    b.get(i), StringUtils.join(a, ",")
                }));
            }
            i++;
        }
        an1.b();
        b.clear();
        c = 0;
    }

}
