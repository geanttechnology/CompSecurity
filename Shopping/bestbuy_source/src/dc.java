// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.WeddingDateFragment;

public class dc
    implements TextWatcher
{

    final WeddingDateFragment a;
    private EditText b;

    public dc(WeddingDateFragment weddingdatefragment, EditText edittext)
    {
        a = weddingdatefragment;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        b.getId();
        JVM INSTR tableswitch 2131493876 2131493876: default 32
    //                   2131493876 52;
           goto _L1 _L2
_L1:
        if (WeddingDateFragment.c(a))
        {
            WeddingDateFragment.b(a, true);
            return;
        } else
        {
            WeddingDateFragment.b(a, false);
            return;
        }
_L2:
        if (editable.isEmpty())
        {
            WeddingDateFragment.a(a, false);
        } else
        {
            WeddingDateFragment.a(a, true);
        }
          goto _L1
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
