// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Color;
import android.graphics.RectF;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
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

public class ut extends tp
{

    private static String l = "TPhotoMagDownloadAssistant";
    public String k;

    public ut()
    {
    }

    private int a(JSONObject jsonobject)
    {
        float f3 = 0.0F;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        float f2 = kv.f(jsonobject, "R");
        float f;
        float f1;
        float f4;
        try
        {
            f1 = kv.f(jsonobject, "G");
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
            f = kv.f(jsonobject, "B");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            f = 0.0F;
            continue; /* Loop/switch isn't completed */
        }
        f4 = kv.f(jsonobject, "alpha");
        f3 = f4;
_L5:
        return Color.argb((int)(f3 * 255F), (int)f2, (int)f1, (int)f);
        jsonobject;
        f1 = 0.0F;
        f2 = 0.0F;
        f = 0.0F;
_L3:
        jsonobject.printStackTrace();
        Crashlytics.logException(jsonobject);
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

    private List b(JSONObject jsonobject)
    {
        Object obj1 = null;
        Object obj;
        if (jsonobject == null)
        {
            obj = obj1;
        } else
        {
            obj = obj1;
            if (jsonobject.has("X"))
            {
                obj = obj1;
                if (jsonobject.has("Y"))
                {
                    obj = obj1;
                    if (jsonobject.has("Z"))
                    {
                        ArrayList arraylist = new ArrayList();
                        obj = arraylist;
                        if (jsonobject != null)
                        {
                            try
                            {
                                float f = kv.f(jsonobject, "scale");
                                float f1 = kv.f(jsonobject, "m34");
                                float f2 = kv.f(jsonobject, "X");
                                float f3 = kv.f(jsonobject, "Y");
                                float f4 = kv.f(jsonobject, "Z");
                                arraylist.add(Float.valueOf(f));
                                arraylist.add(Float.valueOf(f1));
                                arraylist.add(Float.valueOf(f2));
                                arraylist.add(Float.valueOf(f3));
                                arraylist.add(Float.valueOf(f4));
                            }
                            // Misplaced declaration of an exception variable
                            catch (JSONObject jsonobject)
                            {
                                jsonobject.printStackTrace();
                                Crashlytics.logException(jsonobject);
                                return arraylist;
                            }
                            return arraylist;
                        }
                    }
                }
            }
        }
        return ((List) (obj));
    }

    private RectF c(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        float f2 = kv.f(jsonobject, "x");
        float f1 = kv.f(jsonobject, "y");
        float f = kv.f(jsonobject, "w");
        float f3 = kv.f(jsonobject, "h");
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
        Crashlytics.logException(jsonobject);
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
        ArrayList arraylist;
        boolean flag;
        flag = false;
        arraylist = new ArrayList();
        if (s != null && !s.equalsIgnoreCase("null")) goto _L2; else goto _L1
_L1:
        s = null;
_L6:
        return s;
_L2:
        Object obj;
        Object obj1;
        String s1;
        int i;
        try
        {
            s = new JSONObject(s);
            obj = s.names();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return arraylist;
        }
        s.toJSONArray(((JSONArray) (obj)));
        if (!kv.a(s, "status").toString().equalsIgnoreCase("1")) goto _L4; else goto _L3
_L3:
        obj = kv.c(s, "data");
        s = arraylist;
        if (obj == null) goto _L6; else goto _L5
_L5:
        s = kv.a(((JSONObject) (obj)), "icon");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = kv.a(((JSONObject) (obj)), "backgroundImageUrl");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = kv.a(((JSONObject) (obj)), "foregroundImageUrl");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        if (!s.equalsIgnoreCase(""))
        {
            arraylist.add(s);
        }
        s = kv.b(((JSONObject) (obj)), "masks");
        i = 0;
_L15:
        if (i >= s.length()) goto _L8; else goto _L7
_L7:
        obj1 = s.getJSONObject(i);
        s1 = kv.a(((JSONObject) (obj1)), "backgroundImageUrl");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (!s1.equalsIgnoreCase(""))
        {
            arraylist.add(s1);
        }
        s1 = kv.a(((JSONObject) (obj1)), "foregroundImageUrl");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (!s1.equalsIgnoreCase(""))
        {
            arraylist.add(s1);
        }
        s1 = kv.a(((JSONObject) (obj1)), "maskImageUrl");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        if (!s1.equalsIgnoreCase(""))
        {
            arraylist.add(s1);
        }
        s1 = kv.a(((JSONObject) (obj1)), "backmaskImagePath");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        if (s1.length() > 0)
        {
            arraylist.add(s1);
        }
        if (!((JSONObject) (obj1)).has("grainPath")) goto _L10; else goto _L9
_L9:
        obj1 = kv.a(((JSONObject) (obj1)), "grainPath");
        if (obj1 == null) goto _L10; else goto _L11
_L11:
        if (((String) (obj1)).length() > 0 && !((String) (obj1)).startsWith("MaskGrains"))
        {
            arraylist.add(obj1);
        }
          goto _L10
_L8:
        obj = kv.b(((JSONObject) (obj)), "decorates");
        i = ((flag) ? 1 : 0);
_L16:
        s = arraylist;
        if (i >= ((JSONArray) (obj)).length()) goto _L6; else goto _L12
_L12:
        s = kv.a(((JSONArray) (obj)).getJSONObject(i), "imageUrl");
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
          goto _L13
_L4:
        s = arraylist;
        if (c == null) goto _L6; else goto _L14
_L14:
        c.filterDownloadFailed(0, b);
        return arraylist;
_L13:
        s.printStackTrace();
        Crashlytics.logException(s);
        return arraylist;
_L10:
        i++;
          goto _L15
        i++;
          goto _L16
    }

    public void a(tn tn1)
    {
        c = tn1;
        d = Boolean.valueOf(true);
        if (k == null)
        {
            return;
        } else
        {
            a(a(k));
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
_L4:
        return obj2;
_L2:
        Object obj1;
        Object obj3;
        Object obj4;
        String s1;
        obj2 = obj;
        Exception exception;
        int i;
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return obj2;
        }
        obj2 = obj;
        obj3 = s.names();
        obj1 = obj;
        s.toJSONArray(((JSONArray) (obj3)));
        obj2 = obj;
        obj1 = obj;
        if (!kv.a(s, "status").toString().equalsIgnoreCase("1")) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        obj3 = kv.c(s, "data");
        obj2 = obj;
        if (obj3 == null) goto _L4; else goto _L5
_L5:
        s = ((String) (obj));
        obj1 = obj;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj1 = obj;
        b = new TPhotoComposeInfo();
        obj1 = obj;
        s = (TPhotoComposeInfo)b;
        obj1 = s;
        s.resId = kv.e(((JSONObject) (obj3)), "rid");
        obj1 = s;
        s.version = kv.a(((JSONObject) (obj3)), "version");
        obj1 = s;
        s.name = kv.a(((JSONObject) (obj3)), "name");
        obj1 = s;
        s.icon = kv.a(((JSONObject) (obj3)), "icon");
        obj1 = s;
        s.previewUrl = kv.a(((JSONObject) (obj3)), "previewUrl");
        obj1 = s;
        s.price = kv.e(((JSONObject) (obj3)), "price");
        obj1 = s;
        s.imageCount = kv.e(((JSONObject) (obj3)), "imageCount");
        obj1 = s;
        s.width = kv.f(((JSONObject) (obj3)), "width");
        obj1 = s;
        s.height = kv.f(((JSONObject) (obj3)), "height");
        obj1 = s;
        s.isOnline = true;
        obj1 = s;
        s.setResType(EResType.NETWORK);
        obj1 = s;
        s.isUpdate = kv.d(((JSONObject) (obj3)), "isUpdate");
        obj1 = s;
        s.otherAppStoreId = kv.a(((JSONObject) (obj3)), "otherAppStoreId");
        obj1 = s;
        s.bRetainFirst = kv.d(((JSONObject) (obj3)), "bRetainFirst");
        obj1 = s;
        s.downloadTime = System.currentTimeMillis();
        obj1 = s;
        s.expiredTime = kv.e(((JSONObject) (obj3)), "expiredTime");
        obj1 = s;
        s.shareTag = kv.a(((JSONObject) (obj3)), "shareTag");
        obj1 = s;
        s.needReviewing = false;
        obj1 = s;
        s.isCartoon = kv.d(((JSONObject) (obj3)), "isCartoon");
        obj1 = s;
        if (((JSONObject) (obj3)).has("isFlip")) goto _L7; else goto _L6
_L6:
        obj1 = s;
        s.isHFlip = true;
_L17:
        obj1 = s;
        if (((JSONObject) (obj3)).has("isVFlip")) goto _L9; else goto _L8
_L8:
        obj1 = s;
        s.isVFlip = true;
_L18:
        obj1 = s;
        Log.d(l, (new StringBuilder()).append(l).append(" isHFlip: ").append(((TPhotoComposeInfo) (s)).isHFlip).toString());
        obj1 = s;
        Log.d(l, (new StringBuilder()).append(l).append(" isVFlip: ").append(((TPhotoComposeInfo) (s)).isVFlip).toString());
        obj1 = s;
        s.backgoundImagePath = kv.a(((JSONObject) (obj3)), "backgroundImageUrl");
        obj1 = s;
        obj = kv.c(((JSONObject) (obj3)), "backgroundColor");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_521;
        }
        obj1 = s;
        s.backgroundColor = a(((JSONObject) (obj)));
        obj1 = s;
        s.foregroundImagePath = kv.a(((JSONObject) (obj3)), "foregroundImageUrl");
        obj1 = s;
        obj = kv.c(((JSONObject) (obj3)), "foregroundColor");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj1 = s;
        s.foregroundColor = a(((JSONObject) (obj)));
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).width == 0.0F)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).height != 0.0F)
        {
            break MISSING_BLOCK_LABEL_600;
        }
        obj1 = s;
        s.width = 320F;
        obj1 = s;
        s.height = 480F;
        obj1 = s;
        obj = kv.b(((JSONObject) (obj3)), "masks");
        i = 0;
