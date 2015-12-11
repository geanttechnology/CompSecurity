// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.b;

import com.shazam.model.store.StoreChoice;
import com.shazam.model.store.StoreChoiceAction;
import com.shazam.server.response.config.Choice;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;

    public a(com.shazam.b.a.a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (Choice)obj;
        com.shazam.model.store.StoreChoice.Builder builder = com.shazam.model.store.StoreChoice.Builder.a();
        builder.key = ((Choice) (obj)).getKey();
        builder.id = ((Choice) (obj)).getId();
        builder.name = ((Choice) (obj)).getName();
        builder.menuIcon = ((Choice) (obj)).getMenuicon();
        builder.trackViewButtonUrl = ((Choice) (obj)).getTrackViewButton();
        builder.tagBarButtonUrl = ((Choice) (obj)).getTagBarButton();
        builder.newsFeedButtonUrl = ((Choice) (obj)).getNewsFeedButton();
        builder.mapsTrackArtUrlPattern = ((Choice) (obj)).getMapsTrackArtUrlPattern();
        builder.storeChoiceAction = (StoreChoiceAction)a.a(((Choice) (obj)).getActions());
        return new StoreChoice(builder, null);
    }
}
