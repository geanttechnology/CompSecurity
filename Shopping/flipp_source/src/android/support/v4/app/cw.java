// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.RemoteInput;

// Referenced classes of package android.support.v4.app:
//            cy

final class cw
{

    static RemoteInput[] a(cy acy[])
    {
        if (acy == null)
        {
            return null;
        }
        RemoteInput aremoteinput[] = new RemoteInput[acy.length];
        for (int i = 0; i < acy.length; i++)
        {
            cy cy1 = acy[i];
            aremoteinput[i] = (new android.app.RemoteInput.Builder(cy1.a())).setLabel(cy1.b()).setChoices(cy1.c()).setAllowFreeFormInput(cy1.d()).addExtras(cy1.e()).build();
        }

        return aremoteinput;
    }
}
