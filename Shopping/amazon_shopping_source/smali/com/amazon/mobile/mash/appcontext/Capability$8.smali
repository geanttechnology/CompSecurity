.class final enum Lcom/amazon/mobile/mash/appcontext/Capability$8;
.super Lcom/amazon/mobile/mash/appcontext/Capability;
.source "Capability.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/appcontext/Capability;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p3, "x0"    # I

    .prologue
    .line 83
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mobile/mash/appcontext/Capability;-><init>(Ljava/lang/String;IILcom/amazon/mobile/mash/appcontext/Capability$1;)V

    return-void
.end method


# virtual methods
.method protected initAvailability(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V
    .locals 1
    .param p1, "manager"    # Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    .prologue
    .line 86
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;->isAvailableShowAdsBrowser()Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/mobile/mash/appcontext/Capability$8;->setIsAvailable(Z)V

    .line 87
    return-void
.end method
