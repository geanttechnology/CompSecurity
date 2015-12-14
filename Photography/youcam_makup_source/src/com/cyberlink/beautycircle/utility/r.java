// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserAtrribute;
import com.cyberlink.beautycircle.model.UserInfo;
import com.edmodo.cropper.a.a;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.model.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager

public class r
{

    private static int a = 10;

    private static float a(int i, int j, int k)
    {
        if (i > j)
        {
            return (float)k / (float)i;
        } else
        {
            return (float)k / (float)j;
        }
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i, int j)
    {
label0:
        {
            {
                float f2 = 0.0F;
                float f1 = 0.0F;
                if (bitmap == null)
                {
                    return null;
                }
                new PointF();
                context = a(bitmap);
                int k = bitmap.getWidth();
                int l = bitmap.getHeight();
                float f4 = (float)k / (float)l;
                float f3 = (float)i / (float)j;
                if (f4 <= f3)
                {
                    break label0;
                }
                Edge.b.a(0.0F);
                Edge.d.a(l);
                f2 = (float)k / 2.0F;
                float f6 = Math.max(40F, com.edmodo.cropper.a.a.a(Edge.b.a(), Edge.d.a(), f3));
                if (f6 == 40F)
                {
                    f3 = 40F / (Edge.d.a() - Edge.b.a());
                }
                f3 = f6 / 2.0F;
                Edge.a.a(f2 - f3);
                Edge.c.a(f2 + f3);
                if (((PointF) (context)).x != 0.0F && ((PointF) (context)).y != 0.0F)
                {
                    f2 = ((PointF) (context)).x * (float)k - f3;
                    float f5;
                    if (f2 >= 0.0F)
                    {
                        f1 = f2;
                    }
                    f5 = f1 + f6;
                    f3 = f5;
                    f2 = f1;
                    if (f5 > (float)k)
                    {
                        f2 = f1 - (f5 - (float)k);
                        f3 = f2 + f6;
                    }
                    Edge.a.a(f2);
                    Edge.c.a(f3);
                }
            }
            f1 = Edge.a.a();
            f2 = Edge.b.a();
            f3 = Edge.b();
            f5 = Edge.c();
            return Bitmap.createBitmap(bitmap, (int)f1, (int)f2, (int)f3, (int)f5);
        }
        Edge.a.a(0.0F);
        Edge.c.a(k);
        f1 = (float)l / 2.0F;
        f6 = Math.max(40F, com.edmodo.cropper.a.a.b(Edge.a.a(), Edge.c.a(), f3));
        if (f6 == 40F)
        {
            f3 = (Edge.c.a() - Edge.a.a()) / 40F;
        }
        f3 = f6 / 2.0F;
        Edge.b.a(f1 - f3);
        Edge.d.a(f1 + f3);
        if (((PointF) (context)).x != 0.0F && ((PointF) (context)).y != 0.0F)
        {
            f1 = ((PointF) (context)).y * (float)l - f6 / 3F;
            if (f1 < 0.0F)
            {
                f1 = f2;
            }
            f5 = f1 + f6;
            f3 = f5;
            f2 = f1;
            if (f5 > (float)l)
            {
                f2 = f1 - (f5 - (float)l);
                f3 = f2 + f6;
            }
            Edge.b.a(f2);
            Edge.d.a(f3);
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_258;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int j)
    {
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1 = null;
_L4:
        return bitmap1;
_L2:
        int k;
        i = bitmap.getWidth();
        k = bitmap.getHeight();
        if (i > j)
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap1 = bitmap;
        if (k <= j) goto _L4; else goto _L3
_L3:
        Matrix matrix = new Matrix();
        float f1 = a(i, k, j);
        matrix.postScale(f1, f1);
        return Bitmap.createBitmap(bitmap, 0, 0, i, k, matrix, true);
    }

    public static PointF a(Bitmap bitmap)
    {
        PointF pointf;
        RectF rectf;
        rectf = new RectF();
        pointf = new PointF();
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        return pointf;
_L2:
        int i;
        Object obj1 = new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), a);
        android.media.FaceDetector.Face aface[] = new android.media.FaceDetector.Face[a];
        Object obj = pointf;
        float f1;
        Bitmap bitmap1;
        int j;
        try
        {
            bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.RGB_565, false);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return ((PointF) (obj));
        }
        if (bitmap1 == null) goto _L1; else goto _L3
