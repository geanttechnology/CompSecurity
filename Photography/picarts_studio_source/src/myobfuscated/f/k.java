// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.f;

import bo.app.bx;
import bo.app.eo;
import com.appboy.enums.inappmessage.SlideFrom;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.f:
//            f

public final class k extends f
{

    public SlideFrom a;
    public int b;

    public k()
    {
        a = SlideFrom.BOTTOM;
    }

    public k(JSONObject jsonobject, bx bx)
    {
        this(jsonobject, bx, (SlideFrom)eo.a(jsonobject, "slide_from", com/appboy/enums/inappmessage/SlideFrom, SlideFrom.BOTTOM), jsonobject.optInt("close_btn_color"));
    }

    private k(JSONObject jsonobject, bx bx, SlideFrom slidefrom, int i)
    {
        super(jsonobject, bx);
        a = SlideFrom.BOTTOM;
        a = slidefrom;
        if (a == null)
        {
            a = SlideFrom.BOTTOM;
        }
        b = i;
    }
}
