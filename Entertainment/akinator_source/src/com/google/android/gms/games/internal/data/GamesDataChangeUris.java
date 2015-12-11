// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.data;

import android.net.Uri;

public final class GamesDataChangeUris
{

    private static final Uri zzayY;
    public static final Uri zzayZ;
    public static final Uri zzaza;

    public GamesDataChangeUris()
    {
    }

    static 
    {
        zzayY = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        zzayZ = zzayY.buildUpon().appendPath("invitations").build();
        zzaza = zzayY.buildUpon().appendEncodedPath("players").build();
    }
}
