// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.Item;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.a:
//            h, g, ak

public final class aj extends h
{

    private g b;
    private TextView c;
    private TextView d;
    private TextView e;
    private FloatingActionButton f;

    public aj()
    {
    }

    public static aj a()
    {
        return new aj();
    }

    static g a(aj aj1)
    {
        return aj1.b;
    }

    protected final void a(Item item)
    {
label0:
        {
            String s = item.getPostDateAgo();
            if (e != null)
            {
                if (StringUtils.isNotEmpty(s))
                {
                    e.setText(String.format("Posted %s ago", new Object[] {
                        s
                    }));
                } else
                {
                    e.setText("");
                }
            }
            s = item.getTitle();
            if (c != null)
            {
                if (StringUtils.isNotEmpty(s))
                {
                    c.setText(s);
                } else
                {
                    c.setText("");
                }
            }
            item = item.getCategory();
            if (d != null)
            {
                if (!StringUtils.isNotEmpty(item.getName()))
                {
                    break label0;
                }
                d.setText(item.getName());
            }
            return;
        }
        d.setText("");
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            b = (g)activity;
            return;
        }
        catch (Exception exception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement OnShareListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f04008f, viewgroup, false);
        f = (FloatingActionButton)layoutinflater.findViewById(0x7f10021c);
        f.setOnClickListener(new ak(this));
        c = (TextView)layoutinflater.findViewById(0x7f10021d);
        d = (TextView)layoutinflater.findViewById(0x7f10021e);
        e = (TextView)layoutinflater.findViewById(0x7f100221);
        return layoutinflater;
    }
}
