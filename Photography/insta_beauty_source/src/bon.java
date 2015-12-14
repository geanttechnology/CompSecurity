// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import com.wantu.setting.FileAdapter;

public class bon
    implements android.view.View.OnClickListener
{

    final FileAdapter a;
    private String b;
    private FrameLayout c;

    public bon(FileAdapter fileadapter, String s, FrameLayout framelayout)
    {
        a = fileadapter;
        super();
        b = s;
        c = framelayout;
    }

    public void onClick(View view)
    {
        if (FileAdapter.access$400(a) == view && b.equals(FileAdapter.access$100(a)))
        {
            return;
        }
        if (FileAdapter.access$400(a) != null)
        {
            FileAdapter.access$500(a).setVisibility(8);
            c.setVisibility(0);
            FileAdapter.access$502(a, c);
            FileAdapter.access$402(a, view);
        } else
        {
            FileAdapter.access$502(a, c);
            c.setVisibility(8);
            FileAdapter.access$402(a, view);
        }
        FileAdapter.access$602(a, b);
        a.notifyDataSetChanged();
    }
}
