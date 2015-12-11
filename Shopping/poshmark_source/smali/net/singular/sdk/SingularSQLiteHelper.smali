.class Lnet/singular/sdk/SingularSQLiteHelper;
.super Landroid/database/sqlite/SQLiteOpenHelper;
.source "SingularSQLiteHelper.java"


# static fields
.field static final DB_VERSION:I = 0x1


# instance fields
.field private final log:Lnet/singular/sdk/SingularLog;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 12
    const-string v0, "singular.db"

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    .line 13
    iput-object p2, p0, Lnet/singular/sdk/SingularSQLiteHelper;->log:Lnet/singular/sdk/SingularLog;

    .line 14
    const-string v0, "singular_sdk"

    const-string v1, "SingularSQLiteHelper initialization complete!"

    invoke-virtual {p2, v0, v1}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 15
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 27
    iget-object v0, p0, Lnet/singular/sdk/SingularSQLiteHelper;->log:Lnet/singular/sdk/SingularLog;

    invoke-static {p1, v0}, Lnet/singular/sdk/EventStore;->onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V

    .line 28
    iget-object v0, p0, Lnet/singular/sdk/SingularSQLiteHelper;->log:Lnet/singular/sdk/SingularLog;

    invoke-static {p1, v0}, Lnet/singular/sdk/KeyValueStore;->onCreate(Landroid/database/sqlite/SQLiteDatabase;Lnet/singular/sdk/SingularLog;)V

    .line 29
    return-void
.end method

.method public onOpen(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 22
    const-string v0, "PRAGMA synchronous=NORMAL;"

    instance-of v1, p1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v1, :cond_0

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 23
    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return-void

    .line 22
    .restart local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast p1, Landroid/database/sqlite/SQLiteDatabase;

    .end local p1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {p1, v0}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->execSQL(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p2, "oldVersion"    # I
    .param p3, "newVersion"    # I

    .prologue
    .line 33
    iget-object v0, p0, Lnet/singular/sdk/SingularSQLiteHelper;->log:Lnet/singular/sdk/SingularLog;

    invoke-static {p1, p2, p3, v0}, Lnet/singular/sdk/EventStore;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;IILnet/singular/sdk/SingularLog;)V

    .line 34
    iget-object v0, p0, Lnet/singular/sdk/SingularSQLiteHelper;->log:Lnet/singular/sdk/SingularLog;

    invoke-static {p1, p2, p3, v0}, Lnet/singular/sdk/KeyValueStore;->onUpgrade(Landroid/database/sqlite/SQLiteDatabase;IILnet/singular/sdk/SingularLog;)V

    .line 35
    return-void
.end method
