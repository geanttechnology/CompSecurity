// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ActionProvider;
import android.support.v7.internal.widget.ActivityChooserView;
import android.view.View;
import android.widget.AdapterView;

public class cs
    implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener
{

    final ActivityChooserView a;

    private cs(ActivityChooserView activitychooserview)
    {
        a = activitychooserview;
        super();
    }

    public cs(ActivityChooserView activitychooserview, co co)
    {
        this(activitychooserview);
    }

    private void a()
    {
        if (ActivityChooserView.access$1000(a) != null)
        {
            ActivityChooserView.access$1000(a).onDismiss();
        }
    }

    public void onClick(View view)
    {
        if (view == ActivityChooserView.access$700(a))
        {
            a.dismissPopup();
            view = ActivityChooserView.access$000(a).b();
            int i = ActivityChooserView.access$000(a).e().a(view);
            view = ActivityChooserView.access$000(a).e().b(i);
            if (view != null)
            {
                view.addFlags(0x80000);
                a.getContext().startActivity(view);
            }
            return;
        }
        if (view == ActivityChooserView.access$800(a))
        {
            ActivityChooserView.access$602(a, false);
            ActivityChooserView.access$500(a, ActivityChooserView.access$900(a));
            return;
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public void onDismiss()
    {
        a();
        if (a.mProvider != null)
        {
            a.mProvider.subUiVisibilityChanged(false);
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ((cr)adapterview.getAdapter()).getItemViewType(i);
        JVM INSTR tableswitch 0 1: default 32
    //                   0 50
    //                   1 40;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException();
_L3:
        ActivityChooserView.access$500(a, 0x7fffffff);
_L5:
        return;
_L2:
        a.dismissPopup();
        if (!ActivityChooserView.access$600(a))
        {
            break; /* Loop/switch isn't completed */
        }
        if (i > 0)
        {
            ActivityChooserView.access$000(a).e().c(i);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (!ActivityChooserView.access$000(a).f())
        {
            i++;
        }
        adapterview = ActivityChooserView.access$000(a).e().b(i);
        if (adapterview != null)
        {
            adapterview.addFlags(0x80000);
            a.getContext().startActivity(adapterview);
            return;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public boolean onLongClick(View view)
    {
        if (view == ActivityChooserView.access$700(a))
        {
            if (ActivityChooserView.access$000(a).getCount() > 0)
            {
                ActivityChooserView.access$602(a, true);
                ActivityChooserView.access$500(a, ActivityChooserView.access$900(a));
            }
            return true;
        } else
        {
            throw new IllegalArgumentException();
        }
    }
}
