// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import com.wishabi.flipp.app.FavoritesFragment;
import com.wishabi.flipp.app.FeaturedFragment;
import com.wishabi.flipp.app.FlippApplication;
import com.wishabi.flipp.content.aj;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.f;
import com.wishabi.flipp.util.g;
import com.wishabi.flipp.util.h;
import com.wishabi.flipp.util.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            ak

class y extends AsyncTask
{

    private static final String a = com/wishabi/flipp/b/y.getSimpleName();
    private final String b;
    private final String c = Locale.getDefault().toString();

    public y(String s)
    {
        b = s;
    }

    private static HashSet a(JSONObject jsonobject)
    {
        HashSet hashset;
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = new ArrayList();
        obj1 = new ArrayList();
        obj = new ArrayList();
        hashset = new HashSet();
        Object obj3;
        Object obj4;
        ContentValues contentvalues3;
        int j;
        int k;
        int l;
        try
        {
            jsonobject = jsonobject.getJSONArray("flyers");
            l = jsonobject.length();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            (new StringBuilder("Error processing flyer JSON: ")).append(jsonobject.toString());
            return null;
        }
        j = 0;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = jsonobject.getJSONObject(j);
        obj4 = new ContentValues();
        hashset.add(Integer.valueOf(((JSONObject) (obj3)).getInt("id")));
        ((ContentValues) (obj4)).put("_id", Integer.valueOf(((JSONObject) (obj3)).getInt("id")));
        ((ContentValues) (obj4)).put("flyer_id", Integer.valueOf(((JSONObject) (obj3)).getInt("id")));
        ((ContentValues) (obj4)).put("available_from", ((JSONObject) (obj3)).getString("available_from"));
        ((ContentValues) (obj4)).put("available_to", ((JSONObject) (obj3)).getString("available_to"));
        ((ContentValues) (obj4)).put("flyer_run_id", Integer.valueOf(((JSONObject) (obj3)).getInt("flyer_run_id")));
        ((ContentValues) (obj4)).put("flyer_type_id", Integer.valueOf(((JSONObject) (obj3)).getInt("flyer_type_id")));
        ((ContentValues) (obj4)).put("width", Double.valueOf(((JSONObject) (obj3)).getDouble("width")));
        ((ContentValues) (obj4)).put("height", Double.valueOf(((JSONObject) (obj3)).getDouble("height")));
        ((ContentValues) (obj4)).put("language", ((JSONObject) (obj3)).optString("language", "en"));
        ((ContentValues) (obj4)).put("locale", ((JSONObject) (obj3)).getString("locale"));
        ((ContentValues) (obj4)).put("merchant", ((JSONObject) (obj3)).getString("merchant"));
        ((ContentValues) (obj4)).put("merchant_id", Integer.valueOf(((JSONObject) (obj3)).getInt("merchant_id")));
        ((ContentValues) (obj4)).put("merchant_logo", ((JSONObject) (obj3)).getString("merchant_logo"));
        ((ContentValues) (obj4)).put("name", ((JSONObject) (obj3)).getString("name"));
        ((ContentValues) (obj4)).put("path", ((JSONObject) (obj3)).getString("path"));
        ((ContentValues) (obj4)).put("postal_code", ((JSONObject) (obj3)).getString("postal_code"));
        ((ContentValues) (obj4)).put("premium", Boolean.valueOf(((JSONObject) (obj3)).getBoolean("premium")));
        ((ContentValues) (obj4)).put("priority", Integer.valueOf(((JSONObject) (obj3)).getInt("priority")));
        ((ContentValues) (obj4)).put("thumbnail", ((JSONObject) (obj3)).getString("thumbnail_url"));
        ((ContentValues) (obj4)).put("updated_at", ((JSONObject) (obj3)).getString("updated_at"));
        ((ContentValues) (obj4)).put("web_indexed", Boolean.valueOf(((JSONObject) (obj3)).getBoolean("web_indexed")));
        ((ContentValues) (obj4)).put("valid_from", ((JSONObject) (obj3)).getString("valid_from"));
        ((ContentValues) (obj4)).put("valid_to", ((JSONObject) (obj3)).getString("valid_to"));
        ((ContentValues) (obj4)).put("analytics_payload", ((JSONObject) (obj3)).getString("analytics_payload"));
        ((ContentValues) (obj4)).put("store_select", Boolean.valueOf(((JSONObject) (obj3)).getBoolean("is_store_select")));
        ((ContentValues) (obj4)).put("resolutions", ((JSONObject) (obj3)).getJSONArray("resolutions").toString());
        ((List) (obj2)).add(obj4);
        obj4 = ((JSONObject) (obj3)).getJSONArray("categories");
        k = 0;
_L2:
        if (k >= ((JSONArray) (obj4)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues3 = new ContentValues();
        contentvalues3.put("name", ((JSONArray) (obj4)).getString(k));
        contentvalues3.put("flyer_id", ((JSONObject) (obj3)).getString("id"));
        ((List) (obj1)).add(contentvalues3);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        obj3 = h.b(((JSONObject) (obj3)), "featured_items");
        if (obj3 == null) goto _L4; else goto _L3
_L3:
        k = 0;
_L5:
        if (k >= ((JSONArray) (obj3)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj4 = ((JSONArray) (obj3)).getJSONObject(k);
        contentvalues3 = new ContentValues();
        contentvalues3.put("_id", Long.valueOf(((JSONObject) (obj4)).getLong("flyer_item_id")));
        contentvalues3.put("flyer_id", Integer.valueOf(((JSONObject) (obj4)).getInt("flyer_id")));
        contentvalues3.put("item_image_url", ((JSONObject) (obj4)).getString("item_image_url"));
        contentvalues3.put("weight", Integer.valueOf(((JSONObject) (obj4)).getInt("weight")));
        contentvalues3.put("sale_story", h.a(((JSONObject) (obj4)), "sale_story"));
        contentvalues3.put("description", h.a(((JSONObject) (obj4)), "description"));
        contentvalues3.put("brand_id", h.a(((JSONObject) (obj4)), "brand_id", Integer.valueOf(-1)));
        contentvalues3.put("brand_logo_image_url", h.a(((JSONObject) (obj4)), "brand_logo_image_url"));
        contentvalues3.put("brand_display_name", h.a(((JSONObject) (obj4)), "brand_display_name"));
        contentvalues3.put("left", h.a(((JSONObject) (obj4)), "left", Double.valueOf(0.0D)));
        contentvalues3.put("top", Double.valueOf(-h.a(((JSONObject) (obj4)), "top", Double.valueOf(0.0D)).doubleValue()));
        contentvalues3.put("right", h.a(((JSONObject) (obj4)), "right", Double.valueOf(0.0D)));
        contentvalues3.put("bottom", Double.valueOf(-h.a(((JSONObject) (obj4)), "bottom", Double.valueOf(0.0D)).doubleValue()));
        ((List) (obj)).add(contentvalues3);
        k++;
        if (true) goto _L5; else goto _L4
_L4:
        j++;
        if (true) goto _L7; else goto _L6
_L7:
        break MISSING_BLOCK_LABEL_49;
_L6:
        jsonobject = new ArrayList();
        jsonobject.add(ContentProviderOperation.newDelete(i.a).build());
        jsonobject.add(ContentProviderOperation.newDelete(i.c).build());
        jsonobject.add(ContentProviderOperation.newDelete(i.d).build());
        jsonobject.add(ContentProviderOperation.newDelete(i.b).build());
        jsonobject.add(ContentProviderOperation.newDelete(i.e).build());
        ContentValues contentvalues1;
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); jsonobject.add(ContentProviderOperation.newInsert(i.a).withValues(contentvalues1).build()))
        {
            contentvalues1 = (ContentValues)((Iterator) (obj2)).next();
        }

        ContentValues contentvalues;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); jsonobject.add(ContentProviderOperation.newInsert(i.b).withValues(contentvalues).build()))
        {
            contentvalues = (ContentValues)((Iterator) (obj1)).next();
        }

        obj1 = FlippApplication.b();
        if (obj1 == null)
        {
            return null;
        }
        obj1 = ((Context) (obj1)).getContentResolver();
        ((ContentResolver) (obj1)).applyBatch("com.wishabi.flipp.content.Flyer", jsonobject);
        if (!((List) (obj)).isEmpty())
        {
            ((ContentResolver) (obj1)).bulkInsert(i.e, (ContentValues[])((List) (obj)).toArray(new ContentValues[((List) (obj)).size()]));
        }
        jsonobject = new ArrayList();
        jsonobject.add(ContentProviderOperation.newDelete(aj.d).build());
        obj = aj.a();
        if (obj != null)
        {
            ContentValues contentvalues2;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); jsonobject.add(ContentProviderOperation.newInsert(aj.d).withValues(contentvalues2).build()))
            {
                String s = (String)((Iterator) (obj)).next();
                contentvalues2 = new ContentValues();
                contentvalues2.put("word", s);
            }

        }
          goto _L8
        jsonobject;
