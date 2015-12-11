.class public abstract Lcom/amazon/android/dagger/application/DaggerContentProvider;
.super Landroid/content/ContentProvider;
.source "DaggerContentProvider.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/android/dagger/application/DaggerContentProvider;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/dagger/application/DaggerContentProvider;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method

.method private static waitForDaggerGraphCreation()V
    .locals 3

    .prologue
    .line 32
    :try_start_0
    invoke-static {}, Lcom/amazon/android/dagger/DaggerAndroid;->awaitGraphCreation()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    .local v0, "e":Ljava/lang/InterruptedException;
    :goto_0
    return-void

    .line 33
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catch_0
    move-exception v0

    .line 34
    .restart local v0    # "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/android/dagger/application/DaggerContentProvider;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Interrupted while awaiting completion of Dagger object graph creation"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method


# virtual methods
.method public final delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 90
    invoke-static {}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->waitForDaggerGraphCreation()V

    .line 91
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->deleteOnGraphCreate(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method protected abstract deleteOnGraphCreate(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
.end method

.method public final getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 101
    invoke-static {}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->waitForDaggerGraphCreation()V

    .line 102
    invoke-virtual {p0, p1}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->getTypeOnGraphCreate(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract getTypeOnGraphCreate(Landroid/net/Uri;)Ljava/lang/String;
.end method

.method public final insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 62
    invoke-static {}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->waitForDaggerGraphCreation()V

    .line 63
    invoke-virtual {p0, p1, p2}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->insertOnGraphCreate(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method protected abstract insertOnGraphCreate(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
.end method

.method public final query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 50
    invoke-static {}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->waitForDaggerGraphCreation()V

    .line 51
    invoke-virtual/range {p0 .. p5}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->queryOnGraphCreate(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method protected abstract queryOnGraphCreate(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
.end method

.method public final update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 77
    invoke-static {}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->waitForDaggerGraphCreation()V

    .line 78
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/android/dagger/application/DaggerContentProvider;->updateOnGraphCreate(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method protected abstract updateOnGraphCreate(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
.end method
