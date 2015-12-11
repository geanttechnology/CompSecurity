.class final Lcom/conviva/LivePass$3;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/LivePass;->createSessionWorker(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;Z)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$contentInfo:Lcom/conviva/ConvivaContentInfo;

.field final synthetic val$global:Z

.field final synthetic val$sessionOptions:Ljava/util/Map;

.field final synthetic val$sid:I

.field final synthetic val$streamer:Ljava/lang/Object;


# direct methods
.method constructor <init>(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;IZ)V
    .locals 0

    iput-object p1, p0, Lcom/conviva/LivePass$3;->val$streamer:Ljava/lang/Object;

    iput-object p2, p0, Lcom/conviva/LivePass$3;->val$contentInfo:Lcom/conviva/ConvivaContentInfo;

    iput-object p3, p0, Lcom/conviva/LivePass$3;->val$sessionOptions:Ljava/util/Map;

    iput p4, p0, Lcom/conviva/LivePass$3;->val$sid:I

    iput-boolean p5, p0, Lcom/conviva/LivePass$3;->val$global:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/conviva/LivePass$3;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    # getter for: Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;
    invoke-static {}, Lcom/conviva/LivePass;->access$400()Lcom/conviva/session/SessionFactory;

    move-result-object v0

    iget-object v1, p0, Lcom/conviva/LivePass$3;->val$streamer:Ljava/lang/Object;

    iget-object v2, p0, Lcom/conviva/LivePass$3;->val$contentInfo:Lcom/conviva/ConvivaContentInfo;

    iget-object v3, p0, Lcom/conviva/LivePass$3;->val$sessionOptions:Ljava/util/Map;

    iget v4, p0, Lcom/conviva/LivePass$3;->val$sid:I

    iget-boolean v5, p0, Lcom/conviva/LivePass$3;->val$global:Z

    invoke-virtual/range {v0 .. v5}, Lcom/conviva/session/SessionFactory;->makeSession(Ljava/lang/Object;Lcom/conviva/ConvivaContentInfo;Ljava/util/Map;IZ)Lcom/conviva/session/Session;

    # getter for: Lcom/conviva/LivePass;->_utils:Lcom/conviva/utils/PlatformUtils;
    invoke-static {}, Lcom/conviva/LivePass;->access$300()Lcom/conviva/utils/PlatformUtils;

    move-result-object v0

    const-string v1, "LivePass Session Created"

    invoke-virtual {v0, v1}, Lcom/conviva/utils/PlatformUtils;->log(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method
