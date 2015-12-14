// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.library.view.LibraryFilterMenuItemView;

public class bdp
    implements android.view.View.OnClickListener
{

    final LibraryFilterMenuItemView a;

    public bdp(LibraryFilterMenuItemView libraryfiltermenuitemview)
    {
        a = libraryfiltermenuitemview;
        super();
    }

    public void onClick(View view)
    {
        if (a.lisener != null)
        {
            a.lisener.a(a.mItemType, a.mPosition);
        }
    }
}
