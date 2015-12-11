.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
.super Ljava/lang/Object;
.source "AvailabilityModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel$Builder;
    }
.end annotation


# instance fields
.field private generalMessage:Ljava/lang/String;

.field private lowStockMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->setLowStockMessage(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->setGeneralMessage(Ljava/lang/String;)V

    return-void
.end method

.method private setGeneralMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "generalMessage"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->generalMessage:Ljava/lang/String;

    .line 53
    return-void
.end method

.method private setLowStockMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "lowStockMessage"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->lowStockMessage:Ljava/lang/String;

    .line 37
    return-void
.end method


# virtual methods
.method public getGeneralMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->generalMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getLowStockMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->lowStockMessage:Ljava/lang/String;

    return-object v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->generalMessage:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/AvailabilityModel;->lowStockMessage:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
