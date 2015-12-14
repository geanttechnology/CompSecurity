// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cc;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package myobfuscated.cc:
//            b

public final class a
    implements android.view.View.OnClickListener
{

    private Activity a;
    private b b[] = {
        new b(this, 0x7f1001e6, 10, 1), new b(this, 0x7f1001e7, 20, 1), new b(this, 0x7f1001e8, 30, 1), new b(this, 0x7f1001e9, 40, 1), new b(this, 0x7f1001ea, 50, 1), new b(this, 0x7f1001eb, 60, 1), new b(this, 0x7f1001ec, 10, 2), new b(this, 0x7f1001ed, 20, 2), new b(this, 0x7f1001ee, 30, 2), new b(this, 0x7f1001ef, 40, 2), 
        new b(this, 0x7f1001f0, 50, 2), new b(this, 0x7f1001f1, 60, 2)
    };

    public a(Activity activity, int i, int j)
    {
        int k = 0;
        super();
        a = null;
        a = activity;
        for (; k < b.length; k++)
        {
            View view = activity.findViewById(b[k].a);
            if (i == b[k].b && j == b[k].c)
            {
                view.setBackgroundResource(0x7f020556);
            }
            view.setOnClickListener(this);
        }

    }

    public final void onClick(View view)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < b.length)
                {
                    if (b[i].a != view.getId())
                    {
                        break label0;
                    }
                    view = new Intent();
                    view.putExtra("size", b[i].b);
                    view.putExtra("type", b[i].c);
                    a.setResult(-1, view);
                    a.finish();
                }
                return;
            }
            i++;
        } while (true);
    }
}
