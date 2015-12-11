// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;


public class EmailAddressInputFilter extends android.text.LoginFilter.UsernameFilterGeneric
{

    public EmailAddressInputFilter()
    {
    }

    public boolean isAllowed(char c)
    {
        while (c <= ' ' || c > '~' || c == '(' || c == ')' || c == '<' || c == '>' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '"' || c == '[' || c == ']') 
        {
            return false;
        }
        return true;
    }
}