_L16:
        obj1 = s;
        if (i >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_1214;
        }
        obj1 = s;
        obj2 = ((JSONArray) (obj)).getJSONObject(i);
        obj1 = s;
        obj4 = new TPhotoMaskInfo();
        obj1 = s;
        obj4.resType = EResType.NETWORK;
        obj1 = s;
        obj4.backgroundFrame = c(kv.c(((JSONObject) (obj2)), "backgroundFrame"));
        obj1 = s;
        obj4.innerFrame = c(kv.c(((JSONObject) (obj2)), "innerFrame"));
        obj1 = s;
        obj4.foregroundFrame = c(kv.c(((JSONObject) (obj2)), "foregroundFrame"));
        obj1 = s;
        obj4.foregroundImagePath = kv.a(((JSONObject) (obj2)), "foregroundImageUrl");
        obj1 = s;
        obj4.foregroundColor = a(kv.c(((JSONObject) (obj2)), "foregroundColor"));
        obj1 = s;
        obj4.rotation = kv.f(((JSONObject) (obj2)), "rotation");
        obj1 = s;
        obj4.backgroundImagePath = kv.a(((JSONObject) (obj2)), "backgroundImageUrl");
        obj1 = s;
        obj4.backgroundColor = a(kv.c(((JSONObject) (obj2)), "backgroundColor"));
        obj1 = s;
        obj4.rotation = kv.f(((JSONObject) (obj2)), "rotation");
        obj1 = s;
        obj4.maskImagePath = kv.a(((JSONObject) (obj2)), "maskImageUrl");
        obj1 = s;
        obj4.filterName = kv.a(((JSONObject) (obj2)), "filterName");
        obj1 = s;
        obj4.isBackgroundShadow = kv.d(((JSONObject) (obj2)), "isBackgroundShadow");
        obj1 = s;
        if (!((JSONObject) (obj2)).has("transform3D"))
        {
            break MISSING_BLOCK_LABEL_884;
        }
        obj1 = s;
        obj4.transforms = b(kv.c(((JSONObject) (obj2)), "transform3D"));
        obj1 = s;
        if (!((JSONObject) (obj2)).has("grainPath")) goto _L11; else goto _L10
