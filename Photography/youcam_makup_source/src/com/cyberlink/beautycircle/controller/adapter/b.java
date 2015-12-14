// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Html;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            m, n

public class b extends com.cyberlink.beautycircle.controller.adapter.m
{

    public Comparator a;
    private Date b;
    private String c;
    private Activity d;

    public b(Activity activity, ViewGroup viewgroup, int k, n n, String s)
    {
        super(activity, viewgroup, k, 20, n);
        a = new Comparator() {

            final b a;

            public int a(com.cyberlink.beautycircle.model.Event.BrandEvent brandevent, com.cyberlink.beautycircle.model.Event.BrandEvent brandevent1)
            {
                boolean flag1 = true;
                boolean flag = false;
                int j1 = brandevent.a(b.a(a));
                int k1 = brandevent1.a(b.a(a));
                int l;
                int i1;
                if (brandevent.priority != null)
                {
                    l = brandevent.priority.intValue();
                } else
                {
                    l = 0;
                }
                if (brandevent1.priority != null)
                {
                    i1 = brandevent1.priority.intValue();
                } else
                {
                    i1 = 0;
                }
                if (l != i1)
                {
                    if (l < i1)
                    {
                        l = 1;
                    } else
                    {
                        l = -1;
                    }
                } else
                {
                    if (j1 != k1)
                    {
                        if (j1 < k1)
                        {
                            l = ((flag1) ? 1 : 0);
                        } else
                        {
                            l = -1;
                        }
                        return l;
                    }
                    l = ((flag) ? 1 : 0);
                    if (brandevent.startTime != null)
                    {
                        l = ((flag) ? 1 : 0);
                        if (brandevent.endTime != null)
                        {
                            l = ((flag) ? 1 : 0);
                            if (brandevent1.startTime != null)
                            {
                                l = ((flag) ? 1 : 0);
                                if (brandevent1.endTime != null)
                                {
                                    if (j1 == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_ONGOING)
                                    {
                                        return brandevent.endTime.compareTo(brandevent1.endTime);
                                    }
                                    if (j1 == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_UPCOMING)
                                    {
                                        return brandevent.startTime.compareTo(brandevent1.startTime);
                                    }
                                    l = ((flag) ? 1 : 0);
                                    if (j1 == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_EXPIRED)
                                    {
                                        return brandevent1.endTime.compareTo(brandevent.endTime);
                                    }
                                }
                            }
                        }
                    }
                }
                return l;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((com.cyberlink.beautycircle.model.Event.BrandEvent)obj, (com.cyberlink.beautycircle.model.Event.BrandEvent)obj1);
            }

            
            {
                a = b.this;
                super();
            }
        };
        if (activity == null)
        {
            throw new NullPointerException("The first parameter cannot be null");
        } else
        {
            d = activity;
            c = s;
            return;
        }
    }

    static Date a(b b1)
    {
        return b1.b;
    }

    static Date a(b b1, Date date)
    {
        b1.b = date;
        return date;
    }

    public void a()
    {
        sort(a);
    }

    protected void a(com.cyberlink.beautycircle.model.Event.BrandEvent brandevent)
    {
    }

    protected void a(com.cyberlink.beautycircle.model.Event.BrandEvent brandevent, View view)
    {
        if (brandevent != null && view != null)
        {
            int k = brandevent.a(b);
            Object obj = (UICImageView)view.findViewById(j.free_sample_image);
            if (obj != null && brandevent.imageUrl != null)
            {
                ((UICImageView) (obj)).setImageURI(brandevent.imageUrl);
            }
            obj = (TextView)view.findViewById(j.free_sample_join_count);
            TextView textview;
            if (obj != null)
            {
                if (k == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_UPCOMING)
                {
                    ((TextView) (obj)).setVisibility(8);
                } else
                {
                    String s = view.getResources().getString(m.bc_freesample_join_count);
                    ((TextView) (obj)).setText(String.format(Locale.getDefault(), s, new Object[] {
                        brandevent.joinNum
                    }));
                    ((TextView) (obj)).setVisibility(0);
                }
            }
            textview = (TextView)view.findViewById(j.free_sample_quantity);
            if (textview != null)
            {
                if (k == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_ONGOING && brandevent.eventType.equals(com.cyberlink.beautycircle.model.Event.BrandEvent.LimitProdNum))
                {
                    obj = view.getResources().getString(m.bc_freesample_quantity_left);
                } else
                {
                    obj = view.getResources().getString(m.bc_freesample_quantity);
                }
                textview.setText(Html.fromHtml(String.format(Locale.getDefault(), ((String) (obj)), new Object[] {
                    brandevent.quantity
                })));
            }
            obj = (TextView)view.findViewById(j.free_sample_duration);
            if (obj != null && b != null && brandevent.startTime != null && brandevent.endTime != null)
            {
                if (k == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_UPCOMING)
                {
                    view = view.getResources().getString(m.bc_freesample_time_to_start);
                    brandevent = i.a(brandevent.startTime, b);
                    ((TextView) (obj)).setText(String.format(Locale.getDefault(), view, new Object[] {
                        ((Pair) (brandevent)).first, ((Pair) (brandevent)).second
                    }));
                    ((TextView) (obj)).setBackgroundResource(com.cyberlink.beautycircle.i.bc_event_upcoming_patch);
                    return;
                }
                if (k == com.cyberlink.beautycircle.model.Event.BrandEvent.EVENT_ONGOING)
                {
                    view = view.getResources().getString(m.bc_freesample_time_remains);
                    brandevent = i.a(brandevent.endTime, b);
                    ((TextView) (obj)).setText(String.format(Locale.getDefault(), view, new Object[] {
                        ((Pair) (brandevent)).first, ((Pair) (brandevent)).second
                    }));
                    ((TextView) (obj)).setBackgroundResource(com.cyberlink.beautycircle.i.bc_event_ongoing_patch);
                    return;
                } else
                {
                    ((TextView) (obj)).setText(view.getResources().getString(m.bc_freesample_end));
                    ((TextView) (obj)).setBackgroundResource(com.cyberlink.beautycircle.i.bc_event_expired_patch);
                    return;
                }
            }
        }
    }

    protected void a(Model model)
    {
        b((com.cyberlink.beautycircle.model.Event.BrandEvent)model);
    }

    protected volatile void a(Model model, View view)
    {
        a((com.cyberlink.beautycircle.model.Event.BrandEvent)model, view);
    }

    protected d b(int k, int l)
    {
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        e.c(new Object[] {
            "listBrandEvent do not have offset parameter."
        });
        return null;
        Object obj;
        try
        {
            obj = (d)NetworkEvent.a(AccountManager.c(), c).a(new com.perfectcorp.utility.j() {

                final b a;

                protected d a(com.cyberlink.beautycircle.model.network.NetworkEvent.ListBrandEventResult listbrandeventresult)
                {
                    b.a(a, listbrandeventresult.currentTime);
                    return listbrandeventresult.b();
                }

                protected volatile Object a(Object obj1)
                {
                    return a((com.cyberlink.beautycircle.model.network.NetworkEvent.ListBrandEventResult)obj1);
                }

                protected void a(int i1)
                {
                    super.a(i1);
                }

            
            {
                a = b.this;
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

    protected void b(com.cyberlink.beautycircle.model.Event.BrandEvent brandevent)
    {
        if (d != null && brandevent != null)
        {
            com.cyberlink.beautycircle.c.a(d, brandevent.id, null, null);
        }
    }

    protected void b(Model model)
    {
        a((com.cyberlink.beautycircle.model.Event.BrandEvent)model);
    }
}
