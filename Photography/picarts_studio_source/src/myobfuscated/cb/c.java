// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.picsart.shop.a;
import com.socialin.android.d;
import com.socialin.android.util.t;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.cb:
//            a

public class c
{

    private static final String z = myobfuscated/cb/c.getSimpleName();
    private WeakReference A;
    public Object a;
    public int b;
    public String c;
    public String d;
    public String e;
    public Drawable f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public boolean o;
    public com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem p;
    public String q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;
    public String x;
    WeakReference y;

    public c()
    {
        a = null;
        b = 0;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = false;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = true;
        p = null;
        q = null;
        r = false;
        s = null;
        t = null;
        u = null;
        v = null;
        w = -1;
        x = "normal";
    }

    public final View a()
    {
        if (A == null)
        {
            return null;
        } else
        {
            return (View)A.get();
        }
    }

    public final void a(int i1)
    {
        if (i1 >= -1) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L4:
        w = j1;
        return;
_L2:
        j1 = i1;
        if (i1 > 1)
        {
            j1 = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(View view)
    {
        if (view == null)
        {
            A = null;
            return;
        } else
        {
            A = new WeakReference(view);
            return;
        }
    }

    public final boolean a(String s1)
    {
        byte byte0;
        u = s1;
        String s2;
        Object obj;
        Object obj1;
        try
        {
            obj = com.picsart.shop.a.a();
            s2 = (new StringBuilder()).append(((a) (obj)).c).append(u).toString();
            s1 = new RandomAccessFile(s2, "r");
            ((a) (obj)).a.a(s1, s2);
            obj1 = new JSONObject(new String(((a) (obj)).a.a((new StringBuilder()).append(u).append(".json").toString())));
            s2 = ((JSONObject) (obj1)).getString("category_name");
            obj1 = ((JSONObject) (obj1)).getString("category_icon");
            byte abyte0[] = ((a) (obj)).a.a(((String) (obj1)));
            obj = new myobfuscated.cd.a(((a) (obj)).f.getResources(), com.socialin.android.util.c.a(abyte0, abyte0.length));
            abyte0 = k;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            a(1);
            com.socialin.android.d.b(z, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
            });
            return false;
        }
        byte0 = -1;
        abyte0.hashCode();
        JVM INSTR lookupswitch 2: default 335
    //                   796424543: 208
    //                   859810130: 224;
           goto _L1 _L2 _L3
_L5:
        e = s2;
_L4:
        f = ((Drawable) (obj));
        s1.close();
        return true;
_L2:
        if (abyte0.equals("package_mawns_font"))
        {
            byte0 = 0;
        }
          goto _L1
_L3:
        if (abyte0.equals("package_mawns_font_2"))
        {
            byte0 = 1;
        }
          goto _L1
_L6:
        e = "Mawn's Fonts";
          goto _L4
_L7:
        e = "Mawn's Fonts 2";
          goto _L4
        s1;
        com.socialin.android.d.b(a.d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
        });
        return true;
_L1:
        byte0;
        JVM INSTR tableswitch 0 1: default 360
    //                   0 240
    //                   1 290;
           goto _L5 _L6 _L7
    }

    public final void b()
    {
        if (y != null)
        {
            Object obj = (ArrayAdapter)y.get();
            if (obj instanceof myobfuscated.cb.a)
            {
                obj = (myobfuscated.cb.a)obj;
                if (((myobfuscated.cb.a) (obj)).b != null)
                {
                    ((myobfuscated.cb.a) (obj)).b.invalidate();
                }
            }
        }
    }

}
