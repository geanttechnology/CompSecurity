.class Lcom/amazon/identity/auth/device/api/MAPInit$3;
.super Ljava/lang/Object;
.source "MAPInit.java"

# interfaces
.implements Ljava/lang/Runnable;


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
    .line 166
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInit$3;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 170
    new-instance v0, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPInit$3;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/MAPInitTasks;->performInitOperations()V

    .line 171
    return-void
.end method
