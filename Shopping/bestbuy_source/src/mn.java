// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class mn
{

    private LinearLayout a;
    private LinearLayout b;
    private LinearLayout c;
    private RelativeLayout d;
    private BBYTextView e;

    public mn()
    {
    }

    static LinearLayout a(mn mn1, LinearLayout linearlayout)
    {
        mn1.a = linearlayout;
        return linearlayout;
    }

    static RelativeLayout a(mn mn1, RelativeLayout relativelayout)
    {
        mn1.d = relativelayout;
        return relativelayout;
    }

    static BBYTextView a(mn mn1)
    {
        return mn1.e;
    }

    static BBYTextView a(mn mn1, BBYTextView bbytextview)
    {
        mn1.e = bbytextview;
        return bbytextview;
    }

    static LinearLayout b(mn mn1, LinearLayout linearlayout)
    {
        mn1.b = linearlayout;
        return linearlayout;
    }

    static RelativeLayout b(mn mn1)
    {
        return mn1.d;
    }

    static LinearLayout c(mn mn1)
    {
        return mn1.a;
    }

    static LinearLayout c(mn mn1, LinearLayout linearlayout)
    {
        mn1.c = linearlayout;
        return linearlayout;
    }

    static LinearLayout d(mn mn1)
    {
        return mn1.b;
    }

    static LinearLayout e(mn mn1)
    {
        return mn1.c;
    }
}
