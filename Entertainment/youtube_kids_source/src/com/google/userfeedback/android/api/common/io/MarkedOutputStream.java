// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import java.io.OutputStream;

public class MarkedOutputStream extends OutputStream
{

    private static final int MINIMUM_SIZE = 16;
    private byte contents[];
    private int markers[];
    private int nextContent;
    private int nextMarker;

    public MarkedOutputStream()
    {
        nextContent = 0;
        nextMarker = 0;
        clear();
    }

    private static int calculateSize(int i, int j, int k)
    {
        for (k = j - k; k < i;)
        {
            k += j;
            j <<= 1;
        }

        return j;
    }

    private void expandContentsIfNecessary(int i)
    {
        i = calculateSize(i, contents.length, nextContent);
        if (i > contents.length)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(contents, 0, abyte0, 0, nextContent);
            contents = abyte0;
        }
    }

    private void expandMarkersIfNecessary(int i)
    {
        i = calculateSize(i, markers.length, nextMarker);
        if (i > markers.length)
        {
            int ai[] = new int[i];
            System.arraycopy(markers, 0, ai, 0, nextMarker);
            markers = ai;
        }
    }

    public void addMarker(int i)
    {
        expandMarkersIfNecessary(1);
        int ai[] = markers;
        int j = nextMarker;
        nextMarker = j + 1;
        ai[j] = i;
    }

    public int availableContent()
    {
        return nextContent;
    }

    public void clear()
    {
        reset();
        contents = new byte[16];
        markers = new int[1];
    }

    public int getMarker(int i)
    {
        return markers[i];
    }

    public int numMarkers()
    {
        return nextMarker;
    }

    public void reset()
    {
        nextContent = 0;
        nextMarker = 0;
    }

    public void setMarker(int i, int j)
    {
        markers[i] = j;
    }

    public void write(int i)
    {
        expandContentsIfNecessary(1);
        byte abyte0[] = contents;
        int j = nextContent;
        nextContent = j + 1;
        abyte0[j] = (byte)i;
    }

    public void write(byte abyte0[])
    {
        expandContentsIfNecessary(abyte0.length);
        System.arraycopy(abyte0, 0, contents, nextContent, abyte0.length);
        nextContent = nextContent + abyte0.length;
    }

    public void write(byte abyte0[], int i, int j)
    {
        expandContentsIfNecessary(j);
        System.arraycopy(abyte0, i, contents, nextContent, j);
        nextContent = nextContent + j;
    }

    public void writeContentsTo(OutputStream outputstream, int i, int j)
    {
        outputstream.write(contents, i, j);
    }
}
