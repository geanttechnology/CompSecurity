// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.instamag.activity.commonview.TResTypeItemView;

public class azq
    implements android.view.View.OnClickListener
{

    final TResTypeItemView a;

    public azq(TResTypeItemView trestypeitemview)
    {
        a = trestypeitemview;
        super();
    }

    public void onClick(View view)
    {
        if (!a.isSelected && a.mListener != null)
        {
            a.isSelected = true;
            a.setSelected(a.isSelected);
            a.mListener.a(a.mResType);
        }
    }
}
