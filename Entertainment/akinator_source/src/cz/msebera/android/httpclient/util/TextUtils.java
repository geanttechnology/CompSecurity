// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.util;


public final class TextUtils
{

    public TextUtils()
    {
    }

    public static boolean isBlank(CharSequence charsequence)
    {
        if (charsequence != null)
        {
            int i = 0;
            while (i < charsequence.length()) 
            {
                if (!Character.isWhitespace(charsequence.charAt(i)))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        while (charsequence == null || charsequence.length() == 0) 
        {
            return true;
        }
        return false;
    }
}
