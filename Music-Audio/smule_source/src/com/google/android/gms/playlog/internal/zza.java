// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.IInterface;
import java.util.List;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            PlayLoggerContext, LogEvent

public interface zza
    extends IInterface
{

    public abstract void zza(String s, PlayLoggerContext playloggercontext, LogEvent logevent);

    public abstract void zza(String s, PlayLoggerContext playloggercontext, List list);

    public abstract void zza(String s, PlayLoggerContext playloggercontext, byte abyte0[]);
}