_L10:
        obj1 = s;
        s1 = kv.a(((JSONObject) (obj2)), "grainPath");
        if (s1 == null) goto _L11; else goto _L12
_L12:
        obj1 = s;
        if (s1.length() <= 0) goto _L11; else goto _L13
_L13:
        obj1 = s;
        if (s1.startsWith("MaskGrains")) goto _L15; else goto _L14
_L14:
        obj1 = s;
        obj4.grainPath = s1;
_L11:
        obj1 = s;
        obj4.isPIP = kv.d(((JSONObject) (obj2)), "isPIP");
        obj1 = s;
        obj4.backmaskImagePath = kv.a(((JSONObject) (obj2)), "backmaskImagePath");
        obj1 = s;
        obj4.backFilterName = kv.a(((JSONObject) (obj2)), "backFilterName");
        obj1 = s;
        obj4.gaussianFilterName = kv.a(((JSONObject) (obj2)), "gaussianFilterName");
        obj1 = s;
        obj4.gaussianBlur = kv.f(((JSONObject) (obj2)), "gaussianBlur");
        obj1 = s;
        obj4.saturation = kv.f(((JSONObject) (obj2)), "saturation");
        obj1 = s;
        obj4.downsampling = kv.f(((JSONObject) (obj2)), "downsampling");
        obj1 = s;
        obj4.rangeReductionFactor = kv.f(((JSONObject) (obj2)), "rangeReductionFactor");
        obj1 = s;
        obj4.backScaleFactor = kv.f(((JSONObject) (obj2)), "backScaleFactor");
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).photoMaskInfoArray != null)
        {
            break MISSING_BLOCK_LABEL_1100;
        }
        obj1 = s;
        s.photoMaskInfoArray = new ArrayList(1);
        obj1 = s;
        ((TPhotoComposeInfo) (s)).photoMaskInfoArray.add(obj4);
        i++;
          goto _L16
