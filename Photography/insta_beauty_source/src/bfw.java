// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.widget.Button;
import com.wantu.ResourceOnlineLibrary.Manage.SectionGridViewAdapter;

public class bfw
    implements android.content.DialogInterface.OnClickListener
{

    final SectionGridViewAdapter a;

    public bfw(SectionGridViewAdapter sectiongridviewadapter)
    {
        a = sectiongridviewadapter;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (SectionGridViewAdapter.access$000(a) != null)
        {
            dialoginterface = (bfy)SectionGridViewAdapter.access$000(a).getTag();
            if (SectionGridViewAdapter.access$100(a) != null && dialoginterface != null)
            {
                SectionGridViewAdapter.access$100(a).a(((bfy) (dialoginterface)).a, ((bfy) (dialoginterface)).b, ((bfy) (dialoginterface)).c);
            }
        }
    }
}
