// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.nostra13.universalimageloader.a.b.a;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a extends j
{

    final CameraCtrl a;

    protected Bitmap a(Void void1)
    {
        String s;
        s = Exporter.a();
        void1 = new File(s);
        if (void1.exists()) goto _L2; else goto _L1
_L1:
        void1.mkdirs();
_L4:
        return null;
_L2:
        if (CameraCtrl.u(a) == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Cursor cursor;
        void1 = CameraCtrl.u(a).getContentResolver();
        obj = (new StringBuilder()).append(s).append("%").toString();
        cursor = void1.query(android.provider.ges.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "bucket_id", "_id", "_data"
        }, "_data LIKE ?", new String[] {
            obj
        }, "date_added DESC");
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        obj = null;
_L6:
        void1 = ((Void) (obj));
        if (!cursor.moveToNext())
        {
            break MISSING_BLOCK_LABEL_342;
        }
        void1 = ((Void) (obj));
        String s1 = cursor.getString(cursor.getColumnIndex("_data"));
        void1 = ((Void) (obj));
        File file = new File(s1);
        void1 = ((Void) (obj));
        Object obj1 = file.getParent();
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        void1 = ((Void) (obj));
        if (!((String) (obj1)).equals(s)) goto _L6; else goto _L7
_L7:
        void1 = ((Void) (obj));
        long l = cursor.getLong(cursor.getColumnIndex("_id"));
        void1 = ((Void) (obj));
        com.cyberlink.youcammakeup.camera.CameraCtrl.a(a, cursor.getLong(cursor.getColumnIndex("bucket_id")));
        void1 = ((Void) (obj));
        obj1 = c.f();
        void1 = ((Void) (obj));
        CameraCtrl.b(a, ((p) (obj1)).f(l));
        void1 = ((Void) (obj));
        s1 = (new StringBuilder()).append(s1).append("_preview").toString();
        void1 = ((Void) (obj));
        obj = f.b().c().a(s1);
        void1 = ((Void) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        void1 = ((Void) (obj));
        obj = ImageUtils.a(Globals.d().getApplicationContext(), Uri.fromFile(file));
        void1 = ((Void) (obj));
        f.b().c().a(s1, ((Bitmap) (obj)));
        void1 = ((Void) (obj));
_L8:
        cursor.close();
        return void1;
        Exception exception;
        exception;
        exception = void1;
          goto _L6
        void1 = null;
          goto _L8
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    (CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
