.class Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKCursorFactory;
.super Ljava/lang/Object;
.source "VSdkDb.java"

# interfaces
.implements Landroid/database/sqlite/SQLiteDatabase$CursorFactory;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 515
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newCursor(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)Landroid/database/Cursor;
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "masterQuery"    # Landroid/database/sqlite/SQLiteCursorDriver;
    .param p3, "editTable"    # Ljava/lang/String;
    .param p4, "query"    # Landroid/database/sqlite/SQLiteQuery;

    .prologue
    .line 523
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor;-><init>(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)V

    return-object v0
.end method
