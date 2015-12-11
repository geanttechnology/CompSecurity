// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.jumio.ocr.impl.smartEngines.swig.OcrPoint;
import com.jumio.ocr.impl.smartEngines.swig.OcrQuadrangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            cs, ay, fy

public class fx extends cs
{

    private static HashMap d = null;
    private static StringBuilder e = null;

    public static Point a(JSONObject jsonobject)
    {
        Point point = new Point();
        if (jsonobject == null)
        {
            return null;
        }
        try
        {
            point.x = jsonobject.getInt("x");
            point.y = jsonobject.getInt("y");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return point;
        }
        return point;
    }

    public static String a(OcrPoint ocrpoint)
    {
        return String.format("%d, %d", new Object[] {
            Integer.valueOf(ocrpoint.getX()), Integer.valueOf(ocrpoint.getY())
        });
    }

    public static void a(Context context, byte abyte0[], int i, int j, String s)
    {
        Canvas canvas;
        Paint paint;
        Iterator iterator;
        abyte0 = ay.a(abyte0, i, j);
        canvas = new Canvas(abyte0);
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(0.0F);
        iterator = d.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_287;
        }
        entry = (java.util.Map.Entry)iterator.next();
        fy fy2;
        if (entry.getKey() == com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER)
        {
            paint.setColor(0xff00cc33);
        } else
        if (entry.getKey() == com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.EXPIRY)
        {
            paint.setColor(-205);
        } else
        if (entry.getKey() == com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NAME)
        {
            paint.setColor(-39373);
        } else
        if (entry.getKey() == com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.AMEX_CVV)
        {
            paint.setColor(0xff996633);
        } else
        {
            if (entry.getKey() != com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_ACCOUNTNUM)
            {
                continue; /* Loop/switch isn't completed */
            }
            paint.setColor(0xff00ccff);
        }
_L3:
        i = 0;
        while (i < ((ArrayList)entry.getValue()).size()) 
        {
            fy2 = (fy)((ArrayList)entry.getValue()).get(i);
            canvas.drawRect(fy2.a, fy2.b, fy2.c, fy2.d, paint);
            i++;
        }
          goto _L1
        if (entry.getKey() != com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.UK_SORTCODE) goto _L1; else goto _L2
_L2:
        paint.setColor(0xff9933cc);
          goto _L3
        Object obj = (ArrayList)d.get(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName.NUMBER);
        if (obj != null)
        {
            paint.setColor(0xffff0000);
            paint.setStrokeWidth(2.0F);
            if (((ArrayList) (obj)).size() > 6)
            {
                fy fy1 = (fy)((ArrayList) (obj)).get(6);
                obj = (fy)((ArrayList) (obj)).get(((ArrayList) (obj)).size() - 1 - 4);
                canvas.drawLine(fy1.a, fy1.b, ((fy) (obj)).c, ((fy) (obj)).b, paint);
                canvas.drawLine(((fy) (obj)).c, ((fy) (obj)).b, ((fy) (obj)).c, ((fy) (obj)).d, paint);
                canvas.drawLine(fy1.a, fy1.b, fy1.a, fy1.d, paint);
                canvas.drawLine(fy1.a, fy1.d, ((fy) (obj)).c, ((fy) (obj)).d, paint);
            }
        }
        a(context, ((android.graphics.Bitmap) (abyte0)), a(context, s), (new StringBuilder()).append(s).append("_coordinates.png").toString(), android.graphics.Bitmap.CompressFormat.PNG, 0);
        return;
    }

    public static void a(Context context, byte abyte0[], int i, int j, String s, JSONObject jsonobject, JSONObject jsonobject1)
    {
        abyte0 = ay.a(abyte0, i, j);
        Canvas canvas = new Canvas(abyte0);
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(0.0F);
        paint.setColor(0xffff0000);
        try
        {
            Point point = a(jsonobject.getJSONObject("topLeft"));
            Point point1 = a(jsonobject.getJSONObject("topRight"));
            Point point2 = a(jsonobject.getJSONObject("bottomLeft"));
            jsonobject = a(jsonobject.getJSONObject("bottomRight"));
            canvas.drawLine(point.x, point.y, point1.x, point1.y, paint);
            canvas.drawLine(point1.x, point1.y, ((Point) (jsonobject)).x, ((Point) (jsonobject)).y, paint);
            canvas.drawLine(((Point) (jsonobject)).x, ((Point) (jsonobject)).y, point2.x, point2.y, paint);
            canvas.drawLine(point2.x, point2.y, point.x, point.y, paint);
            jsonobject = a(jsonobject1.getJSONObject("topLeft"));
            point = a(jsonobject1.getJSONObject("topRight"));
            point1 = a(jsonobject1.getJSONObject("bottomLeft"));
            jsonobject1 = a(jsonobject1.getJSONObject("bottomRight"));
            canvas.drawLine(((Point) (jsonobject)).x, ((Point) (jsonobject)).y, point.x, point.y, paint);
            canvas.drawLine(point.x, point.y, ((Point) (jsonobject1)).x, ((Point) (jsonobject1)).y, paint);
            canvas.drawLine(((Point) (jsonobject1)).x, ((Point) (jsonobject1)).y, point1.x, point1.y, paint);
            canvas.drawLine(point1.x, point1.y, ((Point) (jsonobject)).x, ((Point) (jsonobject)).y, paint);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        a(context, ((android.graphics.Bitmap) (abyte0)), a(context, s), (new StringBuilder()).append(s).append("_upload_coordinates.png").toString(), android.graphics.Bitmap.CompressFormat.PNG, 0);
    }

    public static void a(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, OcrQuadrangle ocrquadrangle)
    {
        if (d == null)
        {
            return;
        }
        if (!d.containsKey(fieldname))
        {
            d.put(fieldname, new ArrayList());
        }
        fy fy1 = new fy();
        fy1.a = ocrquadrangle.getTopLeft().getX();
        fy1.b = ocrquadrangle.getTopLeft().getY();
        fy1.c = ocrquadrangle.getBottomRight().getX();
        fy1.d = ocrquadrangle.getBottomRight().getY();
        ((ArrayList)d.get(fieldname)).add(fy1);
    }

    public static void a(com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName fieldname, StringBuilder stringbuilder)
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((fieldname = (ArrayList)d.get(fieldname)) != null)
        {
            int i = 0;
            while (i < fieldname.size()) 
            {
                fy fy1 = (fy)fieldname.get(i);
                stringbuilder.append(fy1.a).append(",").append(fy1.b).append(",").append(fy1.c).append(",").append(fy1.d).append("\r\n");
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String b(JSONObject jsonobject)
    {
        return String.format("%d, %d", new Object[] {
            Integer.valueOf(jsonobject.getInt("x")), Integer.valueOf(jsonobject.getInt("y"))
        });
    }

    public static StringBuilder f()
    {
        if (e == null)
        {
            e = new StringBuilder();
        }
        return e;
    }

    public static void g()
    {
        if (d == null)
        {
            d = new HashMap();
            return;
        } else
        {
            d.clear();
            return;
        }
    }

}
