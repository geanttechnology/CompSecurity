// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.activity.link.view.LinkBaseView;

public class bis
    implements android.view.View.OnClickListener
{

    LinkBaseView a;
    final LinkBaseView b;

    public bis(LinkBaseView linkbaseview, LinkBaseView linkbaseview1)
    {
        b = linkbaseview;
        super();
        a = linkbaseview1;
    }

    public void onClick(View view)
    {
        if (b.textClickListener != null)
        {
            b.textClickListener.a(view, a);
        }
    }
}
