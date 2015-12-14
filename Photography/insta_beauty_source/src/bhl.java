// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import android.graphics.RectF;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.compose.TDecorateInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMaskInfo;
import com.wantu.model.res.EResType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bhl extends bgj
{

    public String j;

    public bhl()
    {
    }

    private int a(JSONObject jsonobject)
    {
        float f3 = 0.0F;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        float f2 = aqn.f(jsonobject, "R");
        float f;
        float f1;
        float f4;
        try
        {
            f1 = aqn.f(jsonobject, "G");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            f1 = 0.0F;
            f = 0.0F;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            f = aqn.f(jsonobject, "B");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            f = 0.0F;
            continue; /* Loop/switch isn't completed */
        }
        f4 = aqn.f(jsonobject, "alpha");
        f3 = f4;
_L5:
        return Color.argb((int)(f3 * 255F), (int)f2, (int)f1, (int)f);
        jsonobject;
        f1 = 0.0F;
        f2 = 0.0F;
        f = 0.0F;
_L3:
        jsonobject.printStackTrace();
        continue; /* Loop/switch isn't completed */
        jsonobject;
        if (true) goto _L3; else goto _L2
_L2:
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private RectF b(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        float f2 = aqn.f(jsonobject, "x");
        float f1 = aqn.f(jsonobject, "y");
        float f = aqn.f(jsonobject, "w");
        float f3 = aqn.f(jsonobject, "h");
_L4:
        if (f != 0.0F && f3 != 0.0F)
        {
            return new RectF(f2, f1, f + f2, f3 + f1);
        }
        if (true) goto _L1; else goto _L3
_L3:
        jsonobject;
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
_L5:
        jsonobject.printStackTrace();
        f3 = 0.0F;
          goto _L4
        jsonobject;
        f = 0.0F;
        f1 = 0.0F;
          goto _L5
        jsonobject;
        f = 0.0F;
          goto _L5
        jsonobject;
          goto _L5
    }

    public int a(int i)
    {
        if (i != 0)
        {
            if (i == 1)
            {
                return 17;
            }
            if (i == 2)
            {
                return 5;
            }
        }
        return 3;
    }

    protected ArrayList a(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null && !s.equalsIgnoreCase("null")) goto _L2; else goto _L1
_L1:
        s = null;
_L8:
        return s;
_L2:
        int i;
        aqn.a(null, 3, (new StringBuilder()).append("Response => ").append(s).toString());
        Object obj;
        Object obj1;
        String s1;
        try
        {
            s = new JSONObject(s);
            obj = s.names();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return arraylist;
        }
        obj1 = s.toJSONArray(((JSONArray) (obj)));
        i = 0;
_L4:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        aqn.a(null, 3, (new StringBuilder()).append("Key => ").append(((JSONArray) (obj)).getString(i)).append(" Value => ").append(((JSONArray) (obj1)).getString(i)).toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (!aqn.a(s, "status").toString().equalsIgnoreCase("1")) goto _L6; else goto _L5
_L5:
        obj = aqn.c(s, "data");
        s = arraylist;
        if (obj == null) goto _L8; else goto _L7
_L7:
        s = aqn.a(((JSONObject) (obj)), "icon");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = aqn.a(((JSONObject) (obj)), "backgroundImageUrl");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = aqn.a(((JSONObject) (obj)), "foregroundImageUrl");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = aqn.b(((JSONObject) (obj)), "masks");
        i = 0;
_L16:
        if (i >= s.length()) goto _L10; else goto _L9
_L9:
        obj1 = s.getJSONObject(i);
        s1 = aqn.a(((JSONObject) (obj1)), "backgroundImageUrl");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        if (!s1.equalsIgnoreCase(""))
        {
            arraylist.add(s1);
        }
        s1 = aqn.a(((JSONObject) (obj1)), "foregroundImageUrl");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        if (!s1.equalsIgnoreCase(""))
        {
            arraylist.add(s1);
        }
        obj1 = aqn.a(((JSONObject) (obj1)), "maskImageUrl");
        if (obj1 == null) goto _L12; else goto _L11
_L11:
        if (!((String) (obj1)).equalsIgnoreCase(""))
        {
            arraylist.add(obj1);
        }
          goto _L12
_L10:
        obj = aqn.b(((JSONObject) (obj)), "decorates");
        i = 0;
_L17:
        s = arraylist;
        if (i >= ((JSONArray) (obj)).length()) goto _L8; else goto _L13
_L13:
        s = aqn.a(((JSONArray) (obj)).getJSONObject(i), "imageUrl");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_469;
        }
        try
        {
            if (!s.equalsIgnoreCase(""))
            {
                arraylist.add(s);
            }
            break MISSING_BLOCK_LABEL_469;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
          goto _L14
_L6:
        s = arraylist;
        if (c == null) goto _L8; else goto _L15
_L15:
        c.filterDownloadFailed(0, b);
        return arraylist;
_L14:
        s.printStackTrace();
        return arraylist;
_L12:
        i++;
          goto _L16
        i++;
          goto _L17
    }

    public void a(bge bge1)
    {
        c = bge1;
        d = Boolean.valueOf(true);
        if (j == null)
        {
            return;
        } else
        {
            a(((List) (a(j))));
            return;
        }
    }

    protected EOnlineResType b()
    {
        return EOnlineResType.MAG_MASK_INFO;
    }

    protected Object b(String s)
    {
        Object obj = (TPhotoComposeInfo)b;
        if (s != null && !s.equalsIgnoreCase("null")) goto _L2; else goto _L1
_L1:
        Object obj2 = null;
_L6:
        return obj2;
_L2:
        aqn.a(null, 3, (new StringBuilder()).append("Response => ").append(s).toString());
        obj2 = obj;
        s = new JSONObject(s);
        obj2 = obj;
        Object obj3 = s.names();
        Object obj1 = obj;
        obj2 = s.toJSONArray(((JSONArray) (obj3)));
        int i = 0;
_L4:
        obj1 = obj;
        if (i >= ((JSONArray) (obj3)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        aqn.a(null, 3, (new StringBuilder()).append("Key => ").append(((JSONArray) (obj3)).getString(i)).append(" Value => ").append(((JSONArray) (obj2)).getString(i)).toString());
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj1 = obj;
        if (!aqn.a(s, "status").toString().equalsIgnoreCase("1")) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        obj3 = aqn.c(s, "data");
        obj2 = obj;
        if (obj3 == null) goto _L6; else goto _L7
_L7:
        s = ((String) (obj));
        obj1 = obj;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj1 = obj;
        b = new TPhotoComposeInfo();
        obj1 = obj;
        s = (TPhotoComposeInfo)b;
        obj1 = s;
        s.resId = aqn.e(((JSONObject) (obj3)), "rid");
        obj1 = s;
        s.version = aqn.a(((JSONObject) (obj3)), "version");
        obj1 = s;
        s.name = aqn.a(((JSONObject) (obj3)), "name");
        obj1 = s;
        s.icon = aqn.a(((JSONObject) (obj3)), "icon");
        obj1 = s;
        s.previewUrl = aqn.a(((JSONObject) (obj3)), "previewUrl");
        obj1 = s;
        s.price = aqn.e(((JSONObject) (obj3)), "price");
        obj1 = s;
        s.imageCount = aqn.e(((JSONObject) (obj3)), "imageCount");
        obj1 = s;
        s.width = aqn.f(((JSONObject) (obj3)), "width");
        obj1 = s;
        s.height = aqn.f(((JSONObject) (obj3)), "height");
        obj1 = s;
        s.isOnline = true;
        obj1 = s;
        s.setResType(EResType.NETWORK);
        obj1 = s;
        s.isUpdate = aqn.d(((JSONObject) (obj3)), "isUpdate");
        obj1 = s;
        s.otherAppStoreId = aqn.a(((JSONObject) (obj3)), "otherAppStoreId");
        obj1 = s;
        s.bRetainFirst = aqn.d(((JSONObject) (obj3)), "bRetainFirst");
        obj1 = s;
        s.downloadTime = System.currentTimeMillis();
        obj1 = s;
        s.expiredTime = aqn.e(((JSONObject) (obj3)), "expiredTime");
        obj1 = s;
        s.setShareTag(aqn.a(((JSONObject) (obj3)), "shareTag"));
        obj1 = s;
        s.backgoundImagePath = aqn.a(((JSONObject) (obj3)), "backgroundImageUrl");
        obj1 = s;
        obj = aqn.c(((JSONObject) (obj3)), "backgroundColor");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_478;
        }
        obj1 = s;
        s.backgroundColor = a(((JSONObject) (obj)));
        obj1 = s;
        s.foregroundImagePath = aqn.a(((JSONObject) (obj3)), "foregroundImageUrl");
        obj1 = s;
        obj = aqn.c(((JSONObject) (obj3)), "foregroundColor");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        obj1 = s;
        s.foregroundColor = a(((JSONObject) (obj)));
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).width == 0.0F)
        {
            break MISSING_BLOCK_LABEL_539;
        }
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).height != 0.0F)
        {
            break MISSING_BLOCK_LABEL_557;
        }
        obj1 = s;
        s.width = 320F;
        obj1 = s;
        s.height = 480F;
        obj1 = s;
        obj = aqn.b(((JSONObject) (obj3)), "masks");
        i = 0;
