.class Lcom/amazon/mShop/feature/Features$1$2;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/Features$1;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/feature/Features$1;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features$1;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 484
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$1$2;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iput-object p2, p0, Lcom/amazon/mShop/feature/Features$1$2;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 487
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$1$2;->this$1:Lcom/amazon/mShop/feature/Features$1;

    iget-object v0, v0, Lcom/amazon/mShop/feature/Features$1;->this$0:Lcom/amazon/mShop/feature/Features;

    iget-object v1, p0, Lcom/amazon/mShop/feature/Features$1$2;->val$e:Ljava/lang/Exception;

    # invokes: Lcom/amazon/mShop/feature/Features;->notifyError(Ljava/lang/Exception;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/feature/Features;->access$200(Lcom/amazon/mShop/feature/Features;Ljava/lang/Exception;)V

    .line 488
    return-void
.end method
