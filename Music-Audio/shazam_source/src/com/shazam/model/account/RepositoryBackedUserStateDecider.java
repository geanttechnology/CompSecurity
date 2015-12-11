// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.account;

import com.shazam.k.t;
import com.shazam.model.configuration.InstallationIdRepository;

// Referenced classes of package com.shazam.model.account:
//            UserStateDecider, UserState

public class RepositoryBackedUserStateDecider
    implements UserStateDecider
{

    private final InstallationIdRepository installationIdRepository;
    private final t userStateRepository;

    public RepositoryBackedUserStateDecider(t t1, InstallationIdRepository installationidrepository)
    {
        userStateRepository = t1;
        installationIdRepository = installationidrepository;
    }

    private boolean a(UserState userstate)
    {
        return userStateRepository.a() == userstate;
    }

    public final boolean a()
    {
        return !installationIdRepository.a() || a(UserState.NEW) || a(UserState.MIGRATION_CANDIDATE) || a(UserState.UNAUTHORIZED);
    }

    public final boolean b()
    {
        return installationIdRepository.a() && (a(UserState.MIGRATION_CANDIDATE) || a(UserState.MIGRATED_AWAITING_CONFIG));
    }

    public final boolean c()
    {
        return installationIdRepository.a() && a(UserState.PENDING_EMAIL_VALIDATION);
    }

    public final boolean d()
    {
        return a() || b() || e() || a(UserState.REGISTERED);
    }

    public final boolean e()
    {
        return userStateRepository.b() || a(UserState.EMAIL_VALIDATED_AWAITING_CONFIG);
    }

    public final boolean f()
    {
        return a(UserState.EMAIL_VALIDATED) || a(UserState.FACEBOOK_VALIDATED);
    }

    public final boolean g()
    {
        return a(UserState.EMAIL_VALIDATED);
    }

    public final boolean h()
    {
        return a(UserState.EMAIL_VALIDATED_AWAITING_CONFIG);
    }
}
