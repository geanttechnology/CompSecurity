// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.util.Log;
import com.photo.effect.Effect;
import myobfuscated.ck.a;

public class k
{

    public Effect a;
    public myobfuscated.ck.a._cls1 b;

    public k(myobfuscated.ck.a._cls1 _pcls1, Effect effect)
    {
        b = _pcls1;
        a = effect;
        super();
    }

    public void a()
    {
        Log.e("ex1", (new StringBuilder("blendModeAplyed succes = true")).toString());
        myobfuscated.ck.a.a(b.a, a, true);
    }
}
