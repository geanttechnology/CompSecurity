.class final Lcom/wishabi/flipp/content/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/x;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 190
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 193
    const-string v0, "ALTER TABLE items ADD video_url TEXT"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 194
    const-string v0, "ALTER TABLE flyers ADD analytics_payload TEXT"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 196
    const-string v0, "CREATE TABLE coupons (_id INTEGER PRIMARY KEY, merchant_id INTEGER, merchant_name TEXT, merchant_logo_url TEXT, coupon_vendor_id INTEGER, coupon_type TEXT, brand TEXT, brand_logo_url TEXT, sale_story TEXT, dollars_off REAL, percent_off REAL, qualifying_quantity INTEGER, reward_quantity INTEGER, promotion_text TEXT, disclaimer_text TEXT, redemption_method TEXT, available_from TEXT, available_to TEXT, valid_from TEXT, valid_to TEXT, coupon_image_url TEXT, barcode_image_url TEXT, priority INTEGER, use_sales_story INTEGER, postal_code TEXT, deleted INTEGER DEFAULT 0);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 224
    const-string v0, "CREATE TABLE coupon_categories (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, coupon_id INTEGER, UNIQUE (name, coupon_id));"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 232
    const-string v0, "CREATE TABLE flyer_item_coupons (_id INTEGER PRIMARY KEY, flyer_item_id INTEGER, flyer_id INTEGER, coupon_id INTEGER, left REAL, top REAL, right REAL, bottom REAL,item_current_price REAL,item_original_price REAL,item_dollars_off REAL,item_cutout_url TEXT,coupon_dollars_off REAL,total_savings REAL,final_price REAL,percent_off REAL,display_final_price INTEGER,display_type INTEGER,item_rank INTEGER);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 252
    return-void
.end method

.method public final b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    .prologue
    .line 256
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Downward migration not supported"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
