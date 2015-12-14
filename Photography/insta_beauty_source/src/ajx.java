// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.font.FontShadowOutlineEditView;
import com.fotoable.fotoproedit.activity.font.FontStyleColorShadowView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;

public class ajx
    implements ake
{

    final FontStyleColorShadowView a;

    public ajx(FontStyleColorShadowView fontstylecolorshadowview)
    {
        a = fontstylecolorshadowview;
        super();
    }

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
}
