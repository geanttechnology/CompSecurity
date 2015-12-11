// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import java.util.HashSet;

public abstract class SensitiveImageClickListener
    implements android.view.View.OnClickListener
{

    protected final HashSet mExplicitDismissed;
    protected int mPosition;

    public SensitiveImageClickListener(HashSet hashset)
    {
        mExplicitDismissed = hashset;
    }

    public void setPosition(int i)
    {
        mPosition = i;
    }
}
