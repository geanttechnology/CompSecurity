// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import android.graphics.Bitmap;
import android.net.Uri;
import bo.app.bx;
import bo.app.ct;
import bo.app.eo;
import bo.app.ep;
import com.appboy.Constants;
import com.appboy.enums.inappmessage.ClickAction;
import com.appboy.enums.inappmessage.DismissType;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.i.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.f:
//            a, e

public abstract class f
    implements myobfuscated.f.a, e
{

    protected static final String c;
    private Map a;
    private boolean b;
    public String d;
    public ClickAction e;
    protected String f;
    protected String g;
    protected bx h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public Bitmap n;
    private boolean o;
    private Uri p;
    private DismissType q;
    private int r;
    private JSONObject s;
    private boolean t;
    private boolean u;
    private String v;
    private boolean w;

    protected f()
    {
        b = true;
        o = true;
        e = ClickAction.NONE;
        q = DismissType.AUTO_DISMISS;
        r = 5000;
        t = false;
        u = false;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        w = false;
    }

    private f(String s1, Map map, ClickAction clickaction, String s2, int i1, int j1, int k1, 
            int l1, String s3, String s4, DismissType dismisstype, int i2, String s5, String s6, 
            JSONObject jsonobject, bx bx1)
    {
        b = true;
        o = true;
        e = ClickAction.NONE;
        q = DismissType.AUTO_DISMISS;
        r = 5000;
        t = false;
        u = false;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        w = false;
        d = s1;
        a = map;
        b = true;
        o = true;
        e = clickaction;
        if (e == ClickAction.URI && !ep.c(s2))
        {
            p = Uri.parse(s2);
        }
        if (dismisstype == DismissType.SWIPE)
        {
            q = DismissType.MANUAL;
        } else
        {
            q = dismisstype;
        }
        if (i2 < 999)
        {
            r = 5000;
            myobfuscated.i.a.b(c, (new StringBuilder("Requested in-app message duration ")).append(i2).append(" is lower than the minimum of 999. Defaulting to ").append(r).append(" milliseconds.").toString());
        } else
        {
            r = i2;
            myobfuscated.i.a.a(c, (new StringBuilder("Set in-app message duration to ")).append(r).append(" milliseconds.").toString());
        }
        i = i1;
        k = j1;
        l = k1;
        j = l1;
        m = s3;
        v = s4;
        f = s5;
        g = s6;
        s = jsonobject;
        t = false;
        u = false;
        h = bx1;
    }

    public f(JSONObject jsonobject, bx bx1)
    {
        this(jsonobject.optString("message"), eo.a(jsonobject.optJSONObject("extras"), new HashMap()), (ClickAction)eo.a(jsonobject, "click_action", com/appboy/enums/inappmessage/ClickAction, ClickAction.NONE), jsonobject.optString("uri"), jsonobject.optInt("bg_color"), jsonobject.optInt("icon_color"), jsonobject.optInt("icon_bg_color"), jsonobject.optInt("text_color"), jsonobject.optString("icon"), jsonobject.optString("image_url"), (DismissType)eo.a(jsonobject, "message_close", com/appboy/enums/inappmessage/DismissType, DismissType.AUTO_DISMISS), jsonobject.optInt("duration"), jsonobject.optString("campaign_id"), jsonobject.optString("card_id"), jsonobject, bx1);
    }

    public final String a()
    {
        return d;
    }

    public final void a(Bitmap bitmap)
    {
        n = bitmap;
    }

    public final void a(boolean flag)
    {
        o = flag;
    }

    public final Map b()
    {
        return a;
    }

    public final int c()
    {
        return r;
    }

    public final int d()
    {
        return i;
    }

    public final int e()
    {
        return k;
    }

    public final int f()
    {
        return l;
    }

    public volatile Object forJsonPut()
    {
        return s;
    }

    public final int g()
    {
        return j;
    }

    public final String h()
    {
        return m;
    }

    public final String i()
    {
        return v;
    }

    public final boolean j()
    {
        return b;
    }

    public final boolean k()
    {
        return o;
    }

    public final ClickAction l()
    {
        return e;
    }

    public final Uri m()
    {
        return p;
    }

    public final Bitmap n()
    {
        return n;
    }

    public final DismissType o()
    {
        return q;
    }

    public final boolean p()
    {
        return w;
    }

    public final void q()
    {
        b = false;
    }

    public final void r()
    {
        w = true;
    }

    public final boolean s()
    {
        while (ep.b(f) && ep.b(g) || t) 
        {
            return false;
        }
        if (h == null)
        {
            myobfuscated.i.a.c(c, "Cannot log an in-app message impression because the AppboyManager is null.");
            return false;
        }
        try
        {
            ct ct1 = ct.c(f, g);
            h.a(ct1);
            t = true;
        }
        catch (JSONException jsonexception)
        {
            h.a(jsonexception);
            return false;
        }
        return true;
    }

    public final boolean t()
    {
        if (ep.b(f) && ep.b(g))
        {
            return false;
        }
        if (u)
        {
            myobfuscated.i.a.a(c, "Click already logged for this in-app message. Ignoring.");
            return false;
        }
        if (h == null)
        {
            myobfuscated.i.a.c(c, "Cannot log a in-app message click because the AppboyManager is null.");
            return false;
        }
        try
        {
            ct ct1 = ct.d(f, g);
            h.a(ct1);
            u = true;
        }
        catch (JSONException jsonexception)
        {
            h.a(jsonexception);
            return false;
        }
        return true;
    }

    static 
    {
        c = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/f/f.getName()
        });
    }
}
