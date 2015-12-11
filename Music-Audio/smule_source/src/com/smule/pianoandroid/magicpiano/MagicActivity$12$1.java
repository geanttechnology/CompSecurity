// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.setText("");
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/MagicActivity$12

/* anonymous class */
    class MagicActivity._cls12
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
                MagicActivity.a(c, b, new MagicActivity._cls12._cls1(this));
                return;
            }
        }

            
            {
                c = magicactivity;
                a = i;
                b = textview;
                super();
            }
    }

}
