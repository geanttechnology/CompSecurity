// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class b
    implements Runnable
{

    final int a;
    final TextView b;
    final MagicActivity c;

    public void run()
    {
        if (a != 0)
        {
            if (b.getVisibility() == 4)
            {
                b.setVisibility(0);
            } else
            {
                MagicActivity.a(c, b, null);
            }
            b.setText(c.getString(a));
            MagicActivity.b(c, b);
            return;
        } else
        {
            MagicActivity.a(c, b, new Runnable() {

                final MagicActivity._cls12 a;

                public void run()
                {
                    a.b.setText("");
                }

            
            {
                a = MagicActivity._cls12.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(MagicActivity magicactivity, int i, TextView textview)
    {
        c = magicactivity;
        a = i;
        b = textview;
        super();
    }
}