_L7:
        obj1 = s;
        s.isHFlip = kv.d(((JSONObject) (obj3)), "isFlip");
          goto _L17
        exception;
        obj1 = s;
        exception.printStackTrace();
        obj1 = s;
        Crashlytics.logException(exception);
          goto _L18
        s;
        obj2 = obj1;
        s.printStackTrace();
        obj2 = obj1;
        Crashlytics.logException(s);
        return obj1;
_L9:
        obj1 = s;
        s.isVFlip = kv.d(((JSONObject) (obj3)), "isVFlip");
          goto _L18
_L15:
        obj1 = s;
        obj4.grainPath = s1;
          goto _L11
        obj1 = s;
        exception = kv.b(((JSONObject) (obj3)), "decorates");
        int j = 0;
_L23:
        obj2 = s;
        obj1 = s;
        if (j >= exception.length()) goto _L4; else goto _L19
_L19:
        obj1 = s;
        obj2 = exception.getJSONObject(j);
        obj1 = s;
        obj3 = new TDecorateInfo();
        obj1 = s;
        obj3.resType = EResType.NETWORK;
        obj1 = s;
        obj3.frame = c(kv.c(((JSONObject) (obj2)), "frame"));
        obj1 = s;
        obj3.rotation = (float)(((double)kv.f(((JSONObject) (obj2)), "rotation") * 3.1415926535897931D) / 180D);
        obj1 = s;
        obj3.imagePath = kv.a(((JSONObject) (obj2)), "imageUrl");
        obj1 = s;
        obj3.type = kv.e(((JSONObject) (obj2)), "type");
        obj1 = s;
        obj3.textColor = a(kv.c(((JSONObject) (obj2)), "textColor"));
        obj1 = s;
        obj3.backgroundColor = a(kv.c(((JSONObject) (obj2)), "backgroundColor"));
        obj1 = s;
        obj3.fontSize = kv.e(((JSONObject) (obj2)), "fontSize");
        obj1 = s;
        obj4 = kv.a(((JSONObject) (obj2)), "androidFontFamily");
        if (obj4 == null) goto _L21; else goto _L20
