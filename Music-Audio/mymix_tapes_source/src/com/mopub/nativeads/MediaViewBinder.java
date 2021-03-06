// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediaViewBinder
{
    public static final class Builder
    {

        private int callToActionId;
        private Map extras;
        private int iconImageId;
        private final int layoutId;
        private int mediaLayoutId;
        private int privacyInformationIconImageId;
        private int textId;
        private int titleId;

        public final Builder addExtra(String s, int i)
        {
            extras.put(s, Integer.valueOf(i));
            return this;
        }

        public final Builder addExtras(Map map)
        {
            extras = new HashMap(map);
            return this;
        }

        public final MediaViewBinder build()
        {
            return new MediaViewBinder(this);
        }

        public final Builder callToActionId(int i)
        {
            callToActionId = i;
            return this;
        }

        public final Builder iconImageId(int i)
        {
            iconImageId = i;
            return this;
        }

        public final Builder mediaLayoutId(int i)
        {
            mediaLayoutId = i;
            return this;
        }

        public final Builder privacyInformationIconImageId(int i)
        {
            privacyInformationIconImageId = i;
            return this;
        }

        public final Builder textId(int i)
        {
            textId = i;
            return this;
        }

        public final Builder titleId(int i)
        {
            titleId = i;
            return this;
        }









        public Builder(int i)
        {
            extras = Collections.emptyMap();
            layoutId = i;
            extras = new HashMap();
        }
    }


    final int callToActionId;
    final Map extras;
    final int iconImageId;
    final int layoutId;
    final int mediaLayoutId;
    final int privacyInformationIconImageId;
    final int textId;
    final int titleId;

    private MediaViewBinder(Builder builder)
    {
        layoutId = builder.layoutId;
        mediaLayoutId = builder.mediaLayoutId;
        titleId = builder.titleId;
        textId = builder.textId;
        callToActionId = builder.callToActionId;
        iconImageId = builder.iconImageId;
        privacyInformationIconImageId = builder.privacyInformationIconImageId;
        extras = builder.extras;
    }

}
