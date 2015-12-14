// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import he;
import mm;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontShadowOutlineEditView

class a
    implements mm
{

    final FontShadowOutlineEditView a;

    public void TouchBegin()
    {
    }

    public void TouchEnd()
    {
    }

    public void onColorSelector(int i)
    {
        if (FontShadowOutlineEditView.access$000(a) != null)
        {
            FontShadowOutlineEditView.access$000(a).c(i);
        }
    }

    (FontShadowOutlineEditView fontshadowoutlineeditview)
    {
        a = fontshadowoutlineeditview;
        super();
    }
}
