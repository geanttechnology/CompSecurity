// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.io.File;

// Referenced classes of package co.vine.android.recorder:
//            RecordSessionManager, RecordSessionMeta

public static class meta
    implements Comparable
{

    public final File folder;
    public final RecordSessionMeta meta;
    public final File thumb;
    public final File video;

    public int compareTo(meta meta1)
    {
        return Long.valueOf(folder.getName()).compareTo(Long.valueOf(meta1.folder.getName()));
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public (File file, File file1, File file2, RecordSessionMeta recordsessionmeta)
    {
        folder = file;
        thumb = file1;
        video = file2;
        meta = recordsessionmeta;
    }
}
