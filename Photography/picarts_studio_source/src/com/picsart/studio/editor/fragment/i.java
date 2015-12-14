// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            a

public abstract class i extends a
{

    public c g;
    protected Bitmap h;

    public i()
    {
    }

    public void a(Bitmap bitmap)
    {
        h = bitmap;
    }

    public final void a(c c1)
    {
        g = c1;
    }

    protected final ViewGroup b()
    {
        if (getView() != null)
        {
            return (ViewGroup)getView().findViewById(0x7f1003fb);
        } else
        {
            return null;
        }
    }

    public void d()
    {
        g.a(this);
    }

    public abstract Tool e();

    public boolean f()
    {
        return true;
    }

    public final void g()
    {
        a();
    }

    public String h()
    {
        return UUID.randomUUID().toString();
    }

    public void onDetach()
    {
        super.onDetach();
        if (getActivity() instanceof EditorActivity)
        {
            ((EditorActivity)getActivity()).a.remove(this);
        }
    }
}
