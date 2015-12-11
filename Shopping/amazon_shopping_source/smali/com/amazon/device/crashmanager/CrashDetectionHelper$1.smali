.class Lcom/amazon/device/crashmanager/CrashDetectionHelper$1;
.super Ljava/lang/Object;
.source "CrashDetectionHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReportAsync()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/crashmanager/CrashDetectionHelper;


# direct methods
.method constructor <init>(Lcom/amazon/device/crashmanager/CrashDetectionHelper;)V
    .locals 0

    .prologue
    .line 291
    iput-object p1, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper$1;->this$0:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 295
    :try_start_0
    iget-object v1, p0, Lcom/amazon/device/crashmanager/CrashDetectionHelper$1;->this$0:Lcom/amazon/device/crashmanager/CrashDetectionHelper;

    invoke-virtual {v1}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->uploadCrashReport()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 299
    :goto_0
    return-void

    .line 296
    :catch_0
    move-exception v0

    .line 297
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/device/crashmanager/CrashDetectionHelper;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/crashmanager/CrashDetectionHelper;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Failed to upload crash."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
