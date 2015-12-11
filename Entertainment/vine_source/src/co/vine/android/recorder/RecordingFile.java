// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import com.edisonwang.android.slog.FormattingTuple;
import com.edisonwang.android.slog.MessageFormatter;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.recorder:
//            RecordSession, RecordSessionManager, RecordSessionVersion

public class RecordingFile
{

    public ArrayList editedSegments;
    public final File folder;
    public boolean isDirty;
    public final boolean isLastSession;
    public boolean isSavedSession;
    private String mHash;
    private RecordSession mSession;
    public final RecordSessionVersion version;

    public RecordingFile(File file, RecordSession recordsession, boolean flag, boolean flag1, boolean flag2)
    {
        if (SLog.sLogsOn)
        {
            SLog.i("[session] New file created: {}.", Integer.valueOf(hashCode()));
        }
        mSession = recordsession;
        version = mSession.getVersion();
        folder = file;
        isSavedSession = flag;
        isLastSession = flag2;
        isDirty = flag1;
        try
        {
            FileUtils.forceMkdir(folder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            throw new RuntimeException(file);
        }
    }

    public static String getLastFramePathThumbnailFromThumbnailPath(String s, boolean flag)
    {
        return (new StringBuilder()).append(s).append(".last.").append(String.valueOf(flag)).append(".jpg").toString();
    }

    public String getHash()
    {
        return mHash;
    }

    public String getLastFramePath()
    {
        String s = getThumbnailPath();
        String s1 = getLastFramePathThumbnailFromThumbnailPath(s, false);
        if (!(new File(s1)).exists())
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public String getPreviewThumbnailPath()
    {
        return RecordSessionManager.getPreviewThumbnailPath(folder);
    }

    public String getPreviewVideoPath()
    {
        return RecordSessionManager.getPreviewVideoPath(version, folder);
    }

    public String getSegmentThumbnailPath()
    {
        return RecordSessionManager.getSegmentThumbnailPath(folder);
    }

    public String getSegmentVideoPath()
    {
        return RecordSessionManager.getSegmentVideoPath(version, folder);
    }

    public RecordSession getSession()
    {
        return mSession;
    }

    public String getThumbnailPath()
    {
        return RecordSessionManager.getThumbnailPath(folder);
    }

    public String getVideoPath()
    {
        return RecordSessionManager.getVideoPath(version, folder);
    }

    public boolean hasData()
    {
        return mSession.getSegments().size() > 0;
    }

    public void invalidateGhostThumbnail()
    {
        File file = new File(getLastFramePathThumbnailFromThumbnailPath(getPreviewThumbnailPath(), true));
        if (file.exists())
        {
            file.renameTo(new File(getLastFramePathThumbnailFromThumbnailPath(getThumbnailPath(), false)));
        }
    }

    public boolean isValid()
    {
        return mSession.getSegments().size() > 0;
    }

    public void setHash(String s)
    {
        mHash = s;
    }

    public void setSession(RecordSession recordsession)
    {
        mSession = recordsession;
    }

    public String toString()
    {
        return MessageFormatter.format("Folder: {}, isLastSession: {}, isDirty: {}, isSavedSession: {}, Session: {}", new Object[] {
            folder, Boolean.valueOf(isLastSession), Boolean.valueOf(isDirty), Boolean.valueOf(isSavedSession), mSession
        }).getMessage();
    }
}
