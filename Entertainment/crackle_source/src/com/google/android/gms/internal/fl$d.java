// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            fk, fl, eg

final class  extends fk
{

    private final com.google.android.gms.common.api. jW;
    final fl tZ;

    public void onAchievementUpdated(int i, String s)
    {
        tZ.a(new <init>(tZ, jW, i, s));
    }

    (fl fl1, com.google.android.gms.common.api. )
    {
        tZ = fl1;
        super();
        jW = (com.google.android.gms.common.api.)eg.b(, "Holder must not be null");
    }
}
