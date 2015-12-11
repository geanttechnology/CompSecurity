.class final Lcom/amazon/device/ads/ThreadUtils$1;
.super Ljava/lang/Object;
.source "ThreadUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/ThreadUtils;->executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$params:[Ljava/lang/Object;

.field final synthetic val$task:Landroid/os/AsyncTask;


# direct methods
.method constructor <init>(Landroid/os/AsyncTask;[Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/device/ads/ThreadUtils$1;->val$task:Landroid/os/AsyncTask;

    iput-object p2, p0, Lcom/amazon/device/ads/ThreadUtils$1;->val$params:[Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/device/ads/ThreadUtils$1;->val$task:Landroid/os/AsyncTask;

    iget-object v1, p0, Lcom/amazon/device/ads/ThreadUtils$1;->val$params:[Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/AndroidTargetUtils;->executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 47
    return-void
.end method
