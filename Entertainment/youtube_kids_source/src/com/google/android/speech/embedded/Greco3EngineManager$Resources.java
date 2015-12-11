// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import eyn;

// Referenced classes of package com.google.android.speech.embedded:
//            Greco3Mode, Greco3Grammar, Greco3ResourceManager

public class languagePack
{

    final String configFile;
    final Greco3Grammar grammarType;
    final eyn languagePack;
    final String locale;
    final Greco3Mode mode;
    final String paths[];
    final Greco3ResourceManager resources;

    public boolean equals(Object obj)
    {
        if (obj instanceof languagePack)
        {
            if (locale.equals(((locale) (obj = (locale)obj)).locale) && mode == ((mode) (obj)).mode && mode == Greco3Mode.GRAMMAR && grammarType == ((grammarType) (obj)).grammarType)
            {
                return true;
            }
        }
        return false;
    }

    boolean isEquivalentTo(String s, Greco3Grammar greco3grammar, Greco3Mode greco3mode)
    {
        return s.equals(locale) && greco3mode == mode && (greco3mode != Greco3Mode.GRAMMAR || greco3grammar == grammarType);
    }

    (Greco3ResourceManager greco3resourcemanager, String s, String s1, Greco3Grammar greco3grammar, Greco3Mode greco3mode, String as[], eyn eyn)
    {
        resources = greco3resourcemanager;
        configFile = s;
        locale = s1;
        grammarType = greco3grammar;
        mode = greco3mode;
        paths = as;
        languagePack = eyn;
    }
}
