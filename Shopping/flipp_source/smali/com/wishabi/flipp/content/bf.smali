.class final Lcom/wishabi/flipp/content/bf;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/content/bk;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 176
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 179
    const-string v0, "CREATE TABLE user_coupon_data (_id INTEGER PRIMARY KEY,clipped INTEGER DEFAULT 0,sent INTEGER DEFAULT 0);"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 183
    return-void
.end method

.method public final b(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1

    .prologue
    .line 187
    const-string v0, "DROP TABLE IF EXISTS clipped_coupons;"

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 188
    return-void
.end method
