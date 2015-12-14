// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.instamag.activity.library.view.MaglibItemView;

public class bdw
    implements android.content.DialogInterface.OnClickListener
{

    final MaglibItemView a;

    public bdw(MaglibItemView maglibitemview)
    {
        a = maglibitemview;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        MaglibItemView.access$200(a, MaglibItemView.access$100(a));
    }
}
