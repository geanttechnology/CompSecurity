.class Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;
.super Ljava/lang/Object;
.source "MediaLicenseRenewalTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

.field final synthetic val$platformAPIFuture:Lcom/google/common/util/concurrent/SettableFuture;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;Lcom/google/common/util/concurrent/SettableFuture;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;->val$platformAPIFuture:Lcom/google/common/util/concurrent/SettableFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 144
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;->val$platformAPIFuture:Lcom/google/common/util/concurrent/SettableFuture;

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->applicationContext:Landroid/app/Application;
    invoke-static {v2}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->access$000(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;)Landroid/app/Application;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask$1;->this$0:Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;

    # getter for: Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    invoke-static {v3}, Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;->access$100(Lcom/xfinity/playerlib/downloads/MediaLicenseRenewalTask;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;-><init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    invoke-virtual {v0, v1}, Lcom/google/common/util/concurrent/SettableFuture;->set(Ljava/lang/Object;)Z

    .line 145
    return-void
.end method
