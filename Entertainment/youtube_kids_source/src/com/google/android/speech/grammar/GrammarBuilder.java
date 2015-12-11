// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.grammar;

import android.util.Base64;
import day;
import ejj;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.speech.grammar:
//            GrammarToken

public abstract class GrammarBuilder
{

    private static final Pattern ABNF_RESERVED_TOKENS = Pattern.compile("[\\Q/|*+?=;[]()<>${}\"\\\\E]");
    private static final boolean DEBUG = false;
    public static final String SEMANTIC_INTERP_PREFIX = "XX_";
    private static final String TAG = "GrammarBuilder";

    public GrammarBuilder()
    {
    }

    public static String decodeName(String s)
    {
        return new String(Base64.decode(s.substring(s.indexOf("_", 3) + 1), 11));
    }

    public static double decodeWeight(String s)
    {
        return Double.parseDouble(s.substring(3, s.indexOf("_", 3)).replace('P', '.'));
    }

    static String[] getWords(String s)
    {
        return (String[])ejj.a(day.a(stripAbnfTokens(s)), java/lang/String);
    }

    static String stripAbnfTokens(String s)
    {
        return ABNF_RESERVED_TOKENS.matcher(s).replaceAll("");
    }

    public void append(StringBuilder stringbuilder)
    {
        Object obj = getGrammarTokens();
        if (((Collection) (obj)).isEmpty())
        {
            appendEmptyTokensRules(stringbuilder);
            return;
        }
        appendBeforeDisjunctionRules(stringbuilder);
        appendDisjunctionAssignment(stringbuilder);
        obj = ((Collection) (obj)).iterator();
        boolean flag = true;
        GrammarToken grammartoken;
        for (; ((Iterator) (obj)).hasNext(); grammartoken.append(stringbuilder))
        {
            grammartoken = (GrammarToken)((Iterator) (obj)).next();
            if (!flag)
            {
                stringbuilder.append(" | ");
            }
            flag = false;
        }

        stringbuilder.append(";\n");
    }

    protected abstract void appendBeforeDisjunctionRules(StringBuilder stringbuilder);

    protected abstract void appendDisjunctionAssignment(StringBuilder stringbuilder);

    protected abstract void appendEmptyTokensRules(StringBuilder stringbuilder);

    protected abstract Collection getGrammarTokens();

}
