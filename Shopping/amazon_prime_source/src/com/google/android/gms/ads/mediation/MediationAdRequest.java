// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.mediation;

import java.util.Date;
import java.util.Set;

public interface MediationAdRequest
{

    public abstract Date getBirthday();

    public abstract int getGender();

    public abstract Set getKeywords();

    public abstract boolean isTesting();
}
