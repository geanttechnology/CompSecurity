// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package jumiomobile:
//            ee

public class eh
    implements TextWatcher
{

    final ee a;

    public eh(ee ee1)
    {
        a = ee1;
        super();
    }

    public void afterTextChanged(Editable editable)
    {
        if (a.getVisibility() == 0)
        {
            a.b();
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
