// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import android.os.Parcel;
import android.os.Parcelable;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.damnhandy.uri.template.UriTemplate;
import com.damnhandy.uri.template.impl.ExpressionParseException;
import com.xfinity.playerlib.model.HalUtils;

public class HalLiveStreamParseable
    implements Parcelable, HalParseable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public HalLiveStreamParseable createFromParcel(Parcel parcel)
        {
            return new HalLiveStreamParseable(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public HalLiveStreamParseable[] newArray(int i)
        {
            return new HalLiveStreamParseable[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected String artworkLink;
    private String playbackLink;
    private String selfLink;
    private String title;
    private String type;

    public HalLiveStreamParseable()
    {
    }

    public HalLiveStreamParseable(Parcel parcel)
    {
        type = parcel.readString();
        title = parcel.readString();
        playbackLink = parcel.readString();
        artworkLink = parcel.readString();
        selfLink = parcel.readString();
    }

    public static String getArtworkUrl(String s, int i, int j)
    {
        String s1;
        try
        {
            s1 = UriTemplate.fromTemplate(s).set("width", Integer.toString(i)).set("height", Integer.toString(j)).expand();
        }
        catch (ExpressionParseException expressionparseexception)
        {
            return s;
        }
        return s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getArtworkLink()
    {
        return artworkLink;
    }

    public String getExpandedArtworkLink(int i, int j)
    {
        return getArtworkUrl(artworkLink, i, j);
    }

    public String getPlaybackLink()
    {
        return playbackLink;
    }

    public String getSelfLink()
    {
        return selfLink;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        playbackLink = microdatapropertyresolver.fetchOptionalLinkAsString("playback");
        artworkLink = HalUtils.resolveOptionalLink("artwork", microdatapropertyresolver);
        selfLink = microdatapropertyresolver.fetchOptionalLinkAsString("self");
        title = microdatapropertyresolver.fetchOptionalString("title");
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(type);
        parcel.writeString(title);
        parcel.writeString(playbackLink);
        parcel.writeString(artworkLink);
        parcel.writeString(selfLink);
    }

}
