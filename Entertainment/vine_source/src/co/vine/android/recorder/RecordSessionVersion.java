// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import java.io.File;
import java.io.IOException;

// Referenced classes of package co.vine.android.recorder:
//            RecordSessionManager

public final class RecordSessionVersion extends Enum
{

    private static final RecordSessionVersion $VALUES[];
    public static final RecordSessionVersion HW;
    public static final RecordSessionVersion SW_MP4;
    public static final RecordSessionVersion SW_WEBM;
    public final String folder;
    private RecordSessionManager manager;
    public final String mimeType;
    public final String videoOutputExtension;
    public final boolean willEventuallyTranscoded;

    private RecordSessionVersion(String s, int i, String s1, String s2, String s3, boolean flag)
    {
        super(s, i);
        folder = s1;
        videoOutputExtension = s2;
        mimeType = s3;
        willEventuallyTranscoded = flag;
    }

    public static void deleteSessionWithName(Context context, String s)
        throws IOException
    {
        RecordSessionVersion arecordsessionversion[] = values();
        int j = arecordsessionversion.length;
        for (int i = 0; i < j; i++)
        {
            File file = arecordsessionversion[i].getManager(context).getFolderFromName(s);
            if (file != null && file.exists())
            {
                RecordSessionManager.deleteSession(file, "Done with session.");
            }
        }

    }

    public static RecordSessionVersion[] getValuesWithManagers(Context context)
        throws IOException
    {
        RecordSessionVersion arecordsessionversion[] = values();
        int j = arecordsessionversion.length;
        for (int i = 0; i < j; i++)
        {
            arecordsessionversion[i].getManager(context);
        }

        return values();
    }

    public static RecordSessionVersion valueOf(String s)
    {
        return (RecordSessionVersion)Enum.valueOf(co/vine/android/recorder/RecordSessionVersion, s);
    }

    public static RecordSessionVersion[] values()
    {
        return (RecordSessionVersion[])$VALUES.clone();
    }

    public AudioArray.AudioArrayType getAudioArrayType()
    {
        if (this == HW)
        {
            return AudioArray.AudioArrayType.BYTE;
        } else
        {
            return AudioArray.AudioArrayType.SHORT;
        }
    }

    public RecordSessionManager getManager(Context context)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (manager == null)
        {
            manager = new RecordSessionManager(context, this);
        }
        context = manager;
        this;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static 
    {
        HW = new RecordSessionVersion("HW", 0, "drafts_hw", ".mp4", "video/mp4", false);
        SW_MP4 = new RecordSessionVersion("SW_MP4", 1, "drafts", ".mp4", "video/mp4", true);
        SW_WEBM = new RecordSessionVersion("SW_WEBM", 2, "drafts_webm", ".webm", "video/webm", true);
        $VALUES = (new RecordSessionVersion[] {
            HW, SW_MP4, SW_WEBM
        });
    }
}
