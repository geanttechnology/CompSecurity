// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


final class zzaZg
    implements Runnable
{

    final android.content.references.Editor zzaZg;

    public final void run()
    {
        zzaZg.commit();
    }

    (android.content.references.Editor editor)
    {
        zzaZg = editor;
        super();
    }
}
