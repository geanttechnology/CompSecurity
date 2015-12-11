// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SearchActivity;

public final class yr
    implements afv
{

    private SearchActivity a;

    public yr(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final void a(String s)
    {
        bpf bpf1 = SearchActivity.c(a).a();
        bpf1.a(new brj(s));
        SearchActivity.c(a).a(bpf1, new ys(a));
    }
}
