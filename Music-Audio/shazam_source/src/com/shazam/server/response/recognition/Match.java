// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.recognition;

import com.shazam.server.legacy.Json;
import java.util.Map;

// Referenced classes of package com.shazam.server.response.recognition:
//            Images

public class Match
{

    public final String beacon = null;
    public final String campaign = null;
    public final String caption = null;
    public final String category = null;
    public final String description = null;
    public final Images images = null;
    public final Json json = null;
    public final String key;
    public final double offset = 0.0D;
    public final Map stores = null;
    public final String title = null;
    public final Integer toastTimeout = null;
    public final String trackId = null;
    public final Map urlParams = null;

    public Match(String s)
    {
        key = s;
    }
}
