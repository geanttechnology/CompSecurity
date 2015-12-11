.class Lcom/amazon/mShop/control/smile/SmileController$1;
.super Ljava/lang/Object;
.source "SmileController.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/smile/SmileController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/smile/SmileController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/smile/SmileController;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/control/smile/SmileController$1;->this$0:Lcom/amazon/mShop/control/smile/SmileController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 25
    return-void
.end method
