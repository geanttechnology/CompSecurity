.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

.field final synthetic val$creds:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

.field final synthetic val$emptyListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

.field final synthetic val$overridingDSNChildDevicePackageName:Ljava/lang/String;

.field final synthetic val$registrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;Lcom/amazon/identity/auth/accounts/AccountRegistrar;Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$registrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$emptyListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$overridingDSNChildDevicePackageName:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$creds:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 368
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$registrar:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$emptyListener:Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$overridingDSNChildDevicePackageName:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mDirectedId:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->access$100(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->val$creds:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;
    invoke-static {v6}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->access$200(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest$2;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    # getter for: Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->mTracer:Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-static {v7}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->access$300(Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;->deregister(Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/credentials/AccountCredentials;ZLcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 375
    return-void
.end method
