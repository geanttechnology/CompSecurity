// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

// Referenced classes of package com.uplynk.media:
//            CaptionStyle, MediaPlayer, CaptionEvent

public class CaptionManager
{
    protected class CCEventHandler extends Handler
    {

        private CaptionManager _cc;
        private MediaPlayer _mediaPlayer;
        final CaptionManager this$0;

        public void handleMessage(Message message)
        {
            if (!_mediaPlayer.hasNativeContext())
            {
                Log.w("upLynkCaptionManager", "mediaplayer went away with unhandled closed caption events");
            } else
            {
                int i = message.arg1;
                if (_cc._preferredChannelIndex == i)
                {
                    if (message.what == 0)
                    {
                        clearDisplay();
                        return;
                    }
                    if (message.what == 1)
                    {
                        _ccEventHandler.removeMessages(0);
                        int j = message.arg2;
                        message = (short[])message.obj;
                        if (j != message.length)
                        {
                            Log.e("upLynkCaptionManager", (new StringBuilder("CC: Data Packet doesn't match advertised length  (")).append(message.length).append(" vs ").append(j).append(")").toString());
                            return;
                        } else
                        {
                            _cc.renderCCData(j, message);
                            return;
                        }
                    }
                    if (message.what == 2)
                    {
                        _ccEventHandler.removeMessages(0);
                        message = (CaptionQueueItem)message.obj;
                        _cc.renderCCStreamItem(message);
                        return;
                    }
                }
            }
        }


        public CCEventHandler(MediaPlayer mediaplayer, CaptionManager captionmanager1, Looper looper)
        {
            this$0 = CaptionManager.this;
            super(looper);
            _mediaPlayer = mediaplayer;
            _cc = captionmanager1;
        }
    }

    protected class CCTimerHandler extends Handler
    {

        private CaptionChannel _channel;
        final CaptionManager this$0;

        public void handleMessage(Message message)
        {
            if (message.what == 1 && _channel._runTimer) goto _L2; else goto _L1
_L1:
            return;
_L2:
            message = _channel;
            message;
            JVM INSTR monitorenter ;
            CaptionQueueItem captionqueueitem;
            CCEventHandler cceventhandler;
            if (_channel.queue.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            captionqueueitem = (CaptionQueueItem)_channel.queue.removeFirst();
            cceventhandler = ((CaptionManager)_channel._mgr.get()).getEventHandler();
            if (cceventhandler == null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            cceventhandler.sendMessage(cceventhandler.obtainMessage(2, _channel._index, 0, captionqueueitem));
            message;
            JVM INSTR monitorexit ;
            if (!_channel._runTimer) goto _L1; else goto _L3
_L3:
            sendEmptyMessageDelayed(1, 30L);
            return;
            Exception exception;
            exception;
            message;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public CCTimerHandler(CaptionChannel captionchannel, Looper looper)
        {
            this$0 = CaptionManager.this;
            super(looper);
            _channel = captionchannel;
        }
    }

    public static final class CaptionAction extends Enum
    {

        public static final CaptionAction BACKSPACE;
        public static final CaptionAction CLEAR_ALL;
        public static final CaptionAction CLEAR_EOR;
        public static final CaptionAction COLOR;
        public static final CaptionAction COLUMN;
        private static final CaptionAction ENUM$VALUES[];
        public static final CaptionAction ERASE_DISPLAY_MEM;
        public static final CaptionAction FLUSH;
        public static final CaptionAction INDENT;
        public static final CaptionAction ITALIC;
        public static final CaptionAction LINEBREAK;
        public static final CaptionAction START_NEW_ROW;
        public static final CaptionAction TEXT;
        public static final CaptionAction UNDERLINED;
        public static final CaptionAction UNKNOWN;

        public static CaptionAction valueOf(String s)
        {
            return (CaptionAction)Enum.valueOf(com/uplynk/media/CaptionManager$CaptionAction, s);
        }

        public static CaptionAction[] values()
        {
            CaptionAction acaptionaction[] = ENUM$VALUES;
            int i = acaptionaction.length;
            CaptionAction acaptionaction1[] = new CaptionAction[i];
            System.arraycopy(acaptionaction, 0, acaptionaction1, 0, i);
            return acaptionaction1;
        }

        static 
        {
            UNKNOWN = new CaptionAction("UNKNOWN", 0);
            TEXT = new CaptionAction("TEXT", 1);
            BACKSPACE = new CaptionAction("BACKSPACE", 2);
            CLEAR_ALL = new CaptionAction("CLEAR_ALL", 3);
            CLEAR_EOR = new CaptionAction("CLEAR_EOR", 4);
            COLOR = new CaptionAction("COLOR", 5);
            COLUMN = new CaptionAction("COLUMN", 6);
            ERASE_DISPLAY_MEM = new CaptionAction("ERASE_DISPLAY_MEM", 7);
            FLUSH = new CaptionAction("FLUSH", 8);
            INDENT = new CaptionAction("INDENT", 9);
            ITALIC = new CaptionAction("ITALIC", 10);
            LINEBREAK = new CaptionAction("LINEBREAK", 11);
            UNDERLINED = new CaptionAction("UNDERLINED", 12);
            START_NEW_ROW = new CaptionAction("START_NEW_ROW", 13);
            ENUM$VALUES = (new CaptionAction[] {
                UNKNOWN, TEXT, BACKSPACE, CLEAR_ALL, CLEAR_EOR, COLOR, COLUMN, ERASE_DISPLAY_MEM, FLUSH, INDENT, 
                ITALIC, LINEBREAK, UNDERLINED, START_NEW_ROW
            });
        }

        private CaptionAction(String s, int i)
        {
            super(s, i);
        }
    }

    protected class CaptionChannel
    {

        int _color;
        int _column;
        private int _index;
        boolean _italic;
        private WeakReference _mgr;
        CaptionEvent.CaptionMode _mode;
        int _row;
        private boolean _runTimer;
        private CCTimerHandler _timer;
        boolean _underlined;
        private _CaptionRow currentRow;
        private int currentRowIndex;
        LinkedList queue;
        short rowCount;
        private SparseArray rows;
        final CaptionManager this$0;

        private void doAppendText(char c)
        {
            if (currentRow != null)
            {
                currentRow.writeChar(c);
            }
        }

        private void doBackspace()
        {
            if (currentRow != null)
            {
                currentRow.backspace();
            }
        }

        private void doClearAll()
        {
            rows.clear();
            currentRow = null;
        }

        private void doClearEndOfRow()
        {
            if (currentRow != null)
            {
                currentRow.clearToEnd();
            }
        }

        private void doColor(int i)
        {
            if (currentRow != null)
            {
                currentRow.color = i;
                currentRow.isItalic = false;
                currentRow.isUnderlined = false;
            }
        }

        private void doColumn(int i)
        {
            if (currentRow != null)
            {
                currentRow.setColumnIndex((short)i);
            }
        }

        private void doEraseDisplayMemory()
        {
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                CCEventHandler cceventhandler = ((CaptionManager)_mgr.get()).getEventHandler();
                if (cceventhandler != null)
                {
                    cceventhandler.sendMessage(cceventhandler.obtainMessage(0, _index, 0, null));
                }
                return;
            } else
            {
                doClearAll();
                return;
            }
        }

        private void doFlush()
        {
            short aword0[] = getRowsData();
            if (aword0.length <= 0 || _mode != CaptionEvent.CaptionMode.POP_ON) goto _L2; else goto _L1
_L1:
            CaptionEvent captionevent;
            int i;
            CCEventHandler cceventhandler = ((CaptionManager)_mgr.get()).getEventHandler();
            if (cceventhandler != null)
            {
                cceventhandler.sendMessage(cceventhandler.obtainMessage(1, _index, aword0.length, aword0));
            }
            captionevent = new CaptionEvent(CaptionEvent.CaptionMode.POP_ON, CaptionEvent.CaptionEventType.TEXT);
            i = 0;
_L6:
            if (i < rows.size()) goto _L4; else goto _L3
_L3:
            if (_overlayView != null && _ccEnabled)
            {
                _overlayView.renderCaptionEvent(captionevent);
            }
            if (((MediaPlayer)_mp.get()).mOnCaptionEventListener != null)
            {
                ((MediaPlayer)_mp.get()).mOnCaptionEventListener.onCaptionEvent(_ccEventHandler._mediaPlayer, captionevent);
            }
_L2:
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doClearAll();
            }
            return;
_L4:
            int j = rows.keyAt(i);
            CaptionEvent.CaptionRow captionrow = ((_CaptionRow)rows.get(j)).toCaptionRow(captionevent);
            captionevent.rows.put(j, captionrow);
            i++;
            if (true) goto _L6; else goto _L5
_L5:
        }

        private void doIndent(int i)
        {
            if (currentRow != null)
            {
                currentRow.tabIndex(i);
            }
        }

        private void doItalic()
        {
            if (currentRow != null)
            {
                currentRow.isItalic = true;
            }
        }

        private void doLinebreak()
        {
            if (currentRow != null && _mode != CaptionEvent.CaptionMode.ROLL_UP)
            {
                currentRowIndex = currentRowIndex + 1;
                currentRow = getCaptionRow(currentRowIndex);
            }
        }

        private void doStartNewRow(int i)
        {
            currentRowIndex = i;
            currentRow = getCaptionRow(i);
        }

        private void doUnderlined()
        {
            if (currentRow != null)
            {
                currentRow.isUnderlined = true;
            }
        }

        private _CaptionRow getCaptionRow(int i)
        {
            if (i > 0 && i <= 15)
            {
                _CaptionRow _lcaptionrow1 = (_CaptionRow)rows.get(i);
                _CaptionRow _lcaptionrow = _lcaptionrow1;
                if (_lcaptionrow1 == null)
                {
                    _lcaptionrow = new _CaptionRow(i);
                    rows.put(i, _lcaptionrow);
                }
                return _lcaptionrow;
            } else
            {
                return null;
            }
        }

        private short[] getRowsData()
        {
            short aword0[] = new short[0];
            int i = 0;
            do
            {
                if (i >= rows.size())
                {
                    return aword0;
                }
                int j = rows.keyAt(i);
                aword0 = CaptionManager.concat(aword0, ((_CaptionRow)rows.get(j)).getData());
                i++;
            } while (true);
        }

        private String getRowsMarkup()
        {
            return " ";
        }

        private String getRowsText()
        {
            String s = new String();
            int j = 0;
            int i = 0;
            do
            {
                if (i >= rows.size())
                {
                    return s;
                }
                int k = rows.keyAt(i);
                String s2 = ((_CaptionRow)rows.get(k)).getText();
                String s1 = s;
                if (j > 0)
                {
                    s1 = (new StringBuilder(String.valueOf(s))).append("\n").toString();
                }
                s = (new StringBuilder(String.valueOf(s1))).append(s2).toString();
                Log.d("upLynkCaptionManager", String.format("CC (%d): %s", new Object[] {
                    Integer.valueOf(k), s2
                }));
                j++;
                i++;
            } while (true);
        }

        private transient void queueTask(boolean flag, CaptionAction captionaction, int ai[])
        {
            CaptionQueueItem captionqueueitem;
            captionqueueitem = new CaptionQueueItem();
            captionqueueitem.pause = flag;
            captionqueueitem.mode = _mode;
            captionqueueitem.channel = (short)_index;
            captionqueueitem.action = captionaction;
            captionqueueitem.rowCount = rowCount;
            if (captionaction != CaptionAction.TEXT) goto _L2; else goto _L1
_L1:
            captionqueueitem.value = ai[0];
_L4:
            this;
            JVM INSTR monitorenter ;
            queue.add(captionqueueitem);
            this;
            JVM INSTR monitorexit ;
            if (_timer == null)
            {
                startTimer();
            }
            return;
_L2:
            if (captionaction == CaptionAction.COLOR)
            {
                captionqueueitem.value = ai[0];
            }
            if (true) goto _L4; else goto _L3
_L3:
            captionaction;
            this;
            JVM INSTR monitorexit ;
            throw captionaction;
        }

        private void startTimer()
        {
            if (_timer == null)
            {
                _timer = new CCTimerHandler(this, Looper.getMainLooper());
                _runTimer = true;
                _timer.sendEmptyMessageDelayed(1, 30L);
            }
        }

        private void stopTimer()
        {
            if (_timer != null)
            {
                _timer.removeMessages(1);
                _runTimer = false;
                _timer = null;
            }
        }

        void appendText(char c)
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doAppendText(c);
                return;
            } else
            {
                queueTask(true, CaptionAction.TEXT, new int[] {
                    c
                });
                return;
            }
        }

