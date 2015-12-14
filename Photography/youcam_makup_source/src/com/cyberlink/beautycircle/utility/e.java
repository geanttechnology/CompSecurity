// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            d

public class e extends LinearLayout
{

    final d a;
    private final View b;
    private final UICImageView c;
    private final TextView d;
    private CircleType e;
    private final ImageView f;

    public e(d d1, Context context)
    {
        a = d1;
        super(context);
        b = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_view_item_category, this);
        c = (UICImageView)findViewById(j.bc_discover_category_view);
        d = (TextView)findViewById(j.bc_discover_category_name);
        f = (ImageView)findViewById(j.bc_new_alert);
    }

    static CircleType a(e e1, CircleType circletype)
    {
        e1.e = circletype;
        return circletype;
    }

    static UICImageView a(e e1)
    {
        return e1.c;
    }

    static TextView b(e e1)
    {
        return e1.d;
    }

    public View a(CircleType circletype)
    {
        e = circletype;
        c.setImageURI(circletype.iconUrl);
        d.setText(circletype.circleTypeName);
        if (circletype.defaultType.equals("HOW-TO") && !Globals.o)
        {
            f.setVisibility(0);
        } else
        {
            f.setVisibility(8);
        }
        return b;
    }

    public void a()
    {
        f.setVisibility(8);
    }

    public String getCategoryDefautlType()
    {
        return e.defaultType;
    }

    public Long getCategoryId()
    {
        return e.id;
    }

    public String getCategoryName()
    {
        return e.circleTypeName;
    }

    public String getCategoryType()
    {
        return e.defaultType;
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            b.setAlpha(0.5F);
            return;
        } else
        {
            b.setAlpha(1.0F);
            return;
        }
    }
}
