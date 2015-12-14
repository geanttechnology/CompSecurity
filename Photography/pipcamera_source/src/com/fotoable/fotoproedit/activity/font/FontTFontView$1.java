// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.view.View;
import android.widget.AdapterView;
import hb;
import hp;
import hq;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTFontView

public class a
    implements android.widget.emClickListener
{

    final FontTFontView a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        FontTFontView.access$100(a).a(i);
        adapterview = (hb)FontTFontView.access$200(a).get(i);
        if (FontTFontView.access$300(a) != null)
        {
            FontTFontView.access$300(a).a(adapterview);
        }
    }

    (FontTFontView fonttfontview)
    {
        a = fonttfontview;
        super();
    }
}
