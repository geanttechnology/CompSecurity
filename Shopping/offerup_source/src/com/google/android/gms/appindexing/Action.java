// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.appindexing:
//            Thing

public final class Action extends Thing
{

    public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
    public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
    public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
    public static final String TYPE_ACTIVATE = "http://schema.org/ActivateAction";
    public static final String TYPE_ADD = "http://schema.org/AddAction";
    public static final String TYPE_BOOKMARK = "http://schema.org/BookmarkAction";
    public static final String TYPE_COMMUNICATE = "http://schema.org/CommunicateAction";
    public static final String TYPE_FILM = "http://schema.org/FilmAction";
    public static final String TYPE_LIKE = "http://schema.org/LikeAction";
    public static final String TYPE_LISTEN = "http://schema.org/ListenAction";
    public static final String TYPE_PHOTOGRAPH = "http://schema.org/PhotographAction";
    public static final String TYPE_RESERVE = "http://schema.org/ReserveAction";
    public static final String TYPE_SEARCH = "http://schema.org/SearchAction";
    public static final String TYPE_VIEW = "http://schema.org/ViewAction";
    public static final String TYPE_WANT = "http://schema.org/WantAction";
    public static final String TYPE_WATCH = "http://schema.org/WatchAction";

    private Action(Bundle bundle)
    {
        super(bundle);
    }

    Action(Bundle bundle, _cls1 _pcls1)
    {
        this(bundle);
    }

    public static Action newAction(String s, String s1, Uri uri)
    {
        return newAction(s, s1, null, uri);
    }

    public static Action newAction(String s, String s1, Uri uri, Uri uri1)
    {
        Builder builder = new Builder(s);
        s1 = (new Thing.Builder()).setName(s1);
        if (uri == null)
        {
            s = null;
        } else
        {
            s = uri.toString();
        }
        return builder.setObject(s1.setId(s).setUrl(uri1).build()).build();
    }

    private class Builder extends Thing.Builder
    {

        public final Action build()
        {
            zzx.zzb(zzRj.get("object"), "setObject is required before calling build().");
            zzx.zzb(zzRj.get("type"), "setType is required before calling build().");
            Bundle bundle = (Bundle)zzRj.getParcelable("object");
            zzx.zzb(bundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            zzx.zzb(bundle.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
            return new Action(zzRj, null);
        }

        public final volatile Thing build()
        {
            return build();
        }

        public final Builder put(String s, Thing thing)
        {
            return (Builder)super.put(s, thing);
        }

        public final Builder put(String s, String s1)
        {
            return (Builder)super.put(s, s1);
        }

        public final volatile Thing.Builder put(String s, Thing thing)
        {
            return put(s, thing);
        }

        public final volatile Thing.Builder put(String s, String s1)
        {
            return put(s, s1);
        }

        public final Builder setActionStatus(String s)
        {
            zzx.zzw(s);
            return (Builder)super.put("actionStatus", s);
        }

        public final Builder setName(String s)
        {
            return (Builder)super.put("name", s);
        }

        public final volatile Thing.Builder setName(String s)
        {
            return setName(s);
        }

        public final Builder setObject(Thing thing)
        {
            zzx.zzw(thing);
            return (Builder)super.put("object", thing);
        }

        public final Builder setUrl(Uri uri)
        {
            if (uri != null)
            {
                super.put("url", uri.toString());
            }
            return this;
        }

        public final volatile Thing.Builder setUrl(Uri uri)
        {
            return setUrl(uri);
        }

        public Builder(String s)
        {
            zzx.zzw(s);
            super.put("type", s);
        }
    }

}
