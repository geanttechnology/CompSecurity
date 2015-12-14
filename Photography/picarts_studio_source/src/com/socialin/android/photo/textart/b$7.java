// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.d;
import com.socialin.android.photo.database.a;
import com.socialin.android.photo.f;
import com.socialin.android.util.ModernAsyncTask;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextArtStyle, TypefaceSpec

public final class sk extends ModernAsyncTask
{

    private String a;
    private b b;

    private transient Void a()
    {
        Object obj;
        if (a.equals(com.socialin.android.photo.textart.b.f(b)))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        obj = b.getActivity().getContentResolver();
        android.net.Uri uri = a.a;
        String s = a;
        obj = ((ContentResolver) (obj)).query(uri, new String[] {
            "addtext_usage"
        }, "addtext_addedtext=?", new String[] {
            s
        }, null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (((Cursor) (obj)).getCount() != 0)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        obj = new ContentValues(2);
        ((ContentValues) (obj)).put("addtext_addedtext", a);
        ((ContentValues) (obj)).put("addtext_created_at", Long.valueOf((new Date()).getTime()));
        b.getActivity().getContentResolver().insert(a.a, ((ContentValues) (obj)));
_L1:
        if (com.socialin.android.photo.textart.b.a().getTypefaceSpec().getFontPackageName() != null && "swyftmedia".equals(com.socialin.android.photo.textart.b.g(b)))
        {
            obj = new SwyftSerials(com.socialin.android.photo.textart.b.h(b), com.socialin.android.photo.textart.b.i(b), (new StringBuilder()).append(com.socialin.android.photo.textart.b.j(b)).append("_").append(String.format("%03d", new Object[] {
                Integer.valueOf(com.socialin.android.photo.textart.b.c() + 1)
            })).toString());
            SwyftAnalytics.getInstance().createTrackEvent("shop_package_use").addParam("serials", ((SwyftSerials) (obj)).toJSON().toString()).track();
        }
        obj = b.getActivity();
        com.picsart.studio.ItemType itemtype = b.o;
        TextArtStyle textartstyle = com.socialin.android.photo.textart.b.a();
        int i = com.socialin.android.photo.textart.b.b();
        com.socialin.android.photo.textart.b.c();
        f.a(((android.content.Context) (obj)), itemtype, textartstyle, i);
        return null;
        try
        {
            ((Cursor) (obj)).moveToFirst();
            ContentValues contentvalues = new ContentValues(2);
            contentvalues.put("addtext_usage", Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("addtext_usage")) + 1));
            contentvalues.put("addtext_created_at", Long.valueOf((new Date()).getTime()));
            b.getActivity().getContentResolver().update(a.a, contentvalues, "addtext_addedtext=?", new String[] {
                a
            });
        }
        catch (Exception exception)
        {
            d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
            return null;
        }
          goto _L1
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    public cs.TrackEvent(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }
}
