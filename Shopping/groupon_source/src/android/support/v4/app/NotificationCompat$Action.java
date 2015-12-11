// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            NotificationCompat, RemoteInput

public static class <init> extends ion
{
    public static final class Builder
    {

        private final Bundle mExtras;
        private final int mIcon;
        private final PendingIntent mIntent;
        private ArrayList mRemoteInputs;
        private final CharSequence mTitle;

        public NotificationCompat.Action build()
        {
            RemoteInput aremoteinput[];
            if (mRemoteInputs != null)
            {
                aremoteinput = (RemoteInput[])mRemoteInputs.toArray(new RemoteInput[mRemoteInputs.size()]);
            } else
            {
                aremoteinput = null;
            }
            return new NotificationCompat.Action(mIcon, mTitle, mIntent, mExtras, aremoteinput, null);
        }

        public Builder(int i, CharSequence charsequence, PendingIntent pendingintent)
        {
            this(i, charsequence, pendingintent, new Bundle());
        }

        private Builder(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle)
        {
            mIcon = i;
            mTitle = NotificationCompat.Builder.limitCharSequenceLength(charsequence);
            mIntent = pendingintent;
            mExtras = bundle;
        }
    }


    public static final ion.Factory FACTORY = new NotificationCompatBase.Action.Factory() {

    };
    public PendingIntent actionIntent;
    public int icon;
    private final Bundle mExtras;
    private final RemoteInput mRemoteInputs[];
    public CharSequence title;

    protected PendingIntent getActionIntent()
    {
        return actionIntent;
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    protected int getIcon()
    {
        return icon;
    }

    public RemoteInput[] getRemoteInputs()
    {
        return mRemoteInputs;
    }

    public volatile teInput[] getRemoteInputs()
    {
        return getRemoteInputs();
    }

    protected CharSequence getTitle()
    {
        return title;
    }


    private _cls1(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle, RemoteInput aremoteinput[])
    {
        icon = i;
        title = .limitCharSequenceLength(charsequence);
        actionIntent = pendingintent;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        mExtras = bundle;
        mRemoteInputs = aremoteinput;
    }

    mRemoteInputs(int i, CharSequence charsequence, PendingIntent pendingintent, Bundle bundle, RemoteInput aremoteinput[], mRemoteInputs mremoteinputs)
    {
        this(i, charsequence, pendingintent, bundle, aremoteinput);
    }
}
