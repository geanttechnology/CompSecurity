// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.pipcamera.activity:
//            ShareEditActivity

class a
    implements TextWatcher
{

    final ShareEditActivity a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ShareEditActivity.a(a);
    }

    (ShareEditActivity shareeditactivity)
    {
        a = shareeditactivity;
        super();
    }
}
