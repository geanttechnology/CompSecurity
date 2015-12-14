// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.l.a;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.unzipped.b;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import com.pf.common.utility.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            v, j, x, DatabaseUpgradeHelper

public class DatabaseOpenHelper extends SQLiteOpenHelper
{

    private static final String a;
    private static final RecoverType b;
    private static boolean c = false;
    private final List d = new ArrayList();

    public DatabaseOpenHelper(Context context)
    {
        super(context, "youmakeup.sqlite", null, 0x10008);
        c = TestConfigHelper.h().l();
        a(a(1, 1), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 1)).toString());
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 2), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 2)).toString());
                sqlitedatabase.execSQL(com.cyberlink.youcammakeup.database.more.j.a());
                sqlitedatabase.execSQL("CREATE TABLE MakeupCategoryCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MCid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
                sqlitedatabase.execSQL("CREATE TABLE MakeupItemCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MIid BIGINT,Cid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 3), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 3)).toString());
                sqlitedatabase.execSQL("CREATE TABLE TattooMaskInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternId TEXT,TattooMaskOrder TEXT,TattoMaskPath TEXT,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT);");
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 4), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 4)).toString());
                sqlitedatabase.execSQL("CREATE TABLE SkuColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,SkuGUID TEXT,ItemGUID TEXT,PatternGUID TEXT,ColorNumber TEXT,ColorName TEXT,ColorType TEXT,Color TEXT,Intensity INTEGER,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT, UNIQUE (SkuGUID, ItemGUID) ON CONFLICT REPLACE);");
                sqlitedatabase.execSQL("CREATE TABLE SkuCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Skuid BIGINT,SkuType TEXT,SkuStartDate BIGINT,SkuEndDate BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 5), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 5)).toString());
                sqlitedatabase.execSQL("CREATE TABLE PatternColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternGUID TEXT,ColorGUID TEXT,Source TEXT,ExtStr TEXT,ExtInt INTEGER, UNIQUE (PatternGUID, ColorGUID));");
                com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper.a(sqlitedatabase);
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 6), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 6)).toString());
                sqlitedatabase.delete("MakeupItemCache", null, null);
                sqlitedatabase.delete("MakeupCategoryCache", null, null);
                sqlitedatabase.execSQL("CREATE TABLE LookCategoryInfo (GUID TEXT,Type TEXT,Category TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER);");
                sqlitedatabase.execSQL("CREATE TABLE LocalizationInfo (Lang TEXT,Name TEXT,Value TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER, UNIQUE (Lang, Name) ON CONFLICT REPLACE);");
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 7), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 7)).toString());
                com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper.b(sqlitedatabase);
                DatabaseUpgradeHelper.c(sqlitedatabase);
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
        a(a(1, 8), new x() {

            final DatabaseOpenHelper a;

            public void a(SQLiteDatabase sqlitedatabase)
            {
                m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a(a, 1, 8)).toString());
                sqlitedatabase.execSQL("CREATE TABLE StyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,ExtraData TEXT,Ext1 TEXT,Ext2 TEXT,Ext3 TEXT,Ext4 TEXT,Ext5 TEXT);");
                sqlitedatabase.execSQL("CREATE TABLE PaletteStyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,palette_guid TEXT,style_guid TEXT,inner_ratio TEXT,feather_strength TEXT,intensity TEXT);");
                DatabaseUpgradeHelper.e(sqlitedatabase);
                DatabaseUpgradeHelper.d(sqlitedatabase);
                com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper.a(sqlitedatabase, com.cyberlink.youcammakeup.database.more.DatabaseUpgradeHelper.UpgradeType.a);
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
    }

    private int a(int i, int k)
    {
        return i << 16 | k;
    }

    static int a(DatabaseOpenHelper databaseopenhelper, int i, int k)
    {
        return databaseopenhelper.a(i, k);
    }

    public static void a()
    {
        try
        {
            File file = Environment.getExternalStorageDirectory();
            File file1 = Environment.getDataDirectory();
            if (file.canWrite())
            {
                file1 = new File(file1, a);
                file = new File(file, "youmakeup.sqlite.db");
                if (file1.exists())
                {
                    bb.a(new FileInputStream(file1), new FileOutputStream(file));
                }
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void a(int i, x x1)
    {
        d.add(new Pair(Integer.valueOf(i), x1));
    }

    private void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE TemplateMetadataCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Tid BIGINT,JsonString TEXT,IsNew INT);");
        sqlitedatabase.execSQL("CREATE TABLE NoticeCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Nindex BIGINT,JsonString TEXT);");
        sqlitedatabase.execSQL(com.cyberlink.youcammakeup.database.more.v.a());
        sqlitedatabase.execSQL("CREATE TABLE PatternPaletteInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternGUID TEXT,PaletteGUID TEXT,Source TEXT,Purpose TEXT,Type TEXT,ColorCount Integer,ColorIntensities TEXT,DateTime DATETIME DEFAULT CURRENT_TIMESTAMP, UNIQUE (PatternGUID, PaletteGUID, Source, Purpose) ON CONFLICT REPLACE);");
        sqlitedatabase.execSQL("CREATE TABLE PatternInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,PatternType TEXT,Name TEXT,ThumbPath TEXT,Source TEXT,SupportMode TEXT,Version REAL,ColorImagePath TEXT,ToolImagePath TEXT,IsNew INTEGER,SkuGUID TEXT,ExtraData TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtStr3 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER,ExtInt3 INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE PaletteInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,ColorSetGUID TEXT,ColorCount TEXT,Name TEXT,Thumbnail TEXT,Source TEXT,Version REAL,PaletteOrder TEXT,isNew INTEGER,SkuGUID TEXT,ExtraData TEXT,Ext1 TEXT,Ext2 TEXT,Ext3 TEXT,Ext4 TEXT,Ext5 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE MaskInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternId TEXT,MaskOrder TEXT,MaskPath TEXT,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE TattooMaskInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternId TEXT,TattooMaskOrder TEXT,TattoMaskPath TEXT,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE ColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,Set_GUID TEXT,PatternType TEXT,Color TEXT,Intensity TEXT,Source TEXT,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE LookInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,Version REAL,Name TEXT,Description TEXT,ThumbImage TEXT,PreviewImage TEXT,Source TEXT,SupportMode TEXT,IsNew INTEGER,ExtraData TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtStr3 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER,ExtInt3 INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE EffectInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,PresetGUID TEXT,PatternGUID TEXT,EffectType TEXT,ColorCount TEXT,ColorSetGUID TEXT,Intensity TEXT,ListOrder TEXT,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE CategoryMetadataCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,BCid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE FilmMetadataCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Cid BIGINT,Findex BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL(com.cyberlink.youcammakeup.database.more.j.a());
        sqlitedatabase.execSQL("CREATE TABLE MakeupCategoryCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MCid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE MakeupItemCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MIid BIGINT,Cid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE SkuColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,SkuGUID TEXT,ItemGUID TEXT,PatternGUID TEXT,ColorNumber TEXT,ColorName TEXT,ColorType TEXT,Color TEXT,Intensity INTEGER,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT, UNIQUE (SkuGUID, ItemGUID) ON CONFLICT REPLACE);");
        sqlitedatabase.execSQL("CREATE TABLE SkuCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Skuid BIGINT,SkuType TEXT,SkuStartDate BIGINT,SkuEndDate BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE PatternColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,PatternGUID TEXT,ColorGUID TEXT,Source TEXT,ExtStr TEXT,ExtInt INTEGER, UNIQUE (PatternGUID, ColorGUID));");
        sqlitedatabase.execSQL("CREATE TABLE LookCategoryInfo (GUID TEXT,Type TEXT,Category TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE LocalizationInfo (Lang TEXT,Name TEXT,Value TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER, UNIQUE (Lang, Name) ON CONFLICT REPLACE);");
        sqlitedatabase.execSQL("CREATE TABLE StyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,ExtraData TEXT,Ext1 TEXT,Ext2 TEXT,Ext3 TEXT,Ext4 TEXT,Ext5 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE PaletteStyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,palette_guid TEXT,style_guid TEXT,inner_ratio TEXT,feather_strength TEXT,intensity TEXT);");
    }

    static void a(String s, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype)
    {
        b(s, sourcetype);
    }

    public static boolean a(File file)
    {
        int i = 0;
        if (file == null)
        {
            throw new IllegalArgumentException("file must not be null");
        }
        boolean flag = file.delete() | false | (new File((new StringBuilder()).append(file.getPath()).append("-journal").toString())).delete() | (new File((new StringBuilder()).append(file.getPath()).append("-shm").toString())).delete() | (new File((new StringBuilder()).append(file.getPath()).append("-wal").toString())).delete();
        File file1 = file.getParentFile();
        boolean flag1 = flag;
        if (file1 != null)
        {
            file = file1.listFiles(new FileFilter((new StringBuilder()).append(file.getName()).append("-mj").toString()) {

                final String a;

                public boolean accept(File file2)
                {
                    return file2.getName().startsWith(a);
                }

            
            {
                a = s;
                super();
            }
            });
            flag1 = flag;
            if (file != null)
            {
                int k = file.length;
                do
                {
                    flag1 = flag;
                    if (i >= k)
                    {
                        break;
                    }
                    flag1 = file[i].delete();
                    i++;
                    flag = flag1 | flag;
                } while (true);
            }
        }
        return flag1;
    }

    private static final void b(String s, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype)
    {
        File afile[] = (new File(s)).listFiles();
        if (afile != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int k;
        k = afile.length;
        i = 0;
_L10:
        if (i >= k) goto _L1; else goto _L3
_L3:
        s = afile[i];
        if (s.isDirectory()) goto _L5; else goto _L4
_L4:
        if (!"makeup_template.xml".equals(s.getName())) goto _L7; else goto _L6
_L6:
        File file;
        m.c("database.more.DatabaseOpenHelper", (new StringBuilder()).append(sourcetype.name()).append(" template: ").append(s.getAbsolutePath()).toString());
        file = new File((new StringBuilder()).append(s.getParent()).append(File.separator).toString());
        Object obj1 = new BufferedReader(new FileReader((new StringBuilder()).append(file).append(File.separator).append("makeup_metadata.json").toString()));
        Object obj = obj1;
        s = new StringBuilder();
_L9:
        obj = obj1;
        String s1 = ((BufferedReader) (obj1)).readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        s.append(s1).append("\n");
        if (true) goto _L9; else goto _L8
        obj;
        s = ((String) (obj1));
        obj1 = obj;
_L13:
        obj = s;
        ((IOException) (obj1)).printStackTrace();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
_L7:
        i++;
          goto _L10
_L8:
        obj = obj1;
        ((BufferedReader) (obj1)).close();
        obj = obj1;
        s1 = s.toString();
        obj = obj1;
        s = new BufferedReader(new FileReader((new StringBuilder()).append(file).append(File.separator).append("makeup_category_id").toString()));
        obj = new StringBuilder();
_L11:
        obj1 = s.readLine();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        ((StringBuilder) (obj)).append(((String) (obj1)));
          goto _L11
        obj = ((StringBuilder) (obj)).toString();
        long l;
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        try
        {
            s = new MakeupItemMetadata(new JSONObject(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        bo.a((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).toString(), "makeup_template.xml", sourcetype);
        obj1 = new b(file.getAbsoluteFile(), 0);
        obj = CategoryType.a(Long.valueOf(((String) (obj))).longValue());
        l = (new Date()).getTime();
        s = new a(s.a(), s.m(), l, ((com.cyberlink.youcammakeup.database.more.unzipped.c) (obj1)), ((CategoryType) (obj)), s.h(), s.i(), false);
        h.c().a(s);
          goto _L7
        s;
        obj = null;
_L12:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype)
            {
                sourcetype.printStackTrace();
            }
        }
        throw s;
_L5:
        b(s.getAbsolutePath(), sourcetype);
          goto _L7
        s;
          goto _L12
        sourcetype;
        obj = s;
        s = sourcetype;
          goto _L12
        obj1;
        s = null;
          goto _L13
        obj1;
          goto _L13
    }

    static boolean b()
    {
        return c;
    }

    private final void c()
    {
        c = false;
        d();
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[RecoverType.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.database.more.RecoverType.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.database.more.RecoverType.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.cyberlink.youcammakeup.database.more._cls3.a[b.ordinal()];
        JVM INSTR tableswitch 1 1: default 36
    //                   1 69;
           goto _L1 _L2
_L1:
        bo.v();
        bo.a(new bu() {

            final DatabaseOpenHelper a;

            public void a(List list)
            {
                bo.u();
                com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.a((new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.b()).append(File.separator).append("makeup").toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
            }

            
            {
                a = DatabaseOpenHelper.this;
                super();
            }
        });
_L4:
        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", bo.c(), Globals.d());
        com.cyberlink.youcammakeup.kernelctrl.sku.h.b().e();
        return;
_L2:
        try
        {
            e();
            b((new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.b()).append(File.separator).append("makeup").toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static final void d()
    {
        File file = new File(Environment.getDataDirectory(), a);
        if (file.exists())
        {
            a(file);
        }
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        return;
        obj;
        throw obj;
    }

    private static final void e()
    {
        InputStream inputstream;
        Object obj;
        obj = new File(Environment.getDataDirectory(), a);
        inputstream = Globals.d().getAssets().open("youmakeup.sqlite.db");
        obj = new FileOutputStream(((File) (obj)));
        bb.a(inputstream, ((java.io.OutputStream) (obj)));
        if (inputstream != null)
        {
            inputstream.close();
        }
        if (obj != null)
        {
            ((FileOutputStream) (obj)).close();
        }
        return;
        Exception exception;
        exception;
        if (inputstream != null)
        {
            inputstream.close();
        }
        if (obj != null)
        {
            ((FileOutputStream) (obj)).close();
        }
        throw exception;
    }

    public SQLiteDatabase getReadableDatabase()
    {
        try
        {
            if (c)
            {
                throw new dbUpgradeException();
            }
        }
        catch (dbUpgradeException dbupgradeexception)
        {
            c();
            return super.getReadableDatabase();
        }
        SQLiteDatabase sqlitedatabase = super.getReadableDatabase();
        return sqlitedatabase;
    }

    public SQLiteDatabase getWritableDatabase()
    {
        try
        {
            if (c)
            {
                throw new dbUpgradeException();
            }
        }
        catch (dbUpgradeException dbupgradeexception)
        {
            c();
            return super.getWritableDatabase();
        }
        SQLiteDatabase sqlitedatabase = super.getWritableDatabase();
        return sqlitedatabase;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        m.c("database.more.DatabaseOpenHelper", "creating schema");
        a(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        m.c("database.more.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        Object obj;
        obj;
        m.e("database.more.DatabaseOpenHelper", (new StringBuilder()).append("Exception: ").append(((Exception) (obj)).getMessage()).toString());
        m.c("database.more.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        return;
        obj;
        m.c("database.more.DatabaseOpenHelper", "end transaction");
        sqlitedatabase.endTransaction();
        throw obj;
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int k)
    {
        m.d("database.more.DatabaseOpenHelper", (new StringBuilder()).append("Downgrading database from version ").append(i).append(" to ").append(k).append(", which will destroy all old data").toString());
        d();
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        m.c("database.more.DatabaseOpenHelper", "Open database");
        super.onOpen(sqlitedatabase);
        if (Globals.X())
        {
            return;
        } else
        {
            sqlitedatabase.rawQuery("PRAGMA synchronous = OFF;", null).close();
            sqlitedatabase.rawQuery("PRAGMA temp_store = MEMORY;", null).close();
            sqlitedatabase.rawQuery("PRAGMA cache_size = 20000;", null).close();
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int k)
    {
        int l;
        m.d("database.more.DatabaseOpenHelper", (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(k).append(", which will destroy all old data").toString());
        sqlitedatabase.beginTransaction();
        m.c("database.more.DatabaseOpenHelper", "updating schema begin transaction");
        l = 0;
_L2:
        Pair pair;
        int i1;
        if (l >= d.size())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        pair = (Pair)d.get(l);
        i1 = ((Integer)pair.first).intValue();
        if (i1 <= i || i1 > k)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        ((x)pair.second).a(sqlitedatabase);
        break MISSING_BLOCK_LABEL_196;
        sqlitedatabase.setTransactionSuccessful();
        m.c("database.more.DatabaseOpenHelper", "updating schema end transaction");
        sqlitedatabase.endTransaction();
        m.c("database.more.DatabaseOpenHelper", "Upgrading done.");
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        throw new dbUpgradeException();
        obj;
        m.c("database.more.DatabaseOpenHelper", "updating schema end transaction");
        sqlitedatabase.endTransaction();
        throw obj;
        l++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        a = (new StringBuilder()).append("data").append(File.separator).append(Globals.d().getPackageName()).append(File.separator).append("databases").append(File.separator).append("youmakeup.sqlite").toString();
        b = com.cyberlink.youcammakeup.database.more.RecoverType.a;
    }

    private class RecoverType extends Enum
    {

        public static final RecoverType a;
        public static final RecoverType b;
        private static final RecoverType c[];

        public static RecoverType valueOf(String s)
        {
            return (RecoverType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/DatabaseOpenHelper$RecoverType, s);
        }

        public static RecoverType[] values()
        {
            return (RecoverType[])c.clone();
        }

        static 
        {
            a = new RecoverType("ReparseBuildIn", 0);
            b = new RecoverType("ReplaceDb", 1);
            c = (new RecoverType[] {
                a, b
            });
        }

        private RecoverType(String s, int i)
        {
            super(s, i);
        }
    }


    private class dbUpgradeException extends RuntimeException
    {

        final DatabaseOpenHelper this$0;

        public dbUpgradeException()
        {
            this$0 = DatabaseOpenHelper.this;
            super();
            databaseopenhelper = Toast.makeText(Globals.d(), "Database upgrade failed!", 1);
            if (com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper.b())
            {
                show();
                return;
            } else
            {
                com.cyberlink.youcammakeup.flurry.a.a(new DatabaseUpgradeCrashEvent(z.v()));
                return;
            }
        }
    }

}
