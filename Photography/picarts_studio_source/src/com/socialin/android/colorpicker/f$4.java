// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.widget.RadioGroup;

// Referenced classes of package com.socialin.android.colorpicker:
//            f

final class a
    implements android.widget.oGroup.OnCheckedChangeListener
{

    private f a;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        f.b(a, i);
    }

    angeListener(f f1)
    {
        a = f1;
        super();
    }
}
