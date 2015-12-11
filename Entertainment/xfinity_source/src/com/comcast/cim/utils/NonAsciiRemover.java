// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;


public class NonAsciiRemover
{

    public NonAsciiRemover()
    {
    }

    public String convertNonAscii(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        int i = 0;
        while (i < j) 
        {
            char c = s.charAt(i);
            int k = "\300\340\310\350\314\354\322\362\331\371\301\341\311\351\315\355\323\363\332\372\335\375\302\342\312\352\316\356\324\364\333\373\u0176\u0177\303\343\325\365\321\361\304\344\313\353\317\357\326\366\334\374\u0178\377\305\345\307\347\u0150\u0151\u0170\u0171".indexOf(c);
            if (k > -1)
            {
                stringbuilder.append("AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu".charAt(k));
            } else
            {
                stringbuilder.append(c);
            }
            i++;
        }
        return stringbuilder.toString();
    }
}
