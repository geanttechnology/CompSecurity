// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSCpmBase

public class DMSPayloadAudio extends DMSCpmBase
{

    public static final int RE_TYPE = 254;
    public static final int S4_TYPE = 255;
    public long id;
    public long timeReported;
    public long type;

    public DMSPayloadAudio(String s)
    {
        super(s);
        type = 0L;
        id = 0L;
        timeReported = 0L;
    }
}
