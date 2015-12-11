// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.ArrayList;

public class l extends t
{

    public ArrayList mInvites;
    public Integer mNext;

    public String toString()
    {
        return (new StringBuilder()).append("ListInvitesResponse{mNext=").append(mNext).append(", mInvites=").append(mInvites).append('}').toString();
    }
}
