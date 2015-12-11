// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            ArtifactSourceFactory, RamDumpArtifactSource, SettingsStore

public class DefaultUploadArtifactSourceFactory
    implements ArtifactSourceFactory
{

    protected SettingsStore mSettingsStore;

    public DefaultUploadArtifactSourceFactory(SettingsStore settingsstore)
    {
        if (settingsstore == null)
        {
            throw new IllegalArgumentException("SettingsStore must not be null.");
        } else
        {
            mSettingsStore = settingsstore;
            return;
        }
    }

    public List constructArtifactSources()
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(new RamDumpArtifactSource(mSettingsStore));
        return linkedlist;
    }
}
