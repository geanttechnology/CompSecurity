// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;

// Referenced classes of package android.support.v4.app:
//            cy

final class da
{

    static Bundle[] a(cy acy[])
    {
        if (acy == null)
        {
            return null;
        }
        Bundle abundle[] = new Bundle[acy.length];
        for (int i = 0; i < acy.length; i++)
        {
            cy cy1 = acy[i];
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", cy1.a());
            bundle.putCharSequence("label", cy1.b());
            bundle.putCharSequenceArray("choices", cy1.c());
            bundle.putBoolean("allowFreeFormInput", cy1.d());
            bundle.putBundle("extras", cy1.e());
            abundle[i] = bundle;
        }

        return abundle;
    }
}
