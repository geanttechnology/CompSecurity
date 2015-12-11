// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.configuration;

import com.shazam.b.b;

public interface InstallationIdRepository
{

    public static final InstallationIdRepository NO_OP = (InstallationIdRepository)com.shazam.b.b.a(com/shazam/model/configuration/InstallationIdRepository);

    public abstract void a(String s);

    public abstract boolean a();

    public abstract String b();

}
