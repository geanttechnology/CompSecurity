// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            NotificationCompat, RemoteInput

public static final class mExtras
{

    private final Bundle mExtras;
    private final int mIcon;
    private final PendingIntent mIntent;
    private ArrayList mRemoteInputs;
    private final CharSequence mTitle;

    public mExtras build()
    {
        RemoteInput aremoteinput[];
        if (mRemoteInputs != null)
        {
            aremoteinput = (RemoteInput[])mRemoteInputs.toArray(new RemoteInput[mRemoteInputs.size()]);
        } else
        {
            aremoteinput = null;
        }
        return new mRemoteInputs(mIcon, mTitle, mIntent, mExtras, aremoteinput, null);
    }

    public (int i, CharSequence charsequence, PendingIntent pendingintent)
    {
        this(i, charsequence, pendingintent, new Bundle());
    }

    private <init>(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
    {
        mIcon = i;
        mTitle = arSequenceLength(charsequence);
        mIntent = pendingintent;
        mExtras = bundle;
    }
}
