.class public Lcom/aio/downloader/cleaner/RubActivity$memInfo;
.super Ljava/lang/Object;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/RubActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "memInfo"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1047
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$memInfo;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getmem_UNUSED(Landroid/content/Context;)J
    .locals 8
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    .line 1052
    .line 1053
    const-string v4, "activity"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 1052
    check-cast v2, Landroid/app/ActivityManager;

    .line 1056
    .local v2, "am":Landroid/app/ActivityManager;
    new-instance v3, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v3}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 1057
    .local v3, "mi":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v2, v3}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 1061
    iget-wide v4, v3, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    const-wide/16 v6, 0x400

    div-long v0, v4, v6

    .line 1062
    .local v0, "MEM_UNUSED":J
    return-wide v0
.end method
