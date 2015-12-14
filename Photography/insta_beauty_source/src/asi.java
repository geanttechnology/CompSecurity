// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.photoselector.model.GroupGridAdapter;

public class asi
    implements android.view.View.OnClickListener
{

    final GroupGridAdapter a;

    public asi(GroupGridAdapter groupgridadapter)
    {
        a = groupgridadapter;
        super();
    }

    public void onClick(View view)
    {
        a.MulttSelectCancel();
    }
}
