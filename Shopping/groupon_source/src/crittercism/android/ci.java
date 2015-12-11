// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cg, bj, ch, au, 
//            df

public class ci
    implements cg
{
    public static final class a
        implements ch
    {

        public final cg a(bj bj1, bj bj2, String s, Context context, au au, df df)
        {
            return new ci(bj1, bj2);
        }

        public a()
        {
        }
    }


    private bj a;
    private bj b;

    public ci(bj bj1, bj bj2)
    {
        a = bj1;
        b = bj2;
    }

    public void a(boolean flag, int i, JSONObject jsonobject)
    {
        if (flag || i >= 200 && i < 300)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            a.a();
            return;
        } else
        {
            a.a(b);
            return;
        }
    }
}
