// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import ady;
import afr;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class oa
    implements SafeParcelable
{

    public static final oa A = a("courthouse");
    public static final oa B = a("dentist");
    public static final oa C = a("department_store");
    public static final afr CREATOR = new afr();
    public static final oa D = a("doctor");
    public static final oa E = a("electrician");
    public static final oa F = a("electronics_store");
    public static final oa G = a("embassy");
    public static final oa H = a("establishment");
    public static final oa I = a("finance");
    public static final oa J = a("fire_station");
    public static final oa K = a("florist");
    public static final oa L = a("food");
    public static final oa M = a("funeral_home");
    public static final oa N = a("furniture_store");
    public static final oa O = a("gas_station");
    public static final oa P = a("general_contractor");
    public static final oa Q = a("grocery_or_supermarket");
    public static final oa R = a("gym");
    public static final oa S = a("hair_care");
    public static final oa T = a("hardware_store");
    public static final oa U = a("health");
    public static final oa V = a("hindu_temple");
    public static final oa W = a("home_goods_store");
    public static final oa X = a("hospital");
    public static final oa Y = a("insurance_agency");
    public static final oa Z = a("jewelry_store");
    public static final oa a = a("accounting");
    public static final oa aA = a("restaurant");
    public static final oa aB = a("roofing_contractor");
    public static final oa aC = a("rv_park");
    public static final oa aD = a("school");
    public static final oa aE = a("shoe_store");
    public static final oa aF = a("shopping_mall");
    public static final oa aG = a("spa");
    public static final oa aH = a("stadium");
    public static final oa aI = a("storage");
    public static final oa aJ = a("store");
    public static final oa aK = a("subway_station");
    public static final oa aL = a("synagogue");
    public static final oa aM = a("taxi_stand");
    public static final oa aN = a("train_station");
    public static final oa aO = a("travel_agency");
    public static final oa aP = a("university");
    public static final oa aQ = a("veterinary_care");
    public static final oa aR = a("zoo");
    public static final oa aS = a("administrative_area_level_1");
    public static final oa aT = a("administrative_area_level_2");
    public static final oa aU = a("administrative_area_level_3");
    public static final oa aV = a("colloquial_area");
    public static final oa aW = a("country");
    public static final oa aX = a("floor");
    public static final oa aY = a("geocode");
    public static final oa aZ = a("intersection");
    public static final oa aa = a("laundry");
    public static final oa ab = a("lawyer");
    public static final oa ac = a("library");
    public static final oa ad = a("liquor_store");
    public static final oa ae = a("local_government_office");
    public static final oa af = a("locksmith");
    public static final oa ag = a("lodging");
    public static final oa ah = a("meal_delivery");
    public static final oa ai = a("meal_takeaway");
    public static final oa aj = a("mosque");
    public static final oa ak = a("movie_rental");
    public static final oa al = a("movie_theater");
    public static final oa am = a("moving_company");
    public static final oa an = a("museum");
    public static final oa ao = a("night_club");
    public static final oa ap = a("painter");
    public static final oa aq = a("park");
    public static final oa ar = a("parking");
    public static final oa as = a("pet_store");
    public static final oa at = a("pharmacy");
    public static final oa au = a("physiotherapist");
    public static final oa av = a("place_of_worship");
    public static final oa aw = a("plumber");
    public static final oa ax = a("police");
    public static final oa ay = a("post_office");
    public static final oa az = a("real_estate_agency");
    public static final oa b = a("airport");
    public static final oa ba = a("locality");
    public static final oa bb = a("natural_feature");
    public static final oa bc = a("neighborhood");
    public static final oa bd = a("political");
    public static final oa be = a("point_of_interest");
    public static final oa bf = a("post_box");
    public static final oa bg = a("postal_code");
    public static final oa bh = a("postal_code_prefix");
    public static final oa bi = a("postal_town");
    public static final oa bj = a("premise");
    public static final oa bk = a("room");
    public static final oa bl = a("route");
    public static final oa bm = a("street_address");
    public static final oa bn = a("sublocality");
    public static final oa bo = a("sublocality_level_1");
    public static final oa bp = a("sublocality_level_2");
    public static final oa bq = a("sublocality_level_3");
    public static final oa br = a("sublocality_level_4");
    public static final oa bs = a("sublocality_level_5");
    public static final oa bt = a("subpremise");
    public static final oa bu = a("transit_station");
    public static final oa bv = a("other");
    public static final oa c = a("amusement_park");
    public static final oa d = a("aquarium");
    public static final oa e = a("art_gallery");
    public static final oa f = a("atm");
    public static final oa g = a("bakery");
    public static final oa h = a("bank");
    public static final oa i = a("bar");
    public static final oa j = a("beauty_salon");
    public static final oa k = a("bicycle_store");
    public static final oa l = a("book_store");
    public static final oa m = a("bowling_alley");
    public static final oa n = a("bus_station");
    public static final oa o = a("cafe");
    public static final oa p = a("campground");
    public static final oa q = a("car_dealer");
    public static final oa r = a("car_rental");
    public static final oa s = a("car_repair");
    public static final oa t = a("car_wash");
    public static final oa u = a("casino");
    public static final oa v = a("cemetery");
    public static final oa w = a("church");
    public static final oa x = a("city_hall");
    public static final oa y = a("clothing_store");
    public static final oa z = a("convenience_store");
    public final int bw;
    public final String bx;

    public oa(int i1, String s1)
    {
        ady.a(s1);
        bw = i1;
        bx = s1;
    }

    public static oa a(String s1)
    {
        return new oa(0, s1);
    }

    public int describeContents()
    {
        afr afr1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof oa) && bx.equals(((oa)obj).bx);
    }

    public int hashCode()
    {
        return bx.hashCode();
    }

    public String toString()
    {
        return bx;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        afr afr1 = CREATOR;
        afr.a(this, parcel, i1);
    }

}
