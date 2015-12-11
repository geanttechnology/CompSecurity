// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{

    public FastJsonResponse()
    {
    }

    private void zza(StringBuilder stringbuilder, Field field, Object obj)
    {
        if (field.zzpB() == 11)
        {
            stringbuilder.append(((FastJsonResponse)field.zzpL().cast(obj)).toString());
            return;
        }
        if (field.zzpB() == 7)
        {
            stringbuilder.append("\"");
            stringbuilder.append(zzmu.zzcz((String)obj));
            stringbuilder.append("\"");
            return;
        } else
        {
            stringbuilder.append(obj);
            return;
        }
    }

    private void zza(StringBuilder stringbuilder, Field field, ArrayList arraylist)
    {
        stringbuilder.append("[");
        int i = 0;
        for (int j = arraylist.size(); i < j; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(",");
            }
            Object obj = arraylist.get(i);
            if (obj != null)
            {
                zza(stringbuilder, field, obj);
            }
        }

        stringbuilder.append("]");
    }

    public String toString()
    {
        Map map = zzpD();
        StringBuilder stringbuilder = new StringBuilder(100);
        Iterator iterator = map.keySet().iterator();
label0:
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                Field field = (Field)map.get(s);
                if (zza(field))
                {
                    Object obj = zza(field, zzb(field));
                    if (stringbuilder.length() == 0)
                    {
                        stringbuilder.append("{");
                    } else
                    {
                        stringbuilder.append(",");
                    }
                    stringbuilder.append("\"").append(s).append("\":");
                    if (obj == null)
                    {
                        stringbuilder.append("null");
                    } else
                    {
                        switch (field.zzpC())
                        {
                        default:
                            if (field.zzpH())
                            {
                                zza(stringbuilder, field, (ArrayList)obj);
                            } else
                            {
                                zza(stringbuilder, field, obj);
                            }
                            break;

                        case 8: // '\b'
                            stringbuilder.append("\"").append(zzmk.zzi((byte[])obj)).append("\"");
                            break;

                        case 9: // '\t'
                            stringbuilder.append("\"").append(zzmk.zzj((byte[])obj)).append("\"");
                            break;

                        case 10: // '\n'
                            zzmv.zza(stringbuilder, (HashMap)obj);
                            break;
                        }
                        continue label0;
                    }
                }
            } while (true);
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("}");
            } else
            {
                stringbuilder.append("{}");
            }
            return stringbuilder.toString();
        } while (true);
    }

    protected Object zza(Field field, Object obj)
    {
        Object obj1 = obj;
        if (Field.zzc(field) != null)
        {
            obj1 = field.convertBack(obj);
        }
        return obj1;
    }

    protected boolean zza(Field field)
    {
        if (field.zzpC() == 11)
        {
            if (field.zzpI())
            {
                return zzcv(field.zzpJ());
            } else
            {
                return zzcu(field.zzpJ());
            }
        } else
        {
            return zzct(field.zzpJ());
        }
    }

    protected Object zzb(Field field)
    {
        String s = field.zzpJ();
        if (field.zzpL() != null)
        {
            boolean flag;
            if (zzcs(field.zzpJ()) == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Concrete field shouldn't be value object: %s", new Object[] {
                field.zzpJ()
            });
            if (field.zzpI())
            {
                field = zzpF();
            } else
            {
                field = zzpE();
            }
            if (field != null)
            {
                return field.get(s);
            }
            try
            {
                field = (new StringBuilder("get")).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
                field = ((Field) (getClass().getMethod(field, new Class[0]).invoke(this, new Object[0])));
            }
            // Misplaced declaration of an exception variable
            catch (Field field)
            {
                throw new RuntimeException(field);
            }
            return field;
        } else
        {
            return zzcs(field.zzpJ());
        }
    }

    protected abstract Object zzcs(String s);

    protected abstract boolean zzct(String s);

    protected boolean zzcu(String s)
    {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzcv(String s)
    {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map zzpD();

    public HashMap zzpE()
    {
        return null;
    }

    public HashMap zzpF()
    {
        return null;
    }

    private class Field
        implements SafeParcelable
    {

        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();
        private final int mVersionCode;
        protected final int zzagU;
        protected final boolean zzagV;
        protected final int zzagW;
        protected final boolean zzagX;
        protected final String zzagY;
        protected final int zzagZ;
        protected final Class zzaha;
        protected final String zzahb;
        private FieldMappingDictionary zzahc;
        private zza zzahd;

        public static Field zza(String s, int i, zza zza1, boolean flag)
        {
            return new Field(zza1.zzpB(), flag, zza1.zzpC(), false, s, i, null, zza1);
        }

        public static Field zza(String s, int i, Class class1)
        {
            return new Field(11, false, 11, false, s, i, class1, null);
        }

        public static Field zzb(String s, int i, Class class1)
        {
            return new Field(11, true, 11, true, s, i, class1, null);
        }

        static zza zzc(Field field)
        {
            return field.zzahd;
        }

        public static Field zzj(String s, int i)
        {
            return new Field(0, false, 0, false, s, i, null, null);
        }

        public static Field zzk(String s, int i)
        {
            return new Field(4, false, 4, false, s, i, null, null);
        }

        public static Field zzl(String s, int i)
        {
            return new Field(6, false, 6, false, s, i, null, null);
        }

        public static Field zzm(String s, int i)
        {
            return new Field(7, false, 7, false, s, i, null, null);
        }

        public static Field zzn(String s, int i)
        {
            return new Field(7, true, 7, true, s, i, null, null);
        }

        public Object convertBack(Object obj)
        {
            return zzahd.convertBack(obj);
        }

        public int describeContents()
        {
            return 0;
        }

        public int getVersionCode()
        {
            return mVersionCode;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Field\n");
            stringbuilder.append("            versionCode=").append(mVersionCode).append('\n');
            stringbuilder.append("                 typeIn=").append(zzagU).append('\n');
            stringbuilder.append("            typeInArray=").append(zzagV).append('\n');
            stringbuilder.append("                typeOut=").append(zzagW).append('\n');
            stringbuilder.append("           typeOutArray=").append(zzagX).append('\n');
            stringbuilder.append("        outputFieldName=").append(zzagY).append('\n');
            stringbuilder.append("      safeParcelFieldId=").append(zzagZ).append('\n');
            stringbuilder.append("       concreteTypeName=").append(zzpM()).append('\n');
            if (zzpL() != null)
            {
                stringbuilder.append("     concreteType.class=").append(zzpL().getCanonicalName()).append('\n');
            }
            StringBuilder stringbuilder1 = stringbuilder.append("          converterName=");
            String s;
            if (zzahd == null)
            {
                s = "null";
            } else
            {
                s = zzahd.getClass().getCanonicalName();
            }
            stringbuilder1.append(s).append('\n');
            return stringbuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldmappingdictionary)
        {
            zzahc = fieldmappingdictionary;
        }

        public int zzpB()
        {
            return zzagU;
        }

        public int zzpC()
        {
            return zzagW;
        }

        public Field zzpG()
        {
            return new Field(mVersionCode, zzagU, zzagV, zzagW, zzagX, zzagY, zzagZ, zzahb, zzpO());
        }

        public boolean zzpH()
        {
            return zzagV;
        }

        public boolean zzpI()
        {
            return zzagX;
        }

        public String zzpJ()
        {
            return zzagY;
        }

        public int zzpK()
        {
            return zzagZ;
        }

        public Class zzpL()
        {
            return zzaha;
        }

        String zzpM()
        {
            if (zzahb == null)
            {
                return null;
            } else
            {
                return zzahb;
            }
        }

        public boolean zzpN()
        {
            return zzahd != null;
        }

        ConverterWrapper zzpO()
        {
            if (zzahd == null)
            {
                return null;
            } else
            {
                return ConverterWrapper.zza(zzahd);
            }
        }

        public Map zzpP()
        {
            zzx.zzw(zzahb);
            zzx.zzw(zzahc);
            return zzahc.zzcw(zzahb);
        }


        Field(int i, int j, boolean flag, int k, boolean flag1, String s, int l, 
                String s1, ConverterWrapper converterwrapper)
        {
            mVersionCode = i;
            zzagU = j;
            zzagV = flag;
            zzagW = k;
            zzagX = flag1;
            zzagY = s;
            zzagZ = l;
            if (s1 == null)
            {
                zzaha = null;
                zzahb = null;
            } else
            {
                zzaha = com/google/android/gms/common/server/response/SafeParcelResponse;
                zzahb = s1;
            }
            if (converterwrapper == null)
            {
                zzahd = null;
                return;
            } else
            {
                zzahd = converterwrapper.zzpz();
                return;
            }
        }

        protected Field(int i, boolean flag, int j, boolean flag1, String s, int k, Class class1, 
                zza zza1)
        {
            mVersionCode = 1;
            zzagU = i;
            zzagV = flag;
            zzagW = j;
            zzagX = flag1;
            zzagY = s;
            zzagZ = k;
            zzaha = class1;
            if (class1 == null)
            {
                zzahb = null;
            } else
            {
                zzahb = class1.getCanonicalName();
            }
            zzahd = zza1;
        }

        private class zza
        {

            public abstract Object convertBack(Object obj);

            public abstract int zzpB();

            public abstract int zzpC();
        }

    }

}
