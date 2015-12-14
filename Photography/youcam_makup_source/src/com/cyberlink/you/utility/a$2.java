// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.util.Patterns;
import java.util.regex.Matcher;

// Referenced classes of package com.cyberlink.you.utility:
//            c, a

final class 
    implements c
{

    public final String a(Matcher matcher, String s)
    {
        return Patterns.digitsAndPlusOnly(matcher);
    }

    ()
    {
    }
}
