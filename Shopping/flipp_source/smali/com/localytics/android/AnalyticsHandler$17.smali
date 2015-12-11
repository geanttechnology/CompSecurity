.class Lcom/localytics/android/AnalyticsHandler$17;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/localytics/android/AnalyticsHandler;

.field final synthetic val$key:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/localytics/android/AnalyticsHandler;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1539
    iput-object p1, p0, Lcom/localytics/android/AnalyticsHandler$17;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iput-object p2, p0, Lcom/localytics/android/AnalyticsHandler$17;->val$key:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1539
    invoke-virtual {p0}, Lcom/localytics/android/AnalyticsHandler$17;->call()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 1543
    .line 1547
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler$17;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iget-object v0, v0, Lcom/localytics/android/AnalyticsHandler;->mProvider:Lcom/localytics/android/BaseProvider;

    const-string v1, "identifiers"

    # getter for: Lcom/localytics/android/AnalyticsHandler;->PROJECTION_SET_IDENTIFIER:[Ljava/lang/String;
    invoke-static {}, Lcom/localytics/android/AnalyticsHandler;->access$1600()[Ljava/lang/String;

    move-result-object v2

    # getter for: Lcom/localytics/android/AnalyticsHandler;->SELECTION_SET_IDENTIFIER:Ljava/lang/String;
    invoke-static {}, Lcom/localytics/android/AnalyticsHandler;->access$1700()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-object v7, p0, Lcom/localytics/android/AnalyticsHandler$17;->val$key:Ljava/lang/String;

    aput-object v7, v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Lcom/localytics/android/BaseProvider;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 1549
    :try_start_1
    invoke-interface {v1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1551
    const-string v0, "value"

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v6

    .line 1556
    :cond_0
    if-eqz v1, :cond_1

    .line 1558
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1563
    :cond_1
    return-object v6

    .line 1556
    :catchall_0
    move-exception v0

    move-object v1, v6

    :goto_0
    if-eqz v1, :cond_2

    .line 1558
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 1559
    :cond_2
    throw v0

    .line 1556
    :catchall_1
    move-exception v0

    goto :goto_0
.end method
