// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import android.os.DropBoxManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            ArtifactSourceFactory, DropBoxArtifactSource, SettingsStore

public class DefaultOffloadArtifactSourceFactory
    implements ArtifactSourceFactory
{

    private final DropBoxManager mDropBoxManager;
    private final Set mDropBoxTags;
    private final SettingsStore mSettingsStore;

    public DefaultOffloadArtifactSourceFactory(SettingsStore settingsstore, DropBoxManager dropboxmanager, Set set)
    {
        if (settingsstore == null)
        {
            throw new IllegalArgumentException("SettingsStore must not be null.");
        }
        if (dropboxmanager == null)
        {
            throw new IllegalArgumentException("DropBoxManager must not be null.");
        }
        if (set == null)
        {
            throw new IllegalArgumentException("dropBoxTags must not be null.");
        } else
        {
            mSettingsStore = settingsstore;
            mDropBoxManager = dropboxmanager;
            mDropBoxTags = set;
            return;
        }
    }

    public List constructArtifactSources()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new DropBoxArtifactSource(mDropBoxManager, mSettingsStore, mDropBoxTags));
        return linkedlist;
    }
}
