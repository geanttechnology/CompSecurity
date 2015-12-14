// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import android.net.Uri;
import bo.app.eo;
import bo.app.ep;
import com.appboy.Constants;
import com.appboy.enums.inappmessage.ClickAction;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.f:
//            e

public class l
    implements e
{

    public int a;
    public ClickAction b;
    public Uri c;
    public String d;
    public int e;
    public int f;
    private JSONObject g;

    public l()
    {
        a = -1;
        b = ClickAction.NONE;
        e = 0;
        f = 0;
    }

    public l(JSONObject jsonobject)
    {
        this(jsonobject, jsonobject.optInt("id", -1), (ClickAction)eo.a(jsonobject, "click_action", com/appboy/enums/inappmessage/ClickAction, ClickAction.NEWS_FEED), jsonobject.optString("uri"), jsonobject.optString("text"), jsonobject.optInt("bg_color"), jsonobject.optInt("text_color"));
    }

    private l(JSONObject jsonobject, int i, ClickAction clickaction, String s, String s1, int j, int k)
    {
        a = -1;
        b = ClickAction.NONE;
        e = 0;
        f = 0;
        g = jsonobject;
        a = i;
        b = clickaction;
        if (b == ClickAction.URI && !ep.c(s))
        {
            c = Uri.parse(s);
        }
        d = s1;
        e = j;
        f = k;
    }

    public volatile Object forJsonPut()
    {
        return g;
    }

    static 
    {
        String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/f/l.getName()
        });
    }
}
