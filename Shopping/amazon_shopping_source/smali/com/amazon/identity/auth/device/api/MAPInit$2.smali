.class Lcom/amazon/identity/auth/device/api/MAPInit$2;
.super Ljava/lang/Object;
.source "MAPInit.java"

# interfaces
.implements Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPInit;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPInit;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInit$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCacheUpdated()V
    .locals 2

    .prologue
    .line 144
    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$400()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "DCP settings updated"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$2;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # invokes: Lcom/amazon/identity/auth/device/api/MAPInit;->toggleSettings()V
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$500(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    .line 146
    return-void
.end method
