.class public Lcom/penthera/virtuososdk/database/impl/VSdkDb;
.super Ljava/lang/Object;
.source "VSdkDb.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;
    }
.end annotation


# static fields
.field private static LOG_TAG:Ljava/lang/String;

.field private static iAuthority:Ljava/lang/String;

.field private static iDb:Landroid/database/sqlite/SQLiteDatabase;

.field private static iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

.field private static iLock:Ljava/util/concurrent/locks/Lock;


# instance fields
.field private iHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    const-class v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;

    .line 39
    sput-object v1, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    .line 42
    sput-object v1, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 43
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;

    .line 26
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "aContext"    # Landroid/content/Context;
    .param p2, "authority"    # Ljava/lang/String;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    .line 72
    sput-object p2, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iAuthority:Ljava/lang/String;

    .line 73
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-direct {v0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    .line 74
    return-void
.end method

.method static synthetic access$0()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iAuthority:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2()Ljava/util/concurrent/locks/Lock;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iLock:Ljava/util/concurrent/locks/Lock;

    return-object v0
.end method

.method static synthetic access$3()Landroid/database/sqlite/SQLiteDatabase;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;

    return-object v0
.end method

.method static synthetic access$4(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0

    .prologue
    .line 42
    sput-object p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iDb:Landroid/database/sqlite/SQLiteDatabase;

    return-void
.end method

.method public static getHelper()Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;
    .locals 1

    .prologue
    .line 66
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    iget-object v0, v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iHelper:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    .line 68
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getInstance()Lcom/penthera/virtuososdk/database/impl/VSdkDb;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    return-object v0
.end method

.method public static declared-synchronized init(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p0, "aContext"    # Landroid/content/Context;
    .param p1, "Authority"    # Ljava/lang/String;

    .prologue
    .line 48
    const-class v1, Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;

    const-string v2, "initialising the db."

    invoke-static {v0, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    if-nez v0, :cond_0

    .line 50
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->LOG_TAG:Ljava/lang/String;

    const-string v2, "creating the db instance."

    invoke-static {v0, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;

    invoke-direct {v0, p0, p1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/VSdkDb;->iInstance:Lcom/penthera/virtuososdk/database/impl/VSdkDb;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 53
    :cond_0
    monitor-exit v1

    return-void

    .line 48
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
