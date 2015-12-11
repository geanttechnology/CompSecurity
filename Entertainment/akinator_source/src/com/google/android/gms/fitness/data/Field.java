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
    public static final Field FIELD_ACCURACY = zzcR("accuracy");
    public static final Field FIELD_ACTIVITY = zzcQ("activity");
    public static final Field FIELD_ALTITUDE = zzcR("altitude");
    public static final Field FIELD_AVERAGE = zzcR("average");
    public static final Field FIELD_BPM = zzcR("bpm");
    public static final Field FIELD_CALORIES = zzcR("calories");
    public static final Field FIELD_CIRCUMFERENCE = zzcR("circumference");
    public static final Field FIELD_CONFIDENCE = zzcR("confidence");
    public static final Field FIELD_DISTANCE = zzcR("distance");
    public static final Field FIELD_DURATION = zzcQ("duration");
    public static final Field FIELD_EXERCISE = zzcS("exercise");
    public static final Field FIELD_FOOD_ITEM = zzcS("food_item");
    public static final Field FIELD_HEIGHT = zzcR("height");
    public static final Field FIELD_HIGH_LATITUDE = zzcR("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzcR("high_longitude");
    public static final Field FIELD_LATITUDE = zzcR("latitude");
    public static final Field FIELD_LONGITUDE = zzcR("longitude");
    public static final Field FIELD_LOW_LATITUDE = zzcR("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzcR("low_longitude");
    public static final Field FIELD_MAX = zzcR("max");
    public static final Field FIELD_MEAL_TYPE = zzcQ("meal_type");
    public static final Field FIELD_MIN = zzcR("min");
    public static final Field FIELD_NUM_SEGMENTS = zzcQ("num_segments");
    public static final Field FIELD_NUTRIENTS = zzcT("nutrients");
    public static final Field FIELD_PERCENTAGE = zzcR("percentage");
    public static final Field FIELD_REPETITIONS = zzcQ("repetitions");
    public static final Field FIELD_RESISTANCE = zzcR("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzcQ("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzcQ("revolutions");
    public static final Field FIELD_RPM = zzcR("rpm");
    public static final Field FIELD_SPEED = zzcR("speed");
    public static final Field FIELD_STEPS = zzcQ("steps");
    public static final Field FIELD_WATTS = zzcR("watts");
    public static final Field FIELD_WEIGHT = zzcR("weight");
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
    public static final Field zzaqB = zzcT("activity_confidence");
    public static final Field zzaqC = zzcT("activity_duration");
    public static final Field zzaqD = zzcT("activity_duration.ascending");
    public static final Field zzaqE = zzcT("activity_duration.descending");
    public static final Field zzaqF = zzcR("elevation.change");
    public static final Field zzaqG = zzcT("elevation.gain");
    public static final Field zzaqH = zzcT("elevation.loss");
    public static final Field zzaqI = zzcR("floors");
    public static final Field zzaqJ = zzcT("floor.gain");
    public static final Field zzaqK = zzcT("floor.loss");
    public static final Field zzaqL = zzcR("x");
    public static final Field zzaqM = zzcR("y");
    public static final Field zzaqN = zzcR("z");
    private final String mName;
    private final int mVersionCode;
    private final int zzaqO;

    Field(int i, String s, int j)
    {
        mVersionCode = i;
        mName = (String)zzx.zzw(s);
        zzaqO = j;
    }

    private Field(String s, int i)
    {
        this(1, s, i);
    }

    private boolean zza(Field field)
    {
        return mName.equals(field.mName) && zzaqO == field.zzaqO;
    }

    private static Field zzcQ(String s)
    {
        return new Field(s, 1);
    }

    private static Field zzcR(String s)
    {
        return new Field(s, 2);
    }

    private static Field zzcS(String s)
    {
        return new Field(s, 3);
    }

    private static Field zzcT(String s)
    {
        return new Field(s, 4);
    }

    public static Field zzo(String s, int i)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 46: default 384
    //                   -2131707655: 594
    //                   -1992012396: 769
    //                   -1655966961: 608
    //                   -1579612127: 848
    //                   -1579449403: 864
    //                   -1569430471: 1067
    //                   -1531570079: 784
    //                   -1439978388: 958
    //                   -1271636505: 880
    //                   -1221029593: 911
    //                   -1133736764: 622
    //                   -1110756780: 896
    //                   -921832806: 1098
    //                   -791592328: 1236
    //                   -631448035: 678
    //                   -626344110: 942
    //                   -619868540: 1004
    //                   -494782871: 926
    //                   -437053898: 1036
    //                   -277306353: 724
    //                   -266093204: 1083
    //                   -168965370: 709
    //                   -126538880: 1145
    //                   120: 1251
    //                   121: 1267
    //                   122: 1283
    //                   97759: 694
    //                   107876: 1020
    //                   108114: 1051
    //                   113135: 1176
    //                   109641799: 1191
    //                   109761319: 1206
    //                   112903913: 1221
    //                   137365935: 973
    //                   198162679: 988
    //                   286612066: 650
    //                   288459765: 754
    //                   455965230: 636
    //                   811264586: 1161
    //                   829251210: 739
    //                   984367650: 1113
    //                   1857734768: 800
    //                   1857897492: 816
    //                   1863800889: 1129
    //                   2036550306: 664
    //                   2056323544: 832;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47
_L1:
        break; /* Loop/switch isn't completed */
_L27:
        break MISSING_BLOCK_LABEL_1283;
_L48:
        switch (byte0)
        {
        default:
            return new Field(s, i);

        case 0: // '\0'
            return FIELD_ACCURACY;

        case 1: // '\001'
            return FIELD_ACTIVITY;

        case 2: // '\002'
            return zzaqC;

        case 3: // '\003'
            return zzaqD;

        case 4: // '\004'
            return zzaqE;

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
            return zzaqF;

        case 14: // '\016'
            return zzaqG;

        case 15: // '\017'
            return zzaqH;

        case 16: // '\020'
            return FIELD_EXERCISE;

        case 17: // '\021'
            return zzaqJ;

        case 18: // '\022'
            return zzaqK;

        case 19: // '\023'
            return zzaqI;

        case 20: // '\024'
            return FIELD_FOOD_ITEM;

        case 21: // '\025'
            return FIELD_HEIGHT;

        case 22: // '\026'
            return FIELD_HIGH_LATITUDE;

        case 23: // '\027'
            return FIELD_HIGH_LONGITUDE;

        case 24: // '\030'
            return FIELD_LATITUDE;

        case 25: // '\031'
            return FIELD_LONGITUDE;

        case 26: // '\032'
            return FIELD_LOW_LATITUDE;

        case 27: // '\033'
            return FIELD_LOW_LONGITUDE;

        case 28: // '\034'
            return FIELD_MAX;

        case 29: // '\035'
            return FIELD_MEAL_TYPE;

        case 30: // '\036'
            return FIELD_MIN;

        case 31: // '\037'
            return FIELD_NUM_SEGMENTS;

        case 32: // ' '
            return FIELD_NUTRIENTS;

        case 33: // '!'
            return FIELD_PERCENTAGE;

        case 34: // '"'
            return FIELD_REPETITIONS;

        case 35: // '#'
            return FIELD_RESISTANCE;

        case 36: // '$'
            return FIELD_RESISTANCE_TYPE;

        case 37: // '%'
            return FIELD_REVOLUTIONS;

        case 38: // '&'
            return FIELD_RPM;

        case 39: // '\''
            return FIELD_SPEED;

        case 40: // '('
            return FIELD_STEPS;

        case 41: // ')'
            return FIELD_WATTS;

        case 42: // '*'
            return FIELD_WEIGHT;

        case 43: // '+'
            return zzaqL;

        case 44: // ','
            return zzaqM;

        case 45: // '-'
            return zzaqN;
        }
_L2:
        if (s.equals("accuracy"))
        {
            byte0 = 0;
        }
          goto _L48
_L4:
        if (s.equals("activity"))
        {
            byte0 = 1;
        }
          goto _L48
_L12:
        if (s.equals("activity_duration"))
        {
            byte0 = 2;
        }
          goto _L48
_L39:
        if (s.equals("activity_duration.ascending"))
        {
            byte0 = 3;
        }
          goto _L48
_L37:
        if (s.equals("activity_duration.descending"))
        {
            byte0 = 4;
        }
          goto _L48
_L46:
        if (s.equals("altitude"))
        {
            byte0 = 5;
        }
          goto _L48
_L16:
        if (s.equals("average"))
        {
            byte0 = 6;
        }
          goto _L48
_L28:
        if (s.equals("bpm"))
        {
            byte0 = 7;
        }
          goto _L48
_L23:
        if (s.equals("calories"))
        {
            byte0 = 8;
        }
          goto _L48
_L21:
        if (s.equals("circumference"))
        {
            byte0 = 9;
        }
          goto _L48
_L41:
        if (s.equals("confidence"))
        {
            byte0 = 10;
        }
          goto _L48
_L38:
        if (s.equals("distance"))
        {
            byte0 = 11;
        }
          goto _L48
_L3:
        if (s.equals("duration"))
        {
            byte0 = 12;
        }
          goto _L48
_L8:
        if (s.equals("elevation.change"))
        {
            byte0 = 13;
        }
          goto _L48
_L43:
        if (s.equals("elevation.gain"))
        {
            byte0 = 14;
        }
          goto _L48
_L44:
        if (s.equals("elevation.loss"))
        {
            byte0 = 15;
        }
          goto _L48
_L47:
        if (s.equals("exercise"))
        {
            byte0 = 16;
        }
          goto _L48
_L5:
        if (s.equals("floor.gain"))
        {
            byte0 = 17;
        }
          goto _L48
_L6:
        if (s.equals("floor.loss"))
        {
            byte0 = 18;
        }
          goto _L48
_L10:
        if (s.equals("floors"))
        {
            byte0 = 19;
        }
          goto _L48
_L13:
        if (s.equals("food_item"))
        {
            byte0 = 20;
        }
          goto _L48
_L11:
        if (s.equals("height"))
        {
            byte0 = 21;
        }
          goto _L48
_L19:
        if (s.equals("high_latitude"))
        {
            byte0 = 22;
        }
          goto _L48
_L17:
        if (s.equals("high_longitude"))
        {
            byte0 = 23;
        }
          goto _L48
_L9:
        if (s.equals("latitude"))
        {
            byte0 = 24;
        }
          goto _L48
_L35:
        if (s.equals("longitude"))
        {
            byte0 = 25;
        }
          goto _L48
_L36:
        if (s.equals("low_latitude"))
        {
            byte0 = 26;
        }
          goto _L48
_L18:
        if (s.equals("low_longitude"))
        {
            byte0 = 27;
        }
          goto _L48
_L29:
        if (s.equals("max"))
        {
            byte0 = 28;
        }
          goto _L48
_L20:
        if (s.equals("meal_type"))
        {
            byte0 = 29;
        }
          goto _L48
_L30:
        if (s.equals("min"))
        {
            byte0 = 30;
        }
          goto _L48
_L7:
        if (s.equals("num_segments"))
        {
            byte0 = 31;
        }
          goto _L48
_L22:
        if (s.equals("nutrients"))
        {
            byte0 = 32;
        }
          goto _L48
_L14:
        if (s.equals("percentage"))
        {
            byte0 = 33;
        }
          goto _L48
_L42:
        if (s.equals("repetitions"))
        {
            byte0 = 34;
        }
          goto _L48
_L45:
        if (s.equals("resistance"))
        {
            byte0 = 35;
        }
          goto _L48
_L24:
        if (s.equals("resistance_type"))
        {
            byte0 = 36;
        }
          goto _L48
_L40:
        if (s.equals("revolutions"))
        {
            byte0 = 37;
        }
          goto _L48
_L31:
        if (s.equals("rpm"))
        {
            byte0 = 38;
        }
          goto _L48
_L32:
        if (s.equals("speed"))
        {
            byte0 = 39;
        }
          goto _L48
_L33:
        if (s.equals("steps"))
        {
            byte0 = 40;
        }
          goto _L48
_L34:
        if (s.equals("watts"))
        {
            byte0 = 41;
        }
          goto _L48
_L15:
        if (s.equals("weight"))
        {
            byte0 = 42;
        }
          goto _L48
_L25:
        if (s.equals("x"))
        {
            byte0 = 43;
        }
          goto _L48
_L26:
        if (s.equals("y"))
        {
            byte0 = 44;
        }
          goto _L48
        if (s.equals("z"))
        {
            byte0 = 45;
        }
          goto _L48
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
        return zzaqO;
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
        if (zzaqO == 1)
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