_L20:
        obj1 = s;
        if (((String) (obj4)).length() <= 0) goto _L21; else goto _L22
_L22:
        obj1 = s;
        obj3.fontFamily = ((String) (obj4));
_L24:
        obj1 = s;
        obj3.isBold = kv.d(((JSONObject) (obj2)), "isBold");
        obj1 = s;
        obj3.isShadow = kv.d(((JSONObject) (obj2)), "isShadow");
        obj1 = s;
        obj3.isOutline = kv.d(((JSONObject) (obj2)), "isOutline");
        obj1 = s;
        obj3.isItalic = kv.d(((JSONObject) (obj2)), "isItalic");
        obj1 = s;
        obj3.fontMaxCount = kv.e(((JSONObject) (obj2)), "fontMaxCount");
        obj1 = s;
        obj3.text = kv.a(((JSONObject) (obj2)), "text");
        obj1 = s;
        obj3.textAlignment = a(kv.e(((JSONObject) (obj2)), "textAlignment"));
        obj1 = s;
        obj3.movable = kv.d(((JSONObject) (obj2)), "movable");
        obj1 = s;
        obj3.editable = kv.d(((JSONObject) (obj2)), "editable");
        obj1 = s;
        obj3.lines = kv.e(((JSONObject) (obj2)), "lines");
        obj1 = s;
        obj3.letterSpace = kv.e(((JSONObject) (obj2)), "letterSpace");
        obj1 = s;
        obj3.bubbleTextFrame = c(kv.c(((JSONObject) (obj2)), "txtFrame"));
        obj1 = s;
        obj3.isFlipH = kv.d(((JSONObject) (obj2)), "isFlipH");
        obj1 = s;
        obj3.isFlipV = kv.d(((JSONObject) (obj2)), "isFlipV");
        obj1 = s;
        obj3.scale = kv.f(((JSONObject) (obj2)), "scale");
        obj1 = s;
        if (((TDecorateInfo) (obj3)).scale != 0.0F)
        {
            break MISSING_BLOCK_LABEL_1686;
        }
        obj1 = s;
        obj3.scale = 1.0F;
        obj1 = s;
        if (((TPhotoComposeInfo) (s)).decorateInfoArray != null)
        {
            break MISSING_BLOCK_LABEL_1709;
        }
        obj1 = s;
        s.decorateInfoArray = new ArrayList(1);
        obj1 = s;
        ((TPhotoComposeInfo) (s)).decorateInfoArray.add(obj3);
        j++;
          goto _L23
_L21:
        obj1 = s;
        obj3.fontFamily = kv.a(((JSONObject) (obj2)), "fontFamily");
          goto _L24
    }

    protected ArrayList b(uy uy)
    {
        return null;
    }

    protected Object c(uy uy)
    {
        return null;
    }

    protected void c()
    {
        if (k != null)
        {
            Object obj = b(k);
            if (c != null)
            {
                c.filterDownloadFinished(obj);
                return;
            }
        }
    }

}
