// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class mp
{

    public ImageView a;
    public BBYTextView b;
    public ImageView c;
    public ImageView d;
    public BBYTextView e;
    private BBYTextView f;
    private BBYTextView g;
    private LinearLayout h;
    private View i;
    private RelativeLayout j;
    private RelativeLayout k;
    private LinearLayout l;

    public mp()
    {
    }

    static View a(mp mp1, View view)
    {
        mp1.i = view;
        return view;
    }

    static LinearLayout a(mp mp1, LinearLayout linearlayout)
    {
        mp1.l = linearlayout;
        return linearlayout;
    }

    static RelativeLayout a(mp mp1, RelativeLayout relativelayout)
    {
        mp1.j = relativelayout;
        return relativelayout;
    }

    static BBYTextView a(mp mp1)
    {
        return mp1.f;
    }

    static BBYTextView a(mp mp1, BBYTextView bbytextview)
    {
        mp1.f = bbytextview;
        return bbytextview;
    }

    static LinearLayout b(mp mp1, LinearLayout linearlayout)
    {
        mp1.h = linearlayout;
        return linearlayout;
    }

    static RelativeLayout b(mp mp1, RelativeLayout relativelayout)
    {
        mp1.k = relativelayout;
        return relativelayout;
    }

    static BBYTextView b(mp mp1)
    {
        return mp1.g;
    }

    static BBYTextView b(mp mp1, BBYTextView bbytextview)
    {
        mp1.g = bbytextview;
        return bbytextview;
    }

    static RelativeLayout c(mp mp1)
    {
        return mp1.k;
    }

    static LinearLayout d(mp mp1)
    {
        return mp1.l;
    }

    static RelativeLayout e(mp mp1)
    {
        return mp1.j;
    }

    static LinearLayout f(mp mp1)
    {
        return mp1.h;
    }
}
