// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

// Referenced classes of package com.uplynk.media:
//            CaptionManager, CaptionEvent, MediaPlayer

protected class queue
{

    int _color;
    int _column;
    private int _index;
    boolean _italic;
    private WeakReference _mgr;
    NDERLINED _mode;
    int _row;
    private boolean _runTimer;
    private NDERLINED _timer;
    boolean _underlined;
    private NDERLINED currentRow;
    private int currentRowIndex;
    LinkedList queue;
    short rowCount;
    private SparseArray rows;
    final CaptionManager this$0;

    private void doAppendText(char c)
    {
        if (currentRow != null)
        {
            currentRow.teChar(c);
        }
    }

    private void doBackspace()
    {
        if (currentRow != null)
        {
            currentRow.kspace();
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
            currentRow.arToEnd();
        }
    }

    private void doColor(int i)
    {
        if (currentRow != null)
        {
            currentRow.or = i;
            currentRow.talic = false;
            currentRow.nderlined = false;
        }
    }

    private void doColumn(int i)
    {
        if (currentRow != null)
        {
            currentRow.ColumnIndex((short)i);
        }
    }

    private void doEraseDisplayMemory()
    {
        if (_mode == N)
        {
            ColumnIndex columnindex = ((CaptionManager)_mgr.get()).getEventHandler();
            if (columnindex != null)
            {
                columnindex.sendMessage(columnindex.obtainMessage(0, _index, 0, null));
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
        if (aword0.length <= 0 || _mode != N) goto _L2; else goto _L1
_L1:
        CaptionEvent captionevent;
        int i;
        doClearAll doclearall = ((CaptionManager)_mgr.get()).getEventHandler();
        if (doclearall != null)
        {
            doclearall.sendMessage(doclearall.obtainMessage(1, _index, aword0.length, aword0));
        }
        captionevent = new CaptionEvent(N, TEXT);
        i = 0;
_L6:
        if (i < rows.size()) goto _L4; else goto _L3
_L3:
        if (CaptionManager.access$2(CaptionManager.this) != null && CaptionManager.access$3(CaptionManager.this))
        {
            CaptionManager.access$2(CaptionManager.this).derCaptionEvent(captionevent);
        }
        if (((MediaPlayer)CaptionManager.access$4(CaptionManager.this).get()).mOnCaptionEventListener != null)
        {
            ((MediaPlayer)CaptionManager.access$4(CaptionManager.this).get()).mOnCaptionEventListener.onCaptionEvent(access._mth0(CaptionManager.access$0(CaptionManager.this)), captionevent);
        }
_L2:
        if (_mode == N)
        {
            doClearAll();
        }
        return;
_L4:
        int j = rows.keyAt(i);
        doClearAll doclearall1 = ((rows)rows.get(j)).aptionRow(captionevent);
        captionevent.rows.put(j, doclearall1);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void doIndent(int i)
    {
        if (currentRow != null)
        {
            currentRow.Index(i);
        }
    }

    private void doItalic()
    {
        if (currentRow != null)
        {
            currentRow.talic = true;
        }
    }

    private void doLinebreak()
    {
        if (currentRow != null && _mode != UP)
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
            currentRow.nderlined = true;
        }
    }

    private nderlined getCaptionRow(int i)
    {
        if (i > 0 && i <= 15)
        {
            nderlined nderlined1 = (nderlined)rows.get(i);
            nderlined nderlined = nderlined1;
            if (nderlined1 == null)
            {
                nderlined = new it>(CaptionManager.this, i);
                rows.put(i, nderlined);
            }
            return nderlined;
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
            aword0 = CaptionManager.access$1(aword0, ((rows)rows.get(j)).Data());
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
            String s2 = ((rows)rows.get(k)).Text();
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

    private transient void queueTask(boolean flag, Text text, int ai[])
    {
        m m;
        m = new m(CaptionManager.this);
        m.pause = flag;
        m.mode = _mode;
        m.channel = (short)_index;
        m.action = text;
        m.rowCount = rowCount;
        if (text != EXT) goto _L2; else goto _L1
_L1:
        m.value = ai[0];
_L4:
        this;
        JVM INSTR monitorenter ;
        queue.add(m);
        this;
        JVM INSTR monitorexit ;
        if (_timer == null)
        {
            startTimer();
        }
        return;
_L2:
        if (text == OLOR)
        {
            m.value = ai[0];
        }
        if (true) goto _L4; else goto _L3
_L3:
        text;
        this;
        JVM INSTR monitorexit ;
        throw text;
    }

    private void startTimer()
    {
        if (_timer == null)
        {
            _timer = new <init>(CaptionManager.this, this, Looper.getMainLooper());
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
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doAppendText(c);
            return;
        } else
        {
            queueTask(true, EXT, new int[] {
                c
            });
            return;
        }
    }

    void backspace()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doBackspace();
            return;
        } else
        {
            queueTask(false, ACKSPACE, new int[0]);
            return;
        }
    }

    void clearAll()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doClearAll();
            return;
        } else
        {
            queueTask(false, LEAR_ALL, new int[0]);
            return;
        }
    }

    void clearEndOfRow()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doClearEndOfRow();
            return;
        } else
        {
            queueTask(false, LEAR_EOR, new int[0]);
            return;
        }
    }

    void color(int i)
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doColor(i);
            return;
        } else
        {
            queueTask(false, OLOR, new int[] {
                i
            });
            return;
        }
    }

    void column(int i)
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doColumn(i);
            return;
        } else
        {
            queueTask(false, OLUMN, new int[] {
                i
            });
            return;
        }
    }

    void eraseDisplayMemory()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doEraseDisplayMemory();
            return;
        } else
        {
            queueTask(false, RASE_DISPLAY_MEM, new int[0]);
            return;
        }
    }

    void flush()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doFlush();
            return;
        } else
        {
            queueTask(false, LUSH, new int[0]);
            return;
        }
    }

    void indent(int i)
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doIndent(i);
            return;
        } else
        {
            queueTask(false, NDENT, new int[] {
                i
            });
            return;
        }
    }

    void italic()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doItalic();
            return;
        } else
        {
            queueTask(false, TALIC, new int[0]);
            return;
        }
    }

    void linebreak()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doLinebreak();
            return;
        } else
        {
            queueTask(false, INEBREAK, new int[0]);
            return;
        }
    }

    void mode(INEBREAK inebreak)
    {
        if (inebreak != _mode)
        {
            _mode = inebreak;
            if (_mode != N)
            {
                startTimer();
            } else
            {
                stopTimer();
                queue.clear();
            }
        }
        _mode = inebreak;
    }

    protected void reset()
    {
        stopTimer();
        queue.clear();
        _column = 0;
        _color = 0xffffff;
        _italic = false;
        _mode = WN;
        _row = 0;
        currentRowIndex = 0;
        currentRow = null;
        rowCount = 1;
        _underlined = false;
    }

    void startNewRow(int i)
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doStartNewRow(i);
            return;
        } else
        {
            queueTask(false, TART_NEW_ROW, new int[] {
                i
            });
            return;
        }
    }

    void underlined()
    {
        if (_mode == WN || _mode == _ON || _mode == _mode)
        {
            return;
        }
        if (_mode == N)
        {
            doUnderlined();
            return;
        } else
        {
            queueTask(false, NDERLINED, new int[0]);
            return;
        }
    }








    public m(int i, CaptionManager captionmanager1)
    {
        this$0 = CaptionManager.this;
        super();
        queue = null;
        _mode = WN;
        _timer = null;
        _runTimer = false;
        _column = 0;
        _color = 0xffffff;
        _italic = false;
        _mode = WN;
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
