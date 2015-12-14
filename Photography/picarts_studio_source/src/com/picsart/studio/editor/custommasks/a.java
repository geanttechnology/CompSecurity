// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import myobfuscated.bw.d;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o, p

public final class a extends ArrayAdapter
    implements android.view.View.OnHoverListener
{

    public final o a;

    public a(Context context, Activity activity, List list, p p)
    {
        super(context, 0x7f030239, list);
        a = new o(activity, p);
    }

    public final View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getDropDownView(i, view, viewgroup);
        view.setOnHoverListener(this);
        view.setTag(Integer.valueOf(i));
        return view;
    }

    public final boolean onHover(View view, MotionEvent motionevent)
    {
        return a.c.a(view, motionevent);
    }
}