_L12:
        (new StringBuilder("Error inserting flyers: ")).append(jsonobject.toString());
        return null;
_L8:
        ((ContentResolver) (obj1)).applyBatch("com.wishabi.flipp.content.SearchTerm", jsonobject);
        return hashset;
        jsonobject;
_L10:
        (new StringBuilder("Error inserting merchant: ")).append(jsonobject.toString());
        return hashset;
        jsonobject;
        if (true) goto _L10; else goto _L9
_L9:
        jsonobject;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private boolean a(JSONObject jsonobject, HashSet hashset, HashSet hashset1)
    {
        Object obj;
        ArrayList arraylist;
        obj = FlippApplication.b();
        if (obj == null)
        {
            return false;
        }
        obj = ((Context) (obj)).getContentResolver();
        arraylist = new ArrayList();
        arraylist.add(ContentProviderOperation.newDelete(i.p).build());
        if (hashset != null && hashset1 != null) goto _L2; else goto _L1
_L1:
        ((ContentResolver) (obj)).applyBatch("com.wishabi.flipp.content.Flyer", arraylist);
_L3:
        return false;
        jsonobject;
_L9:
        (new StringBuilder("Error deleting flyer-item-coupon data: ")).append(jsonobject.toString());
        if (true) goto _L3; else goto _L2
_L2:
        ArrayList arraylist1;
        arraylist1 = new ArrayList();
        JSONObject jsonobject1;
        ContentValues contentvalues;
        int j;
        int k;
        try
        {
            jsonobject = jsonobject.optJSONArray("flyer_item_coupons");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            (new StringBuilder("Error processing coupon JSON: ")).append(jsonobject.toString());
            return false;
        }
        if (jsonobject == null) goto _L5; else goto _L4
_L4:
        j = 0;
_L6:
        if (j >= jsonobject.length() || isCancelled())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject1 = jsonobject.getJSONObject(j);
        if (!hashset1.contains(Integer.valueOf(jsonobject1.getInt("coupon_id"))) || !hashset.contains(Integer.valueOf(jsonobject1.getInt("flyer_id"))))
        {
            break MISSING_BLOCK_LABEL_526;
        }
        contentvalues = new ContentValues();
        contentvalues.put("_id", Integer.valueOf(jsonobject1.getInt("id")));
        contentvalues.put("flyer_item_id", Long.valueOf(jsonobject1.getLong("flyer_item_id")));
        contentvalues.put("flyer_id", Integer.valueOf(jsonobject1.getInt("flyer_id")));
        contentvalues.put("coupon_id", Integer.valueOf(jsonobject1.getInt("coupon_id")));
        contentvalues.put("left", Integer.valueOf(jsonobject1.getInt("left")));
        contentvalues.put("top", Integer.valueOf(-jsonobject1.getInt("top")));
        contentvalues.put("right", Integer.valueOf(jsonobject1.getInt("right")));
        contentvalues.put("bottom", Integer.valueOf(-jsonobject1.getInt("bottom")));
        contentvalues.put("item_current_price", h.a(jsonobject1, "item_current_price", null));
        contentvalues.put("item_original_price", h.a(jsonobject1, "item_original_price", null));
        contentvalues.put("item_dollars_off", h.a(jsonobject1, "item_dollars_off", null));
        contentvalues.put("item_cutout_url", jsonobject1.getString("item_cutout_url"));
        contentvalues.put("coupon_dollars_off", h.a(jsonobject1, "coupon_dollars_off", null));
        contentvalues.put("total_savings", h.a(jsonobject1, "total_savings", null));
        contentvalues.put("final_price", h.a(jsonobject1, "final_price", null));
        contentvalues.put("percent_off", h.a(jsonobject1, "percent_off", null));
        if (jsonobject1.getBoolean("display_final_price"))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        contentvalues.put("display_final_price", Integer.valueOf(k));
        contentvalues.put("display_type", h.a(jsonobject1, "display_type", null));
        contentvalues.put("item_rank", Integer.valueOf(jsonobject1.getInt("item_rank")));
        arraylist1.add(contentvalues);
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        if (isCancelled())
        {
            return false;
        }
        for (jsonobject = arraylist1.iterator(); jsonobject.hasNext(); arraylist.add(ContentProviderOperation.newInsert(i.p).withValues(hashset).build()))
        {
            hashset = (ContentValues)jsonobject.next();
        }

        if (isCancelled())
        {
            return false;
        }
        ((ContentResolver) (obj)).applyBatch("com.wishabi.flipp.content.Flyer", arraylist);
        return true;
        jsonobject;
_L8:
        (new StringBuilder("Error inserting flyer-item-coupon data: ")).append(jsonobject.toString());
        return false;
        jsonobject;
        if (true) goto _L8; else goto _L7
_L7:
        jsonobject;
          goto _L9
    }

    private static HashSet b(JSONObject jsonobject)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj = new HashSet();
        obj2 = new ArrayList();
        obj1 = new ArrayList();
        JSONObject jsonobject1;
        Object obj3;
        ContentValues contentvalues;
        int j;
        int k;
        int l;
        int i1;
        try
        {
            jsonobject = jsonobject.getJSONArray("coupons");
            l = jsonobject.length();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            (new StringBuilder("Error processing coupon JSON: ")).append(jsonobject.toString());
            return null;
        }
        j = 0;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject1 = jsonobject.getJSONObject(j);
        obj3 = jsonobject1.getString("redemption_method");
        i1 = jsonobject1.getInt("coupon_id");
        if (!((String) (obj3)).equalsIgnoreCase("print")) goto _L2; else goto _L1
