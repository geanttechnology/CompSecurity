// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;

import android.widget.Toast;
import co.vine.android.util.MediaUtil;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

// Referenced classes of package co.vine.android.player:
//            SdkVideoView

public class SaveVideoClicker
{

    private static File LONG_PRESS_SAVE_DIR = null;
    private int mCount;

    public SaveVideoClicker()
    {
        mCount = 0;
    }

    public static void setLongPressSaveDir(File file)
    {
        LONG_PRESS_SAVE_DIR = file;
    }

    public void onClick(SdkVideoView sdkvideoview)
    {
        String s1;
        if (LONG_PRESS_SAVE_DIR == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        mCount = mCount + 1;
        if (mCount < 20)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s1 = sdkvideoview.getPath();
        String s = (new File(s1)).getName();
        Object obj = s;
        try
        {
            if (!s.endsWith(".mp4"))
            {
                obj = (new StringBuilder()).append(s).append(".mp4").toString();
            }
            obj = new File(LONG_PRESS_SAVE_DIR, ((String) (obj)));
            FileUtils.copyFile(new File(s1), ((File) (obj)));
            Toast.makeText(sdkvideoview.getContext(), (new StringBuilder()).append("File Saved: ").append(obj).toString(), 0).show();
            MediaUtil.scanFile(sdkvideoview.getContext(), ((File) (obj)), null);
        }
        // Misplaced declaration of an exception variable
        catch (SdkVideoView sdkvideoview)
        {
            SLog.e("Failed to save video", sdkvideoview);
        }
        mCount = 0;
    }

}
