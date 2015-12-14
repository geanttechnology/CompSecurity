// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.view.View;
import android.widget.AdapterView;
import hf;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontStyleColorShadowView, FontTextLabelInfo, FontTextureAdapter

class a
    implements android.widget.ener
{

    final FontStyleColorShadowView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (FontStyleColorShadowView.access$900(a) != null)
        {
            adapterview = (FontTextLabelInfo)FontStyleColorShadowView.access$1000(a).get(i);
            FontStyleColorShadowView.access$900(a).b(adapterview);
            FontStyleColorShadowView.access$1100(a).setSeclection(i);
            FontStyleColorShadowView.access$1100(a).notifyDataSetChanged();
        }
    }

    (FontStyleColorShadowView fontstylecolorshadowview)
    {
        a = fontstylecolorshadowview;
        super();
    }
}
