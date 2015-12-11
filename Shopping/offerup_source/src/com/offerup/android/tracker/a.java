// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.tracker;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.b.a.a.g;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.am;
import com.offerup.android.utils.av;
import com.offerup.android.utils.c;
import com.offerup.android.utils.v;
import com.omniata.android.sdk.Omniata;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.tracker:
//            ItemDetailUserInteractionRecord, PhotoGalleryUserInteractionRecord

public class a
{

    private static String a = com/offerup/android/tracker/a.getSimpleName();

    public a()
    {
    }

    private static JSONObject a(Item item)
    {
        int i = 1;
        JSONObject jsonobject = new JSONObject();
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        jsonobject.put("currency", "USD");
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        return jsonobject;
    }

    public static void a(long l, long l1)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("user_id", l);
            jsonobject.put("item_id", l1);
            am.a("ou_rate_seller_no_buy", jsonobject);
            return;
        }
        catch (Exception exception)
        {
            g.a(a, exception);
        }
    }

    public static void a(Activity activity, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        jsonobject.put("currency", "USD");
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        av.a("ou_item_sold", jsonobject);
        com.offerup.android.utils.c.a(activity, "ou_item_sold", item.getPrice());
        am.a("ou_item_sold", jsonobject);
_L1:
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("fb_currency", "USD");
        if (item != null && item.getCategory() != null)
        {
            ((Bundle) (obj)).putString("fb_content_type", item.getCategory().getName());
        }
        if (item != null && NumberUtils.isNumber(item.getPrice()))
        {
            v.a(activity, "SoldItem", Double.parseDouble(item.getPrice()), ((Bundle) (obj)));
            return;
        } else
        {
            v.a(activity, "SoldItem", ((Bundle) (obj)));
            return;
        }
        obj;
        g.a(activity.getClass().getSimpleName(), "Exception logging Omniata data", ((Exception) (obj)));
          goto _L1
    }

    public static void a(Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("currency", "USD");
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getOwner() != null)
        {
            jsonobject.put("owner_id", item.getOwner().getId());
        }
        av.a("ou_item_archived_buying", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_archived_buying");
        am.a("ou_item_archived_buying", jsonobject);
_L1:
        Exception exception;
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("fb_currency", "USD");
            bundle.putLong("fb_content_id", item.getId());
            if (item.getCategory() != null)
            {
                bundle.putString("fb_content_type", item.getCategory().getName());
            }
            if (item.getOwner() != null)
            {
                bundle.putLong("owner_id", item.getOwner().getId());
            }
            v.a(context, "ArchivedItemBuying", Double.parseDouble(item.getPrice()), bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(a, context);
        }
        break MISSING_BLOCK_LABEL_232;
        exception;
        g.a(a, exception);
          goto _L1
    }

    public static void a(Context context, OfferUpLocation offeruplocation, String s, String s1)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("search_location_name", s);
        jsonobject.put("search_location_lon", new Double(offeruplocation.c()));
        jsonobject.put("search_location_lat", new Double(offeruplocation.d()));
        if (!StringUtils.isEmpty(offeruplocation.a()))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        offeruplocation = offeruplocation.b();
