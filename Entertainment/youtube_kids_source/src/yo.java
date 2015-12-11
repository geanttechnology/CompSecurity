// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.SearchActivity;

public final class yo
    implements android.view.View.OnClickListener
{

    private SearchActivity a;

    public yo(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final void onClick(View view)
    {
        SearchActivity.a(a);
    }
}
