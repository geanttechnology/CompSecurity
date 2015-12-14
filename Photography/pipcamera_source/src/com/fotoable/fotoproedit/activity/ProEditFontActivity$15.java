// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements TextWatcher
{

    final ProEditFontActivity a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (ProEditFontActivity.n(a) != null && !ProEditFontActivity.E(a))
        {
            ProEditFontActivity.n(a).setLabelTextStr(charsequence.toString());
            ProEditFontActivity.n(a).onTextCreate();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
            ProEditFontActivity.g(a);
            return;
        } else
        {
            ProEditFontActivity.e(a, false);
            return;
        }
    }

    (ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
