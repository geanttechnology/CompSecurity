// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.util.SparseArray;
import java.util.Vector;

public class CaptionEvent
{
    public class CaptionCharacter
    {

        private short _char;
        private int _color;
        private boolean _isItalic;
        private boolean _isTransparent;
        private boolean _isUnderlined;
        final CaptionEvent this$0;

        public char character()
        {
            return (char)_char;
        }

        public int color()
        {
            return _color;
        }

        public boolean isItalic()
        {
            return _isItalic;
        }

        public boolean isUnderlined()
        {
            return _isUnderlined;
        }

        private CaptionCharacter()
        {
            this$0 = CaptionEvent.this;
            super();
        }

        protected CaptionCharacter(short word0, int i, boolean flag, boolean flag1, boolean flag2)
        {
            this$0 = CaptionEvent.this;
            super();
            _char = word0;
            _color = i;
            _isItalic = flag;
            _isUnderlined = flag1;
            _isTransparent = flag2;
        }
    }

    public static final class CaptionEventType extends Enum
    {

        public static final CaptionEventType CLEAR;
        private static final CaptionEventType ENUM$VALUES[];
        public static final CaptionEventType LINEBREAK;
        public static final CaptionEventType TEXT;

        public static CaptionEventType valueOf(String s)
        {
            return (CaptionEventType)Enum.valueOf(com/uplynk/media/CaptionEvent$CaptionEventType, s);
        }

        public static CaptionEventType[] values()
        {
            CaptionEventType acaptioneventtype[] = ENUM$VALUES;
            int i = acaptioneventtype.length;
            CaptionEventType acaptioneventtype1[] = new CaptionEventType[i];
            System.arraycopy(acaptioneventtype, 0, acaptioneventtype1, 0, i);
            return acaptioneventtype1;
        }

        static 
        {
            TEXT = new CaptionEventType("TEXT", 0);
            CLEAR = new CaptionEventType("CLEAR", 1);
            LINEBREAK = new CaptionEventType("LINEBREAK", 2);
            ENUM$VALUES = (new CaptionEventType[] {
                TEXT, CLEAR, LINEBREAK
            });
        }

        private CaptionEventType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class CaptionMode extends Enum
    {

        private static final CaptionMode ENUM$VALUES[];
        public static final CaptionMode PAINT_ON;
        public static final CaptionMode POP_ON;
        public static final CaptionMode ROLL_UP;
        public static final CaptionMode TEXT;
        public static final CaptionMode UNKNOWN;

        public static CaptionMode valueOf(String s)
        {
            return (CaptionMode)Enum.valueOf(com/uplynk/media/CaptionEvent$CaptionMode, s);
        }

        public static CaptionMode[] values()
        {
            CaptionMode acaptionmode[] = ENUM$VALUES;
            int i = acaptionmode.length;
            CaptionMode acaptionmode1[] = new CaptionMode[i];
            System.arraycopy(acaptionmode, 0, acaptionmode1, 0, i);
            return acaptionmode1;
        }

        static 
        {
            UNKNOWN = new CaptionMode("UNKNOWN", 0);
            POP_ON = new CaptionMode("POP_ON", 1);
            ROLL_UP = new CaptionMode("ROLL_UP", 2);
            PAINT_ON = new CaptionMode("PAINT_ON", 3);
            TEXT = new CaptionMode("TEXT", 4);
            ENUM$VALUES = (new CaptionMode[] {
                UNKNOWN, POP_ON, ROLL_UP, PAINT_ON, TEXT
            });
        }

        private CaptionMode(String s, int i)
        {
            super(s, i);
        }
    }

    public class CaptionRow
    {

        private Vector _characters;
        private int _col;
        private int _indent;
        private int _row;
        private String _text;
        final CaptionEvent this$0;

        public final Vector getCharacters()
        {
            return _characters;
        }

        public int getColumn()
        {
            return _col;
        }

        public int getIndent()
        {
            return _indent;
        }

        public int getRow()
        {
            return _row;
        }

        public String getText()
        {
            return _text;
        }

        protected CaptionRow()
        {
            this$0 = CaptionEvent.this;
            super();
            _characters = new Vector();
        }

        protected CaptionRow(int i, int j, int k, String s)
        {
            this$0 = CaptionEvent.this;
            super();
            _row = i;
            _col = j;
            _indent = k;
            _text = s;
            _characters = null;
        }

        protected CaptionRow(int i, int j, int k, String s, Vector vector)
        {
            this$0 = CaptionEvent.this;
            super();
            _row = i;
            _col = j;
            _indent = k;
            _text = s;
            _characters = vector;
        }
    }


    public CaptionCharacter character;
    public CaptionEventType eventType;
    public CaptionMode mode;
    public short rowCount;
    public SparseArray rows;

    protected CaptionEvent(CaptionMode captionmode, CaptionEventType captioneventtype)
    {
        mode = captionmode;
        eventType = captioneventtype;
        if (captioneventtype == CaptionEventType.TEXT)
        {
            rows = new SparseArray(15);
        }
    }

    protected CaptionEvent(CaptionMode captionmode, CaptionEventType captioneventtype, short word0)
    {
        this(captionmode, captioneventtype);
        rowCount = word0;
    }
}