_L9:
        obj1 = s;
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = s;
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        obj1 = s;
        Object obj4 = new TPhotoMaskInfo();
        obj1 = s;
        obj4.resType = EResType.NETWORK;
        obj1 = s;
        obj4.backgroundFrame = b(aqn.c(((JSONObject) (obj2)), "backgroundFrame"));
        obj1 = s;
        obj4.innerFrame = b(aqn.c(((JSONObject) (obj2)), "innerFrame"));
        obj1 = s;
        obj4.foregroundFrame = b(aqn.c(((JSONObject) (obj2)), "foregroundFrame"));
        obj1 = s;
        obj4.foregroundImagePath = aqn.a(((JSONObject) (obj2)), "foregroundImageUrl");
        obj1 = s;
        obj4.foregroundColor = a(aqn.c(((JSONObject) (obj2)), "foregroundColor"));
        obj1 = s;
        obj4.rotation = aqn.f(((JSONObject) (obj2)), "rotation");
        obj1 = s;
        obj4.backgroundImagePath = aqn.a(((JSONObject) (obj2)), "backgroundImageUrl");
        obj1 = s;
        obj4.backgroundColor = a(aqn.c(((JSONObject) (obj2)), "backgroundColor"));
        obj1 = s;
        obj4.rotation = aqn.f(((JSONObject) (obj2)), "rotation");
        obj1 = s;
        obj4.maskImagePath = aqn.a(((JSONObject) (obj2)), "maskImageUrl");
        obj1 = s;
        obj4.filterName = aqn.a(((JSONObject) (obj2)), "filterName");
        obj1 = s;
        obj4.isBackgroundShadow = aqn.d(((JSONObject) (obj2)), "isBackgroundShadow");
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).photoMaskInfoArray != null)
        {
            break MISSING_BLOCK_LABEL_832;
        }
        obj1 = s;
        s.photoMaskInfoArray = new ArrayList(1);
        obj1 = s;
        ((TPhotoComposeInfo) (s)).photoMaskInfoArray.add(obj4);
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        obj1 = s;
        obj = aqn.b(((JSONObject) (obj3)), "decorates");
        i = 0;
