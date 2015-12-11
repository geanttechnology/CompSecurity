.class public Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory$ModalOpenHandlerFactory;
.super Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;
.source "MASHNavHandlerFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ModalOpenHandlerFactory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 111
    invoke-direct {p0}, Lcom/amazon/mobile/mash/nav/MASHNavHandlerFactory;-><init>()V

    return-void
.end method


# virtual methods
.method public createOperationHandler(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)Lcom/amazon/mobile/mash/nav/MASHNavHandler;
    .locals 1
    .param p1, "plugin"    # Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;
    .param p3, "currentIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mobile/mash/nav/MASHNavOperation;",
            ">;I)",
            "Lcom/amazon/mobile/mash/nav/MASHNavHandler;"
        }
    .end annotation

    .prologue
    .line 118
    .local p2, "operationList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mobile/mash/nav/MASHNavOperation;>;"
    new-instance v0, Lcom/amazon/mobile/mash/nav/MASHNavModalOpenHandler;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/mobile/mash/nav/MASHNavModalOpenHandler;-><init>(Lcom/amazon/mobile/mash/api/MASHNavigationPlugin;Ljava/util/List;I)V

    return-object v0
.end method
