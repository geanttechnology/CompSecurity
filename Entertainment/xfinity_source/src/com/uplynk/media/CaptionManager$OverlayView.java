// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.uplynk.media:
//            CaptionManager, CaptionStyle, CaptionEvent

private class _handler extends View
{

    protected static final int CLEAR_MSG = 1;
    private static final short STREAM_ROW = 14;
    Paint _backgroundPaint;
    float _density;
    er _handler;
    private boolean _hasContent;
    StringBuffer _lineBuff;
    er _mode;
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
        if (_mode != P_ON)
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
        if (_mode != LL_UP)
        {
            int j = 0;
            i = 15;
            while (i >= 1) 
            {
                l = _rowY.get(i);
                i1 = CaptionManager.access$7(CaptionManager.this) - l;
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
        if ((_rowY)_rows.get(i) != null)
        {
            if (i1 != 0 && i1 == i - 1)
            {
                j = l + CaptionManager.access$5(CaptionManager.this);
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
                i1 = CaptionManager.access$5(CaptionManager.this) * j + CaptionManager.access$6(CaptionManager.this) + j1 * 2;
                j = i1;
                if (i1 <= l)
                {
                    j = CaptionManager.access$5(CaptionManager.this) + l + j1 * 2;
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
        if (_mode == LL_UP)
        {
            j = CaptionManager.access$7(CaptionManager.this) - j1 * 2;
            i = 14;
            l = _rowCount;
            while (i >= 14 - (l - 1)) 
            {
                k = j;
                if (i != 14)
                {
                    k = j - CaptionManager.access$5(CaptionManager.this);
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
        er er = (er)vector.next();
        _lineBuff.append(er.character());
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
        f1 = CaptionManager.access$5(CaptionManager.this);
        f3 = CaptionManager.access$8(CaptionManager.this);
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
        if (_mode != P_ON || _rows == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        vector = new Vector();
        i = 0;
        j = 1;
_L10:
        if (j > 15) goto _L1; else goto _L3
_L3:
        obj = (_rows)_rows.get(j);
        k = i;
        if (obj != null)
        {
            k = i;
            if (i == 0)
            {
                k = j;
                vector.clear();
            }
            l = (int)Math.floor((float)(((_rows) (obj)).Column() + ((Column) (obj)).Indent()) * (f3 * f) + (float)CaptionManager.access$9(CaptionManager.this));
            i = (int)((float)(j - 1) * f1 + (float)CaptionManager.access$6(CaptionManager.this) + (float)i2);
            if (flag)
            {
                i = (int)((float)_rowY.get(j) - f1);
            }
            vector.add(new Rect(l, i, l + (int)(_textPaint.measureText(((_textPaint) (obj)).Text()) + (float)(_textPadding * 2)), i + (int)f1));
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
        if (_mode != LL_UP || _rowCount <= 0) goto _L1; else goto _L12
_L12:
        f3 = 10F * (f3 * f) + (float)CaptionManager.access$9(CaptionManager.this);
        if (flag)
        {
            f = (float)_rowY.get(14 - (_rowCount - 1)) - f1;
        } else
        {
            f = (float)(14 - _rowCount) * f1 + (float)CaptionManager.access$6(CaptionManager.this) + (float)i2;
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
            CaptionManager.access$2(CaptionManager.this)._mode = KNOWN;
            CaptionManager.access$2(CaptionManager.this).invalidate();
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
        f7 = CaptionManager.access$5(CaptionManager.this);
        f8 = CaptionManager.access$8(CaptionManager.this);
        _style._textSize;
        JVM INSTR lookupswitch 2: default 88
    //                   150: 401
    //                   200: 408;
           goto _L1 _L2 _L3
_L1:
        f = 1.0F;
_L12:
        k = (int)(10F * _density);
        drawWindow(canvas, f);
        if (_mode != P_ON || _rows == null) goto _L5; else goto _L4
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
        f12 = (float)_previewColumn * (f8 * f) + (float)CaptionManager.access$9(CaptionManager.this);
        f1 = (float)(_previewRow - 1) * f7 + (float)CaptionManager.access$6(CaptionManager.this) + (float)k;
        if (flag)
        {
            float f4;
            float f10;
            float f13;
            float f15;
            Object obj1;
            er er;
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
            f1 = CaptionManager.access$5(CaptionManager.this) * i + CaptionManager.access$6(CaptionManager.this) + k * 2;
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
        obj = (_hasContent)_rows.valueAt(i);
        f2 = _textPaint.measureText(((_textPaint) (obj)).Text());
        f4 = _textPaint.ascent();
        f10 = (float)(((_textPaint) (obj)).Column() + ((Column) (obj)).Indent()) * (f8 * f) + (float)CaptionManager.access$9(CaptionManager.this);
        if (flag)
        {
            f1 = _rowY.get(((_rowY) (obj)).Row());
        } else
        {
            f1 = (float)((Row) (obj)).Row() * f7 + (float)CaptionManager.access$6(CaptionManager.this) + (float)k;
        }
        f13 = _textPadding;
        f15 = (float)_textPadding / _density;
        drawRowBackground(canvas, f10, f1 - f7, f10 + f2 + (float)(_textPadding * 2), f1);
        drawRowText(canvas, f10 + f13, (f1 - f7) + -1F * f4 + f15, ((drawRowText) (obj)).Characters());
        i++;
          goto _L13
_L5:
        if (_mode != LL_UP) goto _L15; else goto _L14
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
        obj = (_hasContent)_rows.get(i);
        if (obj == null) goto _L17; else goto _L16
_L16:
        obj1 = ((_rows) (obj)).Characters();
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
        f10 = 10F * (f8 * f) + (float)CaptionManager.access$9(CaptionManager.this);
        if (flag)
        {
            f1 = _rowY.get(i);
        } else
        {
            f1 = (float)i * f7 + (float)CaptionManager.access$6(CaptionManager.this) + (float)k;
        }
        f13 = _textPadding;
        f15 = (float)_textPadding / _density;
        drawRowBackground(canvas, f10, f1 - f7, f10 + f2 + (float)(_textPadding * 2), f1);
        drawRowText(canvas, f10 + f13, (f1 - f7) + -1F * f4 + f15, ((drawRowText) (obj)).Characters());
_L17:
        i++;
          goto _L19
        er = (er)((Iterator) (obj1)).next();
        _lineBuff.append(er.character());
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
        float f14 = (float)_previewColumn * (f8 * f) + (float)CaptionManager.access$9(CaptionManager.this);
        float f3 = (float)(_previewRow + i) * f7 + (float)CaptionManager.access$6(CaptionManager.this) + (float)k;
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
        if (captionevent.mode != LL_UP)
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
        if (captionevent.eventType != pe.LINEBREAK) goto _L2; else goto _L1
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
        _previewText _lpreviewtext = (_rows)_rows.get(i);
        if (_lpreviewtext != null)
        {
            _rows.put(i - 1, _lpreviewtext);
            _rows.delete(i);
        }
        i++;
          goto _L8
_L2:
        i = ((flag) ? 1 : 0);
        if (captionevent.eventType == pe.TEXT)
        {
            _previewText _lpreviewtext2 = (pe.TEXT)_rows.get(14);
            _previewText _lpreviewtext1 = _lpreviewtext2;
            if (_lpreviewtext2 == null)
            {
                captionevent.getClass();
                _lpreviewtext1 = new it>(captionevent);
            }
            _lpreviewtext1.Characters().add(captionevent.character);
            _rows.put(14, _lpreviewtext1);
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
                _textEffect1Paint.setStyle(android.graphics._textEffect1Paint);
                return;
            }
        }
    }


    public er(Context context, AttributeSet attributeset)
    {
        this$0 = CaptionManager.this;
        super(context, attributeset);
        _handler = null;
        _density = 1.0F;
        _textSize = 12F;
        _textPadding = 0;
        _rows = null;
        _rowY = null;
        _mode = KNOWN;
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
            _handler = new er(CaptionManager.this, this, context);
            return;
        }
        context = Looper.getMainLooper();
        if (context != null)
        {
            _handler = new er(CaptionManager.this, this, context);
            return;
        } else
        {
            _handler = null;
            return;
        }
    }
}
