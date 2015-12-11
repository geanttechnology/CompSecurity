// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.availability;

import com.shazam.b.b;
import java.util.List;

public interface AppInstallationVerifier
{

    public static final AppInstallationVerifier NO_OP = (AppInstallationVerifier)b.a(com/shazam/model/availability/AppInstallationVerifier);

    public abstract List a();

    public abstract boolean a(String s);

}
