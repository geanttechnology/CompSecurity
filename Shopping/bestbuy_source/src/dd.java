// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.WeddingRegistrySettings;

public class dd
    implements TextWatcher
{

    final WeddingRegistrySettings a;
    private EditText b;

    public dd(WeddingRegistrySettings weddingregistrysettings, EditText edittext)
    {
        a = weddingregistrysettings;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        switch (b.getId())
        {
        default:
            return;

        case 2131493162: 
            break;
        }
        if (editable.isEmpty())
        {
            WeddingRegistrySettings.a(a, false);
            return;
        } else
        {
            WeddingRegistrySettings.a(a, true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
