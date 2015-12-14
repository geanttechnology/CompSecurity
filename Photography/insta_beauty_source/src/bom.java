// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.wantu.setting.FileAdapter;

public class bom
    implements android.view.View.OnClickListener
{

    final FileAdapter a;
    private String b;
    private ImageView c;

    public bom(FileAdapter fileadapter, String s, ImageView imageview)
    {
        a = fileadapter;
        super();
        b = s;
        c = imageview;
    }

    public void onClick(View view)
    {
        if (FileAdapter.access$000(a) != view || !b.equals(FileAdapter.access$100(a)))
        {
            if (a.onSelectedBtnItemCall.b(b))
            {
                Toast.makeText(FileAdapter.access$200(a), 0x7f0600d1, 0).show();
                return;
            }
            if (FileAdapter.access$000(a) != null)
            {
                FileAdapter.access$300(a).setVisibility(4);
                c.setVisibility(0);
                FileAdapter.access$302(a, c);
                FileAdapter.access$002(a, view);
            } else
            {
                FileAdapter.access$302(a, c);
                c.setVisibility(0);
                FileAdapter.access$002(a, view);
            }
            FileAdapter.access$102(a, b);
            if (a.onSelectedBtnItemCall != null)
            {
                a.onSelectedBtnItemCall.a(FileAdapter.access$100(a));
                return;
            }
        }
    }
}
