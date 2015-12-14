// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.AdapterView;
import com.fotoable.fotoproedit.activity.font.FontStyleColorShadowView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelInfo;
import com.fotoable.fotoproedit.activity.font.FontTextureAdapter;
import java.util.ArrayList;

public class ajw
    implements android.widget.AdapterView.OnItemClickListener
{

    final FontStyleColorShadowView a;

    public ajw(FontStyleColorShadowView fontstylecolorshadowview)
    {
        a = fontstylecolorshadowview;
        super();
    }

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
}
