// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import hf;
import hg;
import hi;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontStyleColorShadowView, FontTextLabelInfo, FontShadowOutlineEditView

class a
    implements hi
{

    final FontStyleColorShadowView a;

    public void a(FontTextLabelInfo fonttextlabelinfo)
    {
        if (FontStyleColorShadowView.access$900(a) != null)
        {
            FontStyleColorShadowView.access$900(a).a(fonttextlabelinfo);
            FontStyleColorShadowView.access$800(a).setShadowNum((int)fonttextlabelinfo.d);
            FontStyleColorShadowView.access$800(a).setStrokeNum((int)fonttextlabelinfo.g);
            if (FontStyleColorShadowView.access$1200(a) != null)
            {
                FontStyleColorShadowView.access$1200(a).a();
            }
        }
    }

    (FontStyleColorShadowView fontstylecolorshadowview)
    {
        a = fontstylecolorshadowview;
        super();
    }
}
