// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            OnTurnBasedMatchCanceledListener, OnTurnBasedMatchInitiatedListener, OnTurnBasedMatchLeftListener, OnTurnBasedMatchUpdateReceivedListener, 
//            OnTurnBasedMatchUpdatedListener, OnTurnBasedMatchesLoadedListener

public interface TurnBasedMultiplayerListener
    extends OnInvitationReceivedListener, OnTurnBasedMatchCanceledListener, OnTurnBasedMatchInitiatedListener, OnTurnBasedMatchLeftListener, OnTurnBasedMatchUpdateReceivedListener, OnTurnBasedMatchUpdatedListener, OnTurnBasedMatchesLoadedListener
{
}
