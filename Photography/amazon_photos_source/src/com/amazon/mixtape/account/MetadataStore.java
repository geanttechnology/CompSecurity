// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.account;

import com.amazon.mixtape.service.MetadataSyncException;
import java.io.Closeable;
import java.util.List;

public interface MetadataStore
    extends Closeable
{
    public static class MetadataState
    {

        private final int metadataVersion;
        private final String state;

        public int getMetadataVersion()
        {
            return metadataVersion;
        }

        public String getState()
        {
            return state;
        }

        public MetadataState(String s, int i)
        {
            state = s;
            metadataVersion = i;
        }
    }


    public abstract void addAccountMetadataState(String s)
        throws MetadataSyncException;

    public abstract void clearStore()
        throws MetadataSyncException;

    public abstract long getCurrentNodesCount()
        throws MetadataSyncException;

    public abstract long getCurrentStoreSize()
        throws MetadataSyncException;

    public abstract String getLastCheckpoint()
        throws MetadataSyncException;

    public abstract MetadataState getMostRecentAccountMetadataState()
        throws MetadataSyncException;

    public abstract void resetCheckpoint()
        throws MetadataSyncException;

    public abstract void resetStore()
        throws MetadataSyncException;

    public abstract void saveNodes(List list)
        throws MetadataSyncException;

    public abstract void saveNodes(List list, String s, String s1)
        throws MetadataSyncException;

    public abstract void saveNodes(List list, boolean flag)
        throws MetadataSyncException;
}
