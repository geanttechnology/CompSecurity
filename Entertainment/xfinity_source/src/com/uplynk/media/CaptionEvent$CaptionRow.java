// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import java.util.Vector;

// Referenced classes of package com.uplynk.media:
//            CaptionEvent

public class _characters
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

    protected ()
    {
        this$0 = CaptionEvent.this;
        super();
        _characters = new Vector();
    }

    protected _characters(int i, int j, int k, String s)
    {
        this$0 = CaptionEvent.this;
        super();
        _row = i;
        _col = j;
        _indent = k;
        _text = s;
        _characters = null;
    }

    protected _characters(int i, int j, int k, String s, Vector vector)
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