_L1:
        jsonobject.put("search_location_zipcode", offeruplocation);
        av.a(s1, jsonobject);
        com.offerup.android.utils.c.a(context, s1);
        am.a(s1, jsonobject);
        return;
        try
        {
            offeruplocation = offeruplocation.a();
        }
        // Misplaced declaration of an exception variable
        catch (OfferUpLocation offeruplocation)
        {
            g.a(context.getClass().getSimpleName(), "Exception logging Omniata data", offeruplocation);
            return;
        }
          goto _L1
    }

    public static void a(Context context, Object obj, Item item)
    {
        try
        {
            item = a(item);
            av.a("ou_item_watched", item);
            com.offerup.android.utils.c.a(context, "ou_item_watched");
            am.a("ou_item_watched", item);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(obj, context);
        }
    }

    public static void a(Context context, String s, Item item)
    {
        a(context, s, ((String) (null)), item);
    }

    public static void a(Context context, String s, String s1, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        jsonobject.put("currency", "USD");
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (StringUtils.isNotEmpty(s1))
        {
            jsonobject.put("source", s1);
        }
        av.a(s, jsonobject);
        com.offerup.android.utils.c.a(context, s);
        am.a(s, jsonobject);
        return;
        context;
        g.a(a, context);
        return;
    }

    public static void a(ItemDetailUserInteractionRecord itemdetailuserinteractionrecord)
    {
        am.a("ItemDetail_end", itemdetailuserinteractionrecord.b());
    }

    public static void a(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord)
    {
        photogalleryuserinteractionrecord.a();
        am.a("ItemDetail_PhotoGallery_end", photogalleryuserinteractionrecord.d());
    }

    public static void a(Object obj, int i)
    {
        a(obj, "PostItem_CameraPlusMenuTakePhoto-Option_click", i);
    }

    public static void a(Object obj, Context context)
    {
        try
        {
            com.offerup.android.utils.c.a(context, "ou_item_detail_bid_click");
            am.a("ou_item_detail_bid_click");
            Omniata.track("ou_item_detail_bid_click");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(obj, context);
        }
    }

    public static void a(Object obj, Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("currency", "USD");
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        av.a("ou_item_reported", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_reported");
        am.a("ou_item_reported", jsonobject);
        return;
        context;
        g.a(obj, context);
        return;
    }

    public static void a(Object obj, Context context, String s, String s1, boolean flag)
    {
        double d1;
        try
        {
            d1 = Double.parseDouble(s.replace("$", ""));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            d1 = 0.0D;
        }
        s = new JSONObject();
        s.put("item_price", d1);
        s.put("category", s1);
        s.put("currency", "USD");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            s.put("firm_price", i);
            av.a("ou_item_post", s);
            com.offerup.android.utils.c.a(context, "ou_item_post");
            am.a("ou_item_post", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(obj, s);
        }
        obj = new Bundle();
        ((Bundle) (obj)).putString("fb_currency", "USD");
        ((Bundle) (obj)).putString("fb_content_type", s1);
        if (d1 > 0.0D)
        {
            v.a(context, "PostedItem", d1, ((Bundle) (obj)));
            return;
        } else
        {
            v.a(context, "PostedItem", ((Bundle) (obj)));
            return;
        }
    }

    public static void a(Object obj, Uri uri, String s, long l)
    {
        if (uri != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        uri = new HashMap();
        uri.put("bnd", s);
        uri.put("itemId", String.format("%s", new Object[] {
            Long.valueOf(l)
        }));
        am.a("AD-889", new JSONObject((new GsonBuilder()).create().toJson(uri)));
        return;
        uri;
        g.a(obj, uri);
        return;
    }

    public static void a(Object obj, String s)
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("from_screen", s);
            hashmap.put("type", "back");
            am.a("ou_back_pressed", new JSONObject((new GsonBuilder()).create().toJson(hashmap)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(obj, s);
        }
    }

    private static void a(Object obj, String s, int i)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("image", i);
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(obj, s);
        }
    }

    public static void a(String s)
    {
        try
        {
            if (StringUtils.isNotEmpty(s))
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("screen_name", s);
                av.a("ou_ui_screenview", jsonobject);
                s = String.format("%s_%s", new Object[] {
                    "ou_screenview", s
                });
                am.a(s);
                g.b("ScreenView", s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, long l)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("item_id", l);
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, long l, long l1, int i)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("user_id", l);
            jsonobject.put("item_id", l1);
            jsonobject.put("rating", i);
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, long l, Person person)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("item_id", l);
            jsonobject.put("user_id", person.getId());
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, String s1)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            if (StringUtils.isNotEmpty(s1))
            {
                jsonobject.put("query_keyword", s1);
            }
            av.a(s, jsonobject);
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, String s1, long l)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("screen_name", s);
            jsonobject.put("origin", s1);
            jsonobject.put("itemId", l);
            av.a("ou_ui_screenview", jsonobject);
            s = String.format("%s_%s", new Object[] {
                "ou_screenview", s
            });
            am.a(s, jsonobject);
            g.b("ScreenView", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void a(String s, String s1, long l, int i, int j, boolean flag)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("screen_name", s);
            jsonobject.put("origin", s1);
            jsonobject.put("itemId", l);
            jsonobject.put("listId", i);
            jsonobject.put("itemListPosition", j);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        jsonobject.put("search", flag);
        av.a("ou_ui_screenview", jsonobject);
        s = String.format("%s_%s", new Object[] {
            "ou_screenview", s
        });
        am.a(s, jsonobject);
        g.b("ScreenView", s);
        return;
    }

    public static void a(String s, JSONObject jsonobject)
    {
        try
        {
            av.a(s, jsonobject);
            am.a(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void b(Activity activity, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        jsonobject.put("currency", "USD");
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        av.a("ou_item_delete", jsonobject);
        am.a("ou_item_delete", jsonobject);
        return;
        item;
        g.a(activity, item);
        return;
    }

    public static void b(Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("currency", "USD");
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getOwner() != null)
        {
            jsonobject.put("owner_id", item.getOwner().getId());
        }
        av.a("ou_item_archived_selling", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_archived_selling");
        am.a("ou_item_archived_selling", jsonobject);
_L1:
        Exception exception;
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("fb_currency", "USD");
            bundle.putLong("fb_content_id", item.getId());
            if (item.getCategory() != null)
            {
                bundle.putString("fb_content_type", item.getCategory().getName());
            }
            if (item.getOwner() != null)
            {
                bundle.putLong("owner_id", item.getOwner().getId());
            }
            v.a(context, "ArchivedItemSelling", Double.parseDouble(item.getPrice()), bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(a, context);
        }
        break MISSING_BLOCK_LABEL_236;
        exception;
        g.a(a, exception);
          goto _L1
    }

    public static void b(Context context, Object obj, Item item)
    {
        try
        {
            item = a(item);
            av.a("ou_item_unwatched", item);
            com.offerup.android.utils.c.a(context, "ou_item_unwatched");
            am.a("ou_item_unwatched", item);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(obj, context);
        }
    }

    public static void b(Object obj, int i)
    {
        a(obj, "PostItem_CameraPlusMenuSelectPhoto-Option_click", i);
    }

    public static void b(Object obj, Context context)
    {
        try
        {
            com.offerup.android.utils.c.a(context, "ou_item_detail_ask_click");
            am.a("ou_item_detail_ask_click");
            Omniata.track("ou_item_detail_ask_click");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(obj, context);
        }
    }

    public static void b(Object obj, String s)
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("from_screen", s);
            hashmap.put("type", "up");
            am.a("ou_back_pressed", new JSONObject((new GsonBuilder()).create().toJson(hashmap)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(obj, s);
        }
    }

    public static void b(String s)
    {
        try
        {
            am.a(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void c(Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("currency", "USD");
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getOwner() != null)
        {
            jsonobject.put("owner_id", item.getOwner().getId());
        }
        av.a("ou_item_unarchived_buying", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_unarchived_buying");
        am.a("ou_item_unarchived_buying", jsonobject);
_L1:
        Exception exception;
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("fb_currency", "USD");
            bundle.putLong("fb_content_id", item.getId());
            if (item.getCategory() != null)
            {
                bundle.putString("fb_content_type", item.getCategory().getName());
            }
            if (item.getOwner() != null)
            {
                bundle.putLong("owner_id", item.getOwner().getId());
            }
            v.a(context, "UnarchivedItemBuying", Double.parseDouble(item.getPrice()), bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(a, context);
        }
        break MISSING_BLOCK_LABEL_236;
        exception;
        g.a(a, exception);
          goto _L1
    }

    public static void c(Object obj, int i)
    {
        a(obj, "PostItem_CameraPlusMenuCancel-Option_click", i);
    }

    public static void c(String s)
    {
        try
        {
            am.a(String.format("%s_%s", new Object[] {
                "ou_item_list", s.replaceAll(" ", "_").toLowerCase()
            }));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(a, s);
        }
    }

    public static void d(Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("currency", "USD");
        if (item.getCategory() != null)
        {
            jsonobject.put("category", item.getCategory().getName());
        }
        jsonobject.put("item_id", item.getId());
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        if (NumberUtils.isNumber(item.getPrice()))
        {
            jsonobject.put("item_price", item.getPrice());
        }
        if (item.getOwner() != null)
        {
            jsonobject.put("owner_id", item.getOwner().getId());
        }
        av.a("ou_item_unarchived_selling", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_unarchived_selling");
        am.a("ou_item_unarchived_selling", jsonobject);
_L1:
        Exception exception;
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("fb_currency", "USD");
            bundle.putLong("fb_content_id", item.getId());
            if (item.getCategory() != null)
            {
                bundle.putString("fb_content_type", item.getCategory().getName());
            }
            if (item.getOwner() != null)
            {
                bundle.putLong("owner_id", item.getOwner().getId());
            }
            v.a(context, "UnarchivedItemSelling", Double.parseDouble(item.getPrice()), bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a(a, context);
        }
        break MISSING_BLOCK_LABEL_236;
        exception;
        g.a(a, exception);
          goto _L1
    }

    public static void d(Object obj, int i)
    {
        a(obj, "PostItem_SetNewCoverPhoto-Option_click", i);
    }

    public static void d(String s)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("screenview", s);
            am.a("ou_actionbar_itempost_click", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void e(Context context, Item item)
    {
        int i = 1;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("item_price", item.getPrice());
        jsonobject.put("category", item.getCategory().getId());
        jsonobject.put("currency", "USD");
        if (1 != item.getListingType())
        {
            i = 0;
        }
        jsonobject.put("firm_price", i);
        av.a("ou_item_edit", jsonobject);
        com.offerup.android.utils.c.a(context, "ou_item_edit");
        am.a("ou_item_edit", jsonobject);
        return;
        item;
        g.a(context.getClass().getSimpleName(), "", item);
        return;
    }

    public static void e(Object obj, int i)
    {
        a(obj, "PostItem_DeletePhoto-Option_click", i);
    }

    public static void e(String s)
    {
        if (!StringUtils.isNotEmpty(s))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("item_list", s);
        am.a("ou_actionbar_search_click", jsonobject);
        return;
        s;
    }

}
