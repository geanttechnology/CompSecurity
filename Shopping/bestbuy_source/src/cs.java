// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.EditListDetailsFragment;

public class cs
    implements TextWatcher
{

    EditText a;
    final EditListDetailsFragment b;

    public cs(EditListDetailsFragment editlistdetailsfragment, EditText edittext)
    {
        b = editlistdetailsfragment;
        super();
        a = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
label0:
        {
            editable = editable.toString();
            if (a.getId() == 0x7f0c00e6)
            {
                if (!editable.isEmpty())
                {
                    break label0;
                }
                EditListDetailsFragment.a(b, false);
            }
            return;
        }
        EditListDetailsFragment.a(b, true);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
