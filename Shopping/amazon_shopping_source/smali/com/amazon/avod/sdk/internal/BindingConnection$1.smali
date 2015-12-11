.class Lcom/amazon/avod/sdk/internal/BindingConnection$1;
.super Ljava/lang/Object;
.source "BindingConnection.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/avod/sdk/internal/BindingConnection;->disconnect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;


# direct methods
.method constructor <init>(Lcom/amazon/avod/sdk/internal/BindingConnection;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/BindingConnection$1;->this$0:Lcom/amazon/avod/sdk/internal/BindingConnection;

    # getter for: Lcom/amazon/avod/sdk/internal/BindingConnection;->mServiceConnection:Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;
    invoke-static {v0}, Lcom/amazon/avod/sdk/internal/BindingConnection;->access$000(Lcom/amazon/avod/sdk/internal/BindingConnection;)Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/avod/sdk/internal/BlockingBindingConnection;->unbind()V

    .line 93
    return-void
.end method
