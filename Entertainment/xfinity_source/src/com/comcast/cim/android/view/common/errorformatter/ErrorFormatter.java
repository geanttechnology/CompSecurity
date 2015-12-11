// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;


// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            FormattedError

public interface ErrorFormatter
{

    public abstract FormattedError formatError(Throwable throwable);
}
