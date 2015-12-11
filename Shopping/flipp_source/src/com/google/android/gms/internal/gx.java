// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            jc

public final class gx
    implements SafeParcelable
{

    public static final gx A = a("courthouse");
    public static final gx B = a("dentist");
    public static final gx C = a("department_store");
    public static final jc CREATOR = new jc();
    public static final gx D = a("doctor");
    public static final gx E = a("electrician");
    public static final gx F = a("electronics_store");
    public static final gx G = a("embassy");
    public static final gx H = a("establishment");
    public static final gx I = a("finance");
    public static final gx J = a("fire_station");
    public static final gx K = a("florist");
    public static final gx L = a("food");
    public static final gx M = a("funeral_home");
    public static final gx N = a("furniture_store");
    public static final gx O = a("gas_station");
    public static final gx P = a("general_contractor");
    public static final gx Q = a("grocery_or_supermarket");
    public static final gx R = a("gym");
    public static final gx S = a("hair_care");
    public static final gx T = a("hardware_store");
    public static final gx U = a("health");
    public static final gx V = a("hindu_temple");
    public static final gx W = a("home_goods_store");
    public static final gx X = a("hospital");
    public static final gx Y = a("insurance_agency");
    public static final gx Z = a("jewelry_store");
    public static final gx a = a("accounting");
    public static final gx aA = a("restaurant");
    public static final gx aB = a("roofing_contractor");
    public static final gx aC = a("rv_park");
    public static final gx aD = a("school");
    public static final gx aE = a("shoe_store");
    public static final gx aF = a("shopping_mall");
    public static final gx aG = a("spa");
    public static final gx aH = a("stadium");
    public static final gx aI = a("storage");
    public static final gx aJ = a("store");
    public static final gx aK = a("subway_station");
    public static final gx aL = a("synagogue");
    public static final gx aM = a("taxi_stand");
    public static final gx aN = a("train_station");
    public static final gx aO = a("travel_agency");
    public static final gx aP = a("university");
    public static final gx aQ = a("veterinary_care");
    public static final gx aR = a("zoo");
    public static final gx aS = a("administrative_area_level_1");
    public static final gx aT = a("administrative_area_level_2");
    public static final gx aU = a("administrative_area_level_3");
    public static final gx aV = a("colloquial_area");
    public static final gx aW = a("country");
    public static final gx aX = a("floor");
    public static final gx aY = a("geocode");
    public static final gx aZ = a("intersection");
    public static final gx aa = a("laundry");
    public static final gx ab = a("lawyer");
    public static final gx ac = a("library");
    public static final gx ad = a("liquor_store");
    public static final gx ae = a("local_government_office");
    public static final gx af = a("locksmith");
    public static final gx ag = a("lodging");
    public static final gx ah = a("meal_delivery");
    public static final gx ai = a("meal_takeaway");
    public static final gx aj = a("mosque");
    public static final gx ak = a("movie_rental");
    public static final gx al = a("movie_theater");
    public static final gx am = a("moving_company");
    public static final gx an = a("museum");
    public static final gx ao = a("night_club");
    public static final gx ap = a("painter");
    public static final gx aq = a("park");
    public static final gx ar = a("parking");
    public static final gx as = a("pet_store");
    public static final gx at = a("pharmacy");
    public static final gx au = a("physiotherapist");
    public static final gx av = a("place_of_worship");
    public static final gx aw = a("plumber");
    public static final gx ax = a("police");
    public static final gx ay = a("post_office");
    public static final gx az = a("real_estate_agency");
    public static final gx b = a("airport");
    public static final gx ba = a("locality");
    public static final gx bb = a("natural_feature");
    public static final gx bc = a("neighborhood");
    public static final gx bd = a("political");
    public static final gx be = a("point_of_interest");
    public static final gx bf = a("post_box");
    public static final gx bg = a("postal_code");
    public static final gx bh = a("postal_code_prefix");
    public static final gx bi = a("postal_town");
    public static final gx bj = a("premise");
    public static final gx bk = a("room");
    public static final gx bl = a("route");
    public static final gx bm = a("street_address");
    public static final gx bn = a("sublocality");
    public static final gx bo = a("sublocality_level_1");
    public static final gx bp = a("sublocality_level_2");
    public static final gx bq = a("sublocality_level_3");
    public static final gx br = a("sublocality_level_4");
    public static final gx bs = a("sublocality_level_5");
    public static final gx bt = a("subpremise");
    public static final gx bu = a("transit_station");
    public static final gx c = a("amusement_park");
    public static final gx d = a("aquarium");
    public static final gx e = a("art_gallery");
    public static final gx f = a("atm");
    public static final gx g = a("bakery");
    public static final gx h = a("bank");
    public static final gx i = a("bar");
    public static final gx j = a("beauty_salon");
    public static final gx k = a("bicycle_store");
    public static final gx l = a("book_store");
    public static final gx m = a("bowling_alley");
    public static final gx n = a("bus_station");
    public static final gx o = a("cafe");
    public static final gx p = a("campground");
    public static final gx q = a("car_dealer");
    public static final gx r = a("car_rental");
    public static final gx s = a("car_repair");
    public static final gx t = a("car_wash");
    public static final gx u = a("casino");
    public static final gx v = a("cemetary");
    public static final gx w = a("church");
    public static final gx x = a("city_hall");
    public static final gx y = a("clothing_store");
    public static final gx z = a("convenience_store");
    final int bv;
    final String bw;

    gx(int i1, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Given String is empty or null");
        } else
        {
            bv = i1;
            bw = s1;
            return;
        }
    }

    public static gx a(String s1)
    {
        return new gx(0, s1);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof gx) && bw.equals(((gx)obj).bw);
    }

    public final int hashCode()
    {
        return bw.hashCode();
    }

    public final String toString()
    {
        return bw;
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        jc.a(this, parcel);
    }

}
