// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            x

final class u
    implements x
{

    u()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("ALTER TABLE items ADD video_url TEXT");
        sqlitedatabase.execSQL("ALTER TABLE flyers ADD analytics_payload TEXT");
        sqlitedatabase.execSQL("CREATE TABLE coupons (_id INTEGER PRIMARY KEY, merchant_id INTEGER, merchant_name TEXT, merchant_logo_url TEXT, coupon_vendor_id INTEGER, coupon_type TEXT, brand TEXT, brand_logo_url TEXT, sale_story TEXT, dollars_off REAL, percent_off REAL, qualifying_quantity INTEGER, reward_quantity INTEGER, promotion_text TEXT, disclaimer_text TEXT, redemption_method TEXT, available_from TEXT, available_to TEXT, valid_from TEXT, valid_to TEXT, coupon_image_url TEXT, barcode_image_url TEXT, priority INTEGER, use_sales_story INTEGER, postal_code TEXT, deleted INTEGER DEFAULT 0);");
        sqlitedatabase.execSQL("CREATE TABLE coupon_categories (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, coupon_id INTEGER, UNIQUE (name, coupon_id));");
        sqlitedatabase.execSQL("CREATE TABLE flyer_item_coupons (_id INTEGER PRIMARY KEY, flyer_item_id INTEGER, flyer_id INTEGER, coupon_id INTEGER, left REAL, top REAL, right REAL, bottom REAL,item_current_price REAL,item_original_price REAL,item_dollars_off REAL,item_cutout_url TEXT,coupon_dollars_off REAL,total_savings REAL,final_price REAL,percent_off REAL,display_final_price INTEGER,display_type INTEGER,item_rank INTEGER);");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        throw new RuntimeException("Downward migration not supported");
    }
}
