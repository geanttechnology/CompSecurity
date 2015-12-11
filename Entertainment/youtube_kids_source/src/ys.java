// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.apps.youtube.kids.activities.SearchActivity;
import com.google.android.apps.youtube.kids.ui.InterstitialLayout;
import com.google.android.apps.youtube.kids.ui.ScrollingSectionListGridView;

public final class ys
    implements mj
{

    private dre a;
    private SearchActivity b;

    public ys(SearchActivity searchactivity)
    {
        b = searchactivity;
        super();
        a = null;
    }

    public ys(SearchActivity searchactivity, dre dre)
    {
        b = searchactivity;
        super();
        a = dre;
    }

    public final void a(Object obj)
    {
        Object obj1;
label0:
        {
            obj1 = (btj)obj;
            if (obj1 != null)
            {
                if (a != null)
                {
                    SearchActivity.a(b, new bvy(b.e().f(), a));
                    b.i.a(SearchActivity.d(b), bwa.c, null);
                }
                b.i.a(SearchActivity.d(b), ((bvz) (obj1)), null);
                b.m();
                if (obj1 != null)
                {
                    b.g.c(true);
                    if (((btj) (obj1)).c() == null)
                    {
                        break label0;
                    }
                    b.a(((btj) (obj1)).c(), true);
                }
            }
            return;
        }
        if (((btj) (obj1)).a.b != null && ((btj) (obj1)).a.b.b != null)
        {
            obj = b;
            obj1 = new bsd(((btj) (obj1)).a.b.b, null);
            ((zj) (obj)).j.d.a(((bsd) (obj1)), true);
            return;
        } else
        {
            obj = b;
            ((zj) (obj)).k();
            obj = ((zj) (obj)).h;
            android.view.View view = ((InterstitialLayout) (obj)).a(((InterstitialLayout) (obj)).b);
            ((InterstitialLayout) (obj)).a(0x7f0b018b, view, 0x7f100136);
            ((InterstitialLayout) (obj)).a(view);
            return;
        }
    }

    public final void a(mp mp)
    {
        b.g.c(false);
        b.a(0x7f0b0188, true);
    }
}
