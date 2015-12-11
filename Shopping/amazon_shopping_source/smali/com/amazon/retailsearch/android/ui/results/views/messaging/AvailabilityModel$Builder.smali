.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;
.super Ljava/lang/Object;
.source "AvailabilityModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Availability;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .locals 2
    .param p1, "availabilityInfo"    # Lcom/amazon/searchapp/retailsearch/model/Availability;

    .prologue
    .line 79
    if-nez p1, :cond_0

    .line 81
    const/4 v0, 0x0

    .line 89
    :goto_0
    return-object v0

    .line 84
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;-><init>()V

    .line 86
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Availability;->getLowStockMessage()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->setLowStockMessage(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Ljava/lang/String;)V

    .line 87
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Availability;->getGeneralAvailability()Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->setGeneralMessage(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Ljava/lang/String;)V

    goto :goto_0
.end method
