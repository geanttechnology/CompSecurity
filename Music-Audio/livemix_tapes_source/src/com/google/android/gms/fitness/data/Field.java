// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzi

public final class Field
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzi();
    public static final Field FIELD_ACCURACY = zzcS("accuracy");
    public static final Field FIELD_ACTIVITY = zzcR("activity");
    public static final Field FIELD_ALTITUDE = zzcS("altitude");
    public static final Field FIELD_AVERAGE = zzcS("average");
    public static final Field FIELD_BPM = zzcS("bpm");
    public static final Field FIELD_CALORIES = zzcS("calories");
    public static final Field FIELD_CIRCUMFERENCE = zzcS("circumference");
    public static final Field FIELD_CONFIDENCE = zzcS("confidence");
    public static final Field FIELD_DISTANCE = zzcS("distance");
    public static final Field FIELD_DURATION = zzcR("duration");
    public static final Field FIELD_EXERCISE = zzcT("exercise");
    public static final Field FIELD_FOOD_ITEM = zzcT("food_item");
    public static final Field FIELD_HEIGHT = zzcS("height");
    public static final Field FIELD_HIGH_LATITUDE = zzcS("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzcS("high_longitude");
    public static final Field FIELD_LATITUDE = zzcS("latitude");
    public static final Field FIELD_LONGITUDE = zzcS("longitude");
    public static final Field FIELD_LOW_LATITUDE = zzcS("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzcS("low_longitude");
    public static final Field FIELD_MAX = zzcS("max");
    public static final Field FIELD_MEAL_TYPE = zzcR("meal_type");
    public static final Field FIELD_MIN = zzcS("min");
    public static final Field FIELD_NUM_SEGMENTS = zzcR("num_segments");
    public static final Field FIELD_NUTRIENTS = zzcU("nutrients");
    public static final Field FIELD_PERCENTAGE = zzcS("percentage");
    public static final Field FIELD_REPETITIONS = zzcR("repetitions");
    public static final Field FIELD_RESISTANCE = zzcS("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzcR("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzcR("revolutions");
    public static final Field FIELD_RPM = zzcS("rpm");
    public static final Field FIELD_SPEED = zzcS("speed");
    public static final Field FIELD_STEPS = zzcR("steps");
    public static final Field FIELD_WATTS = zzcS("watts");
    public static final Field FIELD_WEIGHT = zzcS("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzaoc = zzcU("activity_confidence");
    public static final Field zzaod = zzcU("activity_duration");
    public static final Field zzaoe = zzcU("activity_duration.ascending");
    public static final Field zzaof = zzcU("activity_duration.descending");
    public static final Field zzaog = zzcS("elevation.change");
    public static final Field zzaoh = zzcU("elevation.gain");
    public static final Field zzaoi = zzcU("elevation.loss");
    public static final Field zzaoj = zzcS("floors");
    public static final Field zzaok = zzcU("floor.gain");
    public static final Field zzaol = zzcU("floor.loss");
    public static final Field zzaom = zzcR("edge_type");
    public static final Field zzaon = zzcS("x");
    public static final Field zzaoo = zzcS("y");
    public static final Field zzaop = zzcS("z");
    private final String mName;
    private final int mVersionCode;
    private final int zzaoq;

    Field(int i, String s, int j)
    {
        mVersionCode = i;
        mName = (String)zzx.zzv(s);
        zzaoq = j;
    }

    private Field(String s, int i)
    {
        this(1, s, i);
    }

    private boolean zza(Field field)
    {
        return mName.equals(field.mName) && zzaoq == field.zzaoq;
    }

    private static Field zzcR(String s)
    {
        return new Field(s, 1);
    }

    private static Field zzcS(String s)
    {
        return new Field(s, 2);
    }

    private static Field zzcT(String s)
    {
        return new Field(s, 3);
    }

    private static Field zzcU(String s)
    {
        return new Field(s, 4);
    }

    public static Field zzo(String s, int i)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 47: default 392
    //                   -2131707655: 606
    //                   -1992012396: 781
    //                   -1655966961: 620
    //                   -1579612127: 876
    //                   -1579449403: 892
    //                   -1569430471: 1095
    //                   -1531570079: 812
    //                   -1439978388: 986
    //                   -1271636505: 908
    //                   -1221029593: 939
    //                   -1133736764: 634
    //                   -1110756780: 924
    //                   -921832806: 1126
    //                   -791592328: 1264
    //                   -631448035: 690
    //                   -626344110: 970
    //                   -619868540: 1032
    //                   -494782871: 954
    //                   -437053898: 1064
    //                   -277306353: 736
    //                   -266093204: 1111
    //                   -168965370: 721
    //                   -126538880: 1173
    //                   120: 1279
    //                   121: 1295
    //                   122: 1311
    //                   97759: 706
    //                   107876: 1048
    //                   108114: 1079
    //                   113135: 1204
    //                   109641799: 1219
    //                   109761319: 1234
    //                   112903913: 1249
    //                   137365935: 1001
    //                   198162679: 1016
    //                   224520316: 796
    //                   286612066: 662
    //                   288459765: 766
    //                   455965230: 648
    //                   811264586: 1189
    //                   829251210: 751
    //                   984367650: 1141
    //                   1857734768: 828
    //                   1857897492: 844
    //                   1863800889: 1157
    //                   2036550306: 676
    //                   2056323544: 860;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48
_L1:
        break; /* Loop/switch isn't completed */
_L27:
        break MISSING_BLOCK_LABEL_1311;
_L49:
        switch (byte0)
        {
        default:
            return new Field(s, i);

        case 0: // '\0'
            return FIELD_ACCURACY;

        case 1: // '\001'
            return FIELD_ACTIVITY;

        case 2: // '\002'
            return zzaod;

        case 3: // '\003'
            return zzaoe;

        case 4: // '\004'
            return zzaof;

        case 5: // '\005'
            return FIELD_ALTITUDE;

        case 6: // '\006'
            return FIELD_AVERAGE;

        case 7: // '\007'
            return FIELD_BPM;

        case 8: // '\b'
            return FIELD_CALORIES;

        case 9: // '\t'
            return FIELD_CIRCUMFERENCE;

        case 10: // '\n'
            return FIELD_CONFIDENCE;

        case 11: // '\013'
            return FIELD_DISTANCE;

        case 12: // '\f'
            return FIELD_DURATION;

        case 13: // '\r'
            return zzaom;

        case 14: // '\016'
            return zzaog;

        case 15: // '\017'
            return zzaoh;

        case 16: // '\020'
            return zzaoi;

        case 17: // '\021'
            return FIELD_EXERCISE;

        case 18: // '\022'
            return zzaok;

        case 19: // '\023'
            return zzaol;

        case 20: // '\024'
            return zzaoj;

        case 21: // '\025'
            return FIELD_FOOD_ITEM;

        case 22: // '\026'
            return FIELD_HEIGHT;

        case 23: // '\027'
            return FIELD_HIGH_LATITUDE;

        case 24: // '\030'
            return FIELD_HIGH_LONGITUDE;

        case 25: // '\031'
            return FIELD_LATITUDE;

        case 26: // '\032'
            return FIELD_LONGITUDE;

        case 27: // '\033'
            return FIELD_LOW_LATITUDE;

        case 28: // '\034'
            return FIELD_LOW_LONGITUDE;

        case 29: // '\035'
            return FIELD_MAX;

        case 30: // '\036'
            return FIELD_MEAL_TYPE;

        case 31: // '\037'
            return FIELD_MIN;

        case 32: // ' '
            return FIELD_NUM_SEGMENTS;

        case 33: // '!'
            return FIELD_NUTRIENTS;

        case 34: // '"'
            return FIELD_PERCENTAGE;

        case 35: // '#'
            return FIELD_REPETITIONS;

        case 36: // '$'
            return FIELD_RESISTANCE;

        case 37: // '%'
            return FIELD_RESISTANCE_TYPE;

        case 38: // '&'
            return FIELD_REVOLUTIONS;

        case 39: // '\''
            return FIELD_RPM;

        case 40: // '('
            return FIELD_SPEED;

        case 41: // ')'
            return FIELD_STEPS;

        case 42: // '*'
            return FIELD_WATTS;

        case 43: // '+'
            return FIELD_WEIGHT;

        case 44: // ','
            return zzaon;

        case 45: // '-'
            return zzaoo;

        case 46: // '.'
            return zzaop;
        }
_L2:
        if (s.equals("accuracy"))
        {
            byte0 = 0;
        }
          goto _L49
_L4:
        if (s.equals("activity"))
        {
            byte0 = 1;
        }
          goto _L49
_L12:
        if (s.equals("activity_duration"))
        {
            byte0 = 2;
        }
          goto _L49
_L40:
        if (s.equals("activity_duration.ascending"))
        {
            byte0 = 3;
        }
          goto _L49
_L38:
        if (s.equals("activity_duration.descending"))
        {
            byte0 = 4;
        }
          goto _L49
_L47:
        if (s.equals("altitude"))
        {
            byte0 = 5;
        }
          goto _L49
_L16:
        if (s.equals("average"))
        {
            byte0 = 6;
        }
          goto _L49
_L28:
        if (s.equals("bpm"))
        {
            byte0 = 7;
        }
          goto _L49
_L23:
        if (s.equals("calories"))
        {
            byte0 = 8;
        }
          goto _L49
_L21:
        if (s.equals("circumference"))
        {
            byte0 = 9;
        }
          goto _L49
_L42:
        if (s.equals("confidence"))
        {
            byte0 = 10;
        }
          goto _L49
_L39:
        if (s.equals("distance"))
        {
            byte0 = 11;
        }
          goto _L49
_L3:
        if (s.equals("duration"))
        {
            byte0 = 12;
        }
          goto _L49
_L37:
        if (s.equals("edge_type"))
        {
            byte0 = 13;
        }
          goto _L49
_L8:
        if (s.equals("elevation.change"))
        {
            byte0 = 14;
        }
          goto _L49
_L44:
        if (s.equals("elevation.gain"))
        {
            byte0 = 15;
        }
          goto _L49
_L45:
        if (s.equals("elevation.loss"))
        {
            byte0 = 16;
        }
          goto _L49
_L48:
        if (s.equals("exercise"))
        {
            byte0 = 17;
        }
          goto _L49
_L5:
        if (s.equals("floor.gain"))
        {
            byte0 = 18;
        }
          goto _L49
_L6:
        if (s.equals("floor.loss"))
        {
            byte0 = 19;
        }
          goto _L49
_L10:
        if (s.equals("floors"))
        {
            byte0 = 20;
        }
          goto _L49
_L13:
        if (s.equals("food_item"))
        {
            byte0 = 21;
        }
          goto _L49
_L11:
        if (s.equals("height"))
        {
            byte0 = 22;
        }
          goto _L49
_L19:
        if (s.equals("high_latitude"))
        {
            byte0 = 23;
        }
          goto _L49
_L17:
        if (s.equals("high_longitude"))
        {
            byte0 = 24;
        }
          goto _L49
_L9:
        if (s.equals("latitude"))
        {
            byte0 = 25;
        }
          goto _L49
_L35:
        if (s.equals("longitude"))
        {
            byte0 = 26;
        }
          goto _L49
_L36:
        if (s.equals("low_latitude"))
        {
            byte0 = 27;
        }
          goto _L49
_L18:
        if (s.equals("low_longitude"))
        {
            byte0 = 28;
        }
          goto _L49
_L29:
        if (s.equals("max"))
        {
            byte0 = 29;
        }
          goto _L49
_L20:
        if (s.equals("meal_type"))
        {
            byte0 = 30;
        }
          goto _L49
_L30:
        if (s.equals("min"))
        {
            byte0 = 31;
        }
          goto _L49
_L7:
        if (s.equals("num_segments"))
        {
            byte0 = 32;
        }
          goto _L49
_L22:
        if (s.equals("nutrients"))
        {
            byte0 = 33;
        }
          goto _L49
_L14:
        if (s.equals("percentage"))
        {
            byte0 = 34;
        }
          goto _L49
_L43:
        if (s.equals("repetitions"))
        {
            byte0 = 35;
        }
          goto _L49
_L46:
        if (s.equals("resistance"))
        {
            byte0 = 36;
        }
          goto _L49
_L24:
        if (s.equals("resistance_type"))
        {
            byte0 = 37;
        }
          goto _L49
_L41:
        if (s.equals("revolutions"))
        {
            byte0 = 38;
        }
          goto _L49
_L31:
        if (s.equals("rpm"))
        {
            byte0 = 39;
        }
          goto _L49
_L32:
        if (s.equals("speed"))
        {
            byte0 = 40;
        }
          goto _L49
_L33:
        if (s.equals("steps"))
        {
            byte0 = 41;
        }
          goto _L49
_L34:
        if (s.equals("watts"))
        {
            byte0 = 42;
        }
          goto _L49
_L15:
        if (s.equals("weight"))
        {
            byte0 = 43;
        }
          goto _L49
_L25:
        if (s.equals("x"))
        {
            byte0 = 44;
        }
          goto _L49
_L26:
        if (s.equals("y"))
        {
            byte0 = 45;
        }
          goto _L49
        if (s.equals("z"))
        {
            byte0 = 46;
        }
          goto _L49
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof Field) && zza((Field)obj);
    }

    public int getFormat()
    {
        return zzaoq;
    }

    public String getName()
    {
        return mName;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return mName.hashCode();
    }

    public String toString()
    {
        String s1 = mName;
        String s;
        if (zzaoq == 1)
        {
            s = "i";
        } else
        {
            s = "f";
        }
        return String.format("%s(%s)", new Object[] {
            s1, s
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi.zza(this, parcel, i);
    }

}
