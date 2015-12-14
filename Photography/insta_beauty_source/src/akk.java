// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.fotoable.fotoproedit.activity.font.FontTFontView;
import java.util.ArrayList;

public class akk
    implements android.widget.AdapterView.OnItemClickListener
{

    final FontTFontView a;

    public akk(FontTFontView fonttfontview)
    {
        a = fonttfontview;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        FontTFontView.access$100(a).a(i);
        adapterview = (ama)FontTFontView.access$200(a).get(i);
        if (FontTFontView.access$300(a) != null)
        {
            FontTFontView.access$300(a).a(adapterview);
        }
    }
}
