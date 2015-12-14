// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import aeg;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.List;

// Referenced classes of package com.fotoable.photoselector.uicomp:
//            DialogChooseDirectory

public class this._cls0 extends ArrayAdapter
{

    final DialogChooseDirectory this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)super.getView(i, view, viewgroup);
        if (a.get(i) == null)
        {
            view.setText("..");
            view.setCompoundDrawablesWithIntrinsicBounds(c.getResources().getDrawable(aeg.ic_parentdir), null, null, null);
            return view;
        } else
        {
            view.setText(((File)a.get(i)).getName());
            view.setCompoundDrawablesWithIntrinsicBounds(c.getResources().getDrawable(aeg.ic_file), null, null, null);
            return view;
        }
    }

    public (int i)
    {
        this$0 = DialogChooseDirectory.this;
        super(c, i, a);
    }
}
