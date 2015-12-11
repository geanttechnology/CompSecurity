// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.lifevibes;

import com.lifevibes.videoeditor.MediaVideoItem;
import com.lifevibes.videoeditor.VideoEditor;
import com.lifevibes.videoeditor.VideoEditorFactory;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class LifeVibesTranscoder
    implements co.vine.android.recorder.EncoderManager.Encoder, com.lifevibes.videoeditor.VideoEditor.ExportProgressListener
{

    private int mProgress;

    public LifeVibesTranscoder()
    {
    }

    public void onProgress(VideoEditor videoeditor, String s, int i)
    {
        mProgress = i;
    }

    public void transcode(co.vine.android.recorder.EncoderManager.EncoderBoss encoderboss, String s, String s1, ArrayList arraylist)
        throws co.vine.android.recorder.EncoderManager.EncodingException
    {
        File file;
label0:
        {
            File file1 = new File(s);
            file = null;
            arraylist = file1;
            String s2 = s;
            if (!s.endsWith(".mp4"))
            {
                file = new File(s);
                arraylist = new File((new StringBuilder()).append(s).append("_t.mp4").toString());
                file1.renameTo(arraylist);
                s2 = arraylist.getAbsolutePath();
            }
            try
            {
                s = new File(arraylist.getParentFile(), "temp");
                FileUtils.forceMkdir(s);
                s = VideoEditorFactory.create(s.getAbsolutePath());
                s.addMediaItem(new MediaVideoItem(s, arraylist.getName(), s2, 0));
                s.setAspectRatio(6);
                s.export(s1, 480, 0x16e360, 2, 4, this);
                while (mProgress != 100) 
                {
                    if (encoderboss.isCancelled())
                    {
                        s.cancelExport(s1);
                    }
                    encoderboss.updateLastProcess(mProgress);
                    Thread.sleep(1000L);
                }
                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (co.vine.android.recorder.EncoderManager.EncoderBoss encoderboss) { }
            finally
            {
                if (file != null)
                {
                    arraylist.renameTo(file);
                }
                throw encoderboss;
            }
        }
        throw new co.vine.android.recorder.EncoderManager.EncodingException(encoderboss);
        if (file != null)
        {
            arraylist.renameTo(file);
        }
        return;
    }

    static 
    {
        switch (android.os.Build.VERSION.SDK_INT)
        {
        default:
            System.loadLibrary("lifevibes_sw_JB");
            break;

        case 14: // '\016'
        case 15: // '\017'
            System.loadLibrary("lifevibes_sw_ICS");
            break;
        }
    }
}
