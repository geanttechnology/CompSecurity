// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import dt;
import du;
import hu;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextTouchView

class a
    implements du
{

    final FontTextTouchView a;

    public boolean a(dt dt1)
    {
        float f = dt1.b();
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
            FontTextTouchView.access$000(a).b(f);
        }
        return true;
    }

    public boolean b(dt dt1)
    {
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
        }
        return true;
    }

    public void c(dt dt1)
    {
        if (FontTextTouchView.access$000(a) != null)
        {
            FontTextTouchView.access$000(a).b();
        }
    }

    (FontTextTouchView fonttexttouchview)
    {
        a = fonttexttouchview;
        super();
    }
}
