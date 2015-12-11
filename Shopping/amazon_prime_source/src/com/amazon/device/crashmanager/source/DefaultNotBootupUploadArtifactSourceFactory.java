// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;

import android.os.DropBoxManager;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.device.crashmanager.source:
//            DefaultUploadArtifactSourceFactory, DropBoxArtifactSource, SettingsStore

public class DefaultNotBootupUploadArtifactSourceFactory extends DefaultUploadArtifactSourceFactory
{

    private DropBoxManager mDropBoxManager;
    private final Set mDropBoxTags;

    public DefaultNotBootupUploadArtifactSourceFactory(SettingsStore settingsstore, DropBoxManager dropboxmanager, Set set)
    {
        super(settingsstore);
        if (dropboxmanager == null)
        {
            throw new IllegalArgumentException("DropBoxManager must not be null.");
        }
        if (set == null)
        {
            throw new IllegalArgumentException("dropBoxTags must not be null.");
        } else
        {
            mDropBoxManager = dropboxmanager;
            mDropBoxTags = set;
            return;
        }
    }

    public List constructArtifactSources()
    {
        List list = super.constructArtifactSources();
        list.add(new DropBoxArtifactSource(mDropBoxManager, mSettingsStore, mDropBoxTags));
        return list;
    }
}
