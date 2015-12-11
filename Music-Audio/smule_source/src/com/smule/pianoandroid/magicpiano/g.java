// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.smule.android.c.aa;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.models.AccountIcon;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            DailyChallengeActivity, LeaderboardEntry

class g extends ArrayAdapter
{

    final DailyChallengeActivity a;
    private final LayoutInflater b;
    private Integer c;
    private Long d;

    public g(DailyChallengeActivity dailychallengeactivity, Context context, int i, List list, Integer integer, Long long1)
    {
        a = dailychallengeactivity;
        super(context, i);
        c = integer;
        d = long1;
        a();
        addAll(list);
        b = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private void a()
    {
        if (c != null && (d == null || d.longValue() != 0L))
        {
            add(new com.smule.android.network.models.ContestData.AccountScore());
        }
    }

    public void a(List list, Integer integer, Long long1)
    {
        c = integer;
        d = long1;
        clear();
        a();
        addAll(list);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j;
label0:
        {
            aa.a(DailyChallengeActivity.b(), (new StringBuilder()).append("getView position ").append(i).toString());
            if (view == null)
            {
                view = (LeaderboardEntry)b.inflate(0x7f030039, viewgroup, false);
            } else
            {
                view = (LeaderboardEntry)view;
            }
            viewgroup = (com.smule.android.network.models.ContestData.AccountScore)getItem(i);
            if (i == 0 && c != null && (d == null || d.longValue() != 0L))
            {
                view.a(d, null, c.intValue(), true);
                return view;
            }
            j = i;
            if (c == null)
            {
                break label0;
            }
            if (d != null)
            {
                j = i;
                if (d.longValue() == 0L)
                {
                    break label0;
                }
            }
            j = i - 1;
        }
        long l = j;
        AccountIcon accounticon = ((com.smule.android.network.models.ContestData.AccountScore) (viewgroup)).accountIcon;
        i = ((com.smule.android.network.models.ContestData.AccountScore) (viewgroup)).score.intValue();
        boolean flag;
        if (((com.smule.android.network.models.ContestData.AccountScore) (viewgroup)).accountIcon.accountId == UserManager.n().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.a(Long.valueOf(l), accounticon, i, flag);
        return view;
    }
}
