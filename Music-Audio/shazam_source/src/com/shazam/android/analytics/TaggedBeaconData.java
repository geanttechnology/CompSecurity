// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingOrigin

public class TaggedBeaconData
{
    public static class Builder
    {

        private Map additionalTaggedBeaconParams;
        private TaggingOrigin taggingOrigin;

        static TaggingOrigin a(Builder builder)
        {
            return builder.taggingOrigin;
        }

        static Map b(Builder builder)
        {
            return builder.additionalTaggedBeaconParams;
        }

        public static Builder taggedBeaconData()
        {
            return new Builder();
        }

        public TaggedBeaconData build()
        {
            return new TaggedBeaconData(this, (byte)0);
        }

        public Builder withAdditionalBeaconParams(Map map)
        {
            additionalTaggedBeaconParams = map;
            return this;
        }

        public Builder withTaggingOrigin(TaggingOrigin taggingorigin)
        {
            taggingOrigin = taggingorigin;
            return this;
        }

        public Builder()
        {
            additionalTaggedBeaconParams = Collections.emptyMap();
        }
    }


    private final Map additionalTaggedBeaconParams;
    private final TaggingOrigin taggingOrigin;

    private TaggedBeaconData(Builder builder)
    {
        taggingOrigin = Builder.a(builder);
        additionalTaggedBeaconParams = Builder.b(builder);
    }

    TaggedBeaconData(Builder builder, byte byte0)
    {
        this(builder);
    }

    public void addAdditionalTaggedBeaconParamsTo(com.shazam.android.analytics.event.EventParameters.Builder builder)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = getAdditionalTaggedBeaconParams().entrySet().iterator(); iterator.hasNext(); builder.putNotEmptyOrNullParameter(com.shazam.android.analytics.event.StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey((String)entry.getKey()).build(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

    }

    public Map getAdditionalTaggedBeaconParams()
    {
        return additionalTaggedBeaconParams;
    }

    public TaggingOrigin getTaggingOrigin()
    {
        return taggingOrigin;
    }
}