_L3:
        obj = pointf;
        j = ((FaceDetector) (obj1)).findFaces(bitmap1, aface);
        i = 0;
        bitmap = pointf;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_217;
        }
        obj1 = aface[i];
        obj = bitmap;
        f1 = ((android.media.FaceDetector.Face) (obj1)).eyesDistance();
        obj = bitmap;
        pointf = new PointF();
        obj = bitmap;
        ((android.media.FaceDetector.Face) (obj1)).getMidPoint(pointf);
        obj = bitmap;
        rectf.union(new RectF(pointf.x - f1, pointf.y - f1, pointf.x + f1, f1 * 2.0F + pointf.y));
        if (i == 0)
        {
            bitmap = pointf;
            break MISSING_BLOCK_LABEL_317;
        }
        obj = bitmap;
        bitmap.x = (((PointF) (bitmap)).x + pointf.x) / 2.0F;
        obj = bitmap;
        f1 = ((PointF) (bitmap)).y;
        obj = bitmap;
        bitmap.y = (pointf.y + f1) / 2.0F;
        break MISSING_BLOCK_LABEL_317;
        obj = bitmap;
        bitmap.x = ((PointF) (bitmap)).x / (float)bitmap1.getWidth();
        obj = bitmap;
        bitmap.y = ((PointF) (bitmap)).y / (float)bitmap1.getHeight();
        obj = bitmap;
        bitmap1.recycle();
        obj = bitmap;
        Globals.b((new StringBuilder()).append("[FaceDetect] Found ").append(j).append(" faces. Eye midpoint (").append(((PointF) (bitmap)).x).append(", ").append(((PointF) (bitmap)).y).append(")").toString());
        return bitmap;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void a(Uri uri, Bitmap bitmap)
    {
        if (uri == null || bitmap == null)
        {
            return;
        }
        try
        {
            uri = uri.toString();
            f.b().d().a(uri, bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
        }
    }

    public static boolean a()
    {
        Object obj = AccountManager.d();
        if (obj != null)
        {
            if (((UserInfo) (obj)).birthDay == null || ((UserInfo) (obj)).birthDay.isEmpty() || ((UserInfo) (obj)).gender == null || ((UserInfo) (obj)).gender.isEmpty() || ((UserInfo) (obj)).name == null || ((UserInfo) (obj)).name.isEmpty() || ((UserInfo) (obj)).phone == null || ((UserInfo) (obj)).phone.isEmpty() || (((UserInfo) (obj)).email == null || ((UserInfo) (obj)).email.isEmpty()) && (((UserInfo) (obj)).receiveEmail == null || ((UserInfo) (obj)).receiveEmail.isEmpty()) || ((UserInfo) (obj)).address == null || ((UserInfo) (obj)).address.isEmpty())
            {
                return false;
            }
            obj = (UserAtrribute)Model.a(com/cyberlink/beautycircle/model/UserAtrribute, ((UserInfo) (obj)).attribute);
            return ((UserAtrribute) (obj)).skinType != null && !((UserAtrribute) (obj)).skinType.isEmpty() && ((UserAtrribute) (obj)).skinColor != null && !((UserAtrribute) (obj)).skinColor.isEmpty() && ((UserAtrribute) (obj)).isSensitive != null && ((UserAtrribute) (obj)).eyeColor != null && !((UserAtrribute) (obj)).eyeColor.isEmpty() && ((UserAtrribute) (obj)).lashLength != null && !((UserAtrribute) (obj)).lashLength.isEmpty() && ((UserAtrribute) (obj)).hairTexture != null && !((UserAtrribute) (obj)).hairTexture.isEmpty() && ((UserAtrribute) (obj)).hairColor != null && !((UserAtrribute) (obj)).hairColor.isEmpty() && ((UserAtrribute) (obj)).hairType != null && !((UserAtrribute) (obj)).hairType.isEmpty();
        } else
        {
            return false;
        }
    }

    public static boolean a(Bitmap bitmap, String s, int i)
    {
        boolean flag1 = false;
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L4:
        return flag;
_L2:
        s = new File(s);
        flag = flag1;
        if (s.exists())
        {
            continue; /* Loop/switch isn't completed */
        }
        s = new FileOutputStream(s);
        flag = bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, s);
        flag1 = flag;
        flag = flag1;
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                bitmap.printStackTrace();
                return flag1;
            }
            return flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        bitmap;
        s = null;
_L8:
        flag = flag1;
        if (s == null) goto _L4; else goto _L5
_L5:
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return false;
        bitmap;
        s = null;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        throw bitmap;
        bitmap;
        if (true) goto _L7; else goto _L6
_L6:
        bitmap;
          goto _L8
    }

}
