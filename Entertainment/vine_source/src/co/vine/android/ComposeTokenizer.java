// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.HashSet;

public class ComposeTokenizer
    implements android.widget.MultiAutoCompleteTextView.Tokenizer
{

    public static final String TAGS_ADAPTER = "tags_adapter";
    public static final String USERS_ADAPTER = "users_adapter";
    private static final HashSet mDelimiters;
    private co.vine.android.widget.PopupEditText.PopupEditTextListener mCallback;

    public ComposeTokenizer(co.vine.android.widget.PopupEditText.PopupEditTextListener popupedittextlistener)
    {
        mCallback = popupedittextlistener;
    }

    public int findTokenEnd(CharSequence charsequence, int i)
    {
        int j;
        for (j = charsequence.length(); i < j; i++)
        {
            if (mDelimiters.contains(Character.valueOf(charsequence.charAt(i))))
            {
                return i;
            }
        }

        return j;
    }

    public int findTokenStart(CharSequence charsequence, int i)
    {
        boolean flag1 = true;
        if (i > 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = i;
        char c;
        int k;
        do
        {
            k = j - 1;
            c = charsequence.charAt(k);
            if (k <= 0 || mDelimiters.contains(Character.valueOf(c)) || c == '@')
            {
                break;
            }
            j = k;
        } while (c != '#');
        boolean flag;
        if (c == '@')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (c != '#')
        {
            flag1 = false;
        }
        if (!flag && !flag1 || k != 0 && !mDelimiters.contains(Character.valueOf(charsequence.charAt(k - 1))) && charsequence.charAt(k - 1) != ' ') goto _L1; else goto _L3
_L3:
        if (!flag) goto _L5; else goto _L4
_L4:
        mCallback.setPopupAdapter("users_adapter");
_L7:
        return k;
_L5:
        if (flag1)
        {
            mCallback.setPopupAdapter("tags_adapter");
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public CharSequence terminateToken(CharSequence charsequence)
    {
        if (charsequence instanceof Spanned)
        {
            SpannableString spannablestring = new SpannableString((new StringBuilder()).append(charsequence).append(" ").toString());
            TextUtils.copySpansFrom((Spanned)charsequence, 0, charsequence.length(), java/lang/Object, spannablestring, 0);
            return spannablestring;
        } else
        {
            return (new StringBuilder()).append(charsequence).append(" ").toString();
        }
    }

    static 
    {
        HashSet hashset = new HashSet(32);
        hashset.add(Character.valueOf('\t'));
        hashset.add(Character.valueOf('\n'));
        hashset.add(Character.valueOf('.'));
        hashset.add(Character.valueOf('!'));
        hashset.add(Character.valueOf('?'));
        hashset.add(Character.valueOf(','));
        hashset.add(Character.valueOf(':'));
        hashset.add(Character.valueOf(';'));
        hashset.add(Character.valueOf('\''));
        hashset.add(Character.valueOf('"'));
        hashset.add(Character.valueOf('`'));
        hashset.add(Character.valueOf('/'));
        hashset.add(Character.valueOf('\\'));
        hashset.add(Character.valueOf('-'));
        hashset.add(Character.valueOf('='));
        hashset.add(Character.valueOf('+'));
        hashset.add(Character.valueOf('~'));
        hashset.add(Character.valueOf('$'));
        hashset.add(Character.valueOf('%'));
        hashset.add(Character.valueOf('^'));
        hashset.add(Character.valueOf('&'));
        hashset.add(Character.valueOf('*'));
        hashset.add(Character.valueOf('('));
        hashset.add(Character.valueOf(')'));
        hashset.add(Character.valueOf('['));
        hashset.add(Character.valueOf(']'));
        hashset.add(Character.valueOf('{'));
        hashset.add(Character.valueOf('}'));
        hashset.add(Character.valueOf('<'));
        hashset.add(Character.valueOf('>'));
        hashset.add(Character.valueOf('|'));
        mDelimiters = hashset;
    }
}
