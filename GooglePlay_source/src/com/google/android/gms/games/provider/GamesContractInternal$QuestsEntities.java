// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.provider;

import android.net.Uri;
import android.provider.BaseColumns;
import com.google.android.gms.common.internal.ClientContext;

// Referenced classes of package com.google.android.gms.games.provider:
//            GamesContractInternal

public static final class 
    implements BaseColumns, com.google.android.gms.games.internal., com.google.android.gms.games.internal.
{

    public static Uri getContentUri(ClientContext clientcontext)
    {
        return ilder(clientcontext, "quest_entities").ext();
    }

    public static Uri getUriForExternalGameId(ClientContext clientcontext, String s)
    {
        return ilder(clientcontext, "quest_entities").ext("ext_game").ext(s).ext();
    }

    public static Uri getUriForExternalQuestId(ClientContext clientcontext, String s)
    {
        return ilder(clientcontext, "quest_entities").ext("ext_quest").ext(s).ext();
    }
}
