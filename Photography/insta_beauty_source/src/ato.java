// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.savepagescrollview.ShareScrolladView;

public class ato
    implements android.view.View.OnClickListener
{

    final ShareScrolladView a;

    public ato(ShareScrolladView sharescrolladview)
    {
        a = sharescrolladview;
        super();
    }

    public void onClick(View view)
    {
        if (ShareScrolladView.access$000(a) != view)
        {
            if (ShareScrolladView.access$000(a) != null)
            {
                ShareScrolladView.access$000(a).setSelected(false);
            }
            ShareScrolladView.access$002(a, view);
        }
        view.setSelected(true);
        if (ShareScrolladView.access$100(a) != null)
        {
            ShareScrolladView.access$100(a).a((String)view.getTag(), a);
        }
    }
}