_L1:
        contentvalues = new ContentValues();
        contentvalues.put("_id", Integer.valueOf(i1));
        contentvalues.put("merchant_id", h.a(jsonobject1, "merchant_id", null));
        contentvalues.put("merchant_name", h.a(jsonobject1, "merchant_name"));
        contentvalues.put("merchant_logo_url", h.a(jsonobject1, "merchant_logo_url"));
        contentvalues.put("coupon_vendor_id", h.a(jsonobject1, "coupon_vendor_id", null));
        contentvalues.put("coupon_type", jsonobject1.getString("coupon_type"));
        contentvalues.put("brand", h.a(jsonobject1, "brand"));
        contentvalues.put("brand_logo_url", h.a(jsonobject1, "brand_logo_url"));
        contentvalues.put("sale_story", h.a(jsonobject1, "sale_story"));
        contentvalues.put("dollars_off", h.a(jsonobject1, "dollars_off", null));
        contentvalues.put("percent_off", h.a(jsonobject1, "percent_off", null));
        contentvalues.put("qualifying_quantity", h.a(jsonobject1, "qualifying_quantity", null));
        contentvalues.put("reward_quantity", h.a(jsonobject1, "reward_quantity", null));
        contentvalues.put("promotion_text", h.a(jsonobject1, "promotion_text"));
        contentvalues.put("disclaimer_text", h.a(jsonobject1, "disclaimer_text"));
        contentvalues.put("redemption_method", ((String) (obj3)));
        contentvalues.put("available_from", jsonobject1.getString("available_from"));
        contentvalues.put("available_to", h.a(jsonobject1, "available_to"));
        contentvalues.put("valid_from", jsonobject1.getString("valid_from"));
        contentvalues.put("valid_to", h.a(jsonobject1, "valid_to"));
        contentvalues.put("coupon_image_url", jsonobject1.getString("coupon_image_url"));
        contentvalues.put("barcode_image_url", h.a(jsonobject1, "barcode_image_url"));
        if (jsonobject1.getBoolean("use_sales_story"))
        {
            k = 1;
        } else
        {
            k = 0;
        }
        contentvalues.put("use_sales_story", Integer.valueOf(k));
        contentvalues.put("priority", Integer.valueOf(jsonobject1.getInt("priority")));
        contentvalues.put("postal_code", jsonobject1.getString("postal_code"));
        ((List) (obj2)).add(contentvalues);
        ((HashSet) (obj)).add(Integer.valueOf(i1));
        obj3 = jsonobject1.getJSONArray("categories");
        i1 = ((JSONArray) (obj3)).length();
        k = 0;
