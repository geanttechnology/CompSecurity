// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.fotoable.fotoproedit.activity.font.FontStyleGridView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import java.util.ArrayList;

public class akb
    implements android.widget.AdapterView.OnItemClickListener
{

    final FontStyleGridView a;

    public akb(FontStyleGridView fontstylegridview)
    {
        a = fontstylegridview;
        super();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (FontStyleGridView.access$000(a) != null)
        {
            adapterview = (FontTextLabelInfo)FontStyleGridView.access$100(a).get(i);
            FontStyleGridView.access$000(a).a(adapterview);
            FontStyleGridView.access$200(a).setSeclection(i);
        }
    }
}
