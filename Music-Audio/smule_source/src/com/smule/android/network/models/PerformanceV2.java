// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.smule.android.network.models:
//            AccountIcon, Round, ArrangementVersion

public class PerformanceV2
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PerformanceV2 a(Parcel parcel)
        {
            return new PerformanceV2(parcel);
        }

        public PerformanceV2[] a(int i)
        {
            return new PerformanceV2[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private static final String a = com/smule/android/network/models/PerformanceV2.getName();
    public AccountIcon accountIcon;
    public String app;
    public String arrKey;
    public ArrangementVersion arrangementVersion;
    public File backgroundTrackFileAbsolutePath;
    public int childCount;
    public boolean closed;
    public String compType;
    public String connectUrl;
    public boolean coprDisabled;
    public String coverUrl;
    public int createdAt;
    public int currentRound;
    public String ensembleType;
    public long expireAt;
    public boolean hasBeenLoved;
    public boolean isPrivate;
    public long lastJoinTs;
    public String longTermRenderedUrl;
    public String message;
    public List nextJoiners;
    public String origTrackInstrumentId;
    public String origTrackOptions;
    public int origTrackPartId;
    public String origTrackUrl;
    public String parentPerformanceKey;
    public String performanceKey;
    public int playerId;
    public List recentTracks;
    public List rounds;
    public boolean seed;
    public String shortTermRenderedUrl;
    public String songUid;
    public String title;
    public int totalComments;
    public int totalListens;
    public int totalLoves;
    public int totalPerformers;
    public boolean video;
    public String videoRenderedUrl;
    public String vocalRenderedUrl;
    public String webUrl;

    public PerformanceV2()
    {
        recentTracks = new ArrayList();
        nextJoiners = new ArrayList();
        rounds = new ArrayList();
        hasBeenLoved = false;
    }

    public PerformanceV2(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        recentTracks = new ArrayList();
        nextJoiners = new ArrayList();
        rounds = new ArrayList();
        hasBeenLoved = false;
        performanceKey = parcel.readString();
        playerId = parcel.readInt();
        accountIcon = (AccountIcon)parcel.readParcelable(com/smule/android/network/models/AccountIcon.getClassLoader());
        songUid = parcel.readString();
        title = parcel.readString();
        message = parcel.readString();
        shortTermRenderedUrl = parcel.readString();
        longTermRenderedUrl = parcel.readString();
        videoRenderedUrl = parcel.readString();
        webUrl = parcel.readString();
        connectUrl = parcel.readString();
        origTrackUrl = parcel.readString();
        coverUrl = parcel.readString();
        totalLoves = parcel.readInt();
        totalComments = parcel.readInt();
        createdAt = parcel.readInt();
        totalPerformers = parcel.readInt();
        origTrackPartId = parcel.readInt();
        recentTracks = parcel.readArrayList(com/smule/android/network/models/AccountIcon.getClassLoader());
        app = parcel.readString();
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPrivate = flag;
        totalListens = parcel.readInt();
        ensembleType = parcel.readString();
        vocalRenderedUrl = parcel.readString();
        origTrackOptions = parcel.readString();
        origTrackInstrumentId = parcel.readString();
        childCount = parcel.readInt();
        currentRound = parcel.readInt();
        lastJoinTs = parcel.readLong();
        nextJoiners = parcel.readArrayList(java/lang/Long.getClassLoader());
        rounds = parcel.readArrayList(com/smule/android/network/models/Round.getClassLoader());
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        seed = flag;
        expireAt = parcel.readLong();
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        closed = flag;
        parentPerformanceKey = parcel.readString();
        compType = parcel.readString();
        arrangementVersion = (ArrangementVersion)parcel.readParcelable(com/smule/android/network/models/ArrangementVersion.getClassLoader());
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        coprDisabled = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        video = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PerformanceV2{performanceKey='").append(performanceKey).append('\'').append(", playerId=").append(playerId).append(", accountIcon=").append(accountIcon).append(", songUid='").append(songUid).append('\'').append(", title='").append(title).append('\'').append(", message='").append(message).append('\'').append(", shortTermRenderedUrl='").append(shortTermRenderedUrl).append('\'').append(", vocalRenderedUrl='").append(vocalRenderedUrl).append('\'').append(", longTermRenderedUrl='").append(longTermRenderedUrl).append('\'').append(", videoRenderedUrl='").append(videoRenderedUrl).append('\'').append(", webUrl='").append(webUrl).append('\'').append(", connectUrl='").append(connectUrl).append('\'').append(", origTrackUrl='").append(origTrackUrl).append('\'').append(", origTrackOptions='").append(origTrackOptions).append('\'').append(", origTrackInstrumentId='").append(origTrackInstrumentId).append('\'').append(", coverUrl='").append(coverUrl).append('\'').append(", totalLoves=").append(totalLoves).append(", totalComments=").append(totalComments).append(", totalPerformers=").append(totalPerformers).append(", createdAt=").append(createdAt).append(", origTrackPartId=").append(origTrackPartId).append(", recentTracks=").append(recentTracks).append(", app='").append(app).append('\'').append(", isPrivate=").append(isPrivate).append(", totalListens=").append(totalListens).append(", ensembleType='").append(ensembleType).append('\'').append(", childCount=").append(childCount).append(", currentRound=").append(currentRound).append(", lastJoinTs=").append(lastJoinTs).append(", nextJoiners=").append(nextJoiners).append(", rounds=").append(rounds).append(", seed=").append(seed).append(", expireAt=").append(expireAt).append(", closed=").append(closed).append(", parentPerformanceKey='").append(parentPerformanceKey).append('\'').append(", compType='").append(compType).append('\'').append(", arrangementVersion=").append(arrangementVersion).append(", coprDisabled=").append(coprDisabled).append(", video=").append(video).append(", backgroundTrackFileAbsolutePath=").append(backgroundTrackFileAbsolutePath).append(", hasBeenLoved=").append(hasBeenLoved).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(performanceKey);
        parcel.writeInt(playerId);
        parcel.writeParcelable(accountIcon, 0);
        parcel.writeString(songUid);
        parcel.writeString(title);
        parcel.writeString(message);
        parcel.writeString(shortTermRenderedUrl);
        parcel.writeString(longTermRenderedUrl);
        parcel.writeString(videoRenderedUrl);
        parcel.writeString(webUrl);
        parcel.writeString(connectUrl);
        parcel.writeString(origTrackUrl);
        parcel.writeString(coverUrl);
        parcel.writeInt(totalLoves);
        parcel.writeInt(totalComments);
        parcel.writeInt(createdAt);
        parcel.writeInt(totalPerformers);
        parcel.writeInt(origTrackPartId);
        parcel.writeList(recentTracks);
        parcel.writeString(app);
        if (isPrivate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(totalListens);
        parcel.writeString(ensembleType);
        parcel.writeString(vocalRenderedUrl);
        parcel.writeString(origTrackOptions);
        parcel.writeString(origTrackInstrumentId);
        parcel.writeInt(childCount);
        parcel.writeInt(currentRound);
        parcel.writeLong(lastJoinTs);
        parcel.writeList(nextJoiners);
        parcel.writeList(rounds);
        if (seed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeLong(expireAt);
        if (closed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(parentPerformanceKey);
        parcel.writeString(compType);
        parcel.writeParcelable(arrangementVersion, 0);
        if (coprDisabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (video)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
