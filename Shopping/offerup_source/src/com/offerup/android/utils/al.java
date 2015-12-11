// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.b.a.a.g;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.dto.ItemPostPhoto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class al
{

    private ItemPost a;

    public al(ItemPost itempost)
    {
        a = itempost;
    }

    private boolean a(Context context, Uri uri)
    {
        context = context.getApplicationContext().getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        boolean flag;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        flag = (new File(context.getString(0))).exists();
        context.close();
        return flag;
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(this, context);
        }
        break MISSING_BLOCK_LABEL_90;
        uri;
        context.close();
        throw uri;
        return false;
    }

    public static boolean a(Category category)
    {
        return category != null;
    }

    public static boolean a(Double double1)
    {
        return double1 != null && double1.doubleValue() >= 0.0D;
    }

    public static boolean a(Integer integer)
    {
        return integer != null && integer.intValue() >= 0 && integer.intValue() <= 100;
    }

    public final List a(Context context)
    {
        ArrayList arraylist = new ArrayList();
        if (!a(a.getCondition()))
        {
            arraylist.add("Please state the condition of your item.");
        }
        if (!a(a.getCategory()))
        {
            arraylist.add("Please select a category.");
        }
        boolean flag;
        if (a.getListingType() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            arraylist.add("Please choose a listing type.");
        }
        if (!b(context))
        {
            arraylist.add("Please attach a picture of the item.");
        }
        if (!d() && !c())
        {
            arraylist.add("Please set a location");
        }
        if (!a(a.getPrice()))
        {
            arraylist.add("Please give your item a price.");
        }
        if (a())
        {
            arraylist.add("Please give your item a title.");
        } else
        if (b())
        {
            arraylist.add("Please limit the title to 150 letters.");
            return arraylist;
        }
        return arraylist;
    }

    public final boolean a()
    {
        String s = a.getTitle();
        return s == null || StringUtils.isEmpty(s.trim());
    }

    public final boolean b()
    {
        String s = a.getTitle();
        return s != null && s.length() > 150;
    }

    public final boolean b(Context context)
    {
        Object obj = a.getItemPostPhotos();
        if (obj != null && ((ArrayList) (obj)).size() > 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        obj = (ItemPostPhoto)((ArrayList) (obj)).get(0);
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((ItemPostPhoto) (obj)).getImageUri();
        if (obj == null) goto _L4; else goto _L5
_L5:
        if ("file".equalsIgnoreCase(((Uri) (obj)).getScheme()))
        {
            return (new File(((Uri) (obj)).getPath())).exists();
        }
        if ("content".equalsIgnoreCase(((Uri) (obj)).getScheme()))
        {
            return a(context, ((Uri) (obj)));
        }
        if (a.getId() == null || a.getId().longValue() <= 0L) goto _L4; else goto _L6
_L6:
        if (!"http".equalsIgnoreCase(((Uri) (obj)).getScheme()) && !"https".equalsIgnoreCase(((Uri) (obj)).getScheme())) goto _L1; else goto _L7
_L7:
        boolean flag = true;
_L9:
        return flag;
_L4:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final boolean c()
    {
        return StringUtils.isNotEmpty(a.getZipcode());
    }

    public final boolean d()
    {
        return a.getLatitude() != null && a.getLatitude().doubleValue() != 0.0D && a.getLongitude() != null && a.getLongitude().doubleValue() != 0.0D;
    }
}
