// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class <init>
    implements Parcelable
{

    public static final android.os.teCompat.CustomAction._cls1 CREATOR = new _cls1();
    private final String mAction;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;

    public int describeContents()
    {
        return 0;
    }

    public String getAction()
    {
        return mAction;
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public int getIcon()
    {
        return mIcon;
    }

    public CharSequence getName()
    {
        return mName;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Action:mName='").append(mName).append(", mIcon=").append(mIcon).append(", mExtras=").append(mExtras).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mAction);
        TextUtils.writeToParcel(mName, parcel, i);
        parcel.writeInt(mIcon);
        parcel.writeBundle(mExtras);
    }


    private _cls1(Parcel parcel)
    {
        mAction = parcel.readString();
        mName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.el(parcel);
        mIcon = parcel.readInt();
        mExtras = parcel.readBundle();
    }

    mExtras(Parcel parcel, mExtras mextras)
    {
        this(parcel);
    }

    private <init>(String s, CharSequence charsequence, int i, Bundle bundle)
    {
        mAction = s;
        mName = charsequence;
        mIcon = i;
        mExtras = bundle;
    }

    mExtras(String s, CharSequence charsequence, int i, Bundle bundle, mExtras mextras)
    {
        this(s, charsequence, i, bundle);
    }

    class _cls1
        implements android.os.Parcelable.Creator
    {

        public PlaybackStateCompat.CustomAction createFromParcel(Parcel parcel)
        {
            return new PlaybackStateCompat.CustomAction(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PlaybackStateCompat.CustomAction[] newArray(int i)
        {
            return new PlaybackStateCompat.CustomAction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

            _cls1()
            {
            }
    }

}
