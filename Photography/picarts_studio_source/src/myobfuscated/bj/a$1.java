// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bj;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

// Referenced classes of package myobfuscated.bj:
//            a

final class it>
    implements TextWatcher
{

    private a a;

    public final void afterTextChanged(Editable editable)
    {
        if (myobfuscated.bj.a.a(a) != -1F)
        {
            int i = myobfuscated.bj.a.b(a);
            myobfuscated.bj.a.d(a).removeTextChangedListener(myobfuscated.bj.a.c(a));
            myobfuscated.bj.a.d(a).setText(String.valueOf((int)((float)i * myobfuscated.bj.a.a(a))));
            myobfuscated.bj.a.d(a).addTextChangedListener(myobfuscated.bj.a.c(a));
        }
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ce(a a1)
    {
        a = a1;
        super();
    }
}
