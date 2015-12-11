// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.location.SimpleLocation;
import com.shazam.model.post.Post;

// Referenced classes of package com.shazam.model:
//            Identifiable, Track, Art, TagContext

public class Tag
    implements Identifiable
{
    public static class Builder
    {

        public String dateTime;
        public String eventId;
        private String facebookUserId;
        public Double frequencySkew;
        private String installedAppId;
        public String json;
        public SimpleLocation location;
        public String locationName;
        public Double lyricOffset;
        public Double lyricSkew;
        private Post post;
        public String requestId;
        private String requestResultsType;
        public String shortDateTime;
        public byte sig[];
        public Status status;
        public TagContext tagContext;
        public long timestamp;
        public Track track;
        private String ueeUserId;
        public boolean unread;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(Tag tag)
        {
            Builder builder = new Builder();
            builder.requestId = tag.requestId;
            builder.track = tag.track;
            builder.dateTime = tag.dateTime;
            builder.shortDateTime = tag.shortDateTime;
            builder.timestamp = tag.timestamp;
            builder.sig = tag.sig;
            builder.status = tag.status;
            builder.location = tag.location;
            builder.locationName = tag.locationName;
            builder.lyricOffset = tag.lyricOffset;
            builder.lyricSkew = tag.lyricSkew;
            builder.frequencySkew = tag.frequencySkew;
            builder.eventId = tag.eventId;
            builder.unread = tag.unread;
            builder.facebookUserId = tag.facebookUserId;
            builder.installedAppId = tag.installedAppId;
            builder.requestResultsType = tag.requestResultsType;
            builder.ueeUserId = tag.ueeUserId;
            builder.tagContext = tag.tagContext;
            builder.json = tag.json;
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.requestId;
        }

        static Track b(Builder builder)
        {
            return builder.track;
        }

        static String c(Builder builder)
        {
            return builder.dateTime;
        }

        static String d(Builder builder)
        {
            return builder.shortDateTime;
        }

        static long e(Builder builder)
        {
            return builder.timestamp;
        }

        static byte[] f(Builder builder)
        {
            return builder.sig;
        }

        static Status g(Builder builder)
        {
            return builder.status;
        }

        static String h(Builder builder)
        {
            return builder.locationName;
        }

        static SimpleLocation i(Builder builder)
        {
            return builder.location;
        }

        static Double j(Builder builder)
        {
            return builder.lyricOffset;
        }

        static Double k(Builder builder)
        {
            return builder.lyricSkew;
        }

        static Double l(Builder builder)
        {
            return builder.frequencySkew;
        }

        static String m(Builder builder)
        {
            return builder.eventId;
        }

        static boolean n(Builder builder)
        {
            return builder.unread;
        }

        static String o(Builder builder)
        {
            return builder.ueeUserId;
        }

        static String p(Builder builder)
        {
            return builder.facebookUserId;
        }

        static String q(Builder builder)
        {
            return builder.installedAppId;
        }

        static String r(Builder builder)
        {
            return builder.requestResultsType;
        }

        static TagContext s(Builder builder)
        {
            return builder.tagContext;
        }

        static String t(Builder builder)
        {
            return builder.json;
        }

        static Post u(Builder builder)
        {
            return builder.post;
        }

        public final Tag b()
        {
            return new Tag(this, null);
        }

        private Builder()
        {
        }
    }

    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status BEAMED;
        public static final Status FROM_BACKUP;
        public static final Status MANUALLY_ADDED;
        public static final Status SUCCESSFUL;
        public static final Status UNKNOWN;
        public static final Status UNSUBMITTED;
        public static final Status UNSUCCESSFUL;
        public static final Status VISUAL;
        private final String dbString;

        public static Status getStatusForName(String s, Status status1)
        {
            Status astatus[] = values();
            int j = astatus.length;
            int i = 0;
            do
            {
label0:
                {
                    Status status2 = status1;
                    if (i < j)
                    {
                        status2 = astatus[i];
                        if (!status2.dbString.equals(s))
                        {
                            break label0;
                        }
                    }
                    return status2;
                }
                i++;
            } while (true);
        }

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/shazam/model/Tag$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        public final String getDbString()
        {
            return dbString;
        }

        public final boolean isLyricPlayAllowed()
        {
            return this == SUCCESSFUL;
        }

        static 
        {
            UNKNOWN = new Status("UNKNOWN", 0, "UNKNOWN");
            BEAMED = new Status("BEAMED", 1, "BEAMED");
            UNSUBMITTED = new Status("UNSUBMITTED", 2, "UNSUBMITTED");
            SUCCESSFUL = new Status("SUCCESSFUL", 3, "SUCCESSFUL");
            UNSUCCESSFUL = new Status("UNSUCCESSFUL", 4, "UNSUCCESSFUL");
            MANUALLY_ADDED = new Status("MANUALLY_ADDED", 5, "MANUALLY_ADDED");
            FROM_BACKUP = new Status("FROM_BACKUP", 6, "FROM_BACKUP");
            VISUAL = new Status("VISUAL", 7, "VISUAL");
            $VALUES = (new Status[] {
                UNKNOWN, BEAMED, UNSUBMITTED, SUCCESSFUL, UNSUCCESSFUL, MANUALLY_ADDED, FROM_BACKUP, VISUAL
            });
        }

        private Status(String s, int i, String s1)
        {
            super(s, i);
            dbString = s1;
        }
    }


    public String dateTime;
    public String eventId;
    String facebookUserId;
    private boolean firstLaunch;
    public Double frequencySkew;
    String installedAppId;
    public String json;
    public SimpleLocation location;
    public String locationName;
    public Double lyricOffset;
    public Double lyricSkew;
    public Post post;
    public String requestId;
    String requestResultsType;
    public String shortDateTime;
    public byte sig[];
    public Status status;
    public TagContext tagContext;
    public long timestamp;
    public Track track;
    String ueeUserId;
    public boolean unread;

    public Tag()
    {
    }

    private Tag(Builder builder)
    {
        requestId = Builder.a(builder);
        track = Builder.b(builder);
        dateTime = Builder.c(builder);
        shortDateTime = Builder.d(builder);
        timestamp = Builder.e(builder);
        sig = Builder.f(builder);
        status = Builder.g(builder);
        locationName = Builder.h(builder);
        location = Builder.i(builder);
        lyricOffset = Builder.j(builder);
        lyricSkew = Builder.k(builder);
        frequencySkew = Builder.l(builder);
        eventId = Builder.m(builder);
        unread = Builder.n(builder);
        ueeUserId = Builder.o(builder);
        facebookUserId = Builder.p(builder);
        installedAppId = Builder.q(builder);
        requestResultsType = Builder.r(builder);
        tagContext = Builder.s(builder);
        json = Builder.t(builder);
        post = Builder.u(builder);
    }

    Tag(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final String a()
    {
        return requestId;
    }

    public final String b()
    {
        Art art;
        if (track == null)
        {
            art = null;
        } else
        {
            art = track.art;
        }
        if (art == null)
        {
            return null;
        } else
        {
            return art.url;
        }
    }
}