        void backspace()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doBackspace();
                return;
            } else
            {
                queueTask(false, CaptionAction.BACKSPACE, new int[0]);
                return;
            }
        }

        void clearAll()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doClearAll();
                return;
            } else
            {
                queueTask(false, CaptionAction.CLEAR_ALL, new int[0]);
                return;
            }
        }

        void clearEndOfRow()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doClearEndOfRow();
                return;
            } else
            {
                queueTask(false, CaptionAction.CLEAR_EOR, new int[0]);
                return;
            }
        }

        void color(int i)
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doColor(i);
                return;
            } else
            {
                queueTask(false, CaptionAction.COLOR, new int[] {
                    i
                });
                return;
            }
        }

        void column(int i)
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doColumn(i);
                return;
            } else
            {
                queueTask(false, CaptionAction.COLUMN, new int[] {
                    i
                });
                return;
            }
        }

        void eraseDisplayMemory()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doEraseDisplayMemory();
                return;
            } else
            {
                queueTask(false, CaptionAction.ERASE_DISPLAY_MEM, new int[0]);
                return;
            }
        }

        void flush()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doFlush();
                return;
            } else
            {
                queueTask(false, CaptionAction.FLUSH, new int[0]);
                return;
            }
        }

        void indent(int i)
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doIndent(i);
                return;
            } else
            {
                queueTask(false, CaptionAction.INDENT, new int[] {
                    i
                });
                return;
            }
        }

        void italic()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doItalic();
                return;
            } else
            {
                queueTask(false, CaptionAction.ITALIC, new int[0]);
                return;
            }
        }

        void linebreak()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doLinebreak();
                return;
            } else
            {
                queueTask(false, CaptionAction.LINEBREAK, new int[0]);
                return;
            }
        }

        void mode(CaptionEvent.CaptionMode captionmode)
        {
            if (captionmode != _mode)
            {
                _mode = captionmode;
                if (_mode != CaptionEvent.CaptionMode.POP_ON)
                {
                    startTimer();
                } else
                {
                    stopTimer();
                    queue.clear();
                }
            }
            _mode = captionmode;
        }

        protected void reset()
        {
            stopTimer();
            queue.clear();
            _column = 0;
            _color = 0xffffff;
            _italic = false;
            _mode = CaptionEvent.CaptionMode.UNKNOWN;
            _row = 0;
            currentRowIndex = 0;
            currentRow = null;
            rowCount = 1;
            _underlined = false;
        }

        void startNewRow(int i)
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doStartNewRow(i);
                return;
            } else
            {
                queueTask(false, CaptionAction.START_NEW_ROW, new int[] {
                    i
                });
                return;
            }
        }

        void underlined()
        {
            if (_mode == CaptionEvent.CaptionMode.UNKNOWN || _mode == CaptionEvent.CaptionMode.PAINT_ON || _mode == CaptionEvent.CaptionMode.TEXT)
            {
                return;
            }
            if (_mode == CaptionEvent.CaptionMode.POP_ON)
            {
                doUnderlined();
                return;
            } else
            {
                queueTask(false, CaptionAction.UNDERLINED, new int[0]);
                return;
            }
        }








        public CaptionChannel(int i, CaptionManager captionmanager1)
        {
            this$0 = CaptionManager.this;
            super();
            queue = null;
            _mode = CaptionEvent.CaptionMode.UNKNOWN;
            _timer = null;
            _runTimer = false;
            _column = 0;
            _color = 0xffffff;
            _italic = false;
            _mode = CaptionEvent.CaptionMode.UNKNOWN;
            _row = 0;
            currentRowIndex = 0;
            currentRow = null;
            rowCount = 1;
            _underlined = false;
            _index = i;
            _mgr = new WeakReference(captionmanager1);
            rows = new SparseArray();
            queue = new LinkedList();
        }
    }

    protected class CaptionQueueItem
    {

        public CaptionAction action;
        public short channel;
        public CaptionEvent.CaptionMode mode;
        public boolean pause;
        public int rowCount;
        final CaptionManager this$0;
        public int value;

        protected CaptionQueueItem()
        {
            this$0 = CaptionManager.this;
            super();
            mode = CaptionEvent.CaptionMode.UNKNOWN;
            action = CaptionAction.UNKNOWN;
            channel = 0;
            pause = false;
            rowCount = 1;
        }
    }

    private class OverlayHandler extends Handler
    {

        OverlayView _overlayView;
        final CaptionManager this$0;

        public void handleMessage(Message message)
        {
            if (message.what == 1)
            {
                removeMessages(1);
                _overlayView._mode = CaptionEvent.CaptionMode.UNKNOWN;
                _overlayView.invalidate();
                _overlayView._hasContent = false;
            }
        }

        protected OverlayHandler(OverlayView overlayview, Looper looper)
        {
            this$0 = CaptionManager.this;
            super(looper);
            _overlayView = overlayview;
        }
    }

    private class OverlayView extends View
    {

        protected static final int CLEAR_MSG = 1;
        private static final short STREAM_ROW = 14;
        Paint _backgroundPaint;
        float _density;
        OverlayHandler _handler;
        private boolean _hasContent;
        StringBuffer _lineBuff;
        CaptionEvent.CaptionMode _mode;
        int _previewColumn;
        int _previewRow;
        Vector _previewText;
        short _rowCount;
        SparseIntArray _rowY;
        SparseArray _rows;
        CaptionStyle _style;
        Paint _textDebugPaint;
        Paint _textEffect1Paint;
        Paint _textEffect2Paint;
        int _textPadding;
        Paint _textPaint;
        float _textSize;
        Paint _windowPaint;
        final CaptionManager this$0;

        private int complimentShadeWithAlpha(int i, int j)
        {
            int l = 0;
            if (Color.red(i) > 0)
            {
                l = Color.red(i);
            }
            int k = l;
            if (Color.green(i) > l)
            {
                k = Color.green(i);
            }
            l = k;
            if (Color.blue(i) > k)
            {
                l = Color.blue(i);
            }
            if (l > 128)
            {
                return Color.argb(j, 50, 50, 50);
            } else
            {
                return Color.argb(j, 200, 200, 200);
            }
        }

        private void configureOversizedRowPositions()
        {
            if (_style._textSize == 150 || _style._textSize == 200) goto _L2; else goto _L1
_L1:
            _rowY = null;
_L5:
            return;
_L2:
            int i;
            int k;
            int l;
            int i1;
            int j1;
            _rowY = new SparseIntArray(15);
            j1 = (int)(10F * _density);
            if (_mode != CaptionEvent.CaptionMode.POP_ON)
            {
                break MISSING_BLOCK_LABEL_330;
            }
            i1 = 0;
            l = 0;
            if (_style._textSize == 150)
            {
                k = 3;
            } else
            {
                k = 2;
            }
            i = 1;
_L6:
            if (i <= 15) goto _L4; else goto _L3
_L3:
            if (_mode != CaptionEvent.CaptionMode.ROLL_UP)
            {
                int j = 0;
                i = 15;
                while (i >= 1) 
                {
                    l = _rowY.get(i);
                    i1 = _ccLayoutHeight - l;
                    k = j;
                    if (l != -1)
                    {
                        if (i < 8)
                        {
                            k = j;
                        } else
                        if (i1 < 0)
                        {
                            k = i1 - j1;
                            _rowY.put(i, l + k);
                        } else
                        {
                            _rowY.put(i, l + j);
                            k = j;
                        }
                    }
                    i--;
                    j = k;
                }
            }
              goto _L5
_L4:
            if ((CaptionEvent.CaptionRow)_rows.get(i) != null)
            {
                if (i1 != 0 && i1 == i - 1)
                {
                    j = l + _ccRowSize;
                    _rowY.put(i, j);
                } else
                {
                    if (i < 5)
                    {
                        j = 1;
                    } else
                    if (i < 10)
                    {
                        j = k * 2;
                    } else
                    {
                        j = k * 3;
                    }
                    i1 = _ccRowSize * j + _ccRowOffsetY + j1 * 2;
                    j = i1;
                    if (i1 <= l)
                    {
                        j = _ccRowSize + l + j1 * 2;
                    }
                    _rowY.put(i, j);
                }
                i1 = i;
            } else
            {
                _rowY.put(i, -1);
                j = l;
            }
            i++;
            l = j;
              goto _L6
            if (_mode == CaptionEvent.CaptionMode.ROLL_UP)
            {
                j = _ccLayoutHeight - j1 * 2;
                i = 14;
                l = _rowCount;
                while (i >= 14 - (l - 1)) 
                {
                    k = j;
                    if (i != 14)
                    {
                        k = j - _ccRowSize;
                    }
                    _rowY.put(i, k);
                    i--;
                    j = k;
                }
            }
              goto _L3
        }

        private void drawRowBackground(Canvas canvas, float f, float f1, float f2, float f3)
        {
            if (_style == null || Color.alpha(_style.getBackgroundColor()) == 0)
            {
                return;
            } else
            {
                canvas.drawRect(f, f1, f2, f3, _backgroundPaint);
                return;
            }
        }

        private void drawRowText(Canvas canvas, float f, float f1, String s)
        {
            if (s.length() <= 0) goto _L2; else goto _L1
_L1:
            if (_style._edgeType == 0) goto _L4; else goto _L3
_L3:
            if (_style._edgeType != 1) goto _L6; else goto _L5
_L5:
            canvas.drawText(s, _density * 2.0F + f, _density * 2.0F + f1, _textEffect1Paint);
_L4:
            if (_style._edgeType != 3)
            {
                canvas.drawText(s, f, f1, _textPaint);
            }
_L2:
            return;
_L6:
            if (_style._edgeType == 3)
            {
                canvas.drawText(s, _density * 1.0F + f, f1 - _density * 2.0F, _textEffect2Paint);
                canvas.drawText(s, f - _density * 1.0F, _density * 1.0F + f1, _textPaint);
            } else
            if (_style._edgeType == 2)
            {
                canvas.drawText(s, _density * 2.0F + f, _density * 2.0F + f1, _textEffect2Paint);
                canvas.drawText(s, f - _density * 1.0F, f1 - _density * 1.0F, _textEffect1Paint);
            } else
            if (_style._edgeType == 4)
            {
                canvas.drawText(s, f, f1, _textEffect1Paint);
            }
            if (true) goto _L4; else goto _L7
_L7:
        }

        private void drawRowText(Canvas canvas, float f, float f1, Vector vector)
        {
            if (vector.size() <= 0) goto _L2; else goto _L1
_L1:
            _lineBuff.delete(0, _lineBuff.length());
            vector = vector.iterator();
_L6:
            if (vector.hasNext()) goto _L4; else goto _L3
_L3:
            drawRowText(canvas, f, f1, _lineBuff.toString());
_L2:
            return;
_L4:
            CaptionEvent.CaptionCharacter captioncharacter = (CaptionEvent.CaptionCharacter)vector.next();
            _lineBuff.append(captioncharacter.character());
            if (true) goto _L6; else goto _L5
_L5:
        }

        private void drawWindow(Canvas canvas, float f)
        {
            if (_style != null && Color.alpha(_style.getWindowColor()) != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            float f1;
            float f2;
            float f3;
            Object obj;
            int i;
            int k;
            boolean flag;
            int l;
            int j1;
            int i2;
            f1 = _ccRowSize;
            f3 = _ccColSize;
            i2 = (int)(10F * _density);
            f2 = 4F * _density;
            Vector vector;
            int j;
            if (_style._textSize != 150 && _style._textSize != 200)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (_mode != CaptionEvent.CaptionMode.POP_ON || _rows == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            vector = new Vector();
            i = 0;
            j = 1;
_L10:
            if (j > 15) goto _L1; else goto _L3
_L3:
            obj = (CaptionEvent.CaptionRow)_rows.get(j);
            k = i;
            if (obj != null)
            {
                k = i;
                if (i == 0)
                {
                    k = j;
                    vector.clear();
                }
                l = (int)Math.floor((float)(((CaptionEvent.CaptionRow) (obj)).getColumn() + ((CaptionEvent.CaptionRow) (obj)).getIndent()) * (f3 * f) + (float)_ccColOffsetX);
                i = (int)((float)(j - 1) * f1 + (float)_ccRowOffsetY + (float)i2);
                if (flag)
                {
                    i = (int)((float)_rowY.get(j) - f1);
                }
                vector.add(new Rect(l, i, l + (int)(_textPaint.measureText(((CaptionEvent.CaptionRow) (obj)).getText()) + (float)(_textPadding * 2)), i + (int)f1));
            }
            if (obj == null) goto _L5; else goto _L4
_L4:
            i = k;
            if (j != 15) goto _L6; else goto _L5
_L5:
            i = k;
            if (k == 0) goto _L6; else goto _L7
_L7:
            j1 = 9999;
            i = 9999;
            l = 0;
            k = 0;
            if (vector == null || vector.size() <= 0) goto _L9; else goto _L8
_L8:
            obj = vector.iterator();
_L11:
            if (((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_417;
            }
            canvas.drawRect((float)j1 - f2, (float)i - f2, (float)l + f2, (float)k + f2, _windowPaint);
_L9:
            i = 0;
            vector.clear();
_L6:
            j++;
              goto _L10
            Rect rect = (Rect)((Iterator) (obj)).next();
            int i1 = j1;
            if (rect.left < j1)
            {
                i1 = rect.left;
            }
            int k1 = i;
            if (rect.top < i)
            {
                k1 = rect.top;
            }
            int l1 = l;
            if (rect.right > l)
            {
                l1 = rect.right;
            }
            l = l1;
            j1 = i1;
            i = k1;
            if (rect.bottom > k)
            {
                k = rect.bottom;
                l = l1;
                j1 = i1;
                i = k1;
            }
              goto _L11
            if (_mode != CaptionEvent.CaptionMode.ROLL_UP || _rowCount <= 0) goto _L1; else goto _L12
_L12:
            f3 = 10F * (f3 * f) + (float)_ccColOffsetX;
            if (flag)
            {
                f = (float)_rowY.get(14 - (_rowCount - 1)) - f1;
            } else
            {
                f = (float)(14 - _rowCount) * f1 + (float)_ccRowOffsetY + (float)i2;
            }
            canvas.drawRect(f3 - f2, f - f2, f3 + (_textPaint.measureText("W") * 32F + (float)(_textPadding * 2)) + f2, (float)_rowCount * f1 + f + f2, _windowPaint);
            return;
        }

        private int reverseColorsWithAlpha(int i, int j)
        {
            return 0xffffff - (i | j) | i & j;
        }

        protected void clear(boolean flag)
        {
            if (flag)
            {
                if (_handler.hasMessages(1))
                {
                    _handler.removeMessages(1);
                }
                _overlayView._mode = CaptionEvent.CaptionMode.UNKNOWN;
                _overlayView.invalidate();
                _hasContent = false;
                return;
            } else
            {
                _handler.sendEmptyMessageDelayed(1, 2000L);
                return;
            }
        }

        protected boolean hasContent()
        {
            return _hasContent;
        }

        protected void onDraw(Canvas canvas)
        {
            float f;
            float f1;
            float f2;
            float f7;
            float f8;
            Object obj;
            int i;
            boolean flag;
            int k;
            super.onDraw(canvas);
            float f9;
            float f12;
            int j;
            if (_style._textSize != 150 && _style._textSize != 200)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            f7 = _ccRowSize;
            f8 = _ccColSize;
            _style._textSize;
            JVM INSTR lookupswitch 2: default 88
        //                       150: 401
        //                       200: 408;
               goto _L1 _L2 _L3
_L1:
            f = 1.0F;
_L12:
            k = (int)(10F * _density);
            drawWindow(canvas, f);
            if (_mode != CaptionEvent.CaptionMode.POP_ON || _rows == null) goto _L5; else goto _L4
_L4:
            i = 0;
_L13:
            if (i < _rows.size()) goto _L7; else goto _L6
_L6:
            _hasContent = true;
_L15:
            if (_previewText == null) goto _L9; else goto _L8
_L8:
            j = _previewText.size();
            i = j;
            if (j > 3)
            {
                i = 3;
            }
            j = i;
            if ((_previewRow + i) - 1 > 15)
            {
                j = (15 - _previewRow) + 1;
            }
            f9 = 4F * _density;
            f12 = (float)_previewColumn * (f8 * f) + (float)_ccColOffsetX;
            f1 = (float)(_previewRow - 1) * f7 + (float)_ccRowOffsetY + (float)k;
            if (flag)
            {
                float f4;
                float f10;
                float f13;
                float f15;
                Object obj1;
                CaptionEvent.CaptionCharacter captioncharacter;
                if (_style._textSize == 150)
                {
                    i = 3;
                } else
                {
                    i = 2;
                }
                if (_previewRow < 5)
                {
                    i = 1;
                } else
                if (_previewRow < 10)
                {
                    i *= 2;
                } else
                {
                    i *= 3;
                }
                f1 = _ccRowSize * i + _ccRowOffsetY + k * 2;
            }
            f2 = 0.0F;
            obj = _previewText.iterator();
_L21:
            if (((Iterator) (obj)).hasNext()) goto _L11; else goto _L10
_L10:
            canvas.drawRect(f12 - f9, f1 - f9, f12 + f2 + f9 + (float)(_textPadding * 2), (float)j * f7 + f1 + f9, _windowPaint);
            i = 0;
_L22:
            if (i < j)
            {
                break MISSING_BLOCK_LABEL_969;
            }
            _hasContent = true;
_L9:
            return;
_L2:
            f = 0.75F;
              goto _L12
_L3:
            f = 0.4F;
              goto _L12
_L7:
            obj = (CaptionEvent.CaptionRow)_rows.valueAt(i);
            f2 = _textPaint.measureText(((CaptionEvent.CaptionRow) (obj)).getText());
            f4 = _textPaint.ascent();
            f10 = (float)(((CaptionEvent.CaptionRow) (obj)).getColumn() + ((CaptionEvent.CaptionRow) (obj)).getIndent()) * (f8 * f) + (float)_ccColOffsetX;
            if (flag)
            {
                f1 = _rowY.get(((CaptionEvent.CaptionRow) (obj)).getRow());
            } else
            {
                f1 = (float)((CaptionEvent.CaptionRow) (obj)).getRow() * f7 + (float)_ccRowOffsetY + (float)k;
            }
            f13 = _textPadding;
            f15 = (float)_textPadding / _density;
            drawRowBackground(canvas, f10, f1 - f7, f10 + f2 + (float)(_textPadding * 2), f1);
            drawRowText(canvas, f10 + f13, (f1 - f7) + -1F * f4 + f15, ((CaptionEvent.CaptionRow) (obj)).getCharacters());
            i++;
              goto _L13
_L5:
            if (_mode != CaptionEvent.CaptionMode.ROLL_UP) goto _L15; else goto _L14
_L14:
            i = (14 - _rowCount) + 1;
_L19:
label0:
            {
                if (i <= 14)
                {
                    break label0;
                }
                _hasContent = true;
            }
              goto _L15
            obj = (CaptionEvent.CaptionRow)_rows.get(i);
            if (obj == null) goto _L17; else goto _L16
_L16:
            obj1 = ((CaptionEvent.CaptionRow) (obj)).getCharacters();
            if (((Vector) (obj1)).size() <= 0) goto _L17; else goto _L18
_L18:
            _lineBuff.delete(0, _lineBuff.length());
            obj1 = ((Vector) (obj1)).iterator();
_L20:
            if (((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_851;
            }
            f2 = _textPaint.measureText(_lineBuff.toString());
            f4 = _textPaint.ascent();
            f10 = 10F * (f8 * f) + (float)_ccColOffsetX;
            if (flag)
            {
                f1 = _rowY.get(i);
            } else
            {
                f1 = (float)i * f7 + (float)_ccRowOffsetY + (float)k;
            }
            f13 = _textPadding;
            f15 = (float)_textPadding / _density;
            drawRowBackground(canvas, f10, f1 - f7, f10 + f2 + (float)(_textPadding * 2), f1);
            drawRowText(canvas, f10 + f13, (f1 - f7) + -1F * f4 + f15, ((CaptionEvent.CaptionRow) (obj)).getCharacters());
_L17:
            i++;
              goto _L19
            captioncharacter = (CaptionEvent.CaptionCharacter)((Iterator) (obj1)).next();
            _lineBuff.append(captioncharacter.character());
              goto _L20
_L11:
            float f5 = _textPaint.measureText((String)((Iterator) (obj)).next());
            if (f5 > f2)
            {
                f2 = f5;
            }
              goto _L21
            float f6 = _textPaint.measureText((String)_previewText.get(i));
            float f11 = _textPaint.ascent();
            float f14 = (float)_previewColumn * (f8 * f) + (float)_ccColOffsetX;
            float f3 = (float)(_previewRow + i) * f7 + (float)_ccRowOffsetY + (float)k;
            if (flag)
            {
                f3 = f1 + (float)(i + 1) * f7;
            }
            float f16 = _textPadding;
            float f17 = (float)_textPadding / _density;
            drawRowBackground(canvas, f14, f3 - f7, f14 + f6 + (float)(_textPadding * 2), f3);
            drawRowText(canvas, f14 + f16, (f3 - f7) + -1F * f11 + f17, (String)_previewText.get(i));
            i++;
              goto _L22
        }

        protected void onSizeChanged(int i, int j, int k, int l)
        {
            Log.d("upLynkCaptionOverlay", String.format("View Size Changed: %dx%d -> %dx%d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i), Integer.valueOf(j)
            }));
            super.onSizeChanged(i, j, k, l);
        }

        protected void renderCaptionEvent(CaptionEvent captionevent)
        {
            boolean flag;
            _handler.removeMessages(1);
            flag = false;
            if (captionevent.mode != CaptionEvent.CaptionMode.ROLL_UP)
            {
                break MISSING_BLOCK_LABEL_318;
            }
            if (_mode != captionevent.mode)
            {
                _rows = new SparseArray(14);
            }
            _rowCount = captionevent.rowCount;
            if (_mode != captionevent.mode || _rowCount != captionevent.rowCount)
            {
                flag = true;
            }
            if (captionevent.eventType != CaptionEvent.CaptionEventType.LINEBREAK) goto _L2; else goto _L1
_L1:
            int i;
            short word0;
            i = 1;
            word0 = _rowCount;
_L7:
            if (i <= (14 - word0) + 1) goto _L4; else goto _L3
_L3:
            i = (14 - _rowCount) + 1;
_L8:
            if (i <= 14) goto _L6; else goto _L5
_L5:
            i = ((flag) ? 1 : 0);
_L9:
            _mode = captionevent.mode;
            if (i != 0)
            {
                configureOversizedRowPositions();
            }
            postInvalidate();
            _handler.sendEmptyMessageDelayed(1, 4000L);
            return;
_L4:
            if (_rows.get(i) != null)
            {
                _rows.delete(i);
            }
            i++;
              goto _L7
_L6:
            CaptionEvent.CaptionRow captionrow = (CaptionEvent.CaptionRow)_rows.get(i);
            if (captionrow != null)
            {
                _rows.put(i - 1, captionrow);
                _rows.delete(i);
            }
            i++;
              goto _L8
_L2:
            i = ((flag) ? 1 : 0);
            if (captionevent.eventType == CaptionEvent.CaptionEventType.TEXT)
            {
                CaptionEvent.CaptionRow captionrow2 = (CaptionEvent.CaptionRow)_rows.get(14);
                CaptionEvent.CaptionRow captionrow1 = captionrow2;
                if (captionrow2 == null)
                {
                    captionevent.getClass();
                    captionrow1 = new CaptionEvent.CaptionRow(captionevent);
                }
                captionrow1.getCharacters().add(captionevent.character);
                _rows.put(14, captionrow1);
                i = ((flag) ? 1 : 0);
            }
              goto _L9
            _rows = captionevent.rows;
            i = 1;
              goto _L9
        }

        protected void setFontMetrics(float f, float f1, int i)
        {
            _density = f;
            _textSize = f1;
            _textPadding = Math.round((float)i * f);
            if (_textPaint != null)
            {
                _textPaint.setTextSize(f1 * f);
            }
            if (_textEffect1Paint != null)
            {
                _textEffect1Paint.setTextSize(f1 * f);
            }
            if (_textEffect2Paint != null)
            {
                _textEffect2Paint.setTextSize(f1 * f);
            }
        }

        protected void setPreviewText(int i, int j, String s)
        {
            this;
            JVM INSTR monitorenter ;
            if (s != null) goto _L2; else goto _L1
_L1:
            if (_previewText != null)
            {
                _previewText.clear();
            }
            _previewText = null;
            _previewRow = 7;
            _previewColumn = 5;
_L4:
            this;
            JVM INSTR monitorexit ;
            invalidate();
            return;
_L2:
            if (i < 1 || i > 15)
            {
                i = 7;
            }
            _previewRow = i;
            if (j < 1 || j > 32)
            {
                j = 5;
            }
            _previewColumn = j;
            _previewText = new Vector();
_L6:
            if (s.length() <= 0) goto _L4; else goto _L3
_L3:
            if (s.length() <= 32)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            i = 32;
_L7:
            String s1 = s.substring(0, i);
            Log.d("upLynkCaptionOverlay", String.format("Caption Preview {%d} %s", new Object[] {
                Integer.valueOf(i), s1
            }));
            _previewText.add(s1);
            s = s.substring(i);
            if (true) goto _L6; else goto _L5
_L5:
              goto _L4
            i = s.length();
              goto _L7
            s;
            this;
            JVM INSTR monitorexit ;
            throw s;
              goto _L4
        }

        protected void setStyle(CaptionStyle captionstyle)
        {
            _style = captionstyle;
            _textPaint = new Paint();
            _textPaint.setAntiAlias(true);
            _textPaint.setColor(captionstyle.getTextColor());
            _textPaint.setTypeface(captionstyle.getTypeface());
            _textDebugPaint = new Paint();
            _textDebugPaint.setColor(0xffff0000);
            _backgroundPaint = new Paint();
            _backgroundPaint.setColor(captionstyle.getBackgroundColor());
            _windowPaint = new Paint();
            _windowPaint.setColor(captionstyle.getWindowColor());
            if (_style._edgeType == 0)
            {
                _textEffect1Paint = null;
                _textEffect2Paint = null;
            } else
            {
                _textEffect1Paint = new Paint();
                _textEffect1Paint.setAntiAlias(true);
                _textEffect1Paint.setTypeface(captionstyle.getTypeface());
                _textEffect2Paint = new Paint();
                _textEffect2Paint.setAntiAlias(true);
                _textEffect2Paint.setTypeface(captionstyle.getTypeface());
                if (_style._edgeType == 1)
                {
                    _textEffect1Paint.setColor(0x55000000);
                    return;
                }
                if (_style._edgeType == 3)
                {
                    _textEffect2Paint.setColor(0x66222222);
                    return;
                }
                if (_style._edgeType == 2)
                {
                    _textEffect1Paint.setColor(0xbbffffff);
                    _textEffect2Paint.setColor(0x99222222);
                    return;
                }
                if (_style._edgeType == 4)
                {
                    int i = complimentShadeWithAlpha(captionstyle.getTextColor(), 255);
                    _textEffect1Paint.setColor(i);
                    _textEffect1Paint.setStrokeWidth(2.0F * _density);
                    _textEffect1Paint.setStyle(android.graphics.Paint.Style.STROKE);
                    return;
                }
            }
        }


        public OverlayView(Context context, AttributeSet attributeset)
        {
            this$0 = CaptionManager.this;
            super(context, attributeset);
            _handler = null;
            _density = 1.0F;
            _textSize = 12F;
            _textPadding = 0;
            _rows = null;
            _rowY = null;
            _mode = CaptionEvent.CaptionMode.UNKNOWN;
            _style = null;
            _lineBuff = new StringBuffer();
            _previewText = null;
            _previewColumn = 5;
            _previewRow = 7;
            _hasContent = false;
            setFocusable(false);
            setWillNotCacheDrawing(false);
            setWillNotDraw(false);
            _textPaint = new Paint();
            _backgroundPaint = new Paint();
            context = Looper.myLooper();
            if (context != null)
            {
                _handler = new OverlayHandler(this, context);
                return;
            }
            context = Looper.getMainLooper();
            if (context != null)
            {
                _handler = new OverlayHandler(this, context);
                return;
            } else
            {
                _handler = null;
                return;
            }
        }
    }

    private class _CaptionCharacter
    {

        private short _char;
        private int _color;
        private boolean _isItalic;
        private boolean _isTransparent;
        private boolean _isUnderlined;
        final CaptionManager this$0;

        short character()
        {
            return _char;
        }

        int color()
        {
            return _color;
        }

        boolean isItalic()
        {
            return _isItalic;
        }

        boolean isTransparent()
        {
            return _isTransparent;
        }

        boolean isUnderlined()
        {
            return _isUnderlined;
        }

        void reset()
        {
            _char = 32;
            _color = 0xffffff;
            _isItalic = false;
            _isUnderlined = false;
            _isTransparent = true;
        }

        void setTransparent()
        {
            _isTransparent = true;
        }

        void setValue(short word0, int i, boolean flag, boolean flag1)
        {
            _char = word0;
            _color = i;
            _isItalic = flag;
            _isUnderlined = flag1;
            _isTransparent = false;
        }

        CaptionEvent.CaptionCharacter toCaptionCharacter(CaptionEvent captionevent)
        {
            captionevent.getClass();
            return new CaptionEvent.CaptionCharacter(captionevent, _char, _color, _isItalic, _isUnderlined, _isTransparent);
        }

        _CaptionCharacter()
        {
            this$0 = CaptionManager.this;
            super();
            _char = 32;
            _color = 0xffffff;
            _isItalic = false;
            _isUnderlined = false;
            _isTransparent = true;
        }
    }

    private class _CaptionRow
    {

        private static final int ROW_LENGTH = 32;
        private int _row;
        private short characterPosition;
        private Vector characters;
        int color;
        private short endPos;
        boolean isItalic;
        boolean isUnderlined;
        private short startPos;
        final CaptionManager this$0;

        private void incrementPosition(int i)
        {
            if (characterPosition + i < characters.size())
            {
                characterPosition = (short)(characterPosition + i);
                return;
            } else
            {
                characterPosition = (short)(characters.size() - 1);
                return;
            }
        }

        void backspace()
        {
            if (characterPosition > 0)
            {
                ((_CaptionCharacter)characters.get(characterPosition)).reset();
                characterPosition = (short)(characterPosition - 1);
            }
        }

        void clearToEnd()
        {
            int i = characterPosition;
            do
            {
                if (i >= characters.size())
                {
                    return;
                }
                ((_CaptionCharacter)characters.get(i)).reset();
                i++;
            } while (true);
        }

        short[] getData()
        {
            short word1 = (short)((endPos - startPos) + 1);
            short word0 = word1;
            if (word1 + 4 < 0)
            {
                Log.w("upLynkCaptionManager", String.format("Invalid CC Row Data Size: %d vs %d", new Object[] {
                    Short.valueOf(startPos), Short.valueOf(endPos)
                }));
                word0 = 0;
                reset();
            }
            short aword0[] = new short[word0 + 4];
            aword0[0] = (short)_row;
            int i = (short)1;
            aword0[1] = characterPosition;
            i++;
            aword0[2] = startPos;
            i++;
            aword0[3] = word0;
            short word2 = (short)(i + 1);
            i = startPos;
            do
            {
                if (i > endPos)
                {
                    return aword0;
                }
                aword0[word2] = ((_CaptionCharacter)characters.get(i)).character();
                word2++;
                i++;
            } while (true);
        }

        String getMarkup()
        {
            StringBuffer stringbuffer = new StringBuffer();
            if ((short)((endPos - startPos) + 1) + 4 < 0)
            {
                Log.w("upLynkCaptionManager", String.format("Invalid CC Row Data Size: %d vs %d", new Object[] {
                    Short.valueOf(startPos), Short.valueOf(endPos)
                }));
                reset();
            }
            int j = 0xffffff;
            boolean flag4 = false;
            boolean flag1 = false;
            boolean flag = false;
            int i = startPos;
            do
            {
                if (i > endPos)
                {
                    if (flag1)
                    {
                        stringbuffer.append("</u>");
                    }
                    if (flag4)
                    {
                        stringbuffer.append("</em>");
                    }
                    return stringbuffer.toString();
                }
                _CaptionCharacter _lcaptioncharacter = (_CaptionCharacter)characters.get(i);
                boolean flag2 = flag4;
                String s;
                if (_lcaptioncharacter.isItalic() != flag4)
                {
                    int k;
                    boolean flag3;
                    if (_lcaptioncharacter.isItalic())
                    {
                        s = "<em>";
                    } else
                    {
                        s = "</em>";
                    }
                    stringbuffer.append(s);
                    flag2 = _lcaptioncharacter.isItalic();
                }
                flag3 = flag1;
                if (_lcaptioncharacter.isUnderlined() != flag1)
                {
                    if (_lcaptioncharacter.isUnderlined())
                    {
                        s = "<u>";
                    } else
                    {
                        s = "</u>";
                    }
                    stringbuffer.append(s);
                    flag3 = _lcaptioncharacter.isUnderlined();
                }
                flag1 = flag;
                if (_lcaptioncharacter.isTransparent() != flag)
                {
                    flag1 = _lcaptioncharacter.isTransparent();
                }
                k = j;
                if (_lcaptioncharacter.color() != j)
                {
                    k = _lcaptioncharacter.color();
                }
                stringbuffer.append((char)_lcaptioncharacter.character());
                i++;
                j = k;
                flag4 = flag2;
                flag = flag1;
                flag1 = flag3;
            } while (true);
        }

        String getText()
        {
            StringBuffer stringbuffer = new StringBuffer();
            Log.i("upLynkCaptionManager", String.format("Get Row Characters 0-%d {%d,%d}", new Object[] {
                Short.valueOf(characterPosition), Short.valueOf(startPos), Short.valueOf(endPos)
            }));
            int i = startPos;
            do
            {
                if (i > endPos)
                {
                    return stringbuffer.toString();
                }
                char c = (char)((_CaptionCharacter)characters.get(i)).character();
                Log.d("upLynkCaptionManager", String.format("CC [%d] %c", new Object[] {
                    Integer.valueOf(i), Character.valueOf(c)
                }));
                stringbuffer.append(c);
                i++;
            } while (true);
        }

        void reset()
        {
            isItalic = false;
            isUnderlined = false;
            color = 0xffffff;
            Iterator iterator = characters.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    characterPosition = 0;
                    startPos = 32;
                    endPos = -1;
                    return;
                }
                ((_CaptionCharacter)iterator.next()).reset();
            } while (true);
        }

        void setColumnIndex(short word0)
        {
            characterPosition = word0;
        }

        void tabIndex(int i)
        {
            incrementPosition(i);
        }

        CaptionEvent.CaptionRow toCaptionRow(CaptionEvent captionevent)
        {
            StringBuffer stringbuffer = new StringBuffer();
            Vector vector = new Vector();
            int i = startPos;
            do
            {
                if (i > endPos)
                {
                    captionevent.getClass();
                    return new CaptionEvent.CaptionRow(captionevent, _row, characterPosition, startPos, stringbuffer.toString(), vector);
                }
                _CaptionCharacter _lcaptioncharacter = (_CaptionCharacter)characters.get(i);
                stringbuffer.append((char)_lcaptioncharacter.character());
                vector.add(_lcaptioncharacter.toCaptionCharacter(captionevent));
                i++;
            } while (true);
        }

        void writeChar(char c)
        {
            _CaptionCharacter _lcaptioncharacter = (_CaptionCharacter)characters.get(characterPosition);
            if (_lcaptioncharacter == null)
            {
                Log.w("upLynkCaptionManager", String.format("Invalid CC Character Position: %d", new Object[] {
                    Short.valueOf(characterPosition)
                }));
                return;
            }
            _lcaptioncharacter.setValue((short)c, color, isItalic, isUnderlined);
            if (characterPosition < startPos)
            {
                startPos = characterPosition;
            }
            if (characterPosition > endPos)
            {
                endPos = characterPosition;
            }
            incrementPosition(1);
        }

        protected _CaptionRow(int i)
        {
            this$0 = CaptionManager.this;
            super();
            _row = 0;
            isItalic = false;
            isUnderlined = false;
            color = 0xffffff;
            _row = i;
            isItalic = false;
            isUnderlined = false;
            color = 0xfffffff;
            startPos = 32;
            endPos = -1;
            characterPosition = 0;
            characters = new Vector(32);
            i = 0;
            do
            {
                if (i >= 32)
                {
                    return;
                }
                characters.add(i, new _CaptionCharacter());
                i++;
            } while (true);
        }
    }


    private static int $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction[];
    private static final int CC_CLEAR = 0;
    private static final int CC_ROW_COUNT = 15;
    private static final int CC_STREAM = 2;
    protected static final int CC_STREAM_ROW = 14;
    private static final int CC_TEXT = 1;
    private static final String TAG = "upLynkCaptionManager";
    private static final String TAG_CC = "upLynkCaptionManager";
    private static final String TAG_OVERLAY = "upLynkCaptionOverlay";
    private static final boolean TRACE_CC = false;
    private StringBuffer _activeLineText;
    private int _activeRowCount;
    SparseArray _captions;
    private int _ccColOffsetX;
    private int _ccColSize;
    private int _ccColWidth;
    private RelativeLayout _ccContainer;
    private boolean _ccEnabled;
    private CCEventHandler _ccEventHandler;
    private int _ccLayoutHeight;
    private int _ccLayoutWidth;
    private int _ccRowHeight;
    private int _ccRowHeightNormal;
    private int _ccRowOffsetY;
    private int _ccRowSize;
    private int _ccRowSizeNormal;
    private CaptionChannel _currentChannel;
    int _currentChannelIndex;
    private char _lastData1;
    private char _lastData2;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener _layoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

        final CaptionManager this$0;

        public void onGlobalLayout()
        {
            int j = 0;
            int i = 0;
            if (_ccContainer != null)
            {
                j = _ccContainer.getWidth();
                i = _ccContainer.getHeight();
            }
            if (j != _ccLayoutWidth || i != _ccLayoutHeight)
            {
                updateMetrics();
            }
        }

            
            {
                this$0 = CaptionManager.this;
                super();
            }
    };
    private WeakReference _mp;
    private OverlayView _overlayView;
    int _preferredChannelIndex;
    private CaptionStyle _style;
    private float _videoAspectRatio;
    private int _videoHeight;
    private int _videoWidth;
    private boolean inXdsMode;

    static int[] $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction()
    {
        int ai[] = $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[CaptionAction.values().length];
        try
        {
            ai[CaptionAction.BACKSPACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            ai[CaptionAction.CLEAR_ALL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            ai[CaptionAction.CLEAR_EOR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai[CaptionAction.COLOR.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai[CaptionAction.COLUMN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai[CaptionAction.ERASE_DISPLAY_MEM.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[CaptionAction.FLUSH.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[CaptionAction.INDENT.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[CaptionAction.ITALIC.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[CaptionAction.LINEBREAK.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[CaptionAction.START_NEW_ROW.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[CaptionAction.TEXT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[CaptionAction.UNDERLINED.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[CaptionAction.UNKNOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction = ai;
        return ai;
    }

    private CaptionManager()
    {
        _ccRowSize = 0;
        _ccRowSizeNormal = 0;
        _ccRowHeight = 0;
        _ccRowHeightNormal = 0;
        _ccRowOffsetY = 0;
        _ccColSize = 0;
        _ccColWidth = 0;
        _ccColOffsetX = 0;
        _videoAspectRatio = 1.7777F;
        _videoWidth = 0;
        _videoHeight = 0;
        _ccLayoutWidth = 0;
        _ccLayoutHeight = 0;
        _activeRowCount = 1;
        inXdsMode = false;
        _currentChannelIndex = 0;
        _preferredChannelIndex = 0;
        _layoutListener = null;
    }

    protected CaptionManager(MediaPlayer mediaplayer)
    {
        _ccRowSize = 0;
        _ccRowSizeNormal = 0;
        _ccRowHeight = 0;
        _ccRowHeightNormal = 0;
        _ccRowOffsetY = 0;
        _ccColSize = 0;
        _ccColWidth = 0;
        _ccColOffsetX = 0;
        _videoAspectRatio = 1.7777F;
        _videoWidth = 0;
        _videoHeight = 0;
        _ccLayoutWidth = 0;
        _ccLayoutHeight = 0;
        _activeRowCount = 1;
        inXdsMode = false;
        _currentChannelIndex = 0;
        _preferredChannelIndex = 0;
        _layoutListener = null;
        _mp = new WeakReference(mediaplayer);
        _ccEnabled = false;
        _style = new CaptionStyle();
        _captions = new SparseArray();
        _activeLineText = new StringBuffer();
    }

    private boolean checkForDuplicateCommands(char c, char c1)
    {
        return _lastData1 == c && _lastData2 == c1;
    }

    private static short[] concat(short aword0[], short aword1[])
    {
        short aword2[] = Arrays.copyOf(aword0, aword0.length + aword1.length);
        System.arraycopy(aword1, 0, aword2, aword0.length, aword1.length);
        return aword2;
    }

    private void decodeCCStyle(char c)
    {
        if ((c & 0x10) == 16)
        {
            int i = 0;
            if ((c & 0xe) == 0)
            {
                i = 0;
            } else
            if ((c & 0xe) == 2)
            {
                i = 4;
            } else
            if ((c & 0xe) == 4)
            {
                i = 8;
            } else
            if ((c & 0xe) == 6)
            {
                i = 12;
            } else
            if ((c & 0xe) == 8)
            {
                i = 16;
            } else
            if ((c & 0xe) == 10)
            {
                i = 20;
            } else
            if ((c & 0xe) == 12)
            {
                i = 24;
            } else
            if ((c & 0xe) == 14)
            {
                i = 28;
            }
            _currentChannel.column(i);
            _currentChannel.color(0xffffff);
        } else
        if ((c & 0xe) == 0)
        {
            _currentChannel.color(0xffffff);
        } else
        if ((c & 0xe) == 2)
        {
            _currentChannel.color(65280);
        } else
        if ((c & 0xe) == 4)
        {
            _currentChannel.color(255);
        } else
        if ((c & 0xe) == 6)
        {
            _currentChannel.color(65535);
        } else
        if ((c & 0xe) == 8)
        {
            _currentChannel.color(0xff0000);
        } else
        if ((c & 0xe) == 10)
        {
            _currentChannel.color(0xffff00);
        } else
        if ((c & 0xe) == 12)
        {
            _currentChannel.color(0xff00ff);
        } else
        if ((c & 0xe) == 14)
        {
            _currentChannel.italic();
        }
        if ((c & '\001') == 1)
        {
            _currentChannel.underlined();
        }
    }

    protected void clearDisplay()
    {
        clearDisplay(false);
    }

    protected void clearDisplay(boolean flag)
    {
        if (_overlayView != null)
        {
            _overlayView.clear(flag);
        }
    }

    protected CCEventHandler getEventHandler()
    {
        return _ccEventHandler;
    }

    protected void processPacket(char c, char c1, char c2)
    {
        char c3;
        char c4;
        c3 = (char)(c & 0x7f);
        c4 = (char)(c1 & 0x7f);
        if (c3 != 0 || c4 != 0) goto _L2; else goto _L1
_L1:
        Log.w("upLynkCaptionManager", "Empty CC");
_L4:
        return;
_L2:
        if (c3 >= '\001' && c3 <= '\016' && c2 == '\001')
        {
            inXdsMode = true;
        }
        if (c3 == '\017' && inXdsMode && c2 == '\001')
        {
            inXdsMode = false;
            return;
        }
        if (c3 < '\020' || c3 >= '\037')
        {
            continue; /* Loop/switch isn't completed */
        }
        if (checkForDuplicateCommands(c3, c4)) goto _L4; else goto _L3
_L3:
        if ((c3 & 8) != 8 && c2 == 0)
        {
            updateCurrentChannel(0);
        } else
        if ((c3 & 8) == 8 && c2 == 0)
        {
            updateCurrentChannel(1);
        } else
        if ((c3 & 8) != 8 && c2 == '\001')
        {
            updateCurrentChannel(2);
        } else
        if ((c3 & 8) == 8 && c2 == '\001')
        {
            updateCurrentChannel(3);
        }
        if (_currentChannel == null || _currentChannelIndex != _preferredChannelIndex) goto _L4; else goto _L5
_L5:
        c = c3 & 0x77;
        c1 = c4 & 0x60;
        if (c == '\021' && c1 == '@')
        {
            _currentChannel.startNewRow(1);
            decodeCCStyle(c4);
        } else
        if (c == '\021' && c1 == '`')
        {
            _currentChannel.startNewRow(2);
            decodeCCStyle(c4);
        } else
        if (c == '\022' && c1 == '@')
        {
            _currentChannel.startNewRow(3);
            decodeCCStyle(c4);
        } else
        if (c == '\022' && c1 == '`')
        {
            _currentChannel.startNewRow(4);
            decodeCCStyle(c4);
        } else
        if (c == '\025' && c1 == '@')
        {
            _currentChannel.startNewRow(5);
            decodeCCStyle(c4);
        } else
        if (c == '\025' && c1 == '`')
        {
            _currentChannel.startNewRow(6);
            decodeCCStyle(c4);
        } else
        if (c == '\026' && c1 == '@')
        {
            _currentChannel.startNewRow(7);
            decodeCCStyle(c4);
        } else
        if (c == '\026' && c1 == '`')
        {
            _currentChannel.startNewRow(8);
            decodeCCStyle(c4);
        } else
        if (c == '\027' && c1 == '@')
        {
            _currentChannel.startNewRow(9);
            decodeCCStyle(c4);
        } else
        if (c == '\027' && c1 == '`')
        {
            _currentChannel.startNewRow(10);
            decodeCCStyle(c4);
        } else
        if (c == '\020' && c1 == '@')
        {
            _currentChannel.startNewRow(11);
            decodeCCStyle(c4);
        } else
        if (c == '\023' && c1 == '@')
        {
            _currentChannel.startNewRow(12);
            decodeCCStyle(c4);
        } else
        if (c == '\023' && c1 == '`')
        {
            _currentChannel.startNewRow(13);
            decodeCCStyle(c4);
        } else
        if (c == '\024' && c1 == '@')
        {
            _currentChannel.startNewRow(14);
            decodeCCStyle(c4);
        } else
        if (c == '\024' && c1 == '`')
        {
            _currentChannel.startNewRow(15);
            decodeCCStyle(c4);
        }
        if (c == '\021' && (c4 & 0x70) == 32)
        {
            decodeCCStyle(c4);
            _currentChannel.appendText(' ');
        }
        if (c == '\024' && c4 == ' ')
        {
            _currentChannel.mode(CaptionEvent.CaptionMode.POP_ON);
        } else
        if (c == '\024' && c4 == '!')
        {
            _currentChannel.backspace();
        } else
        if (c == '\024' && c4 == '$')
        {
            _currentChannel.clearEndOfRow();
        } else
        if (c == '\024' && c4 == '%')
        {
            _currentChannel.mode(CaptionEvent.CaptionMode.ROLL_UP);
            _currentChannel.rowCount = 2;
        } else
        if (c == '\024' && c4 == '&')
        {
            _currentChannel.mode(CaptionEvent.CaptionMode.ROLL_UP);
            _currentChannel.rowCount = 3;
        } else
        if (c == '\024' && c4 == '\'')
        {
            _currentChannel.mode(CaptionEvent.CaptionMode.ROLL_UP);
            _currentChannel.rowCount = 4;
        } else
        if (c != '\024' || c4 != '(')
        {
            if (c == '\024' && c4 == ')')
            {
                _currentChannel.mode(CaptionEvent.CaptionMode.PAINT_ON);
            } else
            if ((c != '\024' || c4 != '*') && (c != '\024' || c4 != '+'))
            {
                if (c == '\024' && c4 == ',')
                {
                    _currentChannel.eraseDisplayMemory();
                } else
                if (c == '\024' && c4 == '-')
                {
                    _currentChannel.linebreak();
                } else
                if (c == '\024' && c4 == '.')
                {
                    _currentChannel.clearAll();
                } else
                if (c == '\024' && c4 == '/')
                {
                    _currentChannel.flush();
                } else
                if (c == '\027' && c4 == '!')
                {
                    _currentChannel.indent(1);
                } else
                if (c == '\027' && c4 == '"')
                {
                    _currentChannel.indent(2);
                } else
                if (c == '\027' && c4 == '#')
                {
                    _currentChannel.indent(3);
                }
            }
        }
        if (c == '\021' && (c4 & 0x70) == 48)
        {
            c = c4 & 0xf;
            if (c == 0)
            {
                _currentChannel.appendText('\251');
            } else
            if (c == '\001')
            {
                _currentChannel.appendText('\247');
            } else
            if (c == '\002')
            {
                _currentChannel.appendText('\253');
            } else
            if (c == '\003')
            {
                _currentChannel.appendText('\250');
            } else
            if (c == '\004')
            {
                _currentChannel.appendText('\u2122');
            } else
            if (c == '\005')
            {
                _currentChannel.appendText('\233');
            } else
            if (c == '\006')
            {
                _currentChannel.appendText('\234');
            } else
            if (c == '\007')
            {
                _currentChannel.appendText('\u266A');
            } else
            if (c == '\b')
            {
                _currentChannel.appendText('\205');
            } else
            if (c == '\t')
            {
                _currentChannel.appendText(' ');
            } else
            if (c == '\n')
            {
                _currentChannel.appendText('\212');
            } else
            if (c == '\013')
            {
                _currentChannel.appendText('\203');
            } else
            if (c == '\f')
            {
                _currentChannel.appendText('\210');
            } else
            if (c == '\r')
            {
                _currentChannel.appendText('\214');
            } else
            if (c == '\016')
            {
                _currentChannel.appendText('\223');
            } else
            if (c == '\017')
            {
                _currentChannel.appendText('\226');
            }
        }
_L8:
        _lastData1 = c3;
        _lastData2 = c4;
        return;
        if (inXdsMode && c2 == '\001') goto _L4; else goto _L6
_L6:
        if (c3 < ' ' || c3 >= '~') goto _L8; else goto _L7
_L7:
        if (c2 == 0 && _currentChannelIndex == 2)
        {
            updateCurrentChannel(0);
        } else
        if (c2 == 0 && _currentChannelIndex == 3)
        {
            updateCurrentChannel(1);
        } else
        if (c2 == '\001' && _currentChannelIndex == 0)
        {
            updateCurrentChannel(2);
        } else
        if (c2 == '\001' && _currentChannelIndex == 1)
        {
            updateCurrentChannel(3);
        }
        if (_currentChannel == null) goto _L4; else goto _L9
_L9:
        _currentChannel.appendText(c3);
        if (c4 >= ' ' && c4 < '~')
        {
            _currentChannel.appendText(c4);
        }
          goto _L8
    }

    protected void release()
    {
        if (_ccEventHandler != null)
        {
            _ccEventHandler.removeCallbacksAndMessages(null);
            _ccEventHandler = null;
        }
        reset();
        setLayoutContainer(null);
        _layoutListener = null;
        _activeLineText = null;
        _style = null;
        _mp = null;
    }

    protected void renderCCData(int i, short aword0[])
    {
        StringBuffer stringbuffer;
        int j;
        j = 0;
        stringbuffer = new StringBuffer();
        clearDisplay();
_L2:
        if (j + 3 >= i)
        {
            if (_ccEnabled && _ccContainer != null)
            {
                _ccEventHandler.sendEmptyMessageDelayed(0, 4000L);
            }
            return;
        }
        int k = aword0[j];
        k = aword0[j + 1];
        k = aword0[j + 2];
        short word0 = aword0[j + 3];
        k = j + 4;
        if (i == 4)
        {
            Log.e("upLynkCaptionManager", (new StringBuilder("CC Packet Data Size 4, text size = ")).append(word0).toString());
            return;
        }
        if (word0 > 32)
        {
            Log.e("upLynkCaptionManager", (new StringBuilder("CC Packet Row Length > 32 (")).append(word0).append(")").toString());
            return;
        }
        j = k;
        do
        {
label0:
            {
                if (j < word0 + k)
                {
                    break label0;
                }
                j = k + word0;
                stringbuffer.delete(0, stringbuffer.length());
            }
            if (true)
            {
                continue;
            }
            stringbuffer.append((char)aword0[j]);
            j++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void renderCCStreamItem(CaptionQueueItem captionqueueitem)
    {
        if (_currentChannelIndex != captionqueueitem.channel)
        {
            Log.w("upLynkCaptionManager", "IGNORING CaptionQueueItem From Wrong Channel");
        }
        $SWITCH_TABLE$com$uplynk$media$CaptionManager$CaptionAction()[captionqueueitem.action.ordinal()];
        JVM INSTR tableswitch 1 14: default 100
    //                   1 100
    //                   2 302
    //                   3 100
    //                   4 100
    //                   5 100
    //                   6 268
    //                   7 100
    //                   8 100
    //                   9 100
    //                   10 100
    //                   11 282
    //                   12 100
    //                   13 292
    //                   14 100;
           goto _L1 _L1 _L2 _L1 _L1 _L1 _L3 _L1 _L1 _L1 _L1 _L4 _L1 _L5 _L1
_L1:
        boolean flag;
        boolean flag1;
        CaptionEvent captionevent;
        if (((MediaPlayer)_mp.get()).mOnCaptionEventListener != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (_overlayView != null && _ccEnabled)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag && !flag1) goto _L7; else goto _L6
_L6:
        if (captionqueueitem.action != CaptionAction.TEXT) goto _L9; else goto _L8
_L8:
        captionevent = new CaptionEvent(_currentChannel._mode, CaptionEvent.CaptionEventType.TEXT, _currentChannel.rowCount);
        captionevent.getClass();
        captionevent.character = new CaptionEvent.CaptionCharacter(captionevent, (short)captionqueueitem.value, _currentChannel._color, _currentChannel._italic, _currentChannel._underlined, false);
        if (flag1)
        {
            _overlayView.renderCaptionEvent(captionevent);
        }
        if (flag)
        {
            ((MediaPlayer)_mp.get()).mOnCaptionEventListener.onCaptionEvent(_ccEventHandler._mediaPlayer, captionevent);
        }
_L7:
        return;
_L3:
        _currentChannel.doColor(captionqueueitem.value);
          goto _L1
_L4:
        _currentChannel.doItalic();
          goto _L1
_L5:
        _currentChannel.doUnderlined();
          goto _L1
_L2:
        _currentChannel.doAppendText((char)captionqueueitem.value);
          goto _L1
_L9:
        if (captionqueueitem.action != CaptionAction.LINEBREAK)
        {
            continue; /* Loop/switch isn't completed */
        }
        captionqueueitem = new CaptionEvent(_currentChannel._mode, CaptionEvent.CaptionEventType.LINEBREAK, _currentChannel.rowCount);
        if (flag1)
        {
            _overlayView.renderCaptionEvent(captionqueueitem);
        }
        if (!flag) goto _L7; else goto _L10
_L10:
        ((MediaPlayer)_mp.get()).mOnCaptionEventListener.onCaptionEvent(_ccEventHandler._mediaPlayer, captionqueueitem);
        return;
        if (captionqueueitem.action != CaptionAction.ERASE_DISPLAY_MEM) goto _L7; else goto _L11
_L11:
        captionqueueitem = new CaptionEvent(_currentChannel._mode, CaptionEvent.CaptionEventType.CLEAR, _currentChannel.rowCount);
        if (flag)
        {
            ((MediaPlayer)_mp.get()).mOnCaptionEventListener.onCaptionEvent(_ccEventHandler._mediaPlayer, captionqueueitem);
            return;
        }
          goto _L7
    }

    protected void reset()
    {
        _activeRowCount = 1;
        _activeLineText.setLength(0);
        if (_captions == null || _captions.size() <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < _captions.size()) goto _L3; else goto _L2
_L2:
        clearDisplay(true);
        return;
_L3:
        CaptionChannel captionchannel = (CaptionChannel)_captions.valueAt(i);
        if (captionchannel != null)
        {
            captionchannel.reset();
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void setCaptionStyle(CaptionStyle captionstyle)
    {
        _style = captionstyle;
        if (_overlayView != null)
        {
            _overlayView.setStyle(_style);
        }
        updateMetrics();
    }

    protected void setEnabled(boolean flag)
    {
        _ccEnabled = flag;
        if (!flag)
        {
            clearDisplay(true);
        }
    }

    protected void setEventHandler(CCEventHandler cceventhandler)
    {
        _ccEventHandler = cceventhandler;
    }

    public void setLayoutContainer(RelativeLayout relativelayout)
    {
        if (_ccContainer != null)
        {
            _ccContainer.getViewTreeObserver().removeGlobalOnLayoutListener(_layoutListener);
            if (_overlayView != null)
            {
                _ccContainer.removeView(_overlayView);
                _overlayView = null;
            }
        }
        _ccContainer = relativelayout;
        if (relativelayout == null)
        {
            return;
        } else
        {
            _overlayView = new OverlayView(_ccContainer.getContext(), null);
            _overlayView.setStyle(_style);
            relativelayout = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            _ccContainer.addView(_overlayView, relativelayout);
            updateMetrics();
            _ccContainer.getViewTreeObserver().addOnGlobalLayoutListener(_layoutListener);
            return;
        }
    }

    protected boolean setPreferredCaptionChannel(int i)
    {
        boolean flag = true;
        if (i < 0 || i > 3)
        {
            flag = false;
        } else
        if (i != _preferredChannelIndex)
        {
            _preferredChannelIndex = i;
            clearDisplay(true);
            return true;
        }
        return flag;
    }

    protected void setPreviewText(int i, int j, String s)
    {
        if (_overlayView != null)
        {
            _overlayView.setPreviewText(i, j, s);
        }
    }

    protected void setVideoSize(int i, int j)
    {
        _videoWidth = i;
        _videoHeight = j;
        _videoAspectRatio = (float)i / (float)j;
        updateMetrics();
    }

    protected void updateCurrentChannel(int i)
    {
        _currentChannelIndex = i;
        if (_captions.get(i) == null)
        {
            _captions.put(i, new CaptionChannel(i, this));
        }
        _currentChannel = (CaptionChannel)_captions.get(i);
    }

    protected void updateMetrics()
    {
        float f;
        if (_ccContainer == null)
        {
            _ccLayoutHeight = 0;
            _ccLayoutWidth = 0;
            _ccColWidth = 0;
            _ccRowHeight = 0;
            _ccColSize = 0;
            _ccRowSize = 0;
            return;
        }
        f = 1.0F;
        float f1;
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)_ccContainer.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        f1 = displaymetrics.density;
        f = f1;
_L2:
        int i1 = _ccContainer.getWidth();
        _ccLayoutWidth = i1;
        int j1 = _ccContainer.getHeight();
        _ccLayoutHeight = j1;
        int k1 = (int)(10F * f);
        float f2 = (float)i1 / (float)j1;
        int j = i1;
        int i = j1;
        int k;
        int l;
        if (_videoAspectRatio < f2)
        {
            j = (int)Math.ceil((float)i * _videoAspectRatio);
            k = (i1 - j) / 2;
            l = 0;
        } else
        {
            i = (int)Math.ceil((float)j / _videoAspectRatio);
            l = (j1 - i) / 2;
            k = 0;
        }
        _ccColOffsetX = k;
        _ccRowOffsetY = l;
        k1 = (i - k1 * 2) / 15;
        _ccRowSizeNormal = k1;
        _ccRowSize = k1;
        _ccColSize = j / 64;
        f2 = (float)((double)_style._textSize / 100D);
        _ccRowSize = (int)((float)_ccRowSize * f2);
        _ccRowHeightNormal = (int)Math.ceil((float)_ccRowSizeNormal / f);
        _ccRowHeight = (int)Math.ceil((float)_ccRowSize / f);
        _ccColWidth = (int)Math.ceil((float)_ccColSize / f);
        f2 = (float)_ccRowSize / (1.8F * f);
        k1 = (int)Math.floor(((float)_ccRowSize - f2) / 6F);
        if (_overlayView != null)
        {
            _overlayView.setFontMetrics(f, f2, k1);
        }
        Log.d("upLynkCaptionManager", String.format("CC Container %dx%d | Content %dx%d x:%d y:%d | rowSize:%d (%d)  colSize:%d (%d)  textSize:%f  textPadding:%d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(_ccRowSize), Integer.valueOf(_ccRowHeight), Integer.valueOf(_ccColSize), Integer.valueOf(_ccColWidth), 
            Float.valueOf(f2), Integer.valueOf(k1)
        }));
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }












}
