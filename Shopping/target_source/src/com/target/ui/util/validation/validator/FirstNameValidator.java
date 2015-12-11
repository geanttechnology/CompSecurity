// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.validator;

import android.content.Context;
import com.target.ui.util.validation.a.e;
import com.target.ui.util.validation.a.i;
import com.target.ui.util.validation.a.k;
import com.target.ui.util.validation.c;
import com.target.ui.util.validation.h;

// Referenced classes of package com.target.ui.util.validation.validator:
//            a

public class FirstNameValidator
    implements a
{

    private static final int FIRST_NAME_MAX_LENGTH = 40;
    private static final int FIRST_NAME_MIN_LENGTH = 1;
    private Context mApplicationContext;

    public FirstNameValidator(Context context)
    {
        mApplicationContext = context.getApplicationContext();
    }

    public k a(String s)
    {
        s = h.a(s, 1, 40);
        if (s.a())
        {
            return new i(true, "");
        } else
        {
            return new i(false, c.a(mApplicationContext, s, 1, 40));
        }
    }
}