_L14:
        obj2 = s;
        obj1 = s;
        if (i >= ((JSONArray) (obj)).length()) goto _L6; else goto _L10
_L10:
        obj1 = s;
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        obj1 = s;
        obj3 = new TDecorateInfo();
        obj1 = s;
        obj3.resType = EResType.NETWORK;
        obj1 = s;
        obj3.frame = b(aqn.c(((JSONObject) (obj2)), "frame"));
        obj1 = s;
        obj3.rotation = (float)(((double)aqn.f(((JSONObject) (obj2)), "rotation") * 3.1415926535897931D) / 180D);
        obj1 = s;
        obj3.imagePath = aqn.a(((JSONObject) (obj2)), "imageUrl");
        obj1 = s;
        obj3.type = aqn.e(((JSONObject) (obj2)), "type");
        obj1 = s;
        obj3.textColor = a(aqn.c(((JSONObject) (obj2)), "textColor"));
        obj1 = s;
        obj3.backgroundColor = a(aqn.c(((JSONObject) (obj2)), "backgroundColor"));
        obj1 = s;
        obj3.fontSize = aqn.e(((JSONObject) (obj2)), "fontSize");
        obj1 = s;
        obj4 = aqn.a(((JSONObject) (obj2)), "androidFontFamily");
        if (obj4 == null) goto _L12; else goto _L11
_L11:
        obj1 = s;
        if (((String) (obj4)).length() <= 0) goto _L12; else goto _L13
_L13:
        obj1 = s;
        obj3.fontFamily = ((String) (obj4));
_L15:
        obj1 = s;
        obj3.isBold = aqn.d(((JSONObject) (obj2)), "isBold");
        obj1 = s;
        obj3.isShadow = aqn.d(((JSONObject) (obj2)), "isShadow");
        obj1 = s;
        obj3.isOutline = aqn.d(((JSONObject) (obj2)), "isOutline");
        obj1 = s;
        obj3.isItalic = aqn.d(((JSONObject) (obj2)), "isItalic");
        obj1 = s;
        obj3.fontMaxCount = aqn.e(((JSONObject) (obj2)), "fontMaxCount");
        obj1 = s;
        obj3.text = aqn.a(((JSONObject) (obj2)), "text");
        obj1 = s;
        obj3.textAlignment = a(aqn.e(((JSONObject) (obj2)), "textAlignment"));
        obj1 = s;
        obj3.movable = aqn.d(((JSONObject) (obj2)), "movable");
        obj1 = s;
        obj3.editable = aqn.d(((JSONObject) (obj2)), "editable");
        obj1 = s;
        obj3.lines = aqn.e(((JSONObject) (obj2)), "lines");
        obj1 = s;
        obj3.letterSpace = aqn.e(((JSONObject) (obj2)), "letterSpace");
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).decorateInfoArray != null)
        {
            break MISSING_BLOCK_LABEL_1267;
        }
        obj1 = s;
        s.decorateInfoArray = new ArrayList(1);
        obj1 = s;
        ((TPhotoComposeInfo) (s)).decorateInfoArray.add(obj3);
        i++;
          goto _L14
_L12:
        obj1 = s;
        obj3.fontFamily = aqn.a(((JSONObject) (obj2)), "fontFamily");
          goto _L15
        s;
        obj2 = obj1;
        s.printStackTrace();
        return obj1;
        s;
        s.printStackTrace();
        return obj2;
          goto _L14
    }

    protected List b(bib bib)
    {
        return null;
    }

    protected Object c(bib bib)
    {
        return null;
    }

    protected void c()
    {
        if (j != null)
        {
            Object obj = b(j);
            if (c != null)
            {
                c.filterDownloadFinished(obj);
                return;
            }
        }
    }
}
