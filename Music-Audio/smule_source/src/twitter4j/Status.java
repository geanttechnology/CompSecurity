// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package twitter4j:
//            EntitySupport, TwitterResponse, GeoLocation, Place, 
//            Scopes, User

public interface Status
    extends Serializable, Comparable, EntitySupport, TwitterResponse
{

    public abstract long[] getContributors();

    public abstract Date getCreatedAt();

    public abstract long getCurrentUserRetweetId();

    public abstract int getFavoriteCount();

    public abstract GeoLocation getGeoLocation();

    public abstract long getId();

    public abstract String getInReplyToScreenName();

    public abstract long getInReplyToStatusId();

    public abstract long getInReplyToUserId();

    public abstract String getLang();

    public abstract Place getPlace();

    public abstract int getRetweetCount();

    public abstract Status getRetweetedStatus();

    public abstract Scopes getScopes();

    public abstract String getSource();

    public abstract String getText();

    public abstract User getUser();

    public abstract String[] getWithheldInCountries();

    public abstract boolean isFavorited();

    public abstract boolean isPossiblySensitive();

    public abstract boolean isRetweet();

    public abstract boolean isRetweeted();

    public abstract boolean isRetweetedByMe();

    public abstract boolean isTruncated();
}
