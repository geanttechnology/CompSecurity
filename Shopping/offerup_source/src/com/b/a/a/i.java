// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.offerup.android.c.a;
import com.offerup.android.dto.Category;
import com.offerup.android.dto.ItemPost;
import com.offerup.android.dto.ItemPostPhoto;
import java.util.ArrayList;

public final class i
{

    private static i b;
    private SharedPreferences a;

    private i(Context context)
    {
        a = context.getSharedPreferences("POST_PREFS", 0);
    }

    public static i a(Context context)
    {
        com/b/a/a/i;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new i(context.getApplicationContext());
        }
        context = b;
        com/b/a/a/i;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public final ItemPost a()
    {
        ItemPost itempost = new ItemPost();
        if (a.contains("title"))
        {
            itempost.setTitle(a.getString("title", ""));
        }
        if (a.contains("description"))
        {
            itempost.setDescription(a.getString("description", ""));
        }
        ArrayList arraylist = new ArrayList(com.offerup.android.c.a.a());
        int j = 0;
        while (j < com.offerup.android.c.a.a()) 
        {
            String s = a.getString(String.format("photos::uri::%d", new Object[] {
                Integer.valueOf(j)
            }), null);
            String s1 = a.getString(String.format("photos::uuid::%d", new Object[] {
                Integer.valueOf(j)
            }), null);
            if (s1 != null)
            {
                arraylist.add(new ItemPostPhoto(s1, Uri.parse(s)));
            } else
            if (s != null)
            {
                arraylist.add(new ItemPostPhoto(Uri.parse(s)));
            } else
            {
                arraylist.add(new ItemPostPhoto());
            }
            j++;
        }
        itempost.setItemPostPhotos(arraylist);
        if (a.contains("zipcode"))
        {
            itempost.setZipcode(a.getString("zipcode", ""));
        }
        if (a.contains("condition"))
        {
            itempost.setCondition(Integer.valueOf(a.getInt("condition", 0)));
        }
        if (a.contains("categoryId") && a.contains("categoryName"))
        {
            Category category = new Category();
            category.setId(a.getInt("categoryId", 0x80000000));
            category.setName(a.getString("categoryName", ""));
            itempost.setCategory(category);
        }
        if (a.contains("listingType"))
        {
            itempost.setListingType(Integer.valueOf(a.getInt("listingType", 0)));
        }
        if (a.contains("listingState"))
        {
            itempost.setListingState(Integer.valueOf(a.getInt("listingState", 0)));
        }
        itempost.setShareToFacebook(Integer.valueOf(a.getInt("shareToFacebook", 0)));
        if (a.contains("price"))
        {
            itempost.setPrice(a.getString("price", "0"));
        }
        if (a.contains("longitude"))
        {
            itempost.setLongitude(Double.valueOf(Double.parseDouble(a.getString("longitude", "0"))));
        }
        if (a.contains("latitude"))
        {
            itempost.setLatitude(Double.valueOf(Double.parseDouble(a.getString("latitude", "0"))));
        }
        if (a.contains("location_name"))
        {
            itempost.setLocationName(a.getString("location_name", null));
        }
        return itempost;
    }

    public final void a(ItemPost itempost)
    {
        if (itempost != null)
        {
            android.content.SharedPreferences.Editor editor = a.edit();
            editor.clear();
            if (itempost.getTitle() != null)
            {
                editor.putString("title", itempost.getTitle());
            }
            if (itempost.getDescription() != null)
            {
                editor.putString("description", itempost.getDescription());
            }
            if (itempost.getItemPostPhotos() != null)
            {
                ArrayList arraylist = itempost.getItemPostPhotos();
                for (int j = 0; j < arraylist.size(); j++)
                {
                    ItemPostPhoto itempostphoto = (ItemPostPhoto)arraylist.get(j);
                    if (itempostphoto == null)
                    {
                        continue;
                    }
                    if (itempostphoto.getImageUri() != null)
                    {
                        editor.putString(String.format("photos::uri::%d", new Object[] {
                            Integer.valueOf(j)
                        }), itempostphoto.getImageUri().toString());
                    }
                    String s = itempostphoto.getUuid();
                    if (s != null)
                    {
                        editor.putString(String.format("photos::uuid::%d", new Object[] {
                            Integer.valueOf(j)
                        }), s);
                    }
                    editor.putBoolean(String.format("photos::upload::%d", new Object[] {
                        Integer.valueOf(j)
                    }), itempostphoto.requiresUpload());
                }

            }
            if (itempost.getZipcode() != null)
            {
                editor.putString("zipcode", itempost.getZipcode());
            }
            if (itempost.getCondition() != null)
            {
                editor.putInt("condition", itempost.getCondition().intValue());
            }
            if (itempost.getCategory() != null)
            {
                editor.putInt("categoryId", itempost.getCategory().getId());
                editor.putString("categoryName", itempost.getCategory().getName());
            }
            if (itempost.getListingType() != null)
            {
                editor.putInt("listingType", itempost.getListingType().intValue());
            }
            if (itempost.getListingState() != null)
            {
                editor.putInt("listingState", itempost.getListingState().intValue());
            }
            editor.putInt("shareToFacebook", itempost.getShareToFacebook().intValue());
            if (itempost.getPrice() != null)
            {
                editor.putString("price", String.valueOf(itempost.getPrice()));
            }
            if (itempost.getLongitude() != null)
            {
                editor.putString("longitude", String.valueOf(itempost.getLongitude()));
            }
            if (itempost.getLatitude() != null)
            {
                editor.putString("latitude", String.valueOf(itempost.getLatitude()));
            }
            if (itempost.getLocationName() != null)
            {
                editor.putString("location_name", itempost.getLocationName());
            }
            editor.commit();
        }
    }

    public final void b()
    {
        int j = a.getInt("shareToFacebook", 0);
        android.content.SharedPreferences.Editor editor = a.edit();
        editor.clear();
        editor.putInt("shareToFacebook", j);
        editor.commit();
    }

    public final void c()
    {
        a.edit().remove("shareToFacebook").commit();
    }
}
