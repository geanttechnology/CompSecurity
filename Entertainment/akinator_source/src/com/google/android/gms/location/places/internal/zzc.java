// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.Iterator;
import java.util.List;

public class zzc
{

    public static CharSequence zza(String s, List list, CharacterStyle characterstyle)
    {
        if (characterstyle == null)
        {
            return s;
        }
        s = new SpannableString(s);
        AutocompletePredictionEntity.SubstringEntity substringentity;
        CharacterStyle characterstyle1;
        int i;
        int j;
        for (list = list.iterator(); list.hasNext(); s.setSpan(characterstyle1, i, substringentity.getLength() + j, 0))
        {
            substringentity = (AutocompletePredictionEntity.SubstringEntity)list.next();
            characterstyle1 = CharacterStyle.wrap(characterstyle);
            i = substringentity.getOffset();
            j = substringentity.getOffset();
        }

        return s;
    }
}
