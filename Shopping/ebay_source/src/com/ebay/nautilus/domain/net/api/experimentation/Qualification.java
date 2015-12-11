// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Qualification extends BaseApiResponse
{
    public class QualificationMetadata
    {

        public Long initialCacheTimestamp;
        public Map knownExperimentsToContextHash;
        final Qualification this$0;

        public QualificationMetadata()
        {
            this$0 = Qualification.this;
            super();
            knownExperimentsToContextHash = new HashMap();
        }
    }


    public static final long serialVersionUID = 1L;
    public String cosExperimentMetadata;
    public long expirationTimestampMillis;
    public QualificationMetadata metadata;
    public List qTags;
    public long qualificationTimestampMillis;
    public List treatments;

    public Qualification()
    {
        qualificationTimestampMillis = System.currentTimeMillis();
        metadata = new QualificationMetadata();
    }
}
