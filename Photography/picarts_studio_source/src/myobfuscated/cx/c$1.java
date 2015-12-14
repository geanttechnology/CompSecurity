// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import com.socialin.android.util.s;
import myobfuscated.cv.c;

// Referenced classes of package myobfuscated.cx:
//            c, a, b

final class it>
    implements android.view..OnClickListener
{

    private b a;
    private ImageView b;
    private myobfuscated.cx.c c;

    public final void onClick(View view)
    {
        if (!s.a(c.a.getActivity()) && !a.e)
        {
            b.setImageResource(a.b);
            myobfuscated.cx.a.k(c.a);
            return;
        }
        myobfuscated.cv.c.a(a.d);
        if (a.f)
        {
            myobfuscated.cx.a.a(c.a, a.d);
            myobfuscated.cx.a.d(c.a).edit().putBoolean(a.a, false).apply();
            return;
        } else
        {
            myobfuscated.cx.a.b(c.a, a.d);
            return;
        }
    }

    View(myobfuscated.cx.c c1, b b1, ImageView imageview)
    {
        c = c1;
        a = b1;
        b = imageview;
        super();
    }
}
