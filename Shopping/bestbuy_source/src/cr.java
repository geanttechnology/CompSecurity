// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.registry.CreateWeddingRegistry;

public class cr
    implements TextWatcher
{

    final CreateWeddingRegistry a;
    private EditText b;

    public cr(CreateWeddingRegistry createweddingregistry, EditText edittext)
    {
        a = createweddingregistry;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        b.getId();
        JVM INSTR tableswitch 2131493031 2131493034: default 44
    //                   2131493031 94
    //                   2131493032 125
    //                   2131493033 156
    //                   2131493034 187;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_187;
_L6:
        if (CreateWeddingRegistry.a(a) && CreateWeddingRegistry.b(a) && CreateWeddingRegistry.c(a) && CreateWeddingRegistry.d(a))
        {
            CreateWeddingRegistry.e(a, true);
            return;
        } else
        {
            CreateWeddingRegistry.e(a, false);
            return;
        }
_L2:
        if (editable.isEmpty())
        {
            CreateWeddingRegistry.a(a, false);
        } else
        {
            CreateWeddingRegistry.a(a, true);
        }
          goto _L6
_L3:
        if (editable.isEmpty())
        {
            CreateWeddingRegistry.b(a, false);
        } else
        {
            CreateWeddingRegistry.b(a, true);
        }
          goto _L6
_L4:
        if (editable.isEmpty())
        {
            CreateWeddingRegistry.c(a, false);
        } else
        {
            CreateWeddingRegistry.c(a, true);
        }
          goto _L6
        if (editable.isEmpty())
        {
            CreateWeddingRegistry.d(a, false);
        } else
        {
            CreateWeddingRegistry.d(a, true);
        }
          goto _L6
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
