// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MoaMetadata
    implements JSONWriter.JSONEncode
{

    public static final String MOALITE_VERSION = "2.1.1";
    private int cellsize[] = {
        -1, -1
    };
    private int grid[] = {
        0, 0
    };
    private int imagesize[] = {
        1, 1
    };
    private int inplace;

    public MoaMetadata()
    {
        inplace = 0;
    }

    public int cellHeight()
    {
        return cellsize[1];
    }

    public int cellWidth()
    {
        return cellsize[0];
    }

    public int cols()
    {
        return grid[0];
    }

    public JSONObject encode()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(imagesize[0]);
        jsonarray.put(imagesize[1]);
        jsonobject.put("imageorigsize", jsonarray);
        jsonobject.put("cellWidth", cellWidth());
        jsonobject.put("cellHeight", cellHeight());
        jsonobject.put("cols", cols());
        jsonobject.put("rows", rows());
        jsonobject.put("inplace", inplace);
        jsonobject.put("version", "2.1.1");
        return jsonobject;
    }

    public int imageHeight()
    {
        return imagesize[1];
    }

    public int imageWidth()
    {
        return imagesize[0];
    }

    public int rows()
    {
        return grid[1];
    }

    public void setCellSize(int i, int j)
    {
        cellsize[0] = i;
        cellsize[1] = j;
    }

    public void setGridSize(int i, int j)
    {
        grid[0] = i;
        grid[1] = j;
    }

    public void setImageSize(int i, int j)
    {
        imagesize[0] = i;
        imagesize[1] = j;
    }

    public void setTransformInputBitmap(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        inplace = i;
    }
}
