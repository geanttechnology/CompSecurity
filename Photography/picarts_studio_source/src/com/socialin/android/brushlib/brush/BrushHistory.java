// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import com.socialin.android.NoProGuard;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.brushlib.util.k;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            c, d, b, e, 
//            a, l, g, i, 
//            j, f, k

public class BrushHistory
    implements NoProGuard, Serializable
{

    public static final List BRUSH_LIST = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), 
        Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(30), Integer.valueOf(31), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(35), Integer.valueOf(36), Integer.valueOf(37), 
        Integer.valueOf(38), Integer.valueOf(39), Integer.valueOf(40), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(22), Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(1), Integer.valueOf(4), 
        Integer.valueOf(8), Integer.valueOf(21)
    });
    public static final List ERASER_BRUSH_LIST = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), 
        Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(30), Integer.valueOf(31), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34), Integer.valueOf(35), Integer.valueOf(36), Integer.valueOf(37), 
        Integer.valueOf(38), Integer.valueOf(39), Integer.valueOf(40), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(8)
    });
    private static final String SAVE_FILE_GLOBAL_PATH;
    private static String projectFolderPath;
    private static final long serialVersionUID = 0xf3d0832a068115dL;
    private Map savedBrushParams;
    private Map savedEraserBrushParams;
    private int selectedBrushId;
    private int selectedEraserBrushId;
    private String selectedShapeName;
    private int selectedStickerIndex;

    public BrushHistory()
    {
        savedBrushParams = new HashMap();
        savedEraserBrushParams = new HashMap();
    }

    private static Brush.Params getDefaultParamsForBrush(int i1)
    {
        switch (i1)
        {
        case 3: // '\003'
        case 9: // '\t'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            return c.f();

        case 0: // '\0'
            return c.f();

        case 7: // '\007'
            return d.f();

        case 2: // '\002'
            return b.f();

        case 8: // '\b'
            return e.f();

        case 4: // '\004'
            return a.f();

        case 1: // '\001'
            return l.f();

        case 5: // '\005'
            return g.f();

        case 6: // '\006'
            return i.j();

        case 21: // '\025'
            return j.f();

        case 22: // '\026'
            return f.f();

        case 10: // '\n'
            return k.b(10);

        case 11: // '\013'
            return k.b(11);

        case 12: // '\f'
            return k.b(12);

        case 13: // '\r'
            return k.b(13);

        case 14: // '\016'
            return k.b(14);

        case 15: // '\017'
            return k.b(15);

        case 16: // '\020'
            return k.b(16);

        case 17: // '\021'
            return k.b(17);

        case 18: // '\022'
            return k.b(18);

        case 19: // '\023'
            return k.b(19);

        case 20: // '\024'
            return k.b(20);

        case 29: // '\035'
            return k.b(29);

        case 30: // '\036'
            return k.b(30);

        case 31: // '\037'
            return k.b(31);

        case 32: // ' '
            return k.b(32);

        case 33: // '!'
            return k.b(33);

        case 34: // '"'
            return k.b(34);

        case 35: // '#'
            return k.b(35);

        case 36: // '$'
            return k.b(36);

        case 37: // '%'
            return k.b(37);

        case 38: // '&'
            return k.b(38);

        case 39: // '\''
            return k.b(39);

        case 40: // '('
            return k.b(40);
        }
    }

    public static BrushHistory loadFromFile()
    {
        BrushHistory brushhistory1 = (BrushHistory)k.a(new File((new StringBuilder()).append(projectFolderPath).append("brush-data").toString()));
        BrushHistory brushhistory = brushhistory1;
        if (brushhistory1 == null)
        {
            BrushHistory brushhistory2 = (BrushHistory)k.a(new File(SAVE_FILE_GLOBAL_PATH));
            brushhistory = brushhistory2;
            if (brushhistory2 == null)
            {
                brushhistory = new BrushHistory();
            }
        }
        return brushhistory;
    }

    public static void setProjectFolderPath(String s)
    {
        projectFolderPath = s;
    }

    public Brush.Params getBrushSelectedParams(int i1, boolean flag)
    {
        if (flag)
        {
            return getEraserBrushSelectedParams(i1);
        }
        if (savedBrushParams.containsKey(Integer.valueOf(i1)))
        {
            return (Brush.Params)savedBrushParams.get(Integer.valueOf(i1));
        } else
        {
            Brush.Params params = getDefaultParamsForBrush(i1);
            savedBrushParams.put(Integer.valueOf(i1), params);
            return params;
        }
    }

    public Brush.Params getEraserBrushSelectedParams(int i1)
    {
        if (savedEraserBrushParams.containsKey(Integer.valueOf(i1)))
        {
            return (Brush.Params)savedEraserBrushParams.get(Integer.valueOf(i1));
        } else
        {
            Brush.Params params = getDefaultParamsForBrush(i1);
            savedEraserBrushParams.put(Integer.valueOf(i1), params);
            return params;
        }
    }

    public int getSelectedBrushId(boolean flag)
    {
        if (flag)
        {
            return selectedEraserBrushId;
        } else
        {
            return selectedBrushId;
        }
    }

    public String getSelectedShapeName()
    {
        return selectedShapeName;
    }

    public int getSelectedStickerIndex()
    {
        return selectedStickerIndex;
    }

    public void resetBrushParams(int i1, boolean flag)
    {
        if (flag)
        {
            savedEraserBrushParams.remove(Integer.valueOf(i1));
        } else
        {
            savedBrushParams.remove(Integer.valueOf(i1));
        }
        saveToFile();
    }

    public void saveToFile()
    {
        k.a(new File(SAVE_FILE_GLOBAL_PATH), this);
        k.a(new File((new StringBuilder()).append(projectFolderPath).append("brush-data").toString()), this);
    }

    public void setBrushSelectedParams(int i1, Brush.Params params, boolean flag)
    {
        if (flag)
        {
            savedEraserBrushParams.put(Integer.valueOf(i1), params);
            return;
        } else
        {
            savedBrushParams.put(Integer.valueOf(i1), params);
            return;
        }
    }

    public void setEraserBrushSelectedParams(int i1, Brush.Params params)
    {
        savedEraserBrushParams.put(Integer.valueOf(i1), params);
    }

    public void setSelectedBrush(int i1, boolean flag)
    {
        if (flag)
        {
            selectedEraserBrushId = i1;
            return;
        } else
        {
            selectedBrushId = i1;
            return;
        }
    }

    public void setSelectedShapeName(String s)
    {
        selectedShapeName = s;
    }

    public void setSelectedStickerIndex(int i1)
    {
        selectedStickerIndex = i1;
    }

    static 
    {
        SAVE_FILE_GLOBAL_PATH = (new StringBuilder()).append(a.b).append("brush-data").toString();
    }
}
