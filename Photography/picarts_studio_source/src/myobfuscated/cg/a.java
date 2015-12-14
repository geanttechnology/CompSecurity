// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.content.Context;
import android.view.View;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.cg:
//            b

public abstract class a
{

    public Context a;
    public ArrayList b;
    public b c;

    public a(Context context, ArrayList arraylist)
    {
        c = null;
        a = context;
        b = EffectParameter.a(arraylist);
    }

    public abstract View a(android.view.ViewGroup.LayoutParams layoutparams);

    public final void a(ArrayList arraylist, boolean flag)
    {
        if (c != null)
        {
            arraylist = EffectParameter.a(arraylist);
            c.a(arraylist, flag);
        }
    }

    public boolean a()
    {
        return false;
    }
}
