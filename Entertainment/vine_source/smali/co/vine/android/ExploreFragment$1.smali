.class Lco/vine/android/ExploreFragment$1;
.super Landroid/content/BroadcastReceiver;
.source "ExploreFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ExploreFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ExploreFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ExploreFragment;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lco/vine/android/ExploreFragment$1;->this$0:Lco/vine/android/ExploreFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 82
    const-string v2, "connectivity"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 84
    .local v0, "connectivityManager":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 86
    .local v1, "ni":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 87
    iget-object v2, p0, Lco/vine/android/ExploreFragment$1;->this$0:Lco/vine/android/ExploreFragment;

    invoke-virtual {v2}, Lco/vine/android/ExploreFragment;->reloadWebView()V

    .line 89
    :cond_0
    return-void
.end method
