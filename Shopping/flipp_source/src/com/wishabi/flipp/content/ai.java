// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.RectF;
import android.net.Uri;
import b.a.a.b;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.content:
//            i

public final class ai
{

    public long a;
    public int b;
    public String c;
    public Uri d;
    public RectF e;
    public String f;
    public String g;
    public boolean h;
    public b i;
    private int j;
    private final int k;

    private ai(int l)
    {
        k = l;
    }

    public static ai a(JSONObject jsonobject, int l, ContentResolver contentresolver)
    {
        ai ai1;
        boolean flag;
        try
        {
            ai1 = new ai(l);
            ai1.a = jsonobject.getLong("flyer_item_id");
            ai1.b = jsonobject.getInt("flyer_id");
            ai1.c = jsonobject.getString("name");
            ai1.d = Uri.parse(jsonobject.getString("clipping_image_url"));
            ai1.e = new RectF();
            ai1.e.left = (float)jsonobject.getDouble("left");
            ai1.e.top = -(float)jsonobject.getDouble("top");
            ai1.e.right = (float)jsonobject.getDouble("right");
            ai1.e.bottom = -(float)jsonobject.getDouble("bottom");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return null;
        }
        contentresolver = contentresolver.query(i.a, null, "flyer_id = ?", new String[] {
            String.valueOf(ai1.b)
        }, null);
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        flag = contentresolver.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        contentresolver.close();
        return ai1;
        ai1.f = contentresolver.getString(contentresolver.getColumnIndexOrThrow("merchant"));
        ai1.g = contentresolver.getString(contentresolver.getColumnIndexOrThrow("merchant_logo"));
        ai1.j = contentresolver.getInt(contentresolver.getColumnIndexOrThrow("priority"));
        ai1.h = jsonobject.getBoolean("premium");
_L2:
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        contentresolver.close();
        return ai1;
        jsonobject;
        if (contentresolver.getInt(contentresolver.getColumnIndexOrThrow("premium")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ai1.h = flag;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
_L4:
        if (contentresolver == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        contentresolver.close();
        throw jsonobject;
        jsonobject;
        contentresolver = null;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
