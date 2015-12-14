// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.TextRenderer;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.text.eia608:
//            Eia608Parser, ClosedCaptionList, ClosedCaption, ClosedCaptionCtrl, 
//            ClosedCaptionText

public final class Eia608TrackRenderer extends TrackRenderer
    implements android.os.Handler.Callback
{

    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int MAX_SAMPLE_READAHEAD_US = 0x4c4b40;
    private static final int MSG_INVOKE_RENDERER = 0;
    private String caption;
    private int captionMode;
    private int captionRowCount;
    private final StringBuilder captionStringBuilder = new StringBuilder();
    private final Eia608Parser eia608Parser = new Eia608Parser();
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private boolean inputStreamEnded;
    private String lastRenderedCaption;
    private final TreeSet pendingCaptionLists = new TreeSet();
    private final SampleHolder sampleHolder = new SampleHolder(1);
    private final com.google.android.exoplayer.SampleSource.SampleSourceReader source;
    private final TextRenderer textRenderer;
    private final Handler textRendererHandler;
    private int trackIndex;

    public Eia608TrackRenderer(SampleSource samplesource, TextRenderer textrenderer, Looper looper)
    {
        source = samplesource.register();
        textRenderer = (TextRenderer)Assertions.checkNotNull(textrenderer);
        if (looper == null)
        {
            samplesource = null;
        } else
        {
            samplesource = new Handler(looper, this);
        }
        textRendererHandler = samplesource;
    }

    private void clearPendingSample()
    {
        sampleHolder.timeUs = -1L;
        sampleHolder.clearData();
    }

    private void consumeCaptionList(ClosedCaptionList closedcaptionlist)
    {
        int j = closedcaptionlist.captions.length;
        if (j != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
        do
        {
            if (i >= j)
            {
                continue; /* Loop/switch isn't completed */
            }
            Object obj = closedcaptionlist.captions[i];
            if (((ClosedCaption) (obj)).type == 0)
            {
                obj = (ClosedCaptionCtrl)obj;
                if (((ClosedCaptionCtrl) (obj)).isMiscCode())
                {
                    handleMiscCode(((ClosedCaptionCtrl) (obj)));
                } else
                if (((ClosedCaptionCtrl) (obj)).isPreambleAddressCode())
                {
                    handlePreambleAddressCode();
                }
            } else
            {
                handleText((ClosedCaptionText)obj);
            }
            i++;
        } while (true);
        if (captionMode != 1 && captionMode != 3) goto _L1; else goto _L3
_L3:
        caption = getDisplayCaption();
        return;
    }

    private String getDisplayCaption()
    {
        int j = captionStringBuilder.length();
        if (j != 0)
        {
            int i;
            if (captionStringBuilder.charAt(j - 1) == '\n')
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (j != 1 || i == 0)
            {
                if (i != 0)
                {
                    i = j - 1;
                } else
                {
                    i = j;
                }
                if (captionMode != 1)
                {
                    return captionStringBuilder.substring(0, i);
                }
                boolean flag = false;
                j = i;
                for (int k = 0; k < captionRowCount && j != -1; k++)
                {
                    j = captionStringBuilder.lastIndexOf("\n", j - 1);
                }

                int l = ((flag) ? 1 : 0);
                if (j != -1)
                {
                    l = j + 1;
                }
                captionStringBuilder.delete(0, l);
                return captionStringBuilder.substring(0, i - l);
            }
        }
        return null;
    }

    private void handleMiscCode(ClosedCaptionCtrl closedcaptionctrl)
    {
        closedcaptionctrl.cc2;
        JVM INSTR tableswitch 32 41: default 60
    //                   32 101
    //                   33 60
    //                   34 60
    //                   35 60
    //                   36 60
    //                   37 68
    //                   38 79
    //                   39 90
    //                   40 60
    //                   41 107;
           goto _L1 _L2 _L1 _L1 _L1 _L1 _L3 _L4 _L5 _L1 _L6
_L1:
        if (captionMode != 0) goto _L8; else goto _L7
_L7:
        return;
_L3:
        captionRowCount = 2;
        setCaptionMode(1);
        return;
_L4:
        captionRowCount = 3;
        setCaptionMode(1);
        return;
_L5:
        captionRowCount = 4;
        setCaptionMode(1);
        return;
_L2:
        setCaptionMode(2);
        return;
_L6:
        setCaptionMode(3);
        return;
_L8:
        switch (closedcaptionctrl.cc2)
        {
        default:
            return;

        case 33: // '!'
            if (captionStringBuilder.length() > 0)
            {
                captionStringBuilder.setLength(captionStringBuilder.length() - 1);
                return;
            }
            break;

        case 44: // ','
            caption = null;
            if (captionMode == 1 || captionMode == 3)
            {
                captionStringBuilder.setLength(0);
                return;
            }
            break;

        case 46: // '.'
            captionStringBuilder.setLength(0);
            return;

        case 47: // '/'
            caption = getDisplayCaption();
            captionStringBuilder.setLength(0);
            return;

        case 45: // '-'
            maybeAppendNewline();
            return;
        }
        if (true) goto _L7; else goto _L9
_L9:
    }

    private void handlePreambleAddressCode()
    {
        maybeAppendNewline();
    }

    private void handleText(ClosedCaptionText closedcaptiontext)
    {
        if (captionMode != 0)
        {
            captionStringBuilder.append(closedcaptiontext.text);
        }
    }

    private void invokeRenderer(String s)
    {
        if (Util.areEqual(lastRenderedCaption, s))
        {
            return;
        }
        lastRenderedCaption = s;
        if (textRendererHandler != null)
        {
            textRendererHandler.obtainMessage(0, s).sendToTarget();
            return;
        } else
        {
            invokeRendererInternal(s);
            return;
        }
    }

    private void invokeRendererInternal(String s)
    {
        if (s == null)
        {
            textRenderer.onCues(Collections.emptyList());
            return;
        } else
        {
            textRenderer.onCues(Collections.singletonList(new Cue(s)));
            return;
        }
    }

    private boolean isSamplePending()
    {
        return sampleHolder.timeUs != -1L;
    }

    private void maybeAppendNewline()
    {
        int i = captionStringBuilder.length();
        if (i > 0 && captionStringBuilder.charAt(i - 1) != '\n')
        {
            captionStringBuilder.append('\n');
        }
    }

    private void maybeParsePendingSample(long l)
    {
        if (sampleHolder.timeUs <= 0x4c4b40L + l)
        {
            ClosedCaptionList closedcaptionlist = eia608Parser.parse(sampleHolder);
            clearPendingSample();
            if (closedcaptionlist != null)
            {
                pendingCaptionLists.add(closedcaptionlist);
                return;
            }
        }
    }

    private void seekToInternal()
    {
        inputStreamEnded = false;
        pendingCaptionLists.clear();
        clearPendingSample();
        captionRowCount = 4;
        setCaptionMode(0);
        invokeRenderer(null);
    }

    private void setCaptionMode(int i)
    {
        if (captionMode != i)
        {
            captionMode = i;
            captionStringBuilder.setLength(0);
            if (i == 1 || i == 0)
            {
                caption = null;
                return;
            }
        }
    }

    protected int doPrepare(long l)
    {
        if (!source.prepare(l))
        {
            return 0;
        }
        int j = source.getTrackCount();
        for (int i = 0; i < j; i++)
        {
            if (eia608Parser.canParse(source.getTrackInfo(i).mimeType))
            {
                trackIndex = i;
                return 1;
            }
        }

        return -1;
    }

    protected void doSomeWork(long l, long l1)
        throws ExoPlaybackException
    {
        source.continueBuffering(trackIndex, l);
        if (isSamplePending())
        {
            maybeParsePendingSample(l);
        }
        int i;
        if (inputStreamEnded)
        {
            i = -1;
        } else
        {
            i = -3;
        }
        do
        {
            if (isSamplePending() || i != -3)
            {
                break;
            }
            int j = source.readData(trackIndex, l, formatHolder, sampleHolder, false);
            if (j == -3)
            {
                maybeParsePendingSample(l);
                i = j;
            } else
            {
                i = j;
                if (j == -1)
                {
                    inputStreamEnded = true;
                    i = j;
                }
            }
        } while (true);
        while (!pendingCaptionLists.isEmpty() && ((ClosedCaptionList)pendingCaptionLists.first()).timeUs <= l) 
        {
            ClosedCaptionList closedcaptionlist = (ClosedCaptionList)pendingCaptionLists.pollFirst();
            consumeCaptionList(closedcaptionlist);
            if (!closedcaptionlist.decodeOnly)
            {
                invokeRenderer(caption);
            }
        }
    }

    protected long getBufferedPositionUs()
    {
        return -3L;
    }

    protected long getDurationUs()
    {
        return source.getTrackInfo(trackIndex).durationUs;
    }

    public boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            invokeRendererInternal((String)message.obj);
            break;
        }
        return true;
    }

    protected boolean isEnded()
    {
        return inputStreamEnded;
    }

    protected boolean isReady()
    {
        return true;
    }

    protected void maybeThrowError()
        throws ExoPlaybackException
    {
        try
        {
            source.maybeThrowError();
            return;
        }
        catch (IOException ioexception)
        {
            throw new ExoPlaybackException(ioexception);
        }
    }

    protected void onDisabled()
    {
        source.disable(trackIndex);
    }

    protected void onEnabled(long l, boolean flag)
    {
        source.enable(trackIndex, l);
        seekToInternal();
    }

    protected void seekTo(long l)
        throws ExoPlaybackException
    {
        source.seekToUs(l);
        seekToInternal();
    }
}
