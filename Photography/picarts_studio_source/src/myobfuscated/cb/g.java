// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.view.View;
import com.picsart.studio.utils.DynamicHeightImageView;

final class g extends android.support.v7.widget.RecyclerView.ViewHolder
{

    private DynamicHeightImageView a;

    public g(View view)
    {
        super(view);
        a = null;
        a = (DynamicHeightImageView)view;
        a.setHeightRatio(1.0D);
    }

    static DynamicHeightImageView a(g g1)
    {
        return g1.a;
    }
}
