// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;


// Referenced classes of package com.cyberlink.you.utility:
//            b, a

final class 
    implements b
{

    public final boolean a(CharSequence charsequence, int i, int j)
    {
        if (charsequence.subSequence(i, j).toString().matches("[\\x00-\\x7F]+"))
        {
            if (i == 0)
            {
                return true;
            }
            if (charsequence.charAt(i - 1) != '@')
            {
                return true;
            }
        }
        return false;
    }

    ()
    {
    }
}
