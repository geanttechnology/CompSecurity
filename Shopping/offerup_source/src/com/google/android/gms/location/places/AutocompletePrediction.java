// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AutocompletePrediction
    extends Freezable
{

    public abstract String getDescription();

    public abstract CharSequence getFullText(CharacterStyle characterstyle);

    public abstract List getMatchedSubstrings();

    public abstract String getPlaceId();

    public abstract List getPlaceTypes();

    public abstract CharSequence getPrimaryText(CharacterStyle characterstyle);

    public abstract CharSequence getSecondaryText(CharacterStyle characterstyle);
}
