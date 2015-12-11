.class Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;
.super Ljava/lang/Object;
.source "FeedsServerCom.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;,
        Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;
    }
.end annotation


# static fields
.field public static final GET_JSON:I = 0x5

.field public static final GET_XML:I = 0x6

.field public static final HTTPS_GET:I = 0x2

.field public static final HTTP_GET:I = 0x1

.field public static final HTTP_POST:I = 0x3

.field public static final HTTP_PUT:I = 0x4

.field public static final POST_MSG:Ljava/lang/String; = "POSTMSG"


# instance fields
.field executor:Ljava/util/concurrent/Executor;

.field mCtx:Landroid/content/Context;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    return-void
.end method


# virtual methods
.method protected execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "httpType"    # I
    .param p3, "downloadType"    # I
    .param p4, "pListener"    # Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "II",
            "Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 77
    .local p5, "values":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->initiExecutor()V

    .line 78
    iget-object v7, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->executor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$execTaskRunnable;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V

    invoke-interface {v7, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 79
    return-void
.end method

.method initiExecutor()V
    .locals 3

    .prologue
    .line 66
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->executor:Ljava/util/concurrent/Executor;

    if-nez v1, :cond_0

    .line 68
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;)V

    iput-object v1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->executor:Ljava/util/concurrent/Executor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    :cond_0
    :goto_0
    return-void

    .line 69
    :catch_0
    move-exception v0

    .line 70
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Error: "

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method
