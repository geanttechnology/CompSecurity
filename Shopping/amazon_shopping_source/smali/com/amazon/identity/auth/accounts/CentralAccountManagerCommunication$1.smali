.class Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;
.super Ljava/lang/Object;
.source "CentralAccountManagerCommunication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 713
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 718
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;->this$0:Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;

    new-instance v1, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1$1;-><init>(Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;->deregisterDevice(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 734
    return-void
.end method
