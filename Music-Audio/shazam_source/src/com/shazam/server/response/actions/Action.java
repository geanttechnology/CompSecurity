// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.actions;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.actions:
//            ActionType

public class Action
    implements Serializable
{

    public final String href;
    public final String id;
    public final String key;
    public final boolean panel;
    public final ActionType type;
    public final String uri;
}
