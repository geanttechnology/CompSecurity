// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            ViewBinder

public final class extras
{

    private int callToActionId;
    private int daaIconImageId;
    private Map extras;
    private int iconImageId;
    private final int layoutId;
    private int mainImageId;
    private int textId;
    private int titleId;

    public final extras addExtra(String s, int i)
    {
        extras.put(s, Integer.valueOf(i));
        return this;
    }

    public final extras addExtras(Map map)
    {
        extras = new HashMap(map);
        return this;
    }

    public final ViewBinder build()
    {
        return new ViewBinder(this, null);
    }

    public final extras callToActionId(int i)
    {
        callToActionId = i;
        return this;
    }

    public final callToActionId daaIconImageId(int i)
    {
        daaIconImageId = i;
        return this;
    }

    public final daaIconImageId iconImageId(int i)
    {
        iconImageId = i;
        return this;
    }

    public final iconImageId mainImageId(int i)
    {
        mainImageId = i;
        return this;
    }

    public final mainImageId textId(int i)
    {
        textId = i;
        return this;
    }

    public final textId titleId(int i)
    {
        titleId = i;
        return this;
    }









    public (int i)
    {
        extras = Collections.emptyMap();
        layoutId = i;
        extras = new HashMap();
    }
}
