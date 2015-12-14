// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.io.Serializable;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            BeautyMode, MakeupMode

public class beautyMode
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public BeautyMode beautyMode;
    public final MakeupMode makeupMode;
    public final long tid;
    public final String typeGUID;

    public (long l, String s, MakeupMode makeupmode, BeautyMode beautymode)
    {
        tid = l;
        typeGUID = s;
        makeupMode = makeupmode;
        beautyMode = beautymode;
    }
}
