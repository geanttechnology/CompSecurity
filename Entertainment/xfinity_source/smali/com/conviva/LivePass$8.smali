.class final Lcom/conviva/LivePass$8;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/conviva/LivePass;->cleanupSession(I)V
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
.field final synthetic val$sessionId:I


# direct methods
.method constructor <init>(I)V
    .locals 0

    iput p1, p0, Lcom/conviva/LivePass$8;->val$sessionId:I

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

    invoke-virtual {p0}, Lcom/conviva/LivePass$8;->call()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/Void;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    # getter for: Lcom/conviva/LivePass;->_sessionFactory:Lcom/conviva/session/SessionFactory;
    invoke-static {}, Lcom/conviva/LivePass;->access$400()Lcom/conviva/session/SessionFactory;

    move-result-object v0

    iget v1, p0, Lcom/conviva/LivePass$8;->val$sessionId:I

    invoke-virtual {v0, v1}, Lcom/conviva/session/SessionFactory;->cleanupSession(I)V

    const/4 v0, 0x0

    return-object v0
.end method
