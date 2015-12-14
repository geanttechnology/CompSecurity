// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.ArrayList;

public class a
    implements android.widget.MultiAutoCompleteTextView.Tokenizer
{

    ArrayList a;

    a()
    {
        a = new ArrayList(1);
        a.add(Character.valueOf(','));
    }

    a(char ac[])
    {
        a = new ArrayList(ac.length);
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            char c = ac[i];
            a.add(Character.valueOf(c));
        }

    }

    public int findTokenEnd(CharSequence charsequence, int i)
    {
        int j;
        for (j = charsequence.length(); i < j; i++)
        {
            if (a.contains(Character.valueOf(charsequence.charAt(i))))
            {
                return i;
            }
        }

        return j;
    }

    public int findTokenStart(CharSequence charsequence, int i)
    {
        int j = i;
        int k;
        do
        {
            k = j;
            if (j <= 0)
            {
                break;
            }
            k = j;
            if (a.contains(Character.valueOf(charsequence.charAt(j - 1))))
            {
                break;
            }
            j--;
        } while (true);
        for (; k < i && charsequence.charAt(k) == ' '; k++) { }
        return k;
    }

    public CharSequence terminateToken(CharSequence charsequence)
    {
        int i;
        for (i = charsequence.length(); i > 0 && charsequence.charAt(i - 1) == ' '; i--) { }
        if (i > 0 && a.contains(Character.valueOf(charsequence.charAt(i - 1))))
        {
            return charsequence;
        }
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        if (a.size() > 1 && ((Character)a.get(0)).charValue() == ' ')
        {
            obj = (Character)a.get(1);
        } else
        {
            obj = (Character)a.get(0);
        }
        obj = stringbuilder.append(obj).append(" ").toString();
        if (charsequence instanceof Spanned)
        {
            obj = new SpannableString((new StringBuilder()).append(charsequence).append(((String) (obj))).toString());
            TextUtils.copySpansFrom((Spanned)charsequence, 0, charsequence.length(), java/lang/Object, ((android.text.Spannable) (obj)), 0);
            return ((CharSequence) (obj));
        } else
        {
            return (new StringBuilder()).append(charsequence).append(((String) (obj))).toString();
        }
    }
}
