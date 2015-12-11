.class Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;
.super Ljava/lang/Object;
.source "SingleClientConnManager.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->requestConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;

.field final synthetic val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

.field final synthetic val$state:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;

    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->val$state:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getConnection(JLjava/util/concurrent/TimeUnit;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .locals 3
    .param p1, "timeout"    # J
    .param p3, "tunit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 190
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->this$0:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->val$route:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;->val$state:Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->getConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    move-result-object v0

    return-object v0
.end method
