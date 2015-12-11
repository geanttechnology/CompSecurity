// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;


// Referenced classes of package com.target.ui.util.validation.a:
//            l

public final class h
    implements l
{

    public static final int REGISTRY_TYPE_INVALID = 1;
    public static final int REGISTRY_TYPE_VALID = 2;
    public final boolean isValid;
    public final int reason;
    public final String registryType;

    public h(String s, boolean flag, int i)
    {
        registryType = s;
        isValid = flag;
        reason = i;
    }

    public boolean a()
    {
        return isValid;
    }
}
