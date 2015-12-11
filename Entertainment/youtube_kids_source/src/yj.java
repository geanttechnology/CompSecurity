// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

final class yj extends AsyncTask
{

    private yg a;

    yj(yg yg1)
    {
        a = yg1;
        super();
    }

    private transient Boolean a()
    {
        Exception exception;
        if (!b())
        {
            return Boolean.valueOf(false);
        }
        adr adr1 = new adr(a.getApplicationContext());
        aek aek1 = new aek(adr1);
        try
        {
            aek1.save(yg.b(a));
        }
        catch (SQLException sqlexception)
        {
            adr1.close();
            return Boolean.valueOf(false);
        }
        finally
        {
            adr1.close();
        }
        adr1.close();
        return Boolean.valueOf(true);
        throw exception;
    }

    private boolean b()
    {
        Object obj1;
        Bitmap bitmap;
        bitmap = ThumbnailUtils.createVideoThumbnail(yg.b(a).getRecordingPath(), 1);
        obj1 = null;
        Object obj = new FileOutputStream(yg.b(a).getThumbnailPath());
        bitmap.compress(aei.THUMBNAIL_FORMAT, 100, ((java.io.OutputStream) (obj)));
        try
        {
            ((FileOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return true;
        }
        return true;
        obj;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
        obj;
_L2:
        if (obj1 != null)
        {
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L2; else goto _L1
_L1:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        yg.a(a).setControlsState(cuv.g);
        if (((Boolean) (obj)).booleanValue())
        {
            a.setResult(-1);
            a.finish();
            return;
        } else
        {
            Log.e(yg.h(), "Error saving recording!");
            a.setResult(0);
            a.finish();
            return;
        }
    }
}
