// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.k;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.l;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.e;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class f extends com.cyberlink.beautycircle.controller.adapter.m
{

    public Comparator a;
    private Date b;
    private Activity c;
    private String d;

    public f(Activity activity, ViewGroup viewgroup, int i1, n n, String s)
    {
        super(activity, viewgroup, i1, 20, n);
        a = new Comparator() {

            final f a;

            public int a(com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo, com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo1)
            {
                int j1;
                boolean flag;
                boolean flag1;
                int j2;
                int k2;
                flag1 = true;
                flag = false;
                j2 = contestinfo.a(f.a(a));
                k2 = contestinfo1.a(f.a(a));
                int k1;
                if (contestinfo.priority != null)
                {
                    j1 = contestinfo.priority.intValue();
                } else
                {
                    j1 = 0;
                }
                if (contestinfo1.priority != null)
                {
                    k1 = contestinfo1.priority.intValue();
                } else
                {
                    k1 = 0;
                }
                if (j1 == k1) goto _L2; else goto _L1
_L1:
                if (j1 < k1)
                {
                    j1 = 1;
                } else
                {
                    j1 = -1;
                }
_L4:
                return j1;
_L2:
                if (j2 != k2)
                {
                    if (j2 < k2)
                    {
                        j1 = ((flag1) ? 1 : 0);
                    } else
                    {
                        j1 = -1;
                    }
                    return j1;
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo.submitStartDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo.submitEndDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo.voteStartDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo.voteEndDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo1.submitStartDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo1.submitEndDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo1.voteStartDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = ((flag) ? 1 : 0);
                if (contestinfo1.voteEndDate == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (j2 != com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_ONGOING)
                {
                    break; /* Loop/switch isn't completed */
                }
                int l1 = contestinfo1.submitStartDate.compareTo(contestinfo.submitStartDate);
                j1 = l1;
                if (l1 == 0)
                {
                    return contestinfo.submitEndDate.compareTo(contestinfo.submitEndDate);
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (j2 != com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_VOTING)
                {
                    break; /* Loop/switch isn't completed */
                }
                int i2 = contestinfo1.voteStartDate.compareTo(contestinfo.voteStartDate);
                j1 = i2;
                if (i2 == 0)
                {
                    return contestinfo.voteEndDate.compareTo(contestinfo.voteEndDate);
                }
                if (true) goto _L4; else goto _L5
_L5:
                if (j2 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_UPCOMING)
                {
                    return contestinfo.submitStartDate.compareTo(contestinfo1.submitStartDate);
                }
                j1 = ((flag) ? 1 : 0);
                if (j2 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_EXPIRED)
                {
                    return contestinfo1.voteEndDate.compareTo(contestinfo.voteEndDate);
                }
                if (true) goto _L4; else goto _L6
_L6:
            }

            public int compare(Object obj, Object obj1)
            {
                return a((com.cyberlink.beautycircle.model.Contest.ContestInfo)obj, (com.cyberlink.beautycircle.model.Contest.ContestInfo)obj1);
            }

            
            {
                a = f.this;
                super();
            }
        };
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            c = activity;
            d = s;
            return;
        }
    }

    static Date a(f f1)
    {
        return f1.b;
    }

    static Date a(f f1, Date date)
    {
        f1.b = date;
        return date;
    }

    public static void a(e e1)
    {
        if (e1 != null && e1.b != null && e1.c != null)
        {
            long l1 = e1.c.getTime();
            e1 = e1.b.iterator();
            while (e1.hasNext()) 
            {
                com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo = (com.cyberlink.beautycircle.model.Contest.ContestInfo)e1.next();
                if (contestinfo == null || contestinfo.submitStartDate == null)
                {
                    e1.remove();
                } else
                if (contestinfo.submitStartDate.getTime() > l1)
                {
                    e1.remove();
                } else
                {
                    com.perfectcorp.a.b.a(new k("eventshow", Long.toString(contestinfo.id.longValue())));
                }
            }
        }
    }

    public void a()
    {
        sort(a);
    }

    protected void a(com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo)
    {
    }

    protected void a(com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo, View view)
    {
        if (contestinfo != null && view != null)
        {
            int i1 = contestinfo.a(b);
            Object obj = (UICImageView)view.findViewById(j.free_sample_image);
            if (obj != null && contestinfo.thumbnail != null)
            {
                ((UICImageView) (obj)).setImageURI(contestinfo.thumbnail);
            }
            obj = (TextView)view.findViewById(j.free_sample_join_count);
            if (obj != null)
            {
                String s = view.getResources().getString(m.bc_contest_join_count);
                ((TextView) (obj)).setText(Html.fromHtml(String.format(Locale.getDefault(), s, new Object[] {
                    contestinfo.entries
                })));
            }
            obj = (TextView)view.findViewById(j.free_sample_event_description);
            if (obj != null)
            {
                ((TextView) (obj)).setText(contestinfo.description);
            }
            obj = (TextView)view.findViewById(j.contest_event_status);
            View view1;
            if (obj != null)
            {
                ((TextView) (obj)).setVisibility(0);
                int j1 = getPosition(contestinfo);
                if (j1 > 0 && i1 == ((com.cyberlink.beautycircle.model.Contest.ContestInfo)getItem(j1 - 1)).a(b))
                {
                    ((TextView) (obj)).setVisibility(8);
                }
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_UPCOMING)
                {
                    ((TextView) (obj)).setText(m.bc_contest_status_upcoming);
                    ((TextView) (obj)).setBackgroundResource(g.bc_contest_oncomming);
                } else
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_ONGOING)
                {
                    ((TextView) (obj)).setText(m.bc_contest_status_ongoing);
                    ((TextView) (obj)).setBackgroundResource(g.bc_contest_ongoing);
                } else
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_VOTING)
                {
                    ((TextView) (obj)).setText(m.bc_contest_status_voting);
                    ((TextView) (obj)).setBackgroundResource(g.bc_contest_voting);
                } else
                {
                    ((TextView) (obj)).setText(m.bc_contest_status_ended);
                    ((TextView) (obj)).setBackgroundResource(g.bc_contest_end);
                }
            }
            obj = (TextView)view.findViewById(j.free_sample_duration);
            view1 = view.findViewById(j.free_sample_time_icon);
            if (obj != null && view1 != null && b != null)
            {
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_UPCOMING)
                {
                    j1 = i.b(contestinfo.submitStartDate, b);
                    ((TextView) (obj)).setText(view.getResources().getQuantityString(l.bc_contest_duration_pattern_join, j1, new Object[] {
                        Integer.valueOf(j1)
                    }));
                } else
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_ONGOING)
                {
                    int k1 = i.b(contestinfo.submitEndDate, b);
                    ((TextView) (obj)).setText(view.getResources().getQuantityString(l.bc_contest_duration_pattern_join, k1, new Object[] {
                        Integer.valueOf(k1)
                    }));
                } else
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_VOTING)
                {
                    int l1 = i.b(contestinfo.voteEndDate, b);
                    ((TextView) (obj)).setText(view.getResources().getQuantityString(l.bc_contest_duration_pattern_vote, l1, new Object[] {
                        Integer.valueOf(l1)
                    }));
                }
                if (i1 == com.cyberlink.beautycircle.model.Contest.ContestInfo.EVENT_EXPIRED)
                {
                    ((TextView) (obj)).setVisibility(4);
                    view1.setVisibility(4);
                    return;
                } else
                {
                    ((TextView) (obj)).setVisibility(0);
                    view1.setVisibility(0);
                    return;
                }
            }
        }
    }

    protected void a(Model model)
    {
        b((com.cyberlink.beautycircle.model.Contest.ContestInfo)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((com.cyberlink.beautycircle.model.Contest.ContestInfo)model, view);
    }

    protected d b(int i1, int j1)
    {
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        com.perfectcorp.utility.e.c(new Object[] {
            "listContestInfo do not have offset parameter."
        });
        return null;
        Object obj;
        try
        {
            obj = (d)NetworkContest.a(d).a(new com.perfectcorp.utility.j() {

                final f a;

                protected d a(e e1)
                {
                    f.a(e1);
                    f.a(a, e1.c);
                    return e1;
                }

                protected volatile Object a(Object obj1)
                {
                    return a((e)obj1);
                }

                protected void a(int k1)
                {
                    super.a(k1);
                }

            
            {
                a = f.this;
                super();
            }
            }).d();
        }
        catch (CancellationException cancellationexception)
        {
            cancellationexception.printStackTrace();
            cancellationexception = null;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
            interruptedexception = null;
        }
        catch (ExecutionException executionexception)
        {
            executionexception.printStackTrace();
            executionexception = null;
        }
        return ((d) (obj));
    }

    protected void b(com.cyberlink.beautycircle.model.Contest.ContestInfo contestinfo)
    {
        if (c != null && contestinfo != null)
        {
            com.perfectcorp.a.b.a(new k("click", Long.toString(contestinfo.id.longValue())));
        }
        com.cyberlink.beautycircle.c.a(c, contestinfo.id, "contest", false);
    }

    protected void b(Model model)
    {
        a((com.cyberlink.beautycircle.model.Contest.ContestInfo)model);
    }
}
