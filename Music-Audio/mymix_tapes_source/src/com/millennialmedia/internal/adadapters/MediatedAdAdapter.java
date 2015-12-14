// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;


public interface MediatedAdAdapter
{
    public static class MediationInfo
    {

        public String siteId;
        public String spaceId;

        public MediationInfo(String s, String s1)
        {
            siteId = s;
            spaceId = s1;
        }
    }


    public abstract void setMediationInfo(MediationInfo mediationinfo);
}
