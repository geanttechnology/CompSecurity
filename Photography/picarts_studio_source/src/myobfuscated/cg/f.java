// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cg;

import android.widget.RadioGroup;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;

public final class f
{

    public RadioGroup a;
    public ArrayList b;
    public ArrayList c;
    public EffectParameter d;

    public f()
    {
    }

    public final String a(int i)
    {
        String s = null;
        for (int j = 0; j < b.size(); j++)
        {
            if (i == ((Integer)b.get(j)).intValue())
            {
                s = (String)c.get(j);
            }
        }

        return s;
    }
}
