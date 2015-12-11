// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation.a;


// Referenced classes of package com.target.ui.util.validation.a:
//            k

public final class i
    implements k
{

    private final boolean mIsValid;
    private final String mSuggestedErrorMessage;

    public i(boolean flag, String s)
    {
        mIsValid = flag;
        mSuggestedErrorMessage = s;
    }

    public boolean a()
    {
        return mIsValid;
    }

    public String b()
    {
        return mSuggestedErrorMessage;
    }
}
