// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text:
//            SubtitleParser, TextRenderer, Subtitle, SubtitleParserHelper

public final class TextTrackRenderer extends TrackRenderer
    implements android.os.Handler.Callback
{

    private static final List DEFAULT_PARSER_CLASSES;
    private static final int MSG_UPDATE_OVERLAY = 0;
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private boolean inputStreamEnded;
    private Subtitle nextSubtitle;
    private int nextSubtitleEventIndex;
    private SubtitleParserHelper parserHelper;
    private int parserIndex;
    private HandlerThread parserThread;
    private final com.google.android.exoplayer.SampleSource.SampleSourceReader source;
    private Subtitle subtitle;
    private final SubtitleParser subtitleParsers[];
    private final TextRenderer textRenderer;
    private final Handler textRendererHandler;
    private int trackIndex;

    public transient TextTrackRenderer(SampleSource samplesource, TextRenderer textrenderer, Looper looper, SubtitleParser asubtitleparser[])
    {
label0:
        {
            super();
            source = samplesource.register();
            textRenderer = (TextRenderer)Assertions.checkNotNull(textrenderer);
            int i;
            if (looper == null)
            {
                samplesource = null;
            } else
            {
                samplesource = new Handler(looper, this);
            }
            textRendererHandler = samplesource;
            if (asubtitleparser != null)
            {
                samplesource = asubtitleparser;
                if (asubtitleparser.length != 0)
                {
                    break label0;
                }
            }
            textrenderer = new SubtitleParser[DEFAULT_PARSER_CLASSES.size()];
            i = 0;
            do
            {
                samplesource = textrenderer;
                if (i >= textrenderer.length)
                {
                    break;
                }
                try
                {
                    textrenderer[i] = (SubtitleParser)((Class)DEFAULT_PARSER_CLASSES.get(i)).newInstance();
                }
                // Misplaced declaration of an exception variable
                catch (SampleSource samplesource)
                {
                    throw new IllegalStateException("Unexpected error creating default parser", samplesource);
                }
                // Misplaced declaration of an exception variable
                catch (SampleSource samplesource)
                {
                    throw new IllegalStateException("Unexpected error creating default parser", samplesource);
                }
                i++;
            } while (true);
        }
        subtitleParsers = samplesource;
    }

    private void clearTextRenderer()
    {
        updateTextRenderer(Collections.emptyList());
    }

    private long getNextEventTime()
    {
        if (nextSubtitleEventIndex == -1 || nextSubtitleEventIndex >= subtitle.getEventTimeCount())
        {
            return 0x7fffffffffffffffL;
        } else
        {
            return subtitle.getEventTime(nextSubtitleEventIndex);
        }
    }

    private void invokeRendererInternalCues(List list)
    {
        textRenderer.onCues(list);
    }

    private void seekToInternal()
    {
        inputStreamEnded = false;
        subtitle = null;
        nextSubtitle = null;
        parserHelper.flush();
        clearTextRenderer();
    }

    private void updateTextRenderer(List list)
    {
        if (textRendererHandler != null)
        {
            textRendererHandler.obtainMessage(0, list).sendToTarget();
            return;
        } else
        {
            invokeRendererInternalCues(list);
            return;
        }
    }

    protected int doPrepare(long l)
    {
        if (!source.prepare(l))
        {
            return 0;
        }
        int k = source.getTrackCount();
        for (int i = 0; i < subtitleParsers.length; i++)
        {
            for (int j = 0; j < k; j++)
            {
                if (subtitleParsers[i].canParse(source.getTrackInfo(j).mimeType))
                {
                    parserIndex = i;
                    trackIndex = j;
                    return 1;
                }
            }

        }

        return -1;
    }

    protected void doSomeWork(long l, long l1)
        throws ExoPlaybackException
    {
        source.continueBuffering(trackIndex, l);
        if (nextSubtitle == null)
        {
            try
            {
                nextSubtitle = parserHelper.getAndClearResult();
            }
            catch (IOException ioexception)
            {
                throw new ExoPlaybackException(ioexception);
            }
        }
        if (getState() == 3)
        {
            boolean flag = false;
            boolean flag1 = false;
            long l2 = 0x7fffffffffffffffL;
            if (subtitle != null)
            {
                l1 = getNextEventTime();
                flag = flag1;
                do
                {
                    l2 = l1;
                    if (l1 > l)
                    {
                        break;
                    }
                    nextSubtitleEventIndex = nextSubtitleEventIndex + 1;
                    l1 = getNextEventTime();
                    flag = true;
                } while (true);
            }
            flag1 = flag;
            if (l2 == 0x7fffffffffffffffL)
            {
                flag1 = flag;
                if (nextSubtitle != null)
                {
                    flag1 = flag;
                    if (nextSubtitle.getStartTime() <= l)
                    {
                        subtitle = nextSubtitle;
                        nextSubtitle = null;
                        nextSubtitleEventIndex = subtitle.getNextEventTimeIndex(l);
                        flag1 = true;
                    }
                }
            }
            if (flag1)
            {
                updateTextRenderer(subtitle.getCues(l));
            }
            if (!inputStreamEnded && nextSubtitle == null && !parserHelper.isParsing())
            {
                SampleHolder sampleholder = parserHelper.getSampleHolder();
                sampleholder.clearData();
                int i = source.readData(trackIndex, l, formatHolder, sampleholder, false);
                if (i == -3)
                {
                    parserHelper.startParseOperation();
                    return;
                }
                if (i == -1)
                {
                    inputStreamEnded = true;
                    return;
                }
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
            invokeRendererInternalCues((List)message.obj);
            break;
        }
        return true;
    }

    protected boolean isEnded()
    {
        return inputStreamEnded && (subtitle == null || getNextEventTime() == 0x7fffffffffffffffL);
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
        subtitle = null;
        nextSubtitle = null;
        parserThread.quit();
        parserThread = null;
        parserHelper = null;
        clearTextRenderer();
        source.disable(trackIndex);
    }

    protected void onEnabled(long l, boolean flag)
    {
        source.enable(trackIndex, l);
        parserThread = new HandlerThread("textParser");
        parserThread.start();
        parserHelper = new SubtitleParserHelper(parserThread.getLooper(), subtitleParsers[parserIndex]);
        seekToInternal();
    }

    protected void onReleased()
    {
        source.release();
    }

    protected void seekTo(long l)
    {
        source.seekToUs(l);
        seekToInternal();
    }

    static 
    {
        DEFAULT_PARSER_CLASSES = new ArrayList();
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.webvtt.WebvttParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception3) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.ttml.TtmlParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception2) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.subrip.SubripParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception1) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.tx3g.Tx3gParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return;
        }
    }
}
