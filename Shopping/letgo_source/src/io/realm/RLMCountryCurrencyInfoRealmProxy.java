// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.util.JsonReader;
import android.util.JsonToken;
import com.abtnprojects.ambatana.datasource.realm.RLMCountryCurrencyInfo;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            Realm

public class RLMCountryCurrencyInfoRealmProxy extends RLMCountryCurrencyInfo
    implements RealmObjectProxy
{

    private static final List FIELD_NAMES;
    private static long INDEX_COUNTRYCODEALPHA2;
    private static long INDEX_COUNTRYCODEALPHA3;
    private static long INDEX_CURRENCYCODE;
    private static long INDEX_DEFAULTLOCALE;
    private static long INDEX_ID;
    private static Map columnIndices;

    public RLMCountryCurrencyInfoRealmProxy()
    {
    }

    public static RLMCountryCurrencyInfo copy(Realm realm, RLMCountryCurrencyInfo rlmcountrycurrencyinfo, boolean flag, Map map)
    {
        RLMCountryCurrencyInfo rlmcountrycurrencyinfo1 = (RLMCountryCurrencyInfo)realm.createObject(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo);
        map.put(rlmcountrycurrencyinfo, (RealmObjectProxy)rlmcountrycurrencyinfo1);
        rlmcountrycurrencyinfo1.setId(rlmcountrycurrencyinfo.getId());
        if (rlmcountrycurrencyinfo.getCountryCodeAlpha2() != null)
        {
            realm = rlmcountrycurrencyinfo.getCountryCodeAlpha2();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo1.setCountryCodeAlpha2(realm);
        if (rlmcountrycurrencyinfo.getCountryCodeAlpha3() != null)
        {
            realm = rlmcountrycurrencyinfo.getCountryCodeAlpha3();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo1.setCountryCodeAlpha3(realm);
        if (rlmcountrycurrencyinfo.getCurrencyCode() != null)
        {
            realm = rlmcountrycurrencyinfo.getCurrencyCode();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo1.setCurrencyCode(realm);
        if (rlmcountrycurrencyinfo.getDefaultLocale() != null)
        {
            realm = rlmcountrycurrencyinfo.getDefaultLocale();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo1.setDefaultLocale(realm);
        return rlmcountrycurrencyinfo1;
    }

    public static RLMCountryCurrencyInfo copyOrUpdate(Realm realm, RLMCountryCurrencyInfo rlmcountrycurrencyinfo, boolean flag, Map map)
    {
        if (rlmcountrycurrencyinfo.realm != null && rlmcountrycurrencyinfo.realm.getPath().equals(realm.getPath()))
        {
            return rlmcountrycurrencyinfo;
        } else
        {
            return copy(realm, rlmcountrycurrencyinfo, flag, map);
        }
    }

    public static RLMCountryCurrencyInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject jsonobject, boolean flag)
        throws JSONException
    {
        realm = (RLMCountryCurrencyInfo)realm.createObject(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo);
        if (!jsonobject.isNull("id"))
        {
            realm.setId(jsonobject.getInt("id"));
        }
        if (!jsonobject.isNull("countryCodeAlpha2"))
        {
            realm.setCountryCodeAlpha2(jsonobject.getString("countryCodeAlpha2"));
        }
        if (!jsonobject.isNull("countryCodeAlpha3"))
        {
            realm.setCountryCodeAlpha3(jsonobject.getString("countryCodeAlpha3"));
        }
        if (!jsonobject.isNull("currencyCode"))
        {
            realm.setCurrencyCode(jsonobject.getString("currencyCode"));
        }
        if (!jsonobject.isNull("defaultLocale"))
        {
            realm.setDefaultLocale(jsonobject.getString("defaultLocale"));
        }
        return realm;
    }

    public static RLMCountryCurrencyInfo createUsingJsonStream(Realm realm, JsonReader jsonreader)
        throws IOException
    {
        realm = (RLMCountryCurrencyInfo)realm.createObject(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo);
        jsonreader.beginObject();
        while (jsonreader.hasNext()) 
        {
            String s = jsonreader.nextName();
            if (s.equals("id") && jsonreader.peek() != JsonToken.NULL)
            {
                realm.setId(jsonreader.nextInt());
            } else
            if (s.equals("countryCodeAlpha2") && jsonreader.peek() != JsonToken.NULL)
            {
                realm.setCountryCodeAlpha2(jsonreader.nextString());
            } else
            if (s.equals("countryCodeAlpha3") && jsonreader.peek() != JsonToken.NULL)
            {
                realm.setCountryCodeAlpha3(jsonreader.nextString());
            } else
            if (s.equals("currencyCode") && jsonreader.peek() != JsonToken.NULL)
            {
                realm.setCurrencyCode(jsonreader.nextString());
            } else
            if (s.equals("defaultLocale") && jsonreader.peek() != JsonToken.NULL)
            {
                realm.setDefaultLocale(jsonreader.nextString());
            } else
            {
                jsonreader.skipValue();
            }
        }
        jsonreader.endObject();
        return realm;
    }

    public static Map getColumnIndices()
    {
        return columnIndices;
    }

    public static List getFieldNames()
    {
        return FIELD_NAMES;
    }

    public static String getTableName()
    {
        return "class_RLMCountryCurrencyInfo";
    }

    public static Table initTable(ImplicitTransaction implicittransaction)
    {
        if (!implicittransaction.hasTable("class_RLMCountryCurrencyInfo"))
        {
            implicittransaction = implicittransaction.getTable("class_RLMCountryCurrencyInfo");
            implicittransaction.addColumn(ColumnType.INTEGER, "id");
            implicittransaction.addColumn(ColumnType.STRING, "countryCodeAlpha2");
            implicittransaction.addColumn(ColumnType.STRING, "countryCodeAlpha3");
            implicittransaction.addColumn(ColumnType.STRING, "currencyCode");
            implicittransaction.addColumn(ColumnType.STRING, "defaultLocale");
            implicittransaction.setPrimaryKey("");
            return implicittransaction;
        } else
        {
            return implicittransaction.getTable("class_RLMCountryCurrencyInfo");
        }
    }

    static RLMCountryCurrencyInfo update(Realm realm, RLMCountryCurrencyInfo rlmcountrycurrencyinfo, RLMCountryCurrencyInfo rlmcountrycurrencyinfo1, Map map)
    {
        rlmcountrycurrencyinfo.setId(rlmcountrycurrencyinfo1.getId());
        if (rlmcountrycurrencyinfo1.getCountryCodeAlpha2() != null)
        {
            realm = rlmcountrycurrencyinfo1.getCountryCodeAlpha2();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo.setCountryCodeAlpha2(realm);
        if (rlmcountrycurrencyinfo1.getCountryCodeAlpha3() != null)
        {
            realm = rlmcountrycurrencyinfo1.getCountryCodeAlpha3();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo.setCountryCodeAlpha3(realm);
        if (rlmcountrycurrencyinfo1.getCurrencyCode() != null)
        {
            realm = rlmcountrycurrencyinfo1.getCurrencyCode();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo.setCurrencyCode(realm);
        if (rlmcountrycurrencyinfo1.getDefaultLocale() != null)
        {
            realm = rlmcountrycurrencyinfo1.getDefaultLocale();
        } else
        {
            realm = "";
        }
        rlmcountrycurrencyinfo.setDefaultLocale(realm);
        return rlmcountrycurrencyinfo;
    }

    public static void validateTable(ImplicitTransaction implicittransaction)
    {
        if (implicittransaction.hasTable("class_RLMCountryCurrencyInfo"))
        {
            Table table = implicittransaction.getTable("class_RLMCountryCurrencyInfo");
            if (table.getColumnCount() != 5L)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), (new StringBuilder()).append("Field count does not match - expected 5 but was ").append(table.getColumnCount()).toString());
            }
            HashMap hashmap = new HashMap();
            for (long l = 0L; l < 5L; l++)
            {
                hashmap.put(table.getColumnName(l), table.getColumnType(l));
            }

            columnIndices = new HashMap();
            String s;
            long l1;
            for (Iterator iterator = getFieldNames().iterator(); iterator.hasNext(); columnIndices.put(s, Long.valueOf(l1)))
            {
                s = (String)iterator.next();
                l1 = table.getColumnIndex(s);
                if (l1 == -1L)
                {
                    throw new RealmMigrationNeededException(implicittransaction.getPath(), (new StringBuilder()).append("Field '").append(s).append("' not found for type RLMCountryCurrencyInfo").toString());
                }
            }

            INDEX_ID = table.getColumnIndex("id");
            INDEX_COUNTRYCODEALPHA2 = table.getColumnIndex("countryCodeAlpha2");
            INDEX_COUNTRYCODEALPHA3 = table.getColumnIndex("countryCodeAlpha3");
            INDEX_CURRENCYCODE = table.getColumnIndex("currencyCode");
            INDEX_DEFAULTLOCALE = table.getColumnIndex("defaultLocale");
            if (!hashmap.containsKey("id"))
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Missing field 'id'");
            }
            if (hashmap.get("id") != ColumnType.INTEGER)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (!hashmap.containsKey("countryCodeAlpha2"))
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Missing field 'countryCodeAlpha2'");
            }
            if (hashmap.get("countryCodeAlpha2") != ColumnType.STRING)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Invalid type 'String' for field 'countryCodeAlpha2'");
            }
            if (!hashmap.containsKey("countryCodeAlpha3"))
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Missing field 'countryCodeAlpha3'");
            }
            if (hashmap.get("countryCodeAlpha3") != ColumnType.STRING)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Invalid type 'String' for field 'countryCodeAlpha3'");
            }
            if (!hashmap.containsKey("currencyCode"))
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Missing field 'currencyCode'");
            }
            if (hashmap.get("currencyCode") != ColumnType.STRING)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Invalid type 'String' for field 'currencyCode'");
            }
            if (!hashmap.containsKey("defaultLocale"))
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Missing field 'defaultLocale'");
            }
            if (hashmap.get("defaultLocale") != ColumnType.STRING)
            {
                throw new RealmMigrationNeededException(implicittransaction.getPath(), "Invalid type 'String' for field 'defaultLocale'");
            } else
            {
                return;
            }
        } else
        {
            throw new RealmMigrationNeededException(implicittransaction.getPath(), "The RLMCountryCurrencyInfo class is missing from the schema for this Realm.");
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (RLMCountryCurrencyInfoRealmProxy)obj;
            String s = realm.getPath();
            String s1 = ((RLMCountryCurrencyInfoRealmProxy) (obj)).realm.getPath();
            if (s == null ? s1 != null : !s.equals(s1))
            {
                return false;
            }
            s = row.getTable().getName();
            s1 = ((RLMCountryCurrencyInfoRealmProxy) (obj)).row.getTable().getName();
            if (s == null ? s1 != null : !s.equals(s1))
            {
                return false;
            }
            if (row.getIndex() != ((RLMCountryCurrencyInfoRealmProxy) (obj)).row.getIndex())
            {
                return false;
            }
        }
        return true;
    }

    public String getCountryCodeAlpha2()
    {
        realm.checkIfValid();
        return row.getString(INDEX_COUNTRYCODEALPHA2);
    }

    public String getCountryCodeAlpha3()
    {
        realm.checkIfValid();
        return row.getString(INDEX_COUNTRYCODEALPHA3);
    }

    public String getCurrencyCode()
    {
        realm.checkIfValid();
        return row.getString(INDEX_CURRENCYCODE);
    }

    public String getDefaultLocale()
    {
        realm.checkIfValid();
        return row.getString(INDEX_DEFAULTLOCALE);
    }

    public int getId()
    {
        realm.checkIfValid();
        return (int)row.getLong(INDEX_ID);
    }

    public int hashCode()
    {
        int j = 0;
        String s = realm.getPath();
        String s1 = row.getTable().getName();
        long l = row.getIndex();
        int i;
        if (s != null)
        {
            i = s.hashCode();
        } else
        {
            i = 0;
        }
        if (s1 != null)
        {
            j = s1.hashCode();
        }
        return (j + (i + 527) * 31) * 31 + (int)(l >>> 32 ^ l);
    }

    public void setCountryCodeAlpha2(String s)
    {
        realm.checkIfValid();
        row.setString(INDEX_COUNTRYCODEALPHA2, s);
    }

    public void setCountryCodeAlpha3(String s)
    {
        realm.checkIfValid();
        row.setString(INDEX_COUNTRYCODEALPHA3, s);
    }

    public void setCurrencyCode(String s)
    {
        realm.checkIfValid();
        row.setString(INDEX_CURRENCYCODE, s);
    }

    public void setDefaultLocale(String s)
    {
        realm.checkIfValid();
        row.setString(INDEX_DEFAULTLOCALE, s);
    }

    public void setId(int i)
    {
        realm.checkIfValid();
        row.setLong(INDEX_ID, i);
    }

    public String toString()
    {
        if (!isValid())
        {
            return "Invalid object";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("RLMCountryCurrencyInfo = [");
            stringbuilder.append("{id:");
            stringbuilder.append(getId());
            stringbuilder.append("}");
            stringbuilder.append(",");
            stringbuilder.append("{countryCodeAlpha2:");
            stringbuilder.append(getCountryCodeAlpha2());
            stringbuilder.append("}");
            stringbuilder.append(",");
            stringbuilder.append("{countryCodeAlpha3:");
            stringbuilder.append(getCountryCodeAlpha3());
            stringbuilder.append("}");
            stringbuilder.append(",");
            stringbuilder.append("{currencyCode:");
            stringbuilder.append(getCurrencyCode());
            stringbuilder.append("}");
            stringbuilder.append(",");
            stringbuilder.append("{defaultLocale:");
            stringbuilder.append(getDefaultLocale());
            stringbuilder.append("}");
            stringbuilder.append("]");
            return stringbuilder.toString();
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("id");
        arraylist.add("countryCodeAlpha2");
        arraylist.add("countryCodeAlpha3");
        arraylist.add("currencyCode");
        arraylist.add("defaultLocale");
        FIELD_NAMES = Collections.unmodifiableList(arraylist);
    }
}
