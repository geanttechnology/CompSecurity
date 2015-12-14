// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.data;

import android.net.Uri;

public final class GamesDataChangeUris
{

    public static final Uri zzawA;
    public static final Uri zzawB;
    private static final Uri zzawz;

    public GamesDataChangeUris()
    {
    }

    static 
    {
        zzawz = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        zzawA = zzawz.buildUpon().appendPath("invitations").build();
        zzawB = zzawz.buildUpon().appendEncodedPath("players").build();
    }
}