_L3:
        if (k >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        contentvalues = new ContentValues();
        contentvalues.put("name", ((JSONArray) (obj3)).getString(k));
        contentvalues.put("coupon_id", Integer.valueOf(jsonobject1.getInt("coupon_id")));
        ((List) (obj1)).add(contentvalues);
        k++;
        if (true) goto _L3; else goto _L2
_L2:
        j++;
        if (true) goto _L5; else goto _L4
_L5:
        break MISSING_BLOCK_LABEL_41;
_L4:
        ContentResolver contentresolver;
        ArrayList arraylist;
        jsonobject = FlippApplication.b();
        if (jsonobject == null)
        {
            return null;
        }
        contentresolver = jsonobject.getContentResolver();
        arraylist = new ArrayList();
        jsonobject = contentresolver.query(i.q, new String[] {
            "_id"
        }, "user_coupon_data._id IS NULL", null, null);
        String as[];
        as = f.b(jsonobject, "_id");
        break MISSING_BLOCK_LABEL_687;
        obj;
        jsonobject = null;
_L9:
        if (jsonobject != null)
        {
            jsonobject.close();
        }
        throw obj;
        if (jsonobject != null)
        {
            jsonobject.close();
        }
        if (as.length > 0)
        {
            arraylist.add(ContentProviderOperation.newDelete(i.n).withSelection(f.a("_id", as), as).build());
        }
        jsonobject = new ContentValues();
        jsonobject.put("deleted", Integer.valueOf(1));
        arraylist.add(ContentProviderOperation.newUpdate(i.n).withValues(jsonobject).build());
        arraylist.add(ContentProviderOperation.newDelete(i.o).build());
        for (jsonobject = ((List) (obj2)).iterator(); jsonobject.hasNext(); arraylist.add(ContentProviderOperation.newInsert(i.n).withValues(((ContentValues) (obj2))).build()))
        {
            obj2 = (ContentValues)jsonobject.next();
        }

        for (jsonobject = ((List) (obj1)).iterator(); jsonobject.hasNext(); arraylist.add(ContentProviderOperation.newInsert(i.o).withValues(((ContentValues) (obj1))).build()))
        {
            obj1 = (ContentValues)jsonobject.next();
        }

        contentresolver.applyBatch("com.wishabi.flipp.content.Flyer", arraylist);
        contentresolver.delete(i.q, "flyerdb.coupons.deleted = 1 AND user_coupon_data.clipped = 0", null);
        return ((HashSet) (obj));
        jsonobject;
_L7:
        (new StringBuilder("Error inserting coupon data: ")).append(jsonobject.toString());
        return null;
        jsonobject;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void a(Boolean boolean1)
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        if (TextUtils.isEmpty(b))
        {
            return Boolean.valueOf(false);
        }
        if (TextUtils.isEmpty(c))
        {
            return Boolean.valueOf(false);
        }
        aobj = p.a();
        if (aobj == null)
        {
            return Boolean.valueOf(false);
        }
        Object obj = Uri.parse("https://backflipp.wishabi.com/flipp/data").buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("postal_code", b);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("locale", c);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("sid", ((SharedPreferences) (aobj)).getString("advertising_id", null));
        aobj = ((android.net.Uri.Builder) (obj)).build();
        if (aobj == null)
        {
            return Boolean.valueOf(false);
        }
        aobj = ak.a(((Uri) (aobj)));
        if (aobj == null)
        {
            return Boolean.valueOf(false);
        }
        obj = ((JSONObject) (aobj)).optString("category_sort_csv", null);
        boolean flag;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = false;
        } else
        {
            SharedPreferences sharedpreferences = p.a();
            if (sharedpreferences == null)
            {
                flag = false;
            } else
            {
                sharedpreferences.edit().putString("category_order", ((String) (obj))).commit();
                flag = true;
            }
        }
        if (!flag)
        {
            return Boolean.valueOf(false);
        }
        obj = ((JSONObject) (aobj)).optString("coupon_category_sort_csv", null);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = false;
        } else
        {
            SharedPreferences sharedpreferences1 = p.a();
            if (sharedpreferences1 == null)
            {
                flag = false;
            } else
            {
                sharedpreferences1.edit().putString("coupon_category_order", ((String) (obj))).commit();
                flag = true;
            }
        }
        if (!flag)
        {
            return Boolean.valueOf(false);
        } else
        {
            a(((JSONObject) (aobj)), a(((JSONObject) (aobj))), b(((JSONObject) (aobj))));
            return Boolean.valueOf(true);
        }
    }

    protected void onPostExecute(Object obj)
    {
        obj = (Boolean)obj;
        SharedPreferences sharedpreferences = p.a();
        if (sharedpreferences != null)
        {
            int j = g.b();
            sharedpreferences.edit().putLong("last_flyer_fetch_time", System.currentTimeMillis()).putString("last_flyer_fetch_locale", c).putInt("last_flyer_fetch_version_code", j).commit();
        }
        if (((Boolean) (obj)).booleanValue())
        {
            FeaturedFragment.b();
            FavoritesFragment.b();
        }
        a(((Boolean) (obj)));
    }

}
